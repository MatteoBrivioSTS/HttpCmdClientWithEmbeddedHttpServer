package sts.devices.httpcmdclientafiori.models;

public class Pntdef {
    public String protocol;
    public String device;
    public String name;
    public String group;
    public String description;
    public String procedure;
    public String mapRef;
    public String camera;

    //Constructor
    public Pntdef() {}

    public Pntdef(String protocol, String device, String name, String group, String description,
                  String procedure, String mapRef, String camera) {
        this.protocol = protocol;
        this.device = device;
        this.name = name;
        this.group = group;
        this.description = description;
        this.procedure = procedure;
        this.mapRef = mapRef;
        this.camera = camera;
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

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getMapRef() {
        return mapRef;
    }

    public void setMapRef(String mapRef) {
        this.mapRef = mapRef;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    //toString()
    @Override
    public String toString() {
        return "PNTDEF{" +
                "protocol='" + protocol + '\'' +
                ", device='" + device + '\'' +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", description='" + description + '\'' +
                ", procedure='" + procedure + '\'' +
                ", mapRef='" + mapRef + '\'' +
                ", camera='" + camera + '\'' +
                '}';
    }
}
