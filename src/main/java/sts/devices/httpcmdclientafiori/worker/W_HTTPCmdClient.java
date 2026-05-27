package sts.devices.httpcmdclientafiori.worker;

import lis.drivers.comm.conn.core.CoreChannel;
import lis.drivers.comm.conn.core.RCXChannel;
import lis.drivers.model.rcx.RCXDevice;
import lis.drivers.worker.HTTP_Worker;
import lis.drivers.worker.helper.KeepAlive;
import lis.drivers.worker.helper.Tuple;
import lis.drivers.worker.helper.WorkerStatus;
import sts.devices.httpcmdclientafiori.models.Command;
import sts.devices.httpcmdclientafiori.models.HttpStringCommand;
import sts.devices.httpcmdclientafiori.models.Pntdef;
import sts.devices.httpcmdclientafiori.worker.status.W_HTTPCmdClient_INIT;
import sts.devices.httpcmdclientafiori.worker.status.W_HTTPCmdClient_NORMAL;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Hashtable;

public class W_HTTPCmdClient extends HTTP_Worker {
    private RCXChannel rcxChannel;
    private RCXDevice rcxDevice;
    private WorkerStatus ws;

    //Client
    private String clientName;
    private HttpClient client;
    private String url;

    public static final int EN_S_VALUE = 150;
    public static final int US_S_VALUE = 150;
    public static final int US_V_VALUE = 150;
    public static final int CAM_VALUE = 150;


    public static final String EMPTYSTRING_VALUE            = "";

    public static final String COMMAND_110 = "110";
    public static final String COMMAND_111 = "111";
    public static final String COMMAND_112 = "112";
    public static final String COMMAND_113 = "113";
    public static final String COMMAND_114 = "114";
    public static final String COMMAND_115 = "115";
    public static final String COMMAND_116 = "116";

    public static final String PALAZZO_U1 = "U1";
    public static final String LIVELLO_L0 = "L0";

    public static final String EN_S =  "En_S";
    public static final String US_S =  "Us_S";
    public static final String EN_V =  "En_V";
    public static final String US_V =  "Us_V";
    public static final String C =     "C";


    private Hashtable<String,Pntdef> pntdefs = new Hashtable<>();
    private ArrayList<Tuple<Integer,Command>> cmds = new ArrayList<>();
    private Hashtable<String, HttpStringCommand> httpStingCommands = new Hashtable<>();

    private int alignTable = 0;
    //Constructor
    public W_HTTPCmdClient(String name, String address, int port, CoreChannel corech) {
        super(name, address, port, corech);
        this.ws = new WorkerStatus(new W_HTTPCmdClient_INIT(),this);
        this.client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(60))
                .build();
    }

    public W_HTTPCmdClient(String address, int port, CoreChannel corech) {
        super(address, port, corech);
        this.ws = new WorkerStatus(new W_HTTPCmdClient_INIT(),this);

    }

    @Override
    public void run() {
        rcxChannel = (RCXChannel) getCoreChannel();
        rcxDevice = rcxChannel.getDevices().get(getName());
        KeepAlive commAlive = new KeepAlive(rcxChannel,rcxDevice);
        Thread t = new Thread(commAlive);
        t.start();
        while (true) {
            try {
                getWs().getStatus().business(getWs());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void command110request(String url) throws IOException, InterruptedException {
                HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .uri(URI.create(url))
                .header("Content-type", "application/json")
                .timeout(Duration.ofSeconds(5))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("request "+ request);
        System.out.println("Response: " + response.body());
    }

//    public void openBarrierHTTPRequest(int barrier) throws IOException, InterruptedException {
////        HttpRequest request = HttpRequest.newBuilder()
////                .version(HttpClient.Version.HTTP_1_1)
////                .uri(URI.create(OPEN_BARRIER +OPEN_BARRIER_VALUE+"/"+ barrier))
////                .header("Content-type", "application/json")
////                .timeout(Duration.ofSeconds(5))
////                .GET()
////                .build();
////        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
////        System.out.println("Response: " + response.body());
////    }
    public void command111request(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .uri(URI.create(url))
                .header("Content-type", "application/json")
                .timeout(Duration.ofSeconds(5))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response: " + response.body());
    }
    public void command112request(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .uri(URI.create(url))
                .header("Content-type", "application/json")
                .timeout(Duration.ofSeconds(5))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response: " + response.body());
    }
    public void command113request(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .uri(URI.create(url))
                .header("Content-type", "application/json")
                .timeout(Duration.ofSeconds(5))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response: " + response.body());
    }

    //Getter and Setter
    public RCXChannel getRcxChannel() {
        return rcxChannel;
    }

    public void setRcxChannel(RCXChannel rcxChannel) {
        this.rcxChannel = rcxChannel;
    }

    public RCXDevice getRcxDevice() {
        return rcxDevice;
    }

    public void setRcxDevice(RCXDevice rcxDevice) {
        this.rcxDevice = rcxDevice;
    }

    public WorkerStatus getWs() {
        return ws;
    }

    public void setWs(WorkerStatus ws) {
        this.ws = ws;
    }

    public Hashtable<String, Pntdef> getPntdefs() {
        return pntdefs;
    }

    public void setPntdefs(Hashtable<String, Pntdef> pntdefs) {
        this.pntdefs = pntdefs;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HttpClient getClient() {
        return client;
    }

    public void setClient(HttpClient client) {
        this.client = client;
    }

    public ArrayList<Tuple<Integer, Command>> getCmds() {
        return cmds;
    }

    public void setCmds(ArrayList<Tuple<Integer, Command>> cmds) {
        this.cmds = cmds;
    }

    public int getAlignTable() {
        return alignTable;
    }

    public void setAlignTable(int alignTable) {
        this.alignTable = alignTable;
    }

    public Hashtable<String, HttpStringCommand> getHttpStingCommands() {
        return httpStingCommands;
    }

    public void setHttpStingCommands(Hashtable<String, HttpStringCommand> httpStingCommands) {
        this.httpStingCommands = httpStingCommands;
    }
}
