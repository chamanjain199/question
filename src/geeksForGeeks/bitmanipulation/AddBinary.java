package geeksForGeeks.bitmanipulation;

public class AddBinary {
    public static String addBinary(String a, String b) {
        int aLength = a.length() - 1;
        int bLength = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        char aChar;
        char bChar;
        while (aLength > 0 && bLength >0) {
            aChar = a.charAt(aLength);
            bChar = b.charAt(bLength);
            if (aChar == '1' && bChar == '1') {
                if (carry == 0) {
                    sb.append('0');
                    carry = 1;
                } else {
                    sb.append('1');
                }
            } else if (aChar == '1' || bChar == '1') {
                if (carry == 0) sb.append('1');
                else {
                    sb.append('0');
                }
            } else {
                if (carry == 0) sb.append('0');
                else {
                    sb.append('1');
                    carry = 0;
                }
            }
            aLength--;
            bLength--;
        }

        if (aLength >= 0) {

            while (aLength >= 0) {
                aChar = a.charAt(aLength);
                if (aChar == '1' && carry == 1) {
                    sb.append('0');
                } else if (aChar == '1' || carry == 1) {
                    sb.append('1');
                    carry = 0;
                } else {
                    sb.append(aChar);
                }
                aLength--;
            }
            if (carry == 1) {
                sb.append('1');
            }

        } else {
            while (bLength >= 0) {
                bChar = b.charAt(bLength);
                if (bChar == '1' && carry == 1) {
                    sb.append('0');
                } else if (bChar == '1' || carry == 1) {
                    sb.append('1');
                    carry = 0;
                } else {
                    sb.append(bChar);
                }
                bLength--;
            }
            if (carry == 1) {
                sb.append('1');
            }

        }

        return sb.reverse().toString();
    }

    public String addBinaryOp(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        int sum;
        while (i >= 0 && j >= 0) {
            sum = Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(j)) + carry;
            sb.append(sum % 2);
            carry = sum >= 2 ? 1 : 0;
            i--;
            j--;
        }
        while (i >= 0) {
            sum = Character.getNumericValue(a.charAt(i)) + carry;
            sb.append(sum % 2);
            carry = sum >= 2 ? 1 : 0;
            i--;
        }
        while (j >= 0) {
            sum = Character.getNumericValue(b.charAt(j)) + carry;
            sb.append(sum % 2);
            carry = sum >= 2 ? 1 : 0;
            j--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static String addBinaryShortCodeButTakingTime(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        String zeros = "0".repeat(Math.abs(aLength - bLength));
        if (aLength > bLength) {
            b = zeros + b;
        } else {
            a = zeros + a;
        }
        aLength=a.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        char aChar;
        char bChar;
        while (aLength > 0) {
            aLength--;
            aChar = a.charAt(aLength);
            bChar = b.charAt(aLength);
            if (aChar == '1' && bChar == '1') {
                if (carry == 0) {
                    sb.append('0');
                    carry = 1;
                } else {
                    sb.append('1');
                }
            } else if (aChar == '1' || bChar == '1') {
                if (carry == 0) sb.append('1');
                else {
                    sb.append('0');
                }
            } else {
                if (carry == 0) sb.append('0');
                else {
                    sb.append('1');
                    carry = 0;
                }
            }

        }
        if (carry == 1) sb.append('1');

        return sb.reverse().toString();
    }

    public static String addBinary1(String a, String b) {
        int aLength = a.length() - 1;
        int bLength = b.length() - 1;

        int carry = 0;

        StringBuilder sb = new StringBuilder();
        char aChar;
        char bChar;
        while (aLength >= 0 && bLength >= 0) {
            aChar = a.charAt(aLength);
            bChar = b.charAt(bLength);
            if (aChar == '1' && bChar == '1') {
                if (carry == 0) {
                    sb.append('0');
                    carry = 1;
                } else {
                    sb.append('1');
                }
            } else if (aChar == '1' || bChar == '1') {
                if (carry == 0) sb.append('1');
                else {
                    sb.append('0');
                }
            } else {
                if (carry == 0) sb.append('0');
                else {
                    sb.append('1');
                    carry = 0;
                }
            }
            aLength--;
            bLength--;
        }

        if (aLength >= 0) {

            while (aLength >= 0) {
                aChar = a.charAt(aLength);
                if (aChar == '1' && carry == 1) {
                    sb.append('0');
                } else if (aChar == '1' || carry == 1) {
                    sb.append('1');
                    carry = 0;
                } else {
                    sb.append(aChar);
                }
                aLength--;
            }
            if (carry == 1) {
                sb.append('1');
            }

        } else {
            while (bLength >= 0) {
                bChar = b.charAt(bLength);
                if (bChar == '1' && carry == 1) {
                    sb.append('0');
                } else if (bChar == '1' || carry == 1) {
                    sb.append('1');
                    carry = 0;
                } else {
                    sb.append(bChar);
                }
                bLength--;
            }
            if (carry == 1) {
                sb.append('1');
            }

        }

        return sb.reverse().toString();
    }

    public static String addBinary2(String a, String b) {
        int aLength = a.length() - 1;
        int bLength = b.length() - 1;

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        char aChar;
        char bChar;
        while (aLength >= 0 && bLength >= 0) {
            aChar = a.charAt(aLength);
            bChar = b.charAt(bLength);
            if (aChar == '1' && bChar == '1') {
                if (carry == 0) {
                    sb.append('0');
                    carry = 1;
                } else {
                    sb.append('1');
                }
            } else if (aChar == '1' || bChar == '1') {
                if (carry == 0) sb.append('1');
                else {
                    sb.append('0');
                }
            } else {
                if (carry == 0) sb.append('0');
                else {
                    sb.append('1');
                    carry = 0;
                }
            }
            aLength--;
            bLength--;
        }

        if (aLength >= 0) {

            while (aLength >= 0) {
                aChar = a.charAt(aLength);
                if (aChar == '1' && carry == 1) {
                    sb.append('0');
                } else if (aChar == '1' || carry == 1) {
                    sb.append('1');
                    carry = 0;
                    break;
                } else {
                    sb.append(aChar);
                }
                aLength--;
            }
            if (aLength >= 0) {
                sb.append(new StringBuilder().append(a, 0, aLength).reverse());
            }
            if (carry == 1) {
                sb.append('1');
            }

        } else {
            while (bLength >= 0) {
                bChar = b.charAt(bLength);
                if (bChar == '1' && carry == 1) {
                    sb.append('0');
                } else if (bChar == '1' || carry == 1) {
                    sb.append('1');
                    carry = 0;
                    break;
                } else {
                    sb.append(bChar);
                }
                bLength--;
            }
            if (bLength >= 0) {
                sb.append(new StringBuilder().append(b, 0, bLength).reverse());
            }
            if (carry == 1) {
                sb.append('1');
            }

        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println(addBinary("11", "1"));
    }
}
