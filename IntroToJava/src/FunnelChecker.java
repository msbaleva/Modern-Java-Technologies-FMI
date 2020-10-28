

public class FunnelChecker {
	public static boolean isFunnel(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		if (len1 != (len2 +1)) {return false;}
		if (str1.substring(1,len1).equals(str2)) {
			return true;
		} else if  (str1.substring(0,len1-1).equals(str2)) {
			return true;
		}
		for(int i=0;i<=len2;i++) {
			if(str1.charAt(i) != str2.charAt(i)) {
				if ((str1.substring(0,i) + str1.substring(i+1,len1)).equals(str2)) {
					return true;
				} else {
					return false;
				}
			}
			
		}
		return false;
	}
   public static void main(String[] args) {
	   System.out.println(isFunnel("leave","eave")); // true
	   System.out.println(isFunnel("reset", "rest"));	//true
	   System.out.println(isFunnel("dragoon", "dragon"));	//true
	   System.out.println(isFunnel("eave", "leave"));	//false
	   System.out.println(isFunnel("sleet", "lets"));	//false
	   System.out.println(isFunnel("skiff", "ski"));//false
   }
   
}
