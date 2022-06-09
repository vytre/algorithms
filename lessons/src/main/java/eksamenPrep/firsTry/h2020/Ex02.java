package eksamenPrep.firsTry.h2020;

import org.pg4200.les02.list.MyList;

public class Ex02<T> implements MyList<T> {

    private class Node{
        T value;
        Node next;
        Node previous;
    }

    private Node head;

    private Node middle;
    private Node tail;
    private int size;


    public int getMiddle(){
        if(isEmpty()){
            return -1;
        }

        return (int) (Math.ceil(size() / 2.0) - 1);
    }

    @Override
    public void delete(int index) {
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }

        if(index == 0){
            if(head.next != null){
                head = head.next;
                head.previous = null;
            } else {
                head = null;
                tail = null;
            }
        } else if(index == (size-1)){

            tail.previous.next = null;
            tail = tail.previous;

        } else {

            Node target = getNode(index);

            target.previous.next = target.next;
            target.next.previous = target.previous;
        }

        size--;
    }

    private Node getNode(int index){

        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }

        if(index <= size() / 2){
            //start from head

            Node current = head;
            int counter = 0;

            while(current != null){

                if(counter == index){
                    return current;
                }

                current = current.next;
                counter++;
            }
        } else {
            //start from tail

            Node current = tail;
            int counter = 0;

            while(current != null){

                if(counter == ((size-1) - index)){
                    return current;
                }

                current = current.previous;
                counter++;
            }
        }

        return null;
    }

    @Override
    public T get(int index) {
        return getNode(index).value;
    }

    @Override
    public void add(int index, T value) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        Node node = new Node();
        node.value = value;

        if(head == null){
            head = node;
            tail = node;

        } else if(index == 0){
            head.previous = node;
            node.next = head;
            head = node;

        } else if(index == size) {
            tail.next = node;
            node.previous = tail;
            tail = node;

        } else {

            Node target = getNode(index);
            Node beforeTarget = target.previous;

            beforeTarget.next = node;
            node.previous = beforeTarget;

            node.next = target;
            target.previous = node;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }
}
