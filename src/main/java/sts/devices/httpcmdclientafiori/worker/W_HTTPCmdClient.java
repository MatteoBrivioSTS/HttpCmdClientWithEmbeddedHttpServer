package sts.devices.httpcmdclientafiori.worker;

import lis.drivers.com.metarec.util.Record;
import lis.drivers.comm.conn.core.CoreChannel;
import lis.drivers.comm.conn.core.RCXChannel;
import lis.drivers.comm.conn.ext.ExtHTTPChannel;
import lis.drivers.model.rcx.RCXDevice;
import lis.drivers.worker.HTTP_Worker;
import lis.drivers.worker.helper.KeepAlive;
import lis.drivers.worker.helper.Tuple;
import lis.drivers.worker.helper.WorkerStatus;
import sts.devices.httpcmdclientafiori.models.Command;
import sts.devices.httpcmdclientafiori.models.Fullev;
import sts.devices.httpcmdclientafiori.models.HttpStringCommand;
import sts.devices.httpcmdclientafiori.models.Pntdef;
import sts.devices.httpcmdclientafiori.worker.status.W_HTTPCmdClient_DISCON;
import sts.devices.httpcmdclientafiori.worker.status.W_HTTPCmdClient_INIT;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.time.Duration;
import java.time.LocalDateTime;
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
    public static final int EN_V_VALUE = 150;
    public static final int US_S_VALUE = 150;
    public static final int US_V_VALUE = 150;
    public static final int C_VALUE = 150;
    public static final int S20_ = 150;

    public static final String EMPTYSTRING_VALUE = "";

    public static final String COMMAND_110 = "110";
    public static final String COMMAND_111 = "111";
    public static final String COMMAND_112 = "112";
    public static final String COMMAND_113 = "113";
    public static final String COMMAND_114 = "114";
    public static final String COMMAND_115 = "115";
    public static final String COMMAND_116 = "116";
    public static final String COMMAND_RESET = "6";

    public static final String EN_S4ZERO =  "En_S%04d";
    public static final String US_S4ZERO =  "Us_S%04d";
    public static final String EN_V4ZERO =  "En_V%04d";
    public static final String US_V4ZERO =  "Us_V%04d";
    public static final String C4ZERO =     "C%04d";
    public static final String S20_4ZERO =    "S20_%04d";

    private static final String LOGS_PATH = "C:/Bin/PSM/LOGS/HTTPCMDCLIENT/";

    private Hashtable<String,Pntdef> pntdefs = new Hashtable<>();
    private ArrayList<Tuple<Integer,Command>> cmds = new ArrayList<>();
    private Hashtable<String, HttpStringCommand> httpStingCommands = new Hashtable<>();
    private Hashtable<String, Fullev> fullevs = new Hashtable<>();

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
            }catch (Exception e) {
                System.err.println("Errore generico nel worker: " + e.getMessage());
                goToDisconn(e);
                writeLog(LOGS_PATH, e);
            }

        }
    }

    public void command110request(String url) throws Exception {
                HttpRequest request = HttpRequest.newBuilder()
                        .version(HttpClient.Version.HTTP_1_1)
                        .uri(URI.create(url))
                        .header("Content-type", "application/json")
                        .timeout(Duration.ofSeconds(10))
                        .GET()
                        .build();
                System.out.println("request " + request);
                HttpResponse<String> response =
                        client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println("Response: " + response.body()+ "status code" + response.statusCode());
    }
    public void command111request(String url) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .uri(URI.create(url))
                .header("Content-type", "application/json")
                .timeout(Duration.ofSeconds(10))
                .GET()
                .build();
        System.out.println("request " + request);
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response: " + response.body()+ "status code" + response.statusCode());
    }
    public void command112request(String url) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .uri(URI.create(url))
                .header("Content-type", "application/json")
                .timeout(Duration.ofSeconds(10))
                .GET()
                .build();
        System.out.println("request " + request);
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response: " + response.body()+ "status code" + response.statusCode());
    }
    public void command113request(String url) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .uri(URI.create(url))
                .header("Content-type", "application/json")
                .timeout(Duration.ofSeconds(10))
                .GET()
                .build();
        System.out.println("request " + request);
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response: " + response.body()+ "status code" + response.statusCode());
    }
    public void command114request(String url) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .uri(URI.create(url))
                .header("Content-type", "application/json")
                .timeout(Duration.ofSeconds(10))
                .GET()
                .build();
        System.out.println("request " + request);
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response: " + response.body()+ "status code" + response.statusCode());
    }
    public void command115request(String url) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .uri(URI.create(url))
                .header("Content-type", "application/json")
                .timeout(Duration.ofSeconds(10))
                .GET()
                .build();
        System.out.println("request " + request);
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response: " + response.body()+ "status code" + response.statusCode());
    }
    public void command116request(String url) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .uri(URI.create(url))
                .header("Content-type", "application/json")
                .timeout(Duration.ofSeconds(10))
                .GET()
                .build();
        System.out.println("request " + request);
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response: " + response.body()+ "status code" + response.statusCode());
    }



    @Override
    public boolean writeLog(String path, Exception ex) {

        System.out.println(ex.getMessage());
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String sStackTrace = sw.toString();

        LocalDateTime now =  LocalDateTime.now();
        File obj = new File(path + this.getName() + "_" + String.format("%04d%02d%02d%02d%02d%02d"
                ,now.getYear(), now.getMonthValue(), now.getDayOfMonth(), now.getHour(), now.getMinute(), now.getSecond())  + ".txt");
        try
        {
            if(obj.createNewFile())
            {
                FileWriter writer = new FileWriter(obj);
                writer.write(sStackTrace);
                writer.close();
                System.out.println("File created: " + obj.getName());
                return true;
            }
            else
            {
                System.out.println("File already exists.");
                return false;
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //sendLogs
    public void sendLogs(int lvl, String line) throws Exception {
        rcxChannel = (RCXChannel) getCoreChannel();
        Record rec = new Record(4, "META#LOGT2");
        rec.fieldValues[0] = Integer.toString(lvl);
        rec.fieldValues[1] = rcxChannel.getProto();
        rec.fieldValues[2] = getName();
        rec.fieldValues[3] = line;
        rcxChannel.sendRecord(rec);
    }
    //
    public void goToDisconn(Exception e)
    {
        e.printStackTrace();
        this.writeLog(LOGS_PATH, e);
        this.getWs().setStatus(new W_HTTPCmdClient_DISCON());
        rcxChannel = (RCXChannel) this.getCoreChannel();
        rcxDevice = rcxChannel.getDevices().get(this.getName());
        rcxDevice.devicstatus &= ~RCXDevice.STAT_UPLD;
        rcxDevice.devicstatus |= RCXDevice.STAT_DISC;
        Record rec = rcxDevice.DescribeDevice();
        try {
            rcxChannel.sendRecord(rec);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            this.writeLog(LOGS_PATH, ex);
        }
    }
    //Getter and Setter

    public Hashtable<String, Fullev> getFullevs() {
        return fullevs;
    }

    public void setFullevs(Hashtable<String, Fullev> fullevs) {
        this.fullevs = fullevs;
    }

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
