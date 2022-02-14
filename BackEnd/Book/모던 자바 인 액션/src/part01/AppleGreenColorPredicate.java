package part01;

import common.Apple;

import static common.Color.GREEN;

class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }
}
