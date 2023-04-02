package revision.bitmanipulation;

public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        int maxProduct = 0;
        int n = words.length;
        int[] binaryWords = new int[n];
        char[] ch;
        for (int i = 0; i < n; i++) {
            ch = words[i].toCharArray();
            int number = 0;
            for (char c : ch) {
                number = number | (1 << (c - 'a'));
            }
            binaryWords[i] = number;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((binaryWords[i] & binaryWords[j]) == 0) {
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
                }
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {

    }
}
