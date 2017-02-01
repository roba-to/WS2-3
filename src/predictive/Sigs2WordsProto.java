package predictive;

/** Sigs2WordsProto.java
 * Sigs2WordsProto is a command-line program for calling the
 * signature2Words method of the PredictivePrototype class for
 * Worksheet 3: Predictive Text Entry
 *
 * Created by Robert Campbell on 31/01/2017.
 * @version 01/02/2017
 */
public class Sigs2WordsProto {
    public static void main(String[] args) {
        for (String s : args) {
            System.out.println(s + " : " + PredictivePrototype.signatureToWords(s));
        }
    }
}
