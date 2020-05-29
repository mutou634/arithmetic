package arithmeticDemo;
import java.util.Stack;

/**
 * 此题还可以引申至配对字符符匹配问题，如单引号，双引号匹配问题。
 *
 */

public class Stack2 {
    
    public boolean matching(String expression)
    {
        if(expression==null||expression=="")
        {
            System.out.println( "输入表达式为空或没有输入表达式" ) ;
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
            System.out.println("匹配成功！") ;
        }
        else
        {
            System.out.println(" 匹配失败 ");
        }
    }
}
