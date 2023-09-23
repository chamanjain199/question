package revision.tree;

class Node
{
    int data;
    Node left, right,next;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}