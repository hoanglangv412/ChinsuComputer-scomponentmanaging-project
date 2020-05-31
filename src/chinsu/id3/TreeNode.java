/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chinsu.id3;

/**
 *
 * @author Windows 10
 */
public class TreeNode {
    public Attribute attributes;
    public TreeNode[] childs;
    public int n;
    public int numberLabel;
    
    public TreeNode(Attribute attributes) {
        this.attributes = attributes;
        this.childs = new TreeNode[attributes.values.size()];
        this.n = 0;
        for(int i = 0; i < attributes.values.size(); i++) {
            childs[i] = null;
        }
        if(attributes.values.isEmpty()) {
            numberLabel = 1;
        } else {
            numberLabel = 0;
        }
    }
    
    public void addNode(TreeNode child) {
        if(n < childs.length) {
            childs[n] = child;
            numberLabel += child.numberLabel;
        }
        n++;
    }

    public Attribute getAttributes() {
        return attributes;
    }

    public void setAttributes(Attribute attributes) {
        this.attributes = attributes;
    }

    public TreeNode[] getChilds() {
        return childs;
    }

    public void setChilds(TreeNode[] childs) {
        this.childs = childs;
    }

    public int getNumberLabel() {
        return numberLabel;
    }

    public void setNumberLabel(int numberLabel) {
        this.numberLabel = numberLabel;
    }
    
}
