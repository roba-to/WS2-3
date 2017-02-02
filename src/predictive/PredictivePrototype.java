package predictive;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** PredictivePrototype.java
 * PredictivePrototype is a class for Worksheet 3: Predictive Text Entry for
 * MSc Software Workshop, Spring Term 2016-2017
 *
 * This exercise assesses several concepts taught on the course
 * including data structures and algorithms.
 * Created by Robert Campbell on 31/01/2017.
 * @version 31/01/2017
 */
public class PredictivePrototype {
//    private static final String[] choices = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private static final String[] choices = {"", "", "[abc]", "[def]", "[ghi]", "[jkl]", "[mno]", "[pqrs]", "[tuv]", "[wxyz]"};
    private static final String keypad = "22233344455566677778889999";
    private static File path = new File("smallDict.txt");

    /** wordToSignature is a method that takes a word and
     * returns a numeric signature. For example. "home" should
     * return "4663" whereas "Help!" would return "4357 ".
     * If the word has any non-alphabetic characters,
     * those characters are replaced with whitespace in the result.
     *
     * A StringBuffer is used rather than a String as the append function
     * is a more efficient method of accumulating the result String
     * when compared with regular concatenation.
     *
     * @param word the word you wish to generate a signature for
     * @return a string containing a signature using numeric characters 2-9 inclusive and/or whitespace
     */
    public static String wordToSignature(String word) {
        int c; word = word.toLowerCase();

        StringBuffer buff = new StringBuffer();
        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i) - 'a';
            if (0 <= c && c <= 25) {
                buff.append(keypad.substring(c, c+1));
            }
            else {
                buff.append(" ");
            }
        }
        return buff.toString();
    }

    /** makePattern is a recursive method which takes a numeric signature
     * parameter and generates a regular expression String pattern to be used by
     * the signatureToWord method when searching a dictionary.
     *
     * Any value within the signature that is not in range 2-9 inclusive is ignored.
     *
     * @param signature the numeric signature
     * @return a regular expression String
     */
    public static String makePattern(String signature) {
        if (signature.length() < 1) {
            return "";
        }
//        If you wish to add auto-suggest functionality to the program then uncomment the following lines
//        else if (signature.length() == 1) {
//            return "[" + choices[Integer.parseInt(signature.substring(0,1))] + "].*";
//        }
        else if (Integer.parseInt(signature.substring(0,1)) <= 1 || Integer.parseInt(signature.substring(0,1)) > 9) {
            return makePattern(signature.substring(1));
        }
        else {
//            return "[" + choices[Integer.parseInt(signature.substring(0,1))] + "]" + makePattern(signature.substring(1));
            return choices[Integer.parseInt(signature.substring(0,1))] + makePattern(signature.substring(1));

        }
    }

    /** signatureToWords is a method that takes a numeric signature and
     * returns a set of possible matching words from the dictionary
     * (default dictionary: "smallDict.txt"). If the dictionary can not
     * be found then a fileNotFoundException will be thrown.
     *
     * The dictionary is stored in a .txt file and not within the Java program.
     * This implementation is inefficient as the dictionary must be read line by line
     * whereas a HashMap would allow for much quicker retrieval, removal, or addition of
     * elements to the dictionary.
     *
     * The method uses a scanner along with pattern matching of a generated
     * regular expression to find matching words from the dictionary .txt file
     * specified.
     *
     * The returned list of words does not have duplicates and each word is in lowercase.
     *
     * @param signature the numeric signature to be used for matching
     * @return a set of possible matching words from the dictionary
     */
    public static Set<String> signatureToWords(String signature) {
        String s; Matcher m; Pattern p;
        Set<String> set = new HashSet<>();

        try (Scanner scan = new Scanner(path)){
//            path = new File("words.txt");
            p = Pattern.compile(makePattern(signature));

            while (scan.hasNextLine()) {
                s = scan.nextLine();
                m = p.matcher(s);
                if (m.matches()) {
                    set.add(s.toLowerCase());
                }
            }
            scan.close();
            return set;
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
        return set;
    }

    public static void main(String[] args) {
//        System.out.println(wordToSignature("Hello"));
//        System.out.println(signatureToWords("22"));
//        System.out.println(wordToSignature("F**k"));
//        System.out.println(makePattern(""));


    }

}
