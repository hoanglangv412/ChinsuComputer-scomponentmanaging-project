/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinsu.object.type;

/**
 *
 * @author kieun
 */
public class TypeObject {
    private int type_id;
    private String type_name;
    private int type_distributor_id;

    public TypeObject() {
    }

    public TypeObject(int type_id, String type_name, int distributor_id) {
        this.type_id = type_id;
        this.type_name = type_name;
        this.type_distributor_id = distributor_id;
    }

    public int getType_id() {
        return type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public int getType_distributor_id() {
        return type_distributor_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public void setType_distributor_id(int distributor_id) {
        this.type_distributor_id = distributor_id;
    }

    
}
