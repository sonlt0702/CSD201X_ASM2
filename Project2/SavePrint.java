package Project2;

import java.io.PrintStream;

/**
 * Tạo ra 2 phương thức print và println vừa in ra console vừa lưu vào file
 */
public class SavePrint {
    public static void savePrint(PrintStream old, String s) {
        old.print(s);
        System.out.print(s);
    }

    public static void savePrintln(PrintStream old, String s) {
        old.println(s);
        System.out.println(s);
    }
}
