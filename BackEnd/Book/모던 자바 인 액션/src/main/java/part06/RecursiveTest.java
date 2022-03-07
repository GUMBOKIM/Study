package part06;

public class RecursiveTest {

    static long factorialRecursive(long n ){
        return n == 1 ? 1 : n * factorialRecursive(n - 1);
    }

    static long factorialTailRecursive(long n){
        return factorialHelper(1, n);
    }

    static long factorialHelper(long acc, long n){
        return n == 1 ? acc : factorialHelper(acc * n , n -1);
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println("factorialRecursive(100) = " + factorialRecursive(100));
        System.out.println(System.nanoTime() - start);

        start = System.nanoTime();
        System.out.println("factorialTailRecursive(100) = " + factorialTailRecursive(100));
        System.out.println(System.nanoTime() - start);
    }
}
