package part05;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static java.util.stream.Collectors.toList;

public class NonBlockingApi {

    public static void main(String[] args) throws Exception {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("invocationTimeRR = " + invocationTime);

//        doSomethingElse();
        try {
            double price = futurePrice.get();
            System.out.println("price = " + price);
        } catch (Exception e) {
            throw new Exception(e);
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("retrievalTime = " + retrievalTime);
    }

}

class NonBlockCode {
    List<Shop> shops = Arrays.asList(new Shop("Best Price"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"));

    public List<String> findPrices(String product) {
//        return shops.stream().map(shop -> shop.getName() + shop.getPrice(product)).collect(toList());
        return shops.parallelStream().map(shop -> shop.getName() + shop.getPrice(product)).collect(toList());
    }
}

class Shop {

    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public Future<Double> getPriceAsync(String product) {
//        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//        new Thread(() -> {
//            try {
//                double price = calculatePrice(product);
//                // 계산이 정상적으로 종료되면 Future에 가격 정보를 저장한 채로 Future를 종료한다.
//                futurePrice.complete(price);
//            } catch (Exception ex){
//                // 도중에 문제가 발생하면 발생한 에러를 포함시켜 Future를 종료한다.
//                futurePrice.completeExceptionally(ex);
//            }
//        }).start();
//        return futurePrice;
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        delay();
        return Math.random() * product.charAt(0) + product.charAt(1);
    }

    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
