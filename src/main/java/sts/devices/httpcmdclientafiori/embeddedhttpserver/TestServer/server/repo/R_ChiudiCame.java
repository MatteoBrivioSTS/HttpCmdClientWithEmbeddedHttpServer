package sts.devices.httpcmdclientafiori.embeddedhttpserver.TestServer.server.repo;

import java.util.Hashtable;

public class R_ChiudiCame {
    Hashtable<Integer, String> chiudiCameRepo = new Hashtable<>();

    public R_ChiudiCame() {
        chiudiCameRepo = new Hashtable<>();
        chiudiCameRepo.put(12,"Chiudendo cancello... 12");
        chiudiCameRepo.put(14,"Chiudendo cancello... 14");
    }

    public String chiudiCame(int idDevice){
        String response = chiudiCameRepo.get(idDevice);
        if (response ==null)
            return null;
        System.out.println("R_ChiudiCame " +response);

        return response;
    }
}
