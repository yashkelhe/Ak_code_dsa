package array;

public class share_market {

    public static int shareMarket(int price[]) {
        int buypricing = Integer.MAX_VALUE;// infinity
        int maxProfit = 0;

        // ioteration
        // index - buypricing
        // 0 - 7
        // 1- 1
        // condition true porfit will be 5 - 1 = 4
        // condition true porfit will be 3 - 1 = 2 but the max is 4
        // condition true porfit will be 6- 1 = 5 now the max is 5
        // condition true porfit will be 4 - 1 = 3 but the max is 5
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
