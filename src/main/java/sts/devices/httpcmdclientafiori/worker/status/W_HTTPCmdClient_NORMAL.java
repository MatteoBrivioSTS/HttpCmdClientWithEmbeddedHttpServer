package sts.devices.httpcmdclientafiori.worker.status;

import lis.drivers.com.metarec.util.Record;
import lis.drivers.comm.conn.core.RCXChannel;
import lis.drivers.worker.helper.ConcreteStatus;
import lis.drivers.worker.helper.Tuple;
import lis.drivers.worker.helper.WorkerStatus;
import sts.devices.httpcmdclientafiori.models.Command;
import sts.devices.httpcmdclientafiori.models.HttpStringCommand;
import sts.devices.httpcmdclientafiori.models.Pntdef;
import sts.devices.httpcmdclientafiori.worker.W_HTTPCmdClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class W_HTTPCmdClient_NORMAL implements ConcreteStatus {
    private WorkerStatus ws;
    private W_HTTPCmdClient worker;
    @Override
    public void business(WorkerStatus workerStatus) {

        try{
            if(ws == null)
            {
                System.out.println("WS == null");
                setWs(workerStatus);
            }

            if(worker == null)
            {
                System.out.println("WORKER == null");
                setWorker((W_HTTPCmdClient) getWs().getWorker());
            }
            if(!getWorker().getCmds().isEmpty())
            {
                Tuple<Integer,Command> cmd = getWorker().getCmds().remove(0);
                switch (Integer.toString(cmd.getFirstValue()).trim())
                {
                    case W_HTTPCmdClient.COMMAND_110 -> {httpgetrequest110(cmd.getSecondValue());}
                    case W_HTTPCmdClient.COMMAND_111 -> {httpgetrequest111(cmd.getSecondValue());}
                    case W_HTTPCmdClient.COMMAND_112 -> {httpgetrequest112(cmd.getSecondValue());}
                    case W_HTTPCmdClient.COMMAND_113 -> {httpgetrequest113(cmd.getSecondValue());}
                    case W_HTTPCmdClient.COMMAND_114 -> {httpgetrequest114(cmd.getSecondValue());}
                    case W_HTTPCmdClient.COMMAND_115 -> {httpgetrequest115(cmd.getSecondValue());}
                    case W_HTTPCmdClient.COMMAND_116 -> {httpgetrequest116(cmd.getSecondValue());}
                    case W_HTTPCmdClient.EMPTYSTRING_VALUE -> {break;}
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    private void httpgetrequest110(Command cmd) throws IOException, InterruptedException {
        RCXChannel rcxChannel = (RCXChannel) getWorker().getCoreChannel();
        Pntdef pntdef = getWorker().getPntdefs().get(rcxChannel.getProto() +
                        Record.KEYSYNCH + getWorker().getName() + Record.KEYSYNCH + cmd.getName());
        if(pntdef != null)
        {
            HttpStringCommand hsc = getWorker().getHttpStingCommands().get(
                    rcxChannel.getProto() + Record.KEYSYNCH + getWorker().getName() + Record.KEYSYNCH +
                            cmd.getName()+ Record.KEYSYNCH+ W_HTTPCmdClient.COMMAND_110);
            System.out.println("pntdef "+pntdef+" hsc "+hsc);
            if (hsc != null){
                getWorker().command110request(hsc.getHttpString().trim());
            }
        }
    }
    private void httpgetrequest111(Command cmd) throws IOException, InterruptedException {
        RCXChannel rcxChannel = (RCXChannel) getWorker().getCoreChannel();
        Pntdef pntdef = getWorker().getPntdefs().get(rcxChannel.getProto() +
                Record.KEYSYNCH + getWorker().getName() + Record.KEYSYNCH + cmd.getName());
        if(pntdef != null)
        {
            HttpStringCommand hsc = getWorker().getHttpStingCommands().get(
                    rcxChannel.getProto() + Record.KEYSYNCH + getWorker().getName() + Record.KEYSYNCH +
                            cmd.getName()+ Record.KEYSYNCH+ W_HTTPCmdClient.COMMAND_111);
            System.out.println("pntdef "+pntdef+" hsc "+hsc);
            if (hsc != null){
                getWorker().command111request(hsc.getHttpString().trim());
            }
        }
    }
    private void httpgetrequest112(Command cmd) throws IOException, InterruptedException {
        RCXChannel rcxChannel = (RCXChannel) getWorker().getCoreChannel();
        Pntdef pntdef = getWorker().getPntdefs().get(rcxChannel.getProto() +
                Record.KEYSYNCH + getWorker().getName() + Record.KEYSYNCH + cmd.getName());
        if(pntdef != null)
        {
            HttpStringCommand hsc = getWorker().getHttpStingCommands().get(
                    rcxChannel.getProto() + Record.KEYSYNCH + getWorker().getName() + Record.KEYSYNCH +
                            cmd.getName()+ Record.KEYSYNCH+ W_HTTPCmdClient.COMMAND_112);
            System.out.println("pntdef "+pntdef+" hsc "+hsc);
            if (hsc != null){
                getWorker().command112request(hsc.getHttpString().trim());
            }
        }
    }
    private void httpgetrequest113(Command cmd) throws IOException, InterruptedException {
        RCXChannel rcxChannel = (RCXChannel) getWorker().getCoreChannel();
        Pntdef pntdef = getWorker().getPntdefs().get(rcxChannel.getProto() +
                Record.KEYSYNCH + getWorker().getName() + Record.KEYSYNCH + cmd.getName());
        if(pntdef != null)
        {
            HttpStringCommand hsc = getWorker().getHttpStingCommands().get(
                    rcxChannel.getProto() + Record.KEYSYNCH + getWorker().getName() + Record.KEYSYNCH +
                            cmd.getName()+ Record.KEYSYNCH+ W_HTTPCmdClient.COMMAND_113);
            System.out.println("pntdef "+pntdef+" hsc "+hsc);
            if (hsc != null){
                getWorker().command113request(hsc.getHttpString().trim());
            }
        }
    }
    private void httpgetrequest114(Command cmd) throws IOException, InterruptedException {
        RCXChannel rcxChannel = (RCXChannel) getWorker().getCoreChannel();
        Pntdef pntdef = getWorker().getPntdefs().get(rcxChannel.getProto() +
                Record.KEYSYNCH + getWorker().getName() + Record.KEYSYNCH + cmd.getName());
        if(pntdef != null)
        {
            HttpStringCommand hsc = getWorker().getHttpStingCommands().get(
                    rcxChannel.getProto() + Record.KEYSYNCH + getWorker().getName() + Record.KEYSYNCH +
                            cmd.getName()+ Record.KEYSYNCH+ W_HTTPCmdClient.COMMAND_114);
            System.out.println("pntdef "+pntdef+" hsc "+hsc);
            if (hsc != null){
                getWorker().command113request(hsc.getHttpString().trim());
            }
        }
    }
    private void httpgetrequest115(Command cmd) throws IOException, InterruptedException {
        RCXChannel rcxChannel = (RCXChannel) getWorker().getCoreChannel();
        Pntdef pntdef = getWorker().getPntdefs().get(rcxChannel.getProto() +
                Record.KEYSYNCH + getWorker().getName() + Record.KEYSYNCH + cmd.getName());
        if(pntdef != null)
        {
            HttpStringCommand hsc = getWorker().getHttpStingCommands().get(
                    rcxChannel.getProto() + Record.KEYSYNCH + getWorker().getName() + Record.KEYSYNCH +
                            cmd.getName()+ Record.KEYSYNCH+ W_HTTPCmdClient.COMMAND_115);
            System.out.println("pntdef "+pntdef+" hsc "+hsc);
            if (hsc != null){
                getWorker().command113request(hsc.getHttpString().trim());
            }
        }
    }
    private void httpgetrequest116(Command cmd) throws IOException, InterruptedException {
        RCXChannel rcxChannel = (RCXChannel) getWorker().getCoreChannel();
        Pntdef pntdef = getWorker().getPntdefs().get(rcxChannel.getProto() +
                Record.KEYSYNCH + getWorker().getName() + Record.KEYSYNCH + cmd.getName());
        if(pntdef != null)
        {
            HttpStringCommand hsc = getWorker().getHttpStingCommands().get(
                    rcxChannel.getProto() + Record.KEYSYNCH + getWorker().getName() + Record.KEYSYNCH +
                            cmd.getName()+ Record.KEYSYNCH+ W_HTTPCmdClient.COMMAND_116);
            System.out.println("pntdef "+pntdef+" hsc "+hsc);
            if (hsc != null){
                getWorker().command113request(hsc.getHttpString().trim());
            }
        }
    }

    public WorkerStatus getWs() {
        return ws;
    }

    public void setWs(WorkerStatus ws) {
        this.ws = ws;
    }

    public W_HTTPCmdClient getWorker() {
        return worker;
    }

    public void setWorker(W_HTTPCmdClient worker) {
        this.worker = worker;
    }
}
