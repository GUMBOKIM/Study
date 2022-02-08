package common;



public class Apple{
    private Color color;
    private int weight;

    public Apple(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }

    public int getWeight(){
        return this.weight;
    }

}