package sts.devices.httpcmdclientafiori.embeddedhttpserver.TestServer.server.service;

import sts.util.tuple.Tuple;

public interface S_TestServer {
    Tuple<Integer, String> getOpenBarrier( int idDevice);
    Tuple<Integer, String> getMakeCall( int idDevice);
    Tuple<Integer, String> getOpenCame( int idDevice);
    Tuple<Integer, String> getChiudiCame( int idDevice);
}
