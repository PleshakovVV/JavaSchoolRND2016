package homeWorks.homeWork4;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class LinkedList<E> extends AbstractCollection<E>{
    private static class Node<T> {
        Node<T> previous;
        Node<T> next;
        T value;

        public Node(Node<T> previous, Node<T> next, T value) {
            this.previous = previous;
            this.next = next;
            this.value = value;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;
    private int modificationCounter;

    public LinkedList() {
        head = tail = new Node<E>(null,null,null);
    }

    @Override
    public boolean add(E element) {
        tail = new Node<>(tail,null,element);
        tail.previous.next = tail;
        size++;
        this.modificationCounter++;
        return true;
    }

    public void add(int index, E element) {
        Node<E> currentNode = this.getNode(index);
        currentNode.previous = currentNode.previous.next = new Node<E>(currentNode.previous,currentNode,element);
        size++;
        this.modificationCounter++;
    }

    public E get(int index) throws IndexOutOfBoundsException{
        return this.getNode(index).value;
    }

    private Node<E> getNode(int index) throws IndexOutOfBoundsException{
        this.checkBounds(index);
        Node<E> currentNode;
        if (size / 2 < index) {
            currentNode = tail;
            for (int i = 0; i < size - 1 - index; i++) {
                currentNode = currentNode.previous;
            }
        }
        else {
            currentNode = head.next;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        }
        return currentNode;
    }

    private void checkBounds(int index) throws IndexOutOfBoundsException {
        if ((index > size - 1) ||(index < 0)) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds: [0," + (size - 1) + "].");
        }
    }

    public void remove(int index) {
        checkBounds(index);
        Node<E> currentNode = this.getNode(index);
        if (currentNode == tail) {
            currentNode.previous.next = null;
            tail = currentNode.previous;
            size--;
        }
        else {
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
            size--;
        }
        modificationCounter++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        this.modificationCounter = 0;
        return new Iterator<E>() {

            private int iteratorModificationCounter = 0;
            Node<E> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode.next != null;
            }

            @Override
            public E next() {
                if (this.iteratorModificationCounter != LinkedList.this.modificationCounter) {
                    throw new ConcurrentModificationException("Modification during iterator loop!");
                }
                currentNode = currentNode.next;
                return currentNode.value;
            }

            @Override
            public void remove() {
                currentNode.previous.next = currentNode.next;
                currentNode.next.previous = currentNode.previous;
                this.iteratorModificationCounter++;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            result.append(currentNode.value.toString() + " ");
        }
        result.delete(result.length() - 1,result.length());
        result.append("]");
        return result.toString();
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        for (E element : collection) {
            this.add(element);
        }
        this.modificationCounter++;
        return true;
    }

    public void copy(Collection<? super E> collection) {
        for (E element : this) {
            collection.add(element);
        }
    }
}
