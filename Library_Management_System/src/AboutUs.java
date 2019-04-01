import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AboutUs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutUs frame = new AboutUs();
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
	public AboutUs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 5, 592, 250);
		
		JLabel lblLibraryManagementSystem = new JLabel("Library Management System");
		lblLibraryManagementSystem.setBounds(320, 67, 253, 26);
		lblLibraryManagementSystem.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		
		JLabel lblVersion = new JLabel("Version 1.0");
		lblVersion.setBounds(413, 94, 94, 27);
		lblVersion.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 17));
		
		JLabel lblCopyright = new JLabel("Copyright @2019");
		lblCopyright.setBounds(402, 127, 136, 25);
		lblCopyright.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 16));
		
		JLabel lblProjectDevelopedBy = new JLabel("Project Developed By-");
		lblProjectDevelopedBy.setBounds(22, 170, 139, 18);
		lblProjectDevelopedBy.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
		
		JLabel lblshubhamNagure = new JLabel("1)Shubham Nagure");
		lblshubhamNagure.setBounds(179, 170, 160, 18);
		lblshubhamNagure.setFont(new Font("DialogInput", Font.BOLD, 17));
		
		JLabel lblrajasInamdar = new JLabel("2)Rajas Inamdar");
		lblrajasInamdar.setBounds(179, 199, 150, 18);
		lblrajasInamdar.setFont(new Font("DialogInput", Font.BOLD, 17));
		
		JButton btnNewButton = new JButton("Back\r\n");
		btnNewButton.setBackground(new Color(0, 206, 209));
		btnNewButton.setBounds(487, 214, 75, 25);
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("/resource/Back-icon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Home ob= new Home();
				ob.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(lblVersion);
		panel.add(lblLibraryManagementSystem);
		panel.add(lblCopyright);
		panel.add(lblProjectDevelopedBy);
		panel.add(lblrajasInamdar);
		panel.add(lblshubhamNagure);
		panel.add(btnNewButton);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AboutUs.class.getResource("/resource/nat2 (2).jpg")));
		label_1.setBounds(0, 0, 592, 250);
		panel.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AboutUs.class.getResource("/resource/860_main_library_bacteria.png")));
		label.setBounds(-13, 0, 635, 275);
		contentPane.add(label);
		setLocationRelativeTo(null);
	}
}
