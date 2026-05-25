package sts.devices.httpcmdclientafiori.worker.status;

import lis.drivers.com.metarec.util.Record;
import lis.drivers.comm.conn.core.RCXChannel;
import lis.drivers.model.rcx.RCXDevice;
import lis.drivers.worker.helper.ConcreteStatus;
import lis.drivers.worker.helper.WorkerStatus;
import sts.devices.httpcmdclientafiori.models.panag_src.CAM_Model;
import sts.devices.httpcmdclientafiori.models.panag_src.En_S_Model;
import sts.devices.httpcmdclientafiori.models.panag_src.En_V_Model;
import sts.devices.httpcmdclientafiori.models.panag_src.Us_S_Model;
import sts.devices.httpcmdclientafiori.tblhander.TH_HTTPCmdClient;
import sts.devices.httpcmdclientafiori.worker.W_HTTPCmdClient;

public class W_HTTPCmdClient_INIT implements ConcreteStatus {
    private WorkerStatus ws;
    private W_HTTPCmdClient worker;
    private RCXChannel rcxChannel;
    private RCXDevice rcxDevice;
    private int initPrio= 0;
    //Constructor
    public W_HTTPCmdClient_INIT() {
    }

    public W_HTTPCmdClient_INIT(WorkerStatus ws, W_HTTPCmdClient worker) {
        this.ws = ws;
        this.worker = worker;
    }

    @Override
    public void business(WorkerStatus workerStatus) {
        try {
            if (ws == null) {
                System.out.println("WS == null");
                setWs(workerStatus);
            }

            if (worker == null) {
                System.out.println("WORKER == null");
                setWorker((W_HTTPCmdClient) getWs().getWorker());
            }
            switch (initPrio)
            {
                case 0 -> {step1();}
                case 1 -> {sendEns();}
                case 2 -> {step3();}
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Getter and Setter
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

    private void step1() throws Exception {
        rcxChannel = (RCXChannel) getWorker().getCoreChannel();
        if(rcxChannel != null)
        {

            rcxDevice = rcxChannel.getDevices().get(getWorker().getName());
            System.out.println("DEVICE: " +  rcxDevice.toString());

            if(rcxDevice != null)
            {
                rcxDevice.devicstatus &= ~RCXDevice.STAT_UPLD;
                rcxDevice.devicstatus &= ~RCXDevice.STAT_DISC;
                rcxDevice.devicstatus &= ~RCXDevice.STAT_OFFL;
                Record rec = rcxDevice.DescribeDevice();
                rcxChannel.sendRecord(rec);
            }
        }
        initPrio++;
    }

    public void sendEns() throws Exception {
        rcxChannel = (RCXChannel) getWorker().getCoreChannel();
        for(int i=1;i<=W_HTTPCmdClient.EN_S_VALUE;i++)
        {
            Record record = En_S_Model.formObjToRecord(new En_S_Model(rcxChannel.getProto(),
                    getWorker().getName(),String.format("En_S%04d", i),String.format("En_S%04d", i),0,0,0,0));
            rcxChannel.sendRecord(record);
        }
        for(int i=1;i<=W_HTTPCmdClient.US_S_VALUE;i++)
        {
            Record record = Us_S_Model.formObjToRecord(new Us_S_Model(rcxChannel.getProto(),
                    getWorker().getName(),String.format("Us_S%04d", i),String.format("En_S%04d", i),0,0,0,0));
            rcxChannel.sendRecord(record);
        }
        for(int i=1;i<=W_HTTPCmdClient.US_V_VALUE;i++)
        {
            Record record = En_V_Model.formObjToRecord(new En_V_Model(rcxChannel.getProto(),
                    getWorker().getName(),String.format("Us_V%04d", i),String.format("En_S%04d", i),0,0,0,0));
            rcxChannel.sendRecord(record);
        }
        for(int i=1;i<=W_HTTPCmdClient.CAM_VALUE;i++)
        {
            Record record = CAM_Model.formObjToRecord(new CAM_Model(rcxChannel.getProto(),
                    getWorker().getName(),String.format("CAM_%04d", i),String.format("En_S%04d", i),0,0,0,0));
            rcxChannel.sendRecord(record);
        }
        initPrio++;
    }

    public void step3(){
        if((getWorker().getAlignTable()& TH_HTTPCmdClient.ALL_TABLE_ALIGN )== TH_HTTPCmdClient.ALL_TABLE_ALIGN)
        {
            getWorker().getWs().setStatus(new W_HTTPCmdClient_NORMAL());
            getWorker().getWs().setWorker(getWorker());
        }
    }
}
