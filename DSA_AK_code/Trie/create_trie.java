package Trie;

public class create_trie {

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

    public static void main(String[] args) {
        String words[] = {"the", "a", "there", "their", "three", "any"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(search("the")); // true
        System.out.println(search("a")); // true
        System.out.println(search("yash")); // false
    }
}
