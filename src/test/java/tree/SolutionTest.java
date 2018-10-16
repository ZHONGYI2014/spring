package tree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void averageOfLevels() {
        Solution sou = new Solution();
        TreeNode tree = new TreeNode(3);
        tree.leftChildren = new TreeNode(9);
        tree.rightChildren = new TreeNode(20);
        tree.rightChildren.leftChildren = new TreeNode(15);
        tree.rightChildren.rightChildren = new TreeNode(7);

        List<Double> result = sou.averageOfLevels(tree);
        System.out.print("[ ");
        for (Double item : result) {
            System.out.print(item + ", ");
        }
        System.out.println(" ]");

    }
}