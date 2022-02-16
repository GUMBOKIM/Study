package part02;

import common.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class ch0503 {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<TransAction> transActions = Arrays.asList(
                new TransAction(brian, 2011, 300),
                new TransAction(raoul, 2012, 1000),
                new TransAction(raoul, 2011, 400),
                new TransAction(mario, 2012, 710),
                new TransAction(mario, 2012, 700),
                new TransAction(alan, 2012, 950)
        );

        List<TransAction> tr2011 = transActions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(TransAction::getYear))
                .collect(toList());
        System.out.println("tr2011 = " + tr2011);

        List<String> cities = transActions.stream().map(TransAction::getTrader)
                .map(Trader::getCity).distinct().collect(toList());
        System.out.println("cities = " + cities);

        List<Trader> cambridge = transActions.stream().map(TransAction::getTrader).filter(t -> t.getCity().equals("Cambridge"))
                .distinct().sorted(comparing(Trader::getName)).collect(toList());
        System.out.println("cambridge = " + cambridge);

        List<String> collect = transActions.stream().map(TransAction::getTrader).map(Trader::getName).distinct().sorted().collect(toList());
        System.out.println("collect = " + collect);

        boolean milan = transActions.stream().anyMatch(transAction -> transAction.getTrader().getCity().equals("Milan"));
        System.out.println("milan = " + milan);

        transActions.stream().filter(transAction -> transAction.getTrader().getCity().equals("Cambridge")).map(TransAction::toString).forEach(System.out::println);

        Optional<Integer> max = transActions.stream().map(TransAction::getValue).reduce(Integer::max);
        System.out.println("max = " + max);

        Optional<Integer> min = transActions.stream().map(TransAction::getValue).reduce(Integer::min);
        System.out.println("min = " + min);
    }

}

class Trader {
    private final String name;
    private final String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }

    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

    public String toString() {
        return "Trader : " + this.name + " in " + this.city;
    }
}

class TransAction {
    private final Trader trader;
    private final int year;
    private final int value;

    public TransAction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return this.trader;
    }

    public int getYear() {
        return this.year;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return "{" + this.trader + ", " +
                "year : " + this.year + ", " +
                "value : " + this.value + "}";
    }
}