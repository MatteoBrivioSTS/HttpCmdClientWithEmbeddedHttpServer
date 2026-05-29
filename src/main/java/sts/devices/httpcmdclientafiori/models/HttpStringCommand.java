package sts.devices.httpcmdclientafiori.models;

public class HttpStringCommand {
    public String driver;
    public String centrale;
    public String nomeDispositivo;
    public String comando;
    public String stringaHTTP;


    //Constructor
    public HttpStringCommand() {}

    public HttpStringCommand(String driver, String centrale, String nomeDispositivo, String comando, String stringaHTTP) {
        this.driver = driver;
        this.centrale = centrale;
        this.nomeDispositivo = nomeDispositivo;
        this.comando = comando;
        this.stringaHTTP = stringaHTTP;
    }

    //Getter and Setter
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getCentrale() {
        return centrale;
    }

    public void setCentrale(String centrale) {
        this.centrale = centrale;
    }

    public String getNomeDispositivo() {
        return nomeDispositivo;
    }

    public void setNomeDispositivo(String nomeDispositivo) {
        this.nomeDispositivo = nomeDispositivo;
    }

    public String getStringaHTTP() {
        return stringaHTTP;
    }

    public void setStringaHTTP(String stringaHTTP) {
        this.stringaHTTP = stringaHTTP;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }


    //toString()

    @Override
    public String toString() {
        return "HttpStringCommand{" +
                "palazzo='" + driver + '\'' +
                ", lotto='" + centrale + '\'' +
                ", name='" + nomeDispositivo + '\'' +
                ", command='" + comando + '\'' +
                ", httpString='" + stringaHTTP + '\'' +
                '}';
    }
}
