package professor;

import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import services.BD;

/**
 * EN: This class represents the main dashboard panel for the Professor user
 * type. PT: Esta classe representa o painel principal do painel de controle
 * para o tipo de usuário Professor.
 */
public class MainDashboardPanel extends JPanel {

	/**
	 * EN: Serial version UID for serialization. PT: UID de versão serial para a
	 * serialização.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * EN: Constructor for the MainDashboardPanel class. It creates the panel and
	 * its content. PT: Construtor para a classe MainDashboardPanel. Ele cria o
	 * painel e seu conteúdo.
	 */
	public MainDashboardPanel() {
		setLayout(null);

		JLabel lblMessagingElement = new JLabel("");
		lblMessagingElement
				.setIcon(new ImageIcon(DashboardProfessor.class.getResource("/images/Messages_UI_Element.png")));
		lblMessagingElement.setBounds(64, 5, 304, 278);
		add(lblMessagingElement);

		JLabel lblScheduleElement = new JLabel("");
		lblScheduleElement.setIcon(
				new ImageIcon(DashboardProfessor.class.getResource("/images/Scheduled_Classes_UI_Element.png")));
		lblScheduleElement.setBounds(454, 5, 304, 278);
		add(lblScheduleElement);

		JLabel lblCalendarElement = new JLabel("");
		lblCalendarElement
				.setIcon(new ImageIcon(DashboardProfessor.class.getResource("/images/Calendar_UI_Element.png")));
		lblCalendarElement.setBounds(64, 316, 304, 364);
		add(lblCalendarElement);

		JLabel lblBacklogElement = new JLabel("");
		lblBacklogElement.setIcon(
				new ImageIcon(DashboardProfessor.class.getResource("/images/Backlog_Scheduled_UI_Element.png")));
		lblBacklogElement.setBounds(454, 316, 304, 338);
		add(lblBacklogElement);

//		JLabel lblTest = new JLabel("This is a test for home.");
//		add(lblTest);

	}

	/**
	 * EN: The main method for the MainDashboardPanel class. It creates the window
	 * and sets its visibility. PT: O método principal para a classe
	 * MainDashboardPanel. Ele cria a janela e define sua visibilidade.
	 */
	public static void main(String[] args) {
		BD bd = new BD();
		if (bd.getConnection()) {
			// String sql = "SELECT * FROM student_tb WHERE student_id = ?";
			String sql = "SELECT student_id, student_name, student_landline, student_cellphone, student_dob, program_or_course, date_of_enrolment, student_address, student_gender, student_gender_identity, student_obs FROM student_tb WHERE student_id = ?";
			try {
				bd.st = bd.con.prepareStatement(sql);
				// Define the value of the first parameter
				// (Param1, Value1)
				bd.st.setInt(1, 1);
				// Define the value of the second parameter
				// bd.st.setInt(2, 1);
				bd.rs = bd.st.executeQuery();

				while (bd.rs.next()) {
					System.out.println(bd.rs.getInt(1)); // Student ID

					System.out.println(bd.rs.getString(2)); // Student Name

					System.out.println(bd.rs.getString(3)); // Student Landline

					System.out.println(bd.rs.getString(4)); // Student Cellphone

					System.out.println(bd.rs.getDate(5)); // Date of Birth

					System.out.println(bd.rs.getString(6)); // Program or Course

					System.out.println(bd.rs.getDate(7)); // Date of Enrolment

					System.out.println(bd.rs.getString(8)); // Student Address

					System.out.println(bd.rs.getString(9)); // Student Gender

					System.out.println(bd.rs.getString(10)); // Student Gender Identity

					System.out.println(bd.rs.getString(11)); // Student Observations
					System.out.println("--------------------");
				}

			} catch (SQLException e) {
				System.out.println(e);
			} finally {
				bd.close();
			}
		}
	}

}

/*
 * Please, provide data for the following: student_id INT PRIMARY KEY,
 * student_name NVARCHAR(100) NOT NULL, student_landline VARCHAR(20),
 * student_cellphone VARCHAR(20), student_dob DATE, program_or_course
 * NVARCHAR(50), date_of_enrolment DATE, student_address NVARCHAR(100),
 * student_gender CHAR(1) CHECK (student_gender IN ('M', 'F', 'N')), -- Limit to
 * M, F or N student_gender_identity NVARCHAR(50), student_obs NVARCHAR(MAX)
 */
