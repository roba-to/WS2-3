package predictive;

/**
 * Created by Rob on 11/02/2017.
 */
public class Sig2WordsTree {
    public static void main(String[] args) {
        TreeDictionary td = new TreeDictionary("words.txt");
        for (String s : args) {
            System.out.println(s + " : " + td.signatureToWords(s));
        }
    }
}
