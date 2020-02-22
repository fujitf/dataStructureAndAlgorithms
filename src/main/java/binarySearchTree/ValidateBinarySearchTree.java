package binarySearchTree;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ：fangmeixiu
 * @date ：Created in 2020/1/31 下午4:22
 * @description：
 * @modified By：
 */
public class ValidateBinarySearchTree {
    static double last = -Double.MAX_VALUE;

    public static void main(String[] args) {
        //构建树
        TreeNode.DATA.add(5);
        TreeNode.DATA.add(1);
        TreeNode.DATA.add(4);
        TreeNode.DATA.add(null);
        TreeNode.DATA.add(null);
        TreeNode.DATA.add(3);
        TreeNode.DATA.add(6);//树结构的各节点的值
        TreeNode.createNode();


        TreeNode root = TreeNode.nodeList.get(0);


        //boolean validBST1 = isValidBST2(root);
        boolean validBST3 = isValidBST3(root);
        System.out.println(validBST3);



    }
    //二叉搜索树经过中序遍历的节点的值存到集合中，获得是一个递增数列,内存占用率高--不推荐使用
    public static  boolean isValidBST1(TreeNode root){
        return  false;
    }


    //推荐中序遍历2，只比较前继节点的值是否比当前节点的值小---中序遍历---last的值由1---5然后进行到3时会返回false ，，，内存占用率低
    public static  boolean isValidBST2(TreeNode root){
        if(root==null){
           return   true;
        }

        if(isValidBST2(root.left)){
            if(last<root.val){
               last=root.val;
               return isValidBST2(root.right);
            }

        }
        return  false;

    }

    public  static  boolean isValidBST3(TreeNode root){
        return dfs(root,null,null);

    }
    public  static  boolean dfs(TreeNode root,Integer min,Integer max){
        if(root==null){
            return  true;
        }
        if(min!=null && root.val<=min){
            return  false;
        }
        if(max!=null && root.val>=max){
            return  false;
        }
        return dfs(root.left,min,root.val) && dfs(root.right,root.val,max);


    }


}
