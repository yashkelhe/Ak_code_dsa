package array;

public class share_market {

    public static int shareMarket(int price[]) {
        int buypricing = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < price.length; i++) {
            if (buypricing < price[i]) {
                int profit = price[i] - buypricing;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buypricing = price[i];
            }
        }
        return maxProfit;

    }

    public static void main(String[] args) {
        int price[] = { 7, 1, 5, 3, 6, 4 };
        System.out.print("the maximum profit is :");
        System.out.println(shareMarket(price));

    }
}
