package geeksForGeeks.mathematics;

public class DigitsInFactorial {

        public static int digitsInFactorial(int N){
            double sum = 0;
            for(int i = 1; i <= N; i++)
                sum = sum + Math.log10(i);
            sum= Math.floor(sum)+1.0;
            return (int)sum;
        }

    public static void main(String[] args) {
        digitsInFactorial(5);
    }
}
