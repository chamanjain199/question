package revision.tree;

public class ChildrenSumProperty {
    public static int isSumProperty(Node root)
    {
        return isSumPropertyRec(root)>-1?1:0;

    }
    public static int isSumPropertyRec(Node root)
    {
        if(root!=null){
            int leftSum=isSumPropertyRec(root.left);
            int rightSum=isSumPropertyRec(root.right);
            if(leftSum==-1 || rightSum==-1){
                return -1;
            }
            int sumOfChild=leftSum+rightSum;
            if(sumOfChild>0 && sumOfChild!=root.data){
                return -1;
            }else{
                return root.data;
            }
        }
        return 0;


    }
}
