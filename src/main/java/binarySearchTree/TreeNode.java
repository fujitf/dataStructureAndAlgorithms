package binarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：fangmeixiu
 * @date ：Created in 2020/2/9 下午6:27
 * @description：
 * @modified By：
 */
public class TreeNode {
    public  static  List<Integer>   DATA=new ArrayList<>();//用集合表示数组的元素，因为null值可以表示为空的树节点
    public  static List<TreeNode> nodeList=null;

    TreeNode left;
    TreeNode  right;
    Integer val;
    public TreeNode() {
        left=null;
        right=null;
    }
    //构造法初始化

    public TreeNode(Integer newData) {
        left=null;
        right=null;
        this.val= newData;
    }


    public void setVal(int val) {
        this.val = val;
    }

    public  static   void createNode(){
        nodeList=new LinkedList<TreeNode>();
        System.out.println(DATA);
        //将一个数组的值依次转化为Node节点
        for(int nodeIndex=0;nodeIndex<DATA.size();nodeIndex++){
            if(DATA.get(nodeIndex)!=null){
                nodeList.add(new TreeNode(DATA.get(nodeIndex)));
            }else{
                nodeList.add(null);//空节点
            }

        }
        //建立二叉树
        for(int i=0;i<DATA.size()/2;i++){
            if(nodeList.get(i).val!=null){
                nodeList.get(i).left=nodeList.get(i*2+1);

                if(i*2+2<nodeList.size()){//避免偶数的时候 下标越界
                    nodeList.get(i).right=nodeList.get(i*2+2);
                }

            }

        }


    }
}
