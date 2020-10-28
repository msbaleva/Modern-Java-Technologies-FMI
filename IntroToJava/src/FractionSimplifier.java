
public class FractionSimplifier {
  public static int gcd(int n1, int n2) {
	  return (n2 == 0) ? n1 : gcd(n2,n1%n2);
  }
  public static String simplify(String fraction) {
	  String[] str = fraction.split("/");
	  int num1 = Integer.valueOf(str[0]);
	  int num2 = Integer.valueOf(str[1]);
	  if (num1 ==0) {return "0";}
	  
	  int gcd = gcd(num1,num2);
	  num1 /= gcd;
	  num2 /=gcd;
	  
	  return (num2 == 1) ? Integer.toString(num1) : Integer.toString(num1) + "/" +  Integer.toString(num2) ;
	 
  }
  
  public static void main(String[] args) {
	  System.out.println(simplify("4/6"));//"2/3"
	  System.out.println(simplify("10/11"));//"10/11"
	  System.out.println(simplify("100/400"));	//"1/4"
	  System.out.println(simplify("8/4"));	//"2"
	  System.out.println(simplify("4/8"));
	  System.out.println(simplify("0/8"));
  }
}
