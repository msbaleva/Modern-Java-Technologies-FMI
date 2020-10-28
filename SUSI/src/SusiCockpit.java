
public class SusiCockpit implements Susi{
	private int studentsCount;
	private Student[] students;
	
	public SusiCockpit() {
		students = new Student[1000];
	}
	public boolean checkStudent(Student student) {
		if(student!=null) {
			
		for(int i=0;i<studentsCount;i++) {
			if(student.getFacultyNumber() == students[i].getFacultyNumber()) {
				return true;
			}
		}
		}
		return false;
	}
	/**
	* Registers a student in the system.
	* Returns true, if the operation is successful and false, if the student
	* is already registered
	*/
	public boolean validate() {
		if(studentsCount == 1000) {
			System.out.println("Susi's capacity for students is reached.");
			return false;
		}
		return true;
	}
	public boolean registerStudent(Student student) {
		if(!checkStudent(student)){
			if(validate()) {
		
			students[studentsCount++]=student;
			return true;
		    }
		}
		return false;
	}

	/**
	 * Returns the number of registered students
	 */
	public int getStudentsCount() {
		return studentsCount;
	}
	
	/**
	* Sets a grade for the student for the specified course and adds the credits of the
	* course to the total credits of the student.
	* Returns true, if the operation is successful and false, if the student is not found
	*/
	public boolean setGrade(Student student, Course course, double grade) {
		if(checkStudent(student)) {
			return student.setGrade(course,grade);
			
		}
		return false;
	}
	
	/**
	* Returns the total sum of credits for this student
	*/
	public double getTotalCredits(Student student) {
		if(!checkStudent(student) || student==null) {
			return 0.0;
		}
		return student.getTotalCredits();
	}
	
	/**
	* Returns the grade point average for the given student
	*/
	public double getGPA(Student student) {
		if(!checkStudent(student) || student==null) {
			return 0.0;
		}
		return student.getGPA();
	}

}
