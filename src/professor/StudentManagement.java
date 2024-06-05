package professor;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	// This is the database connection
	// Instantiating this class will connect to the database due to its constructor
	private BD bd = new BD(); // Create BD instance outside of the constructor
	private JTextField textFieldStudentName;
	private JTextField textFieldStudentLandline;
	private JTextField textFieldStudentCellphoneNumber;
	private JTextField textFieldProgramOrCourse;
	private JTextField textFieldStudentAddress;
	private JTextField textFieldStudentGenderIdentity;
	private JTextField textFieldStudentObs;
	private JTextField textFieldStudentId;
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
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		dateChooserStudentDOE.setToolTipText("Enter a date of enrolment.");
		dateChooserStudentDOE.setBounds(193, 157, 171, 20);
		addStudentPanel.add(dateChooserStudentDOE);

		JButton clearButton = new JButton("Clear");
		clearButton.setBounds(129, 343, 89, 23);
		addStudentPanel.add(clearButton);

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

		String[] genderChar = { "M", "F", "N" };

		// Combo box for student
		JComboBox<String> comboBoxStudentGender = new JComboBox<>(genderChar);
		comboBoxStudentGender.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		comboBoxStudentGender.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		comboBoxStudentGender.setToolTipText("Select the student's gender");

		comboBoxStudentGender.setModel(new DefaultComboBoxModel<String>(new String[] { "M", "F", "N" }));
		comboBoxStudentGender.setMaximumRowCount(3);
		comboBoxStudentGender.setBounds(194, 229, 40, 22);

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

		JLabel lblStudentId = new JLabel("Enter the student's ID:");
		lblStudentId.setBounds(10, 11, 149, 14);
		panel.add(lblStudentId);

		textFieldStudentId = new JTextField();
		textFieldStudentId.setText("Student ID");
		textFieldStudentId.setToolTipText("Enter a student ID.");

		textFieldStudentId.setBounds(190, 8, 175, 20);
		panel.add(textFieldStudentId);
		textFieldStudentId.setColumns(10);
		JLabel lblNewLabel = new JLabel("Student Management");
		lblNewLabel.setBounds(219, 5, 185, 25);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		add(lblNewLabel);
		setBounds(100, 100, 600, 500);

		JButton insertButton = new JButton("Insert");
		insertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (bd.getConnection()) {
					String sql = "INSERT INTO student_tb (student_name, student_landline, student_cellphone, student_dob, program_or_course, date_of_enrolment, student_address, student_gender, student_gender_identity, student_obs) VALUES (?,?,?,?,?,?,?,?,?,?)";
					// Getting the text data from the fields
					String studentName = textFieldStudentName.getText();
					String studentLandline = textFieldStudentLandline.getText();
					String studentCellphone = textFieldStudentCellphoneNumber.getText();
					java.sql.Date studentDOB = new java.sql.Date(dateChooserStudentDOB.getDate().getTime());
					String programOrCourse = textFieldProgramOrCourse.getText();
					java.sql.Date dateOfEnrolment = new java.sql.Date(dateChooserStudentDOE.getDate().getTime());
					String studentAddress = textFieldStudentAddress.getText();
					// Getting the selected item from the combo box
					String studentGender = comboBoxStudentGender.getSelectedItem().toString();
					String studentGenderIdentity = textFieldStudentGenderIdentity.getText();
					String studentObs = textFieldStudentObs.getText();

					try {
						bd.st = bd.con.prepareStatement(sql);
						// Omit setting the first parameter (student ID)
						bd.st.setString(1, studentName);
						bd.st.setString(2, studentLandline);
						bd.st.setString(3, studentCellphone);
						bd.st.setDate(4, studentDOB);
						bd.st.setString(5, programOrCourse);
						bd.st.setDate(6, dateOfEnrolment);
						bd.st.setString(7, studentAddress);
						bd.st.setString(8, studentGender);
						bd.st.setString(9, studentGenderIdentity);
						bd.st.setString(10, studentObs);
						bd.st.executeUpdate();
						JOptionPane.showMessageDialog(insertButton, "Student inserted successfully!");
						loadTable();
					} catch (Exception error1) {
						JOptionPane.showMessageDialog(insertButton, "Error inserting student!");
						System.out.println(error1);
					} finally {
						bd.close();
					}
				}
			}
		});
		insertButton.setBounds(21, 343, 89, 23);
		addStudentPanel.add(insertButton);

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
		viewTableTP.setTitleAt(1, "Students");

		JPanel viewStudentsPanel = new JPanel();
		viewTableTP.addTab("View Students", null, viewStudentsPanel, null);

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