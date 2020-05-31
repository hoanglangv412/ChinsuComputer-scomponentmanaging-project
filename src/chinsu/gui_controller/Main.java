package chinsu.gui_controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import chinsu.gui1.MainFrame;

/**
 *
 * @author Windows 10
 */
public class Main {

    public static void runMain(int userId, String username, int per) {
        new MainFrame(userId, username, per).setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame(1,"Admin", 0).setVisible(true);
    }
}
