package predictive;

/** Sigs2WordsList.java
 * Sigs2WordsList is a command-line program for calling the
 * signatureToWords method of the ListDictionary class for
 * Worksheet 3: Predictive Text Entry
 *
 * Created by Robert Campbell on 02/02/2017.
 * @version 12/02/2017
 */
public class Sigs2WordsList {
    public static void main(String[] args) {
        long start = System.nanoTime();
        ListDictionary ld = new ListDictionary("words.txt");
        long end = System.nanoTime();
        System.out.println("Sigs2WordsList setup: " + (end - start) + "ns");

        start = System.nanoTime();
        for (String s : args) {
//            System.out.println(s + " : " + ld.signatureToWords(s));
            ld.signatureToWords(s);
        }
        end = System.nanoTime();
        System.out.println("Sigs2WordsList: lookup" + (end - start) + "ns");

    }
}
