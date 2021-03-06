package Project2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class OperationToProduct extends SavePrint {
    Scanner input = new Scanner(System.in);

    /**
     * 
     * Searching and returning the index of product p in the list. If not found
     * 
     * return -1.
     *
     * 
     * 
     * @param p    Product for searching
     * 
     * @param list The Linked List
     * 
     * @return The index of product p in the list
     * 
     */

    public int index(Product p, MyList list) {
        int index = 0;
        Node current = list.getHead();
        while (current != null) {
            if (current.getInfo().equal(p)) {
                return index;
            }
            index++;
            current = current.getNextNode();
        }
        return -1;
    }

    /**
     * 
     * Creating and returning a product with info input from keyboard.
     *
     * 
     * 
     * @return The product
     * 
     */

    public Product createProduct(PrintStream old) {
        savePrint(old, "Input new ID: ");
        String id = input.nextLine();
        savePrint(old, "Input Product's Name: ");
        String title = input.nextLine();
        savePrint(old, "Input Product's quantity: ");
        int quantity = input.nextInt();
        savePrint(old, "Input Product's price: ");
        double price = input.nextDouble();
        input.nextLine();
        Product p = new Product(id, title, quantity, price);
        return p;
    }

    /**
     * 
     * Reading all products from the file and insert them to the list at tail.
     *
     * 
     * 
     * @param fileName The file name of the file
     * 
     * @param list     The Linked List contains all products that read from file
     * @throws IOException
     * 
     */

    public void getAllItemsFromFile(String fileName, MyList list) throws IOException {
        list.clear(); // l??m tr???ng list
        FileInputStream file = new FileInputStream(fileName);
        // khai b??o m???ng String 4 ph???n t??? ????? ch???a data c???a Product
        String[] string = new String[4];
        String s = "";
        int i = 0, j = 0;
        // b???t ?????u ?????c file
        while ((i = file.read()) != -1) {
            // ki???m tra n???u g???p Space ho???c | th?? l???y d??? li???u ???? ?????c ???????c g??n v??o m???ng data
            // r???i ti???p t???c
            if (i == 32 || i == 124) {
                while (i == 32 || i == 124) {
                    i = file.read();
                }
                string[j] = s;
                j++;
                s = "";
            }
            // ki???m tra n???u k???t th??c 1 h??ng th?? kh???i t???o Product v?? g??n v??o list r???i ti???p
            // t???c
            if (i == 13 || i == 10) {
                while (i == 13 || i == 10) {
                    i = file.read();
                }
                string[j] = s;
                Product p = new Product(string[0], string[1], Integer.parseInt(string[2]),
                        Double.parseDouble(string[3]));
                list.addTail(p);
                j = 0;
                s = "";
            }
            s += ((char) i);
        }
        string[j] = s;
        Product p = new Product(string[0], string[1], Integer.parseInt(string[2]), Double.parseDouble(string[3]));
        list.addTail(p);
        file.close();

    }

    /**
     * 
     * Reading all products from the file and insert them to the stack.
     *
     * 
     * 
     * @param fileName The file name of the file
     * 
     * @param stack    The Stack contains all products that read from file
     * @throws FileNotFoundException
     * 
     */

    public void getAllItemsFromFile(String fileName, MyStack stack) throws IOException {
        stack.clear(); // l??m tr???ng stack
        FileInputStream file = new FileInputStream(fileName);
        // khai b??o m???ng String 4 ph???n t??? ????? ch???a data c???a Product
        String[] string = new String[4];
        String s = "";
        int i = 0, j = 0;
        // b???t ?????u ?????c file
        while ((i = file.read()) != -1) {
            // ki???m tra n???u g???p Space ho???c | th?? l???y d??? li???u ???? ?????c ???????c g??n v??o m???ng data
            // r???i ti???p t???c
            if (i == 32 || i == 124) {
                while (i == 32 || i == 124) {
                    i = file.read();
                }
                string[j] = s;
                j++;
                s = "";
            }
            // ki???m tra n???u k???t th??c 1 h??ng th?? kh???i t???o Product v?? g??n v??o stack r???i ti???p
            // t???c
            if (i == 13 || i == 10) {
                while (i == 13 || i == 10) {
                    i = file.read();
                }
                string[j] = s;
                Product p = new Product(string[0], string[1], Integer.parseInt(string[2]),
                        Double.parseDouble(string[3]));
                stack.push(p);
                j = 0;
                s = "";
            }
            s += ((char) i);
        }
        string[j] = s;
        Product p = new Product(string[0], string[1], Integer.parseInt(string[2]), Double.parseDouble(string[3]));
        stack.push(p);
        file.close();
    }

    /**
     * 
     * Reading all products from the file and insert them to the queue.
     *
     * 
     * 
     * @param fileName The file name of the file
     * 
     * @param queue    The Queue contains all products that read from file
     * 
     */

    public void getAllItemsFromFile(String fileName, MyQueue queue) throws IOException {
        queue.clear(); // l??m tr???ng queue
        FileInputStream file = new FileInputStream(fileName);
        // khai b??o m???ng String 4 ph???n t??? ????? ch???a data c???a Product
        String[] string = new String[4];
        String s = "";
        int i = 0, j = 0;
        // b???t ?????u ?????c file
        while ((i = file.read()) != -1) {
            // ki???m tra n???u g???p Space ho???c | th?? l???y d??? li???u ???? ?????c ???????c g??n v??o m???ng data
            // r???i ti???p t???c
            if (i == 32 || i == 124) {
                while (i == 32 || i == 124) {
                    i = file.read();
                }
                string[j] = s;
                j++;
                s = "";
            }
            // ki???m tra n???u k???t th??c 1 h??ng th?? kh???i t???o Product v?? g??n v??o queue r???i ti???p
            // t???c
            if (i == 13 || i == 10) {
                while (i == 13 || i == 10) {
                    i = file.read();
                }
                string[j] = s;
                Product p = new Product(string[0], string[1], Integer.parseInt(string[2]),
                        Double.parseDouble(string[3]));
                queue.enqueue(p);
                j = 0;
                s = "";
            }
            s += ((char) i);
        }
        string[j] = s;
        Product p = new Product(string[0], string[1], Integer.parseInt(string[2]), Double.parseDouble(string[3]));
        queue.enqueue(p);
        file.close();
    }

    /**
     * 
     * Adding a product to the list, info of the product input from keyboard.
     *
     * 
     * 
     * @param list The Linked list
     * 
     */

    public void addLast(MyList list, PrintStream old) {
        Product p = this.createProduct(old);
        list.addTail(p);

    }

    /**
     * 
     * Printing all prodcuts of the list to console screen
     *
     * 
     * 
     * @param list
     * 
     */

    public void displayAll(MyList list, PrintStream old) {
        savePrintln(old, " ID |  Title   | Quantity | Price");
        savePrintln(old, "-------------------------------");
        Node current = list.getHead();
        while (current != null) {
            savePrintln(old, current.toString());
            current = current.getNextNode();
        }

    }

    /**
     * 
     * Writing all products from the list to the file
     *
     * 
     * 
     * @param fileName Input file name
     * 
     * @param list     Input Linked list
     * @throws IOException
     * 
     */

    public void writeAllItemsToFile(String fileName, MyList list) throws IOException {
        File file = new File(fileName);
        boolean isEmpty = true;
        // n???u kh??ng c?? file th?? t???o ra file m???i
        if (!file.exists()) {
            file.createNewFile();
        }

        // ghi file
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter output = new PrintWriter(bw);
        Node current = list.getHead();
        while (current != null) {
            // ki???m tra n???u file r???ng th?? in v??o d??ng ?????u ti??n ng?????c l???i th?? in xu???ng h??ng
            // m???i
            if (isEmpty) {
                PrintWriter outputFirst = new PrintWriter(file);
                outputFirst.print(current.getInfo().toString());
                outputFirst.close();
                isEmpty = false;
            } else {
                output.println("");
                output.print(current.getInfo().toString());
            }
            current = current.getNextNode();
        }
        output.flush();
        output.close();

    }

    /**
     * 
     * Searching product by ID input from keyboard.
     *
     * 
     * 
     * @param list
     * 
     */

    public void searchByCode(MyList list, PrintStream old) {
        // nh???n Id c???n search
        savePrint(old, "Input the ID to search = ");
        String id = input.nextLine();
        // b???t ?????u ki???m tra t??? head
        Node current = list.getHead();
        while (current != null) {
            // n???u c?? th?? in k???t qu??? ?????u ti??n v?? k???t th??c
            if (current.getInfo().getId().equals(id)) {
                savePrint(old, "Result: ");
                savePrintln(old, current.getInfo().toString());
                return;
            }
            current = current.getNextNode();
        }
        // in ra kh??ng t??m ???????c n???u kh??ng c?? k???t qu???
        savePrintln(old, "Result: Not found Product!");
    }

    /**
     * 
     * Deleting first product that has the ID input from keyboard from the list.
     *
     * 
     * 
     * @param list
     * 
     */

    public void deleteByCode(MyList list, PrintStream old) {
        // nh???n id c???n x??a
        savePrint(old, "Input the ID to delete = ");
        String id = input.nextLine();
        // ki???m tra n???u l?? head th?? x??a head
        Node current = list.getHead();
        if (current.getInfo().getId().equals(id)) {
            list.deleteFromHead();
            savePrintln(old, "Deleted!");
            return;
        }
        // ki???m tra t??? sau head n???u c?? th?? x??a
        while (current != null) {
            Node newNode = current.getNextNode();
            if (newNode.getInfo().getId().equals(id)) {
                current.setNextNode(newNode.getNextNode());
                savePrintln(old, "Deleted!");
                return;
            }
            current = current.getNextNode();
        }
    }

    /**
     * 
     * function to swap nodes 'p1' and 'p2' in a linked list without swapping data
     *
     * 
     * @param head  The head of list
     * @param p1    The head of list
     * @param p2    The node to swap
     * @param preP2 The node previous p2
     * 
     */

    public Node swap(Node head, Node p1, Node p2, Node preP2) {
        // make 'p2' as new head
        head = p2;

        // adjust links
        preP2.setNextNode(p1);

        // Swap p1 p2
        Node temp = p2.getNextNode();
        p2.setNextNode(p1.getNextNode());
        p1.setNextNode(temp);
        return head;
    }

    /**
     * 
     * Sorting products in linked list by ID use Recursive selection sort
     *
     * 
     * @param list The Linked list
     * @param head The head of list
     * 
     */

    public Node sortByCode(MyList list, Node head) {
        // end recursion
        if (head.getNextNode() == null) {
            list.setTail(head);
            return head;
        }
        // 'min' - pointer to store the node having minimum data value
        Node min = head;
        // 'beforeMin' - pointer to store node previous
        // to 'min' node
        Node beforeMin = null;
        Node ptr;
        // traverse the list till the last node
        for (ptr = head; ptr.getNextNode() != null; ptr = ptr.getNextNode()) {

            // if true, then update 'min' and 'beforeMin'
            if (min.getInfo().getId().compareTo(ptr.getNextNode().getInfo().getId()) > 0) {
                min = ptr.getNextNode();
                beforeMin = ptr;
            }
        }
        // if 'min' and 'head' are not same,
        // swap the head node with the 'min' node
        if (min != head) {
            head = this.swap(head, head, min, beforeMin);
        }
        // recursively sort the remaining list
        head.setNextNode(this.sortByCode(list, head.getNextNode()));
        return head;
    }

    /**
     * 
     * Adding new product to head of Linked List. The info input from keyboard.
     *
     * 
     * 
     * @param list The linked list
     * 
     */

    public void addFirst(MyList list, PrintStream old) {
        Product p = this.createProduct(old);
        list.addHead(p);
    }

    /**
     * 
     * Convert a decimal to a binary number by Recursion. Example: input i = 18 ->
     * Output =
     * 
     * 100010
     *
     * 
     * 
     * @param i Input decimal number
     * 
     * @return binary number
     * 
     */

    public int convertToBinary(int i) {
        if (i == 0) {
            return 0;
        } else {
            return (i % 2 + 10 * convertToBinary(i / 2)); // recursion
        }
    }

    /**
     * 
     * Deleting the product at position
     *
     * 
     * 
     * @param list The Linked List
     * 
     * @param pos  The position of product to be deleted
     * 
     */

    public void deleteAtPosition(MyList list, int pos, PrintStream old) {
        int length = 0;
        if (pos == length) {
            list.deleteFromHead();
            savePrintln(old, "Deleted!");
            return;
        }
        Node current = list.getHead();
        while (current != null) {
            length++;
            if (length == pos) {
                current.setNextNode(current.getNextNode().getNextNode());
                if (pos == list.length() - 1) {
                    list.setTail(current);
                }
                savePrintln(old, "Deleted!");
                return;
            }
            current = current.getNextNode();
        }
    }

}
