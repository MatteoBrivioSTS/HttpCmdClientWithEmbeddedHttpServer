package sts.devices.httpcmdclientafiori.embeddedhttpserver.TestServer.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpServer;

import sts.devices.httpcmdclientafiori.embeddedhttpserver.TestServer.server.handler.H_CLOSECAME;
import sts.devices.httpcmdclientafiori.embeddedhttpserver.TestServer.server.handler.H_MAKECALL;
import sts.devices.httpcmdclientafiori.embeddedhttpserver.TestServer.server.handler.H_OPENBARRIER;
import sts.devices.httpcmdclientafiori.embeddedhttpserver.TestServer.server.handler.H_OPENCAME;
import sts.util.http_server.EmbeddedHttpServer;
import sts.util.http_server.router.Router;

import java.io.IOException;

public class HTTP_Server extends EmbeddedHttpServer {
    public HTTP_Server() throws IOException {
    }

    public HTTP_Server(int port) throws IOException {
        super(port);
//       OpenBarrier
        getRouter().addRoute("GET", "/CommandSender/Command.svc/OpenBarrier/{idDevice}",new H_OPENBARRIER());
        //MakeCall
        getRouter().addRoute("GET", "/CommandSender/Command.svc/MakeCall/{idDevice}",new H_MAKECALL());
        //OpenCame
        getRouter().addRoute("GET", "/CommandSender/Command.svc/OpenCame/{idDevice}",new H_OPENCAME());
        //ChiudiCame
        getRouter().addRoute("GET", "/CommandSender/Command.svc/ChiudiCame/{idDevice}",new H_CLOSECAME());

        getServer().start();
    }

    @Override
    public ObjectMapper getMapper() {
        return super.getMapper();
    }

    @Override
    public void setMapper(ObjectMapper mapper) {
        super.setMapper(mapper);
    }

    @Override
    public int getPort() {
        return super.getPort();
    }

    @Override
    public void setPort(int port) {
        super.setPort(port);
    }

    @Override
    public Router getRouter() {
        return super.getRouter();
    }

    @Override
    public void setRouter(Router router) {
        super.setRouter(router);
    }

    @Override
    public HttpServer getServer() {
        return super.getServer();
    }

    @Override
    public void setServer(HttpServer server) {
        super.setServer(server);
    }
}
