package sts.devices.httpcmdclientafiori.models.panag_src;

import lis.drivers.com.metarec.util.Record;

public class Us_S_Model {
    private String protocol;
    private String device;
    private String name;
    private String descr;
    private int type;
    private int att;
    private int area;
    private int category;

    //Constructor

    public Us_S_Model() {
    }

    public Us_S_Model(String protocol, String device, String name, String descr, int type, int att, int area, int category) {
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
        return "Us_S_Model{" +
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

    public static Record formObjToRecord(Us_S_Model us_s_model)
    {
        Record uss = new Record(8,"PANAG_SRC");
        uss.fieldValues[0] = us_s_model.getProtocol();
        uss.fieldValues[1] = us_s_model.getDevice();
        uss.fieldValues[2] = us_s_model.getName();
        uss.fieldValues[3] = us_s_model.getDescr();
        uss.fieldValues[4] = String.valueOf(us_s_model.getType());
        uss.fieldValues[5] = String.valueOf(us_s_model.getAtt());
        uss.fieldValues[6] = String.valueOf(us_s_model.getArea());
        uss.fieldValues[7] = String.valueOf(us_s_model.getCategory());
        return uss;
    }
}
