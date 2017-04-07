package wrg.com.klinedemo.Rewrite;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;

import wrg.com.klinedemo.Util.MyYAxis;

/**
 * Created by 翁 on 2017/3/24.
 */

public class MyBarCharts extends BarChart {

    private MyLeftMarkerView myMarkerViewLeft;
    private MyRightMarkerView myMarkerViewRight;
    private MyBottomMarkerView mMyBottomMarkerView;

    public MyBarCharts(Context context) {
        super(context);
    }

    public MyBarCharts(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyBarCharts(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setMarker(MyLeftMarkerView markerLeft, MyRightMarkerView markerRight, MyBottomMarkerView markerBottom) {
        this.myMarkerViewLeft = markerLeft;
        this.myMarkerViewRight = markerRight;
        this.mMyBottomMarkerView = markerBottom;
        //this.minuteHelper = minuteHelper;
    }

    @Override
    protected void init() {
        super.init();
        /*此处不能重新示例*/
        mXAxis = new MyXAxiss();
        mAxisLeft = new MyYAxis(YAxis.AxisDependency.LEFT);
        mXAxisRenderer = new MyXAxisRenderers(mViewPortHandler, (MyXAxiss) mXAxis, mLeftAxisTransformer, this);
        mAxisRight = new MyYAxis(YAxis.AxisDependency.RIGHT);
        mAxisRendererLeft = new MyYAxisRenderers(mViewPortHandler, (MyYAxiss) mAxisLeft, mLeftAxisTransformer);
        mAxisRendererRight = new MyYAxisRenderers(mViewPortHandler, (MyYAxiss) mAxisRight, mRightAxisTransformer);

    }

    @Override
    protected void calcModulus() {

        mXAxis.mAxisLabelModulus = 1;
    }

    /*返回转型后的左右轴*/
    @Override
    public MyYAxis getAxisLeft() {
        return (MyYAxis) super.getAxisLeft();
    }

    @Override
    public MyXAxiss getXAxis() {
        return (MyXAxiss) super.getXAxis();
    }


    @Override
    public MyYAxis getAxisRight() {
        return (MyYAxis) super.getAxisRight();
    }

    public void setHighlightValue(Highlight h) {
        mIndicesToHighlight = new Highlight[]{
                h};
    }

    @Override
    protected void drawMarkers(Canvas canvas) {
        if (!mDrawMarkerViews || !valuesToHighlight())
            return;
        for (int i = 0; i < mIndicesToHighlight.length; i++) {
            Highlight highlight = mIndicesToHighlight[i];
            int xIndex = mIndicesToHighlight[i].getXIndex();
            int dataSetIndex = mIndicesToHighlight[i].getDataSetIndex();
            float deltaX = mXAxis != null
                    ? mXAxis.mAxisRange
                    : ((mData == null ? 0.f : mData.getXValCount()) - 1.f);
            if (xIndex <= deltaX && xIndex <= deltaX * mAnimator.getPhaseX()) {
                Entry e = mData.getEntryForHighlight(mIndicesToHighlight[i]);
                // make sure entry not null
                if (e == null || e.getXIndex() != mIndicesToHighlight[i].getXIndex())
                    continue;
                float[] pos = getMarkerPosition(e, highlight);
                // check bounds
                if (!mViewPortHandler.isInBounds(pos[0], pos[1]))
                    continue;

                //String time = minuteHelper.getDatas().get(mIndicesToHighlight[i].getXIndex()).time;
                //mMyBottomMarkerView.setData(time);
                mMyBottomMarkerView.refreshContent(e, mIndicesToHighlight[i]);
                /*修复bug*/
                // invalidate();
                /*重新计算大小*/
                mMyBottomMarkerView.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
                        MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
                mMyBottomMarkerView.layout(0, 0, mMyBottomMarkerView.getMeasuredWidth(),
                        mMyBottomMarkerView.getMeasuredHeight());


                mMyBottomMarkerView.draw(canvas, pos[0]-mMyBottomMarkerView.getWidth()/2, mViewPortHandler.contentBottom());
            }
        }
    }
}
