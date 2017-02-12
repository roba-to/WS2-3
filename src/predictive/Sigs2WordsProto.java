package predictive;

/** Sigs2WordsProto.java
 * Sigs2WordsProto is a command-line program for calling the
 * signatureToWords method of the PredictivePrototype class for
 * Worksheet 3: Predictive Text Entry
 *
 * Created by Robert Campbell on 31/01/2017.
 * @version 12/02/2017
 */
public class Sigs2WordsProto {
    public static void main(String[] args) {
        long start = System.nanoTime();
        PredictivePrototype p1 = new PredictivePrototype();
        long end = System.nanoTime();
        System.out.println("Sigs2WordsProto setup: " + (end - start) + "ns");

        start = System.nanoTime();
        for (String s : args) {
//            System.out.println(s + " : " + p1.signatureToWords(s));
            p1.signatureToWords(s);
        }
        end = System.nanoTime();
        System.out.println("Sigs2WordsProto lookup: " + (end - start) + "ns");
    }
}
