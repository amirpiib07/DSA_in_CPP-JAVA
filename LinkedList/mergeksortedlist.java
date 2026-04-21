/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode merge(ListNode a, ListNode b){
        ListNode dummy=new ListNode(-1);
        ListNode i=a;
        ListNode j=b;
        ListNode k=dummy;
        while(i!=null&&j!=null){
            if(i.val<=j.val){
                k.next=i;
                i=i.next;
                k=k.next;
            }
            else{
                k.next=j;
                j=j.next;
                k=k.next;
            }
            if(i!=null){
                k.next=i;
            }
            if(j!=null){
                k.next=j;
            }
        }

        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        
        ArrayList<ListNode> node1 = new ArrayList<>();
        for (ListNode ele : lists) {
            if(ele!=null)
            node1.add(ele);
        }
        if(node1.size()==0){
            return null;
        }
        
        
        while(node1.size()>1){
            ListNode a = node1.get(0);
            ListNode b = node1.get(1);
            ListNode c = merge(a, b);
            node1.remove(1);
            node1.remove(0);
            node1.add(c);
            
        }

        return node1.get(0);

    }
}