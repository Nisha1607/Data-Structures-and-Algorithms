public class ListNode{
  int val;
  ListNode next;
  ListNode(){}
  ListNode(int val){this.val=val}
  ListNode(int val,ListNode next){this.val=val;this.next=next;}

  public ListNode reverseList(ListNode head){
    if(head==null){
        return head;
    }
    ListNode curr=head->next,prev=head,front;
    prev->next=null;
    while(curr!=null){
        front = curr->next;
        curr->next=prev;
        prev=curr;
        curr=front;
    }
    return prev;
  }

  public static void main(String[] args){
    ListNode list = new ListNode();
    head = new ListNode(1);
    head.next=new ListNode(2);
    head.next.next=new ListNode(3);
    head = reverseList(head);
}
}
