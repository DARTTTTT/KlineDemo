package wrg.com.klinedemo.Rewrite;

/**
 * Created by 翁 on 2017/3/27.
 */


import android.content.Context;
import android.util.AttributeSet;

import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.renderer.LineChartRenderer;

/**
 * Chart that draws lines, surfaces, circles, ...
 *
 * @author Philipp Jahoda
 */
public class MyLineChart extends BarLineChartBase<LineData> implements LineDataProvider {

    public MyLineChart(Context context) {
        super(context);
    }

    public MyLineChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLineChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }





    @Override
    public MyLineXAxis getXAxis() {
        return (MyLineXAxis) super.getXAxis();
    }


    @Override
    protected void init() {
        super.init();
        mXAxis = new MyLineXAxis();
        mXAxisRenderer = new MyLineXAxisRenderer(mViewPortHandler,(MyLineXAxis) mXAxis, mLeftAxisTransformer, this);
        mRenderer = new LineChartRenderer(this, mAnimator, mViewPortHandler);
    }

    @Override
    protected void calcMinMax() {
        super.calcMinMax();

        if (mXAxis.mAxisRange == 0 && mData.getYValCount() > 0)
            mXAxis.mAxisRange = 1;
    }

    @Override
    public LineData getLineData() {
        return mData;
    }

    @Override
    protected void onDetachedFromWindow() {
        // releases the bitmap in the renderer to avoid oom error
        if(mRenderer != null && mRenderer instanceof LineChartRenderer) {
            ((LineChartRenderer) mRenderer).releaseBitmap();
        }
        super.onDetachedFromWindow();
    }
}

