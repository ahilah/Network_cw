package hileta.com.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, SQLException {
        String ss = "input --price --data";
        String delims = "[-.,?!]+";
        String[] s1 = ss.split(delims);
        List<String> s = convertArrayToList(s1);

        for(int i = 0; i < s.size(); ++i) {
            System.out.println((String)s.get(i));
        }

    }

    public static <T> List<T> convertArrayToList(T[] array) {
        List<T> list = new ArrayList();
        Object[] var1 = array;
        int var2 = array.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            T t = (T) var1[var3];
            list.add(t);
        }

        return list;
    }
}
