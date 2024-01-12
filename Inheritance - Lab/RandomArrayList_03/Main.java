package Inheritance_03.RandomArrayList_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RandomArrayList<Integer> randomArrayList = new RandomArrayList<>();
        randomArrayList.add(1);
        randomArrayList.add(13);
        randomArrayList.add(567);
        int randomElement = randomArrayList.getRandomElement();

        System.out.println(randomElement);
    }
}
