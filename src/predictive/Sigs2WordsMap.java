package predictive;

/** Sigs2WordsMap.java
 * Sigs2WordsMap is a command-line program for calling the
 * signatureToWords method of the MapDictionary class for
 * Worksheet 3: Predictive Text Entry
 *
 * Created by Robert Campbell on 10/02/2017.
 * @version 12/02/2017
 */
public class Sigs2WordsMap {
    public static void main(String[] args) {
        long start = System.nanoTime();
        MapDictionary md = new MapDictionary("words.txt");
        long end = System.nanoTime();
        System.out.println("Sigs2WordsMap setup: " + (end - start) + "ns");

        start = System.nanoTime();
        for (String s : args) {
//            System.out.println(s + " : " + md.signatureToWords(s));
            md.signatureToWords(s);
        }
        end = System.nanoTime();
        System.out.println("Sigs2WordsMap lookup: " + (end - start) + "ns");
    }
}
