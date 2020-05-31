/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chinsu.gui_controller;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Windows 10
 */
public class CategoryObject {

    
    private String kind;
    private JPanel jpn;
    private JLabel jlb;

    public CategoryObject() {
    }

    public CategoryObject(String kind, JPanel jpn, JLabel jlb) {
        this.kind = kind;
        this.jpn = jpn;
        this.jlb = jlb;
    }
    
    public String getKind() {
        return kind;
    }

    public void setItem(String kind) {
        this.kind = kind;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }

    public JLabel getJlb() {
        return jlb;
    }

    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }
    
    public void text1() {
        this.jlb.setForeground(new Color(254, 255, 254));
    }
    
    public void text2() {
        this.jlb.setForeground(new Color(81, 95, 108));
    }
    
}
