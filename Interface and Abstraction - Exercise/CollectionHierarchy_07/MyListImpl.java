package InterfaceAndAbstraction_04.CollectionHierarchy_07;

public class MyListImpl extends Collection implements MyList {
    public MyListImpl() {

    }

    @Override
    public String remove() {
        return super.getItems().remove(0);
    }

    @Override
    public int add(String string) {
        super.getItems().add(0, string);

        return 0;
    }

    @Override
    public int getUsed() {
        return super.getItems().size();
    }
}
