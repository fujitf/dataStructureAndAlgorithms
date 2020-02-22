package algorithmproblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * @Author：fangmeixiu
 * @Description:括号字符串合法性校验----采用堆栈方法
 * @Date :create in 下午12:29 2019/10/31
 */
public class ValidParentheses {

    public  static  boolean  isValid1(String  s){
        Stack<String> stack = new Stack<String>();
        Map<String,String> map=new HashMap<String,String>();
        map.put(")","(");
        map.put("}","{");
        map.put("]","[");
        Set<String> keys = map.keySet();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            String str=String.valueOf(c);
            if(!keys.contains(str)){//左括号则压栈
                stack.push(String.valueOf(c));

            }else if(stack.isEmpty() ||  !map.get(String.valueOf(c)).equals(stack.pop())){
                //右括号：如果栈为空，则直接返回false，，，栈不为空，判断是否与上一个压入栈的元素匹配
                return  false;
            }


        }
        return stack.isEmpty();
    }
    public static  boolean  isValid2(String s){
        Stack<String> stack = new Stack<String>();
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case '(':
                    stack.push("(");
                      break;
                case ')':
                    if(stack.empty()){
                        return false;
                    }
                    if(!stack.pop().equals("(")){
                        return false;
                    }
                    break;
                case '[':
                    stack.push("[");
                    break;
                case ']':
                    if(stack.empty()){
                        return false;
                    }
                    if(!stack.pop().equals("[")){
                        return false;
                    }
                    break;
                case '{':
                    stack.push("{");
                    break;
                case '}':
                    if(stack.empty()){
                        return false;
                    }
                    if(!stack.pop().equals("}")){
                        return false;
                    }
                    break;



            }

        }

        return stack.empty();

    }

    public static  boolean  isValid3(String s){
        int  length;
       do {
           length=s.length();
           s=s.replace("()","").replace("{}","").replace("[]","");
       }while(length!=s.length());
       return  s.length()==0;

    }


    public static void main(String[] args) {
        String  s1="()";
        String  s2="()[]";
        String  s3="([)]";
        String  s4="((([])))";
        String  s5="((([]))";
        String  s6="]][[";
        String  s7="]";
        System.out.println(isValid3(s1));
        System.out.println(isValid3(s2));
        System.out.println(isValid3(s3));
        System.out.println(isValid3(s4));
        System.out.println(isValid3(s5));
        System.out.println(isValid3(s6));



    }

}
