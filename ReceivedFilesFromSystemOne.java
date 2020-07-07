import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class ReceivedFilesFromSystemOne {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        System.out.println(args[1]);
        readFile(args[1]);
    }

    public static void readFile(String readFile){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(readFile)));
            String ln;
            while ((ln = br.readLine()) !=null) {
                try {
                    String[] cols = ln.split("\t");
                    for (String col : cols) {
                        System.out.println(col);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("NG[" + ln + "]");
                }
            }
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}