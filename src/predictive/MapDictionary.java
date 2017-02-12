package predictive;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Rob on 10/02/2017.
 */
public class MapDictionary implements Dictionary {
    private TreeMap<String, Set<String>> map = new TreeMap<>();

    public MapDictionary(String path) {
        String s;

        try (Scanner scan = new Scanner(new File(path))) {

            while (scan.hasNextLine()) {
                s = scan.nextLine().toLowerCase();
                if (ListDictionary.isValidWord(s)) {
                    map.computeIfAbsent(PredictivePrototype.wordToSignature(s), k -> new HashSet<>()).add(s);
                }
            }
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Set<String> signatureToWords(String signature) {
        if (map.get(signature) == null) {
            return new HashSet<>();
        }
        else {
            return map.get(signature);
        }
    }

    public static void main(String[] args) {
//        TreeMap<String, Set<String>> test = new TreeMap<>();

//        test.put("227", new HashSet<>());
//        test.get("227").add("bap");
//        test.get("227").add("bar");
//
//        System.out.println(test.get("227").toString());
//
//        test.computeIfAbsent("227", k -> new HashSet<>()).add("car");
//
//        System.out.println(test.get("227").toString());
//
//        test.computeIfAbsent("227", k -> new HashSet<>()).add("car");
//
//        System.out.println(test.get("227").toString());

        MapDictionary md = new MapDictionary("words.txt");

//        Note that the starting 0 is an invalid signature number and thus no matches should be found
        System.out.println(md.signatureToWords("04663"));

    }
}
