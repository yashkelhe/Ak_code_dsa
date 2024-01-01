package divide_conquer.question;

public class q1 {
    public static String[] margeort(String[] arr, int lo, int hi) {
        // base case
        if (lo == hi) {
            String[] a = { arr[lo] };
            return a;
        }

        // calculate the mid
        int mid = lo + (hi - lo) / 2;
        // get the both side
        // left
        String[] str1 = margeort(arr, lo, mid);
        // right
        String[] str2 = margeort(arr, mid + 1, hi);

        String[] str3 = marge(str1, str2);
        return str3;

    }

    public static String[] marge(String[] str1, String[] str2) {
        int m = str1.length;
        int n = str2.length;
        String[] arr3 = new String[m + n];

        int index = 0;
        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (isAlphaBeticallySmaller(str1[i], str2[j])) {
                // true
                arr3[index] = str1[i];
                i++;
                index++;
            } else {
                arr3[index] = str2[j];
                index++;
                j++;
            }

        }

        // for remaining elements of the string array
        while (i < m) {
            arr3[index] = str1[i];
            i++;
            index++;
        }
        while (j < n) {

            arr3[index] = str2[j];
            index++;
            j++;
        }
        return arr3;
    }

    private static boolean isAlphaBeticallySmaller(String str1, String str2) {

        // here full based on the caracter when str1 and str2 are comapare then it will
        // see that which carcter of the string comes first take ex appple and orange
        // here1 " A" comes first then it will give you a neagtive value it means that
        // the str1 is smaller then str2
        if (str1.compareTo(str2) < 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] str = { "sun", "earth", "mars", "merrcury" };
        String[] st = margeort(str, 0, str.length - 1);
        for (int j = 0; j < st.length; j++) {
            System.out.print(st[j] + " ");
        }
    }
}

// 1. Initial call: margeort(str, 0, str.length - 1)
// 2. margeort(str, 0, 3)
// - str1 = margeort(str, 0, 1)
// - str2 = margeort(str, 2, 3)
// - str1 = margeort(str, 0, 0)
// - str2 = margeort(str, 1, 1)
// - returns { "sun" }
// - returns { "earth" }
// - returns { "sun", "earth" }
// - returns { "mars" }
// - returns { "sun", "earth", "mars" }
// - str1 = { "sun", "earth", "mars" }
// - str2 = { "merrcury" }
// 3. Final sorted array: { "sun", "earth", "mars", "merrcury" }
