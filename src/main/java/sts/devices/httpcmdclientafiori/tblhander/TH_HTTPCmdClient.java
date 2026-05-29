package sts.devices.httpcmdclientafiori.tblhander;

import lis.drivers.com.metarec.util.Record;
import lis.drivers.comm.conn.core.RCXChannel;
import lis.drivers.worker.helper.TableHandler;
import lis.drivers.worker.helper.Tuple;
import sts.devices.httpcmdclientafiori.models.Command;
import sts.devices.httpcmdclientafiori.models.Fullev;
import sts.devices.httpcmdclientafiori.models.HttpStringCommand;
import sts.devices.httpcmdclientafiori.models.Pntdef;
import sts.devices.httpcmdclientafiori.worker.W_HTTPCmdClient;

import java.util.Enumeration;

public class TH_HTTPCmdClient extends TableHandler {
    private static final String COMMAND = "COMMAND";
    private static final String PNTDEFS = "PNTDEFS";
    private static final String HTTPSTRINGCOMMAND = "HTTPSTRINGCOMMAND";
    private static final String FULLEV = "FULLEV";



    public static final int PNTDEFS_ALIGN = 1;
    private static final int HTTPSTRINGCOMMAND_ALIGN = 2;

    public static final int ALL_TABLE_ALIGN = 3;

    private RCXChannel rcxChannel = null;
    public TH_HTTPCmdClient() {
    }

    public TH_HTTPCmdClient(RCXChannel rcxChannel) {super(rcxChannel);}

    @Override
    public void manageRecord(Record rec) {
        rcxChannel = getRcxChannel();
        try{
            if (rec.tagName.equals("META#ALIGN")) {
                switch (rec.fieldValues[0]) {
                    case  HTTPSTRINGCOMMAND -> {
                        setAlignment(HTTPSTRINGCOMMAND_ALIGN);
                    }
                    case PNTDEFS ->{
                        setAlignment(PNTDEFS_ALIGN);
                    }
                }
            }else{
                switch (rec.tagName){
                    case PNTDEFS -> {
                        if (rec.alive)
                        {
                            for (Enumeration en = rcxChannel.getWorkers().elements(); en.hasMoreElements(); )
                            {
                                W_HTTPCmdClient w_httpCmdClient = (W_HTTPCmdClient) en.nextElement();
                                if((rec.fieldValues[0].equals(rcxChannel.getProto()))
                                        &&(rec.fieldValues[1].equals(w_httpCmdClient.getName())))
                                {
                                    Pntdef pntdef = new Pntdef(rec.fieldValues[0], rec.fieldValues[1], rec.fieldValues[2],
                                            rec.fieldValues[3], rec.fieldValues[4], rec.fieldValues[5], rec.fieldValues[6], rec.fieldValues[7]);
                                    w_httpCmdClient.getPntdefs().put(rec.strkey,pntdef);
                                }
                            }
                        }
                    }
                    case COMMAND ->
                    {
                        System.out.println("**************COMMAND*********: "+ rec.toString());
                        if (rec.alive)
                        {
                            for (Enumeration en = rcxChannel.getWorkers().elements(); en.hasMoreElements(); )
                            {
                                W_HTTPCmdClient w_httpCmdClient = (W_HTTPCmdClient) en.nextElement();
                                if((rec.fieldValues[0].equals(rcxChannel.getProto()))
                                        &&(rec.fieldValues[1].equals(w_httpCmdClient.getName())))
                                {
                                    Command cmd = new Command(rec.fieldValues[0], rec.fieldValues[1], rec.fieldValues[2],
                                            rec.fieldValues[3], rec.fieldValues[4]);
                                    w_httpCmdClient.getCmds().add(new Tuple<>(Integer.parseInt(rec.fieldValues[3]), cmd));
                                }

                            }

                        }
                    }
                    case HTTPSTRINGCOMMAND ->{
                        if (rec.alive)
                        {
                            for (Enumeration en = rcxChannel.getWorkers().elements(); en.hasMoreElements(); )
                            {
                                W_HTTPCmdClient w_httpCmdClient = (W_HTTPCmdClient) en.nextElement();
                                HttpStringCommand httpStringCommand = new HttpStringCommand(rec.fieldValues[0],
                                        rec.fieldValues[1], rec.fieldValues[2], rec.fieldValues[3], rec.fieldValues[4]);
                                w_httpCmdClient.getHttpStingCommands().put(rec.strkey, httpStringCommand);
                            }

                        }
                    }
//                    case FULLEV ->{
//                        if (rec.alive)
//                        {
//                            for (Enumeration en = rcxChannel.getWorkers().elements(); en.hasMoreElements(); )
//                            {
//                                W_HTTPCmdClient w_httpCmdClient = (W_HTTPCmdClient) en.nextElement();
//                                if((rec.fieldValues[0].equals(rcxChannel.getProto()))
//                                        &&(rec.fieldValues[1].equals(w_httpCmdClient.getName())))
//                                {
//                                    Fullev fullev = new Fullev(rec.fieldValues[0],
//                                            rec.fieldValues[1], rec.fieldValues[2], rec.fieldValues[3], rec.fieldValues[4],
//                                            rec.fieldValues[5], rec.fieldValues[6], rec.fieldValues[7], rec.fieldValues[8],
//                                            rec.fieldValues[9], rec.fieldValues[10], rec.fieldValues[11], rec.fieldValues[12],
//                                            rec.fieldValues[13], rec.fieldValues[14], rec.fieldValues[15], rec.fieldValues[16],
//                                            rec.fieldValues[17]);
//                                    w_httpCmdClient.getFullevs().put(rec.strkey,fullev);
//                                    System.out.println("***********"+rec.strkey+"***********"+fullev);
//                                }
//
//
//                            }
//                        }
//                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    protected void setAlignment(int tblAlignValue) {
        for (Enumeration en = rcxChannel.getWorkers().elements(); en.hasMoreElements();) {
            W_HTTPCmdClient w_httpCmdClient = (W_HTTPCmdClient) en.nextElement();
            int w_tableAlign = w_httpCmdClient.getAlignTable();
            w_httpCmdClient.setAlignTable(w_tableAlign |= tblAlignValue);
        }
    }
}
