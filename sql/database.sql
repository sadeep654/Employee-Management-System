-- init_database.sql
-- PostgreSQL schema for Java Admin/User Management application
-- Requires: PostgreSQL 9.5+ (pgcrypto extension for bcrypt password hashing)

-- 1) Enable pgcrypto for password hashing (bcrypt)
CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- 2) Create schema (optional)
CREATE SCHEMA IF NOT EXISTS app;

-- 3) Roles table (list of possible roles)
CREATE TABLE app.roles (
  role_id    SERIAL PRIMARY KEY,
  role_name  VARCHAR(50) NOT NULL UNIQUE,
  description TEXT
);

-- 4) Users table
CREATE TABLE app.users (
  user_id       BIGSERIAL PRIMARY KEY,
  username      VARCHAR(100) NOT NULL UNIQUE,
  email         VARCHAR(255) UNIQUE,
  password_hash TEXT NOT NULL,              -- bcrypt/crypt hash
  display_name  VARCHAR(255),
  is_active     BOOLEAN NOT NULL DEFAULT true,
  created_at    TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
  updated_at    TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
  last_login_at TIMESTAMP WITH TIME ZONE
);

-- Trigger to update updated_at on row change
CREATE OR REPLACE FUNCTION app.update_updated_at()
RETURNS TRIGGER AS $$
BEGIN
  NEW.updated_at = now();
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_users_updated_at
BEFORE UPDATE ON app.users
FOR EACH ROW
EXECUTE PROCEDURE app.update_updated_at();

-- 5) Mapping table: user_roles (many-to-many)
CREATE TABLE app.user_roles (
  user_role_id SERIAL PRIMARY KEY,
  user_id BIGINT NOT NULL REFERENCES app.users(user_id) ON DELETE CASCADE,
  role_id INT NOT NULL REFERENCES app.roles(role_id) ON DELETE CASCADE,
  assigned_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
  UNIQUE(user_id, role_id)
);

-- 6) Sessions (optional simple session store)
CREATE TABLE app.sessions (
  session_id    UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  user_id       BIGINT NOT NULL REFERENCES app.users(user_id) ON DELETE CASCADE,
  created_at    TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
  expires_at    TIMESTAMP WITH TIME ZONE,
  user_agent    TEXT,
  ip_address    TEXT
);

-- 7) Audit/log table
CREATE TABLE app.audit_logs (
  log_id      BIGSERIAL PRIMARY KEY,
  user_id     BIGINT REFERENCES app.users(user_id),
  action      VARCHAR(200) NOT NULL,
  details     TEXT,
  created_at  TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now()
);

-- 8) Application settings (key-value)
CREATE TABLE app.settings (
  key_name    VARCHAR(100) PRIMARY KEY,
  key_value   TEXT,
  updated_at  TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now()
);

-- Trigger to update settings.updated_at
CREATE OR REPLACE FUNCTION app.update_settings_ts()
RETURNS TRIGGER AS $$
BEGIN
  NEW.updated_at = now();
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_settings_updated_at
BEFORE UPDATE ON app.settings
FOR EACH ROW
EXECUTE PROCEDURE app.update_settings_ts();

-- 9) Helpful indexes
CREATE INDEX IF NOT EXISTS idx_users_username ON app.users(username);
CREATE INDEX IF NOT EXISTS idx_users_email ON app.users(email);
CREATE INDEX IF NOT EXISTS idx_audit_logs_user_id ON app.audit_logs(user_id);

-- ---------------------------------------------------------
-- 10) Seed roles and example accounts
--    - If you prefer a different admin password, replace 'admin123' below.
--    - We use bcrypt via crypt() and gen_salt('bf') (pgcrypto)
-- ---------------------------------------------------------

-- Insert standard roles
INSERT INTO app.roles (role_name, description)
VALUES
  ('ROLE_ADMIN', 'Administrator with full privileges'),
  ('ROLE_USER',  'Regular user with limited privileges')
ON CONFLICT (role_name) DO NOTHING;

-- Create a sample admin user (username: admin)
-- WARNING: change the password before production use
DO $$
BEGIN
  IF NOT EXISTS (SELECT 1 FROM app.users WHERE username = 'admin') THEN
    INSERT INTO app.users (username, email, password_hash, display_name, is_active)
    VALUES (
      'admin',
      'admin@example.com',
      crypt('admin123', gen_salt('bf')), -- bcrypt hash of 'admin123'
      'Administrator',
      true
    );
    -- assign admin role
    INSERT INTO app.user_roles (user_id, role_id)
    SELECT u.user_id, r.role_id
    FROM app.users u, app.roles r
    WHERE u.username = 'admin' AND r.role_name = 'ROLE_ADMIN';
  END IF;
END$$;

-- Create a sample regular user (username: demo)
DO $$
BEGIN
  IF NOT EXISTS (SELECT 1 FROM app.users WHERE username = 'demo') THEN
    INSERT INTO app.users (username, email, password_hash, display_name, is_active)
    VALUES (
      'demo',
      'demo@example.com',
      crypt('demo123', gen_salt('bf')), -- bcrypt hash of 'demo123'
      'Demo User',
      true
    );
    -- assign user role
    INSERT INTO app.user_roles (user_id, role_id)
    SELECT u.user_id, r.role_id
    FROM app.users u, app.roles r
    WHERE u.username = 'demo' AND r.role_name = 'ROLE_USER';
  END IF;
END$$;

-- 11) Example settings (optional)
INSERT INTO app.settings (key_name, key_value)
VALUES
  ('app.name', 'Java Management System'),
  ('app.session_timeout_minutes', '60')
ON CONFLICT (key_name) DO UPDATE SET key_value = EXCLUDED.key_value;

-- 12) Test audit insert (optional)
INSERT INTO app.audit_logs (user_id, action, details)
SELECT user_id, 'seed:init', 'Initial DB seed completed'
FROM app.users
WHERE username = 'admin'
LIMIT 1;
