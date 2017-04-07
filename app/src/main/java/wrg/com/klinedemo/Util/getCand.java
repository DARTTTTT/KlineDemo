package wrg.com.klinedemo.Util;

import android.util.Log;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

import wrg.com.klinedemo.Entity.KlineEntity;

/**
 * Created by 翁 on 2017/3/17.
 */

public class getCand {
    private int itemcount;


    public static List<CandleEntry> getCandleEntries(List<KlineEntity.DataBean> rawData, int startIndex) {
        List<CandleEntry> entries = new ArrayList<>();

        for (int i = 0; i < rawData.size(); i++) {
            KlineEntity.DataBean stock = rawData.get(i);
            if (stock == null) {
                Log.e("xxx", "第" + i + "StockBean==null");
                continue;
            }
            CandleEntry entry = new CandleEntry(startIndex + i, stock.getHighPx(), stock.getLowPx(), stock.getFirstPx(), stock.getLastPx());

            entries.add(entry);
        }

        return entries;
    }





    //MD线数据
    public LineDataSet generateLineDataSet(List<Entry> entries, int color, String label) {
        LineDataSet set = new LineDataSet(entries, label);
        set.setColor(color);
        set.setLineWidth(1f);
        set.setDrawCubic(true);//圆滑曲线
        set.setDrawCircles(false);
        set.setDrawCircleHole(false);
        set.setDrawValues(false);
        set.setHighlightEnabled(false);
        set.setAxisDependency(YAxis.AxisDependency.LEFT);

        return set;
    }

    public LineData generateMultiLineData(LineDataSet... lineDataSets) {

        List<ILineDataSet> dataSets = new ArrayList<>();
        for (int i = 0; i < lineDataSets.length; i++) {
            dataSets.add(lineDataSets[i]);
        }

        List<String> xVals = new ArrayList<>();
        for (int i = 0; i < itemcount; i++) {
            xVals.add("" + (1990 + i));
        }

        LineData data = new LineData(xVals, dataSets);

        return data;
    }
}
