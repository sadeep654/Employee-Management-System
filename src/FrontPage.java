import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class FrontPage {

	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1img;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textFieldid;
	private JPasswordField passwordFieldpw;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontPage window = new FrontPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrontPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1323, 775);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1305, 728);
		frame.getContentPane().add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("Welcome", null, panel, null);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Employee Management System");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNewLabel.setBounds(338, 13, 636, 127);
		panel.add(lblNewLabel);
		
		lblNewLabel_1img = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("the-png-project-5.png")).getImage();
		lblNewLabel_1img.setIcon(new ImageIcon(img));
		lblNewLabel_1img.setBounds(357, 131, 931, 531);
		panel.add(lblNewLabel_1img);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Login", null, panel_1, null);
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel_1.setBounds(537, 0, 103, 87);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("lock1.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img1));
		lblNewLabel_2.setBounds(493, 100, 265, 257);
		panel_1.add(lblNewLabel_2);
		
		textFieldid = new JTextField();
		textFieldid.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		textFieldid.setBounds(636, 393, 195, 55);
		panel_1.add(textFieldid);
		textFieldid.setColumns(10);
		
		passwordFieldpw = new JPasswordField();
		passwordFieldpw.setEchoChar('*');
		passwordFieldpw.setFont(new Font("Tahoma", Font.PLAIN, 22));
		passwordFieldpw.setBounds(636, 472, 195, 55);
		panel_1.add(passwordFieldpw);
		
		lblNewLabel_3 = new JLabel("Employee ID");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_3.setBounds(397, 392, 206, 55);
		panel_1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_4.setBounds(397, 476, 205, 44);
		panel_1.add(lblNewLabel_4);
		
		btnNewButton = new JButton("Login as an admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					Statement stmt =con.createStatement();
					String sql = "Select * from admin_login where A_id ='"+textFieldid.getText()+"' and A_pw ='"+passwordFieldpw.getText().toString()+"'";
					
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"Login Seccessfully");
						
						frame.dispose();
						Admin adm = new Admin();
						adm.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Incorrect login credentials");
					}
					con.close();
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton.setBounds(331, 590, 234, 34);
		panel_1.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Login as an  user");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					Statement stmt =con.createStatement();
					String sql = "Select * from user_login where U_id ='"+textFieldid.getText()+"' and U_pw ='"+passwordFieldpw.getText().toString()+"'";
					
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"Login Seccessfully");
						
						frame.dispose();
						User adm = new User();
						adm.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Incorrect login credentials");
					}
					con.close();
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton_1.setBounds(690, 590, 240, 34);
		panel_1.add(btnNewButton_1);
		
	}
}
