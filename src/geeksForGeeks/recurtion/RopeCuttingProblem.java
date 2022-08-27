package geeksForGeeks.recurtion;

public class RopeCuttingProblem {
    int max = -1;

    public int ropeCuttingProblem(int n, int a, int b, int c) {
        if (n <= 0) {
            return 0;
        }
        int arr[] = new int[]{a, b, c};

        recursion(n, arr, 0);
        return max;
    }

    int aya = 0;

    public int ropeCuttingProblem2(int n, int a, int b, int c,StringBuilder path) {
        System.out.println("n " + n + " a " + a + " b " + b + " c " + c+" "+path);
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        int maxByA = ropeCuttingProblem2(n - a, a, b, c,path.append("A"));
        path.deleteCharAt(path.length()-1);
        int maxByB = ropeCuttingProblem2(n - b, a, b, c,path.append("B"));
        path.deleteCharAt(path.length()-1);
        int maxByC = ropeCuttingProblem2(n - c, a, b, c,path.append("C"));
        path.deleteCharAt(path.length()-1);
        System.out.println("======== "+maxByA+" "+maxByB+" "+maxByC+" "+path);
        int max=Math.max(Math.max(maxByA,maxByB),maxByC);
        System.out.println("======== "+max);
        if(max==-1){

            return -1;
        }
        return max+1;

    }


    public void recursion(int n, int arr[], int parts) {
        if (n == 0) {
            if (parts > max) {
                System.out.println(" Max " + parts);
                max = parts;
            }
            return;
        }
        if (n < 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                max = n;
                return;
            }
            recursion(n - arr[i], arr, parts + 1);
        }
    }

    public static void main(String[] args) {
        RopeCuttingProblem ropeCuttingProblem = new RopeCuttingProblem();
        System.out.println(ropeCuttingProblem.ropeCuttingProblem2(6, 2, 3, 6,new StringBuilder()));
    }
}
