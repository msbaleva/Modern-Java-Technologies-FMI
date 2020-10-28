
public class StockExchange {

	public static int maxProfit(int[] prices) {
		int len = prices.length;
		return maxProfitRec(prices, 0, len - 1);
	}

	public static int maxProfitRec(int[] prices, int start, int end) {

		if (end <= start)
			return 0;

		int profit = 0;

		for (int i = start; i < end; i++) {

			for (int j = i + 1; j <= end; j++) {

				if (prices[j] > prices[i]) {

					int currentProfit = prices[j] - prices[i] + maxProfitRec(prices, start, i - 1)
							+ maxProfitRec(prices, j + 1, end);

					profit = Math.max(profit, currentProfit);
				}
			}
		}
		return profit;
	}

	public static void main(String[] args) {
		int prices[] = { 7, 6, 4, 3, 1 };
		System.out.println(maxProfit(prices));

	}

}
