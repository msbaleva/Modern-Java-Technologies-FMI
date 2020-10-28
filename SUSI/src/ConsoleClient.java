import java.util.Scanner;

public class ConsoleClient {
	public static void register() {
		Student student = new Student();
		Scanner sc = new Scanner(System.in);
		System.out.println("Въвдете име:");
		
		System.out.println("Въведете факултетен номер:");
		int input = sc.nextInt();
		student.setFacultyNumber(input);
		
		 
	}
	public static void main(String[] args) {
		System.out.println("~СУСИ~");
		System.out.println("-> 1.Нов студент");
		System.out.println("-> 2.Обнови оценка");
		System.out.println("-> 3.Справки");
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<1000000000;i++) {
		 int input = sc.nextInt();
		 switch (input) {
		  case 1: register(); break;
		  //case 2: grade(); break;
		  //case 3: lookup(); break;
		  default: System.out.println("No such option./Pick an option.");
		 
		 }
		}
		sc.close();
	}

}
