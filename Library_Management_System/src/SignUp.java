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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.sql.*;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
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
					SignUp frame = new SignUp();
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
	public SignUp() {
		super("Sign up");
		
		con=DB.getConnection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(170, 29, 402, 298);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(175, 238, 238), 3, true), "New Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(124, 252, 0)));
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setBounds(34, 73, 130, 17);
		lblName.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setBounds(34, 35, 130, 17);
		lblUsername.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBounds(34, 114, 130, 17);
		lblPassword.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		JLabel lblSecurityQuestion = new JLabel("Security Question");
		lblSecurityQuestion.setForeground(new Color(255, 255, 255));
		lblSecurityQuestion.setBounds(34, 142, 130, 17);
		lblSecurityQuestion.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setForeground(new Color(255, 255, 255));
		lblAnswer.setBounds(34, 180, 130, 17);
		lblAnswer.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setBounds(178, 35, 194, 20);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(178, 73, 194, 20);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(178, 111, 194, 20);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(178, 180, 194, 20);
		textField_4.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(178, 142, 194, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"What is your Nick name?", "What is your mother tongue?", "Who is your First Childhood Friend?", "What is your school name?"}));
		
		
		//action to 'create' button
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBackground(new Color(0, 206, 209));
		btnCreate.setBounds(132, 233, 93, 25);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="insert into Account values (?,?,?,?,?,?)" ;
					ps=con.prepareStatement(query);
					String tusername=textField.getText();
					String tname=textField_1.getText();
					String tpassword=textField_2.getText();
					String tanswer=textField_4.getText();
					String cseq_q=(String) comboBox.getSelectedItem();
					
					
					
					ps.setString(1,"0");
					ps.setString(2,tusername );
					ps.setString(3,tname );
					ps.setString(4,tpassword );
					ps.setString(5,cseq_q );
					ps.setString(6,tanswer );
					
					
					
				
					ps.execute();
					JOptionPane.showMessageDialog(null,"New account Created" );
					
					
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnCreate.setIcon(new ImageIcon(getClass().getResource("/resource/Add-user-icon.png")));
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		//back button takes to login page again
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(0, 206, 209));
		btnBack.setBounds(279, 233, 93, 25);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Login ob= new Login();
				ob.setVisible(true);
				
			}
		});
		contentPane.setLayout(null);
		btnBack.setIcon(new ImageIcon(getClass().getResource("/resource/Back-icon.png")));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(lblPassword);
		panel.add(lblSecurityQuestion);
		panel.add(lblAnswer);
		panel.add(lblName);
		panel.add(lblUsername);
		panel.add(btnCreate);
		panel.add(textField);
		panel.add(textField_1);
		panel.add(textField_2);
		panel.add(textField_4);
		panel.add(comboBox);
		panel.add(btnBack);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setForeground(new Color(255, 255, 255));
		lblSignUp.setBackground(new Color(255, 255, 255));
		lblSignUp.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblSignUp.setBounds(0, 0, 83, 24);
		panel.add(lblSignUp);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SignUp.class.getResource("/resource/nat2 (3).jpg")));
		label_1.setBounds(0, 0, 402, 298);
		panel.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SignUp.class.getResource("/resource/8314929977_28fd740070_b.jpg")));
		label.setBounds(0, 0, 795, 380);
		contentPane.add(label);
		setLocationRelativeTo(null);
	}
}
