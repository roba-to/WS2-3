package predictive;
import java.io.File;
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
                    myDictionary.add(new WordSig(s));
                }
            }
            scan.close();
            Collections.sort(myDictionary);
        }
        catch (Exception fileNotFoundException) {
            System.out.println(path + " could not be found!");
        }
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
        ListDictionary l1 = new ListDictionary("smallDict.txt");

//        System.out.println(l1);
        signature2Words("227");
//        System.out.println(Collections.binarySearch(myDictionary, new WordSig()));
    }
}
