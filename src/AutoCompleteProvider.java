import java.util.List;

public interface AutoCompleteProvider {
    /**
     * Return a list of candidates ordered by confidence
     * @param fragment The fragment that all of the candidates start with
     */
    List<Candidate> getWords(String fragment);

    /**
     * Trains the provider with the given passage
     * @param passage The passage to train the algorithm on
     */
    void train(String passage);
}
