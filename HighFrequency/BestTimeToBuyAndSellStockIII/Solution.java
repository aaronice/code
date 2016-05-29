import java.util.*;

public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // find maxProfit for {0, j}, find maxProfit for {j + 1, n - 1}
        // find max for {max{0, j}, max{j + 1, n - 1}}

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maximumProfit = 0;
        int n = prices.length;

        ArrayList<Profit> preMaxProfit = new ArrayList<Profit>(n);
        ArrayList<Profit> postMaxProfit = new ArrayList<Profit>(n);
        for (int i = 0; i < n; i++) {
            preMaxProfit.add(maxProfitHelper(prices, 0, i));
            postMaxProfit.add(maxProfitHelper(prices, i + 1, n - 1));
        }
        for (int i = 0; i < n; i++) {
            int profit = preMaxProfit.get(i).maxProfit + postMaxProfit.get(i).maxProfit;
            maximumProfit = Math.max(profit, maximumProfit);
        }
        return maximumProfit;
    }

    private Profit maxProfitHelper(int[] prices, int startIndex, int endIndex) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return new Profit(maxProfit, minPrice);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{4,4,6,1,1,4,2,5};
        Solution s = new Solution();
        System.out.println(s.maxProfit(prices));
    }
};

class Profit {
    int maxProfit, minPrice;
    Profit(int maxProfit, int minPrice) {
        this.maxProfit = maxProfit;
        this.minPrice = minPrice;
    }
}
