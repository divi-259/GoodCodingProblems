import java.util.*;

/*

Given a list, remove the nodes whose consecutive sum is equal to zero.

Ex:  (2) -> (3) -> (-5) -> (7) -> (3) -> (-3)

Output will be (7) as the first three and last two consecutive nodes are giving sum as 0.

Solution Approach:
We should take a hashmap to keep the cumulative sum in check, and as soon as we find a sum that is already
in the hashmap, we can remove the nodes in between.

*/

class RemoveConsecutiveListNodes {

    public static void main(String args[]) {
        ListNode head = new ListNode(9);
        ListNode newnode1 = new ListNode(-3);
        head.next = newnode1;
        ListNode newnode2 = new ListNode(-5);
        newnode1.next = newnode2;
        ListNode newnode3 = new ListNode(8);
        newnode2.next = newnode3;
        newnode3.next = null;
        System.out.println("Given List is:");
        print(head);
        System.out.println("After removing consecutive nodes that sum to 0:");
        
        print(removeNodes(head));
    }

    private static void print(ListNode head) {
        ListNode temp = head;
        while(temp!=null) {
            System.out.print(temp.val);
            System.out.print("  ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static ListNode removeNodes(ListNode head) {

        ListNode dummy = new ListNode(-100000);
        dummy.next = head;
        HashMap<Integer, ListNode> hmap = new HashMap<>();
        hmap.put(0, dummy); // for the dummy node and in case we get sum 0 somewhere

        ListNode temp = head;
        int sum = 0;
        while(temp!=null) {
            sum = sum + temp.val;
            if(hmap.containsKey(sum)) {
                ListNode first = hmap.get(sum); // the node which we need to keep
                // need to remove all the nodes from hashmap in between 
                {
                    ListNode curr = first.next;
                    while(curr!=temp) {
                        hmap.remove(curr.val);
                        curr = curr.next;
                    }
                }
                first.next = temp.next;

            }
            ListNode temp2 = temp;
            hmap.put(sum, temp2);
            temp = temp.next;
        }
        return dummy.next;

    }

}

