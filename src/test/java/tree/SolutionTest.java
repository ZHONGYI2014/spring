package tree;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    Solution sou = null;
    TreeNode tree = null;

    @Before
    public void init() {
        sou = new Solution();
        tree = new TreeNode(3);
        tree.leftChildren = new TreeNode(9);
        tree.rightChildren = new TreeNode(20);
        tree.rightChildren.leftChildren = new TreeNode(15);
        tree.rightChildren.rightChildren = new TreeNode(7);
    }

    @Test
    public void averageOfLevels() {


        List<Double> result = sou.averageOfLevels(tree);
        System.out.print("[ ");
        for (Double item : result) {
            System.out.print(item + ", ");
        }
        System.out.println(" ]");

    }

    @Test
    public void testMaxDepth() {
        Solution sou = new Solution();
        int l = sou.maxDepth(tree);
        System.out.println(l);
    }

}