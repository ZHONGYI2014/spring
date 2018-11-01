package tree;

import java.util.*;

public class Solution {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        //调用递归方法
        int level = 1;
        List<Integer> list = new ArrayList<>();
        /** 定义数据结构, key = 存放 level 的值,level表示当前层级, List用来存放当前层级的元素 */
        Map<Integer, List<Integer>> data = new HashMap<>();
        twoTree(level, data, root);
        for (Map.Entry<Integer, List<Integer>> entry : data.entrySet()) {
            List<Integer> tmp = entry.getValue();
            int total = 0;
            for (Integer i : tmp) {
                total = total + i;
            }
            result.add((double)total/tmp.size());
        }
        return result;
    }

    /**
     * 递归遍历
     * @param level 深度
     * @param resultMap 存储结构
     * @param node 节点
     */
    public void twoTree(Integer level, Map<Integer, List<Integer>> resultMap, TreeNode node) {
        if (null != node) {
            if (null == resultMap.get(level)) {
                List<Integer> nList = new ArrayList<>();
                nList.add(node.val);
                resultMap.put(level, nList);
            } else {
                List<Integer> oList = resultMap.get(level);
                oList.add(node.val);
                resultMap.put(level, oList);
            }
            if (null != node.leftChildren) {
                int currentLevel = level + 1;
                twoTree(currentLevel, resultMap, node.leftChildren);
            }
            if (null != node.rightChildren) {
                int currentLevel = level + 1;
                twoTree(currentLevel, resultMap, node.rightChildren);
            }
        }
    }

    /**
     * 求一颗二叉树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftDepth = maxDepth(root.leftChildren);
        int rightDepth = maxDepth(root.rightChildren);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }


}
