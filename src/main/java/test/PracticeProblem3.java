package test;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class PracticeProblem3 {
    /**
     * You are given a binary tree:
     *
     * class TreeNode
     *   attr_accessor :left
     *   attr_accessor :right
     *   attr_reader :value
     * end
     * Your task is to return the list with elements from tree sorted by levels,
     * which means the root element goes first, then root children (from left to right) are second and third, and so on.
     *
     * Return empty array if root is nil.
     *
     * Example 1 - following tree:
     *
     *                  2
     *             8        9
     *           1  3     4   5
     * Should return following list:
     *
     * [2,8,9,1,3,4,5]
     */
    public static List<Integer> elementSortedByLevels(TreeNode node){
        List<List<Integer>> elements = new ArrayList<>();
        bfs(node, elements, 0);
        return elements.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
    }

    public static void bfs(TreeNode root, List<List<Integer>> elements, int level){
        if (root == null){
            return;
        }
        if (level >= elements.size()){
            elements.add(new LinkedList<>());
        }
        elements.get(level).add(root.val);
        bfs(root.left, elements, level + 1);
        bfs(root.right, elements, level + 1);
    }

    public static List<Integer> levelOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //queue --> add root
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()){//while queue is not empty add to the result
            TreeNode current = nodeQueue.poll();//poll current node
            res.add(current.val);//add current value to list

            if (current.left != null) nodeQueue.offer(current.left);//check if left node is not empty and add to queue
            if (current.right != null) nodeQueue.offer(current.right);//check if right node is not empty and add to queue
        }
        return res;
    }

    public static List<List<Integer>> levelOrderListOfList(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //queue --> add root
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()){//while queue is not empty add to the result
            int level = nodeQueue.size();
            List<Integer> currLevel = new LinkedList<>();
            for(int i = 0; i < level; i++){
                TreeNode current = nodeQueue.poll();//poll current node
                currLevel.add(current.val);//add current value to list

                if (current.left != null) nodeQueue.offer(current.left);//check if left node is not empty and add to queue
                if (current.right != null) nodeQueue.offer(current.right);//check if right node is not empty and add to queue
            }

            res.add(currLevel);//add currLevel to result
        }
        return res;
    }
}
