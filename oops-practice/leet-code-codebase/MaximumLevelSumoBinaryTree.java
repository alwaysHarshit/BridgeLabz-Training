import java.util.LinkedList;

public class MaximumLevelSumoBinaryTree {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int maxSum = Integer.MIN_VALUE;
        int ansLevel = 1;
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            int curSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                curSum += node.val;

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            if (curSum > maxSum) {
                maxSum = curSum;
                ansLevel = level;
            }

            level++;
        }

        return ansLevel;
    }
}
