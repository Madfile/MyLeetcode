import java.util.ArrayList;
import java.util.List;

public class Leetcode_1268_Search_Suggestions_System {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<List<String>>();

        for (int i = 0; i < searchWord.length(); i++) {
            List<String> candidates = new ArrayList<String>();
            addToCandidates(candidates, products, searchWord.substring(0, i + 1));

            result.add(candidates);
        }

        return result;
    }

    private void addToCandidates(List<String> candidates, String[] products, String word) {
        List<String> newCandidates = new ArrayList<String>();
        for (String product: products) {
            if (product.length() >= word.length() && product.substring(0, word.length()).equals(word)) {
                newCandidates.add(product);
            }
        }

        newCandidates.sort((a, b) -> {return a.compareTo(b);});

        for (int i = 0; i < 3 && i <newCandidates.size(); i++) {
            candidates.add(newCandidates.get(i));
        }
    }
}
