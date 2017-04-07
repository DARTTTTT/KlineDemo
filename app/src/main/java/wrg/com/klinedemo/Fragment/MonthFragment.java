package wrg.com.klinedemo.Fragment;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.Utils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import wrg.com.klinedemo.Base.BaseFragment;
import wrg.com.klinedemo.Entity.KlineEntity;
import wrg.com.klinedemo.R;
import wrg.com.klinedemo.Util.CoupleChartGestureListener;
import wrg.com.klinedemo.Util.MyBarChart;
import wrg.com.klinedemo.Util.MyUtils;
import wrg.com.klinedemo.Util.OrderData;
import wrg.com.klinedemo.Util.VolFormatter;
import wrg.com.klinedemo.Util.getCand;

import static wrg.com.klinedemo.R.color.ma10;
import static wrg.com.klinedemo.R.color.ma20;
import static wrg.com.klinedemo.R.color.ma5;

/**
 * Created by 翁 on 2017/3/17.
 */

public class MonthFragment extends BaseFragment {
    @Bind(R.id.combinedChart)
    CombinedChart mChart;

    @Bind(R.id.barChart)
    MyBarChart barChart;

    private CandleData candleData;
    private CombinedData combinedData;
    private ArrayList<String> xVals;
    private List<CandleEntry> candleEntries = new ArrayList<>();

    private List<CandleEntry> candleEntriesKline;
    private List<KlineEntity.DataBean> KlineAlldata;
    private LineData lineData;
    private XAxis xAxisBar;
    private YAxis axisLeftBar;
    private YAxis axisRightBar;

    //BarDataSet barDataSet;


