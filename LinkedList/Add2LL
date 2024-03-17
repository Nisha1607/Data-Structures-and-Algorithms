public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode ans=res;
        int carry=0;
        while(l1!=null || l2!=null){
            int sum=((l1!=null)?l1.val:0)+((l2!=null)?l2.val:0)+carry;
            
                res.next=new ListNode(sum%10);
                carry=sum/10;
            
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
            res=res.next;
        }
        if(carry>0)
            res.next=new ListNode(carry);
        return ans.next;
    }
