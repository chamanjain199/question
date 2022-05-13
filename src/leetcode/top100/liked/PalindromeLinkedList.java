package leetcode.top100.liked;

public class PalindromeLinkedList {
    public static boolean isPalindromeWorst(ListNode head) {
        StringBuilder sb=new StringBuilder();
        while (head!=null){
            sb.append(head.val);
            head=head.next;
        }
        return sb.toString().equals(new StringBuilder(sb.reverse()).toString());
    }
    public static boolean isPalindromeMy(ListNode head) {
        int size=0;
        ListNode newHead=head;
        while (head!=null){
            head=head.next;
            size++;
        }
        boolean isOdd=size%2!=0;

        size=size/2;
        ListNode prev = null;
        while ( size>0) {
            ListNode next = newHead.next;
            newHead.next = prev;
            prev = newHead;
            newHead = next;
            size--;
        }
        if(isOdd){
            newHead=newHead.next;
        }
        while (prev!=null){
            if(prev.val!=newHead.val){
                return false;
            }
            prev=prev.next;
            newHead=newHead.next;
        }

        return true;
    }
    public static boolean isPalindromeBest(ListNode head) {
        int n1=0;
        int n2=0;
        int count=1;
        while(head!=null){
            n1 = n1 * 10 + head.val;
            n2 = head.val * count + n2;
            count = count * 10;
            head = head.next;
        }
        return n1==n2;
    }

    public static boolean isPalindromeJustAnotherSol(ListNode head) {
        ListNode minNode=midNode(head);
        ListNode reverse=reverseList(minNode);
        while (head!=null){
            if(head.val!=reverse.val){
                return false;
            }
            head=head.next;
            reverse=reverse.next;
        }

        return true;
    }
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private static ListNode midNode(ListNode head) {
        ListNode mid=head.next;
        while (mid!=null && mid.next!=null){
            head=head.next;
            mid=mid.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(1);

        System.out.println(isPalindromeBest(node));

    }
}
