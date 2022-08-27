package geeksForGeeks.bitmanipulation;

public class RightMostDiffBit {
    public static int posOfRightMostDiffBit(int m, int n)
    {
        if(m==n){
            return -1;
        }
        int rs=m^n;
        rs=rs&(-rs);

        int res = (int) (Math.log(rs) / Math.log(2));
        return res + 1;
    }
    public static void main(String[] args) {

    }
}
