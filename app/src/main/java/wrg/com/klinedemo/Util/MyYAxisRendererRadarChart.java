package wrg.com.klinedemo.Util;

import android.graphics.Canvas;
import android.text.TextUtils;

import com.github.mikephil.charting.renderer.YAxisRenderer;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

import wrg.com.klinedemo.Rewrite.MyYAxiss;

/**
 * Created by 翁 on 2017/3/24.
 */

public class MyYAxisRendererRadarChart  extends YAxisRenderer {

    protected MyYAxiss mYAxis;
    public MyYAxisRendererRadarChart(ViewPortHandler viewPortHandler, MyYAxiss yAxis, Transformer trans) {
        super(viewPortHandler, yAxis, trans);
        mYAxis = yAxis;
    }


    @Override
    public void computeAxis(float yMin, float yMax) {
        computeAxisValues(yMin, yMax);
    }

    @Override
    protected void computeAxisValues(float min, float max) {
        /*只显示最大最小情况下*/
        if (mYAxis.isShowOnlyMinMaxEnabled()) {
            mYAxis.mEntryCount = 2;
            mYAxis.mEntries = new float[2];
            mYAxis.mEntries[0] = min;
            mYAxis.mEntries[1] = max;
            return;
        }
        /*折线图左边没有basevalue，则调用系统*/
        if (Float.isNaN(mYAxis.getBaseValue())) {
            super.computeAxisValues(min, max);
            return;
        }
        float base = mYAxis.getBaseValue();
        float yMin = min;
        int labelCount = mYAxis.getLabelCount();
        float interval = (base - yMin) / labelCount;
        int n = labelCount * 2 + 1;
        mYAxis.mEntryCount = n;
        mYAxis.mEntries = new float[n];
        int i;
        float f;
        for (f = min, i = 0; i < n; f += interval, i++) {
            mYAxis.mEntries[i] = f;
        }
    }

    @Override
    protected void drawYLabels(Canvas c, float fixedPosition, float[] positions, float offset) {
       /*当有最小text的时候*/
        if (!TextUtils.isEmpty(mYAxis.getMinValue()) && mYAxis.isShowOnlyMinMaxEnabled()) {
            for (int i = 0; i < mYAxis.mEntryCount; i++) {
                /*获取对应位置的值*/
                String text = mYAxis.getFormattedLabel(i);
                if (i == 0) {
                    text = mYAxis.getMinValue();
                }
                if (i == 1) {
                    c.drawText(text, fixedPosition, mViewPortHandler.offsetTop()+2*offset+5 , mAxisLabelPaint);
                } else if (i == 0) {
                    c.drawText(text, fixedPosition, mViewPortHandler.contentBottom() - 3, mAxisLabelPaint);
                }
            }
        }
        else {
            for (int i = 0; i < mYAxis.mEntryCount; i++) {

                String text = mYAxis.getFormattedLabel(i);
                if (!mYAxis.isDrawTopYLabelEntryEnabled() && i >= mYAxis.mEntryCount - 1)
                    return;

                int labelHeight = Utils.calcTextHeight(mAxisLabelPaint, text);
                float pos = positions[i * 2 + 1] + offset;

                if ((pos - labelHeight) < mViewPortHandler.contentTop()) {

                    pos = mViewPortHandler.contentTop() + offset * 2.5f + 3;
                } else if ((pos + labelHeight / 2) > mViewPortHandler.contentBottom()) {
                    pos = mViewPortHandler.contentBottom() - 3;
                }
                c.drawText(text, fixedPosition, pos, mAxisLabelPaint);
            }


        }
    }

  /*  @Override
    public void renderAxisLabels(Canvas c) {

        if (!mYAxis.isEnabled() || !mYAxis.isDrawLabelsEnabled())
            return;

        mAxisLabelPaint.setTypeface(mYAxis.getTypeface());
        mAxisLabelPaint.setTextSize(mYAxis.getTextSize());
        mAxisLabelPaint.setColor(mYAxis.getTextColor());

        PointF center = mChart.getCenterOffsets();
        float factor = mChart.getFactor();

        int labelCount = mYAxis.mEntryCount;

        for (int j = 0; j < labelCount; j++) {

            if (j == labelCount - 1 && mYAxis.isDrawTopYLabelEntryEnabled() == false)
                break;

            float r = (mYAxis.mEntries[j] - mYAxis.mAxisMinimum) * factor;

            PointF p = Utils.getPosition(center, r, mChart.getRotationAngle());

            String label = mYAxis.getFormattedLabel(j);

            c.drawText(label, p.x + 10, p.y, mAxisLabelPaint);
        }
    }

    @Override
    public void renderLimitLines(Canvas c) {

        List<LimitLine> limitLines = mYAxis.getLimitLines();

        if (limitLines == null)
            return;

        float sliceangle = mChart.getSliceAngle();

        // calculate the factor that is needed for transforming the value to
        // pixels
        float factor = mChart.getFactor();

        PointF center = mChart.getCenterOffsets();

        for (int i = 0; i < limitLines.size(); i++) {

            LimitLine l = limitLines.get(i);

            if (!l.isEnabled())
                continue;

            mLimitLinePaint.setColor(l.getLineColor());
            mLimitLinePaint.setPathEffect(l.getDashPathEffect());
            mLimitLinePaint.setStrokeWidth(l.getLineWidth());

            float r = (l.getLimit() - mChart.getYChartMin()) * factor;

            Path limitPath = new Path();

            for (int j = 0; j < mChart.getData().getXValCount(); j++) {

                PointF p = Utils.getPosition(center, r, sliceangle * j + mChart.getRotationAngle());

                if (j == 0)
                    limitPath.moveTo(p.x, p.y);
                else
                    limitPath.lineTo(p.x, p.y);
            }

            limitPath.close();

            c.drawPath(limitPath, mLimitLinePaint);
        }
    }*/
}
