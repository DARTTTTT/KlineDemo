package wrg.com.klinedemo.Rewrite;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;

import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.renderer.XAxisRenderer;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.List;

public class MyLineXAxisRenderer extends XAxisRenderer {

    private final BarLineChartBase mChart;
    private MyLineXAxis mXAxis;

    public MyLineXAxisRenderer(ViewPortHandler viewPortHandler, MyLineXAxis xAxis, Transformer trans, BarLineChartBase chart) {
        super(viewPortHandler, xAxis, trans);
        mXAxis = xAxis;
        mChart = chart;
    }

    @Override
    protected void drawLabels(Canvas c, float pos, PointF anchor) {
        final float labelRotationAngleDegrees = mXAxis.getLabelRotationAngle();

        // pre allocate to save performance (dont allocate in loop)
        float[] position = new float[]{
                0f, 0f
        };

        for (int i = mMinX; i <= mMaxX; i += mXAxis.mAxisLabelModulus) {

            position[0] = i;

            mTrans.pointValuesToPixel(position);

            if (mViewPortHandler.isInBoundsX(position[0])) {

                String label = mXAxis.getValues().get(i);
                //文本长度
                int labelWidth = Utils.calcTextWidth(mAxisLabelPaint, label);
                //右出界
                if ((labelWidth / 2 + position[0]) > mChart.getViewPortHandler().contentRight()) {
                    position[0] = mChart.getViewPortHandler().contentRight() - labelWidth / 2;
                } else if ((position[0] - labelWidth / 2) < mChart.getViewPortHandler().contentLeft()) {//左出界
                    position[0] = mChart.getViewPortHandler().contentLeft() + labelWidth / 2;
                }
                c.drawText(label, position[0],
                        pos+20,
                        mAxisLabelPaint);
            }
        }

    }




    /*@Override
    protected void drawLabels(Canvas c, float pos, PointF anchor) {
        float[] position = new float[]{
                0f, 0f
        };
        int count = mXAxis.getValues().size();
        Log.d("print", "drawLabels: "+count);
        for (int i = 0; i < count; i ++) {
              //获取label对应key值，也就是x轴坐标0,60,121,182,242
            int ix= Integer.parseInt(mXAxis.getValues().get(i));
            //int ix = Integer.parseInt(mXAxis.getValues().get(i));
            Log.d("print", "drawLabels: 截的数据"+ix);
            position[0] = ix;
            //在图表中的x轴转为像素，方便绘制text
            mTrans.pointValuesToPixel(position);
            //x轴越界
            if (mViewPortHandler.isInBoundsX(position[0])) {
                String label = mXAxis.getValues().get(i);
                //文本长度
                int labelWidth = Utils.calcTextWidth(mAxisLabelPaint, label);
                //右出界
                if ((labelWidth / 2 + position[0]) > mChart.getViewPortHandler().contentRight()) {
                    position[0] = mChart.getViewPortHandler().contentRight() - labelWidth / 2;
                } else if ((position[0] - labelWidth / 2) < mChart.getViewPortHandler().contentLeft()) {//左出界
                    position[0] = mChart.getViewPortHandler().contentLeft() + labelWidth / 2;
                }
                c.drawText(label, position[0],
                        pos+ Utils.convertPixelsToDp(mChart.getViewPortHandler().offsetBottom()),
                        mAxisLabelPaint);
            }

        }
    }*/

    protected void drawLabel(Canvas c, String label, int xIndex, float x, float y, PointF anchor, float angleDegrees) {
        String formattedLabel = mXAxis.getValueFormatter().getXValue(label, xIndex, mViewPortHandler);
        Utils.drawText(c, formattedLabel, x, y, mAxisLabelPaint, anchor, angleDegrees);
    }


    /**
     * Draws the LimitLines associated with this axis to the screen.
     *
     * @param c
     */
    @Override
    public void renderLimitLines(Canvas c) {

        List<LimitLine> limitLines = mXAxis.getLimitLines();

        if (limitLines == null || limitLines.size() <= 0)
            return;

        float[] position = new float[2];

        for (int i = 0; i < limitLines.size(); i++) {

            LimitLine l = limitLines.get(i);

            if (!l.isEnabled())
                continue;

            position[0] = l.getLimit();
            position[1] = 0.f;

            mTrans.pointValuesToPixel(position);

            renderLimitLineLine(c, l, position);
            renderLimitLineLabel(c, l, position, 2.f + l.getYOffset());
        }
    }

    float[] mLimitLineSegmentsBuffer = new float[4];
    private Path mLimitLinePath = new Path();

    public void renderLimitLineLine(Canvas c, LimitLine limitLine, float[] position) {
        mLimitLineSegmentsBuffer[0] = position[0];
        mLimitLineSegmentsBuffer[1] = mViewPortHandler.contentTop();
        mLimitLineSegmentsBuffer[2] = position[0];
        mLimitLineSegmentsBuffer[3] = mViewPortHandler.contentBottom();

        mLimitLinePath.reset();
        mLimitLinePath.moveTo(mLimitLineSegmentsBuffer[0], mLimitLineSegmentsBuffer[1]);
        mLimitLinePath.lineTo(mLimitLineSegmentsBuffer[2], mLimitLineSegmentsBuffer[3]);

        mLimitLinePaint.setStyle(Paint.Style.STROKE);
        mLimitLinePaint.setColor(limitLine.getLineColor());
        mLimitLinePaint.setStrokeWidth(limitLine.getLineWidth());
        mLimitLinePaint.setPathEffect(limitLine.getDashPathEffect());

        c.drawPath(mLimitLinePath, mLimitLinePaint);
    }

    public void renderLimitLineLabel(Canvas c, LimitLine limitLine, float[] position, float yOffset) {
        String label = limitLine.getLabel();

        // if drawing the limit-value label is enabled
        if (label != null && !label.equals("")) {

            mLimitLinePaint.setStyle(limitLine.getTextStyle());
            mLimitLinePaint.setPathEffect(null);
            mLimitLinePaint.setColor(limitLine.getTextColor());
            mLimitLinePaint.setStrokeWidth(0.5f);
            mLimitLinePaint.setTextSize(limitLine.getTextSize());

            float xOffset = limitLine.getLineWidth() + limitLine.getXOffset();

            final LimitLine.LimitLabelPosition labelPosition = limitLine.getLabelPosition();

            if (labelPosition == LimitLine.LimitLabelPosition.RIGHT_TOP) {

                final float labelLineHeight = Utils.calcTextHeight(mLimitLinePaint, label);
                mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
                c.drawText(label, position[0] + xOffset, mViewPortHandler.contentTop() + yOffset + labelLineHeight, mLimitLinePaint);
            } else if (labelPosition == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {

                mLimitLinePaint.setTextAlign(Paint.Align.LEFT);
                c.drawText(label, position[0] + xOffset, mViewPortHandler.contentBottom() - yOffset, mLimitLinePaint);
            } else if (labelPosition == LimitLine.LimitLabelPosition.LEFT_TOP) {

                mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
                final float labelLineHeight = Utils.calcTextHeight(mLimitLinePaint, label);
                c.drawText(label, position[0] - xOffset, mViewPortHandler.contentTop() + yOffset + labelLineHeight, mLimitLinePaint);
            } else {

                mLimitLinePaint.setTextAlign(Paint.Align.RIGHT);
                c.drawText(label, position[0] - xOffset, mViewPortHandler.contentBottom() - yOffset, mLimitLinePaint);
            }
        }
    }
}
