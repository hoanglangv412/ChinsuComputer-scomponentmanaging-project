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
public class Attribute {
    public List<String> values;
    public String name;
    public String label;

    public Attribute() {
        this.name = "";
        this.label = "";
        this.values = new ArrayList<>();
    }
    
    public Attribute(List<String> value, String name) {
        this.values = value;
        this.name = name;
        this.label = "";
    }
    
    public Attribute(String label) {
        this.label = label;
        this.name = "";
        this.values = new ArrayList<>();
    }
    
    public void addValue(String value) {
        if(!this.values.contains(value)) {
            values.add(value);
        }
    }

    public List<String> getValues() {
        for(int i = 0; i<values.size(); i++) {
            System.out.println(values.get(i).toString());
        }
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    
}
