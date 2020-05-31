/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinsu.id3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Windows 10
 */
public class DecisionTreeID3 {

    public List<List<String>> examples;
    public List<Attribute> attributes;
    public TreeNode tree;
    public int depth;
    public String solution;
    public String luat;

    public TreeNode getTree() {
        return tree;
    }

    public void setTree(TreeNode tree) {
        this.tree = tree;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public DecisionTreeID3(List<List<String>> examples, List<Attribute> attributes) {
        this.examples = examples;
        this.attributes = attributes;
        this.tree = null;
        depth = 0;
        luat = "";
    }

    public double getEntropy(int positives, int negatives) {
        if (positives == 0) {
            return 0;
        }
        if (negatives == 0) {
            return 0;
        }
        double entropy;
        int total = negatives + positives;
        double ratePositves = (double) positives / total;
        double rateNegatives = (double) negatives / total;
        entropy = -ratePositves * Caculator.log(ratePositves, 2) - rateNegatives * Caculator.log(rateNegatives, 2);
        return entropy;
    }

    public double gain(List<List<String>> examples, Attribute a, String bestat) {
        double result;
        int countPositives = 0;
        int[] countPositivesA = new int[a.values.size()];
        int[] countNegativeA = new int[a.values.size()];
        int col = this.attributes.indexOf(a);
        for (int i = 0; i < a.values.size(); i++) {
            countPositivesA[i] = 0;
            countNegativeA[i] = 0;
        }
        for (int i = 0; i < examples.size(); i++) {
            int j = a.values.indexOf(examples.get(i).get(col).toString());
            if (examples.get(i).get(examples.get(0).size() - 1).equalsIgnoreCase("yes")) {
                countPositives++;
                countPositivesA[j]++;
            } else {
                countNegativeA[j]++;
            }
        }
        result = getEntropy(countPositives, examples.size() - countPositives);
        for (int i = 0; i < a.values.size(); i++) {
            double rateValue = (double) (countPositivesA[i] + countNegativeA[i]) / examples.size();

            result = result - rateValue * getEntropy(countPositivesA[i], countNegativeA[i]);
        }
        solution += "\n Gain(" + bestat + "," + a.name + ") = " + result;
        return result;
    }

    public TreeNode id3(List<List<String>> examples, List<Attribute> attributes, String bestat) {
        solution += "---------------------------------    Xét " + bestat + "     -------------------------------";
    
        if (checkAllPositive(examples)) {
            solution += "\n Tất cả các mẫu đều khẳng định => Trả về nút gốc với nhãn Yes";
            return new TreeNode(new Attribute("YES"));
        }

        if (checkAllNegative(examples)) {
            solution += "\n Tất cả các mẫu đều phủ định => Trả về nút gốc với nhãn No";
            return new TreeNode(new Attribute("NO"));
        }

        if (attributes.isEmpty()) {
            solution += "\n Các thuộc tính rỗng => Trả về nút gốc có giá trị phổ biến nhất  ";
            return new TreeNode(new Attribute(getMostCommonValue(examples)));
        }

        Attribute bestAttribute = getBestAttribute(examples, attributes, bestat);

        int locationBA = this.attributes.indexOf(bestAttribute);
        TreeNode root = new TreeNode(bestAttribute);

        for (int i = 0; i < bestAttribute.values.size(); i++) {
            List<List<String>> examplesvi = new ArrayList<List<String>>();
            for (int j = 0; j < examples.size(); j++) {
                if (examples.get(j).get(locationBA).equalsIgnoreCase(bestAttribute.values.get(i))) {
                    examplesvi.add(examples.get(j));
                }
            }
//            for(int k = 0; k<examplesvi.size(); k++) {
//                for(int j = 0; j<examplesvi.get(k).size(); j++) {
//                    System.out.print(examplesvi.get(k).get(j) + "\t");
//                }
//                System.out.println("");
//            }
            if (examplesvi.isEmpty()) {
                solution += "\n Các thuộc tính rỗng => Trả về nút gốc có giá trị phổ biến nhất 1";
                return new TreeNode(new Attribute(getMostCommonValue(examplesvi)));
            } else {
                solution += "\n";
                attributes.remove(bestAttribute);
                
                root.addNode(id3(examplesvi, attributes, bestAttribute.values.get(i)));
            }
        }
        
        return root;
    }

    private boolean checkAllPositive(List<List<String>> examples) {
        for (int i = 0; i < examples.size(); i++) {
            if (examples.get(i).get(examples.get(0).size() - 1).equalsIgnoreCase("no")) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAllNegative(List<List<String>> examples) {
        for (int i = 0; i < examples.size(); i++) {
            if (examples.get(i).get(examples.get(0).size() - 1).equalsIgnoreCase("yes")) {
                return false;
            }
        }
        return true;
    }

    private String getMostCommonValue(List<List<String>> examples) {
        int CountPositive = 0;
        for (int i = 0; i < examples.size(); i++) {
            if (examples.get(i).get(examples.get(0).size() - 1).equalsIgnoreCase("yes")) {
                CountPositive++;
            }
        }
        int CountNegative = examples.size() - CountPositive;
        String label;
        if (CountPositive > CountNegative) {
            label = "Yes";
        } else {
            label = "No";
        }
        solution += " là " + label;
        return label;
    }

    private Attribute getBestAttribute(List<List<String>> examples, List<Attribute> attributes, String bestat) {
        double maxGain = gain(examples, attributes.get(0), bestat);
        int max = 0;
        for (int i = 1; i < attributes.size(); i++) {
            double gainCurrent = gain(examples, attributes.get(i), bestat);
            if (maxGain < gainCurrent) {
                maxGain = gainCurrent;
                max = i;
            }
        }
        solution += "\n\t=> Ta chọn đặc tính tốt nhất là : " + attributes.get(max).name;
        return attributes.get(max);
    }

    public int getDepth(TreeNode tree) {
        int depth;
        if (tree.childs.length == 0) {
            return 1;
        } else {
            depth = getDepth(tree.childs[0]);
            for (int i = 1; i < tree.childs.length; i++) {
                int depthchild = getDepth(tree.childs[i]);
                if (depth < depthchild) {
                    depth = depthchild;
                }
            }
            depth++;
        }
        return depth;
    }

    public void takeTree() {
        solution = "";
        List<Attribute> at = new ArrayList<>();
        for (int i = 0; i < attributes.size(); i++) {
            at.add(attributes.get(i));
        }
        tree = id3(examples, at, "S");
        depth = getDepth(tree);

    }

}
