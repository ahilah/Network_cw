package hileta.com.main;


import hileta.com.menu.management.MainMenu;

import java.io.IOException;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, SQLException {
        /**/
        MainMenu mainMenu = new MainMenu();
        mainMenu.StartMainMenu();/**/

        // D:\test1.txt tariffs
        // D:\test9.txt archive
        // D:\test8.txt customer
        // D:\test5.txt mobnum
        // D:\test7.txt abroad




    }

        /*
         //SpectrumParameters spectrumParameters = new SpectrumParameters();

        FileTariff file = new FileTariff(Network.getNetwork("1", "2", "3"));
        file.execute();
        SearchTariffs search = new SearchTariffs(Network.getNetwork("1", "2", "3"));
        search.execute(); */
}
