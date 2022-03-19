package org.pg4200.les02.list;

public class MyBidirectionalLinkedList<T> implements MyList<T> {

    private class ListNode{
        T value;
        ListNode next;
        ListNode previous; // Node som linker til den "bak" seg
    }

    private ListNode head;
    private ListNode tail;
    private int size;



    @Override
    public void delete(int index) {

        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }

        if(index == 0){ // Slette hode
            if(head.next != null){
                head = head.next; // Neste element blir hodet
                head.previous = null; // hode peker bak seg på ingenTing
            } else { // Eneste element i listen...
                head = null;
                tail = null;
            }
        } else if(index == (size-1)){ // Slette tail

            tail.previous.next = null; // [A-B-C]
            tail = tail.previous;

        } else {

            ListNode target = getNode(index); // Slette midt I
                                             // [A-B-C-D] e.g slett index 2 aka C

            target.previous.next = target.next; // [A-B-C-D] [A-B-->D]
            target.next.previous = target.previous; // [A-B<--D]
        }

        size--;
    }

    private ListNode getNode(int index){ // Hente en spesifikk node

        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }

        if(index <= size() / 2){ // Hvis index er mindre enn halvparten av Den lenka listen, start fra hode E.G index = 3 i en lenkaliste på 10 Elementer
            //start from head

            ListNode current = head; // Helt lik operasjon som på vanlig get.
            int counter = 0;

            while(current != null){ // Mens current node ikke er lik null aka siste element. Kjør while loop

                if(counter == index){ // Hvis counter == index gi meg Noden den traff på
                    return current;
                }

                current = current.next;
                counter++;
            }
        } else {
            //start from tail

            ListNode current = tail;
            int counter = 0;

            while(current != null){

                if(counter == ((size-1) - index)){ // Hvis counter er lik størrelse-1 -index e.g
                                                  //  [A, B, C, D, E] hent D, da får vi at counter skal være lik 1 fordi (5-1-3) == 1;
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

        ListNode node = new ListNode(); // X
        node.value = value;

        // Tom liste
        if(head == null){ // Samme som vanlig
            head = node;
            tail = node;

            // Insert på starten
        } else if(index == 0){ // [A-->B-->C]
            head.previous = node; // X<--A
            node.next = head; //X-->A
            head = node; // [X-->A-->B-->C] [X<--A<--B<--C]

            //Insert på Slutten
        } else if(index == size) { // [D-->E-->F]
            tail.next = node; // F-->X
            node.previous = tail; // F<--X
            tail = node; // // [D-->E-->F-->X] [D<--E<--F<--X]

        } else {

            // Insert midt i listen, Si vi skal inserte X
            ListNode target = getNode(index); // Henter noden som befinner seg der vi skal Inserte [L-M-N-O], si vi skal inserte på index 2,der N er
            ListNode beforeTarget = target.previous; // M

            beforeTarget.next = node; // [M-->X]
            node.previous = beforeTarget; // [M<--X]

            node.next = target; // [X-->N]
            target.previous = node; // [X<--N]
            // [L-->M-->X-->N-->O]
            // [L<--M<--X<--N<--O]
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }
}
