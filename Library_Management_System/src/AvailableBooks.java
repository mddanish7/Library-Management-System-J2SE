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
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AvailableBooks extends JFrame {

	private JPanel contentPane;
	private JTable table;
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
					AvailableBooks frame = new AvailableBooks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void jTable1() {
		try {
			String query="select * from book";
			
			
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
	public AvailableBooks() {
		super("Available Books");
		
		con=DB.getConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(53, 22, 710, 337);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 139, 139), 3, true), "Available Book", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(139, 0, 0)));
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(0, 206, 209));
		btnBack.setBounds(650, 380, 75, 25);
		btnBack.setIcon(new ImageIcon(getClass().getResource("/resource/Back-icon.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Report ob= new Report();
				ob.setVisible(true);
			}
		});
		
		table = new JTable();
		table.setBounds(17, 50, 677, 269);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setBounds(17, 27, 653, 17);
		lblBookId.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setBounds(114, 27, 556, 17);
		lblBookName.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setBounds(212, 27, 458, 17);
		lblEdition.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setBounds(304, 27, 366, 17);
		lblPublisher.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblNoOfCopies = new JLabel("No Of Copies");
		lblNoOfCopies.setBounds(407, 27, 263, 17);
		lblNoOfCopies.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(504, 27, 166, 17);
		lblPrice.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblPages = new JLabel("Pages");
		lblPages.setBounds(600, 27, 70, 17);
		lblPages.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPane.setLayout(null);
		contentPane.add(btnBack);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(table);
		panel.add(lblBookId);
		panel.add(lblBookName);
		panel.add(lblEdition);
		panel.add(lblPublisher);
		panel.add(lblNoOfCopies);
		panel.add(lblPrice);
		panel.add(lblPages);
		
		JLabel lblAvailableBooks = new JLabel("Available Books");
		lblAvailableBooks.setForeground(new Color(255, 255, 255));
		lblAvailableBooks.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblAvailableBooks.setBounds(0, 0, 166, 16);
		panel.add(lblAvailableBooks);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AvailableBooks.class.getResource("/resource/nat2 (3).jpg")));
		label_1.setBounds(0, 0, 710, 337);
		panel.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AvailableBooks.class.getResource("/resource/8314929977_28fd740070_b.jpg")));
		label.setBounds(0, 0, 793, 432);
		contentPane.add(label);
		jTable1();
		setLocationRelativeTo(null);
	}
}
