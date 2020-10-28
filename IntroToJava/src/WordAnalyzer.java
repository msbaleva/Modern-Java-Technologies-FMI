import java.util.Arrays;

public class WordAnalyzer {
	public static String getSharedLetters(String word1, String word2) {
		int len = word1.length();
		 word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		StringBuilder result=new StringBuilder();
		for(int i=0;i<len;i++) {
			if(word2.contains(String.valueOf(word1.charAt(i))) && !result.toString().contains(String.valueOf(word1.charAt(i)))) {
				result.append(word1.charAt(i));
			}
		}
		/*
		
		for(int i=1;i<len1+len2;i++) {
			if(((result.substring(0,i) + result.substring(i+1,len1+len2)).contains(String.valueOf(result.charAt(i))))!=true){
				finalresult = finalresult + String.valueOf(result.charAt(i));
			}
		}
		*/
		char[] fresult = result.toString().toCharArray();
		Arrays.sort(fresult);
		return String.valueOf(fresult);
	}
	
	public static void main(String[] args) {
		System.out.println(getSharedLetters("house", "home"));	//"eho"
		System.out.println(getSharedLetters("Micky", "mouse"));	//"m"
		System.out.println(getSharedLetters("house", "villa"));//""
	}
}
