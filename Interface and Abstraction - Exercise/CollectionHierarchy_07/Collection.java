package InterfaceAndAbstraction_04.CollectionHierarchy_07;

import java.util.ArrayList;
import java.util.List;

public class Collection implements Addable, AddRemovable, MyList{
    private final int maxSize = 100;
    private List<String> items;

    public Collection() {
        this.items = new ArrayList<>(maxSize);
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    @Override
    public String remove() {
        return null;
    }

    @Override
    public int add(String string) {
        return 0;
    }

    @Override
    public int getUsed() {
        return 0;
    }
}
