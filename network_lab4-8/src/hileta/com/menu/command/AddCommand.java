package hileta.com.menu.command;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

public class AddCommand implements MenuCommand {
    private String COMMAND_INFO = "add new object";
    private Network network;

    public AddCommand(Network network) {
        this.network = network;
    }

    public void execute() {
        System.out.println("add");
        this.network.addAbroad();
        this.network.addCustomer();
        this.network.addNumber();
        (new FromFileCommand(this.network)).execute();
    }

    public String getCommandInfo() {
        return this.COMMAND_INFO;
    }

    /*
    String ss = "input --price --data";
        String delims = "[-.,?!]+";
        String[] s1 = ss.split(delims);
        List<String> s = convertArrayToList(s1);

        for(int i = 0; i < s.size(); ++i) {
            System.out.println((String)s.get(i));
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
 */
}
