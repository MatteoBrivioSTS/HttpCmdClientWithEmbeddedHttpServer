package sts.devices.httpcmdclientafiori.models;

public class Command {
    public String protocol;
    public String device;
    public String name;
    public String command;
    public String extraData;

    //Constructor
    public Command() {}

    public Command(String protocol, String device, String name, String command, String extraData) {
        this.protocol = protocol;
        this.device = device;
        this.name = name;
        this.command = command;
        this.extraData = extraData;
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

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getExtraData() {
        return extraData;
    }

    public void setExtraData(String extraData) {
        this.extraData = extraData;
    }

    //toString()
    @Override
    public String toString() {
        return "Command{" +
                "protocol='" + protocol + '\'' +
                ", device='" + device + '\'' +
                ", name='" + name + '\'' +
                ", command='" + command + '\'' +
                ", extraData='" + extraData + '\'' +
                '}';
    }
}
