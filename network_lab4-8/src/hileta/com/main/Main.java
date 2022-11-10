package hileta.com.main;

import hileta.com.menu.management.MainMenu;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
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