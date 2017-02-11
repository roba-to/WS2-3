package predictive;

import org.junit.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Robert Campbell on 02/02/2017.
 */
public class ListDictionaryTest {

    @Test
    public void isValidWordTest() {
//        Test is a valid word (word will be cast to lower-case before validation)
        assertTrue(ListDictionary.isValidWord("Test"));

//        Test! is not a valid word due to !
        assertFalse(ListDictionary.isValidWord("Test!"));

//        % is not a valid character and also not a word
        assertFalse(ListDictionary.isValidWord("%"));

//        hyphenated words are NOT valid
        assertFalse(ListDictionary.isValidWord("Hyphenated-word"));
    }

    @Test
    public void signature2WordsTest() {
        Set<String> expected = new HashSet<>();
//        Empty set and signature that will not match a single word
        assertEquals(expected, ListDictionary.signatureToWords("0"));

        expected.add("bap");
        expected.add("bar");
        expected.add("cap");
        expected.add("abs");
        expected.add("car");

        assertEquals(expected, ListDictionary.signatureToWords("227"));

        expected.clear();;

        expected.add("ew");
        assertEquals(expected, ListDictionary.signatureToWords("39"));
    }

    @Test
    public void toStringTest() {
        ListDictionary tinyDictionary = new ListDictionary("tinyDict.txt");
        System.out.println(tinyDictionary.toString());

    }


}
