package Inheritance_03.RandomArrayList_03;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayList<Object> extends ArrayList<Object> {

    public Object getRandomElement() {
        int index = ThreadLocalRandom.current().nextInt(0, size());
        return get(index);
    }
}
