import java.util.List;

public interface AutoCompleteProvider {
    List<Candidate> getWords(String fragment);
    void train(String passage);
}
