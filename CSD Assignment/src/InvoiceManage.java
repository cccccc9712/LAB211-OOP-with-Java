public class InvoiceManage {
    private Node root;

    public void insert(Invoice invoice) {
        root = insert(root, invoice, null);
    }

    private int height(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    private int balanceFactor(Node node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    private Node rotateLeft(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        x.left = y;
        y.right = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node rotateRight(Node x) {
        Node y = x.left;
        Node T2 = y.right;

        y.right = x;
        x.left = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private Node insert(Node node, Invoice invoice, Node parent) {
        if (node == null) {
            Node newNode = new Node(invoice);
            newNode.parent = parent; // Set the parent reference
            return newNode;
        }

        if (invoice.getInvoiceId().compareTo(node.invoice.getInvoiceId()) < 0) {
            node.left = insert(node.left, invoice, node); // Pass 'node' as the parent
        } else if (invoice.getInvoiceId().compareTo(node.invoice.getInvoiceId()) > 0) {
            node.right = insert(node.right, invoice, node); // Pass 'node' as the parent
        } else {
            // Handle duplicates (you may choose to do something here)
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = balanceFactor(node);

        // Left Heavy
        if (balance > 1) {
            if (invoice.getInvoiceId().compareTo(node.left.invoice.getInvoiceId()) < 0) {
                // Left-Left Case
                return rotateRight(node);
            } else {
                // Left-Right Case
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }

        // Right Heavy
        if (balance < -1) {
            if (invoice.getInvoiceId().compareTo(node.right.invoice.getInvoiceId()) > 0) {
                // Right-Right Case
                return rotateLeft(node);
            } else {
                // Right-Left Case
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }

        return node;
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            node.invoice.printInvoice();
            printInOrder(node.right);
        }
    }

    public void printInvoice(Invoice invoice) {
        invoice.printInvoice();
    }

    public Invoice search(String invoiceID) {
        return search(root, invoiceID);
    }

    private Invoice search(Node node, String invoiceID) {
        if (node == null) return null;

        if (invoiceID.compareTo(node.invoice.getInvoiceId()) < 0) {
            return search(node.left, invoiceID);
        } else if (invoiceID.compareTo(node.invoice.getInvoiceId()) > 0) {
            return search(node.right, invoiceID);
        } else {
            return node.invoice;
        }
    }
}
