import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Font;

public class IssueReturnReport extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueReturnReport frame = new IssueReturnReport();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void jTable1() {
		try {
			String query="select Book_ID,Name,Student_ID,SName,FName,DOB,Course,Year,DateOfIssue from issuebook";
			
			
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	public void jTable2() {
		try {
			String query="select ID,Student_Id,Name,Course,Book_ID,BName,Edition,Publisher,DOI,DOR from returnbook";
			
			
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}

	/**
	 * Create the frame.
	 */
	public IssueReturnReport() {
		
		super("Issue/Return Book Report");
		con=DB.getConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 711);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		/*DefaultTableModel model= new DefaultTableModel();*/
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 279, 978, 276);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 139, 139), 3, true), "Return Detail", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(139, 0, 0)));
		
		table_1 = new JTable(/*model*/);
		table_1.setBounds(17, 56, 890, 202);
		/*model.addColumn("ID");*/
		/*String cols[]= {"Serial ID","Student ID","Name","Course","Book ID","Book Name","Edition","Publisher","DOI","DOR"};
		model.setColumnIdentifiers(cols);*/
		
		JLabel label_14 = new JLabel("Student ID");
		label_14.setFont(new Font("Dialog", Font.BOLD, 14));
		label_14.setBounds(99, 36, 777, 14);
		label_14.setBackground(Color.LIGHT_GRAY);
		
		JLabel label_15 = new JLabel("Name");
		label_15.setFont(new Font("Dialog", Font.BOLD, 14));
		label_15.setBounds(191, 36, 685, 14);
		
		JLabel label_17 = new JLabel("Course");
		label_17.setFont(new Font("Dialog", Font.BOLD, 14));
		label_17.setBounds(280, 36, 596, 14);
		
		JLabel label_21 = new JLabel("Book ID");
		label_21.setFont(new Font("Dialog", Font.BOLD, 14));
		label_21.setBounds(376, 36, 500, 14);
		
		JLabel label_22 = new JLabel("Book Name");
		label_22.setFont(new Font("Dialog", Font.BOLD, 14));
		label_22.setBounds(463, 36, 413, 14);
		
		JLabel label_23 = new JLabel("Edition");
		label_23.setFont(new Font("Dialog", Font.BOLD, 14));
		label_23.setBounds(551, 36, 325, 14);
		
		JLabel label_24 = new JLabel("Publisher");
		label_24.setFont(new Font("Dialog", Font.BOLD, 14));
		label_24.setBounds(636, 36, 240, 14);
		
		JLabel label_27 = new JLabel("DOI");
		label_27.setFont(new Font("Dialog", Font.BOLD, 14));
		label_27.setBounds(731, 36, 145, 14);
		
		JLabel label_28 = new JLabel("DOR");
		label_28.setFont(new Font("Dialog", Font.BOLD, 14));
		label_28.setBounds(818, 36, 58, 14);
		
		JLabel lblSerialId = new JLabel("Serial ID");
		lblSerialId.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSerialId.setBounds(17, 36, 859, 14);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(0, 206, 209));
		btnBack.setBounds(913, 598, 75, 25);
		btnBack.setIcon(new ImageIcon(getClass().getResource("/resource/Back-icon.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Report ob= new Report();
				ob.setVisible(true);
				
				
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 24, 978, 227);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 139, 139), 3, true), "Issue Report", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(139, 0, 0)));
		
		table = new JTable();
		table.setBounds(10, 41, 893, 175);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setBounds(10, 18, 893, 17);
		lblBookId.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setBounds(119, 18, 784, 17);
		lblBookName.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(207, 18, 696, 17);
		lblStudentId.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(307, 18, 596, 17);
		lblStudentName.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setBounds(405, 18, 498, 17);
		lblFathersName.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setBounds(505, 18, 398, 17);
		lblDob.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setBounds(604, 18, 299, 17);
		lblCourse.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(704, 18, 199, 17);
		lblYear.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblDoi = new JLabel("DOI");
		lblDoi.setBounds(806, 18, 97, 17);
		lblDoi.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPane.setLayout(null);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.add(table_1);
		panel_1.add(lblSerialId);
		panel_1.add(label_14);
		panel_1.add(label_15);
		panel_1.add(label_17);
		panel_1.add(label_21);
		panel_1.add(label_22);
		panel_1.add(label_23);
		panel_1.add(label_24);
		panel_1.add(label_27);
		panel_1.add(label_28);
		
		JLabel lblReturnBookReport = new JLabel("Return Book Report");
		lblReturnBookReport.setForeground(new Color(255, 255, 255));
		lblReturnBookReport.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblReturnBookReport.setBounds(35, 11, 162, 14);
		panel_1.add(lblReturnBookReport);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(IssueReturnReport.class.getResource("/resource/nat2 (3).jpg")));
		label_2.setBounds(0, 0, 978, 276);
		panel_1.add(label_2);
		contentPane.add(btnBack);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(table);
		panel.add(lblBookId);
		panel.add(lblBookName);
		panel.add(lblStudentId);
		panel.add(lblStudentName);
		panel.add(lblFathersName);
		panel.add(lblDob);
		panel.add(lblCourse);
		panel.add(lblYear);
		panel.add(lblDoi);
		
		JLabel lblNewLabel = new JLabel("Issue Book Report");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(10, 0, 168, 14);
		panel.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(IssueReturnReport.class.getResource("/resource/nat2 (3).jpg")));
		label_1.setBounds(-4, 0, 982, 227);
		panel.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(IssueReturnReport.class.getResource("/resource/8314929977_28fd740070_b.jpg")));
		label.setBounds(-23, -69, 1046, 806);
		contentPane.add(label);
		jTable1();
		jTable2();
		setLocationRelativeTo(null);
		
	}
}