    @Override
    protected int getContentId() {
        return R.layout.fragment_month;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            barChart.setAutoScaleMinMaxEnabled(true);
            mChart.setAutoScaleMinMaxEnabled(true);

            mChart.notifyDataSetChanged();
            barChart.notifyDataSetChanged();

            mChart.invalidate();
            barChart.invalidate();

        }
    };

    @Override
    protected void init(View view) {
        super.init(view);

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        mChart.setDescription("");
        mChart.setDrawBorders(true);//加边框
        mChart.setBorderWidth(0.3f);//边框的宽度
        mChart.setDrawGridBackground(true);
        mChart.setBackgroundColor(getResources().getColor(R.color.common_white));
        mChart.setGridBackgroundColor(getResources().getColor(R.color.common_white));
        mChart.setScaleYEnabled(false);
        mChart.setDrawValueAboveBar(false);
        mChart.setPinchZoom(false);//能否同时缩放
        mChart.setDoubleTapToZoomEnabled(false);//双击放大否
        mChart.setNoDataText("加载中...");
        mChart.setAutoScaleMinMaxEnabled(true);
        mChart.setDragEnabled(true);
        mChart.setDragDecelerationEnabled(false);//是否会有惯性滚动
        // mChart.setDragDecelerationFrictionCoef(0.5f);
        mChart.setDrawOrder(new CombinedChart.DrawOrder[]{CombinedChart.DrawOrder.CANDLE, CombinedChart.DrawOrder.LINE});


        //柱状图
        barChart.setDrawBorders(true);
        barChart.setTouchEnabled(true);
        barChart.setDoubleTapToZoomEnabled(false);//双击放大否
        barChart.setPinchZoom(false);//能否同时缩放
        barChart.setNoDataText("加载中...");
        barChart.setDragDecelerationEnabled(false);//是否会有惯性滚动
        //barChart.setDragDecelerationFrictionCoef(0.5f);
        barChart.setBorderWidth(0.5f);
        barChart.setBorderColor(getResources().getColor(R.color.common_white));
        barChart.setDescription("");
        barChart.setDragEnabled(true);
        barChart.setScaleYEnabled(true);


        Legend barChartLegend = barChart.getLegend();
        barChartLegend.setEnabled(false);


        //X轴
        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);
        xAxis.setGridColor(getResources().getColor(R.color.text_grey_light));
        xAxis.setTextColor(getResources().getColor(R.color.common_divider));
        xAxis.setSpaceBetweenLabels(4);
        //Y轴
        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setLabelCount(4, false);
        leftAxis.setDrawGridLines(true);
        leftAxis.setDrawAxisLine(true);
        leftAxis.setGridColor(getResources().getColor(R.color.text_grey_light));
        leftAxis.setTextColor(getResources().getColor(R.color.common_divider));

        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setEnabled(false);//设置是否左右两边

        //bar x y轴
        xAxisBar = barChart.getXAxis();
        xAxisBar.setDrawLabels(false);
        xAxisBar.setDrawGridLines(false);

        axisLeftBar = barChart.getAxisLeft();
        axisLeftBar.setDrawGridLines(false);


        axisRightBar = barChart.getAxisRight();
        axisRightBar.setDrawGridLines(false);


        int[] colors = {getResources().getColor(ma5), getResources().getColor(ma10), getResources().getColor(ma20)};
        String[] labels = {"MA5", "MA10", "MA20"};
        Legend legend = mChart.getLegend();
        legend.setCustom(colors, labels);
        legend.setPosition(Legend.LegendPosition.ABOVE_CHART_RIGHT);
        legend.setTextColor(Color.BLACK);
        //关键点 联动
        // 将K线控的滑动事件传递给柱状图控件
        mChart.setOnChartGestureListener(new CoupleChartGestureListener(mChart, new Chart[]{barChart}));
        // 将柱状图的滑动事件传递给K线控件
        barChart.setOnChartGestureListener(new CoupleChartGestureListener(barChart, new Chart[]{mChart}));

        //高亮的联动
        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry entry, int i, Highlight highlight) {
                CandleEntry candleEntry = (CandleEntry) entry;
                float change = (candleEntry.getClose() - candleEntry.getOpen()) / candleEntry.getOpen();
                NumberFormat nf = NumberFormat.getPercentInstance();
                nf.setMaximumFractionDigits(2);
                String changePercentage = nf.format(Double.valueOf(String.valueOf(change)));
                //high.setText(candleEntry.getHigh() + "");
                // low.setText(candleEntry.getLow() + "");
             /*   Toast.makeText(getApplicationContext(), "最高" + candleEntry.getHigh() + " 最低" + candleEntry.getLow() +
                        " 开盘" + candleEntry.getOpen() + " 收盘" + candleEntry.getClose() +
                        " 涨跌幅" + changePercentage, Toast.LENGTH_SHORT).show();*/
                barChart.highlightValues(new Highlight[]{highlight});

            }

            @Override
            public void onNothingSelected() {
                barChart.highlightValue(null);
            }
        });

        //高亮的联动
        barChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                mChart.highlightValues(new Highlight[]{h});
            }

            @Override
            public void onNothingSelected() {
                mChart.highlightValue(null);
            }
        });


    }

    private float culcMaxscale(float count) {
        float max = 1;
        max = count / 127 * 5;
        return max;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEventData(List<KlineEntity.DataBean> klineAlldata) {
        if (klineAlldata.get(0).getState().equals("month")) {
            List<KlineEntity.DataBean> pastToNowData = OrderData.getPastToNowData(klineAlldata);
            mChart.resetTracking();
            barChart.resetTracking();

            candleEntriesKline = getCand.getCandleEntries(pastToNowData, 0);
            Log.d("print", "onSuccess: 处理好之后的数据" + candleEntries.toString());

            xVals = new ArrayList<>();
            for (int i = 0; i < pastToNowData.size(); i++) {
                xVals.add(pastToNowData.get(i).getTrdDt().substring(5, 10));
            }
            combinedData = new CombinedData(xVals);

            candleData = generateCandleData(candleEntriesKline, "");
            combinedData.setData(candleData);//此处加入K线图的数据

            //柱状图塞入数据
            //axisLeftBar.setAxisMaxValue((float) pastToNowData.get(0).getTrdAmt()/100000);//设置高度
            //axisLeftBar.setAxisMinValue(0);//即使最小是不是0，也无碍
            axisLeftBar.setShowOnlyMinMax(true);

            //axisRightBar.setAxisMaxValue(pastToNowData.get(0).getTrdDt());
            //axisRightBar.setAxisMinValue(0);//即使最小是不是0，也无碍
            axisRightBar.setShowOnlyMinMax(true);

            String unit = MyUtils.getVolUnit(combinedData.getYMax());
            Log.d("print", "getEventData:万手亿手 " + unit);
            int u = 1;
            if ("万手".equals(unit)) {
                u = 4;
            } else if ("亿手".equals(unit)) {
                u = 8;
            }
            axisLeftBar.setValueFormatter(new VolFormatter((int) Math.pow(10000000, u)));
            axisRightBar.setValueFormatter(new VolFormatter((int) Math.pow(10000000, u)));
            //插入柱状图的数据
            ArrayList<BarEntry> barEntries = new ArrayList<>();
            for (int i = 0; i < pastToNowData.size(); i++) {
                barEntries.add(new BarEntry((float) pastToNowData.get(i).getTrdVol(), i));
            }

            BarDataSet barDataSet = generateBarDataSet(barEntries, getResources().getColor(R.color.KlineRed), "");


            ArrayList<BarDataSet> barDataSets = new ArrayList<>();
            barDataSets.add(barDataSet); // add the datasets


            BarData barData = new BarData(xVals, barDataSet);
            barChart.setData(barData);


            //MD5 MD10 MD20


            ArrayList<Entry> ma5Entries = new ArrayList<>();
            for (int index = 0; index < candleEntries.size(); index++) {
                ma5Entries.add(new Entry(candleEntriesKline.get(index).getOpen(), index));
            }

            ArrayList<Entry> ma10Entries = new ArrayList<>();
            for (int index = 0; index < candleEntries.size(); index++) {
                ma10Entries.add(new Entry(candleEntriesKline.get(index).getHigh(), index));

            }

            ArrayList<Entry> ma20Entries = new ArrayList<>();
            for (int index = 0; index < candleEntries.size(); index++) {
                ma20Entries.add(new Entry(candleEntriesKline.get(index).getLow(), index));

            }

            lineData = generateMultiLineData(
                    generateLineDataSet(ma5Entries, getResources().getColor(ma5), "ma5"),
                    generateLineDataSet(ma10Entries, getResources().getColor(ma10), "ma10"),
                    generateLineDataSet(ma20Entries, getResources().getColor(ma20), "ma20"));


            Log.d("print", "onSuccess: 分时图的的数据" + lineData.toString());
            //combinedData.setData(lineData);

            mChart.setData(combinedData);//当前屏幕会显示所有的数据
            new MyUtils(getContext()).setOff(mChart, barChart);
            handler.sendEmptyMessageDelayed(0, 100);


        }
    }


    private CandleData generateCandleData(List<CandleEntry> candleEntriesKline, String label) {

        CandleDataSet set = new CandleDataSet(candleEntriesKline, label);
        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        set.setShadowWidth(0.5f);
        set.setDecreasingColor(getResources().getColor(R.color.KlineGreen));
        set.setDecreasingPaintStyle(Paint.Style.FILL);
        set.setIncreasingColor(getResources().getColor(R.color.KlineRed));
        set.setIncreasingPaintStyle(Paint.Style.STROKE);
        set.setNeutralColor(Color.RED);
        set.setShadowColorSameAsCandle(true);
        set.setHighlightLineWidth(0.3f);
        //十字线的颜色
        set.setHighLightColor(Color.BLACK);
        set.setDrawValues(false);//在图标上是否显示数值
        CandleData candleData = new CandleData(xVals);
        candleData.addDataSet(set);

        return candleData;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    //柱状图的设置
    public BarDataSet generateBarDataSet(List<BarEntry> barEntries, int color, String label) {
        BarDataSet barDataSet = new BarDataSet(barEntries, label);
        barDataSet = new BarDataSet(barEntries, "成交量");
        barDataSet.setBarSpacePercent(20); //bar空隙
        barDataSet.setHighlightEnabled(true);
        barDataSet.setHighLightAlpha(500);
        barDataSet.setHighLightColor(Color.BLACK);
        barDataSet.setDrawValues(false);//是否在柱状图上显示数值
        barDataSet.setColor(color);
        return barDataSet;

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
        for (int i = 0; i < candleEntries.size(); i++) {
            xVals.add("" + (1990 + i));
        }

        LineData data = new LineData(xVals, dataSets);

        return data;
    }


    public BarData generateMultiBarData(BarDataSet... barDataSets) {

        List<IBarDataSet> dataSets = new ArrayList<>();
        for (int i = 0; i < barDataSets.length; i++) {
            dataSets.add(barDataSets[i]);
        }

        List<String> xVals = new ArrayList<>();
        for (int i = 0; i < candleEntries.size(); i++) {
            xVals.add("" + (1990 + i));
        }

        BarData data = new BarData(xVals, dataSets);

        return data;
    }

    //设置量表对齐
    private void setOffset() {
        float lineLeft = mChart.getViewPortHandler().offsetLeft();
        float barLeft = barChart.getViewPortHandler().offsetLeft();
        float lineRight = mChart.getViewPortHandler().offsetRight();
        float barRight = barChart.getViewPortHandler().offsetRight();
        float barBottom = barChart.getViewPortHandler().offsetBottom();
        float offsetLeft, offsetRight;
        float transLeft = 0, transRight = 0;
        if (barLeft < lineLeft) {
            offsetLeft = Utils.convertPixelsToDp(lineLeft - barLeft);
            barChart.setExtraLeftOffset(offsetLeft);
            transLeft = lineLeft;
        } else {
            offsetLeft = Utils.convertPixelsToDp(barLeft - lineLeft);
            mChart.setExtraLeftOffset(offsetLeft);
            transLeft = barLeft;
        }
        if (barRight < lineRight) {
            offsetRight = Utils.convertPixelsToDp(lineRight);
            barChart.setExtraRightOffset(offsetRight);
            transRight = lineRight;
        } else {
            offsetRight = Utils.convertPixelsToDp(barRight);
            mChart.setExtraRightOffset(offsetRight);
            transRight = barRight;
        }
        barChart.setViewPortOffsets(transLeft, 15, transRight, barBottom);
    }


}
