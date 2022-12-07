package ch.benibuehler.day7.Models;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    private T data;

    private int size = 0;

    private final List<Node<T>> children = new ArrayList<>();

    private Node<T> parent = null;

    public Node(T data) {
        this.data = data;
    }

    public void addChild(Node<T> child)
    {
        child.setParent(this);
        this.children.add(child);
    }
    public T getData() {
        return data;
    }

    public int getSize() {
        return size;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }
}
