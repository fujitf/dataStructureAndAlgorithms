package binarySearchTree;

import org.omg.CORBA.DATA_CONVERSION;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：fangmeixiu
 * @date ：Created in 2020/2/6 上午11:49
 * @description：创建节点，考虑节点可能存在,,空数组表明是空节点
 * @modified By：
 */
public class BinaryTree1 {

    public  static  List<Integer>   DATA=new ArrayList<>();//用集合表示数组的元素，因为null值可以表示为空的树节点
    public  static List<Node> nodeList=null;

    //内部类节点
    public static class Node{
        Node  leftChild;
        Node  rightChild;
        Integer  data;

        public Node() {
            leftChild=null;
            rightChild=null;
        }
        //构造法初始化

        public Node(Integer newData) {
            leftChild=null;
            rightChild=null;
            this.data = newData;
        }
        public void setVal(Integer newData) {
            this.data = newData;
        }


    }


    //创建节点
    public static void createBinTree(){
        nodeList=new LinkedList<Node>();
        System.out.println(DATA);
        //将一个数组的值依次转化为Node节点
        for(int nodeIndex=0;nodeIndex<DATA.size();nodeIndex++){
            if(DATA.get(nodeIndex)!=null){
                nodeList.add(new Node(DATA.get(nodeIndex)));
            }else{
                nodeList.add(null);//空节点
            }
        }
       //建立二叉树
        for(int i=0;i<DATA.size()/2;i++){
            if(nodeList.get(i).data!=null){
                nodeList.get(i).leftChild=nodeList.get(i*2+1);

                if(i*2+2<nodeList.size()){//避免偶数的时候 下标越界
                    nodeList.get(i).rightChild=nodeList.get(i*2+2);
                }

            }

        }

    }

    /**
     *
     * 先序遍历：先root节点，然后左子树，然后右子树
     *
     * */
    public  static void preOrderTraverse(Node node){

        if(node == null){
            return ;
        }
        System.out.println(node.data+" ");
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    /**
     *
     * 中序遍历：先左子树，然后root节点，然后右子树
     *
     * */

    public  static void inOrderTraverse(Node node){
        if(node == null){
            return;
        }
        inOrderTraverse(node.leftChild);
        System.out.println(node.data+" ");
        inOrderTraverse(node.rightChild);
    }


    /**
     *
     * 中序遍历：先左子树，然后右子树，然后root
     *
     * */

    public  static void postOrderTraverse(Node node){
        if(node == null){
            return;
        }
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.println(node.data+" ");
    }

    public static void main(String[] args) {
        DATA.add(5);
        DATA.add(1);
        DATA.add(4);
        DATA.add(null);
        DATA.add(null);
        DATA.add(3);
        DATA.add(6);//树结构的各节点的值

        Node node = new Node();
        createBinTree();


        // nodeList中第0个索引处的值即为根节点
        Node root = nodeList.get(0);
        System.out.println("先序遍历：");
        preOrderTraverse(root);
        System.out.println();
        System.out.println("中序遍历：");
        inOrderTraverse(root);
        System.out.println();
        System.out.println("后序遍历：");
        postOrderTraverse(root);


    }
}
