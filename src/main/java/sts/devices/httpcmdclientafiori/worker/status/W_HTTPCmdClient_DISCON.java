package sts.devices.httpcmdclientafiori.worker.status;

import lis.drivers.com.metarec.util.Record;
import lis.drivers.comm.conn.core.RCXChannel;
import lis.drivers.model.rcx.RCXDevice;
import lis.drivers.worker.helper.ConcreteStatus;
import lis.drivers.worker.helper.WorkerStatus;
import sts.devices.httpcmdclientafiori.worker.W_HTTPCmdClient;

public class W_HTTPCmdClient_DISCON implements ConcreteStatus {

    //Constructor
    public W_HTTPCmdClient_DISCON() {}

    private WorkerStatus ws;
    private W_HTTPCmdClient worker;
    private long retry = System.currentTimeMillis() +6000;

    @Override
    public void business(WorkerStatus workerStatus) {
        if(ws==null)
        {
            System.out.println("WS == null");
            setWs(workerStatus);
        }

        if(worker == null)
        {
            System.out.println("Worker == null");
            setWorker((W_HTTPCmdClient) getWs().getWorker());
        }

        try {
            System.out.println(this.toString());

            if(getRetry() < System.currentTimeMillis())
            {
                // GO TO INIT...
                getWorker().getWs().setStatus(new W_HTTPCmdClient_INIT());
                RCXChannel rcx = (RCXChannel) getWorker().getCoreChannel();
                RCXDevice device = rcx.getDevices().get(getWorker().getName());
                device.devicstatus &= ~RCXDevice.STAT_DISC;

                Record rec = device.DescribeDevice();
                rcx.sendRecord(rec);

                setRetry(System.currentTimeMillis() + 300000);
            }
            getWorker().sendLog(1, getWorker().getName() + " - DISCONN");

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
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

    public long getRetry() {
        return retry;
    }

    public void setRetry(long retry) {
        this.retry = retry;
    }
}
