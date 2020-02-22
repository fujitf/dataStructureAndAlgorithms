package algorithmproblem;

import java.util.Queue;
import java.util.Stack;

/**
 * @Author：fangmeixiu
 * @Description:用栈实现队列
 * @Date :create in 下午6:10 2019/10/31
 */
public class StackToQueue {

   private  static  Stack<Integer> inputStack = new Stack<Integer>();
   private  static  Stack<Integer> outStack = new Stack<Integer>();
    //入队列
    public static void  push(Integer i){
        inputStack.push(i);
        if(outStack.isEmpty()){
            tranfer(inputStack,outStack);
        }
        
    }
    //出队列
    public  static  Integer pop(){
        Integer result=null;
        if(outStack.isEmpty()){
            tranfer(inputStack,outStack);


        }else{
            result=outStack.pop();
            if(outStack.isEmpty()){
                tranfer(inputStack,outStack);
            }
        }

        return result;

    }
    //输入队列元素插入到输出队列里面
    public  static void tranfer(Stack<Integer> inputStack,Stack<Integer> outStack){
            while (!inputStack.isEmpty()){
                outStack.push(inputStack.pop());
            }

    }
    //查看队列
    public  static Integer peek(){
        if(!outStack.isEmpty()){
            return outStack.peek();
        }
        return null;
    }
    public static void main(String[] args) {
        StackToQueue stackToQueue = new StackToQueue();
        //入队列
        stackToQueue.push(1);
        stackToQueue.push(2);
        stackToQueue.push(3);
        System.out.println(stackToQueue.outStack);

        stackToQueue.pop();
        stackToQueue.pop();
        stackToQueue.push(4);
        stackToQueue.push(5);

        System.out.println(stackToQueue.outStack);
        stackToQueue.pop();
        System.out.println(stackToQueue.outStack);
        



    }

}
