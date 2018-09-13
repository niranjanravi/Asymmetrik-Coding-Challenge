import java.util.*;

public class PrefixTree {

    // A tree node represents a fragment of a word, and maps to other possible words formed from the fragment
    public class TreeNode{
        private String prefix;
        private HashMap<Character, TreeNode> children;
        private int confidence; // represents the number of times a word appears in the training data
        private boolean isWordEnd; // true if "prefix" is a full word

        public TreeNode(String s){
            prefix = s;
            children = new HashMap<>();
            confidence = 0;
        }

        public TreeNode(){
            this("");
        }

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

    // Add a word to the prefix tree, increasing its confidence if it's the end of a word
    public void addWord(String word){
        TreeNode current = root;
        for(char letter : word.toCharArray()){
            current.addLetter(letter);
            current = current.children.get(letter);
        }

        current.isWordEnd = true;
        current.confidence++;
    }

    private void findFullWords(TreeNode current, TreeSet<Candidate> words){
        if(current.isWordEnd){
            words.add(new CandidateImpl(current.prefix, current.confidence));
        }

        for(TreeNode child : current.children.values()){
            findFullWords(child, words);
        }
    }

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

        return new LinkedList<>(words);
    }
}
