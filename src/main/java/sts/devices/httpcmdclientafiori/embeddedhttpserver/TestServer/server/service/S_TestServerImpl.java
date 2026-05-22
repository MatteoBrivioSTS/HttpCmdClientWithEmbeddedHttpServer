package sts.devices.httpcmdclientafiori.embeddedhttpserver.TestServer.server.service;


import sts.devices.httpcmdclientafiori.embeddedhttpserver.TestServer.server.repo.R_ChiudiCame;
import sts.devices.httpcmdclientafiori.embeddedhttpserver.TestServer.server.repo.R_MakeCall;
import sts.devices.httpcmdclientafiori.embeddedhttpserver.TestServer.server.repo.R_OpenBarrier;
import sts.devices.httpcmdclientafiori.embeddedhttpserver.TestServer.server.repo.R_OpenCame;
import sts.util.http_server.HTTP_Messages;
import sts.util.tuple.Tuple;

public class S_TestServerImpl implements S_TestServer{
    static final R_OpenBarrier r_testServer = new R_OpenBarrier();
    static final R_MakeCall r_makeCall = new R_MakeCall();
    static final R_OpenCame r_openCame = new R_OpenCame();
    static final R_ChiudiCame r_chiudiCame = new R_ChiudiCame();
    @Override
    public Tuple<Integer, String> getOpenBarrier(int idDevice) {
        String result = r_testServer.httpGetResponse(idDevice);
        System.out.println("S_TestServerImpl_getOpenBarrier" +result);
        if (result == null) {
            return new Tuple<Integer, String>(HTTP_Messages.NOT_FOUND, "non trovato");
        }
        return new Tuple<Integer, String>(HTTP_Messages.OK, result);
    }

    @Override
    public Tuple<Integer, String> getMakeCall(int idDevice) {
        String result = r_makeCall.makeCall(idDevice);
        System.out.println("S_TestServerImpl_httpGetResponse " +result);
        if (result == null) {
            return new Tuple<Integer, String>(HTTP_Messages.NOT_FOUND, "non trovato");
        }
        return new Tuple<Integer, String>(HTTP_Messages.OK, result);
    }

    @Override
    public Tuple<Integer, String> getOpenCame(int idDevice) {
        String result = r_openCame.openCame(idDevice);
        System.out.println("S_TestServerImpl_httpGetResponse " +result);
        if (result == null) {
            return new Tuple<Integer, String>(HTTP_Messages.NOT_FOUND, "non trovato");
        }
        return new Tuple<Integer, String>(HTTP_Messages.OK, result);
    }

    @Override
    public Tuple<Integer, String> getChiudiCame(int idDevice) {
        String result = r_chiudiCame.chiudiCame(idDevice);
        System.out.println("S_TestServerImpl_httpGetResponse " +result);
        if (result == null) {
            return new Tuple<Integer, String>(HTTP_Messages.NOT_FOUND, "non trovato");
        }
        return new Tuple<Integer, String>(HTTP_Messages.OK, result);
    }
}
