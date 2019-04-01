import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1354, 692);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login ob= new Login();
				ob.setVisible(true);
			}
		});
		mntmLogout.setIcon(new ImageIcon(getClass().getResource("/resource/User-Interface-Logout-icon (1).png")));
		mnFile.add(mntmLogout);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mntmExit.setIcon(new ImageIcon(getClass().getResource("/resource/Back-icon.png")));
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				AboutUs ob= new AboutUs();
				ob.setVisible(true);
			}
		});
		mntmAbout.setIcon(new ImageIcon(getClass().getResource("/resource/Very-Basic-About-icon.png")));
		mnEdit.add(mntmAbout);
		
		JMenu mnAddUser = new JMenu("User");
		menuBar.add(mnAddUser);
		
		JMenuItem mntmAdd = new JMenuItem("Add User account");
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				SignUp ob= new SignUp();
				ob.setVisible(true);
				
			}
		});
		mnAddUser.add(mntmAdd);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(603, 140, 667, 213);
		panel.setBackground(new Color(192, 192, 192));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255), 3, true), "Operation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(139, 0, 0)));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(603, 354, 669, 211);
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 191, 255), 3), "Task", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(139, 0, 0)));
		
		
		//Issue book action 
		
		
		
		JButton btnIssueBook = new JButton("");
		btnIssueBook.setBackground(new Color(0, 206, 209));
		btnIssueBook.setBounds(65, 27, 151, 137);
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Issue ob= new Issue();
				ob.setVisible(true);
			}
		});
		btnIssueBook.setIcon(new ImageIcon(getClass().getResource("/resource/issueb.png")));
		
		
		
		/*RETURN BUTTON REDIREDTED TO RETURN PAGE*/
		
		JButton btnReturnBook = new JButton("");
		btnReturnBook.setBackground(new Color(0, 206, 209));
		btnReturnBook.setBounds(262, 27, 150, 137);
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Return ob= new Return();
				ob.setVisible(true);
			}
		});
		btnReturnBook.setIcon(new ImageIcon(Home.class.getResource("/resource/returnb.png")));
		
		JButton btnAbout = new JButton("");
		btnAbout.setBackground(new Color(0, 206, 209));
		btnAbout.setBounds(466, 27, 147, 137);
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				AboutUs ob= new AboutUs();
				ob.setVisible(true);
			}
		});
		btnAbout.setIcon(new ImageIcon(Home.class.getResource("/resource/abt.png")));
		
		JLabel lblIssueBook = new JLabel("Issue Book");
		lblIssueBook.setForeground(new Color(255, 255, 255));
		lblIssueBook.setBounds(111, 182, 528, 17);
		lblIssueBook.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JLabel lblReturnBook = new JLabel("Return Book");
		lblReturnBook.setForeground(new Color(255, 255, 255));
		lblReturnBook.setBounds(291, 182, 348, 17);
		lblReturnBook.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JLabel lblAbout = new JLabel("About");
		lblAbout.setForeground(new Color(255, 255, 255));
		lblAbout.setBounds(520, 182, 119, 17);
		lblAbout.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JButton button = new JButton("");
		button.setBounds(62, 27, 151, 137);
		button.setBackground(new Color(0, 206, 209));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				NewBook ob= new NewBook();
				ob.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(getClass().getResource("/resource/books-icon.png")));
		
		JButton button_1 = new JButton("");
		button_1.setBackground(new Color(0, 206, 209));
		button_1.setBounds(257, 27, 152, 137);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Report ob= new Report();
				ob.setVisible(true);
			}
		});
		button_1.setIcon(new ImageIcon(getClass().getResource("/resource/statistics-market-icon.png")));
		
		
		
		//new Student buttion action
		
		
		
		JButton button_2 = new JButton("");
		button_2.setBackground(new Color(0, 206, 209));
		button_2.setBounds(472, 27, 145, 137);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Student ob= new Student();
				ob.setVisible(true);
				
				
			}
		});
		button_2.setIcon(new ImageIcon(getClass().getResource("/resource/Student-3-icon.png")));
		
		JLabel lblNewBook = new JLabel("New Book");
		lblNewBook.setForeground(new Color(255, 255, 255));
		lblNewBook.setBounds(99, 182, 540, 17);
		lblNewBook.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JLabel lblStatistics = new JLabel("Statistics");
		lblStatistics.setForeground(new Color(255, 255, 255));
		lblStatistics.setBounds(304, 182, 335, 17);
		lblStatistics.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JLabel lblNewStudent = new JLabel("New Student");
		lblNewStudent.setForeground(new Color(255, 255, 255));
		lblNewStudent.setBounds(501, 182, 138, 17);
		lblNewStudent.setFont(new Font("Dialog", Font.BOLD, 15));
		contentPane.setLayout(null);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.add(btnIssueBook);
		panel_1.add(btnReturnBook);
		panel_1.add(btnAbout);
		panel_1.add(lblIssueBook);
		panel_1.add(lblReturnBook);
		panel_1.add(lblAbout);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Home.class.getResource("/resource/linderman-library-lehigh-valley-photography-engagement-ring.bin.jpg")));
		label_2.setBounds(0, 0, 669, 211);
		panel_1.add(label_2);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(button);
		panel.add(button_1);
		panel.add(button_2);
		panel.add(lblNewBook);
		panel.add(lblStatistics);
		panel.add(lblNewStudent);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 667, 213);
		label.setIcon(new ImageIcon(Home.class.getResource("/resource/linderman-library-lehigh-valley-photography-engagement-ring.bin.jpg")));
		panel.add(label);
		
		JLabel lblWelcome = new JLabel("Welcome ");
		lblWelcome.setForeground(new Color(255, 69, 0));
		lblWelcome.setFont(new Font("Elephant", Font.BOLD | Font.ITALIC, 28));
		lblWelcome.setBounds(49, 119, 155, 37);
		contentPane.add(lblWelcome);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setForeground(Color.WHITE);
		lblTo.setFont(new Font("Elephant", Font.BOLD | Font.ITALIC, 28));
		lblTo.setBounds(37, 165, 155, 28);
		contentPane.add(lblTo);
		
		JLabel lblLibraryManagementSystem = new JLabel("Library Management System");
		lblLibraryManagementSystem.setForeground(new Color(0, 128, 0));
		lblLibraryManagementSystem.setFont(new Font("Elephant", Font.BOLD | Font.ITALIC, 28));
		lblLibraryManagementSystem.setBounds(10, 203, 481, 37);
		contentPane.add(lblLibraryManagementSystem);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Home.class.getResource("/resource/nat2 (2).jpg")));
		label_1.setBounds(-149, 0, 1593, 696);
		contentPane.add(label_1);
		setLocationRelativeTo(null);
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);
	}
}
