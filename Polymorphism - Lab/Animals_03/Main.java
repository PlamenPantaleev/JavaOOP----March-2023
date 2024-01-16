package Polymorphism_05.Animals_03;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Oscar","Whiskas");
        Dog dog = new Dog("Rocky", "Meat");

        System.out.println(cat.explainSelf());
        System.out.println(dog.explainSelf());
    }
}
