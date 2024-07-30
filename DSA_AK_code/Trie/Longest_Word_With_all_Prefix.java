package Trie;

public class Longest_Word_With_all_Prefix {
      public static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
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

    public static String ans= "";
    public static void longestWord(Node root, StringBuilder temp){
        if(root == null){
            return ;
        }

        for(int i = 0; i< 26; i++){
            if(root.children[i] != null && root.children[i].eow == true){
                char  ch = (char)( i+ 'a');
                     temp.append(ch);

                     if(temp.length() > ans.length()){
                        ans  = temp.toString();
                     }
                     longestWord(root.children[i], temp);
                     temp.deleteCharAt(temp.length()-1);
                }
        }
    }

    public static void main(String[] args) {
           String words[] = {"a", "banana", "appl", "apply", "apple", "app","ap"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }        
        longestWord(root,new StringBuilder(""));
        System.out.println(ans);
    }
    
}
