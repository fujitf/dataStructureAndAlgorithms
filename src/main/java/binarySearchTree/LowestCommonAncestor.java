package binarySearchTree;

/**
 * @author ：fangmeixiu
 * @date ：Created in 2020/2/20 下午5:43
 * @description：二叉树或者二叉树搜索的最近公共祖先
 * @modified By：
 */
public class LowestCommonAncestor {


    //二叉树的最近公共祖先
    public  static TreeNode findLowestCommonAncestor1(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return null;
        }
        if(root==p || root==q){
            return root;
        }
        TreeNode left=findLowestCommonAncestor1(root.left,p,q);
        TreeNode  right=findLowestCommonAncestor1(root.right,p,q);
//        if(left==null){
//            if(right==null){
//                return root;
//            }else{
//                return right
//            }
//
//        }else{
//            if(right==null){
//                return left;
//            }else{
//                return root;
//            }
//
//        }
        return  left==null?right:right==null?left:root;//嵌套三目运算符替代多个if ...else

    }

    //二叉s搜索树的最近公共祖先
    public  static TreeNode findLowestCommonAncestor2(TreeNode root,TreeNode p,TreeNode q){

        if(p.val<root.val && q.val<root.val){
             return findLowestCommonAncestor2(root.left,p,q);
        }
        if(p.val>root.val && q.val>root.val){
            return findLowestCommonAncestor2(root.right,p,q);
        }
        return root;

    }




}
