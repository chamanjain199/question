package leetcode.top100.liked;

public class IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        while(headA.next!=null){
            headA.val=-headA.val;
            headA=headA.next;
        }
        while(headB.next!=null){
            if(headB.val<0){
                break;
            }
            headB=headB.next;
        }
        return headB;

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0;
        ListNode headAT=headA;
        while(headAT!=null){
            headAT=headAT.next;
            lenA++;
        }
        int lenB=0;
        ListNode headBT=headB;
        while(headBT!=null){
            headBT=headBT.next;
            lenB++;
        }

        if(lenA!=lenB){
            int diff=0;
            if(lenA>lenB){
                diff=lenA-lenB;
                while(diff>0){
                    headA=headA.next;

                    diff--;
                }
            }
            else{
                diff=lenB-lenA;
                while(diff>0){
                    headB=headB.next;

                    diff--;
                }
            }
        }

        while(headA!=null){
            if(headA==headB){
                break;
            }else{
                headB=headB.next;
                headA=headA.next;
            }
        }
        return headA;

    }
}
