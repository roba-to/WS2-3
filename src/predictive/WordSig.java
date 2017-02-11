package predictive;

import java.math.BigInteger;

/**
 * Created by Robert Campbell on 01/02/2017.
 * @version 01/02/2017
 */
public class WordSig implements Comparable<WordSig>{
    private String signature;
    private String words;

    public WordSig(String signature, String word) {
        this.words = word;
        this.signature = signature;
//        this.signature = PredictivePrototype.wordToSignature(word);
    }

    public String getWord() {
        return this.words;
    }

    public String getSignature() {
        return this.signature;
    }

    public int compareTo(WordSig ws) {
        return this.getSignature().compareTo(ws.getSignature());

//        The Code below isn't any more efficient than the above code for massive signatures!!!!

//        BigInteger w1 = new BigInteger(this.getSignature());
//        BigInteger w2 = new BigInteger(ws.getSignature());
//        return w1.compareTo(w2);

//        String a = this.getSignature();
//        String b = ws.getSignature();
//
//        if (a.length() < b.length() && a.length() <= 9) {
//            return -1;
//        }
//        else if (a.length() >= 8 || b.length() >= 8) {
//            return (new BigInteger((a))).compareTo(new BigInteger(b));
//        }
//        else {
//            Long la = Long.parseLong(a);
//            return la.compareTo(Long.parseLong(b));
//        }
    }
}
