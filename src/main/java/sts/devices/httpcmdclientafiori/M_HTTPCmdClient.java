package sts.devices.httpcmdclientafiori;

import lis.drivers.comm.conn.core.RCXChannel;
import lis.drivers.model.rcx.RCXDevice;
import lis.drivers.model.rcx.RCXModelChannel;
import lis.drivers.model.rcx.Subscription;
import sts.devices.httpcmdclientafiori.embeddedhttpserver.TestServer.server.HTTP_Server;
import sts.devices.httpcmdclientafiori.tblhander.TH_HTTPCmdClient;
import sts.devices.httpcmdclientafiori.worker.W_HTTPCmdClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

public class M_HTTPCmdClient {
    public RCXChannel rcx = null;
    public ArrayList<Subscription> subs = new ArrayList<>();
    public RCXModelChannel rcxModelChannel = null;
    public String fileName = "HTTPCmdClient_AFiori/HTTPCmdClient_AFiori.json";
    public TH_HTTPCmdClient th_httpCmdClient = null;
    public HTTP_Server httpServer = null;

    static void main(String[] args){
        M_HTTPCmdClient m_httpCmdClient = new M_HTTPCmdClient();
        try{

            m_httpCmdClient.rcxModelChannel = RCXModelChannel.Build(m_httpCmdClient.fileName);
            m_httpCmdClient.rcx = new RCXChannel(m_httpCmdClient.rcxModelChannel.getProtocol(),
                                    m_httpCmdClient.rcxModelChannel.getAddress(),m_httpCmdClient.rcxModelChannel.getPort());
            m_httpCmdClient.th_httpCmdClient = new TH_HTTPCmdClient(m_httpCmdClient.rcx);
            m_httpCmdClient.rcx.connect();

            while (true){
                if(m_httpCmdClient.rcx.isConf())
                {
                    for (Enumeration en = m_httpCmdClient.rcx.getDevices().elements(); en.hasMoreElements();)
                    {
                        RCXDevice dev= (RCXDevice) en.nextElement();
                        W_HTTPCmdClient worker = new W_HTTPCmdClient(dev.getName(),dev.getAddress(),dev.getPort(),
                                m_httpCmdClient.rcx);
                        m_httpCmdClient.rcx.getWorkers().put(worker.getName(),worker);
                    }
                    break;
                }
                Thread.sleep(10);
            }

            m_httpCmdClient.rcx.setHandler(m_httpCmdClient.th_httpCmdClient);
            m_httpCmdClient.rcx.setSubs(m_httpCmdClient.rcxModelChannel.getSubscription());
            m_httpCmdClient.rcx.setDevs(true);
            m_httpCmdClient.httpServer = new HTTP_Server(9001);

            for(Enumeration en = m_httpCmdClient.rcx.getWorkers().elements(); en.hasMoreElements();)
            {
                W_HTTPCmdClient worker = (W_HTTPCmdClient) en.nextElement();
                System.out.println(worker.toString());
                Thread t = new Thread(worker);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }


    }
}
