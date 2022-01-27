package test;

public class test_기출1 {

    public static void main(String[] args) {

        int [] stock_price1 = {2,1,2,3,4,4,5,4,3};
        int [] stock_price2 = {1,2,4,5,6,7};
        int [] stock_price3 = {5,5,5,5,5,5,5};

        int result_up = 0;
        int result_down = 0;

        int now_up = 0;
        int now_down = 0;

        int before = 0;
        for(int price : stock_price3){
            // UP
            if(price > before){
                now_up += 1;

            } else {
                now_up = 1;
            }
            // DOWN
            if(price < before){
                now_down += 1;

            } else {
                now_down = 1;
            }
            if(result_up < now_up){
                result_up = now_up;
            }
            if(result_down < now_down){
                result_down = now_down;
            }
            before = price;
        }

        System.out.println("result_up = " + result_up);
        System.out.println("result_down = " + result_down);

    }

}
