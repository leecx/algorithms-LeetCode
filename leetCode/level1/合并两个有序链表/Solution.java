package level1.合并两个有序链表;


/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Solution {

    //类似并归排序
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode cur = listNode;
        while(l1.next!=null && l2.next!=null){
            if(l1.val < l2.val){        //l1链表提出来
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else{
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return cur.next;
    }


}



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

