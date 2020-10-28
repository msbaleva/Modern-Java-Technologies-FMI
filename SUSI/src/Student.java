
public class Student implements User{
	private String name;
	private int facultyNumber;
	private double totalCredits;
	private double GPA;
	private Course[] courses;
	private int coursesCount;
	public Student() {
		courses=new Course[50];
	}
	public boolean validate() {
		if(coursesCount == 50) {
			System.out.println(name + "'s capacity for courses is reached.");
			return false;
		}
		return true;
	}
	public boolean addCourse(Course course) {
		if(course!=null) {
			if(validate()) {
			totalCredits+=course.getCredits();
			courses[coursesCount++]=course;
			return true;
			}
		}
		return false;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getCoursesCount() {
		return coursesCount;
	}
	public int getFacultyNumber() {
		return facultyNumber;
	}
	public void setFacultyNumber(int facultyNumber) {
		this.facultyNumber=facultyNumber;
	}
	public double getTotalCredits() {
		return totalCredits;
	}
	public double getGPA() {
		return GPA;
	}
	public void updateGPA() {
		double sum=0.0;
		for(int i=0;i<coursesCount;i++) {
			sum+=courses[i].getGrade();
		}
		GPA= sum/coursesCount;
	}
	public boolean setGrade(Course course, double grade) {
		if(course!=null && checkCourse(course)) {
			course.setGrade(grade);
			updateGPA();
			return true;
		}
		return false;
	}
	public boolean checkCourse(Course course) {
		if(course!=null) {
			
		for(int i=0;i<coursesCount;i++) {
			if(course.getId() == courses[i].getId()) {
				return true;
			}
		}
		}
		return false;
	}
}
