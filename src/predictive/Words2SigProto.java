package predictive;

/** Words2SigProto.java
 * Words2SigProto is a command-line program for calling the
 * word2Signature method of the PredictivePrototype class for
 * Worksheet 3: Predictive Text Entry
 *
 * Created by Robert Campbell on 31/01/2017.
 * @version 01/02/2017
 */
public class Words2SigProto {
    public static void main(String[] args) {
        for (String s :  args) {
            System.out.println(s + " : " + PredictivePrototype.wordToSignature(s));
        }
    }
}
