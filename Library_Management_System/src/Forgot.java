import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Forgot extends JFrame {

	static Forgot frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	Connection con;
	ResultSet rs;
	PreparedStatement ps;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forgot frame = new Forgot();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void search() {
		
		String us=textField.getText();
		String query="select * from account where Username='"+us+"'";
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			
			if (rs.next()) {
				textField_1.setText(rs.getString(3));
				textField_2.setText(rs.getString(5));
				
			} else {
				JOptionPane.showMessageDialog(null, "Incorrect Username");
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}  
	
	public void retrive() {
		String us= textField.getText();
		String ans=textField_3.getText();
		String query="select * from account where answer ='"+ans+"'";
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			if (rs.next()) {
				textField_4.setText(rs.getString(4));
				JOptionPane.showMessageDialog(null,"Note your Password !");
				
			} else {
				JOptionPane.showMessageDialog(null, "Wrong Answer...Try Again!!!");
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
	
	

	/**
	 * Create the frame.
	 */
	public Forgot() {
		super("Forgot Password");
		con=DB.getConnection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(151, 58, 543, 210);
		panel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(135, 206, 250), 3, true), "Forgot Password", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(127, 255, 0)));
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setBackground(new Color(255, 255, 255));
		lblUsername.setBounds(17, 30, 65, 19);
		lblUsername.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setBackground(new Color(255, 255, 255));
		lblName.setBounds(17, 63, 36, 19);
		lblName.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		JLabel lblYourSecurityQuestion = new JLabel("Your Security Question");
		lblYourSecurityQuestion.setForeground(new Color(255, 255, 255));
		lblYourSecurityQuestion.setBackground(new Color(255, 255, 255));
		lblYourSecurityQuestion.setBounds(17, 95, 146, 19);
		lblYourSecurityQuestion.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setForeground(new Color(255, 255, 255));
		lblAnswer.setBackground(new Color(255, 255, 255));
		lblAnswer.setBounds(17, 125, 46, 19);
		lblAnswer.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		JLabel lblYourPassword = new JLabel("Your Password");
		lblYourPassword.setForeground(new Color(255, 255, 255));
		lblYourPassword.setBackground(new Color(255, 255, 255));
		lblYourPassword.setBounds(17, 161, 95, 19);
		lblYourPassword.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setBounds(193, 31, 226, 20);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(193, 64, 226, 20);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(193, 96, 226, 20);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(193, 126, 111, 20);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(193, 162, 226, 20);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		
		//Search() method called on search button 
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(0, 206, 209));
		btnSearch.setBounds(429, 27, 95, 25);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search();
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.setIcon(new ImageIcon(getClass().getResource("/resource/search-icon.png")));
		
		
		
		//Retrive() method called on retrive button 
		JButton btnRetrive = new JButton("Retrive");
		btnRetrive.setBackground(new Color(0, 206, 209));
		btnRetrive.setBounds(429, 122, 95, 25);
		btnRetrive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				retrive();
			}
		});
		btnRetrive.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRetrive.setIcon(new ImageIcon(getClass().getResource("/resource/retrive.png")));
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(0, 206, 209));
		btnBack.setBounds(429, 158, 95, 25);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Login ob= new Login();
				ob.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setIcon(new ImageIcon(getClass().getResource("/resource/Back-icon.png")));
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(lblUsername);
		panel.add(lblName);
		panel.add(lblYourSecurityQuestion);
		panel.add(lblAnswer);
		panel.add(lblYourPassword);
		panel.add(textField_3);
		panel.add(textField_2);
		panel.add(textField_1);
		panel.add(textField);
		panel.add(textField_4);
		panel.add(btnSearch);
		panel.add(btnRetrive);
		panel.add(btnBack);
		
		JLabel lblForgotPassword = new JLabel("Forgot Password");
		lblForgotPassword.setForeground(new Color(255, 255, 255));
		lblForgotPassword.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblForgotPassword.setBounds(0, 0, 126, 19);
		panel.add(lblForgotPassword);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Forgot.class.getResource("/resource/nat2 (3).jpg")));
		label_1.setBounds(0, 0, 543, 210);
		panel.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Forgot.class.getResource("/resource/8314929977_28fd740070_b.jpg")));
		label.setBounds(0, 0, 800, 368);
		contentPane.add(label);
		setLocationRelativeTo(null);
	}

}
