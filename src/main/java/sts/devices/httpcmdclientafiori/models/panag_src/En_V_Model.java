package sts.devices.httpcmdclientafiori.models.panag_src;

import lis.drivers.com.metarec.util.Record;

public class En_V_Model {
    private String protocol;
    private String device;
    private String name;
    private String descr;
    private int type;
    private int att;
    private int area;
    private int category;

    //Constructor
    public En_V_Model() {}

    public En_V_Model(String protocol, String device, String name, String descr, int type, int att, int area, int category) {
        this.protocol = protocol;
        this.device = device;
        this.name = name;
        this.descr = descr;
        this.type = type;
        this.att = att;
        this.area = area;
        this.category = category;
    }

    //Getter and Setter

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAtt() {
        return att;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    //toString()

    @Override
    public String toString() {
        return "En_V_Model{" +
                "protocol='" + protocol + '\'' +
                ", device='" + device + '\'' +
                ", name='" + name + '\'' +
                ", descr='" + descr + '\'' +
                ", type=" + type +
                ", att=" + att +
                ", area=" + area +
                ", category=" + category +
                '}';
    }
    public static Record formObjToRecord(En_V_Model en_v_model)
    {
        Record env = new Record(8,"PANAG_SRC");
        env.fieldValues[0] = en_v_model.getProtocol();
        env.fieldValues[1] = en_v_model.getDevice();
        env.fieldValues[2] = en_v_model.getName();
        env.fieldValues[3] = en_v_model.getDescr();
        env.fieldValues[4] = String.valueOf(en_v_model.getType());
        env.fieldValues[5] = String.valueOf(en_v_model.getAtt());
        env.fieldValues[6] = String.valueOf(en_v_model.getArea());
        env.fieldValues[7] = String.valueOf(en_v_model.getCategory());
        return env;
    }
}
