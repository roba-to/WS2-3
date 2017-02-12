package predictive;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Rob on 12/02/2017.
 */
public class MapDictionaryTest {

    @Test
    public void signatureToWordsTest0() {
        MapDictionary md = new MapDictionary("smallDict.txt");
        Set<String> expected = new HashSet<>();
//        Signature that will not match a single word
        assertEquals(expected, md.signatureToWords("0"));
    }

    @Test
    public void signatureToWordsTest1() {
        MapDictionary md = new MapDictionary("smallDict.txt");
        Set<String> expected = new HashSet<>();

        expected.add("bap");
        expected.add("bar");
        expected.add("cap");
        expected.add("abs");
        expected.add("car");

        assertEquals(expected, md.signatureToWords("227"));
    }

    @Test
    public void signatureToWordsTest2() {
        MapDictionary md = new MapDictionary("smallDict.txt");
        Set<String> expected = new HashSet<>();

        expected.add("ew");
        assertEquals(expected, md.signatureToWords("39"));
    }

    @Test
    public void signature2WordsTest3() {
        MapDictionary md = new MapDictionary("smallDict.txt");
        Set<String> expected = new HashSet<>();

        expected.add("good");
        expected.add("gone");
        expected.add("home");
        expected.add("hone");
        expected.add("hood");
        expected.add("hoof");
        assertTrue(expected.equals(md.signatureToWords("4663")));
    }

    @Test
    public void signatureToWordsTest4() {
//        Note that the word "Robert" appears twice in the words.txt file.
//        The MapDictionary dictionary casts each word to lowercase before adding to the dictionary
//        so "Robert" will only occur once in the VALUE set of the corresponding key
        MapDictionary md = new MapDictionary("words.txt");
        Set<String> expected = new HashSet<>();

        expected.add("robert");

        assertTrue(expected.equals(md.signatureToWords("762378")));
    }

    @Test
    public void signatureToWordsTest5() {
        MapDictionary md = new MapDictionary("words.txt");
        Set<String> expected =  new HashSet<>();

//        Note that the starting 0 is an invalid signature number and thus no matches should be found
        assertTrue(expected.equals(md.signatureToWords("04663")));
    }

    @Test
    public void signatureToWordsTest6() {
        MapDictionary md = new MapDictionary("words.txt");
        Set<String> expected =  new HashSet<>();

//        Note that the 3rd character '0' is an invalid signature number and thus no matches should be found
        assertTrue(expected.equals(md.signatureToWords("46063")));
    }

    @Test
    public void signatureToWordsTest7() {
        MapDictionary md = new MapDictionary("words.txt");
        Set<String> expected =  new HashSet<>();

//        Note that the final character 'S' is an invalid signature number and thus no matches should be found
        assertTrue(expected.equals(md.signatureToWords("4663S")));
    }

    @Test
    public void signatureToWordsTest8() {
        MapDictionary md = new MapDictionary("words.txt");
        Set<String> expected = new HashSet<>();

//        Not a single word should match this signature
        assertTrue(expected.equals(md.signatureToWords("2345678923456789")));
    }
}
