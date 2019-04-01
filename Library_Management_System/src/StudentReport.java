import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class StudentReport extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentReport frame = new StudentReport();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void jTable1() {
		try {
			String query="select * from student";
			
			
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	

	/**
	 * Create the frame.
	 */
	public StudentReport() {
		
		super("Library member Report");
		con=DB.getConnection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(82, 21, 684, 398);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 139, 139), 3, true), "Members", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(139, 0, 0)));
		
		btnBack = new JButton("Back");
		btnBack.setBackground(new Color(0, 206, 209));
		btnBack.setBounds(680, 426, 75, 25);
		btnBack.setIcon(new ImageIcon(getClass().getResource("/resource/Back-icon.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Report ob= new Report();
				ob.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(17, 50, 630, 330);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(17, 27, 93, 17);
		lblStudentId.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(120, 27, 65, 17);
		lblName.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setBounds(195, 27, 114, 17);
		lblFathersName.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblCourse = new JLabel("DOB");
		lblCourse.setBounds(319, 27, 49, 17);
		lblCourse.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblBranch = new JLabel("Course");
		lblBranch.setBounds(378, 27, 65, 17);
		lblBranch.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(472, 27, 79, 17);
		lblYear.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(561, 27, 86, 17);
		lblSemester.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(table);
		panel.add(lblStudentId);
		panel.add(lblName);
		panel.add(lblFathersName);
		panel.add(lblCourse);
		panel.add(lblBranch);
		panel.add(lblYear);
		panel.add(lblSemester);
		
		JLabel lblStudentInfo = new JLabel("Student Info");
		lblStudentInfo.setForeground(new Color(255, 255, 255));
		lblStudentInfo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblStudentInfo.setBounds(0, 0, 148, 27);
		panel.add(lblStudentInfo);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(StudentReport.class.getResource("/resource/nat2 (3).jpg")));
		label_1.setBounds(0, 0, 684, 398);
		panel.add(label_1);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(StudentReport.class.getResource("/resource/860_main_library_bacteria.png")));
		label.setBounds(0, -12, 883, 486);
		contentPane.add(label);
		jTable1();
		setLocationRelativeTo(null);
	}
}
