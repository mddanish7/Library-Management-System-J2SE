import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Login extends JFrame {
	static Login frame;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JButton btnSignup;
	private JButton btnForgotPassword;
	private JLabel lblTroubleLogin;
	private JLabel label;
	private JLabel label_1;
	private JPanel panel;
	
	
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	private JLabel label_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for(LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
						UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
					
					
					}
					Login frame = new Login();
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
	public Login() {
		super("Login");
		con=DB.getConnection();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 423);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBounds(173, 11, 401, 368);
		panel.setBackground(Color.WHITE);
		panel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(175, 238, 238), 4, true), "Login", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 0)));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(76, 106, 123, 17);
		lblPassword.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(72, 34, 127, 17);
		lblUsername.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		
		textField = new JTextField();
		textField.setBounds(76, 62, 271, 33);
		textField.setBackground(new Color(173, 216, 230));
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(76, 134, 271, 36);
		passwordField.setBackground(new Color(173, 216, 230));
		
		label = new JLabel("");
		label.setBounds(365, 62, 24, 24);
		label.setIcon(new ImageIcon(getClass().getResource("/resource/User.png")));
		
		label_1 = new JLabel("");
		label_1.setBounds(365, 145, 24, 24);
		label_1.setIcon(new ImageIcon(getClass().getResource("/resource/Password.png")));
		
		
		//LOGIN button code...
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(76, 198, 133, 33);
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBackground(new Color(0, 128, 128));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query="select * from account where Username=? and Password=?";
				try {
					ps=con.prepareStatement(query);
					ps.setString(1, textField.getText());
					ps.setString(2, passwordField.getText());
					rs=ps.executeQuery();
					if (rs.next()) {
						
						
						setVisible(false);
						load ob=new load();
						
						ob.setUpLoading();
						ob.setVisible(true);
						
						
					} else {
							JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
					}
				} catch (Exception e) {
					JOptionPane.showConfirmDialog(null, e);
				}finally {
					try {
						rs.close();
						ps.close();
					} catch (Exception e) {
						JOptionPane.showConfirmDialog(null, e);
					}
				}
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setIcon(new ImageIcon(getClass().getResource("/resource/Login.png")));
		
		
		//signUp button will take to Signup page
		
		btnSignup = new JButton("SignUp");
		btnSignup.setBounds(219, 198, 128, 33);
		btnSignup.setBackground(new Color(0, 139, 139));
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				SignUp ob= new SignUp();
				ob.setVisible(true);
				
			}
		});
		btnSignup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSignup.setIcon(new ImageIcon(getClass().getResource("/resource/new-icon.png")));
		
		btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.setBounds(137, 268, 159, 33);
		btnForgotPassword.setBackground(new Color(0, 191, 255));
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Forgot ob= new Forgot();
				ob.setVisible(true);
			}
		});
		btnForgotPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnForgotPassword.setIcon(new ImageIcon(getClass().getResource("/resource/forgot.png")));
		
		lblTroubleLogin = new JLabel("Trouble Login...");
		lblTroubleLogin.setBounds(10, 272, 107, 22);
		lblTroubleLogin.setFont(new Font("Informal Roman", Font.BOLD, 17));
		lblTroubleLogin.setForeground(new Color(255, 0, 0));
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblPassword, lblUsername, textField, passwordField, label, label_1, btnLogin, btnSignup, btnForgotPassword, lblTroubleLogin}));
		contentPane.setLayout(null);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(lblTroubleLogin);
		panel.add(btnForgotPassword);
		panel.add(textField);
		panel.add(lblUsername);
		panel.add(passwordField);
		panel.add(lblPassword);
		panel.add(btnLogin);
		panel.add(btnSignup);
		panel.add(label_1);
		panel.add(label);
		
		label_2 = new JLabel("");
		label_2.setBounds(-94, -49, 508, 436);
		panel.add(label_2);
		label_2.setIcon(new ImageIcon(getClass().getResource("/resource/860_main_library_bacteria.png")));
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Login.class.getResource("/resource/nat2 (3).jpg")));
		label_3.setBounds(0, 0, 673, 402);
		contentPane.add(label_3);
		setLocationRelativeTo(null);
	}
}
