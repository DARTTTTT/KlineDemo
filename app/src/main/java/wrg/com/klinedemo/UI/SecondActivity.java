package wrg.com.klinedemo.UI;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;
import wrg.com.klinedemo.Constats.Constant;
import wrg.com.klinedemo.Entity.KlineEntity;
import wrg.com.klinedemo.Entity.StockListBean;
import wrg.com.klinedemo.R;
import wrg.com.klinedemo.Util.Model;

import static wrg.com.klinedemo.R.color.ma10;
import static wrg.com.klinedemo.R.color.ma20;
import static wrg.com.klinedemo.R.color.ma5;
import static wrg.com.klinedemo.Util.Model.getData;

public class SecondActivity extends AppCompatActivity {
    private CombinedChart mChart;
    private Button btn;
    private int itemcount;
    private LineData lineData;
    private CandleData candleData;
    private CombinedData combinedData;
    private ArrayList<String> xVals;
    private List<CandleEntry> candleEntries = new ArrayList<>();
    private int colorHomeBg;
    private int colorLine;
    private int colorText;
    private int colorMa5;
    private int colorMa10;
    private int colorMa20;
    private List<CandleEntry> candleEntriesKline;
    private List<KlineEntity.DataBean> KlineAlldata;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initChart();
        loadKlineData();
        loadChartData();
    }

    private void loadKlineData() {
        mChart.resetTracking();

            OkGo.get(Constant.day_Line)
                    .tag(this)
                    .cacheKey("cache")
                    .cacheMode(CacheMode.DEFAULT)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            KlineEntity klineEntity = new Gson().fromJson(s, KlineEntity.class);
                            KlineAlldata = klineEntity.getData();
                            Log.d("print", "onSuccess: K线的数据是" + KlineAlldata.toString());
                            candleEntriesKline = getCandleEntries(KlineAlldata, 0);
                            Log.d("print", "onSuccess: 处理好之后的数据"+candleEntries.toString());



                           Log.d("print", "onSuccess: 横坐标的数据"+xVals.toString());

                        }
                    });

    }


    public static List<CandleEntry> getCandleEntries(List<KlineEntity.DataBean> rawData, int startIndex) {
        List<CandleEntry> entries = new ArrayList<>();

        for (int i = 0; i < rawData.size(); i++) {
            KlineEntity.DataBean stock = rawData.get(i);
            if (stock == null) {
                Log.e("xxx", "第" + i + "StockBean==null");
                continue;
            }
            CandleEntry entry = new CandleEntry(startIndex+i, stock.getHighPx(), stock.getLowPx(), stock.getFirstPx(), stock.getLastPx());

            entries.add(entry);
        }

        return entries;
    }


    private void initChart() {
        mChart = (CombinedChart) findViewById(R.id.chart);
        colorHomeBg = getResources().getColor(R.color.home_page_bg);
        //colorHomeBg = getResources().getColor(R.color.common_white);
        colorLine = getResources().getColor(R.color.common_divider);
        colorText = getResources().getColor(R.color.text_grey_light);
        colorMa5 = getResources().getColor(ma5);
        colorMa10 = getResources().getColor(ma10);
        colorMa20 = getResources().getColor(ma20);

        mChart.setDescription("");
        mChart.setDrawGridBackground(true);
        mChart.setBackgroundColor(colorHomeBg);
        mChart.setGridBackgroundColor(colorHomeBg);
        mChart.setScaleYEnabled(false);
        mChart.setPinchZoom(true);
        mChart.setDrawValueAboveBar(false);
        mChart.setNoDataText("加载中...");
        mChart.setAutoScaleMinMaxEnabled(true);
        mChart.setDragEnabled(true);
        mChart.setDrawOrder(new CombinedChart.DrawOrder[]{CombinedChart.DrawOrder.CANDLE, CombinedChart.DrawOrder.LINE});
        //X轴
        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);
        xAxis.setGridColor(colorLine);
        xAxis.setTextColor(colorText);
        xAxis.setSpaceBetweenLabels(4);
        //Y轴
        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setLabelCount(4, false);
        leftAxis.setDrawGridLines(true);
        leftAxis.setDrawAxisLine(true);
        leftAxis.setGridColor(colorLine);
        leftAxis.setTextColor(colorText);

        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setEnabled(false);

        int[] colors = {colorMa5, colorMa10, colorMa20};
        String[] labels = {"MA5", "MA10", "MA20"};
        Legend legend = mChart.getLegend();
        legend.setCustom(colors, labels);
        legend.setPosition(Legend.LegendPosition.ABOVE_CHART_RIGHT);
        legend.setTextColor(Color.WHITE);
        //表格的监听
        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry entry, int i, Highlight highlight) {
                CandleEntry candleEntry = (CandleEntry) entry;
                float change = (candleEntry.getClose() - candleEntry.getOpen()) / candleEntry.getOpen();
                NumberFormat nf = NumberFormat.getPercentInstance();
                nf.setMaximumFractionDigits(2);
                String changePercentage = nf.format(Double.valueOf(String.valueOf(change)));
               /* Toast.makeText(getApplicationContext(), "最高" + candleEntry.getHigh() + " 最低" + candleEntry.getLow() +
                        " 开盘" + candleEntry.getOpen() + " 收盘" + candleEntry.getClose() +
                        " 涨跌幅" + changePercentage, Toast.LENGTH_SHORT).show();*/

            }

            @Override
            public void onNothingSelected() {

            }
        });

    }




    /**
     * 加载数据
     */
    private void loadChartData() {

        mChart.resetTracking();


        candleEntries = Model.getCandleEntries();

        itemcount = candleEntries.size();


        //获得相应的数据
        List<StockListBean.StockBean> stockBeans = getData();
        xVals = new ArrayList<>();
        for (int i = 0; i < itemcount; i++) {
            xVals.add(stockBeans.get(i).getDate());
        }


        combinedData = new CombinedData(xVals);


        candleData = generateCandleData();
        combinedData.setData(candleData);

        //MD5 MD10 MD20
        ArrayList<Entry> ma5Entries = new ArrayList<>();
        for (int index = 0; index < itemcount; index++) {
            ma5Entries.add(new Entry(stockBeans.get(index).getMa5(), index));
        }

        ArrayList<Entry> ma10Entries = new ArrayList<>();
        for (int index = 0; index < itemcount; index++) {
            ma10Entries.add(new Entry(stockBeans.get(index).getMa10(), index));
        }

        ArrayList<Entry> ma20Entries = new ArrayList<>();
        for (int index = 0; index < itemcount; index++) {
            ma20Entries.add(new Entry(stockBeans.get(index).getMa20(), index));
        }

        lineData = generateMultiLineData(
                generateLineDataSet(ma5Entries, colorMa5, "ma5"),
                generateLineDataSet(ma10Entries, colorMa10, "ma10"),
                generateLineDataSet(ma20Entries, colorMa20, "ma20"));

        combinedData.setData(lineData);
        mChart.setData(combinedData);//当前屏幕会显示所有的数据
        mChart.invalidate();
    }


    private LineDataSet generateLineDataSet(List<Entry> entries, int color, String label) {
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

    private LineData generateMultiLineData(LineDataSet... lineDataSets) {
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

    private CandleData generateCandleData() {

        CandleDataSet set = new CandleDataSet(candleEntries, "");
        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        set.setShadowWidth(0.7f);
        set.setDecreasingColor(Color.RED);
        set.setDecreasingPaintStyle(Paint.Style.FILL);
        set.setIncreasingColor(Color.GREEN);
        set.setIncreasingPaintStyle(Paint.Style.STROKE);
        set.setNeutralColor(Color.RED);
        set.setShadowColorSameAsCandle(true);
        set.setHighlightLineWidth(0.5f);
        set.setHighLightColor(Color.WHITE);
        set.setDrawValues(false);

        CandleData candleData = new CandleData(xVals);
        candleData.addDataSet(set);

        return candleData;
    }
}
