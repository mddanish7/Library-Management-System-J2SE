import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;

public class Report extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report frame = new Report();
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
	public Report() {
		super("Statistics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(146, 56, 574, 293);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 139, 139), 3, true), "Report", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		
		JButton btnAvalableBooks = new JButton("");
		btnAvalableBooks.setBackground(new Color(0, 206, 209));
		btnAvalableBooks.setBounds(32, 43, 153, 127);
		btnAvalableBooks.setIcon(new ImageIcon(Report.class.getResource("/resource/562132.png")));
		btnAvalableBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				AvailableBooks ob=new AvailableBooks();
				ob.setVisible(true);
			}
		});
		
		JButton btnMembers = new JButton("");
		btnMembers.setBackground(new Color(0, 206, 209));
		btnMembers.setBounds(191, 43, 153, 129);
		btnMembers.setIcon(new ImageIcon(Report.class.getResource("/resource/Register-icon-01.png")));
		btnMembers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				StudentReport ob= new StudentReport();
				ob.setVisible(true);
			}
		});
		
		JButton btnIssuereturnBooks = new JButton("");
		btnIssuereturnBooks.setBackground(new Color(0, 206, 209));
		btnIssuereturnBooks.setBounds(350, 43, 153, 129);
		btnIssuereturnBooks.setIcon(new ImageIcon(getClass().getResource("/resource/issret rep.png")));
		btnIssuereturnBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				IssueReturnReport ob= new IssueReturnReport();
				ob.setVisible(true);
				
			}
		});
		
		JButton btnBcak = new JButton("Back\r\n");
		btnBcak.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBcak.setBackground(new Color(0, 206, 209));
		btnBcak.setBounds(376, 243, 104, 25);
		btnBcak.setIcon(new ImageIcon(getClass().getResource("/resource/Back-icon.png")));
		btnBcak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Home ob=new Home();
				ob.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		
		JLabel lblAvailableBook = new JLabel("Available Book");
		lblAvailableBook.setForeground(new Color(255, 255, 255));
		lblAvailableBook.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAvailableBook.setBounds(42, 183, 122, 14);
		
		JLabel lblMembers = new JLabel("Registered Students");
		lblMembers.setForeground(new Color(255, 255, 255));
		lblMembers.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblMembers.setBounds(195, 183, 149, 14);
		
		JLabel lblIssuereturnBooks = new JLabel("Issue/Return Books ");
		lblIssuereturnBooks.setForeground(new Color(255, 255, 255));
		lblIssuereturnBooks.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblIssuereturnBooks.setBounds(360, 183, 169, 14);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(btnBcak);
		panel.add(btnAvalableBooks);
		panel.add(btnMembers);
		panel.add(lblMembers);
		panel.add(lblIssuereturnBooks);
		panel.add(btnIssuereturnBooks);
		panel.add(lblAvailableBook);
		
		JLabel lblReport = new JLabel("Report");
		lblReport.setForeground(new Color(255, 255, 255));
		lblReport.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblReport.setBounds(10, 0, 85, 32);
		panel.add(lblReport);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Report.class.getResource("/resource/nat2 (2).jpg")));
		label_1.setBounds(0, 0, 574, 293);
		panel.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\r\\eclipse-workspace\\Library_Management_System\\Image\\8314929977_28fd740070_b.jpg"));
		label.setBounds(0, -11, 820, 425);
		contentPane.add(label);
		setLocationRelativeTo(null);
	}
}
