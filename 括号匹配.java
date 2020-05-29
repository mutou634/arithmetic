package arithmeticDemo;
import java.util.Stack;

/**
 * ���⻹��������������ַ���ƥ�����⣬�絥���ţ�˫����ƥ�����⡣
 *
 */

public class Stack2 {
    
    public boolean matching(String expression)
    {
        if(expression==null||expression=="")
        {
            System.out.println( "������ʽΪ�ջ�û��������ʽ" ) ;
        }
        
        Stack<Character> stack = new Stack<Character>() ;
        
        for(int index=0 ; index<expression.length();index++)
        {
            switch(expression.charAt(index))
            {
                case '(':
                    stack.push(expression.charAt(index)) ;
                    break ;
                case '{':
                    stack.push(expression.charAt(index)) ;
                    break ;
                case ')':
                    if(!stack.empty()&&stack.peek()=='(')
                    {
                        stack.pop() ;
                    }
                    break ;    
                    
                case '}':
                    if(!stack.empty()&&stack.peek()=='{')
                    {
                        stack.pop();
                    }
            }    
        }
        
        if(stack.empty())
            return true ;
        return false ;
    }
    
    public static void main(String[] args) {
        
        String expression = "{()}" ;
        
        Stack2 oj = new Stack2() ;
        
        boolean flag = oj.matching(expression) ;
        
        if(flag)
        {
            System.out.println("ƥ��ɹ���") ;
        }
        else
        {
            System.out.println(" ƥ��ʧ�� ");
        }
    }
}
