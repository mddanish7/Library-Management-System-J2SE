import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;

public class Student extends JFrame {

	private JPanel contentPane;
	
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
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
	public Student() {
		super("New Student");
		con=DB.getConnection();
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(235, 31, 329, 363);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 139, 139), 3, true), "New Student", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(139, 0, 0)));
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setForeground(Color.WHITE);
		lblStudentId.setBounds(17, 30, 67, 17);
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(17, 71, 35, 17);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblFatherName = new JLabel("Father's name");
		lblFatherName.setForeground(Color.WHITE);
		lblFatherName.setBounds(17, 109, 91, 17);
		lblFatherName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblCourse = new JLabel("DOB");
		lblCourse.setForeground(Color.WHITE);
		lblCourse.setBounds(17, 147, 28, 17);
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblBranch = new JLabel("Course");
		lblBranch.setForeground(Color.WHITE);
		lblBranch.setBounds(17, 182, 43, 17);
		lblBranch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setForeground(Color.WHITE);
		lblYear.setBounds(17, 220, 27, 17);
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setForeground(Color.WHITE);
		lblSemester.setBounds(17, 258, 57, 17);
		lblSemester.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setBackground(new Color(173, 216, 230));
		textField.setBounds(132, 30, 56, 20);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(173, 216, 230));
		textField_1.setBounds(132, 68, 156, 20);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(173, 216, 230));
		textField_2.setBounds(132, 106, 156, 20);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(173, 216, 230));
		comboBox.setBounds(132, 182, 142, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"BCA", "BBA", "B.COM", "BSC", "BA"}));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(173, 216, 230));
		comboBox_1.setBounds(132, 220, 68, 20);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(new Color(173, 216, 230));
		comboBox_2.setBounds(132, 258, 61, 20);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		
		dateChooser = new JDateChooser();
		dateChooser.setBackground(new Color(173, 216, 230));
		dateChooser.setBounds(132, 144, 91, 20);
		
		
		//register button action
		
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(new Color(0, 206, 209));
		btnRegister.setBounds(56, 293, 101, 25);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query="insert into student(Student_ID,Name,Father,DOB,Course,Year,Semester) values(?,?,?,?,?,?,?)";
				try {
					ps=con.prepareStatement(query);
					ps.setString(1, textField.getText());
					ps.setString(2, textField_1.getText());
					ps.setString(3,textField_2.getText());
					java.util.Date d= dateChooser.getDate();
					Date date= new Date(d.getTime());			
					ps.setDate(4,date); 
					ps.setString(5, (String)comboBox.getSelectedItem());
					
					ps.setString(6, (String)comboBox_1.getSelectedItem());
					ps.setString(7, (String)comboBox_2.getSelectedItem());
					
					ps.execute();
					JOptionPane.showMessageDialog(null, "New Student Registered");
					
					
					
			} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnRegister.setIcon(new ImageIcon(getClass().getResource("/resource/Add-user-icon.png")));
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(0, 206, 209));
		btnBack.setBounds(175, 293, 83, 25);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Home ob= new Home();
				ob.setVisible(true);
				
			}
		});
		contentPane.setLayout(null);
		btnBack.setIcon(new ImageIcon(getClass().getResource("/resource/Back-icon.png")));
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(lblStudentId);
		panel.add(lblName);
		panel.add(lblFatherName);
		panel.add(lblCourse);
		panel.add(lblBranch);
		panel.add(lblYear);
		panel.add(lblSemester);
		panel.add(dateChooser);
		panel.add(comboBox);
		panel.add(textField);
		panel.add(textField_1);
		panel.add(textField_2);
		panel.add(comboBox_1);
		panel.add(comboBox_2);
		panel.add(btnRegister);
		panel.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("Add New Student");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(0, 0, 157, 19);
		panel.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Student.class.getResource("/resource/860_main_library_bacteria.png")));
		label_1.setBounds(0, 0, 329, 363);
		panel.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Student.class.getResource("/resource/860_main_library_bacteria.png")));
		label.setBounds(0, 0, 822, 435);
		contentPane.add(label);
		Random();
		setLocationRelativeTo(null);
	}
	public void Random() {
		
		java.util.Random rd= new java.util.Random();
		textField.setText("" +rd.nextInt(1000+1));
	}
	public void generateStudId(String Query) {
		

	}
}
