package hashtable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ：fangmeixiu
 * @date ：Created in 2020/1/22 下午5:17
 * @description：
 * @modified By：
 */
public class TwoSum {
    //两次for 循环
    public  static int[]  twoSum1(int[] nums,int  target){
        int[] result = new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;

                }
            }
        }
        return  result;

    }


    public  static int[]  twoSum2(int[] nums,int  target){
        HashMap<Integer, Integer> map = new HashMap<>();
        int[]  result=new int[2];
        for(int i=0;i<nums.length;i++){
            int  dif=target-nums[i];
            if(map.get(dif)!=null){
                result[0]=i;
                result[1]=map.get(dif);
            }
            map.put(nums[i],i);
        }
        return  result;

    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
                int target = 9;
        int[] arr1=twoSum1(nums,target);


    }
}
