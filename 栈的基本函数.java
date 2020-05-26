package arithmeticDemo;

public class Stack{
	private int top=-1; //ָ��ջ��������ջ�ı���
	private int stackSize=0;//ջ�Ĵ�С
	private char[] stackArray=null;//���ڴ���ջ������
	//create stack use array������һ��ָ����С����ջ��
	public void createStack(int size){
		stackSize=size;
		stackArray=new char[size];
	}
	//push element������ѹ�룩
	public void push(char element){
		if(top!=stackSize-1){  //Ӧ��ѹ������ǰ�ж�ջ�Ƿ�Ϊ��ջ
		    stackArray[top+1]=element;
		    top++;
		}else{
		    System.out.println("Sorry,can`t push!This stack is full!");
		}	
	}
	//pop element�����ݵ�����
	public void pop(){
		if(!isEmpty()){//�ڵ���ʱӦ�ж�ջ�Ƿ�Ϊ��ջ����ջ�������ݿɵ���
		  // System.out.println("pop->"+stackArray[top]);
		   //stackArray[stackSize-1]=0;
		   top--;   
		}else{
		    System.out.println("Sorry,can`t pop!This stack is empty!");
		}	
	}
	//look element���鿴ջ�����ݣ�
	public char peek(){
		char peekElement=stackArray[top];
		return peekElement;
	}
	
	//is empty���ж�ջ�Ƿ�Ϊ�գ�
	public boolean isEmpty(){
		if(top==-1){
		    return true;
		}else{
		    return false;
		}	
	}
	//is full���ж�ջ�Ƿ�Ϊ��ջ��
	public boolean isFull(){
		if(stackSize!=-1){
		    if(top==stackSize-1){
		        return true;
		    }else{
		        return false;
		}	
		}else{
        	    System.out.println("Sorry,this stack is empty!");
		    return false;
		}	
	}	
}