package binarySearchTree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ：fangmeixiu
 * @date ：Created in 2020/2/6 上午11:49
 * @description：
 * @modified By：
 */
public class BinaryTree {
    private static int[] array={1,2,3,4,5,6,7,8,9};

    private static List<Node> nodeList=null;


    //内部类节点
    private static class Node{
        Node  leftChild;
        Node  rightChild;
        int  data;

        //构造法初始化

        public Node(int newData) {
            leftChild=null;
            rightChild=null;
            this.data = newData;
        }

    }


    //创建节点
    public void createBinTree(){
        nodeList=new LinkedList<Node>();
        //将一个数组的值依次转化为Node节点
        for(int nodeIndex=0;nodeIndex<array.length;nodeIndex++){
            nodeList.add(new Node(array[nodeIndex]));
        }
        int lastParentIndex=array.length/2-1;//父节点个数

        //对前lastParentIndex-1个父节点按照父节点与孩子节点的数学关系建立二叉树
        for(int parentIndex=0;parentIndex<lastParentIndex;parentIndex++){
            //左孩子
            nodeList.get(parentIndex).leftChild=nodeList.get(parentIndex*2+1);
            //右孩子
            nodeList.get(parentIndex).rightChild=nodeList.get(parentIndex*2+2);

        }

        //设置最后一个父节点，因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        //左孩子
        nodeList.get(lastParentIndex).leftChild=nodeList.get(lastParentIndex*2+1);
        //右孩子
        if(array.length%2==1){
            nodeList.get(lastParentIndex).rightChild=nodeList.get(lastParentIndex*2+2);
        }

    }

    /**
     *
     * 先序遍历：先root节点，然后左子树，然后右子树
     *
     * */
    public  static void preOrderTraverse(Node node){
        if(node == null){
            return;
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
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinTree();

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
