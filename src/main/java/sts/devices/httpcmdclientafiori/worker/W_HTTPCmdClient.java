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

//    U1L1_OPEN_GATE_EN_S53     = "http://127.0.0.1/CommandSender/Command.svc/OpenBarrier/53";
//    U1L1_OPEN_GATE_US_S48     = "http://127.0.0.1/CommandSender/Command.svc/OpenBarrier/48";
//    U1L1_INTERCOMCALL_EN_V53  = "http://127.0.0.1/CommandSender/Command.svc/MakeCall/53";
//    U1L1_INTERCOMCALL_US_V48  = "http://127.0.0.1/CommandSender/Command.svc/MakeCall/48";
//    U1L1_OPEN_GATE_C12        = "http://127.0.0.1/CommandSender/Command.svc/OpenCame/12";
//    U1L1_CLOSE_GATE_C12       = "http://127.0.0.1/CommandSender/Command.svc/ChiudiCame/12";
//    U1L1_OPEN_GATE_C14        = "http://127.0.0.1/CommandSender/Command.svc/OpenCame/14";
//    U1L1_CLOSE_GATE_C14       = "http://127.0.0.1/CommandSender/Command.svc/ChiudiCame/14";

    //CHIAMATE REALI
//    private static final String OPEN_BARRIER              = "http://192.168.99.200/CommandSender/Command.svc/OpenBarrier/";
//    private static final String CALL                      = "http://192.168.99.200/CommandSender/Command.svc/MakeCall/";
//    private static final String OPEN_CAME                 = "http://192.168.99.200/CommandSender/Command.svc/OpenCame/";
//    private static final String CLOSE_CAME                = "http://192.168.99.200/CommandSender/Command.svc/ChiudiCame/";

    // PROVA CRUD CONTROLLOACCESSI
//    private static final String OPEN_BARRIER              = "http://127.0.0.1:9001/getPanAnaguserByID/";
//    private static final String CALL                      = "http://127.0.0.1:9001/getPanAnagsiteByID/";
//    private static final String OPEN_CAME                 = "http://127.0.0.1:9001/getPanAnagprofileByID/";
//    private static final String CLOSE_CAME                = "http://127.0.0.1:9001/getPanBoundariesByID/";

    private static final String OPEN_BARRIER              = "http://127.0.0.1:9001/CommandSender/Command.svc/";
    private static final String CALL                      = "http://127.0.0.1:9001/CommandSender/Command.svc/";
    private static final String OPEN_CAME                 = "http://127.0.0.1:9001/CommandSender/Command.svc/";
    private static final String CLOSE_CAME                = "http://127.0.0.1:9001/CommandSender/Command.svc/";

//    public static final String OPEN_BARRIER_VALUE           = "110";
//    public static final String CALL_VALUE                   = "111";
//    public static final String OPEN_CAME_VALUE              = "112";
//    public static final String CLOSE_CAME_VALUE             = "113";
    public static final String EMPTYSTRING_VALUE            = "";

    public static final String COMMAND_110 = "110";
    public static final String COMMAND_111 = "111";
    public static final String COMMAND_112 = "112";
    public static final String COMMAND_113 = "113";

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

    public void command110request(String url, int name) throws IOException, InterruptedException {
                HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .uri(URI.create(url+name))
                .header("Content-type", "application/json")
                .timeout(Duration.ofSeconds(5))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("request "+ request);
        System.out.println("Response: " + response.body());
    }
    public void command111request(String url, int name) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .uri(URI.create(url+name))
                .header("Content-type", "application/json")
                .timeout(Duration.ofSeconds(5))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response: " + response.body());
    }
    public void command112request(String url, int name) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .uri(URI.create(url+name))
                .header("Content-type", "application/json")
                .timeout(Duration.ofSeconds(5))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response: " + response.body());
    }
    public void command113request(String url, int name) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .uri(URI.create(url+name))
                .header("Content-type", "application/json")
                .timeout(Duration.ofSeconds(5))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response: " + response.body());
    }

//3 chiamate apri varco, chiamata, 110 in poi
//    public void openBarrierHTTPRequest(int barrier) throws IOException, InterruptedException {
//        HttpRequest request = HttpRequest.newBuilder()
//                .version(HttpClient.Version.HTTP_1_1)
//                .uri(URI.create(OPEN_BARRIER +OPEN_BARRIER_VALUE+"/"+ barrier))
//                .header("Content-type", "application/json")
//                .timeout(Duration.ofSeconds(5))
//                .GET()
//                .build();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println("Response: " + response.body());
//    }
//
//    public void intercomCallHTTPRequest(int intercom) throws IOException, InterruptedException {
//        HttpRequest request = HttpRequest.newBuilder()
//                .version(HttpClient.Version.HTTP_1_1)
//                .uri(URI.create(CALL+CALL_VALUE+"/"+intercom))
//                .header("Content-type", "application/json")
//                .timeout(Duration.ofSeconds(5))
//                .GET()
//                .build();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println("Response: " + response.body());
//    }
//
//    public void openCameHTTPRequest(int came) throws IOException, InterruptedException {
//        HttpRequest request = HttpRequest.newBuilder()
//                .version(HttpClient.Version.HTTP_1_1)
//                .uri(URI.create(OPEN_CAME+OPEN_CAME_VALUE+"/"+came))
//                .header("Content-type", "application/json")
//                .timeout(Duration.ofSeconds(5))
//                .GET()
//                .build();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println("Response: " + response.body());
//    }
//
//    public void closeCameHTTPRequest(int came) throws IOException, InterruptedException {
//        HttpRequest request = HttpRequest.newBuilder()
//                .version(HttpClient.Version.HTTP_1_1)
//                .uri(URI.create(CLOSE_CAME+CLOSE_CAME_VALUE+"/"+came))
//                .header("Content-type", "application/json")
//                .timeout(Duration.ofSeconds(5))
//                .GET()
//                .build();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println("Response: " + response.body());
//    }


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
