import java.util.Comparator;

/**
 * Stores a word and its confidence
 */
public class CandidateImpl implements Candidate, Comparable<Candidate> {

    private String word;
    private int confidence;

    public CandidateImpl(String word, int confidence){
        this.word = word;
        this.confidence = confidence;
    }

    @Override
    public String getWord() {
        return word;
    }

    @Override
    public int getConfidence() {
        return confidence;
    }

    public void increaseCount(){
        confidence++;
    }

    public String toString(){
        return word + " (" + confidence + ")";
    }


    /**
     * Compares the confidence first, and then compares the words
     * @param o The candidate to compare the current candidate to
     * @return
     */
    @Override
    public int compareTo(Candidate o) {
        if(o.getConfidence() != confidence){
            return o.getConfidence() - confidence;
        }
        return word.compareTo(o.getWord());
    }
}
