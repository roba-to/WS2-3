package predictive;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Rob on 10/02/2017.
 */
public class TreeDictionary implements Dictionary {
    private TreeDictionary[] children;
    private Set<String> words;

    public TreeDictionary() {
        this.children = new TreeDictionary[8];
        this.words = new HashSet<>();
    }

    public TreeDictionary(String path) {
        this.children = new TreeDictionary[8];
        this.words = new HashSet<>();
        String s;

        try (Scanner scan = new Scanner(new File(path))) {

            while (scan.hasNextLine()) {
                s = scan.nextLine();
                if (ListDictionary.isValidWord(s)) {
//                    System.out.println(s);
                    addWord(s, s);
                }
            }
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public void addWord(String word, String input) {
        if (input.length() >= 1) {
            int i = Integer.parseInt(PredictivePrototype.wordToSignature(input.substring(0,1))) - 2;

            if (getChildren()[i] == null) {
                getChildren()[i] = new TreeDictionary();
                getChildren()[i].getWords().add(word);
            }
            else {
                getChildren()[i].getWords().add(word);
                getChildren()[i].addWord(word, input.substring(1));
            }
        }
    }

    public Set<String> getWords() {
        return words;
    }

    public TreeDictionary[] getChildren() {
        return children;
    }

    @Override
    public Set<String> signatureToWords(String signature) {
        return trimSignatureToWords(signature, signature.length());
    }

    public Set<String> trimSignatureToWords(String signature, int trimmedLength) {
        int i = Integer.parseInt(signature.substring(0,1)) - 2;
//        System.out.println(signature);
        if (getChildren()[i] == null) {
            return new HashSet<>();
        }
        else if (signature.length() == 1) {
            Set<String> results = new HashSet<>();
            for (String s : getChildren()[i].getWords()) {
                results.add(s.substring(0, trimmedLength));
            }
            return results;
        }
        else {
            return getChildren()[i].trimSignatureToWords(signature.substring(1), trimmedLength);
        }
    }

    public static void main(String[] args) {
        TreeDictionary t1 = new TreeDictionary("words.txt");

//        System.out.println("2: " + t1.signatureToWords("2"));
        System.out.println("27753: " + t1.signatureToWords("27753"));
//        System.out.println("3: " + t1.signatureToWords("3"));
//        System.out.println("4: " + t1.signatureToWords("4"));
//        System.out.println("5: " + t1.signatureToWords("5"));
//        System.out.println("6: " + t1.signatureToWords("6"));
//        System.out.println("7: " + t1.signatureToWords("7"));
//        System.out.println("8: " + t1.signatureToWords("8"));
//        System.out.println("9: " + t1.signatureToWords("9"));


//        TreeDictionary[] t2 = new TreeDictionary[8];
//
//        t2[0] = new TreeDictionary();
//        t2[0].words.add("test");
//        for (TreeDictionary tree : t2) {
//            if (tree != null) {
//                System.out.println(tree.getWords());
//            }
//        }
//
//        String s = "a";
//        int i = Integer.parseInt(PredictivePrototype.wordToSignature(s.substring(0,1)));
//        System.out.println(i);




    }
}
