package hashtable;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：fangmeixiu
 * @date ：Created in 2020/1/22 下午7:28
 * @description：给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。比如[-1, 2, -1]和 [-1, -1, 2]是重复的
 * @modified By：
 */
public class ThreeSum {
    //三层循环,但是时间太长---进行排序，然后判断元素  311/313
    public static List<List<Integer>> threeSum1(int[] nums){

        if(nums.length<3){
            return new ArrayList<List<Integer>>();
        }
        ArrayList<Integer> list = new ArrayList<>();

        List<List<Integer>>  result=new ArrayList<List<Integer>>();//结果
        for(int i=0;i<nums.length-2;i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.sort(new Comparator<Integer>() {
                            @Override
                            public int compare(Integer o1, Integer o2) {
                                if(o1-o2>0){
                                    return 1;
                                }else if(o1-o2<0){
                                    return -1;
                                }else{
                                    return 0;
                                }
                            }
                        });

                        if(!result.contains(temp)){
                            result.add(temp);
                            break;

                        }
                    }
                }
            }

        }
        return result;

       //用set在leetcode中会出现不识别sete的情况
//        if(nums.length<3){
//            return new ArrayList<List<Integer>>();
//        }
//        //Set用来去重（重复的），Vector用来排序
//        Set<Vector<Integer>> ret=new HashSet<Vector<Integer>>();//去重
//       // Vector<Vector<Integer>>  res=new Vector<Vector<Integer>>();//结果
//        List<List<Integer>>  result=new ArrayList<List<Integer>>();//结果
//        for(int i=0;i<nums.length-2;i++) {
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    if(nums[i]+nums[j]+nums[k]==0){
//                        Vector<Integer> temp=new Vector<>();
//                        int a=(nums[i]<nums[j]?nums[i]:nums[j])<nums[k]?(nums[i]<nums[j]?nums[i]:nums[j]):nums[k];//放最小的元素
//                        int b=(nums[i]>nums[j]?nums[i]:nums[j])>nums[k]?(nums[i]>nums[j]?nums[i]:nums[j]):nums[k];//放最大的元素
//                        int c=0-a-b;
//                       temp.add(a);
//                       temp.add(b);
//                       temp.add(c);
//                       ret.add(temp);
//
//                    }
//                }
//            }
//        }
//
//        for (Vector<Integer> v: ret) {
//            result.add(v);
//
//        }
//        return result;

    }
    //双循环和一个set  还是会有时间限制  311/313
    public static List<List<Integer>> threeSum2(int[] nums){
        List<List<Integer>> result = new ArrayList<>();//结果
         Set<List<Integer>>   s=new HashSet<>()  ;
        List<Integer> list=new ArrayList<>();  //用于保存除三个数之中的两个数之外的数组元素
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                List<Integer> list1= new ArrayList<>();
                list1.addAll(list);
                Integer a=nums[i];
                Integer b=nums[j]  ;
                list1.remove(a)  ;
                list1.remove(b)    ;
                int  diff=-nums[i]-nums[j];
                if(list1.contains(diff)){
                    List<Integer> list3 = new ArrayList<>();
                    list3.add(nums[i]);
                    list3.add(nums[j]);
                    list3.add(diff);
                    list3.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            if(o1-o2>0){
                               return 1;
                            }else if(o1-o2<0){
                                return -1;
                            }else{
                                return 0;
                            }
                        }
                    });

                    s.add(list3)  ;


                }


            }
        }
        for (List<Integer> l:s) {
                     result.add(l)   ;
        }
        return result;

    }
    //先排序，后进行一层循环，执行时间为36毫秒
    public static List<List<Integer>> threeSum3(int[] nums){
        int len=nums.length;
        if(nums==null  || len<3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<len;i++){
            if(nums[i]>0){ //如果当前数字大于0，则三数之和一定大于0
                break;
            }
            if(i>0&& nums[i]==nums[i-1]){ //去重
                continue;
            }
            int  left=i+1;
            int right=len-1;
            while(i+1<=len-2&&left<right){
                int sum=nums[left]+nums[right]+nums[i];
                if(sum>0){
                    right--;
                }else if(sum<0){
                    left++;
                }else{
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    while(left<right && nums[left]==nums[left+1]){
                        left++;//去重

                    }
                    while(left<right && nums[right]==nums[right-1]){
                        right--;//去重

                    }

                    left++;
                    right--;


                }

            }


        }
        return  result;
//        int len=nums.length;
//        if(nums==null  || len<3){
//
//          return new ArrayList<>();
//        }
//        Arrays.sort(nums);
//        List<List<Integer>> result = new ArrayList<>();
//        for(int i=0;i<len;i++){
//            int a=nums[i];
//            if(a>0){ //如果当前数字大于0，则三数之和一定大于0
//                break;
//
//            }
//            int  left=i+1;
//            int right=len-1;
//            while(i+1<=len-2&&left<right){
//                if(nums[left]+nums[right]+a>0){
//                      right--;
//                }else if(nums[left]+nums[right]+a<0){
//                    left++;
//                }else{
//                    ArrayList<Integer> temp = new ArrayList<>();
//                    temp.add(a);
//                    temp.add(nums[left]);
//                    temp.add(nums[right]);
//                    if(!result.contains(temp)){
//                        result.add(temp);
//
//                    }
//                    left++;
//                    right--;
//
//
//                }
//
//            }
//
//
//        }
//        return  result;

    }

    public static void main(String[] args) {
        //int[] nums = {-1, 0, 1, 2, -1, -4};
        //int[] nums = {0,0,0,0};
        int[] nums = {-2,0,1,1,2};

       //threeSum3(nums);
//        System.out.println(threeSum2(nums));
     System.out.println(threeSum3(nums));

























































































    }
}
