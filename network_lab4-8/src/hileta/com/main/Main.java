package hileta.com.main;


import hileta.com.menu.management.MainMenu;

import java.io.IOException;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, SQLException {
        MainMenu mainMenu = new MainMenu();
        mainMenu.StartMainMenu();
        //AddCommand addCommand = new AddCommand(new Network("1", "2", "3"));
        //addCommand.execute();
    }
}
