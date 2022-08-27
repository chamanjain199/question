package geeksForGeeks.bitmanipulation;

public class UTF8Validation {
    public static boolean validUtf8(int[] data) {
        int remainingBits = 0;
        for (int num :
                data) {
            System.out.println(Integer.toBinaryString(num));
            if (0 == remainingBits) {
                if ((num >> 7) != 0b0) {
                    if ((num >> 5) == 0b110) {
                        remainingBits = 1;
                    } else if ((num >> 4) == 0b1110) {
                        remainingBits = 2;
                    } else if ((num >> 3) == 0b11110) {
                        remainingBits = 3;
                    }else  return false;
                }
            } else {
                if ((num >> 6) == 0b10) {
                    remainingBits--;
                } else {
                    return false;
                }
            }
        }
        return remainingBits == 0;
    }

    public static void main(String[] args) {
        System.out.println(validUtf8(new int[]{255}));
    }
}
