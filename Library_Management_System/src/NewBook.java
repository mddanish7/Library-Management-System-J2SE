import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class NewBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBook frame = new NewBook();
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
	public NewBook() {
		super("New Book");
		con=DB.getConnection();
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(225, 21, 315, 360);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 139, 139), 3, true), "Add New Book", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(139, 0, 0)));
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setForeground(Color.WHITE);
		lblBookId.setBounds(17, 27, 49, 17);
		lblBookId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(17, 65, 35, 17);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setForeground(Color.WHITE);
		lblEdition.setBounds(17, 103, 41, 17);
		lblEdition.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setForeground(Color.WHITE);
		lblPublisher.setBounds(17, 141, 54, 17);
		lblPublisher.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setBounds(17, 214, 29, 17);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPages = new JLabel("Pages");
		lblPages.setForeground(Color.WHITE);
		lblPages.setBounds(17, 255, 36, 17);
		lblPages.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		//Add new book method
		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(0, 206, 209));
		btnBack.setBounds(195, 302, 75, 25);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Home ob=new Home();
				ob.setVisible(true);
			}
		});
		btnBack.setIcon(new ImageIcon(getClass().getResource("/resource/Back-icon.png")));
		
		
		textField = new JTextField();
		textField.setBackground(new Color(173, 216, 230));
		textField.setEditable(false);
		textField.setBounds(116, 27, 86, 20);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(173, 216, 230));
		textField_1.setBounds(116, 65, 165, 20);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(173, 216, 230));
		textField_2.setBounds(116, 141, 165, 20);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(173, 216, 230));
		textField_3.setBounds(116, 224, 91, 20);
		textField_3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(173, 216, 230));
		comboBox.setBounds(116, 103, 75, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}));
		
		//add new book code action button
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(0, 206, 209));
		btnAdd.setBounds(73, 302, 79, 25);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String query="insert into book(Book_ID,BName,Edition,Publisher,NoOfCopy,Price,Pages) values(?,?,?,?,?,?,?)";
				try {
					ps=con.prepareStatement(query);
					ps.setString(1, textField.getText());
					ps.setString(2, textField_1.getText());
					ps.setString(3,(String)comboBox.getSelectedItem());
					ps.setString(4, textField_2.getText());
					ps.setString(5, textField_5.getText());
					ps.setString(6, textField_3.getText());
					ps.setString(7, textField_4.getText());
					
					ps.execute();
					JOptionPane.showMessageDialog(null, "New Book Added");
					
					
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		contentPane.setLayout(null);
		btnAdd.setIcon(new ImageIcon(getClass().getResource("/resource/new-icon.png")));
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(173, 216, 230));
		textField_4.setBounds(116, 255, 79, 20);
		textField_4.setColumns(10);
		
		JLabel lblNoOfCopies = new JLabel("No Of Copies");
		lblNoOfCopies.setForeground(Color.WHITE);
		lblNoOfCopies.setBounds(17, 179, 79, 17);
		lblNoOfCopies.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(173, 216, 230));
		textField_5.setBounds(116, 179, 91, 20);
		textField_5.setColumns(10);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(btnAdd);
		panel.add(btnBack);
		panel.add(lblPages);
		panel.add(textField_4);
		panel.add(lblBookId);
		panel.add(lblName);
		panel.add(lblEdition);
		panel.add(lblPublisher);
		panel.add(lblPrice);
		panel.add(lblNoOfCopies);
		panel.add(textField_5);
		panel.add(comboBox);
		panel.add(textField_1);
		panel.add(textField_2);
		panel.add(textField);
		panel.add(textField_3);
		
		JLabel lblNewBook = new JLabel("New Book");
		lblNewBook.setForeground(Color.WHITE);
		lblNewBook.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblNewBook.setBounds(0, 0, 132, 14);
		panel.add(lblNewBook);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(NewBook.class.getResource("/resource/860_main_library_bacteria.png")));
		label_1.setBounds(0, 0, 315, 360);
		panel.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(NewBook.class.getResource("/resource/860_main_library_bacteria.png")));
		label.setBounds(0, 0, 798, 414);
		contentPane.add(label);
		Random();
		setLocationRelativeTo(null);
	}
	public void Random() {
		java.util.Random rd= new java.util.Random();
		textField.setText("" +rd.nextInt(1000+1));
	}
}
