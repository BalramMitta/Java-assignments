package SingleLinkedList;

class SList<E> {
    Link<E> link = new Link<>(null);
    Link<E> flink = new Link<>(null);

    public SList() {

    }

    // return SlistIterator

    SListIterator iterator() {
        return new SListIterator();
    }


    /*

    returns list in the form of string

    Ex : [ "item1", "item2", ......, "itemN" ]

     */

    @Override
    public String toString() {
        if (link.next == null) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder("[");
        SListIterator iterator = new SListIterator();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
            stringBuilder.append(", ");
        }

        // deleting the last ", " added to string in loop after the last item and
        // adding "]" at the end to indicate the end of list

        return stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).append("]").toString();
    }

    class SListIterator {
        Link<E> current = link;

        boolean hasNext() {
            return  current !=null && current.next != null;
        }

        // returns next element and moves further
        E next() {
            current = current.next;
            return current.e;
        }

        // return next element but doesn't move
        E getNext(){
            return current.next.e;
        }

        void goToFirst(){
            current = link;
        }

        void goToLast(){
            while (current.next!=null){
                current=current.next;
            }
        }

        void insert(E e) {
            current.next = new Link<>(e, current.next);
        }

        void remove() {
            current.next = current.next.next;
        }
    }
}

class Link<E> {
    E e;
    Link<E> next;

    Link(E e) {
        this(e, null);
    }

    Link(E e, Link<E> next) {
        this.e = e;
        this.next = next;
    }

    @Override
    public String toString() {
        if (e == null) {
            return "null";
        } else {
            return e.toString();
        }
    }
}



public class Main {

    public static void main(String[] args) {

        SList<String> sList = new SList<>();

        SList<String>.SListIterator sListIterator = sList.iterator();

        sListIterator.insert("balram");
        sListIterator.insert("parikshith");
        sListIterator.insert("rahul");

        System.out.println(sList);    // printing the list
        System.out.println("\n --- \n");


        sListIterator.goToFirst();
        sListIterator.insert("abcd");   // Insert at first as we called go to first


        System.out.println("After adding abcd at begining");
        System.out.println(sList);    // printing the list
        System.out.println("\n --- \n");

        while (sListIterator.hasNext()){
            if(sListIterator.next().equalsIgnoreCase("rahul")) {
                sListIterator.insert("xyz");                                // Insert after rahul
                break;
            }
        }

        System.out.println("After adding xyz after rahul ");
        System.out.println(sList);    // printing the list
        System.out.println("\n --- \n");

        sListIterator.goToLast();
        sListIterator.insert("pqr");   // inserts at last as we called go to last


        System.out.println("After adding pqr at end ");
        System.out.println(sList);    // printing the list
        System.out.println("\n --- \n");

        sListIterator.goToFirst();     // to iterate the list from begining again we are going to first

        while (sListIterator.hasNext()){
            if(sListIterator.getNext().equalsIgnoreCase("xyz")) {
                sListIterator.remove();
                break;
            }
            else
                sListIterator.next();
        }


        System.out.println("After removing xyz ");
        System.out.println(sList);    // printing the list
        System.out.println("\n --- \n");




    }

}
