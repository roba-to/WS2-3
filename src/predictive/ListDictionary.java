package predictive;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Robert Campbell on 01/02/2017.
 * @version 01/02/2017
 */
public class ListDictionary {
    private static ArrayList<WordSig> myDictionary = new ArrayList<>();
    private File path;

    public ListDictionary(String path) {
        this.path = new File(path);
        String s;

        try (Scanner scan = new Scanner(this.path)) {

            while (scan.hasNextLine()) {
                s = scan.nextLine();
                if (isValidWord(s)) {
                    this.myDictionary.add(new WordSig(PredictivePrototype.wordToSignature(s), s));
                }
            }
            Collections.sort(this.myDictionary);
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    /** Getter to retrieve dictionary from ListDictionary object
     * Mainly used for testing purposes
     *
     * @return an ArrayList<WordSig> dictionary
     */
    public ArrayList<WordSig> getMyDictionary() {
        return myDictionary;
    }

    /** Getter to retrieve path, as a String, from ListDictionary object
     * Mainly used for testing purposes
     *
     * @return a String detailing the dictionary's path name
     */
    public String getPath() {
        return path.toString();
    }

    public static boolean isValidWord(String word) {
        Pattern p = Pattern.compile("[a-z]");
        Matcher m;
        for (int i = 0; i < word.length(); i++) {
            m = p.matcher(word.substring(i,i+1));
//            System.out.println(word.substring(i,i+1));
            if (!m.matches()) {
                return false;
            }
        }
        return true;
    }

    public static Set<String> signature2Words(String signature) {
        Set<String> set = new HashSet<>();
        int pos = Collections.binarySearch(myDictionary, new WordSig(signature, null));
        if (pos < 0) return set;

        int backtrack = pos;

        //Move forward through the dictionary adding words with a matching signature to the result set
        while (pos < myDictionary.size() - 1 && myDictionary.get(pos).getSignature().equals(signature)) {
            set.add(myDictionary.get(pos).getWord());
            pos++;
        }
        //Move backwards through the dictionary adding words with a matching signature to the result set
        while (0 <= backtrack && myDictionary.get(backtrack).getSignature().equals(signature)) {
            set.add(myDictionary.get(backtrack).getWord());
            backtrack--;
        }
        return set;
    }

    public String toString() {
        StringBuffer buff = new StringBuffer();
        for (WordSig word : myDictionary) {
            buff.append(word.getSignature() + " : " + word.getWord() + "\n");
        }
        return buff.toString();
    }


    public static void main(String[] args) {
        Long startTime = System.nanoTime();
        ListDictionary l1 = new ListDictionary("smallDict.txt");
        Long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        System.out.println(l1);
//        signature2Words("227");

    }
}
