package priorityqueue;

import java.util.*;

/**
 * @author ：fangmeixiu
 * @date ：Created in 2020/1/19 下午4:21
 * @description：
 * @modified By：
 */
public class MaxInWindow {

    /*
    /**
     * create by: fangmeixiu
     * description: 采用优先队列结构，使用大根堆，但是大根堆每次移除元素时间复杂度O(k)，
     *     取堆顶O(1)，总体时间复杂度高，为O(N*logk）
     * create time: 2020/1/19 下午4:45
     * @param []
     * @return java.util.List<java.lang.Integer>
     */
    public static  int[] priority(int[] num ,int  k){

        if(num==null || num.length==0||  k==0 || num.length<k){
             return  new int[0];
        }
        int[]  result=new int[num.length-k+1];
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k, Comparator.reverseOrder());
        for(int i=0;i<num.length;i++){
            if(q.size()==k){
                q.remove(num[i-k]);//移除元素

            }
            q.add(num[i]);//将新元素添加到大堆顶中

            if(i>=k-1){
                result[i-k+1]=q.peek();
                                       //当访问到第3个元素以后，此时优先队列里面的元素肯定是3个了，
                                      // 此时顶点元素就是此时窗口中的最大叔，弹出添加到结果里
            }
        }

        return  result;

    }
    /*
    /**
     * create by: fangmeixiu
     * description: 双端队列中存储的是最大值的索引，对于新来的元素，将其于双端队列中的元素进行比较，
     *                   前面比新元素小的，直接移除队列（因为不再称为后面滑动窗口中的z最大值，从队尾剔除
     *                   前面比新元素大的，判断是否不再队列里面，不再，直接移除，从队首移除
     * create time: 2020/1/21 上午12:25
     * @param [arr, k]
     * @return int[]
     */
    public static int[] deque(int[] arr ,int k){
        if(arr==null || arr.length==0||  k==0 || arr.length<k){
            return  new int[0];
        }
        int[] result=new int[arr.length-k+1];
        LinkedList<Integer> deq=new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            //无论前面有多少个是否是需要这次移除的，只要比新元素小，统统移除,保证最左单的是最大元素的索引
            while(!deq.isEmpty() && arr[deq.peekLast()]<arr[i]){
                deq.pollLast();
            }
            if(i>=k){
                //判断比新元素大的队首元素是否已经在窗口之外，如果是，则移除
                if(!deq.isEmpty() && deq.peekFirst()==i-k ){
                    deq.pollFirst();
                }


            }


            deq.addLast(i);
            if(i>=k-1){
                result[i-k+1]=arr[deq.peekFirst()];
            }
        }


        return  result;
    }





    public static void main(String[] args) {
        int[] arr={1,3,-1,-3,5,3,6,7};
        int[] priority = priority(arr, 3);
        int[]  deq = deque(arr, 3);
        System.out.println(priority);
        System.out.println(Arrays.toString(deq));



    }


}
