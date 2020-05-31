/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinsu.gui_controller;

import chinsu.gui1.ClientChatJpanel;
import chinsu.gui1.DistributorPanel;
import chinsu.gui1.EquipmentJpanel;
import chinsu.gui1.ExportJpanel;
import chinsu.gui1.HomePageJpanel;
import chinsu.gui1.ID3Jpanel;
import chinsu.gui1.StatisticJpanel;
import chinsu.gui1.TypeJpanel;
import chinsu.gui1.UserJpanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Windows 10
 */
public class ScreenController {

    private JPanel jpnRoot;
    private String typeSelected = "";

    private List<CategoryObject> listItem = null;

    public ScreenController(JPanel jpnRoot) {
        this.jpnRoot = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        typeSelected = "HomePage";
        jpnItem.setBackground(new Color(61, 75, 88));
        jlbItem.setBackground(new Color(61, 75, 88));
        jlbItem.setForeground(new Color(254, 255, 254));
        jpnRoot.removeAll();
        jpnRoot.setLayout(new BorderLayout());
        jpnRoot.add(new HomePageJpanel());
        jpnRoot.validate();
        jpnRoot.repaint();
    }

    public void setEvent(List<CategoryObject> listItem) {
        this.listItem = listItem;
        for (CategoryObject item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String type;

        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String type, JPanel jpnItem, JLabel jlbItem) {
            this.type = type;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        public LabelEvent() {
        }

        public JPanel getNode() {
            return node;
        }

        public void setNode(JPanel node) {
            this.node = node;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public JPanel getJpnItem() {
            return jpnItem;
        }

        public void setJpnItem(JPanel jpnItem) {
            this.jpnItem = jpnItem;
        }

        public JLabel getJlbItem() {
            return jlbItem;
        }

        public void setJlbItem(JLabel jlbItem) {
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (type) {
                case "HomePage":
                    node = new HomePageJpanel();
                    break;
                case "User":
                    node = new UserJpanel();
                    break;
                case "Equipment":
                    node = new EquipmentJpanel();
                    break;
                case "Type":
                    node = new TypeJpanel();
                    break;
                case "Distributor":
                    node = new DistributorPanel();
                    break;
                case "Statistic":
                    node = new StatisticJpanel();
                    break;
                case "Export":
                    node = new ExportJpanel();
                    break;
                case "ClientChat":
                    node = new ClientChatJpanel();
                    break;
                case "ID3":
                    node = new ID3Jpanel();
                    break;
                default:
                    break;
            }

            jpnRoot.removeAll();
            jpnRoot.setLayout(new BorderLayout());
            jpnRoot.add(node);
            jpnRoot.validate();
            jpnRoot.repaint();
            setChangeBackgroud(type);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            typeSelected = type;
            jpnItem.setBackground(new Color(61, 75, 88));
            jlbItem.setBackground(new Color(61, 75, 88));
            jlbItem.setForeground(new Color(254, 255, 254));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            jpnItem.setBackground(new Color(61, 75, 88));
            jlbItem.setBackground(new Color(61, 75, 88));
            jlbItem.setForeground(new Color(254, 255, 254));
        }

        @Override
        public void mouseEntered(MouseEvent e) {

            jpnItem.setBackground(new Color(61, 75, 88));
            jlbItem.setBackground(new Color(61, 75, 88));
            jlbItem.setForeground(new Color(254, 255, 254));

        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!typeSelected.equalsIgnoreCase(type)) {

                jpnItem.setBackground(new Color(30, 40, 51));
                jlbItem.setBackground(new Color(30, 40, 51));
                jlbItem.setForeground(new Color(81, 95, 108));
            }
        }

    }

    private void setChangeBackgroud(String kind) {
        for (CategoryObject item : listItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(61, 75, 88));
                item.getJlb().setBackground(new Color(61, 75, 88));
                item.text1();
            } else {
                item.getJpn().setBackground(new Color(30, 40, 51));
                item.getJlb().setBackground(new Color(30, 40, 51));
                item.text2();
            }
        }
    }

}
