package leetcode.top100.liked;

import java.util.ArrayList;
import java.util.List;

class Node {
    int value;
    Node left;
    Node right;
}

class DLL {
    Node root;

    public boolean isAdded(int el) {
        Node newNode = new Node();
        newNode.value = el;
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        Node parent = root;

        while (temp != null) {
            parent=temp;
            if (temp.value > el) {
                temp = temp.left;
            } else if (temp.value < el) {
                temp = temp.right;
            } else if (temp.value == el) {
                return false;
            }
        }
        if (parent.value > el) {
            parent.left = newNode;
        } else if (parent.value < el) {
            parent.right =newNode;
        }
        return true;
    }

}

public class FindAllDuplicate {
    public  static List<Integer> findDuplicatesOld(int[] nums) {
        List<Integer> li = new ArrayList<>();
        DLL d = new DLL();
        for (int i = 0; i < nums.length; i++) {
            if (!d.isAdded(nums[i])) {
                li.add(nums[i]);
            }
        }
        return li;
    }
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] freq =  new int[nums.length+1];
        for(int i=0;i<nums.length;i++)
            freq[nums[i]]++;
        for(int i=0;i<freq.length;i++)
            if(freq[i]>1)
                ans.add(i);
        return ans;
    }
    public static List<Integer> findDuplicates1(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] freq =  new int[nums.length+1];
        for(int i=0;i<nums.length;i++) {
            if(freq[nums[i]]==1) {
               ans.add(nums[i]);
            }else{
                freq[nums[i]]++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(findDuplicates1(new int[]{4,3,2,7,8,2,3,1}));
    }
}
