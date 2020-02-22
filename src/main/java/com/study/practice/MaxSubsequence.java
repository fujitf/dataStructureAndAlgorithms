package com.study.practice;

/**
 * @Author：fangmeixiu
 * @Description:最大子序列和问题的求解
 * @Date :create in 上午8:49 2019/6/15
 */
public class MaxSubsequence {


    public static void main(String[] args) {
        int[] a={4,-11,5,-6,-1,9};
//        int result = maxSubSum1(a);
        int result= maxSubSum2(a);
        System.out.println(result);


    }


    /**
     * Cubic   maximum    contiguous  subsequence  sum   algorithm.
     * 直接方法：两个循环，一个为子序列的头，一个为子序列的尾，
     * 确定子序列，然后在两循环中利用for循环求和当前子序列的和.
     * 时间复杂度：O(N^3)
     *
     * */
    public  static   int   maxSubSum1(int[] a){

        int  maxSum=0;

        for(int i=0;i<a.length;i++){
            for (int  j=i;j<a.length;j++){
                int  thisSum=0;
                for(int k=i;k<=j;k++){
                    thisSum+=a[k];

                }
                if(thisSum>maxSum){
                    maxSum=thisSum;
                }
            }

        }

        return  maxSum;

    }

    /**
     * Quadratic maximum  contiguous  subsequnence  sum   algorithm
     *
     * 撤出算法1中的一个for循环来避免三次的元算时间,,-----i代表子序列，j代表子序列的尾部，边形成子序列边计算子序列的和
     *
     * 时间复杂度：O(N^2)
     *
     * */
    public  static  int   maxSubSum2(int[] a){
         int  maxSum=0;
         for(int i=0;i<a.length;i++){
             int  thisSum=0;

             for (int  j=i;j<a.length;j++){
                 thisSum+=a[j];
                 if(thisSum>maxSum){
                     maxSum=thisSum;
                 }

             }

         }

         return  maxSum;


    }

}
