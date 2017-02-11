package predictive;

/**
 * Created by Rob on 10/02/2017.
 */
public class Sigs2WordsMap {
    public static void main(String[] args) {
        MapDictionary md = new MapDictionary("words.txt");
        for (String s : args) {
            System.out.println(s + " : " + md.signatureToWords(s));
        }
    }
}
