import java.util.*;

public class AutoCompleteProviderImpl implements AutoCompleteProvider {

    private PrefixTree prefixes;

    public AutoCompleteProviderImpl() {
        prefixes = new PrefixTree();
    }

    @Override
    public List<Candidate> getWords(String fragment) {
        return prefixes.getKnownWords(fragment.toLowerCase());
    }

    @Override
    public void train(String passage) {
        String[] words = passage.split("[\\p{Punct}\\s]+");

        for(String word : words){
            word = word.toLowerCase();
            prefixes.addWord(word);
        }
    }

}
