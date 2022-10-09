package hileta.com.main;

import hileta.com.menu.command.add.AddTariffCommand;

import java.io.IOException;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, SQLException {
        //MainMenu mainMenu = new MainMenu();
        //mainMenu.StartMainMenu();
        AddTariffCommand x1 = new AddTariffCommand();
        x1.execute();
    }
}
