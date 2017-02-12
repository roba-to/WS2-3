package predictive;

/** Sigs2WordsTree.java
 * Sigs2WordsTree is a command-line program for calling the
 * signatureToWords method of the TreeDictionary class for
 * Worksheet 3: Predictive Text Entry
 *
 * Created by Robert Campbell on 12/02/2017.
 * @version 12/02/2017
 */
public class Sigs2WordsTree {
    public static void main(String[] args) {
        long start = System.nanoTime();
        TreeDictionary td = new TreeDictionary("words.txt");
        long end = System.nanoTime();
        System.out.println("Sigs2WordsTree setup: " + (end - start) + "ns");

        start = System.nanoTime();
        for (String s : args) {
//            System.out.println(s + " : " + td.signatureToWords(s));
            td.signatureToWords(s);
        }
        end = System.nanoTime();
        System.out.println("Sigs2WordsTree lookups: " + (end - start) + "ns");
    }
}
