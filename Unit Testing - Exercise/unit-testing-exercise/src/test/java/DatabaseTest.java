import p01_Database.Database;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    Database database;
    Integer[] elements = {7,8,9,12,13,14,17};
    Integer[] empty = new Integer[0];


    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseSizeIsMoreThan16Integers() throws OperationNotSupportedException {
        database = new Database(empty);
    }

    @Test
    public void testDatabaseSizeIs16Integers() throws OperationNotSupportedException {
        database = new Database(elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddMethodShouldThrowWhenObjectIsNull() throws OperationNotSupportedException {
        database = new Database(elements);
        Integer elementToToAdd = null;
        database.add(elementToToAdd);
    }

    @Test
    public void testAddMethodShouldAddElementToTheNextFreeCell() throws OperationNotSupportedException {
        database = new Database(elements);
        Integer elementToAdd = 18;
        database.add(18);
    }
}
