package arithmeticDemo;
//���ʣ�Java����ôģ��C�����еĽṹ��ָ��   2020.5.25   
public class LinkedList { 
	
	public ListNode head;
	public ListNode current;  //c���Ե�p�ṹ��ָ��
	
	class ListNode{     //�൱��C���ԵĽṹ��
		
		int val;   //������
		ListNode next = null; //ָ����
		
		public ListNode(int val) {
			this.val =val;
		}
		
	}
	
	//β�巨����������
	public void CreateList_L(int data) {
		//�ж�����Ϊ�յ�ʱ��
		if(head == null) { //���ͷ���Ϊ�գ�˵���������û�д������ǾͰ��µĽ�㸳��ͷ���
			head = new ListNode(data);
			current = head;
		}else {
			//�����µĽ�㣬���ڵ�ǰ�ڵ�ĺ��棨���µĽ���������й�����
			current.next = new ListNode(data);
            //������ĵ�ǰ��������ƶ�һλ
			current = current.next;   //�˲��������֮��current���ָ������ӵ��Ǹ����
		}
		
	}
	
	//ͷ�巨����������
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
	
	//����������������ӡ������������Ĳ�����ʾ�ӽڵ�node��ʼ���б���
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
        //��LinkList���������
        for (int i = 0; i < 10; i++) {
        	//β�巨��������
            //list.CreateList_L(i);
            //ͷ�巨��������(��Ҫ��λ������n��Ԫ�ص�ֵ)
            list.CreateList_H(i);
        }
 
        list.print(list.head);// ��head�ڵ㿪ʼ�������
	}
 
}
