package leetcode.top100.liked;

public class ListNode {
    public  int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void print(ListNode node){
        if(node==null){
            return;
        }
        System.out.println(node.val);
        print(node.next);
    }
}
