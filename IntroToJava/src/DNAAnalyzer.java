
public class DNAAnalyzer {
	public static String longestRepeatingSequence(String dna) {
		int n = dna.length();
		int[][] lens = new int[n + 1][n + 1];
		int len = 0;
		String result = new String();
		int max = 0;
		int i;
		for (i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (dna.charAt(i - 1) == dna.charAt(j - 1) && lens[i - 1][j - 1] < (j - i)) {
					lens[i][j] = lens[i - 1][j - 1] + 1;
					if (lens[i][j] > len) {
						len = lens[i][j];
						max = Math.max(i, max);
					}
				} else {
					lens[i][j] = 0;
				}
			}
		}

		if (len > 0) {
			for (i = max - len + 1; i <= max; i++) {
				result += dna.charAt(i - 1);
			}
		}

		return result;

	}

	public static void main(String[] args) {
		String dna = "ATACTCGGTACTCT";
		System.out.println(longestRepeatingSequence(dna));
	}
}
