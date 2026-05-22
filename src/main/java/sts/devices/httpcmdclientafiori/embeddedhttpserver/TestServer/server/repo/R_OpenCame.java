package sts.devices.httpcmdclientafiori.embeddedhttpserver.TestServer.server.repo;

import java.util.Hashtable;

public class R_OpenCame {
    Hashtable<Integer, String> openCameRepos = new Hashtable<>();

    public R_OpenCame() {
        openCameRepos = new Hashtable<>();
        openCameRepos.put(12,"Aprendo cancello... 12");
        openCameRepos.put(14,"Aprendo cancello... 14");
    }

    public String openCame(int idDevice){
        String response = openCameRepos.get(idDevice);
        if (response ==null)
            return null;
        System.out.println("R_TestServer " +response);

        return response;
    }
}
