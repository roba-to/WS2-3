package predictive;

/**
 * Created by Robert Campbell on 01/02/2017.
 * @version 01/02/2017
 */
public class WordSig implements Comparable<WordSig>{
    private String words;
    private String signature;

    public WordSig(String word) {
        this.words = word;
        this.signature = PredictivePrototype.wordToSignature(word);
    }

    public String getWord() {
        return this.words;
    }

    public String getSignature() {
        return this.signature;
    }

    public int compareTo(WordSig ws) {
        Long w1 = Long.parseLong(this.getSignature());
        Long w2 = Long.parseLong(ws.getSignature());
        if (w1 == w2) {
            return 0;
        }
        else if (w1 < w2) {
            return -1;
        }
        else {
            return 1;
        }
    }
}
