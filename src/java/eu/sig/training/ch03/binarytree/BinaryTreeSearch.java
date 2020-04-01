package eu.sig.training.ch03.binarytree;

public class BinaryTreeSearch {

    // tag::calculateDepth[]
    public static int calculateDepth(BinaryTreeNode<Integer> node, int nodeValue) {
        int depth = 0;
        if (node.getValue() == nodeValue) {
            return depth;
        } else {
            if (nodeValue < node.getValue()) {
                return new NodeLeft(node, nodeValue).invoke();
            } else {
                return new NodeRight(node, nodeValue).invoke();
            }
        }
    }

    private static class NodeLeft {
        private BinaryTreeNode<Integer> node;
        private int nodeValue;

        public NodeLeft(BinaryTreeNode<Integer> node, int nodeValue) {
            this.node = node;
            this.nodeValue = nodeValue;
        }

        public int invoke() {
            BinaryTreeNode<Integer> left = node.getLeft();
            if (left == null) {
                throw new TreeException("Value not found in tree!");
            } else {
                return 1 + calculateDepth(left, nodeValue);
            }
        }
    }

    private static class NodeRight {
        private BinaryTreeNode<Integer> node;
        private int nodeValue;

        public NodeRight(BinaryTreeNode<Integer> node, int nodeValue) {
            this.node = node;
            this.nodeValue = nodeValue;
        }

        public int invoke() {
            BinaryTreeNode<Integer> right = node.getRight();
            if (right == null) {
                throw new TreeException("Value not found in tree!");
            } else {
                return 1 + calculateDepth(right, nodeValue);
            }
        }
    }
    // end::calculateDepth[]

}