package gui;

import pwlogic.PassWordMaker;
import pwlogic.PassWordMaker;

public class Main {
private PassWordMaker pwMaker = new PassWordMaker();
    public static void main(String[] args) {
        Main inst = new Main();
        String output = inst.pwMaker.allCharactersPW(24);
        System.out.println(output);
    }

}
