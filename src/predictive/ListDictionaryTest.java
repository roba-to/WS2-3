package predictive;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Robert Campbell on 02/02/2017.
 */
public class ListDictionaryTest {
    ListDictionary smallDictionary;
    ListDictionary bigDictionary;

    @Before
    public void setUp() throws IOException {
        System.out.println("Setting up the ListDictionary objects");
        smallDictionary = new ListDictionary("smallDict.txt");
//        bigDictionary = new ListDictionary("words.txt");
    }

    @Test
    public void ListDictionaryTest() {
        assertEquals("smallDict.txt", smallDictionary.getPath());
        System.out.println("Path: " + smallDictionary.getPath());
    }

    @Test
    public void isValidWordTest() {

    }

    @Test
    public void signature2WordsTest() {

    }

    @Test
    public void toStringTest() {

    }


}
