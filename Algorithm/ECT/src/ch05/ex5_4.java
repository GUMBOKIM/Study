package ch05;

public class ex5_4 {
    static void recursive(int i){
        System.out.println("i = " + i);
        if(i == 100){
            return;
        }
        recursive(i+1);

    }
    public static void main(String[] args) {
        recursive(1);
    }
}
