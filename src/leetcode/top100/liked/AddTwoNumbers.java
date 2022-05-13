package leetcode.top100.liked;


import java.time.LocalDateTime;


public class AddTwoNumbers {


    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummyhead = new ListNode(0);

        ListNode result = dummyhead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int currentSum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = currentSum / 10;
            result.next=new ListNode(currentSum % 10);
            result=result.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            result.next = new ListNode(carry);
        }


        return dummyhead.next;
    }
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        int sum=0;
        int carry=0;
        while (l1 != null || l2 != null) {
            int currentSum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = currentSum / 10;
            sum=sum*10+currentSum%10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry>0){
            sum=sum*10+carry;
        }
        int r=0;
        r=sum;
        ListNode rrrrr=null;
        while(r>0){
            sum=r%10;
            r=r/10;
            if(rrrrr==null){
                rrrrr=new ListNode(sum);
            }else{
                rrrrr=new ListNode(sum,rrrrr);
            }
        }
           return rrrrr;

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    public static void main(String[] args) {

        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(5);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(5);
        ListNode ln= addTwoNumbers(l1, l2);

        while (ln!=null){
            System.out.println(ln.val);
            ln=ln.next;
        }

    }
}
