import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Color;



public class load extends JFrame implements Runnable{
	int s=0;
	Thread th;
	JProgressBar jb;
	public load() {
		super("loading");
		getContentPane().setBackground(Color.WHITE);
		th= new Thread((Runnable) this);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(205, 28, 415, 289);
		panel.setBackground(Color.WHITE);
		 jb= new JProgressBar(0,100);
		 jb.setBounds(106, 80, 196, 17);
		 jb.setStringPainted(true);
		
		
		JLabel lblsmartLibrary = new JLabel("#SmArt Library1.0");
		lblsmartLibrary.setBounds(10, 0, 399, 62);
		lblsmartLibrary.setForeground(new Color(255, 255, 255));
		lblsmartLibrary.setFont(new Font("Jokerman", Font.BOLD, 40));
		
		JLabel lblPleaseWait = new JLabel("Please wait...");
		lblPleaseWait.setForeground(new Color(255, 255, 255));
		lblPleaseWait.setBounds(177, 108, 66, 14);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.add(lblsmartLibrary);
		panel.add(jb);
		panel.add(lblPleaseWait);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(load.class.getResource("/resource/book2.gif")));
		label_1.setBounds(-46, 0, 518, 289);
		panel.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(load.class.getResource("/resource/nat2 (2).jpg")));
		label.setBounds(0, 0, 764, 351);
		getContentPane().add(label);
		//add(b);
		setSize(780,390);
		setLocationRelativeTo(null);
	}
	public void setUpLoading() {
		setVisible(false);
		th.start();
	}
	public void run() {
		try {
			for(int i=1;i<=200;i++) {
				s=s+1;
				int m=jb.getMaximum();
				int v=jb.getValue();
				if(v<m) {
					jb.setValue(jb.getValue()+1);
				}
				else {
					i=201;
					setVisible(false);
					Home ob= new Home();
					ob.setVisible(true);
				}Thread.sleep(50);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	
	public static void main(String[] args) {
		load l =new load();
		l.setVisible(true);
		
	}
}
