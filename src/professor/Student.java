package professor;

import java.sql.Date;

public class Student {

	private int studentId;
	private String studentName;
	private String studentLandline;
	private String studentCellphone;
	private Date studentDOB;
	private String programOrCourse;
	private Date dateOfEnrolment;
	private String studentAddress;
	private char studentGender;// M for male, F for female, N for non-binary
	private String studentGenderIdentity;
	private String studentObs;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentLandline() {
		return studentLandline;
	}

	public void setStudentLandline(String studentLandline) {
		this.studentLandline = studentLandline;
	}

	public String getStudentCellphone() {
		return studentCellphone;
	}

	public void setStudentCellphone(String studentCellphone) {
		this.studentCellphone = studentCellphone;
	}

	public Date getStudentDOB() {
		return studentDOB;
	}

	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}

	public String getProgramOrCourse() {
		return programOrCourse;
	}

	public void setProgramOrCourse(String programOrCourse) {
		this.programOrCourse = programOrCourse;
	}

	public Date getDateOfEnrolment() {
		return dateOfEnrolment;
	}

	public void setDateOfEnrolment(Date dateOfEnrolment) {
		this.dateOfEnrolment = dateOfEnrolment;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public char getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(char studentGender) {
		this.studentGender = studentGender;
	}

	public String getStudentGenderIdentity() {
		return studentGenderIdentity;
	}

	public void setStudentGenderIdentity(String studentGenderIdentity) {
		this.studentGenderIdentity = studentGenderIdentity;
	}

	public String getStudentObs() {
		return studentObs;
	}

	public void setStudentObs(String studentObs) {
		this.studentObs = studentObs;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentLandline="
				+ studentLandline + ", studentCellphone=" + studentCellphone + ", studentDOB=" + studentDOB
				+ ", programOrCourse=" + programOrCourse + ", dateOfEnrolment=" + dateOfEnrolment + ", studentAddress="
				+ studentAddress + ", studentGender=" + studentGender + ", studentGenderIdentity="
				+ studentGenderIdentity + ", studentObs=" + studentObs + "]";
	}

	public Student(int studentId, String studentName, String studentLandline, String studentCellphone, Date studentDOB,
			String programOrCourse, Date dateOfEnrolment, String studentAddress, char studentGender,
			String studentGenderIdentity, String studentObs) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentLandline = studentLandline;
		this.studentCellphone = studentCellphone;
		this.studentDOB = studentDOB;
		this.programOrCourse = programOrCourse;
		this.dateOfEnrolment = dateOfEnrolment;
		this.studentAddress = studentAddress;
		this.studentGender = studentGender;
		this.studentGenderIdentity = studentGenderIdentity;
		this.studentObs = studentObs;
	}

}
