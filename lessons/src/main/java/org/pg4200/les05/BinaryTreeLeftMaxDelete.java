package org.pg4200.les05;

public class BinaryTreeLeftMaxDelete<K extends Comparable<K>, V> extends MyMapBinarySearchTree<K,V> {


    @Override
    protected TreeNode delete(K key, TreeNode subtreeRoot){

        if (subtreeRoot == null) {
            /*
                This will happen when the key is not found, and we try a
                recursion on a null node.
                In this case, the new root of a null substree is still a null
                subtree, and we can return itself directly (ie null)
             */
            return null;
        }

        int compare = key.compareTo(subtreeRoot.key);

        if (compare < 0) { // Keyen vi prøver å slette er mindre en subtree key, vå går mot venstre
            subtreeRoot.left = delete(key, subtreeRoot.left);
            return subtreeRoot;
        }

        if (compare > 0) { // Keyen vi prøver å slette er Større en subtree key, vi går mot høyre
            subtreeRoot.right = delete(key, subtreeRoot.right);
            return subtreeRoot;
        }

        /*
            Here, we are done with the recursion.
            How to delete this node will depend on
            how many children it has
         */
        assert compare == 0; // Vi ha kommet fram til den keyen vi prøver å slette

        size--;

        /*
            What we are going to do here depends on the number of children:
            0
            1 (left or right)
            2

            The (2) is the most complex case.
            For the (1), just need to check which child is not-null, and that will become
            the new subtree returned when "this" node is deleted.
            If both children are missing (ie case 0), then the subtree is just "this" node.
            Once deleted, what is left is just a null subtree.
            So we return null.
            However, we do not need to explicitely have a check like
            "if(subtreeRoot.left == null && subtreeRoot.right == null) return null"
            as the following check would give the same result (ie returning null because
            subtreeRoot.right is null) even in the (0) case.
         */

        if (subtreeRoot.left == null) {
            return subtreeRoot.right; // Siden en leaf ikke har noen Children er .right og .left null, her returnerer vi basicly null
        }

        // Hvis vi sletter en subTreeNode med en child, så setter vi bare subtreeNodens .Left eller .Right (Ettersom vi er på venstre eller høyre side)
        // til å være noden over til å "eie" den gamle sin .left eller .Right (Se skrivebok)

        if (subtreeRoot.right == null) {
            return subtreeRoot.left;
        }

        /*
            Both children are present
         */
        assert subtreeRoot.left != null && subtreeRoot.right != null;

        TreeNode tmp = subtreeRoot;
        subtreeRoot = max(tmp.left); // 4
        subtreeRoot.left = deleteMax(tmp.left); // 4.left -> 1
        subtreeRoot.right = tmp.right;

        return subtreeRoot;
    }

    private TreeNode max(TreeNode subtreeRoot) {
        if (subtreeRoot.right == null) {
            return subtreeRoot;
        }
        return max(subtreeRoot.right);
    }

    private TreeNode deleteMax(TreeNode subtreeRoot) {

        if (subtreeRoot.right == null) {
            return subtreeRoot.left;
        }

        subtreeRoot.right = deleteMax(subtreeRoot.right);

        return subtreeRoot;
    }

}
