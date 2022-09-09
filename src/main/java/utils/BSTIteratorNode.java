package utils;

public class BSTIteratorNode<Key extends Comparable<Key>, Value> implements BinaryNode, KeyNode<Key> {

    private BSTIteratorNode<Key, Value> left, right;
    private Key key;
    private Value value;
    private int size;

    public BSTIteratorNode(Key key, Value value, int size) {
        this.left = null;
        this.right = null;
        this.value = value;
        this.key = key;
        this.size = size;
    }

    public BSTIteratorNode<Key, Value> getLeft() {
        return this.left;
    }

    @SuppressWarnings("unchecked")
    public void setLeft(BinaryNode node) {
        if (node instanceof BSTIteratorNode) {
            this.left = (BSTIteratorNode<Key, Value>) node;
        }
    }

    public BSTIteratorNode<Key, Value> getRight() {
        return this.right;
    }

    @SuppressWarnings("unchecked")
    public void setRight(BinaryNode node) {
        if (node instanceof BSTIteratorNode) {
            this.right = (BSTIteratorNode<Key, Value>) node;
        }
    }

    public Value getValue() {
        return this.value;
    }

    public void setValue(Value newValue) {
        this.value = newValue;
    }

    public Key getKey() {
        return this.key;
    }

    public void setKey(Key newKey) {
        this.key = newKey;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
