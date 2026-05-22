package sts.devices.httpcmdclientafiori.embeddedhttpserver.TestServer.server.repo;

import java.util.Hashtable;

public class R_MakeCall {
    Hashtable<Integer, String> makeCallRepos = new Hashtable<>();

    public R_MakeCall() {
        makeCallRepos = new Hashtable<>();
        makeCallRepos.put(27,"componendo chiamata a... 27");
        makeCallRepos.put(29,"componendo chiamata a... 29");
        makeCallRepos.put(36,"componendo chiamata a... 36");
        makeCallRepos.put(53,"componendo chiamata a... 53");
        makeCallRepos.put(48,"componendo chiamata a... 48");
    }

    public String makeCall(int idDevice){
        String response = makeCallRepos.get(idDevice);
        if (response ==null)
            return null;
        System.out.println("R_TestServer " +response);

        return response;
    }
}
