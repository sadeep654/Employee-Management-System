import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSearch1;
	private JTable table;
	private JTextField textFieldid;
	private JTextField textField_1name;
	private JTextField textField_2gender;
	private JTextField textField_3age;
	private JTextField textField_4city;
	private JTextField textField_5email;
	private JTextField textField_6mobile;
	private JTextField textField_7prof;
	private JTextField textField_8dep;
	
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JTextField textFieldsearch2;
	private JTable table_2;
	private JTextField textField_1Aid;
	private JTextField textField_2Aname;
	private JTextField textField_3Aemail;
	private JTextField textField_4Amob;
	private JTextField textField_1;
	private JTable table_3;
	private JTextField textField_2uid;
	private JTextField textField_3pw;
	private JTextField textField_2;
	private JTable table_4;
	private JTextField textField_3aid;
	private JTextField textField_4pw;
	
	private JComboBox comboBoxSearch1;
	private JComboBox comboBox_1search;
	private JComboBox comboBox_2;
	private JComboBox comboBox_5;
	
	private JTextField textField_3;
	private JTable table_5;
	private JTextField textField_5aid;
	private JTextField textField_6month;
	private JTextField textField_7bsal;
	private JTextField textField_8orate;
	private JTextField textField_10ohrs;
	private JTextField textField_11;
	private JTable table_6;
	private JTable table_7;
	private JTextField textField_4aid;
	private JTextField textField_12uid;
	private JTextField textField_13month;
	private JTextField textField_14bsal;
	private JTextField textField_15orate;
	private JTextField textField_16ohrs;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the frame.
	 */
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1316, 753);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1297, 708);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("User Details", null, panel, null);
		panel.setLayout(null);
		
		textFieldSearch1 = new JTextField();
		textFieldSearch1.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		textFieldSearch1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try{
					String selection = (String)comboBoxSearch1.getSelectedItem();
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					String sql ="Select * from user_details where  "+selection+"=?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,textFieldSearch1.getText());
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					
					pst.close();
				}catch(Exception e)
				{
				JOptionPane.showMessageDialog(null,e);
				}

			}
		});
		textFieldSearch1.setBounds(979, 66, 287, 55);
		panel.add(textFieldSearch1);
		textFieldSearch1.setColumns(10);
		
		comboBoxSearch1 = new JComboBox();
		comboBoxSearch1.setModel(new DefaultComboBoxModel(new String[] {"U_id", "U_name"}));
		comboBoxSearch1.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		comboBoxSearch1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBoxSearch1.setBounds(778, 65, 163, 55);
		panel.add(comboBoxSearch1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(437, 149, 829, 455);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnNewButton = new JButton("View Table");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					Statement stmt =con.createStatement();
					String sql ="Select * from user_details";
					ResultSet rs = stmt.executeQuery(sql);
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception e)
				{
				JOptionPane.showMessageDialog(null,e);
				}

			}
		});
		btnNewButton.setBounds(493, 617, 163, 34);
		panel.add(btnNewButton);
		
		textFieldid = new JTextField();
		textFieldid.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textFieldid.setBounds(207, 133, 192, 44);
		panel.add(textFieldid);
		textFieldid.setColumns(10);
		
		textField_1name = new JTextField();
		textField_1name.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_1name.setBounds(207, 190, 192, 44);
		panel.add(textField_1name);
		textField_1name.setColumns(10);
		
		textField_2gender = new JTextField();
		textField_2gender.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_2gender.setBounds(207, 247, 192, 44);
		panel.add(textField_2gender);
		textField_2gender.setColumns(10);
		
		textField_3age = new JTextField();
		textField_3age.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_3age.setBounds(207, 304, 192, 44);
		panel.add(textField_3age);
		textField_3age.setColumns(10);
		
		textField_4city = new JTextField();
		textField_4city.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_4city.setBounds(207, 361, 192, 44);
		panel.add(textField_4city);
		textField_4city.setColumns(10);
		
		textField_5email = new JTextField();
		textField_5email.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_5email.setBounds(207, 418, 192, 44);
		panel.add(textField_5email);
		textField_5email.setColumns(10);
		
		textField_6mobile = new JTextField();
		textField_6mobile.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_6mobile.setBounds(207, 475, 192, 44);
		panel.add(textField_6mobile);
		textField_6mobile.setColumns(10);
		
		textField_7prof = new JTextField();
		textField_7prof.setText(" ");
		textField_7prof.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_7prof.setBounds(207, 532, 192, 44);
		panel.add(textField_7prof);
		textField_7prof.setColumns(10);
		
		textField_8dep = new JTextField();
		textField_8dep.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_8dep.setBounds(207, 592, 192, 44);
		panel.add(textField_8dep);
		textField_8dep.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setBounds(32, 133, 163, 44);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_1.setBounds(32, 188, 163, 44);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gender");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_2.setBounds(32, 245, 163, 44);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Age");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_3.setBounds(32, 307, 166, 34);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("City");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_4.setBounds(32, 359, 163, 44);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_5.setBounds(32, 416, 163, 44);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Mobile No");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_6.setBounds(32, 473, 163, 44);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Profession");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_7.setBounds(32, 530, 163, 44);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Department");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_8.setBounds(32, 590, 163, 44);
		panel.add(lblNewLabel_8);
		
	    btnNewButton_1 = new JButton("Insert");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					
					String query = "insert into  user_details (U_id, U_name,Gender,Age, U_City,U_Email,U_mobile,Profession,Department) values (?,?,?,?,?,?,?,?,?)";
					
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1,textFieldid.getText());
					pst.setString(2,textField_1name.getText() );
					pst.setString(3,textField_2gender.getText());
					pst.setString(4, textField_3age.getText());
					pst.setString(5, textField_4city.getText());
					pst.setString(6, textField_5email.getText());
					pst.setString(7, textField_6mobile.getText());
					pst.setString(8, textField_7prof.getText());
					pst.setString(9, textField_8dep.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Data saved");
					
					con.close();
					
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_1.setBounds(695, 617, 163, 34);
		panel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					
					String query = "Update user_details set U_id = '"+textFieldid.getText()+"' , U_name = '"+ textField_1name.getText()+"' , Gender = '"+textField_2gender.getText()+"',Age = '"+textField_3age.getText()+"' ,U_City = '"+textField_4city.getText()+"',U_Email = '"+textField_5email.getText()+"',U_mobile = '"+textField_6mobile.getText()+"',Profession = '"+textField_7prof.getText()+"', Department = '"+textField_8dep.getText()+"' where U_id ='"+textFieldid.getText() +"'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Data Updated");
					
					con.close();
					
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
			
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_2.setBounds(898, 617, 163, 34);
		panel.add(btnNewButton_2);
		
	    btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null,"Do yo really want to delete?","                    Warning !",JOptionPane.YES_NO_OPTION);
				if(action ==0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					
					String query = "delete from user_details where U_id = '"+textFieldid.getText() +"' ";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Data Deleted");
					
					con.close();
					
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
				
				}
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_3.setBounds(1100, 617, 152, 34);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_9 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("Admin-icon.png")).getImage();
		lblNewLabel_9.setIcon(new ImageIcon(img1));
		lblNewLabel_9.setBounds(12, 13, 152, 107);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Admin Interface");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNewLabel_10.setBounds(426, 13, 322, 71);
		panel.add(lblNewLabel_10);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Admin Details", null, panel_2, null);
		panel_2.setLayout(null);
		
		comboBox_1search = new JComboBox();
		comboBox_1search.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		comboBox_1search.setModel(new DefaultComboBoxModel(new String[] {"A_id", "A_name"}));
		comboBox_1search.setBounds(759, 78, 163, 55);
		panel_2.add(comboBox_1search);
		
		textFieldsearch2 = new JTextField();
		textFieldsearch2.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		textFieldsearch2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try{
					String selection = (String)comboBox_1search.getSelectedItem();
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					String sql ="Select * from admin_details where  "+selection+"=?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,textFieldsearch2 .getText());
					ResultSet rs = pst.executeQuery();
					
					table_2.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					
					pst.close();
				}catch(Exception e)
				{
				JOptionPane.showMessageDialog(null,e);
				}

			}
		});
		textFieldsearch2.setBounds(979, 79, 287, 55);
		panel_2.add(textFieldsearch2);
		textFieldsearch2.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
		});
		scrollPane_2.setBounds(559, 207, 707, 378);
		panel_2.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		textField_1Aid = new JTextField();
		textField_1Aid.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_1Aid.setBounds(315, 219, 192, 44);
		panel_2.add(textField_1Aid);
		textField_1Aid.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("Admin ID");
		lblNewLabel_16.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_16.setBounds(118, 219, 164, 44);
		panel_2.add(lblNewLabel_16);
		
		textField_2Aname = new JTextField();
		textField_2Aname.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_2Aname.setBounds(315, 294, 192, 44);
		panel_2.add(textField_2Aname);
		textField_2Aname.setColumns(10);
		
		textField_3Aemail = new JTextField();
		textField_3Aemail.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_3Aemail.setBounds(315, 364, 192, 44);
		panel_2.add(textField_3Aemail);
		textField_3Aemail.setColumns(10);
		
		textField_4Amob = new JTextField();
		textField_4Amob.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_4Amob.setBounds(315, 433, 192, 44);
		panel_2.add(textField_4Amob);
		textField_4Amob.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("Name");
		lblNewLabel_17.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_17.setBounds(118, 290, 164, 44);
		panel_2.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Email");
		lblNewLabel_18.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_18.setBounds(118, 360, 164, 44);
		panel_2.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Mobile No");
		lblNewLabel_19.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_19.setBounds(118, 437, 164, 44);
		panel_2.add(lblNewLabel_19);
		
		JButton btnNewButton_8 = new JButton("View Table");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					Statement stmt =con.createStatement();
					String sql ="Select * from admin_details";
					ResultSet rs = stmt.executeQuery(sql);
					
					table_2.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception e)
				{
				JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		btnNewButton_8.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_8.setBounds(84, 545, 163, 34);
		panel_2.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Update");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					
					String query = "Update admin_details set A_id = '"+textField_1Aid.getText()+"' , A_name = '"+ textField_2Aname.getText()+"' , A_Email = '"+textField_3Aemail.getText()+"',A_Mobile = '"+textField_4Amob.getText()+"' where A_id ='"+textField_1Aid.getText() +"'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Data Updated");
					
					con.close();
					
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnNewButton_9.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_9.setBounds(84, 592, 163, 34);
		panel_2.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("Insert");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					
					String query = "insert into  admin_details (A_id, A_name,A_Email,A_mobile ) values (?,?,?,?)";
					
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1,textField_1Aid.getText());
					pst.setString(2,textField_2Aname.getText() );
					pst.setString(3,textField_3Aemail.getText());
					pst.setString(4,textField_4Amob.getText());
					
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Data saved");
					
					con.close();
					
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnNewButton_10.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_10.setBounds(344, 545, 163, 34);
		panel_2.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("Delete");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null,"Do yo really want to delete?","                    Warning !",JOptionPane.YES_NO_OPTION);
				if(action ==0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					
					String query = "delete from admin_details where A_id = '"+textField_1Aid.getText() +"' ";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Data Deleted");
					
					con.close();
					
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
				
				}
			}
		});
		btnNewButton_11.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_11.setBounds(344, 592, 163, 34);
		panel_2.add(btnNewButton_11);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Login Details", null, panel_3, null);
		panel_3.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 0, 1313, 691);
		panel_3.add(tabbedPane_1);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("User Login Details", null, panel_4, null);
		panel_4.setLayout(null);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"U_id"}));
		comboBox_2.setBounds(759, 65, 163, 55);
		panel_4.add(comboBox_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					String selection = (String)comboBox_2.getSelectedItem();
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					String sql ="Select * from user_login where  "+selection+"=?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,textField_1 .getText());
					ResultSet rs = pst.executeQuery();
					
					table_3.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					
					pst.close();
				}catch(Exception e2)
				{
				JOptionPane.showMessageDialog(null,e2);
				}
			}
		});
		textField_1.setBounds(979, 66, 287, 55);
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(544, 150, 722, 358);
		panel_4.add(scrollPane_3);
		
		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);
		
		textField_2uid = new JTextField();
		textField_2uid.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_2uid.setBounds(287, 257, 192, 44);
		panel_4.add(textField_2uid);
		textField_2uid.setColumns(10);
		
		textField_3pw = new JTextField();
		textField_3pw.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_3pw.setBounds(287, 344, 192, 44);
		panel_4.add(textField_3pw);
		textField_3pw.setColumns(10);
		
		JLabel lblNewLabel_20 = new JLabel("User ID");
		lblNewLabel_20.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_20.setBounds(111, 257, 164, 44);
		panel_4.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("Password");
		lblNewLabel_21.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_21.setBounds(111, 344, 164, 44);
		panel_4.add(lblNewLabel_21);
		
		JButton btnNewButton_12 = new JButton("Delete");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null,"Do yo really want to delete?","                    Warning !",JOptionPane.YES_NO_OPTION);
				if(action ==0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					
					String query = "delete from user_login where U_id = '"+textField_2uid.getText() +"' ";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Data Deleted");
					
					con.close();
					
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
			
				}
			}
		});
		btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_12.setBounds(1058, 565, 163, 34);
		panel_4.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("Update");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					
					String query = "Update user_login set U_id = '"+textField_2uid.getText()+"' , U_pw = '"+ textField_3pw.getText()+"'where U_id ='"+textField_2uid.getText() +"'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Password Updated");
					
					con.close();
					
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnNewButton_13.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_13.setBounds(815, 565, 163, 34);
		panel_4.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("Insert");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					
					String query = "insert into  user_login (U_id, U_pw) values (?,?)";
					
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1,textField_2uid.getText());
					pst.setString(2,textField_3pw.getText() );
					
					
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Data saved");
					
					con.close();
					
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnNewButton_14.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_14.setBounds(580, 565, 163, 34);
		panel_4.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("View Table");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					Statement stmt =con.createStatement();
					String sql ="Select U_id, U_pw from user_login";
					ResultSet rs = stmt.executeQuery(sql);
					
					table_3.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnNewButton_15.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_15.setBounds(343, 565, 163, 34);
		panel_4.add(btnNewButton_15);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("Admin Login Details", null, panel_5, null);
		panel_5.setLayout(null);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"A_id"}));
		comboBox_3.setBounds(718, 65, 163, 55);
		panel_5.add(comboBox_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					String selection = (String)comboBox_3.getSelectedItem();
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					String sql ="Select * from admin_login where  "+selection+"=?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,textField_2  .getText());
					ResultSet rs = pst.executeQuery();
					
					table_4.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					
					pst.close();
				}catch(Exception e2)
				{
				JOptionPane.showMessageDialog(null,e2);
				}
			}
		});
		textField_2.setBounds(950, 66, 287, 55);
		panel_5.add(textField_2);
		textField_2.setColumns(10);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(548, 267, 689, 39);
		panel_5.add(scrollPane_4);
		
		table_4 = new JTable();
		scrollPane_4.setViewportView(table_4);
		
		textField_3aid = new JTextField();
		textField_3aid.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_3aid.setBounds(298, 266, 192, 44);
		panel_5.add(textField_3aid);
		textField_3aid.setColumns(10);
		
		textField_4pw = new JTextField();
		textField_4pw.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_4pw.setBounds(298, 360, 192, 44);
		panel_5.add(textField_4pw);
		textField_4pw.setColumns(10);
		
		JLabel lblNewLabel_22 = new JLabel("Admin ID");
		lblNewLabel_22.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_22.setBounds(112, 262, 164, 44);
		panel_5.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("Password");
		lblNewLabel_23.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_23.setBounds(112, 356, 164, 44);
		panel_5.add(lblNewLabel_23);
		
		JButton btnNewButton_16 = new JButton("Delete");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null,"Do yo really want to delete?","                    Warning !",JOptionPane.YES_NO_OPTION);
				if(action ==0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					
					String query = "delete from admin_login where A_id = '"+textField_3aid.getText() +"' ";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Data Deleted");
					
					con.close();
					
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
				
				}
			}
		});
		btnNewButton_16.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_16.setBounds(1070, 583, 163, 34);
		panel_5.add(btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton("Update");
		btnNewButton_17.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_17.setBounds(1070, 523, 163, 34);
		panel_5.add(btnNewButton_17);
		
		JButton btnNewButton_19 = new JButton("View Data");
		btnNewButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					Statement stmt =con.createStatement();
					String sql ="Select A_id, A_pw from admin_login";
					ResultSet rs = stmt.executeQuery(sql);
					
					table_4.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnNewButton_19.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_19.setBounds(1070, 394, 163, 34);
		panel_5.add(btnNewButton_19);
		
		JButton btnNewButton_18 = new JButton("Insert");
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					
					String query = "insert into  admin_login (A_id, A_pw) values (?,?)";
					
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1,textField_3aid.getText());
					pst.setString(2,textField_4pw.getText() );
					
					
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Data saved");
					
					con.close();
					
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnNewButton_18.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_18.setBounds(1070, 460, 163, 34);
		panel_5.add(btnNewButton_18);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Salary Details", null, panel_6, null);
		panel_6.setLayout(null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(0, 0, 1295, 686);
		panel_6.add(tabbedPane_2);
		
		JPanel panel_8 = new JPanel();
		tabbedPane_2.addTab("User Salary Details", null, panel_8, null);
		panel_8.setLayout(null);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		textField_11.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					String selection = (String)comboBox_5.getSelectedItem();
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					String sql ="Select U_id,Month,Basic,OT_rate,OT_hrs from user_salary where  "+selection+"=?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,textField_11 .getText());
					ResultSet rs = pst.executeQuery();
					
					table_7.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					
					pst.close();
				}catch(Exception e2)
				{
				JOptionPane.showMessageDialog(null,e2);
				}
			}
		});
		textField_11.setBounds(980, 50, 256, 55);
		panel_8.add(textField_11);
		textField_11.setColumns(10);
		
		comboBox_5 = new JComboBox();
		comboBox_5.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"U_id"}));
		comboBox_5.setBounds(763, 48, 163, 55);
		panel_8.add(comboBox_5);
		
		table_6 = new JTable();
		table_6.setBounds(680, 153, 1, 1);
		panel_8.add(table_6);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(512, 118, 736, 443);
		panel_8.add(scrollPane_5);
		
		table_7 = new JTable();
		scrollPane_5.setViewportView(table_7);
		
		textField_4aid = new JTextField();
		textField_4aid.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_4aid.setBounds(297, 121, 178, 44);
		panel_8.add(textField_4aid);
		textField_4aid.setColumns(10);
		
		textField_12uid = new JTextField();
		textField_12uid.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_12uid.setBounds(297, 195, 178, 44);
		panel_8.add(textField_12uid);
		textField_12uid.setColumns(10);
		
		textField_13month = new JTextField();
		textField_13month.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_13month.setBounds(297, 262, 178, 44);
		panel_8.add(textField_13month);
		textField_13month.setColumns(10);
		
		textField_14bsal = new JTextField();
		textField_14bsal.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_14bsal.setBounds(297, 335, 178, 44);
		panel_8.add(textField_14bsal);
		textField_14bsal.setColumns(10);
		
		textField_15orate = new JTextField();
		textField_15orate.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_15orate.setBounds(297, 406, 178, 44);
		panel_8.add(textField_15orate);
		textField_15orate.setColumns(10);
		
		textField_16ohrs = new JTextField();
		textField_16ohrs.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_16ohrs.setText("");
		textField_16ohrs.setBounds(297, 473, 178, 44);
		panel_8.add(textField_16ohrs);
		textField_16ohrs.setColumns(10);
		
		JLabel lblNewLabel_24 = new JLabel("Admin ID");
		lblNewLabel_24.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_24.setBounds(87, 124, 163, 44);
		panel_8.add(lblNewLabel_24);
		
		JLabel lblNewLabel_30 = new JLabel("User ID");
		lblNewLabel_30.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_30.setBounds(87, 193, 163, 44);
		panel_8.add(lblNewLabel_30);
		
		JLabel lblNewLabel_31 = new JLabel("Month");
		lblNewLabel_31.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_31.setBounds(87, 262, 163, 44);
		panel_8.add(lblNewLabel_31);
		
		JLabel lblNewLabel_32 = new JLabel("Basic Salary");
		lblNewLabel_32.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_32.setBounds(87, 335, 163, 44);
		panel_8.add(lblNewLabel_32);
		
		JLabel lblNewLabel_33 = new JLabel("OT Rate");
		lblNewLabel_33.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_33.setBounds(87, 406, 163, 44);
		panel_8.add(lblNewLabel_33);
		
		JLabel lblNewLabel_34 = new JLabel("OT Hours");
		lblNewLabel_34.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_34.setBounds(87, 473, 163, 44);
		panel_8.add(lblNewLabel_34);
		
		JButton btnNewButton_24 = new JButton("Delete");
		btnNewButton_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null,"Do yo really want to delete?","                    Warning !",JOptionPane.YES_NO_OPTION);
				if(action ==0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					
					String query = "delete from user_salary where U_id = '"+textField_12uid.getText() +"' ";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Data Deleted");
					
					con.close();
					
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
			
				}
			}
		});
		btnNewButton_24.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_24.setBounds(1085, 586, 163, 34);
		panel_8.add(btnNewButton_24);
		
		JButton btnNewButton_25 = new JButton("Update");
		btnNewButton_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					
					String query = "Update user_salary set A_id = '"+textField_4aid.getText()+"' , U_id = '"+ textField_12uid.getText()+"' , Month = '"+textField_13month.getText()+"',Basic = '"+textField_14bsal.getText()+"' ,OT_rate = '"+textField_15orate.getText()+"',OT_hrs = '"+textField_16ohrs.getText()+"'where U_id ='"+textField_12uid.getText() +"'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Data Updated");
					
					con.close();
					
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnNewButton_25.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_25.setBounds(870, 586, 163, 34);
		panel_8.add(btnNewButton_25);
		
		JButton btnNewButton_26 = new JButton("Insert");
		btnNewButton_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					
					String query = "insert into  user_salary (A_id, U_id,Month,Basic, OT_rate,OT_hrs) values (?,?,?,?,?,?)";
					
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1,textField_4aid.getText());
					pst.setString(2,textField_12uid.getText() );
					pst.setString(3,textField_13month.getText());
					pst.setString(4,textField_14bsal.getText());
					pst.setString(5,textField_15orate.getText());
					pst.setString(6,textField_16ohrs.getText());
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Data saved");
					
					con.close();
					
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}

			}
		});
		btnNewButton_26.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_26.setBounds(656, 586, 163, 34);
		panel_8.add(btnNewButton_26);
		
		JButton btnNewButton_27 = new JButton("View Table");
		btnNewButton_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					Statement stmt =con.createStatement();
					String sql ="Select U_id,Month,Basic,OT_rate,OT_hrs from user_salary";
					ResultSet rs = stmt.executeQuery(sql);
					
					table_7.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnNewButton_27.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_27.setBounds(434, 586, 163, 34);
		panel_8.add(btnNewButton_27);
		
		JPanel panel_7 = new JPanel();
		tabbedPane_2.addTab("Admin Salary Details", null, panel_7, null);
		panel_7.setLayout(null);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"A_id"}));
		comboBox_4.setBounds(780, 65, 163, 55);
		panel_7.add(comboBox_4);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try{
					String selection = (String)comboBox_4.getSelectedItem();
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					String sql ="Select A_id,Month,Basic,OT_rate,OT_hrs from admin_salary where  "+selection+"=?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,textField_3 .getText());
					ResultSet rs = pst.executeQuery();
					
					table_5.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					
					pst.close();
				}catch(Exception e2)
				{
				JOptionPane.showMessageDialog(null,e2);
				}
			}
		});
		textField_3.setBounds(979, 66, 256, 55);
		panel_7.add(textField_3);
		textField_3.setColumns(10);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(522, 252, 736, 39);
		panel_7.add(scrollPane_6);
		
		table_5 = new JTable();
		scrollPane_6.setViewportView(table_5);
		
		textField_5aid = new JTextField();
		textField_5aid.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_5aid.setBounds(296, 172, 192, 44);
		panel_7.add(textField_5aid);
		textField_5aid.setColumns(10);
		
		textField_6month = new JTextField();
		textField_6month.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_6month.setBounds(296, 247, 192, 44);
		panel_7.add(textField_6month);
		textField_6month.setColumns(10);
		
		textField_7bsal = new JTextField();
		textField_7bsal.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_7bsal.setBounds(296, 327, 192, 44);
		panel_7.add(textField_7bsal);
		textField_7bsal.setColumns(10);
		
		textField_8orate = new JTextField();
		textField_8orate.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_8orate.setBounds(296, 403, 192, 44);
		panel_7.add(textField_8orate);
		textField_8orate.setColumns(10);
		
		textField_10ohrs = new JTextField();
		textField_10ohrs.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_10ohrs.setBounds(296, 478, 192, 44);
		panel_7.add(textField_10ohrs);
		textField_10ohrs.setColumns(10);
		
		JLabel lblNewLabel_25 = new JLabel("Admin ID");
		lblNewLabel_25.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_25.setBounds(106, 170, 163, 44);
		panel_7.add(lblNewLabel_25);
		
		JLabel lblNewLabel_26 = new JLabel("Month");
		lblNewLabel_26.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_26.setBounds(106, 243, 163, 44);
		panel_7.add(lblNewLabel_26);
		
		JLabel lblNewLabel_27 = new JLabel("Basic Salary");
		lblNewLabel_27.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_27.setBounds(106, 325, 163, 44);
		panel_7.add(lblNewLabel_27);
		
		JLabel lblNewLabel_28 = new JLabel("OT Rate");
		lblNewLabel_28.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_28.setBounds(106, 401, 163, 44);
		panel_7.add(lblNewLabel_28);
		
		JLabel lblNewLabel_29 = new JLabel("OT Hours");
		lblNewLabel_29.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_29.setBounds(106, 476, 163, 44);
		panel_7.add(lblNewLabel_29);
		
		JButton btnNewButton_20 = new JButton("Delete");
		btnNewButton_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null,"Do yo really want to delete?","                    Warning !",JOptionPane.YES_NO_OPTION);
				if(action ==0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					
					String query = "delete from admin_salary where A_id = '"+textField_5aid.getText() +"' ";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Data Deleted");
					
					con.close();
					
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
			
				}
			}
		});
		btnNewButton_20.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_20.setBounds(1095, 584, 163, 34);
		panel_7.add(btnNewButton_20);
		
		JButton btnNewButton_21 = new JButton("Update");
		btnNewButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					
					String query = "Update admin_salary set A_id = '"+textField_5aid.getText()+"' ,  Month = '"+textField_6month.getText()+"',Basic = '"+textField_7bsal.getText()+"' ,OT_rate = '"+textField_8orate.getText()+"',OT_hrs = '"+textField_10ohrs.getText()+"'where A_id ='"+textField_5aid.getText() +"'";
					
					PreparedStatement pst = con.prepareStatement(query);
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Data Updated");
					
					con.close();
					
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnNewButton_21.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_21.setBounds(890, 584, 163, 34);
		panel_7.add(btnNewButton_21);
		
		JButton btnNewButton_22 = new JButton("Insert");
		btnNewButton_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					
					String query = "insert into  admin_salary (A_id,Month,Basic, OT_rate,OT_hrs) values (?,?,?,?,?)";
					
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1,textField_5aid.getText());
					pst.setString(2,textField_6month.getText() );
					pst.setString(3,textField_7bsal.getText());
					pst.setString(4,textField_8orate.getText());
					pst.setString(5,textField_10ohrs.getText());
					
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Data saved");
					
					con.close();
					
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnNewButton_22.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_22.setBounds(692, 584, 163, 34);
		panel_7.add(btnNewButton_22);
		
		JButton btnNewButton_23 = new JButton("View Data");
		btnNewButton_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					Statement stmt =con.createStatement();
					String sql ="Select A_id,Month,Basic,OT_rate,OT_hrs from admin_salary";
					ResultSet rs = stmt.executeQuery(sql);
					
					table_5.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnNewButton_23.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_23.setBounds(485, 584, 163, 34);
		panel_7.add(btnNewButton_23);
		
		
	}
}
