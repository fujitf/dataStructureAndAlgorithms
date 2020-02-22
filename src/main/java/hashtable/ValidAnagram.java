package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：fangmeixiu
 * @date ：Created in 2020/1/21 下午7:18
 * @description：有效字母异位词
 * @modified By：
 */
public class ValidAnagram {
    //将两个字符串进行排序然后进行比较:时间复杂度为O(NlogN)
    public static boolean isAnagram1(String s, String t){
        //判断长度
        if(s.length()!=t.length()){
              return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);//Arrays.sort底层使用的是快排，时间复杂度为O(NlogN)
        Arrays.sort(chars2);
        return  Arrays.equals(chars1,chars2);



    }
     /*
     /**
      * create by: fangmeixiu
      * description: 用一个计数器表统计s的字母出现的频率，用t减少计数器表中的每个字母的计数器，然后检查是否会减到0
      * create time: 2020/1/22 下午4:46
      * @param [s, t]
      * @return boolean
      */
    public static boolean isAnagram2(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        HashMap<Character, Integer> count = new HashMap<>();
        for (Character ch:arr1) {
            if(count.get(ch)!=null && count.get(ch)>0){
                 count.put(ch,count.get(ch)+1);
            }else{
                count.put(ch,1);
            }
            
        }
        for (Character ch:arr2) {

            if(count.get(ch)!=null && count.get(ch)>0){
                count.put(ch,count.get(ch)-1);
            }else{
                //s中不存在但是t中不存在
                return  false;
            }

        }
        return   true;
    }





    public static void main(String[] args) {
        String  s1="ab";
        String  s2="a";
        isAnagram2(s1,s2);
        System.out.println(isAnagram1(s1,s2));
        System.out.println(isAnagram2(s1,s2));

    }
}
