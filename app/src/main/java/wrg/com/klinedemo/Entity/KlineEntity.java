package wrg.com.klinedemo.Entity;

import java.util.List;

/**
 * Created by 翁 on 2017/3/16.
 */

public class KlineEntity {




    private String MsgType;
    private String RefMsgType;
    private int MsgSeqNum;
    private List<DataBean> Data;

    @Override
    public String toString() {
        return "KlineEntity{" +
                "MsgType='" + MsgType + '\'' +
                ", RefMsgType='" + RefMsgType + '\'' +
                ", MsgSeqNum=" + MsgSeqNum +
                ", Data=" + Data +
                '}';
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String MsgType) {
        this.MsgType = MsgType;
    }

    public String getRefMsgType() {
        return RefMsgType;
    }

    public void setRefMsgType(String RefMsgType) {
        this.RefMsgType = RefMsgType;
    }

    public int getMsgSeqNum() {
        return MsgSeqNum;
    }

    public void setMsgSeqNum(int MsgSeqNum) {
        this.MsgSeqNum = MsgSeqNum;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "ID='" + ID + '\'' +
                    ", TrdDt='" + TrdDt + '\'' +
                    ", PrevClsPx=" + PrevClsPx +
                    ", FirstPx=" + FirstPx +
                    ", LastPx=" + LastPx +
                    ", HighPx=" + HighPx +
                    ", LowPx=" + LowPx +
                    ", TrdVol=" + TrdVol +
                    ", TrdAmt=" + TrdAmt +
                    '}';
        }

        private String ID;
        private String TrdDt;
        private double PrevClsPx;

        private float FirstPx;
        private float LastPx;
        private float HighPx;
        private float LowPx;



        private double TrdVol;
        private double TrdAmt;

        private String state;

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getTrdDt() {
            return TrdDt;
        }

        public void setTrdDt(String TrdDt) {
            this.TrdDt = TrdDt;
        }

        public double getPrevClsPx() {
            return PrevClsPx;
        }

        public void setPrevClsPx(double PrevClsPx) {
            this.PrevClsPx = PrevClsPx;
        }

        public float getFirstPx() {
            return FirstPx;
        }

        public void setFirstPx(float firstPx) {
            FirstPx = firstPx;
        }

        public float getLastPx() {
            return LastPx;
        }

        public void setLastPx(float lastPx) {
            LastPx = lastPx;
        }

        public float getHighPx() {
            return HighPx;
        }

        public void setHighPx(float highPx) {
            HighPx = highPx;
        }

        public float getLowPx() {
            return LowPx;
        }

        public void setLowPx(float lowPx) {
            LowPx = lowPx;
        }

        public double getTrdVol() {
            return TrdVol;
        }

        public void setTrdVol(double trdVol) {
            TrdVol = trdVol;
        }

        public double getTrdAmt() {
            return TrdAmt;
        }

        public void setTrdAmt(double trdAmt) {
            TrdAmt = trdAmt;
        }
    }
}
