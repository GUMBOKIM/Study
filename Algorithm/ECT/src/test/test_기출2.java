package test;

public class test_기출2 {

    public static void main(String[] args) {

        int money1 = 420;
        int [] cost1 = {0,900,0,200,150,0,30,50};
        int money2 = 100;
        int [] cost2 = {245,317,151,192};

        int max = 0;
        for(int i = 0; i<cost2.length; i++){

            int count = 0;
            int total = cost2[i];
            int idx = i + 1;
            while(total <= money2){
                count++;
                total += cost2[i];
                idx++;
                if(idx == cost2.length){
                    break;
                }
            }
            if(max < count){
                max = count;
            }
        }

        System.out.println("max = " + max);

    }

}
