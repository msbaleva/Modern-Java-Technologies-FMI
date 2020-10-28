import java.util.Arrays;

public class Anagram {
	public static boolean isAnagram(String input) {
		String[] str=input.split(" ");
		char[] str1 = str[0].toLowerCase().toCharArray();
		char[] str2 = str[1].toLowerCase().toCharArray();
		Arrays.sort(str1);
		Arrays.sort(str2);
		return (String.valueOf(str1).equals(String.valueOf(str2))) ? true : false;
	}
	
	public static void main(String[] args) {
		System.out.println(isAnagram("eaT ate$"));
	}

}
