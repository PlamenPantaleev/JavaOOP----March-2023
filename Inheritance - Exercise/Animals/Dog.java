package Inheritance_03.Animals;

public class Dog extends Animal{
    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }
    public String produceSound() {
        return "Woof!";
    }
}
