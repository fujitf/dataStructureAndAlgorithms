package com.study.practice;

/**
 * @Author：fangmeixiu
 * @Description:
 * @Date :create in 下午6:18 2019/6/10
 */
public class TimeComplexity {
    public static void main(String[] args) {

       logN(1);
        logN(2);
        logN(3);
        logN(4);
        logN(5);
        logN(6);
        logN(7);
        logN(8);
        logN(9);
        logN(10);
        logN(11);
        logN(12);
        logN(13);
        logN(14);
        logN(15);
        logN(16);
        logN(17);
        logN(18);
        logN(19);
        logN(20);

    }



   public static  void  logN(int  n){
        for (int i=1;i<=n;i=i*2){
            System.out.println("hey,i="+i);
        }
    }

}
