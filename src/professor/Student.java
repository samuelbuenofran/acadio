package professor;

import java.sql.Date;

/**
 * EN: This class represents a student. PT: Esta classe representa um aluno.
 */
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

	/**
	 * EN: Method to get the student ID. PT: Método para obter o ID do aluno.
	 * 
	 * @return
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * EN: Method to set the student ID. PT: Método para definir o ID do aluno.
	 * 
	 * @param studentId
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * EN: Method to get the student name. PT: Método para obter o nome do aluno.
	 * 
	 * @return
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * EN: Method to set the student name. PT: Método para definir o nome do aluno.
	 * 
	 * @param studentName
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * EN: Method to get the student landline. PT: Método para obter o telefone fixo
	 * do aluno.
	 * 
	 * @return
	 */
	public String getStudentLandline() {
		return studentLandline;
	}

	/**
	 * EN: Method to set the student landline. PT: Método para definir o telefone
	 * fixo do aluno.
	 * 
	 * @param studentLandline
	 */
	public void setStudentLandline(String studentLandline) {
		this.studentLandline = studentLandline;
	}

	/**
	 * EN: Method to get the student cellphone. PT: Método para obter o celular do
	 * aluno.
	 * 
	 * @return
	 */
	public String getStudentCellphone() {
		return studentCellphone;
	}

	/**
	 * EN: Method to set the student cellphone. PT: Método para definir o celular do
	 * aluno.
	 * 
	 * @param studentCellphone
	 */
	public void setStudentCellphone(String studentCellphone) {
		this.studentCellphone = studentCellphone;
	}

	/**
	 * EN: Method to get the student date of birth. PT: Método para obter a data de
	 * nascimento do aluno.
	 * 
	 * @return
	 */
	public Date getStudentDOB() {
		return studentDOB;
	}

	/**
	 * EN: Method to set the student date of birth. PT: Método para definir a data
	 * de nascimento do aluno.
	 * 
	 * @param studentDOB
	 */
	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}

	/**
	 * EN: Method to get the program or course. PT: Método para obter o programa ou
	 * curso.
	 * 
	 * @return
	 */
	public String getProgramOrCourse() {
		return programOrCourse;
	}

	public void setProgramOrCourse(String programOrCourse) {
		this.programOrCourse = programOrCourse;
	}

	/**
	 * EN: Method to get the date of enrolment. PT: Método para obter a data de
	 * matrícula.
	 * 
	 * @return
	 */
	public Date getDateOfEnrolment() {
		return dateOfEnrolment;
	}

	public void setDateOfEnrolment(Date dateOfEnrolment) {
		this.dateOfEnrolment = dateOfEnrolment;
	}

	/**
	 * EN: Method to get the student address. PT: Método para obter o endereço do
	 * aluno.
	 * 
	 * @return
	 */
	public String getStudentAddress() {
		return studentAddress;
	}

	/**
	 * EN: Method to set the student address. PT: Método para definir o endereço do
	 * aluno.
	 * 
	 * @param studentAddress
	 */
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	/**
	 * EN: Method to get the student's gender. PT: Método para obter o gênero do
	 * aluno.
	 * 
	 * @return
	 */
	public char getStudentGender() {
		return studentGender;
	}

	/**
	 * EN: Method to set the student's gender. PT: Método para definir o gênero do
	 * aluno.
	 * 
	 * @param studentGender
	 */
	public void setStudentGender(char studentGender) {
		this.studentGender = studentGender;
	}

	/**
	 * EN: Method to get the student's gender identity. PT: Método para obter a
	 * identidade de gênero do aluno.
	 * 
	 * @return
	 */
	public String getStudentGenderIdentity() {
		return studentGenderIdentity;
	}

	/**
	 * 
	 * EN: Method to set the student's gender identity. PT: Método para definir a
	 * identidade de gênero do aluno.
	 * 
	 * @param studentGenderIdentity
	 */
	public void setStudentGenderIdentity(String studentGenderIdentity) {
		this.studentGenderIdentity = studentGenderIdentity;
	}

	/**
	 * EN: Method to get the student's observations. PT: Método para obter as
	 * observações do aluno.
	 * 
	 * @return
	 */
	public String getStudentObs() {
		return studentObs;
	}

	/**
	 * EN: Method to set the student's observations. PT: Método para definir as
	 * observações do aluno.
	 * 
	 * @param studentObs
	 */
	public void setStudentObs(String studentObs) {
		this.studentObs = studentObs;
	}

	/**
	 * EN: Method to get the student information in String format. PT: Método para
	 * obter as informações do aluno em formato String.
	 *
	 * @return
	 */
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentLandline="
				+ studentLandline + ", studentCellphone=" + studentCellphone + ", studentDOB=" + studentDOB
				+ ", programOrCourse=" + programOrCourse + ", dateOfEnrolment=" + dateOfEnrolment + ", studentAddress="
				+ studentAddress + ", studentGender=" + studentGender + ", studentGenderIdentity="
				+ studentGenderIdentity + ", studentObs=" + studentObs + "]";
	}

	/**
	 * EN: Constructor for the Student class. PT: Construtor para a classe Student.
	 * 
	 * @param studentId
	 * @param studentName
	 * @param studentLandline
	 * @param studentCellphone
	 * @param studentDOB
	 * @param programOrCourse
	 * @param dateOfEnrolment
	 * @param studentAddress
	 * @param studentGender
	 * @param studentGenderIdentity
	 * @param studentObs
	 */
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
