package pack1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;

public class xxx extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					xxx frame = new xxx();
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
	public xxx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 635);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("name");
		lblNewLabel.setBounds(30, 57, 110, 51);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(173, 72, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(197, 129, 30, 22);
		contentPane.add(comboBox);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(98, 192, 111, 23);
		contentPane.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setActionCommand("MALE");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setBounds(116, 241, 111, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setActionCommand("FEMALE");
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(26, 391, 89, 23);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(390, 257, 110, 133);
		contentPane.add(textArea);
		
		JList list = new JList();
		list.setBounds(539, 232, 131, 146);
		contentPane.add(list);
		
		JButton btn_getList = new JButton("get list");
		btn_getList.setBounds(411, 491, 89, 23);
		contentPane.add(btn_getList);
	}
}
