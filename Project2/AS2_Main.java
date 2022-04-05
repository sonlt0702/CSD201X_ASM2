package Project2;

import java.io.IOException;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AS2_Main extends SavePrint {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String fileName = "./data.txt"; // đường dẫn đến thư mục chứa dữ liệu
        // khởi tạo các Linked List and Operation
        MyList list = new MyList();
        MyStack stack = new MyStack();
        MyQueue queue = new MyQueue();
        OperationToProduct operation = new OperationToProduct();
        // khai báo và khởi tạo file lưu output console
        PrintStream fileOut = new PrintStream("./consoleOutput.txt");
        // Lưu System.out vào old
        PrintStream old = System.out;
        // bắt đầu ghi output vào file
        System.setOut(fileOut);
        int choose = -1;
        // các chức năng chính có thể chọn lại nhiều lần
        while (choose != 0) {
            showMenu(old);
            // bắt lỗi người dùng nhập sai kiểu dữ liệu
            try {
                choose = input.nextInt();
                // yêu cầu người dùng nhập lại chức năng tương ứng với danh sách trong list
                while (choose < 0 || choose > 10) {
                    savePrintln(old, "Retype choose in Product list (0-10)");
                    showMenu(old);
                    choose = input.nextInt();
                }
                // Hàm xử lý các chức năng chính tương ứng từng trường hợp
                switch (choose) {
                    case 1:
                        operation.getAllItemsFromFile(fileName, list);
                        operation.displayAll(list, old);
                        savePrintln(old, "Successfully!");
                        break;
                    case 2:
                        operation.addLast(list, old);
                        savePrintln(old, "Successfully!");
                        break;
                    case 3:
                        operation.displayAll(list, old);
                        break;
                    case 4:
                        operation.writeAllItemsToFile(fileName, list);
                        savePrintln(old, "Successfully!");
                        break;
                    case 5:
                        operation.searchByCode(list, old);
                        break;
                    case 6:
                        operation.deleteByCode(list, old);
                        break;
                    case 7:
                        list.setHead(operation.sortByCode(list, list.getHead()));
                        savePrintln(old, "Successfully!");
                        break;
                    case 8:
                        int i = list.getHead().getInfo().getQuantity();
                        savePrintln(old, "Quantity = " + i + " => " + operation.convertToBinary(i));
                        break;
                    case 9:
                        operation.getAllItemsFromFile(fileName, stack);
                        stack.display(old);
                        savePrintln(old, "Successfully!");
                        break;
                    case 10:
                        operation.getAllItemsFromFile(fileName, queue);
                        queue.display(old);
                        savePrintln(old, "Successfully!");
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                savePrintln(old, "Retype choose type Integer in Product list (0-10)");
            }
            // kiểm tra chọn xong 1 chức năng thì nhấn enter để tiếp tục
            if (choose != 0) {
                savePrint(old, "Press Enter to continute!");
                input.nextLine();
                input.nextLine();
            }
        }
        savePrintln(old, "Thanks for use App!");
        // kết thúc ghi file
        System.setOut(old);
        input.close();
    }

    public static void showMenu(PrintStream old) {
        savePrintln(old, "Product list:");
        savePrintln(old, "1. Load data from file and display");
        savePrintln(old, "2. Input & add to the end.");
        savePrintln(old, "3. Display data");
        savePrintln(old, "4. Save product list to file.");
        savePrintln(old, "5. Search by ID");
        savePrintln(old, "6. Delete by ID");
        savePrintln(old, "7. Sort by ID.");
        savePrintln(old, "8. Convert to Binary");
        savePrintln(old, "9. Load to stack and display");
        savePrintln(old, "10. Load to queue and display.");
        savePrintln(old, "0. Exit");
        savePrint(old, "Choose one of this options: ");
    }
}
