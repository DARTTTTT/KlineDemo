package wrg.com.klinedemo.Fragment;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import wrg.com.klinedemo.Base.BaseFragment;
import wrg.com.klinedemo.Entity.KlineEntity;
import wrg.com.klinedemo.Entity.MinuteEntity;
import wrg.com.klinedemo.R;
import wrg.com.klinedemo.Rewrite.LargeValueFormatter;
import wrg.com.klinedemo.Rewrite.MyLineChart;
import wrg.com.klinedemo.Util.MyBarChart;

/**
 * Created by 翁 on 2017/3/24.
 */

public class MinuteFragments extends BaseFragment {

    @Bind(R.id.lineChart)
    MyLineChart lineChart;

    @Bind(R.id.barChart)
    MyBarChart barChart;

    private ArrayList<String> xVals;
    private List<CandleEntry> candleEntries = new ArrayList<>();

    private List<CandleEntry> candleEntriesKline;
    private List<KlineEntity.DataBean> KlineAlldata;
    private XAxis xAxisBar;
    private YAxis axisLeftBar;
    private YAxis axisRightBar;
    private CombinedData combinedData;


    @Override
    protected int getContentId() {
        return R.layout.fragment_fiveminute;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            barChart.setAutoScaleMinMaxEnabled(true);
            lineChart.setAutoScaleMinMaxEnabled(true);

            lineChart.notifyDataSetChanged();
            barChart.notifyDataSetChanged();

            lineChart.invalidate();
            barChart.invalidate();

        }
    };

    @Override
    protected void init(View view) {
        super.init(view);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }

        //分时图
        lineChart.setDoubleTapToZoomEnabled(false);
        lineChart.setBackgroundColor(getResources().getColor(R.color.common_white));
        lineChart.setScaleEnabled(true);
        lineChart.setDrawBorders(true);
        lineChart.setBorderWidth(0.3f);
        lineChart.setBorderColor(getResources().getColor(R.color.common_black));
        lineChart.setDescription("");
        lineChart.setEnabled(true);
        Legend lineChartLegend = lineChart.getLegend();
        lineChartLegend.setEnabled(false);//下面是否显示成交量
        XAxis xAxis=lineChart.getXAxis();
        xAxis.setDrawGridLines(true);//横的线
        xAxis.setDrawAxisLine(true);
        xAxis.setEnabled(true);
        xAxis.setDrawLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//事件点在底部
        //柱状图
        barChart.setDrawBorders(true);
        barChart.setTouchEnabled(true);
        barChart.setDoubleTapToZoomEnabled(false);//双击放大否
        barChart.setPinchZoom(false);//能否同时缩放
        barChart.setNoDataText("加载中...");
        barChart.setDragDecelerationEnabled(false);//是否会有惯性滚动
        barChart.setBorderWidth(0.5f);
        barChart.setBorderColor(getResources().getColor(R.color.common_white));
        barChart.setDescription("");
        barChart.setDragEnabled(true);
        barChart.setScaleYEnabled(true);
        //barChart.setVisibleXRangeMinimum(100);

        Legend barChartLegend = barChart.getLegend();
        barChartLegend.setEnabled(false);

        //bar x y轴
        xAxisBar = barChart.getXAxis();
        xAxisBar.setDrawLabels(false);
        xAxisBar.setDrawGridLines(false);

        axisLeftBar = barChart.getAxisLeft();
        axisLeftBar.setDrawGridLines(false);


        axisRightBar = barChart.getAxisRight();
        axisRightBar.setDrawGridLines(false);

        lineChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                float val = e.getVal();
                Toast.makeText(getContext(), (int) val,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEventData(List<MinuteEntity.DataBean> pastToNowMinuteData) {
        switch (pastToNowMinuteData.get(0).getState()) {
            case "fenshi":
                lineChart.resetTracking();
                barChart.resetTracking();


                ArrayList<Entry> lineCJEntries = new ArrayList<>();
                ArrayList<Entry> lineJJEntries = new ArrayList<>();
                ArrayList<String> xVals = new ArrayList<>();
                for (int i = 0; i < pastToNowMinuteData.size(); i++) {
                    if (pastToNowMinuteData.get(i).getTrdTm().substring(11, pastToNowMinuteData.get(0).getTrdTm().length() - 3).equals("13:30")) {
                        continue;
                    }
                    lineCJEntries.add(new Entry((float) pastToNowMinuteData.get(i).getLastPx(), i));
                    xVals.add(pastToNowMinuteData.get(i).getTrdTm().substring(11, pastToNowMinuteData.get(0).getTrdTm().length() - 3));
                }

                LineDataSet dataSet = generateLineDataSet(lineCJEntries, "成交量");
                LineData lineData = new LineData(xVals, dataSet);


                lineChart.setData(lineData);
                handler.sendEmptyMessageDelayed(0, 100);

             /*   //柱状图塞入数据
                axisLeftBar.setShowOnlyMinMax(true);

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
                for (int i = 0; i < pastToNowMinuteData.size(); i++) {
                    barEntries.add(new BarEntry((float) pastToNowMinuteData.get(i).getTrdVol(), i));
                }

                BarDataSet barDataSet = generateBarDataSet(barEntries, getResources().getColor(R.color.KlineRed), "");


                ArrayList<BarDataSet> barDataSets = new ArrayList<>();
                barDataSets.add(barDataSet); // add the datasets


                BarData barData = new BarData(xVals, barDataSet);
                barChart.setData(barData);
                handler.sendEmptyMessageDelayed(0, 100);*/

                break;

        }
    }

   /* private LineDataSet generateCandleData(List<Entry> yVals, String label) {

        LineDataSet set = new LineDataSet(yVals, label);
        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        set.



    }
*/

   //分时图的设置
    public LineDataSet generateLineDataSet(List<Entry> lineCJEntries,String labels){
        LineDataSet dataSet = new LineDataSet(lineCJEntries, labels);
        dataSet.setCircleColor(getResources().getColor(R.color.KlineRed));
        dataSet.setColor(getResources().getColor(R.color.KlineRed));
        dataSet.setCircleRadius(0.1f);
        dataSet.setValueTextSize(5f);
        dataSet.setValueFormatter(new LargeValueFormatter());
        dataSet.setHighlightEnabled(true);
        dataSet.setHighLightColor(getResources().getColor(R.color.common_black));//交叉线的颜色
        dataSet.setDrawValues(true);//值是否都显示
        ArrayList<ILineDataSet> sets = new ArrayList<>();
        sets.add(dataSet);
        return dataSet;

    }


    //柱状图的设置
    public BarDataSet generateBarDataSet(List<BarEntry> barEntries, int color, String label) {
        BarDataSet barDataSet = new BarDataSet(barEntries, label);
        barDataSet = new BarDataSet(barEntries, label);
        barDataSet.setBarSpacePercent(20); //bar空隙
        barDataSet.setHighlightEnabled(true);
        barDataSet.setHighLightAlpha(500);
        barDataSet.setHighLightColor(Color.BLACK);
        barDataSet.setDrawValues(false);//是否在柱状图上显示数值
        barDataSet.setColor(color);
        return barDataSet;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
