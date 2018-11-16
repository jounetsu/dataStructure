package linkedList;

/**
 * 链表相关
 *
 * @author wangjinfei
 * @date 2018/11/07
 */
public class LinkedListAlgo {

    //单链表反转
    private static Node reverse(Node list){
        Node headNode = null;
        Node previousNode = null;
        Node currentNode = list;
        while (currentNode != null){
            Node nextNode = currentNode.next;
            if(nextNode == null){
                headNode = currentNode;
            }
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return headNode;

    }

    //检测环
    private static boolean isCircle(Node list){
        if(list == null) return false;
        Node fast = list.next;
        Node slow = list;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) return true;
        }
        return false;
    }

    //有序链表合并
    private static Node mergeSortedLists(Node la, Node lb){
        if(la == null) return lb;
        if(lb == null) return la;

        Node p = la;
        Node q = lb;
        Node head = null;
        if(p.getData() < q.getData()){
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }

        Node r = head;
        while (p != null && q != null){
            if(p.getData() < q.getData()){
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }

        if (p != null){
            r.next = p;
        } else {
            r.next = q;
        }

        return head;
    }

    //删除倒数第k个节点1
    private static Node deleteLastKthOne(Node list, int k){
        Node fast = list;
        int i = k;
        while (fast != null && i < k){
            fast = fast.next;
            i++;
        }

        if(fast == null) return null;//k大于链表长度

        Node slow = list;
        Node pre = null;
        while (fast.next != null){
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        if(pre == null){
            list = list.next;
        } else {
            pre.next = pre.next.next;
        }

        return list;
    }

    //删除倒数第k个节点2
    private static Node deleteLastKthTwo(Node list, int k){
        Node head = new Node(null,0);
        head.next = list;
        Node first = head;
        Node second = head;
        for(int i = 1; i < k + 1; ++i){
            first = first.next;
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;

        return head.next;
    }

    //求中间节点
    private static Node findMiddleNode(Node list){
        if(list == null) return null;
        Node fast = list;
        Node slow = list;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static class Node{
        private Node next;
        private int data;

        public Node(Node next, int data){
            this.next = next;
            this.data = data;
        }

        public int getData() {
            return this.data;
        }
    }
}
