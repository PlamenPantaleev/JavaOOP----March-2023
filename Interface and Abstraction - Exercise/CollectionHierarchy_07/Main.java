package InterfaceAndAbstraction_04.CollectionHierarchy_07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Collection addCollection = new AddCollection();
        Collection addRemoveCollection = new AddRemoveCollection();
        Collection myListImpl = new MyListImpl();

        String[] elementsToAdd = scanner.nextLine().split("\\s+");
        int numberOfRemoveOperations = Integer.parseInt(scanner.nextLine());

        addMethod(addCollection, elementsToAdd);
        addMethod(addRemoveCollection, elementsToAdd);
        addMethod(myListImpl, elementsToAdd);
        removeMethod(numberOfRemoveOperations, addRemoveCollection);
        removeMethod(numberOfRemoveOperations, myListImpl);
        System.out.println();
    }

    private static void addMethod(Collection addCollection, String[] elementsToAdd) {
        for (int i = 0; i < elementsToAdd.length; i++) {
            System.out.print(addCollection.add(elementsToAdd[i]) + " ");
        }
        System.out.println();
    }

    private static void removeMethod(int numberOFOperations, Collection collection) {
        for (int i = 0; i < numberOFOperations; i++) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }
}
