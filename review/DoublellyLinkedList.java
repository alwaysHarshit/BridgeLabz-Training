public class DoublyLinkedList {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    static class DoublyLinkedListMethod {
        private Node head;
        private Node tail;

        // Insert at beginning
        public void addFirst(int data) {
            Node node = new Node(data);

            if (head == null) {
                head = tail = node;
            } else {
                node.right = head;
                head.left = node;
                head = node;
            }
        }

        // Insert at end
        public void addLast(int data) {
            Node node = new Node(data);

            if (head == null) {
                head = tail = node;
            } else {
                tail.right = node;
                node.left = tail;
                tail = node;
            }
        }

        //remove at starting
        public  void deleteFirst(){

            if(head==null) {
                System.out.println("no node present");
                return;
            }
            Node node=head;
            head=node.right;
            node.right=null;
            head.left=null;
        }
        //remove at end
        public void deleteLast(){
            if(head==null) {
                System.out.println("no node present");
                return;
            }
            Node node=tail;
            tail=node.left;
            node.left=null;
            tail.right=null;
        }
        // Print list
        public void print() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value + " <-> ");
                temp = temp.right;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        DoublyLinkedListMethod dm = new DoublyLinkedListMethod();

        dm.addFirst(1);
        dm.addFirst(2);
        dm.addFirst(3);
        dm.addFirst(4);
        dm.addLast(10);

        dm.print();

        dm.deleteFirst();
        dm.deleteFirst();

        dm.print();
        dm.deleteLast();
        dm.deleteLast();
        dm.print();
    }
}
