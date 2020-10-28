
public class Course implements Subject{
	private String name;
	private String id;
	private double grade;
	private double credits;
	public Course() {
		
	}
	public void setId(String id) {
		this.id=id;
	}
	public String getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setGrade(double grade) {
		this.grade=grade;
	}
	public double getGrade() {
		return grade;
	}
	public void setCredits(double credits) {
		this.credits=credits;
	}
	public double getCredits() {
		return credits;
	}

}
