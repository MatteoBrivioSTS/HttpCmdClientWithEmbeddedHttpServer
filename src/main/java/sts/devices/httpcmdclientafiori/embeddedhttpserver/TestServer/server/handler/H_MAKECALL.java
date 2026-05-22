package sts.devices.httpcmdclientafiori.embeddedhttpserver.TestServer.server.handler;

import com.sun.net.httpserver.HttpExchange;

import sts.devices.httpcmdclientafiori.embeddedhttpserver.TestServer.server.service.S_TestServer;
import sts.devices.httpcmdclientafiori.embeddedhttpserver.TestServer.server.service.S_TestServerImpl;
import sts.util.http_server.controller.Controller;
import sts.util.tuple.Tuple;

import java.io.IOException;
import java.util.Map;

public class H_MAKECALL extends Controller {
    S_TestServer s_testServer = new S_TestServerImpl();
    @Override
    public void handle(HttpExchange exchange, Map<String, String> params) throws IOException {
        int idDevice = Integer.parseInt(params.get("idDevice"));
        System.out.println("H_MAKECALL "+ idDevice);
        Tuple<Integer, String> result = s_testServer.getMakeCall(idDevice);
        sendResponse(exchange,result.getFirstValue(), getMapper().writeValueAsString(result.getSecondValue()));
    }
}
