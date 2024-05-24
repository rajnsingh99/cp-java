package recursion;


public class LeetCode {

    private static Node root;

    public static void main(String args[]) {
        System.out.println("LeetCode: Recursion Solution");
        // Creating LL
        addToLL(new Node("1"));
        addToLL(new Node("2"));
        addToLL(new Node("3"));
        addToLL(new Node("4"));
        addToLL(new Node("5"));
        addToLL(new Node("6"));
        addToLL(new Node("7"));

//        printLL(root);
        reverseLL();
    }

    private static void addToLL(Node newNode) {
        if(root == null) {
            root = new Node("1");
        } else {
            Node tempNode = root;
            do {
                if(tempNode.next == null) {
                    tempNode.next = newNode;
                    System.out.println("Added " + newNode);
                    return;
                }

                tempNode = tempNode.next;
            } while(true);
        }
    }

    private static void reverseLL() {
        Node tempNode = root;
        Node reversedLL = null;
        reverse(tempNode, reversedLL);
        printLL(reversedLL);
    }

    private static void reverse(Node currNode, Node newLL) {
        if(currNode.next == null) {
            newLL = new Node(currNode.value);
            return;
        }

        reverse(currNode.next, newLL);
        newLL.next = new Node(currNode.value);


        // Steps:
        // 1. Traverse to the end node
        // 2. During backtracking amend individual nodes

    }

    private static void printLL(Node head) {
        Node tempNode = head;
        do {
            System.out.println("Node " + tempNode);
            tempNode = tempNode.next;
        } while(tempNode != null);
    }

    public static class Node {
        String value;
        Node next;
        Node (String value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "value: " + value + "\n";
        }
    }
}
