package arithmeticDemo;
//疑问：Java中怎么模仿C语言中的结构体指针   2020.5.25   
public class LinkedList { 
	
	public ListNode head;
	public ListNode current;  //c语言的p结构体指针
	
	class ListNode{     //相当于C语言的结构体
		
		int val;   //数据域
		ListNode next = null; //指针域
		
		public ListNode(int val) {
			this.val =val;
		}
		
	}
	
	//尾插法建立单链表
	public void CreateList_L(int data) {
		//判断链表为空的时候
		if(head == null) { //如果头结点为空，说明这个链表还没有创建，那就把新的结点赋给头结点
			head = new ListNode(data);
			current = head;
		}else {
			//创建新的结点，放在当前节点的后面（把新的结点合链表进行关联）
			current.next = new ListNode(data);
            //把链表的当前索引向后移动一位
			current = current.next;   //此步操作完成之后，current结点指向新添加的那个结点
		}
		
	}
	
	//头插法建立单链表
	public void CreateList_H(int data) {
		if(head == null) {
			head = new ListNode(data);
			//current = head;
		}else {
			ListNode node = new ListNode(data);
			node.next = head;
			head = node;
		}
	}
	
	//方法：遍历链表（打印输出链表。方法的参数表示从节点node开始进行遍历
    public void print(ListNode node) {
        if (node == null) {
            return;
        }
 
        current = node;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
 
	public static void main(String[] args) {
	
		LinkedList list = new LinkedList();
        //向LinkList中添加数据
        for (int i = 0; i < 10; i++) {
        	//尾插法建立链表
            //list.CreateList_L(i);
            //头插法建立链表(需要逆位序输入n个元素的值)
            list.CreateList_H(i);
        }
 
        list.print(list.head);// 从head节点开始遍历输出
	}
 
}
