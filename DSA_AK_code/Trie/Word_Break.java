package Trie;

public class Word_Break {
    
    public static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }
     public static Node root;

   public static void insert(String word) {
        if (root == null) {
            root = new Node();
        }

        Node curr = root;

        // it will go up to the word length
        for (int level = 0; level < word.length(); level++) {
            // find the index by sub "a"
            int index = word.charAt(level) - 'a';
            // then check whether the node is present or not
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            // then go to the next element means go to that element
            curr = curr.children[index];
        }
        // make the eow true to indicate the word is added
        curr.eow = true;
    }



        public static boolean search(String key) {
        if (root == null) {
            return false;
        }

        Node curr = root;

        for (int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        // return true if it's the end of a word
        return curr.eow;
    }
        // this is linear TC

    public static boolean wordBreak( String key){
            if(key.length() == 0 ){
                // why true beacouse when the second port becouse empty then we have to only serch for the first part
                return true;
            }
        for( int  i = 1 ; i<=key.length(); i++){
                // here we are searching for the two words first the part is 0 i and then second part is raeminaing ppart of the String means that 
                // if we founda string which a two string in present in rthe trie then true else false 
            if(search(key.substring(0, i)) &&
             wordBreak(key.substring(i))){
                    return true;
            }
        }

        return false ;
    }
    public static void main(String[] args) {
                 String words[] = {"i", "like", "samsung", "ice", "sam", "mobile"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        String key = "ilikesamsung";
        System.out.println(wordBreak(key));

    }   
}
