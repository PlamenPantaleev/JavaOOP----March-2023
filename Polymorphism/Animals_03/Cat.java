package Polymorphism_05.Animals_03;

public class Cat extends Animal {
    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("I am %s and my favourite food is %s", getName(), getFavouriteFood()))
                .append(System.lineSeparator()).append("MEOW");
        return sb.toString();
    }
}
