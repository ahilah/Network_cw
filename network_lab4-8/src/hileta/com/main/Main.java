package hileta.com.main;


import hileta.com.menu.command.file.FromFile;
import hileta.com.network.Network;

import java.io.IOException;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, SQLException {
        /*MainMenu mainMenu = new MainMenu();
        mainMenu.StartMainMenu();*/
        /*Add addCommand = new Add(new Network("1", "2", "3"));
        addCommand.execute();*/

        FromFile fromFileCommand = new FromFile(new Network("1", "2", "3"));
        fromFileCommand.execute();
        // D:\test6.txt tariffs
        // D:\test9.txt archive
        // D:\test8.txt customer
        // D:\test5.txt mobnum
        // D:\test7.txt abroad
    }
}
