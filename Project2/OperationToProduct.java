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
        list.clear(); // làm trống list
        FileInputStream file = new FileInputStream(fileName);
        // khai báo mảng String 4 phần tử để chứa data của Product
        String[] string = new String[4];
        String s = "";
        int i = 0, j = 0;
        // bắt đầu đọc file
        while ((i = file.read()) != -1) {
            // kiểm tra nếu gặp Space hoặc | thì lấy dữ liệu đã đọc được gán vào mảng data
            // rồi tiếp tục
            if (i == 32 || i == 124) {
                while (i == 32 || i == 124) {
                    i = file.read();
                }
                string[j] = s;
                j++;
                s = "";
            }
            // kiểm tra nếu kết thúc 1 hàng thì khởi tạo Product và gán vào list rồi tiếp
            // tục
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
        stack.clear(); // làm trống stack
        FileInputStream file = new FileInputStream(fileName);
        // khai báo mảng String 4 phần tử để chứa data của Product
        String[] string = new String[4];
        String s = "";
        int i = 0, j = 0;
        // bắt đầu đọc file
        while ((i = file.read()) != -1) {
            // kiểm tra nếu gặp Space hoặc | thì lấy dữ liệu đã đọc được gán vào mảng data
            // rồi tiếp tục
            if (i == 32 || i == 124) {
                while (i == 32 || i == 124) {
                    i = file.read();
                }
                string[j] = s;
                j++;
                s = "";
            }
            // kiểm tra nếu kết thúc 1 hàng thì khởi tạo Product và gán vào stack rồi tiếp
            // tục
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
        queue.clear(); // làm trống queue
        FileInputStream file = new FileInputStream(fileName);
        // khai báo mảng String 4 phần tử để chứa data của Product
        String[] string = new String[4];
        String s = "";
        int i = 0, j = 0;
        // bắt đầu đọc file
        while ((i = file.read()) != -1) {
            // kiểm tra nếu gặp Space hoặc | thì lấy dữ liệu đã đọc được gán vào mảng data
            // rồi tiếp tục
            if (i == 32 || i == 124) {
                while (i == 32 || i == 124) {
                    i = file.read();
                }
                string[j] = s;
                j++;
                s = "";
            }
            // kiểm tra nếu kết thúc 1 hàng thì khởi tạo Product và gán vào queue rồi tiếp
            // tục
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
        // nếu không có file thì tạo ra file mới
        if (!file.exists()) {
            file.createNewFile();
        }

        // ghi file
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter output = new PrintWriter(bw);
        Node current = list.getHead();
        while (current != null) {
            // kiểm tra nếu file rỗng thì in vào dòng đầu tiên ngược lại thì in xuống hàng
            // mới
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
        // nhận Id cần search
        savePrint(old, "Input the ID to search = ");
        String id = input.nextLine();
        // bắt đầu kiểm tra từ head
        Node current = list.getHead();
        while (current != null) {
            // nếu có thì in kết quả đầu tiên và kết thúc
            if (current.getInfo().getId().equals(id)) {
                savePrint(old, "Result: ");
                savePrintln(old, current.getInfo().toString());
                return;
            }
            current = current.getNextNode();
        }
        // in ra không tìm được nếu không có kết quả
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
        // nhận id cần xóa
        savePrint(old, "Input the ID to delete = ");
        String id = input.nextLine();
        // kiểm tra nếu là head thì xóa head
        Node current = list.getHead();
        if (current.getInfo().getId().equals(id)) {
            list.deleteFromHead();
            savePrintln(old, "Deleted!");
            return;
        }
        // kiểm tra từ sau head nếu có thì xóa
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
