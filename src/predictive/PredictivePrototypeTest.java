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

//    makePattern() testing
    @Test
    public void makePatternsTest0() {
        assertEquals("", PredictivePrototype.makePattern("0"));
    }
    @Test
    public void makePatternsTest1() {
        assertEquals("", PredictivePrototype.makePattern("1"));
    }
    @Test
    public void makePatternsTest2() {
        assertEquals("[abc]", PredictivePrototype.makePattern("2"));
    }
    @Test
    public void makePatternsTest3() {
        assertEquals("[def]", PredictivePrototype.makePattern("3"));
    }
    @Test
    public void makePatternsTest4() {
        assertEquals("[ghi]", PredictivePrototype.makePattern("4"));
    }
    @Test
    public void makePatternsTest5() {
        assertEquals("[jkl]", PredictivePrototype.makePattern("5"));
    }
    @Test
    public void makePatternsTest6() {
        assertEquals("[mno]", PredictivePrototype.makePattern("6"));
    }
    @Test
    public void makePatternsTest7() {
        assertEquals("[pqrs]", PredictivePrototype.makePattern("7"));
    }
    @Test
    public void makePatternsTest8() {
        assertEquals("[tuv]", PredictivePrototype.makePattern("8"));
    }
    @Test
    public void makePatternsTest9() {
        assertEquals("[wxyz]", PredictivePrototype.makePattern("9"));
    }
    @Test
    public void makePatternsTest10() {
        assertEquals("[abc][def][ghi][jkl][mno][pqrs][tuv][wxyz]", PredictivePrototype.makePattern("0123456789"));
    }
    @Test
    public void makePatternsTest11() {
        assertEquals("[wxyz][tuv][pqrs][mno][jkl][ghi][def][abc]", PredictivePrototype.makePattern("9876543210"));
    }

//   wordToSignature() testing
    @Test
    public void wordToSignatureTest() {
        assertEquals("", PredictivePrototype.wordToSignature(""));
    }

