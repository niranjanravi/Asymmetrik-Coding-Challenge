import java.util.Comparator;

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


    @Override
    public int compareTo(Candidate o) {
        if(o.getConfidence() != confidence){
            return o.getConfidence() - confidence;
        }
        return word.compareTo(o.getWord());
    }
}
