package proglib.lesson5;

public class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        System.out.print("Empty list: ");
        list.print();
        System.out.println("size = " + list.size() + "\n");

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.print("List after adding from 1 to 4: ");
        list.print();
        System.out.println("size = " + list.size() + "\n");

        list.addFirst(0);
        System.out.print("List after adding 0 to the head: ");
        list.print();
        System.out.println("size = " + list.size() + "\n");

        System.out.print("Getting element with index 1: ");
        System.out.println(list.get(1));
        System.out.print("Getting element with index 2: ");
        System.out.println(list.get(2));
        System.out.print("Getting element with index 3: ");
        System.out.println(list.get(3) + "\n");

        list.add(0, 2);
        System.out.print("List after adding 2 to index 0: ");
        list.print();
        System.out.println("size = " + list.size() + "\n");

        list.add(1, 1);
        System.out.print("List after adding 1 to index 1: ");
        list.print();
        System.out.println("size = " + list.size() + "\n");

        list.add(list.size(), 6);
        System.out.print("List after adding 6 to index " + list.size() + " (size): ");
        list.print();
        System.out.println("size = " + list.size() + "\n");

        list.add(list.size() - 1, 5);
        System.out.print("List after adding 5 to index " + (list.size() - 1) + " (size - 1): ");
        list.print();
        System.out.println("size = " + list.size() + "\n");

        list.remove(1);
        System.out.print("List after removing from index 1: ");
        list.print();
        System.out.println("size = " + list.size() + "\n");

        list.remove(0);
        System.out.print("List after removing from index 0: ");
        list.print();
        System.out.println("size = " + list.size() + "\n");

        list.remove(list.size() - 2);
        System.out.print("List after removing from index " + (list.size() - 2) + " (size - 2): ");
        list.print();
        System.out.println("size = " + list.size() + "\n");

        list.remove(list.size() - 1);
        System.out.print("List after removing from index " + (list.size() - 1) + " (size - 1): ");
        list.print();
        System.out.println("size = " + list.size() + "\n");

        for (int i = 0; i < list.size(); i++) {
            list.set(i, 9);
        }
        System.out.print("List after setting 9 to every index: ");
        list.print();
        System.out.println("size = " + list.size() + "\n");
    }

    private int size;
    private Entry head;
    private Entry tail;

    public int size() {
        return this.size;
    }

    public void addFirst(int value) {
        if (head == null) {
            head = new Entry(value);
        } else {
            Entry next = head;
            head = new Entry(value, null, next);
            next.prev = head;
        }
        this.size++;
    }

    public void add(int value) {
        if (head == null) {
            head = new Entry(value);
        } else if (tail == null) {
            tail = new Entry(value, head, null);
            head.next = tail;
        } else {
            Entry prev = tail;
            tail = new Entry(value, prev, null);
            prev.next = tail;
        }
        this.size++;
    }

    public void add(int idx, int value) {
        if (head == null && idx == 0) {
            addFirst(value);
            return;
        } else if (tail == null && idx == 1) {
            add(value);
            return;
        } else if (head != null && tail != null && idx >= 0 && idx <= size) {
            if (idx <= size / 2) addFromHead(idx, value);
            else addFromTail(idx, value);
            return;
        }
        throw new IndexOutOfBoundsException(idx);
    }

    private void addFromHead(int idx, int value) {
        if (idx == 0) {
            Entry next = head;
            head = new Entry(value, head);
            next.prev = head;
            size++;
            return;
        }
        int count = 1;
        Entry current = head.next;
        while (current != null) {
            if (count == idx) {
                current.prev.next = new Entry(value, current.prev, current);
                current.prev = current.prev.next;
                size++;
                return;
            }
            current = current.next;
            count++;
        }
    }

    private void addFromTail(int idx, int value) {
        if (idx == size) {
            add(value);
            return;
        }
        if (idx == size - 1) {
            Entry current = new Entry(value, tail.prev, tail);
            tail.prev.next = current;
            tail.prev = current;
            size++;
            return;
        }
        int count = size - 2;
        Entry current = tail.prev;
        while (current != null) {
            if (count == idx) {
                current.prev.next = new Entry(value, current.prev, current);
                current.prev = current.prev.next;
                size++;
                return;
            }
            current = current.prev;
            count--;
        }
    }

    public int get(int idx) {
        if (idx > size - 1 || idx < 0) throw new IndexOutOfBoundsException(idx);
        if (idx <= size / 2) return getFromHead(idx);
        else return getFromTail(idx);
    }

    private int getFromHead(int idx) {
        int count = 0;
        Entry current = head;
        while (current != null) {
            if (count == idx) return current.value;
            current = current.next;
            count++;
        }
        throw new IndexOutOfBoundsException(idx);
    }

    private int getFromTail(int idx) {
        int count = size - 1;
        Entry current = tail;
        while (current != null) {
            if (count == idx) return current.value;
            current = current.prev;
            count--;
        }
        throw new IndexOutOfBoundsException(idx);
    }

    public void remove(int idx) {
        if (head == null || (tail == null && idx > 0) || (idx > size - 1 || idx < 0)) {
            throw new IndexOutOfBoundsException(idx);
        }
        if (idx <= size / 2) removeFromHead(idx);
        else removeFromTail(idx);
    }

    private void removeFromHead(int idx) {
        if (idx == 0) {
            Entry next = head.next;
            next.prev = null;
            head = next;
            size--;
            return;
        }
        int count = 1;
        Entry current = head.next;
        while (current != null) {
            if (count == idx) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size--;
                return;
            }
            current = current.next;
            count++;
        }
    }

    private void removeFromTail(int idx) {
        if (idx == size - 1) {
            Entry prev = tail.prev;
            prev.next = null;
            tail = prev;
            size--;
            return;
        }
        int count = size - 2;
        Entry current = tail.prev;
        while (current != null) {
            if (count == idx) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size--;
                return;
            }
            current = current.next;
            count++;
        }
    }

    public void set(int idx, int value) {
        if (head == null || (tail == null && idx > 0) || (idx > size - 1 || idx < 0)) {
            throw new IndexOutOfBoundsException(idx);
        }
        if (idx <= size / 2) setFromHead(idx, value);
        else setFromTail(idx, value);
    }

    private void setFromHead(int idx, int value) {
        int count = 0;
        Entry current = head;
        while (current != null) {
            if (count == idx) {
                current.value = value;
                return;
            }
            current = current.next;
            count++;
        }
    }

    private void setFromTail(int idx, int value) {
        int count = size - 1;
        Entry current = tail;
        while (current != null) {
            if (count == idx) {
                current.value = value;
                return;
            }
            current = current.prev;
            count--;
        }
    }

    public void print() {
        StringBuilder result = new StringBuilder("[");
        if (head == null) {
            result.append("]");
        } else {
            Entry el = head;
            result.append(el.value);
            el = el.next;
            while (el != null) {
                result.append(", ").append(el.value);
                el = el.next;
            }
            result.append("]");
        }
        System.out.println(result);
    }

    private static class Entry {
        private int value;
        private Entry next;
        private Entry prev;

        private Entry(int value) {
            this.value = value;
            this.next = null;
        }

        private Entry(int value, Entry next) {
            this.value = value;
            this.next = next;
        }

        private Entry(int value, Entry prev, Entry next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
