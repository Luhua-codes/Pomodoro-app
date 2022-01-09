package src.backend;

import java.io.IOException;
import src.frontend.*;

class Main {
    public static void main(String[] args) throws IOException {
        MainMenu mainMenu = new MainMenu();

    	TimerController.importCycles();
        mainMenu.show();
    }
}