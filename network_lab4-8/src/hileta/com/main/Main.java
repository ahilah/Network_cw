package hileta.com.main;


import hileta.com.Tariff.StartTariff;
import hileta.com.Tariff.SuperTariff;

import java.io.IOException;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, SQLException {
        /**/
        /*MainMenu mainMenu = new MainMenu();
        mainMenu.StartMainMenu();/**/

        /*Add addCommand = new Add(new Network("1", "2", "3"));
        addCommand.execute();*/

        /*FromFile fromFileCommand = new FromFile(new Network("1", "2", "3"));
        fromFileCommand.execute();*/
        // D:\test6.txt tariffs
        // D:\test9.txt archive
        // D:\test8.txt customer
        // D:\test5.txt mobnum
        // D:\test7.txt abroad

        /*List<Integer> lol = new ArrayList<>();
        lol.add(1); lol.add(2);lol.add(3);lol.add(4);lol.add(5);lol.add(6);lol.add(7);lol.add(8);
        for(Integer innnn : lol){
            System.out.println(innnn);
        }
        System.out.println();
        int k = lol.size();

        for (int i = 4,j = 4; j < k; j++) {
            lol.remove(i);
        }

        for(Integer innnn : lol){
            System.out.println(innnn);
        }*/
        //SpectrumParameters spectrumParameters = new SpectrumParameters();
        /* FileTariff file = new FileTariff(Network.getNetwork("1", "2", "3"));
        file.execute();
        SearchTariffs search = new SearchTariffs(Network.getNetwork("1", "2", "3"));
        search.execute(); */
        StartTariff superTariff = new StartTariff("111", 12, 12, 12, "444");
        System.out.println(superTariff.rowTable());
        SuperTariff superTariff1 = new SuperTariff("2222", 1325, 988,
                9999,"88888888", 123,401);
    }
}
