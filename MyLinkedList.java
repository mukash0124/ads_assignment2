import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MyLinkedList<T> implements MyList<T> {

    private class MyNode {
        private final T data;
        private MyNode next;
        private MyNode previous;

        public MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    @Override
    public void add(T item) {
        MyNode newNode = new MyNode(item);
        size++;
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
    }

    @Override
    public T get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
        MyNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T remove(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
        MyNode prev = null;

        MyNode temp = head;
        for (int i = 0; i < index; i++) {
            prev = temp;
            temp = temp.next;
        }

        if(temp == head) {
            head = head.next;
            head.previous = null;
        } else {
            prev.next = temp.next;
            temp.next.previous = prev;
        }

        return temp.data;
        size--;
    }

    @Override
    public boolean contains(Object o) {
        for (MyNode i = head; i != null; i = i.next) {
            if (i.data == o) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        for (MyNode i = head; i != null; i = i.next) {
            if (i.data == o) {
                return index;
            }
            index++;
        }

        return -1;
    }

    @Override
    public void sort() {
        MyNode current = head, index;

        while (current != null) {
            index = current.next;

            while (index != null) {
                if (current.data > index.data) {
                    T temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }

            current = current.next;
        }
    }

    @Override
    public boolean remove(Object o) {
        if (indexOf(o) == -1) {
            return false;
        } else {
            remove(indexOf(o));
            return true;
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        int count = 0;

        for (MyNode i = head; i != null; i = i.next) {
            if (i.data == o) {
                index = count;
            }
            count++;
        }

        return index;
    }

    @Override
    public void add(T item, int index) {
        
    }

}