package predictive;

/** Words2SigProto.java
 * Words2SigProto is a command-line program for calling the
 * word2Signature method of the PredictivePrototype class for
 * Worksheet 3: Predictive Text Entry
 *
 * Created by Robert Campbell on 31/01/2017.
 * @version 12/02/2017
 */
public class Words2SigProto {
    public static void main(String[] args) {
        long start = System.nanoTime();
        PredictivePrototype p1 = new PredictivePrototype();
        long end = System.nanoTime();
        System.out.println("Words2SigProto setup: " + (end - start) + "ns");

        start = System.nanoTime();
        for (String s :  args) {
//            System.out.println(s + " : " + p1.wordToSignature(s));
            p1.wordToSignature(s);
        }
        end = System.nanoTime();
        System.out.println("Words2SigProto setup: " + (end - start) + "ns");

    }
}
