package predictive;

/**
 * Created by Robert Campbell on 02/02/2017.
 * @version 02/02/2017
 */
public class Sigs2WordsList {
    public static void main(String[] args) {
        ListDictionary ld = new ListDictionary("words.txt");
        for (String s : args) {
            System.out.println(s + " : " + ld.signatureToWords(s));
        }
    }
}
