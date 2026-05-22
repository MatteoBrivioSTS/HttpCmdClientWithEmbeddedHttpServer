package sts.devices.httpcmdclientafiori.embeddedhttpserver.TestServer.server.repo;

import java.util.Hashtable;

public class R_OpenBarrier {
    Hashtable<Integer, String> openBarrierRequests = new Hashtable<>();

    public R_OpenBarrier() {
        openBarrierRequests = new Hashtable<>();
        openBarrierRequests.put(27,"apertura barriera 27");
        openBarrierRequests.put(29,"apertura barriera 29");
        openBarrierRequests.put(36,"apertura barriera 36");
        openBarrierRequests.put(53,"apertura barriera 53");
        openBarrierRequests.put(48,"apertura barriera 48");
    }

    public String httpGetResponse(int idDevice){
        String response = openBarrierRequests.get(idDevice);
        if (response ==null)
            return null;
        System.out.println("R_TestServer " +response);

        return response;
    }
}
