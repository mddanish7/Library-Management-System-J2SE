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
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Issue extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	
	
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	public JTextField textField_13;
	JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Issue frame = new Issue();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void updateRecord() {
		try {
		
		String query2="UPDATE book SET NoOfCopy=NoOfCopy-1 WHERE Book_ID=? and NoOfCopy>0";
		
		ps= con.prepareStatement(query2);
		ps.setString(1,textField.getText());
		ps.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "book stock updated");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "exception occure in booK update method of issue class");
			JOptionPane.showMessageDialog(null, e);
		}
		
		

	}
	public boolean insertIssueBook() {
		con=DB.getConnection();
		String query="insert into issuebook(Book_ID,Name,Edition,Publisher,Price,Pages,Student_ID,SName,FName,DOB,Course,Year,Semester,DateOfIssue) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int count = 0;
		try {
			ps=con.prepareStatement(query);
			
			
			
			
			ps.setString(1, textField.getText());
			ps.setString(2, textField_1.getText());
			ps.setString(3, textField_2.getText());
			ps.setString(4, textField_3.getText());
			ps.setString(5, textField_4.getText());
			ps.setString(6, textField_5.getText());
			ps.setString(7, textField_6.getText());
			ps.setString(8, textField_7.getText());
			ps.setString(9, textField_8.getText());
			ps.setString(10, textField_9.getText());
			ps.setString(11, textField_10.getText());
			ps.setString(12, textField_11.getText());
			ps.setString(13, textField_12.getText());
			
			//String date=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
			
			java.util.Date d= dateChooser.getDate();
			Date date= new Date(d.getTime());			
			ps.setDate(14,date); 
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Book Issued");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Member already had a book");
			JOptionPane.showMessageDialog(null, e);
			count++;
		}
		if(count>0) {
			return false;
		}else {
			
		return true;
		}
		
	}

	/**
	 * Create the frame.
	 */
	public Issue() {
		super("Issue Book");
		
		con=DB.getConnection();
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(83, 33, 319, 298);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 139, 139), 3, true), "Book Detail", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(139, 0, 0)));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(433, 33, 346, 298);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 139, 139), 3, true), "Student Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		
		JLabel lblDateOfIssue = new JLabel("Date Of Issue");
		lblDateOfIssue.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDateOfIssue.setForeground(Color.CYAN);
		lblDateOfIssue.setBounds(489, 363, 113, 14);
		
		dateChooser = new JDateChooser();
		dateChooser.setBackground(new Color(173, 216, 230));
		dateChooser.setBounds(609, 363, 123, 20);
		
		
		//Issue button action
		
		JButton btnNewButton = new JButton("Issue");
		btnNewButton.setBackground(new Color(0, 206, 209));
		btnNewButton.setBounds(503, 412, 87, 26);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					boolean b= insertIssueBook();
					if(b==true) {
					updateRecord();
					}else {
						JOptionPane.showMessageDialog(null, "Record not updated");
					}

				} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
				
				}
				
				
				
			}
			
		});
		
		
		
		
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("/resource/new-icon.png")));
		
		
		/*Issue book back button */
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(0, 206, 209));
		btnBack.setBounds(626, 413, 75, 25);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				Home ob= new Home();
				ob.setVisible(true);
				
			}
		});
		btnBack.setIcon(new ImageIcon(getClass().getResource("/resource/Back-icon.png")));
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setForeground(new Color(255, 255, 255));
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblStudentId.setBounds(27, 32, 86, 14);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setForeground(new Color(255, 255, 255));
		lblName_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblName_1.setBounds(27, 73, 69, 14);
		
		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setForeground(new Color(255, 255, 255));
		lblFathersName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblFathersName.setBounds(23, 109, 103, 14);
		
		JLabel lblCourse = new JLabel("DOB");
		lblCourse.setForeground(new Color(255, 255, 255));
		lblCourse.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblCourse.setBounds(27, 149, 86, 14);
		
		JLabel lblBranch = new JLabel("Course");
		lblBranch.setForeground(new Color(255, 255, 255));
		lblBranch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblBranch.setBounds(27, 187, 69, 14);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setForeground(new Color(255, 255, 255));
		lblYear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblYear.setBounds(27, 225, 69, 14);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setForeground(new Color(255, 255, 255));
		lblSemester.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblSemester.setBounds(27, 263, 69, 14);
		
		textField_6 = new JTextField();
		textField_6.setBackground(new Color(173, 216, 230));
		textField_6.setBounds(123, 29, 69, 20);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBackground(new Color(173, 216, 230));
		textField_7.setBounds(123, 70, 156, 20);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBackground(new Color(173, 216, 230));
		textField_8.setBounds(123, 108, 156, 20);
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBackground(new Color(173, 216, 230));
		textField_9.setBounds(123, 146, 132, 20);
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBackground(new Color(173, 216, 230));
		textField_10.setBounds(123, 184, 105, 20);
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBackground(new Color(173, 216, 230));
		textField_11.setBounds(123, 222, 52, 20);
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBackground(new Color(173, 216, 230));
		textField_12.setBounds(123, 260, 52, 20);
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		
		
		//Search button action for student details
		
		
		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.setBackground(new Color(0, 206, 209));
		btnSearch_1.setBounds(251, 29, 85, 25);
		btnSearch_1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
										try {
												String query="select * from student where Student_ID=?";
												ps=con.prepareStatement(query);
												ps.setString(1,textField_6.getText());
												rs=ps.executeQuery();
					
												if(rs.next()) {
													String add1=rs.getString("Name");
													textField_7.setText(add1);
						
													String add2=rs.getString("Father");
													textField_8.setText(add2);
						
													String add3=rs.getString("DOB");
													textField_9.setText(add3);
						
													String add4=rs.getString("Course");
													textField_10.setText(add4);
						
													String add5=rs.getString("Year");
													textField_11.setText(add5);
						
													String add6=rs.getString("Semester");
													textField_12.setText(add6);
						
												}
					
										} catch (Exception e) {
											JOptionPane.showMessageDialog(null, e);
										}
										finally {
											try {
												rs.close();
												ps.close();
											} catch (Exception e2) {
												JOptionPane.showMessageDialog(null, e2);
											}
										}
				
								}
		});
		btnSearch_1.setIcon(new ImageIcon(getClass().getResource("/resource/search-icon.png")));
		
		JLabel lblBookId = new JLabel("Book Id");
		lblBookId.setForeground(Color.WHITE);
		lblBookId.setBounds(10, 29, 77, 17);
		lblBookId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(17, 70, 70, 17);
		lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setForeground(Color.WHITE);
		lblEdition.setBounds(17, 108, 70, 17);
		lblEdition.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setForeground(Color.WHITE);
		lblPublisher.setBounds(17, 146, 94, 17);
		lblPublisher.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setBounds(17, 184, 70, 17);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblPages = new JLabel("Pages");
		lblPages.setForeground(Color.WHITE);
		lblPages.setBounds(17, 222, 70, 17);
		lblPages.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		textField = new JTextField();
		textField.setBackground(new Color(173, 216, 230));
		textField.setBounds(97, 29, 73, 20);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(173, 216, 230));
		textField_1.setBounds(97, 70, 140, 20);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(173, 216, 230));
		textField_2.setBounds(97, 108, 47, 20);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(173, 216, 230));
		textField_3.setBounds(97, 146, 140, 20);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(173, 216, 230));
		textField_4.setBounds(97, 184, 54, 20);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(173, 216, 230));
		textField_5.setBounds(97, 222, 73, 20);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		
		
		//SEARCH button code for book id
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(0, 206, 209));
		btnSearch.setBounds(223, 27, 86, 25);
		btnSearch.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent arg0) {
															String query="select * from book where Book_ID=?";
															
															try {
																ps= con.prepareStatement(query);
																ps.setString(1,textField.getText());
																rs=ps.executeQuery();
																if(rs.next()) {
																	String add1=rs.getString("BName");
																	textField_1.setText(add1);
						
																	String add2=rs.getString("Edition");
																	textField_2.setText(add2);
						
																	String add3=rs.getString("Publisher");
																	textField_3.setText(add3);
						
																	String add6=rs.getString("NoOfCopy");
																	int noc=Integer.parseInt(add6);
																	if(noc==0) {
																		JOptionPane.showMessageDialog(null,"Book is not available now");
																	}
																	textField_13.setText(add6);
																
						
																	String add4=rs.getString("Price");
																	textField_4.setText(add4);
						
																	String add5=rs.getString("Pages");
																	textField_5.setText(add5);
						
						
						
																}
																else {
																	JOptionPane.showMessageDialog(null, "Book Id Not found");
																}
					
															} catch (Exception e) {
																JOptionPane.showMessageDialog(null, e);
															}finally {
																try {
																	rs.close();
																	ps.close();
																} catch (SQLException e) {
																	e.printStackTrace();
																}
					
															}
				
				
														}
		});
		contentPane.setLayout(null);
		btnSearch.setIcon(new ImageIcon(getClass().getResource("/resource/search-icon.png")));
		
		JLabel lblAvailableNoOf = new JLabel("Available Copies");
		lblAvailableNoOf.setForeground(Color.WHITE);
		lblAvailableNoOf.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAvailableNoOf.setBounds(10, 263, 113, 19);
		
		textField_13 = new JTextField();
		textField_13.setBackground(new Color(173, 216, 230));
		textField_13.setBounds(127, 264, 67, 20);
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(lblBookId);
		panel.add(lblName);
		panel.add(lblEdition);
		panel.add(lblPublisher);
		panel.add(lblPrice);
		panel.add(lblPages);
		panel.add(textField_5);
		panel.add(textField_4);
		panel.add(textField_3);
		panel.add(textField_2);
		panel.add(textField);
		panel.add(textField_1);
		panel.add(btnSearch);
		panel.add(lblAvailableNoOf);
		panel.add(textField_13);
		
		JLabel lblBookDetails = new JLabel("Book Details");
		lblBookDetails.setForeground(Color.WHITE);
		lblBookDetails.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblBookDetails.setBounds(0, 0, 111, 18);
		panel.add(lblBookDetails);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(Color.WHITE);
		label_1.setIcon(new ImageIcon(Issue.class.getResource("/resource/860_main_library_bacteria.png")));
		label_1.setBounds(0, 0, 319, 298);
		panel.add(label_1);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.add(lblStudentId);
		panel_1.add(lblName_1);
		panel_1.add(lblFathersName);
		panel_1.add(lblCourse);
		panel_1.add(lblBranch);
		panel_1.add(lblYear);
		panel_1.add(lblSemester);
		panel_1.add(textField_12);
		panel_1.add(textField_11);
		panel_1.add(textField_10);
		panel_1.add(textField_9);
		panel_1.add(textField_8);
		panel_1.add(textField_7);
		panel_1.add(textField_6);
		panel_1.add(btnSearch_1);
		
		JLabel lblStudentDetails = new JLabel("Student Details");
		lblStudentDetails.setForeground(Color.WHITE);
		lblStudentDetails.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblStudentDetails.setBounds(0, 0, 126, 14);
		panel_1.add(lblStudentDetails);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Issue.class.getResource("/resource/860_main_library_bacteria.png")));
		label_2.setBounds(0, 0, 346, 298);
		panel_1.add(label_2);
		contentPane.add(lblDateOfIssue);
		contentPane.add(btnNewButton);
		contentPane.add(dateChooser);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.CYAN);
		label.setIcon(new ImageIcon(Issue.class.getResource("/resource/8314929977_28fd740070_b.jpg")));
		label.setBounds(0, 0, 846, 492);
		contentPane.add(label);
		setLocationRelativeTo(null);
	}
}
	