//        Testing lowercase and uppercase single letter  inputs
    @Test
    public void wordToSignatureTest1() {
        assertEquals("2", PredictivePrototype.wordToSignature("a"));
        assertEquals("2", PredictivePrototype.wordToSignature("A"));
    }

    @Test
    public void wordToSignatureTest2() {
        assertEquals("2", PredictivePrototype.wordToSignature("b"));
        assertEquals("2", PredictivePrototype.wordToSignature("B"));
    }

    @Test
    public void wordToSignatureTest3() {
        assertEquals("2", PredictivePrototype.wordToSignature("c"));
        assertEquals("2", PredictivePrototype.wordToSignature("C"));
    }

    @Test
    public void wordToSignatureTest4() {
        assertEquals("3", PredictivePrototype.wordToSignature("d"));
        assertEquals("3", PredictivePrototype.wordToSignature("D"));
    }

    @Test
    public void wordToSignatureTest5() {
        assertEquals("3", PredictivePrototype.wordToSignature("e"));
        assertEquals("3", PredictivePrototype.wordToSignature("E"));
    }

    @Test
    public void wordToSignatureTest6() {
        assertEquals("3", PredictivePrototype.wordToSignature("f"));
        assertEquals("3", PredictivePrototype.wordToSignature("F"));
    }

    @Test
    public void wordToSignatureTest7() {
        assertEquals("4", PredictivePrototype.wordToSignature("g"));
        assertEquals("4", PredictivePrototype.wordToSignature("G"));

    }

    @Test
    public void wordToSignatureTest8() {
        assertEquals("4", PredictivePrototype.wordToSignature("h"));
        assertEquals("4", PredictivePrototype.wordToSignature("H"));
    }

    @Test
    public void wordToSignatureTest9() {
        assertEquals("4", PredictivePrototype.wordToSignature("i"));
        assertEquals("4", PredictivePrototype.wordToSignature("I"));
    }

    @Test
    public void wordToSignatureTest10() {
        assertEquals("5", PredictivePrototype.wordToSignature("j"));
        assertEquals("5", PredictivePrototype.wordToSignature("J"));
    }

    @Test
    public void wordToSignatureTest11() {
        assertEquals("5", PredictivePrototype.wordToSignature("k"));
        assertEquals("5", PredictivePrototype.wordToSignature("K"));
    }

    @Test
    public void wordToSignatureTest12() {
        assertEquals("5", PredictivePrototype.wordToSignature("l"));
        assertEquals("5", PredictivePrototype.wordToSignature("L"));
    }

    @Test
    public void wordToSignatureTest13() {
        assertEquals("6", PredictivePrototype.wordToSignature("m"));
        assertEquals("6", PredictivePrototype.wordToSignature("M"));
    }

    @Test
    public void wordToSignatureTest14() {
        assertEquals("6", PredictivePrototype.wordToSignature("n"));
        assertEquals("6", PredictivePrototype.wordToSignature("N"));
    }

    @Test
    public void wordToSignatureTest15() {
        assertEquals("6", PredictivePrototype.wordToSignature("o"));
        assertEquals("6", PredictivePrototype.wordToSignature("O"));
    }

    @Test
    public void wordToSignatureTest16() {
        assertEquals("7", PredictivePrototype.wordToSignature("p"));
        assertEquals("7", PredictivePrototype.wordToSignature("P"));
    }

    @Test
    public void wordToSignatureTest17() {
        assertEquals("7", PredictivePrototype.wordToSignature("q"));
        assertEquals("7", PredictivePrototype.wordToSignature("Q"));
    }

    @Test
    public void wordToSignatureTest18() {
        assertEquals("7", PredictivePrototype.wordToSignature("r"));
        assertEquals("7", PredictivePrototype.wordToSignature("R"));
    }

    @Test
    public void wordToSignatureTest19() {
        assertEquals("7", PredictivePrototype.wordToSignature("s"));
        assertEquals("7", PredictivePrototype.wordToSignature("S"));
    }

    @Test
    public void wordToSignatureTest20() {
        assertEquals("8", PredictivePrototype.wordToSignature("t"));
        assertEquals("8", PredictivePrototype.wordToSignature("T"));
    }

    @Test
    public void wordToSignatureTest21() {
        assertEquals("8", PredictivePrototype.wordToSignature("u"));
        assertEquals("8", PredictivePrototype.wordToSignature("U"));
    }

    @Test
    public void wordToSignatureTest22() {
        assertEquals("8", PredictivePrototype.wordToSignature("v"));
        assertEquals("8", PredictivePrototype.wordToSignature("V"));

    }

    @Test
    public void wordToSignatureTest23() {
        assertEquals("9", PredictivePrototype.wordToSignature("w"));
        assertEquals("9", PredictivePrototype.wordToSignature("W"));
    }

    @Test
    public void wordToSignatureTest24() {
        assertEquals("9", PredictivePrototype.wordToSignature("x"));
        assertEquals("9", PredictivePrototype.wordToSignature("X"));
    }

    @Test
    public void wordToSignatureTest25() {
        assertEquals("9", PredictivePrototype.wordToSignature("y"));
        assertEquals("9", PredictivePrototype.wordToSignature("Y"));
    }

    @Test
    public void wordToSignatureTest26() {
        assertEquals("9", PredictivePrototype.wordToSignature("z"));
        assertEquals("9", PredictivePrototype.wordToSignature("Z"));
    }

    @Test
    public void wordToSignatureTest27() {

//        Test word inputs
        assertEquals("27753", PredictivePrototype.wordToSignature("Apple"));
        assertEquals("27753", PredictivePrototype.wordToSignature("apple"));
        assertEquals("27753", PredictivePrototype.wordToSignature("APPLE"));
    }

    @Test
    public void wordToSignatureTest28() {
//        Test inputs with non-valid characters (note the spaces)
        assertEquals("4357 ", PredictivePrototype.wordToSignature("Help!"));
        assertEquals("4357 ", PredictivePrototype.wordToSignature("HELP?"));
        assertEquals(" 4357 ", PredictivePrototype.wordToSignature("(help)"));
    }

    @Test
    public void wordToSignatureTest29() {
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
        result.add("bap");
        result.add("bar");
        result.add("cap");
        result.add("car");

        assertTrue(result.equals(test.signatureToWords("227")));
    }

    @Test
    public void signatureToWordsTest1() {
        PredictivePrototype test = new PredictivePrototype();
        Set<String> result = new HashSet<>();

        result.add("guttering");
        assertTrue(result.equals(test.signatureToWords("488837464")));
    }

    @Test
    public void signatureToWordsTest2() {
        PredictivePrototype test = new PredictivePrototype();
        Set<String> result = new HashSet<>();

        result.add("good"); result.add("gone");
        result.add("home"); result.add("hone"); result.add("hood"); result.add("hoof");
        assertTrue(result.equals(test.signatureToWords("4663")));
    }
}
