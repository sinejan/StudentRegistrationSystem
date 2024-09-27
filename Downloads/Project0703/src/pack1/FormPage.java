package pack1;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtSurname;
	ArrayList<Student> students = new ArrayList<Student>();
	String details;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					FormPage frame = new FormPage();
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
	public FormPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 36, 46, 14);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(84, 33, 86, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(10, 67, 78, 14);
		contentPane.add(lblSurname);
		
		txtSurname = new JTextField();
		txtSurname.setColumns(10);
		txtSurname.setBounds(84, 64, 86, 20);
		contentPane.add(txtSurname);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(10, 113, 46, 14);
		contentPane.add(lblAge);
		
		JComboBox cbAge = new JComboBox();
		cbAge.setBounds(84, 109, 46, 22);
		contentPane.add(cbAge);
		
		for(int age=18; age<=65; age++) {
			cbAge.addItem(age);
		}
		
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(10, 152, 46, 14);
		contentPane.add(lblgender);
		
		JRadioButton rdMale = new JRadioButton("Male");
		rdMale.setBounds(84, 148, 109, 23);
		contentPane.add(rdMale);
		rdMale.setActionCommand("Male");
		
		
		JRadioButton rdFemale = new JRadioButton("Female");
		rdFemale.setBounds(84, 173, 109, 23);
		contentPane.add(rdFemale);
		rdFemale.setActionCommand("Female");
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(rdFemale);
		genderGroup.add(rdMale);
		
		
		
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(10, 209, 78, 14);
		contentPane.add(lblDepartment);
		
		//String [] departments = {"Computing","History","Art"};
		
		DefaultComboBoxModel<String> cbModel = new DefaultComboBoxModel<String>();
		cbModel.addElement("Business");
		cbModel.addElement("Computing");
		cbModel.addElement("Literature");
		
		JComboBox cbDept = new JComboBox();
		cbDept.setModel(cbModel);
		cbDept.setBounds(84, 205, 86, 22);
		contentPane.add(cbDept);
		/*cbDept.addItem("Item 1");
		cbDept.addItem("Item 2");
		cbDept.addItem("Item 3");*/
		
		JLabel lblLanguages = new JLabel("Languages");
		lblLanguages.setBounds(196, 36, 73, 14);
		contentPane.add(lblLanguages);
		
		JCheckBox chEnglish = new JCheckBox("English");
		chEnglish.setBounds(188, 63, 97, 23);
		contentPane.add(chEnglish);
		chEnglish.setActionCommand("English");
		
		JCheckBox chGerman = new JCheckBox("German");
		chGerman.setBounds(188, 84, 97, 23);
		contentPane.add(chGerman);
		chGerman.setActionCommand("German");
		
		JCheckBox chSpanish = new JCheckBox("Spanish");
		chSpanish.setBounds(188, 104, 97, 23);
		contentPane.add(chSpanish);
		chSpanish.setActionCommand("Spanish");
		
		ArrayList<JCheckBox> boxes = new ArrayList<JCheckBox>();
		boxes.add(chEnglish);
		boxes.add(chGerman);
		boxes.add(chSpanish);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = txtName.getText();
				String surname = txtSurname.getText();
				String department = cbDept.getSelectedItem().toString();
				int age = Integer.parseInt(cbAge.getSelectedItem().toString());
				
				String gender = genderGroup.getSelection().getActionCommand();
				String languages = ""; 
				
				for (JCheckBox box : boxes) {
					if(box.isSelected()) {
						languages += box.getActionCommand()+" ";
					}
				}
				
				Student stu = new Student(name, surname, gender, department,
						languages, age);
				students.add(stu);
				JOptionPane.showMessageDialog(contentPane, "Student Saved");
				System.out.println(students);
			}
		});
		btnSave.setBounds(180, 205, 89, 23);
		contentPane.add(btnSave);
		
		JLabel lblNewLabel = new JLabel("Student List");
		lblNewLabel.setBounds(279, 36, 73, 14);
		contentPane.add(lblNewLabel);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(372, 67, 92, 99);
		contentPane.add(textArea);
		
		JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String selectedStudent = list.getSelectedValue().toString();
				details = "";
				students.stream()
					    .filter(s->(s.name+" "+s.surname).equals(selectedStudent))
						.forEach(s->{
							details += s.name+" "+s.surname+"\n"+
									   s.age+" "+s.gender+"\n"+
									   s.department+"\n"+
									   s.languages;
						});
				textArea.setText(details);
			}
		});
		list.setModel(listModel);
		list.setBounds(284, 66, 78, 130);
		contentPane.add(list);
		
		
		
		JButton btnGetList = new JButton("Get List");
		btnGetList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.removeAllElements();
				students.forEach(s->{
					listModel.addElement(s.name+" "+s.surname);
				});
				
			}
		});
		btnGetList.setBounds(279, 205, 89, 23);
		contentPane.add(btnGetList);
		
		JLabel lblNewLabel_1 = new JLabel("Student Details");
		lblNewLabel_1.setBounds(375, 36, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		
	}
}
