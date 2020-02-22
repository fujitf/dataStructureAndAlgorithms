package linkedlist;

import java.util.Scanner;

/**
 * @Author：fangmeixiu
 * @Description:  用单链表存储字符串，判断是否是回文字符串，回文字符串是无论正向读还是反向读都是同一个字符串
 *                思路：使用两个快慢指针，快指针走两步，慢指针走一步，当快指针走到终点时，慢指针刚好到中点，
 *                并且在慢指针没走一步中将其指向方向修改，最后对比前后即可判断是否是回文字符串
 *                时间复杂度O(n),空间复杂度O(1)
 * @Date :create in 上午9:32 2019/8/16
 */
public class PalindRome {
    static class ListNode{
        int  var;
        ListNode  next;
        public ListNode(int x){
            this.var =x;

        }
    }

    public static  boolean isPalindRome(ListNode head){
        //链表是空的或者只有一个节点直接返回 true
        if(head ==null || head.next==null){
            return true;
        }
        //先找到链表的中间节点，使用两个快慢指针，快指针移动两步，慢指针移动一步
        ListNode  pre=null;//用于和slow做比较，后面回让它与slow的值进行比较，它俩的next不一样
        ListNode  slow=head;
        ListNode fast= head;


        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            ListNode next =slow.next;
            slow.next=pre;//修改指向
            pre=slow;
            slow =next;//这两行

        }


        if(fast !=null){
            //说明字符串是奇数个
            slow=slow.next;//保证两者分别是中间左右节点的
        }


        //这时得到的slow和pre都是在中点，如果字符串是奇数个，则slow和pre相隔一个元素，如果是偶数个，则两者中间没没有元素，并且slow和pre的指向相反

        while(slow!=null){


            if(slow.var != pre.var){
                System.out.println("slow:"+slow.var);
                System.out.println("slow.next:"+slow.next.var);
                System.out.println("pre:"+pre.var);
                System.out.println("pre.next:"+pre.next.var);
                return false;
            }
            slow=slow.next;
            pre=pre.next;


        }


        return  true;


    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String tmp = in.nextLine();
        char[] s = tmp.toCharArray();


        ListNode[] node=new ListNode[s.length];

        for(int i=0;i<s.length;i++){
            node[i]=new ListNode(s[i]);

        }

        for(int i=0;i<s.length;i++){
            if(i==s.length-1){//最后一个节点，指针指向空
                node[i].next=null;
            }else{
                node[i].next=node[i+1];
            }

        }
        System.out.println(1111);
        boolean flag=PalindRome.isPalindRome(node[0]);
        System.out.println("是否是回文"+flag);




        }

        public  static  void strreverse(){ //时间复杂度O(n)
            System.out.println("请输入一个字符串");
            Scanner input = new Scanner(System.in);
            String str = input.next();
            int count = 0;
            for (int i = 0; i < str.length() / 2; i++) {
                if ((str.substring(i, i + 1)).equals(str.substring(str.length() - 1 - i, str.length() - i))) {
                    count++;

                }
            }
            if (count == str.length() / 2) {
                System.out.println("是回文字符串");
            }else{
                System.out.println("不是回文字符串");
            }


        }


}
