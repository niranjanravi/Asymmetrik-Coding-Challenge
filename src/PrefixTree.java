import java.util.*;

/**
 * Tree-based data structure that stores each character as a separate node
 */
public class PrefixTree {

    /**
     * Represents a single node in the tree. Each node represents the string of characters up to that node
     */
    public class TreeNode{
        private String prefix;
        private HashMap<Character, TreeNode> children;
        private int confidence; // represents the number of times a word appears in the training data
        private boolean isWordEnd; // true if it's a full word

        public TreeNode(String s){
            prefix = s;
            children = new HashMap<>();
            confidence = 0;
        }

        public TreeNode(){
            this("");
        }

        /**
         * Adds a new node to the tree
         * @param nextChar
         */
        public void addLetter(char nextChar){
            if(!children.containsKey(nextChar)){
                TreeNode child = new TreeNode(prefix + nextChar);
                children.put(nextChar, child);
            }
        }
    }

    private TreeNode root;

    public PrefixTree(){
        root = new TreeNode();
    }

    /**
     * Adds a word to the tree
     * @param word The word to be added into the tree
     */
    public void addWord(String word){
        TreeNode current = root;
        for(char letter : word.toCharArray()){
            current.addLetter(letter);
            current = current.children.get(letter);
        }

        // Update the wordEnd and confidence fields
        current.isWordEnd = true;
        current.confidence++;
    }

    /**
     * Recursively look through the tree to find all words
     * @param current The current node being looked at
     * @param words The set of all full words that have been found, maintaining order based on confidence
     */
    private void findFullWords(TreeNode current, TreeSet<Candidate> words){

        // TreeSets maintain order, so adding it automatically sorts the candidates
        if(current.isWordEnd){
            words.add(new CandidateImpl(current.prefix, current.confidence));
        }

        for(TreeNode child : current.children.values()){
            findFullWords(child, words);
        }
    }

    /**
     * Gets a list of known words that start with the given prefix
     * @param prefix The prefix
     * @return A list of words and their corresponding confidences
     */
    public List<Candidate> getKnownWords(String prefix){
        TreeSet<Candidate> words = new TreeSet<>();

        TreeNode start = root;
        for(char letter : prefix.toCharArray()){

            if(!start.children.containsKey(letter)){
                return Collections.emptyList();
            }

            start = start.children.get(letter);
        }

        findFullWords(start, words);

        // convert the TreeSet back into a list
        return new LinkedList<>(words);
    }
}
