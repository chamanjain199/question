package geeksForGeeks;


class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class AddTwoNumberByLL {
    //Function to add two numbers represented by linked list.
    static Node reverse(Node n){
        Node prev = null;
        Node newLink = n;
        Node currentNode = n;
        while (newLink != null) {
            newLink = newLink.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = newLink;
        }
        return prev;
    }

    static Node addTwoLists(Node first, Node second){
        first=reverse(first);
        second=reverse(second);
        Node head=new Node(0);
        Node ll=head;
        int x=0;
        int y=0;
        int curry=0;
        int sum=0;
        while(first!=null || second!=null){

            x=first==null?0:first.data;
            y=second==null?0:second.data;
            sum=curry+x+y;
            curry=sum/10;
            head.next=new Node(sum%10);
            head=head.next;
            first=first!=null?first.next:null;
            second=second!=null?second.next:null;

        }
        if(curry>0){
            head.next=new Node(curry);
        }

        return reverse(ll.next);
    }

    public static void main(String[] args) {

        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(3);
//        while (n!=null){
//            System.out.println(n.data);
//            n=n.next;
//        }
        Node r = reverse(n);
        while (r != null) {
            System.out.println(r.data);
            r = r.next;
        }
    }
}