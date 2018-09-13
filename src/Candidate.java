public interface Candidate {

    /**
     * Returns the autocomplete candidate
     */
    String getWord();

    /**
     * Return the confidence of the candidate
     */
    int getConfidence();
}
