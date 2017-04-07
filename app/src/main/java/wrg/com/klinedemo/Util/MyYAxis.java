package wrg.com.klinedemo.Util;

import com.github.mikephil.charting.components.YAxis;

/**
 * Created by 翁 on 2017/3/24.
 */

public class MyYAxis extends YAxis {

    private String minValue;

    public MyYAxis() {
        super();
    }

    public MyYAxis(AxisDependency axis) {
        super(axis);
    }

    public void setShowMaxAndUnit(String minValue) {
        setShowOnlyMinMax(true);
        this.minValue = minValue;
    }

    public String getMinValue() {
        return minValue;
    }
}
