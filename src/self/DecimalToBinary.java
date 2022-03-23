package self;

public class DecimalToBinary {

    public  static  String decimalToBinary(int decimal){
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < 32; i++) {
            sb.append((decimal &1) );

           decimal= decimal>>1;

        }
        return sb.toString();
    }
    public static int getDecimal(int binary){
        int decimal = 0;
        int n = 0;
        while(true){
            if(binary == 0){
                break;
            } else {
                int temp = binary%10;
                decimal += temp*Math.pow(2, n);
                binary = binary/10;
                n++;
            }
        }
        return decimal;
    }

    public static void main(String[] args) {

        System.out.println(decimalToBinary(3));

    }
}
