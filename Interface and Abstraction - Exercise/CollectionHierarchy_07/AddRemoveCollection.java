package InterfaceAndAbstraction_04.CollectionHierarchy_07;

public class AddRemoveCollection extends Collection implements AddRemovable {
    public AddRemoveCollection() {
    }

    @Override
    public String remove() {
        return super.getItems().remove(getItems().size() - 1);
    }

    @Override
    public int add(String string) {
        super.getItems().add(0, string);
        return 0;
    }
}
