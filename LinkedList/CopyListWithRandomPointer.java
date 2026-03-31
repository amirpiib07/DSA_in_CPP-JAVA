class Solution {
    public Node copy(Node head1){
        Node dummy = new Node(-1);
        Node temp= head1;
        Node k=dummy;
        while(temp!=null){
            Node temp1=new Node(temp.val);
            k.next=temp1;
            k=k.next;
            temp=temp.next;
        }

        return dummy.next;
    }
    public void connect(Node head1, Node head2){
        Node dummy= new Node(-1);
        Node i=head1;
        Node j=head2;
        Node k=dummy;
        
        while(j!=null){
            k.next=i;
            i=i.next;
            k=k.next;

            k.next=j;
            j=j.next;
            k=k.next;
        }
        
    }
    public void random(Node head1, Node head2){
        Node i=head1;
        Node j=head2;
        while(j!=null&&i!=null){
            if(i.random==null){
                j.random=null;
            }
            else{
                j.random=i.random.next;
            }
            i=i.next.next;
            if(j.next!=null) j=j.next.next;
        }
    }
    public void split(Node head1){
        Node dummy1= new Node(-1);
        Node temp1=dummy1;
        Node dummy2=new Node(-1);
        Node temp2=dummy2;
        Node i=head1;
        while(i!=null){
            temp1.next=i;
            i=i.next;
            temp1=temp1.next;

            temp2.next=i;
            i=i.next;
            temp2=temp2.next;
        }
        temp1.next=null;
    }
    public Node copyRandomList(Node head1){
        Node head2=copy(head1);
        connect(head1,head2);
        random(head1,head2);
        split(head1);
        return head2;
    }
}