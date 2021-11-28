import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class User extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTable table_1;
	private JTextField textField_2BSal;
	private JTextField textField_3ORate;
	private JTextField textField_4OHrs;
	private JTextField textField_5MSal;
	private JTextField textField_2;
	private JTextField textField_3uID;
	private JTextField textField_4uPW;
	private JTable table_2;
	
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
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
	
	public User() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1321, 756);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1304, 713);
		contentPane.add(tabbedPane);
		Image img1 = new ImageIcon(this.getClass().getResource("dialog.png")).getImage();
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("User Details", null, panel, null);
		panel.setLayout(null);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"U_id", "U_name"}));
		comboBox_3.setBounds(728, 189, 163, 55);
		panel.add(comboBox_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					String selection = (String)comboBox_3.getSelectedItem();
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					String sql ="Select * from user_details where  "+selection+"=?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,textField.getText());
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					
					pst.close();
				}catch(Exception e2)
				{
				JOptionPane.showMessageDialog(null,e2);
				}
			}
		});
		textField.setBounds(963, 190, 287, 55);
		panel.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 469, 1214, 39);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("View Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					Statement stmt =con.createStatement();
					String sql ="Select * from user_details";
					ResultSet rs = stmt.executeQuery(sql);
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 26));
		btnNewButton.setBounds(1060, 367, 190, 54);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("User Interface");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNewLabel.setBounds(525, 0, 280, 115);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(img1));
		lblNewLabel_8.setBounds(151, 76, 269, 310);
		panel.add(lblNewLabel_8);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Login Details", null, panel_2, null);
		panel_2.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					String selection = (String)comboBox_2.getSelectedItem();
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					String sql ="Select * from user_login where  "+selection+"=?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,textField_2.getText());
					ResultSet rs = pst.executeQuery();
					
					table_2.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					
					pst.close();
				}catch(Exception e2)
				{
				JOptionPane.showMessageDialog(null,e2);
				}
			}
		});
		textField_2.setBounds(953, 85, 256, 55);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
	    comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"U_id"}));
		comboBox_2.setBounds(724, 85, 163, 55);
		panel_2.add(comboBox_2);
		
		textField_3uID = new JTextField();
		textField_3uID.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_3uID.setBounds(326, 304, 178, 44);
		panel_2.add(textField_3uID);
		textField_3uID.setColumns(10);
		
		textField_4uPW = new JTextField();
		textField_4uPW.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_4uPW.setBounds(326, 379, 178, 44);
		panel_2.add(textField_4uPW);
		textField_4uPW.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("User ID");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_6.setBounds(106, 304, 163, 44);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Password");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_7.setBounds(106, 374, 163, 44);
		panel_2.add(lblNewLabel_7);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(579, 320, 635, 39);
		panel_2.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		JButton btnNewButton_3 = new JButton("View Data");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					Statement stmt =con.createStatement();
					String sql ="Select U_id, U_pw from user_login";
					ResultSet rs = stmt.executeQuery(sql);
					
					table_2.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_3.setBounds(1049, 394, 167, 43);
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Update ");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					
					String query = "Update user_login set U_id = '"+textField_3uID.getText()+"' , U_pw = '"+ textField_4uPW.getText()+"'where U_id ='"+textField_3uID.getText() +"'";
					
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
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_4.setBounds(326, 466, 178, 43);
		panel_2.add(btnNewButton_4);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Salary Details", null, panel_1, null);
		panel_1.setLayout(null);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"U_id"}));
		comboBox_1.setBounds(724, 85, 163, 55);
		panel_1.add(comboBox_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					String selection = (String)comboBox_1.getSelectedItem();
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					String sql ="Select U_id,Month,Basic,OT_rate,OT_hrs from user_salary where  "+selection+"=?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,textField_1 .getText());
					ResultSet rs = pst.executeQuery();
					
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					
					pst.close();
				}catch(Exception e2)
				{
				JOptionPane.showMessageDialog(null,e2);
				}
			}
		});
		textField_1.setBounds(938, 85, 256, 55);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(497, 343, 767, 39);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton_1 = new JButton("View Data");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useTimezone=true&serverTimezone=UTC","root","");
					Statement stmt =con.createStatement();
					String sql ="Select U_id,Month,Basic,OT_rate,OT_hrs from user_salary";
					ResultSet rs = stmt.executeQuery(sql);
					
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_1.setBounds(1097, 408, 167, 43);
		panel_1.add(btnNewButton_1);
		
		textField_2BSal = new JTextField();
		textField_2BSal.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_2BSal.setBounds(278, 274, 178, 43);
		panel_1.add(textField_2BSal);
		textField_2BSal.setColumns(10);
		
		textField_3ORate = new JTextField();
		textField_3ORate.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_3ORate.setBounds(278, 339, 178, 43);
		panel_1.add(textField_3ORate);
		textField_3ORate.setColumns(10);
		
		textField_4OHrs = new JTextField();
		textField_4OHrs.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_4OHrs.setBounds(278, 408, 178, 43);
		panel_1.add(textField_4OHrs);
		textField_4OHrs.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Salary Calculator");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblNewLabel_1.setBounds(91, 175, 271, 72);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Basic Salary");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_2.setBounds(25, 273, 178, 43);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("OT Rate");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_3.setBounds(25, 339, 178, 42);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("OT Hours");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_4.setBounds(25, 406, 179, 43);
		panel_1.add(lblNewLabel_4);
		
		textField_5MSal = new JTextField();
		textField_5MSal.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		textField_5MSal.setBounds(278, 495, 178, 43);
		panel_1.add(textField_5MSal);
		textField_5MSal.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Monthly Salary (Rs.)");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_5.setBounds(25, 494, 241, 43);
		panel_1.add(lblNewLabel_5);
		
		JButton btnNewButton_2 = new JButton("Calculate Salary");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float bSal,oT_Rate,oT_Hrs;
				String mSalary;
				try {
					bSal = Float.parseFloat(textField_2BSal.getText());
					oT_Rate = Float.parseFloat(textField_3ORate.getText());
					oT_Hrs = Float.parseFloat(textField_4OHrs.getText());
					
					mSalary = new DecimalFormat("0.00").format(bSal + (oT_Rate * oT_Hrs)) ;
					
					textField_5MSal.setText(mSalary);
					
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Enter correct values");
				}
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton_2.setBounds(245, 576, 211, 43);
		panel_1.add(btnNewButton_2);
		
		
	}
}
