package Trie;

public class Count_Unique {
    
  public static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {


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

    
        public static  int CountUnique(Node root){
                if(root == null){
                    return  0;
                }
                int count = 0;

                for(int i = 0 ; i < 26; i++){
                    if(root.children[i ]!= null){
                            count+= CountUnique(root.children[i]);
                    }
                }
                return count + 1;
        }


    public static void main(String[] args) {
        String str = "ababa";
        // ans = 10 ;
            for (int i = 0 ; i < str.length(); i++){
                // it will give me suffix
                String suffix = str.substring(i);
                insert(suffix);
            }


            System.out.println(CountUnique(root));
    }
}