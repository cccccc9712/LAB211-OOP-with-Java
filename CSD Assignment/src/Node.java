class Node {
    Invoice invoice;
    Node left;
    Node right;
    Node parent; // Add a parent reference

    int height;

    Node(Invoice invoice) {
        this.invoice = invoice;
        left = null;
        right = null;
        parent = null;
        height = 1;
    }
}
