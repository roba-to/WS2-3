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
    public void isValidWordTest0() {
//        Test is a valid word (word will be cast to lower-case before validation)
        assertTrue(ListDictionary.isValidWord("Test"));
    }

    @Test
    public void isValidWordTest1() {
//        Test! is not a valid word due to !
        assertFalse(ListDictionary.isValidWord("Test!"));
    }

    @Test
    public void isValidWordTest2() {
//        % is not a valid character and also not a word
        assertFalse(ListDictionary.isValidWord("%"));
    }

    @Test
    public void isValidWordTest3() {
//        hyphenated words are NOT valid
        assertFalse(ListDictionary.isValidWord("Hyphenated-word"));
    }

    @Test
    public void signatureToWordsTest0() {
        ListDictionary ld = new ListDictionary("smallDict.txt");
        Set<String> expected = new HashSet<>();
//        Empty set and signature that will not match a single word
        assertEquals(expected, ld.signatureToWords("0"));
    }

    @Test
    public void signatureToWordsTest1() {
        ListDictionary ld = new ListDictionary("smallDict.txt");
        Set<String> expected = new HashSet<>();

        expected.add("bap");
        expected.add("bar");
        expected.add("cap");
        expected.add("abs");
        expected.add("car");

        assertEquals(expected, ld.signatureToWords("227"));
    }

    @Test
    public void signatureToWordsTest2() {
        ListDictionary ld = new ListDictionary("smallDict.txt");
        Set<String> expected = new HashSet<>();

        expected.add("ew");
        assertEquals(expected, ld.signatureToWords("39"));
    }

    @Test
    public void signatureToWordsTest3() {
        ListDictionary ld = new ListDictionary("smallDict.txt");
        Set<String> expected = new HashSet<>();

        expected.add("good");
        expected.add("gone");
        expected.add("home");
        expected.add("hone");
        expected.add("hood");
        expected.add("hoof");
        assertTrue(expected.equals(ld.signatureToWords("4663")));
    }

    @Test
    public void signatureToWordsTest4() {
//        Note that the word "Robert" appears twice in the words.txt file.
//        The ListDictionary dictionary casts each word to lowercase before adding to the dictionary
//        so "Robert" will only occur once in the WordSig object
        ListDictionary ld = new ListDictionary("words.txt");
        Set<String> expected = new HashSet<>();

        expected.add("robert");

        assertTrue(expected.equals(ld.signatureToWords("762378")));
    }

    @Test
    public void signatureToWordsTest5() {
        ListDictionary ld = new ListDictionary("words.txt");
        Set<String> expected =  new HashSet<>();

//        Note that the starting 0 is an invalid signature number and thus no matches should be found
        assertTrue(expected.equals(ld.signatureToWords("04663")));
    }

    @Test
    public void signatureToWordsTest6() {
        ListDictionary ld = new ListDictionary("words.txt");
        Set<String> expected =  new HashSet<>();

//        Note that the 3rd character '0' is an invalid signature number and thus no matches should be found
        assertTrue(expected.equals(ld.signatureToWords("46063")));
    }

    @Test
    public void signatureToWordsTest7() {
        ListDictionary ld = new ListDictionary("words.txt");
        Set<String> expected =  new HashSet<>();

//        Note that the final character 'S' is an invalid signature number and thus no matches should be found
        assertTrue(expected.equals(ld.signatureToWords("4663S")));
    }

    @Test
    public void signatureToWordsTest8() {
        ListDictionary ld = new ListDictionary("words.txt");
        Set<String> expected = new HashSet<>();

//        Not a single word should match this signature
        assertTrue(expected.equals(ld.signatureToWords("2345678923456789")));
    }
}
