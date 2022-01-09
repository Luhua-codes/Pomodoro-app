package src.backend;

import java.io.IOException;
import src.frontend.*;

class Main {
    public static void main(String[] args) throws IOException {
    	TimerController.importCycles();
        MainMenu.show();
    }
}