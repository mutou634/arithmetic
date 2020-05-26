package arithmeticDemo;

public class Stack{
	private int top=-1; //指向栈顶，用于栈的遍历
	private int stackSize=0;//栈的大小
	private char[] stackArray=null;//用于创建栈的数组
	//create stack use array（创建一个指定大小的新栈）
	public void createStack(int size){
		stackSize=size;
		stackArray=new char[size];
	}
	//push element（数据压入）
	public void push(char element){
		if(top!=stackSize-1){  //应在压入数据前判断栈是否为满栈
		    stackArray[top+1]=element;
		    top++;
		}else{
		    System.out.println("Sorry,can`t push!This stack is full!");
		}	
	}
	//pop element（数据弹出）
	public void pop(){
		if(!isEmpty()){//在弹出时应判断栈是否为空栈，空栈则无数据可弹出
		  // System.out.println("pop->"+stackArray[top]);
		   //stackArray[stackSize-1]=0;
		   top--;   
		}else{
		    System.out.println("Sorry,can`t pop!This stack is empty!");
		}	
	}
	//look element（查看栈顶数据）
	public char peek(){
		char peekElement=stackArray[top];
		return peekElement;
	}
	
	//is empty（判断栈是否为空）
	public boolean isEmpty(){
		if(top==-1){
		    return true;
		}else{
		    return false;
		}	
	}
	//is full（判断栈是否为满栈）
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