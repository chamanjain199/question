package leetcode.biweekly.contest;

public class CalculateAmountPaidInTaxes {
    public static double calculateTax(int[][] brackets, int income) {
        if (income == 0) {
            return 0D;
        }
        int i = 0;
        double tax = 0;
        int amount = Math.min(income, brackets[0][0]);
        income = income - amount;
        tax += (amount * brackets[i][1]) / 100D;
        i++;


        while (income > 0) {
            amount = Math.min(income, brackets[i][0] - brackets[i - 1][0]);
            income = income - amount;
            tax += (amount * brackets[i][1]) / 100D;
            i++;
        }
        return tax;

    }

    public static void main(String[] args) {

        System.out.println(calculateTax(new int[][]{{1,0}, {4, 25}, {5, 50}}, 2));
    }
}
