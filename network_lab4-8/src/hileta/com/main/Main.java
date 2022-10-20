package hileta.com.main;


import hileta.com.network.Abroad;

import java.io.IOException;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, SQLException {
        /**/
        /*MainMenu mainMenu = new MainMenu();
        mainMenu.StartMainMenu();/**/

        // D:\test6.txt tariffs
        // D:\test9.txt archive
        // D:\test8.txt customer
        // D:\test5.txt mobnum
        // D:\test7.txt abroad

        //SpectrumParameters spectrumParameters = new SpectrumParameters();
        /* FileTariff file = new FileTariff(Network.getNetwork("1", "2", "3"));
        file.execute();
        SearchTariffs search = new SearchTariffs(Network.getNetwork("1", "2", "3"));
        search.execute(); */
        Abroad abroad = new Abroad("aaaaaaaaaa", 11);
        System.out.println(abroad.rowTable());

    }
}
