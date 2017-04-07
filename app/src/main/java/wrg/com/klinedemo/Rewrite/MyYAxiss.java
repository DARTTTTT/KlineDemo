package wrg.com.klinedemo.Rewrite;

import com.github.mikephil.charting.components.YAxis;

/**
 * Created by 翁 on 2017/3/24.
 */

public class MyYAxiss extends YAxis {
    private float baseValue=Float.NaN;
    private String minValue;
    public MyYAxiss() {
        super();
    }
    public MyYAxiss(AxisDependency axis) {
        super(axis);
    }
    public void setShowMaxAndUnit(String minValue) {
        setShowOnlyMinMax(true);
        this.minValue = minValue;
    }
    public float getBaseValue() {
        return baseValue;
    }

    public String getMinValue(){
        return minValue;
    }
    public void setBaseValue(float baseValue) {
        this.baseValue = baseValue;
    }
}
