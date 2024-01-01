package recursion;

// to remove the Duplicate char 
public class Remove_Duplicate {

    public static void removeDuplicateString(String str, int index, StringBuilder newStr, Boolean[] map) {
        // base case

        if (index == str.length()) {

            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(index);
        int charIndex = currChar - 'a'; // Correct index for the character

        // here we are chacking that is there in array already a some value at the index
        // where we want to store the unDuplicate value
        if (map[charIndex] != null && map[charIndex]) {
            // Character is a duplicate

            removeDuplicateString(str, index + 1, newStr, map);
        } else {
            // Non-duplicate character, mark it as encountered
            map[charIndex] = true;

            removeDuplicateString(str, index + 1, newStr.append(currChar), map);
        }
    }

    public static void main(String[] args) {
        String str = "appnnacollege";
        removeDuplicateString(str, 0, new StringBuilder(""), new Boolean[26]); // Increase array size to 26 for all
                                                                               // lowercase letters
    }
}
