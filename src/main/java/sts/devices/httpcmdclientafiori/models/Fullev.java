package sts.devices.httpcmdclientafiori.models;

public class Fullev {
    private String protocol;
    private String device;
    private String name;
    private String tag;
    private String timeStamp;
    private String event;
    private String levAll;
    private String elemenType;
    private String group;
    private String description;
    private String r;
    private String g;
    private String b;
    private String mapRef;
    private String procedure;
    private String category;
    private String camera;
    private String sybSystem;

    //Consturctor
    public Fullev() {}

    public Fullev(String protocol, String device, String name, String tag, String timeStamp, String event,
                  String levAll, String elemenType, String group, String description, String r, String g, String b,
                  String mapRef, String procedure, String category, String camera, String sybSystem) {
        this.protocol = protocol;
        this.device = device;
        this.name = name;
        this.tag = tag;
        this.timeStamp = timeStamp;
        this.event = event;
        this.levAll = levAll;
        this.elemenType = elemenType;
        this.group = group;
        this.description = description;
        this.r = r;
        this.g = g;
        this.b = b;
        this.mapRef = mapRef;
        this.procedure = procedure;
        this.category = category;
        this.camera = camera;
        this.sybSystem = sybSystem;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getLevAll() {
        return levAll;
    }

    public void setLevAll(String levAll) {
        this.levAll = levAll;
    }

    public String getElemenType() {
        return elemenType;
    }

    public void setElemenType(String elemenType) {
        this.elemenType = elemenType;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getMapRef() {
        return mapRef;
    }

    public void setMapRef(String mapRef) {
        this.mapRef = mapRef;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getSybSystem() {
        return sybSystem;
    }

    public void setSybSystem(String sybSystem) {
        this.sybSystem = sybSystem;
    }

    //toString()

    @Override
    public String toString() {
        return "Error{" +
                "protocol='" + protocol + '\'' +
                ", device='" + device + '\'' +
                ", name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", event='" + event + '\'' +
                ", levAll='" + levAll + '\'' +
                ", elemenType='" + elemenType + '\'' +
                ", group='" + group + '\'' +
                ", description='" + description + '\'' +
                ", r='" + r + '\'' +
                ", g='" + g + '\'' +
                ", b='" + b + '\'' +
                ", mapRef='" + mapRef + '\'' +
                ", procedure='" + procedure + '\'' +
                ", category='" + category + '\'' +
                ", camera='" + camera + '\'' +
                ", sybSystem='" + sybSystem + '\'' +
                '}';
    }
}
