package wrg.com.klinedemo.Rewrite;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.renderer.YAxisRenderer;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/**
 * Created by 翁 on 2017/3/27.
 */

public class CustomeYAxisRenderer extends YAxisRenderer{
    public CustomeYAxisRenderer(ViewPortHandler viewPortHandler, YAxis yAxis, Transformer trans) {
        super(viewPortHandler, yAxis, trans);
    }

    @Override
    public void computeAxis(float yMin, float yMax) {
        super.computeAxis(yMin, yMax);
        if (mYAxis.mEntryCount > 1) {
            float topLabel = Math.abs(mYAxis.mEntries[mYAxis.mEntryCount - 1]);
            mYAxis.setValueFormatter(new CustomYAxisFormatter(topLabel));
        }
    }
}
