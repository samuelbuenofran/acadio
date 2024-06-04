package professor;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import services.BD;
import services.MyTableModel;

public class StudentManagement extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTable studentTable;
	private DefaultTableModel model;
	// I don't know what 'sp' stands for in this case
	// I'm going to assume it's a JScrollPane
	// This is the scroll pane that will contain the query table
	private JScrollPane studentSP;
	private BD bd;
	private JTextField textFieldStudentName;
	private JTextField textFieldStudentLandline;
	private JTextField textFieldStudentCellphoneNumber;
	private JTextField textFieldProgramOrCourse;
	private JTextField textFieldStudentAddress;
	// private JTextField filterTF;
	private JTextField textFieldStudentGenderIdentity;
	private JTextField textFieldStudentObs;
	private JTextField textFieldStudentSearch;
	/**
	 * @wbp.nonvisual location=377,-31
	 */
//	private final JButton button = new JButton("New button");

	/**
	 * Create the panel.
	 */
	public StudentManagement() {
		setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 41, 580, 448);
		add(tabbedPane);

		JTabbedPane viewTableTP = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Student Management", null, viewTableTP, null);

		JTabbedPane addStudentTP = new JTabbedPane(JTabbedPane.TOP);
		addStudentTP.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		addStudentTP.setToolTipText("Add a student.");
		tabbedPane.addTab("Add Student", null, addStudentTP, null);

		JPanel addStudentPanel = new JPanel();
		addStudentTP.addTab("Add Student to Database", null, addStudentPanel, null);
		addStudentTP.setEnabledAt(0, true);
		addStudentPanel.setLayout(null);

		JLabel lblStudentName = new JLabel("Student Name:");
		lblStudentName.setBounds(10, 11, 85, 14);
		addStudentPanel.add(lblStudentName);

		textFieldStudentName = new JTextField();
		textFieldStudentName.setToolTipText("Enter the student's name.");
		textFieldStudentName.setText("John Doe");
		textFieldStudentName.setBounds(194, 8, 170, 20);
		addStudentPanel.add(textFieldStudentName);
		textFieldStudentName.setColumns(10);

		JLabel lblStudentLandline = new JLabel("Student landline telephone number:");
		lblStudentLandline.setBounds(10, 37, 178, 14);
		addStudentPanel.add(lblStudentLandline);

		textFieldStudentLandline = new JTextField();
		textFieldStudentLandline.setColumns(10);
		textFieldStudentLandline.setBounds(194, 34, 170, 20);
		addStudentPanel.add(textFieldStudentLandline);

		JLabel lblStudentCellphone = new JLabel("Student cellphone number:");
		lblStudentCellphone.setBounds(10, 65, 142, 14);
		addStudentPanel.add(lblStudentCellphone);

		textFieldStudentCellphoneNumber = new JTextField();
		textFieldStudentCellphoneNumber.setColumns(10);
		textFieldStudentCellphoneNumber.setBounds(194, 62, 170, 20);
		addStudentPanel.add(textFieldStudentCellphoneNumber);

		JLabel lblStudentDateOf = new JLabel("Student date of birth:");
		lblStudentDateOf.setBounds(10, 97, 142, 14);
		addStudentPanel.add(lblStudentDateOf);

		JDateChooser dateChooserStudentDOB = new JDateChooser();
		dateChooserStudentDOB.setDateFormatString("yyyy-MM-dd");
		dateChooserStudentDOB.setBounds(194, 94, 170, 20);
		addStudentPanel.add(dateChooserStudentDOB);

		JLabel lblProgramOrCourse = new JLabel("Program or course:");
		lblProgramOrCourse.setBounds(10, 128, 142, 14);
		addStudentPanel.add(lblProgramOrCourse);

		textFieldProgramOrCourse = new JTextField();
		textFieldProgramOrCourse.setColumns(10);
		textFieldProgramOrCourse.setBounds(194, 125, 170, 20);
		addStudentPanel.add(textFieldProgramOrCourse);

		JLabel lblStudentDOE = new JLabel("Student date of enrolment:");
		lblStudentDOE.setBounds(10, 163, 142, 14);
		addStudentPanel.add(lblStudentDOE);

		JDateChooser dateChooserStudentDOE = new JDateChooser();
		dateChooserStudentDOE.setDateFormatString("yyyy-MM-dd");
		dateChooserStudentDOE.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		dateChooserStudentDOE.setToolTipText("Enter a date of enrolment.");
		dateChooserStudentDOE.setBounds(193, 157, 171, 20);
		addStudentPanel.add(dateChooserStudentDOE);

		JButton clearButton = new JButton("Clear");
		clearButton.setBounds(120, 343, 89, 23);
		addStudentPanel.add(clearButton);

		JButton insertButton = new JButton("Insert");
		insertButton.setBounds(21, 343, 89, 23);
		addStudentPanel.add(insertButton);

		JLabel lblStudentAddress = new JLabel("Student address:");
		lblStudentAddress.setBounds(10, 197, 85, 14);
		addStudentPanel.add(lblStudentAddress);

		textFieldStudentAddress = new JTextField();
		textFieldStudentAddress.setColumns(10);
		textFieldStudentAddress.setBounds(194, 194, 170, 20);
		addStudentPanel.add(textFieldStudentAddress);

		JLabel lblStudentGender = new JLabel("Student gender:");
		lblStudentGender.setBounds(10, 233, 85, 14);
		addStudentPanel.add(lblStudentGender);

		JComboBox comboBoxStudentGender = new JComboBox();
		comboBoxStudentGender.setModel(new DefaultComboBoxModel(new String[] { "M", "F", "N" }));
		comboBoxStudentGender.setMaximumRowCount(3);
		comboBoxStudentGender.setBounds(194, 229, 39, 22);
		addStudentPanel.add(comboBoxStudentGender);

		JLabel lblGenderInfo = new JLabel("*\"N\" means \"non-binary\".");
		lblGenderInfo.setBounds(243, 233, 128, 14);
		addStudentPanel.add(lblGenderInfo);

		JLabel lblStudentGenderIdentity = new JLabel("Student gender identity:");
		lblStudentGenderIdentity.setBounds(10, 268, 142, 14);
		addStudentPanel.add(lblStudentGenderIdentity);

		textFieldStudentGenderIdentity = new JTextField();
		textFieldStudentGenderIdentity.setColumns(10);
		textFieldStudentGenderIdentity.setBounds(194, 265, 170, 20);
		addStudentPanel.add(textFieldStudentGenderIdentity);

		JLabel lblStudentObs = new JLabel("Observations:");
		lblStudentObs.setBounds(10, 299, 142, 14);
		addStudentPanel.add(lblStudentObs);

		textFieldStudentObs = new JTextField();
		textFieldStudentObs.setToolTipText("Additional health related information.");
		textFieldStudentObs.setColumns(10);
		textFieldStudentObs.setBounds(194, 296, 170, 20);
		addStudentPanel.add(textFieldStudentObs);

		JButton updateButton = new JButton("Update");
		updateButton.setBounds(228, 343, 89, 23);
		addStudentPanel.add(updateButton);

		JPanel panel = new JPanel();
		addStudentTP.addTab("Update Student", null, panel, null);
		panel.setLayout(null);

		// Code to search for a student
		// The filtered search will appear here
		JPanel viewAndUpdateStudentPane = new JPanel();
		viewAndUpdateStudentPane.setBounds(10, 29, 495, 324);
		panel.add(viewAndUpdateStudentPane);
		viewAndUpdateStudentPane.setLayout(null);
		viewAndUpdateStudentPane.setToolTipText("View and update student information.");
		viewAndUpdateStudentPane.setBorder(null);

		JLabel lblStudentSearch = new JLabel("Search for a student:");
		lblStudentSearch.setBounds(10, 11, 149, 14);
		panel.add(lblStudentSearch);

		textFieldStudentSearch = new JTextField();
		textFieldStudentSearch.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				String sql = "SELECT * FROM student_tb WHERE student_name " + "LIKE '%"
						+ textFieldStudentSearch.getText() + "%'";
				model = MyTableModel.getModel(bd, sql);
				studentTable.setModel(model);

			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});
		textFieldStudentSearch.setBounds(190, 8, 175, 20);
		panel.add(textFieldStudentSearch);
		textFieldStudentSearch.setColumns(10);
		JLabel lblNewLabel = new JLabel("Student Management");
		lblNewLabel.setBounds(219, 5, 185, 25);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		add(lblNewLabel);
		setBounds(100, 100, 600, 500);

		studentTable = new JTable();
		bd = new BD();
		if (bd.getConnection()) {
			loadTable();
		} else {
			JOptionPane.showMessageDialog(studentSP, "Error connecting to the database!");
			System.exit(0);
		}

		// Adding the table to the already existing tabbed pane
		viewTableTP.add(studentSP, BorderLayout.CENTER);
		// TODO: Rename the tab label "Center", to something more meaningful
		viewTableTP.setTitleAt(0, "Students");

		JTabbedPane deleteStudentTP = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Delete Student", null, deleteStudentTP, null);

	}

	// Loads the student table
	private void loadTable() {
		String sql = "SELECT * FROM student_tb";
		model = MyTableModel.getModel(bd, sql);
		studentTable.setModel(model);
		studentSP = new JScrollPane(studentTable);
		add(studentSP, BorderLayout.CENTER);

	}
}
// https://web.archive.org/web/20131127023032/http://toedter.com/en/jcalendar/index.html