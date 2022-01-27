package ch05;

public class ex5_5 {
    static int factorial(int i){
        if(i <= 1) return 1;
        return factorial(i -1) * i;
    }
    public static void main(String[] args)
    {
        System.out.println(factorial(5));
    }
}