package predictive;

import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Rob on 12/02/2017.
 */
public class TreeDictionaryTest {

    @Test
    public void signatureToWordsTest0() {
        TreeDictionary td = new TreeDictionary("smallDict.txt");
        Set<String> expected = new HashSet<>();
//        Signature that will not match a single word
        assertEquals(expected, td.signatureToWords("0"));
    }

    @Test
    public void signatureToWordsTest1() {
        TreeDictionary td = new TreeDictionary("smallDict.txt");
        Set<String> expected = new HashSet<>();

        expected.add("bap");
        expected.add("bar");
        expected.add("cap");
        expected.add("abs");
        expected.add("car");
//        Note this extra expected result is due to the TreeDictionary implementation returning
//        the first three characters of longer words with matching prefix signatures as well as complete words
//        The "bas" results is due to the word "bass" being included in the dictionary
        expected.add("bas");
        expected.add("aar");

        assertEquals(expected, td.signatureToWords("227"));
    }

    @Test
    public void signatureToWordsTest2() {
        TreeDictionary td = new TreeDictionary("smallDict.txt");
        Set<String> expected = new HashSet<>();

        expected.add("ew");
//        "extra" is a valid word in the dictionary so the prefix "ex" will be returned
        expected.add("ex");
        assertEquals(expected, td.signatureToWords("39"));

    }

    @Test
    public void signatureToWordsTest3() {
        TreeDictionary td = new TreeDictionary("smallDict.txt");
        Set<String> expected = new HashSet<>();

        expected.add("good");
        expected.add("gone");
        expected.add("home");
        expected.add("hone");
        expected.add("hood");
        expected.add("hoof");
        assertTrue(expected.equals(td.signatureToWords("4663")));
//        System.out.println(PredictivePrototype.wordToSignature("gone"));
//        System.out.println(td.signatureToWords("4663"));
    }

    @Test
    public void signatureToWordsTest4() {
//        Note that the word "Robert" appears twice and "Roberval" has a capital 'R' in the words.txt file.
//        The TreeDictionary dictionary casts each word to lowercase before adding to the dictionary
//        so "Robert" will only occur once in a single tree node and "Roberval" will have a lowercase 'r'.
        TreeDictionary td = new TreeDictionary("words.txt");
        Set<String> expected = new HashSet<>();

        expected.add("robert");
//        roadrunner and roadrunners
        expected.add("roadru");
//        roadstead, roadsteads, roadster, roadsters, and roadstone
        expected.add("roadst");
//        Roberval
        expected.add("roberv");

        assertTrue(expected.equals(td.signatureToWords("762378")));
//        System.out.println(td.signatureToWords("762378"));
    }

    @Test
    public void signatureToWordsTest5() {
        TreeDictionary td = new TreeDictionary("words.txt");
        Set<String> expected =  new HashSet<>();

//        Note that the starting 0 is an invalid signature number and thus no matches should be found
        assertTrue(expected.equals(td.signatureToWords("04663")));
    }

    @Test
    public void signatureToWordsTest6() {
        TreeDictionary td = new TreeDictionary("words.txt");
        Set<String> expected =  new HashSet<>();

//        Note that the 3rd character '0' is an invalid signature number and thus no matches should be found
        assertTrue(expected.equals(td.signatureToWords("46063")));
    }

    @Test
    public void signatureToWordsTest7() {
        TreeDictionary td = new TreeDictionary("words.txt");
        Set<String> expected =  new HashSet<>();

//        Note that the final character 'S' is an invalid signature number and thus no matches should be found
        assertTrue(expected.equals(td.signatureToWords("4663S")));
    }

    @Test
    public void signatureToWordsTest8() {
        TreeDictionary td = new TreeDictionary("words.txt");
        Set<String> expected = new HashSet<>();

//        Not a single word should match this signature
        assertTrue(expected.equals(td.signatureToWords("2345678923456789")));
    }
}
