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
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Return extends JFrame {

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
	private JTextField textField_13;
	JDateChooser dateChooser;
	
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
					Return frame = new Return();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void delete() {
		String  query="delete from issuebook where Student_ID=?";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, textField.getText());
			ps.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
	public boolean insertReturn() {
		
		String query="insert into returnbook(ID,Student_Id,Name,Father,DOB,Course,Year,Semester,Book_ID,BName,Edition,Publisher,Price,Pages,DOI,DOR) values(0,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			ps.setString(14, textField_13.getText());
			
			java.util.Date d= dateChooser.getDate();
			Date date= new Date(d.getTime());			
			ps.setDate(15,date);

			
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Book returned successfully");
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
	
	public void calculateFine() {
		String query= "select DATEDIFF(DOR,DOI) FROM returnbook  where Student_Id=? and Book_ID=? and DOI=?";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, textField.getText());
		
			ps.setString(2, textField_7.getText());
			
			
			ps.setString(3, textField_13.getText());
			System.out.println("one");
			
		
			
			rs=ps.executeQuery();
			if(rs.next()) {
				int Day=rs.getInt(1);
				
				if (Day>10) {
					int d=Day-10;
					int fine=d*10;
					
					JOptionPane.showMessageDialog(null, "You have to pay Fine "+fine);
					
				}
			}
			
		} catch (Exception e) {
			
		}
			
	}
	
	public void addBook() {
		String query= "update book set NoOfCopy=NoOfCopy+1 where Book_ID=?";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, textField_7.getText());
			ps.execute();
		JOptionPane.showMessageDialog(null, "Book Added to BookShelf");	
		} catch (Exception e) {
		JOptionPane.showMessageDialog(null, e);
		}
	}
	

	/**
	 * Create the frame.
	 */
	public Return() {
		super("Return Book");
		
		con=DB.getConnection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(102, 30, 586, 313);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 139, 139), 3, true), "Return Panel", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		
		//return button will delete Issued Book And To retun Book database using delete() method
		
		JButton btnRetu = new JButton("Return");
		btnRetu.setBackground(new Color(0, 206, 209));
		btnRetu.setBounds(487, 408, 85, 25);
		btnRetu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean b=insertReturn();
				if(b==true) {
				delete();
				calculateFine();
				addBook();
				}else {
					JOptionPane.showMessageDialog(null, "failed to update");
				}
			}
		});
		btnRetu.setIcon(new ImageIcon(getClass().getResource("/resource/retrive.png")));
		
		//back button code redirected to home
		
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(0, 206, 209));
		btnBack.setBounds(597, 408, 75, 25);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Home ob= new Home();
				ob.setVisible(true);
				
			}
		});
		btnBack.setIcon(new ImageIcon(getClass().getResource("/resource/Back-icon.png")));
		
		JLabel lblReturnDate = new JLabel("Return Date");
		lblReturnDate.setForeground(new Color(255, 20, 147));
		lblReturnDate.setBackground(new Color(255, 20, 147));
		lblReturnDate.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblReturnDate.setBounds(475, 366, 103, 14);
		
		 dateChooser = new JDateChooser();
		 dateChooser.setBackground(new Color(173, 216, 230));
		 dateChooser.setBounds(581, 366, 91, 20);
		
		/*returnbook search button*/
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(0, 206, 209));
		btnSearch.setBounds(392, 408, 85, 25);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query="select * from issuebook where Student_ID=?";
				try {
					ps=con.prepareStatement(query);
					ps.setString(1, textField.getText());
					rs=ps.executeQuery();
					if (rs.next()) {
						String add1=rs.getString("SName");
						textField_1.setText(add1);
						
						String add2=rs.getString("FName");
						textField_2.setText(add2);
						
						String add3=rs.getString("DOB");
						textField_3.setText(add3);
						
						String add4=rs.getString("Course");
						textField_4.setText(add4);
						
						String add5=rs.getString("Year");
						textField_5.setText(add5);
						
						String add6=rs.getString("Semester");
						textField_6.setText(add6);
						
						String add7=rs.getString("Book_ID");
						textField_7.setText(add7);
						
						String add8=rs.getString("Name");
						textField_8.setText(add8);
						
						String add9=rs.getString("Edition");
						textField_9.setText(add9);
						
						String add10=rs.getString("Publisher");
						textField_10.setText(add10);
						
						String add11=rs.getString("Price");
						textField_11.setText(add11);
						
						String add12=rs.getString("Pages");
						textField_12.setText(add12);
						
						String add13=rs.getString("DateOfIssue");
						textField_13.setText(add13);
						
						
						
					}else {
						JOptionPane.showMessageDialog(null, "book is not issued with this Student ID");
					}
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}finally {
					try {
						rs.close();
						ps.close();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2);
					}
				}
				
			}
			
		});
		btnSearch.setIcon(new ImageIcon(getClass().getResource("/resource/search-icon.png")));
		
		JLabel lblNewLabel = new JLabel("Student ID");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(17, 27, 87, 17);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setBounds(17, 65, 73, 17);
		lblName.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setForeground(new Color(255, 255, 255));
		lblFathersName.setBounds(17, 103, 106, 17);
		lblFathersName.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Course");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(17, 179, 87, 17);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblBranch = new JLabel("DOB");
		lblBranch.setForeground(new Color(255, 255, 255));
		lblBranch.setBounds(17, 141, 87, 17);
		lblBranch.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setForeground(new Color(255, 255, 255));
		lblYear.setBounds(17, 217, 87, 17);
		lblYear.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setForeground(new Color(255, 255, 255));
		lblSemester.setBounds(17, 255, 87, 17);
		lblSemester.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		
		textField = new JTextField();
		textField.setBackground(new Color(173, 216, 230));
		textField.setBounds(133, 27, 86, 20);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(173, 216, 230));
		textField_1.setBounds(133, 65, 135, 20);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(173, 216, 230));
		textField_2.setBounds(133, 103, 135, 20);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(173, 216, 230));
		textField_3.setBounds(133, 141, 135, 20);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(173, 216, 230));
		textField_4.setBounds(133, 179, 135, 20);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(173, 216, 230));
		textField_5.setBounds(133, 217, 135, 20);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBackground(new Color(173, 216, 230));
		textField_6.setBounds(133, 255, 135, 20);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setForeground(new Color(255, 255, 255));
		lblBookId.setBounds(303, 27, 81, 17);
		lblBookId.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setForeground(new Color(255, 255, 255));
		lblName_1.setBounds(303, 65, 54, 17);
		lblName_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setForeground(new Color(255, 255, 255));
		lblEdition.setBounds(303, 103, 54, 17);
		lblEdition.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setForeground(new Color(255, 255, 255));
		lblPublisher.setBounds(303, 141, 73, 17);
		lblPublisher.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(new Color(255, 255, 255));
		lblPrice.setBounds(303, 179, 82, 17);
		lblPrice.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblPages = new JLabel("Pages");
		lblPages.setForeground(new Color(255, 255, 255));
		lblPages.setBounds(303, 217, 73, 17);
		lblPages.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblNewLabel_2 = new JLabel("Date Of Issue");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(303, 255, 113, 17);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		
		textField_7 = new JTextField();
		textField_7.setBackground(new Color(173, 216, 230));
		textField_7.setBounds(394, 27, 86, 20);
		textField_7.setEnabled(false);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBackground(new Color(173, 216, 230));
		textField_8.setBounds(394, 65, 147, 20);
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBackground(new Color(173, 216, 230));
		textField_9.setBounds(394, 103, 147, 20);
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBackground(new Color(173, 216, 230));
		textField_10.setBounds(394, 141, 147, 20);
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBackground(new Color(173, 216, 230));
		textField_11.setBounds(394, 179, 147, 20);
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBackground(new Color(173, 216, 230));
		textField_12.setBounds(394, 217, 147, 20);
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBackground(new Color(173, 216, 230));
		textField_13.setBounds(395, 255, 146, 20);
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(btnSearch);
		contentPane.add(btnRetu);
		contentPane.add(btnBack);
		contentPane.add(lblReturnDate);
		contentPane.add(dateChooser);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(lblNewLabel);
		panel.add(lblName);
		panel.add(lblFathersName);
		panel.add(lblNewLabel_1);
		panel.add(lblBranch);
		panel.add(lblYear);
		panel.add(lblSemester);
		panel.add(textField);
		panel.add(textField_1);
		panel.add(textField_2);
		panel.add(textField_3);
		panel.add(textField_4);
		panel.add(textField_5);
		panel.add(textField_6);
		panel.add(lblNewLabel_2);
		panel.add(textField_13);
		panel.add(lblBookId);
		panel.add(lblName_1);
		panel.add(lblEdition);
		panel.add(lblPublisher);
		panel.add(lblPrice);
		panel.add(lblPages);
		panel.add(textField_7);
		panel.add(textField_8);
		panel.add(textField_9);
		panel.add(textField_10);
		panel.add(textField_11);
		panel.add(textField_12);
		
		JLabel lblNewLabel_4 = new JLabel("Return Book ");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_4.setBounds(0, 0, 123, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_3.setIcon(new ImageIcon(Return.class.getResource("/resource/860_main_library_bacteria.png")));
		lblNewLabel_3.setBounds(0, 0, 586, 313);
		panel.add(lblNewLabel_3);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Return.class.getResource("/resource/860_main_library_bacteria.png")));
		label.setBounds(0, 0, 823, 458);
		contentPane.add(label);
		setLocationRelativeTo(null);
		
	}
}
