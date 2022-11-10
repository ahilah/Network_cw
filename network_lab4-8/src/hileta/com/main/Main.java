package hileta.com.main;

import hileta.com.menu.management.MainMenu;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {
    //private static final Logger logger = LogManager.getLogger(Main.class);
/*static Logger LOGGER;
    static {
        try(FileInputStream ins = new FileInputStream("D:\\programming\\appliedProgramming\\Network_cw\\logs.log")){ //полный путь до файла с конфигами
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Main.class.getName());
        } catch (Exception ignore){
            ignore.printStackTrace();
        }
    }*/
    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        //PropertyConfigurator.configure("D:\\programming\\appliedProgramming\\Network_cw\\Resources\\log4j.properties");
        //PropertyConfigurator.configure("log4j.properties");
        DOMConfigurator.configure("D:\\programming\\appliedProgramming\\Network_cw\\Resources\\log4j.xml");
        logger.info("Start program");
        MainMenu mainMenu = new MainMenu();
        mainMenu.StartMainMenu();

        // D:\test1.txt
        // D:\test2.txt
        // D:\test3.txt
        // D:\test4.txt
        // D:\test5.txt
    }
}

 /*
         //SpectrumParameters spectrumParameters = new SpectrumParameters();

        FileTariff file = new FileTariff(Network.getNetwork("1", "2", "3"));
        file.execute();
        SearchTariffs search = new SearchTariffs(Network.getNetwork("1", "2", "3"));
        search.execute(); // D:\test9.txt archive
        // D:\test8.txt customer
        // D:\test5.txt mobnum
        // D:\test7.txt abroad*/