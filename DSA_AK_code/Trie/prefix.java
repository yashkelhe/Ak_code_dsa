package Trie;

public class prefix {


    public static  class Node{
        Node [] children =new Node[26];
        boolean eow  = false;
        int freq ;

        public Node(){
            for(int i  = 0 ; i< children.length; i++){
                children[i] = null ;
            }
            freq = 1 ;
        }
     }  

     public static Node root = new Node();

    //  insert function 

 public static void insert(String word) {
    // first we check that weather the root initialize or not 
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
            }else{
                curr.children[index].freq++;
            }
            // then go to the next element means go to that element
            curr = curr.children[index];
        }
        // make the eow true to indicate the word is added
        curr.eow = true;
    }   
    // O(l) TC
    public static void findPrfix(Node root , String Ans){
        if( root == null){
            return;
        }
        if(root.freq == 1){
                System.out.println(Ans );
                return;
        }
        for(int i=0 ; i < root.children.length ; i++){
            if(root.children[i] != null){ 
                            // is i is a then it will store the b in rthe ans  
                    findPrfix(root.children[i], Ans+(char)(i+'a'));
            }
        }
    }
    public static void main(String[] args) {
        
        String words[] = {"zebra", "dog", "duck", "dove"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }


        root.freq = -1;

        findPrfix(root,"" );
    }
}
