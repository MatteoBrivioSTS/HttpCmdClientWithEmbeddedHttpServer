package sts.devices.httpcmdclientafiori.models;

public class HttpStringCommand {
    public String palazzo;
    public String lotto;
    public String name;
    public String command;
    public String httpString;


    //Constructor
    public HttpStringCommand() {}

    public HttpStringCommand(String palazzo, String lotto, String name, String command, String httpString) {
        this.palazzo = palazzo;
        this.lotto = lotto;
        this.name = name;
        this.command = command;
        this.httpString = httpString;
    }

    //Getter and Setter
    public String getPalazzo() {
        return palazzo;
    }

    public void setPalazzo(String palazzo) {
        this.palazzo = palazzo;
    }

    public String getLotto() {
        return lotto;
    }

    public void setLotto(String lotto) {
        this.lotto = lotto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHttpString() {
        return httpString;
    }

    public void setHttpString(String httpString) {
        this.httpString = httpString;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }


    //toString()

    @Override
    public String toString() {
        return "HttpStringCommand{" +
                "palazzo='" + palazzo + '\'' +
                ", lotto='" + lotto + '\'' +
                ", name='" + name + '\'' +
                ", command='" + command + '\'' +
                ", httpString='" + httpString + '\'' +
                '}';
    }
}
