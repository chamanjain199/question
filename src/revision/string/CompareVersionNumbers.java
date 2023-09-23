package revision.string;

public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int len1 = arr1.length;
        int len2 = arr2.length;
        int min = Math.min(len1, len2);
        int i = 0;
        for (; i < min; i++) {
            int num1 = Integer.parseInt(arr1[i]);
            int num2 = Integer.parseInt(arr2[i]);
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }
        boolean isMore = false;
        while (i < len1) {
            int num1 = Integer.parseInt(arr1[i]);
            if (num1 > 0) {
                return 1;
            }
            i++;

        }
        while (i < len2) {
            int num1 = Integer.parseInt(arr2[i]);
            if (num1 > 0) {
                return -1;
            }
            i++;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.0.1", "1"));
    }
}
