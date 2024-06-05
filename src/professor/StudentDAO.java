package professor;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import services.BD;

public class StudentDAO {

	private BD bd;
	private String sql, msg;

	public StudentDAO() {
		bd = new BD();
	}

	public String write(Student student) {
		// Prepares a SQL insert statement
		sql = "INSERT INTO student_tb VALUES (?,?,?,?,?,?,?,?,?,?)";
		// Default message
		msg = "Student registered successfully!";
		// Establishes a connection
		bd.getConnection();
		// Tries to insert the student into the database
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, student.getStudentName());
			bd.st.setString(2, student.getStudentLandline());
			bd.st.setString(3, student.getStudentCellphone());
			bd.st.setDate(4, student.getStudentDOB());
			bd.st.setString(5, student.getProgramOrCourse());
			bd.st.setDate(6, student.getDateOfEnrolment());
			bd.st.setString(7, student.getStudentAddress());
			bd.st.setString(8, String.valueOf(student.getStudentGender()));
			bd.st.setString(9, student.getStudentGenderIdentity());
			bd.st.setString(10, student.getStudentObs());
			int n = bd.st.executeUpdate();
			System.out.println("Inserted rows: " + n);
		} catch (SQLException e) {
			sql = "UPDATE student_tb SET student_name = ?, student_landline = ?, student_cellphone = ?, student_dob = ?, program_or_course = ?, date_of_enrolment = ?, student_address = ?, student_gender = ?, student_gender_identity = ?, student_obs = ?"
					+ " WHERE id = ?";
			try {
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setString(1, student.getStudentName());
				bd.st.setString(2, student.getStudentLandline());
				bd.st.setString(3, student.getStudentCellphone());
				bd.st.setDate(4, student.getStudentDOB());
				bd.st.setString(5, student.getProgramOrCourse());
				bd.st.setDate(6, student.getDateOfEnrolment());
				bd.st.setString(7, student.getStudentAddress());
				bd.st.setString(8, String.valueOf(student.getStudentGender()));
				bd.st.setString(9, student.getStudentGenderIdentity());
				bd.st.setString(10, student.getStudentObs());
				int studentId = Integer.parseInt(JOptionPane.showInputDialog("Enter the student ID to update entry:"));
				bd.st.setInt(11, studentId);
				int n = bd.st.executeUpdate();
				System.out.println("Updated rows: " + n);
				if (n == 1) {
					msg = "Student information updated successfully!";
				} else {
					msg = "Student not found!";
				}
			} catch (SQLException e1) {
				msg = "Error: " + e1;
			}
		} finally {
			bd.close();
		}
		return msg;
	}

	public String delete(int id) {
		sql = "DELETE FROM student_tb WHERE student_id = ?";
		bd.getConnection();
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, id);
			int n = bd.st.executeUpdate();
			System.out.println("Deleted rows: " + n);
			if (n == 1) {
				msg = "Student removed successfully!";
			} else {
				msg = "Student not found!";
			}
		} catch (SQLException e) {
			msg = "Error: " + e;
		} finally {
			bd.close();
		}
		return msg;
	}

	public List<Student> get() {
		return null;
	}

}
