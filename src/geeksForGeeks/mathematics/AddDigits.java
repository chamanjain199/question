package geeksForGeeks.mathematics;

public class AddDigits {
    public int addDigits(int num) {
        int ans=0;
        while(num>0){
            ans+=num%10;
            num=num/10;
        }
        if(ans>=10){
            return addDigits(ans);
        }
        return ans;

    }
}
