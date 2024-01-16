package InterfaceAndAbstraction_04.CollectionHierarchy_07;

public class AddCollection extends Collection implements Addable{
    public AddCollection() {
    }

    @Override
    public int add(String string) {
        super.getItems().add(string);

        return super.getItems().size() - 1;
    }
}
