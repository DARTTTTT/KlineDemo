package wrg.com.klinedemo.Util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import wrg.com.klinedemo.Entity.KlineEntity;
import wrg.com.klinedemo.Entity.MinuteEntity;

/**
 * Created by 翁 on 2017/3/16.
 */

public class OrderData {


    /**
     * 涨幅从低到高
     * @param data
     * @return
     */
    public static List<KlineEntity.DataBean> getPastToNowData(final List<KlineEntity.DataBean> data) {
        Collections.sort(data, new Comparator<KlineEntity.DataBean>() {
            @Override
            public int compare(KlineEntity.DataBean dataBean, KlineEntity.DataBean dataBean2) {
                int trdDt = Integer.parseInt(dataBean.getTrdDt().substring(0,10).replace("-",""));
                int trdDt2 = Integer.parseInt(dataBean2.getTrdDt().substring(0, 10).replace("-",""));
                if (trdDt > trdDt2) {
                    return 1;
                }
                if (trdDt == trdDt2) {
                    return 0;
                }
                return -1;
            }
        });
        return data;
    }


    public static List<KlineEntity.DataBean> getNowToPassData(final List<KlineEntity.DataBean> data) {
        Collections.sort(data, new Comparator<KlineEntity.DataBean>() {
            @Override
            public int compare(KlineEntity.DataBean dataBean, KlineEntity.DataBean dataBean2) {
                int trdDt = Integer.parseInt(dataBean.getTrdDt().substring(0,10).replace("-",""));
                int trdDt2 = Integer.parseInt(dataBean2.getTrdDt().substring(0, 10).replace("-",""));
                if (trdDt > trdDt2) {
                    return 0;
                }
                if (trdDt == trdDt2) {
                    return 1;
                }
                return -1;
            }
        });
        return data;
    }



    public static List<KlineEntity.DataBean> getPastToNowFenshiData(final List<KlineEntity.DataBean> data){
        Collections.sort(data, new Comparator<KlineEntity.DataBean>() {
            @Override
            public int compare(KlineEntity.DataBean dataBean, KlineEntity.DataBean dataBean2) {
                int trdDt = Integer.parseInt(dataBean.getTrdDt().substring(11, dataBean.getTrdDt().length()-3).replace(":",""));
                int trdDt2 = Integer.parseInt(dataBean2.getTrdDt().substring(11, dataBean2.getTrdDt().length()-3).replace(":",""));
                if (trdDt > trdDt2) {
                    return 1;
                }
                if (trdDt == trdDt2) {
                    return 0;
                }
                return -1;
            }
        });
       return data;

    }


    public static List<MinuteEntity.DataBean> getPastToNowMinuteData(final List<MinuteEntity.DataBean> data) {
        Collections.sort(data, new Comparator<MinuteEntity.DataBean>() {
            @Override
            public int compare(MinuteEntity.DataBean dataBean, MinuteEntity.DataBean dataBean2) {
                int trdDt = Integer.parseInt(dataBean.getTrdTm().substring(0,10).replace("-",""));
                int trdDt2 = Integer.parseInt(dataBean2.getTrdTm().substring(0, 10).replace("-",""));
                if (trdDt > trdDt2) {
                    return 1;
                }
                if (trdDt == trdDt2) {
                    return 0;
                }
                return -1;
            }
        });
        return data;
    }
}
