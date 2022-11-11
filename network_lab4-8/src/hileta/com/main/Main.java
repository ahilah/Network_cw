package hileta.com.main;

import hileta.com.menu.management.MainMenu;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        //PropertyConfigurator.configure("D:\\programming\\appliedProgramming\\Network_cw\\Resources\\log4j.properties");
        //PropertyConfigurator.configure("log4j.properties");
        //SendEmail.sendMessage("123");
        DOMConfigurator.configure("D:\\programming\\appliedProgramming\\Network_cw\\Resources\\log4j.xml");
        logger.info("Start program");
        MainMenu mainMenu = new MainMenu();
        mainMenu.StartMainMenu();

        // D:\programming\appliedProgramming\Network_cw\dataFiles\text1.txt
        // D:\programming\appliedProgramming\Network_cw\dataFiles\text2.txt
        // D:\programming\appliedProgramming\Network_cw\dataFiles\text3.txt
        // D:\programming\appliedProgramming\Network_cw\dataFiles\text4.txt
        // D:\programming\appliedProgramming\Network_cw\dataFiles\text5.txt
        // D:\programming\appliedProgramming\Network_cw\dataFiles\text6.txt
    }
}