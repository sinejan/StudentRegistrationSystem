package pack1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblUser;
	User activeUser;
	
	public void setUser(User u) {
		activeUser = u;
		lblUser.setText("Hello "+activeUser.getName());
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("Main Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUser = new JLabel("");
		lblUser.setBounds(25, 32, 138, 14);
		contentPane.add(lblUser);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setBounds(305, 227, 119, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Admin Panel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(activeUser.getUserRole().equals("admin")) {
					AdminPage ap = new AdminPage();
					ap.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "No admin rights!");
				}
				
				
			}
		});
		btnNewButton_1.setBounds(305, 202, 119, 23);
		contentPane.add(btnNewButton_1);
	}

}
