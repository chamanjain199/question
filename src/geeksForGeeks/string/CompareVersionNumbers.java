package geeksForGeeks.string;

public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        int i = 0;
        int j = 0;
        int len1 = version1.length();
        int len2 = version2.length();
        char ch1;
        char ch2;
        while (i < len1 && j < len2) {
            ch1 = version1.charAt(i);
            ch2 = version2.charAt(j);
            while ((ch1 == '0' || ch1=='.') && i < len1 - 1) {
                i++;
                ch1 = version1.charAt(i);
            }
            while ((ch2 == '0' || ch2=='.') && j < len2 - 1) {
                j++;
                ch2 = version2.charAt(j);
            }
            if (ch1 == ch2) {
                i++;
                j++;
            } else if (ch1 > ch2) {
                return 1;
            } else {
                return -1;
            }
        }
        if (i < len1) {
            ch1 = version1.charAt(i);
            while ((ch1 == '0' || ch1 == '.') && i < len1 - 1) {
                i++;
                ch1 = version1.charAt(i);

            }
        }
        if (j < len2) {
            ch2 = version2.charAt(j);
            while ((ch2 == '0' || ch2 == '.') && j < len2 - 1) {
                j++;
                ch2 = version2.charAt(j);
            }
        }
        if (i == len1 && j == len2) {
            return 0;
        }
        return len1 < len2 ? -1 : 1;

    }
    public static int compareVersion2(String version1, String version2) {
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
        System.out.println(compareVersion("0.1", "1.1"));
    }
}
