package predictive;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Rob on 01/02/2017.
 */
public class PredictivePrototypeTest {

    @Test
    public void makePatternsTest() {
        assertEquals("", PredictivePrototype.makePattern("0"));
        assertEquals("", PredictivePrototype.makePattern("1"));
        assertEquals("[abc]", PredictivePrototype.makePattern("2"));
        assertEquals("[def]", PredictivePrototype.makePattern("3"));
        assertEquals("[ghi]", PredictivePrototype.makePattern("4"));
        assertEquals("[jkl]", PredictivePrototype.makePattern("5"));
        assertEquals("[mno]", PredictivePrototype.makePattern("6"));
        assertEquals("[pqrs]", PredictivePrototype.makePattern("7"));
        assertEquals("[tuv]", PredictivePrototype.makePattern("8"));
        assertEquals("[wxyz]", PredictivePrototype.makePattern("9"));
        assertEquals("[abc][def][ghi][jkl][mno][pqrs][tuv][wxyz]", PredictivePrototype.makePattern("0123456789"));
        assertEquals("[wxyz][tuv][pqrs][mno][jkl][ghi][def][abc]", PredictivePrototype.makePattern("9876543210"));

    }

    @Test
    public void wordToSignatureTest() {
        assertEquals("", PredictivePrototype.wordToSignature(""));

//        Testing lowercase inputs
        assertEquals("2", PredictivePrototype.wordToSignature("a"));
        assertEquals("2", PredictivePrototype.wordToSignature("b"));
        assertEquals("2", PredictivePrototype.wordToSignature("c"));
        assertEquals("3", PredictivePrototype.wordToSignature("d"));
        assertEquals("3", PredictivePrototype.wordToSignature("e"));
        assertEquals("3", PredictivePrototype.wordToSignature("f"));
        assertEquals("4", PredictivePrototype.wordToSignature("g"));
        assertEquals("4", PredictivePrototype.wordToSignature("h"));
        assertEquals("4", PredictivePrototype.wordToSignature("i"));
        assertEquals("5", PredictivePrototype.wordToSignature("j"));
        assertEquals("5", PredictivePrototype.wordToSignature("k"));
        assertEquals("5", PredictivePrototype.wordToSignature("l"));
        assertEquals("6", PredictivePrototype.wordToSignature("m"));
        assertEquals("6", PredictivePrototype.wordToSignature("n"));
        assertEquals("6", PredictivePrototype.wordToSignature("o"));
        assertEquals("7", PredictivePrototype.wordToSignature("p"));
        assertEquals("7", PredictivePrototype.wordToSignature("q"));
        assertEquals("7", PredictivePrototype.wordToSignature("r"));
        assertEquals("7", PredictivePrototype.wordToSignature("s"));
        assertEquals("8", PredictivePrototype.wordToSignature("t"));
        assertEquals("8", PredictivePrototype.wordToSignature("u"));
        assertEquals("8", PredictivePrototype.wordToSignature("v"));
        assertEquals("9", PredictivePrototype.wordToSignature("w"));
        assertEquals("9", PredictivePrototype.wordToSignature("x"));
        assertEquals("9", PredictivePrototype.wordToSignature("y"));
        assertEquals("9", PredictivePrototype.wordToSignature("z"));

//        Testing uppercase inputs
        assertEquals("2", PredictivePrototype.wordToSignature("A"));
        assertEquals("2", PredictivePrototype.wordToSignature("B"));
        assertEquals("2", PredictivePrototype.wordToSignature("C"));
        assertEquals("3", PredictivePrototype.wordToSignature("D"));
        assertEquals("3", PredictivePrototype.wordToSignature("E"));
        assertEquals("3", PredictivePrototype.wordToSignature("F"));
        assertEquals("4", PredictivePrototype.wordToSignature("G"));
        assertEquals("4", PredictivePrototype.wordToSignature("H"));
        assertEquals("4", PredictivePrototype.wordToSignature("I"));
        assertEquals("5", PredictivePrototype.wordToSignature("J"));
        assertEquals("5", PredictivePrototype.wordToSignature("K"));
        assertEquals("5", PredictivePrototype.wordToSignature("L"));
        assertEquals("6", PredictivePrototype.wordToSignature("M"));
        assertEquals("6", PredictivePrototype.wordToSignature("N"));
        assertEquals("6", PredictivePrototype.wordToSignature("O"));
        assertEquals("7", PredictivePrototype.wordToSignature("P"));
        assertEquals("7", PredictivePrototype.wordToSignature("Q"));
        assertEquals("7", PredictivePrototype.wordToSignature("R"));
        assertEquals("7", PredictivePrototype.wordToSignature("S"));
        assertEquals("8", PredictivePrototype.wordToSignature("T"));
        assertEquals("8", PredictivePrototype.wordToSignature("U"));
        assertEquals("8", PredictivePrototype.wordToSignature("V"));
        assertEquals("9", PredictivePrototype.wordToSignature("W"));
        assertEquals("9", PredictivePrototype.wordToSignature("X"));
        assertEquals("9", PredictivePrototype.wordToSignature("Y"));
        assertEquals("9", PredictivePrototype.wordToSignature("Z"));

//        Test word inputs
        assertEquals("27753", PredictivePrototype.wordToSignature("Apple"));
        assertEquals("27753", PredictivePrototype.wordToSignature("apple"));
        assertEquals("27753", PredictivePrototype.wordToSignature("APPLE"));

//        Test inputs with non-valid characters (note the spaces)
        assertEquals("4357 ", PredictivePrototype.wordToSignature("Help!"));
        assertEquals("4357 ", PredictivePrototype.wordToSignature("HELP?"));
        assertEquals(" 4357 ", PredictivePrototype.wordToSignature("(help)"));

//        Test input containing nothing but non-valid characters
        assertEquals(" ", PredictivePrototype.wordToSignature("?"));
        assertEquals("  ", PredictivePrototype.wordToSignature("!?"));
        assertEquals("     ", PredictivePrototype.wordToSignature("(!?*)"));

    }

    @Test
    public void signatureToWordsTest() {
//        Note this test uses the smallDict.txt dictionary for testing purposes
        PredictivePrototype test = new PredictivePrototype();

        Set<String> result = new HashSet<>();
        result.add("abs");
        result.add("bap"); result.add("bar");
        result.add("cap"); result.add("car");
        assertTrue(result.equals(test.signatureToWords("227")));

        result.clear();
        result.add("guttering");
        assertTrue(result.equals(test.signatureToWords("488837464")));

        result.clear();
        result.add("good"); result.add("gone");
        result.add("home"); result.add("hone"); result.add("hood"); result.add("hoof");
        assertTrue(result.equals(test.signatureToWords("4663")));
    }
}
