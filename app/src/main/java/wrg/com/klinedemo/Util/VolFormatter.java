package wrg.com.klinedemo.Util;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.formatter.YAxisValueFormatter;

import java.text.DecimalFormat;

/**
 * Created by 翁 on 2017/3/23.
 */

public class VolFormatter implements YAxisValueFormatter {
    private final int unit;
    private DecimalFormat mFormat;
    private String u;
    public VolFormatter(int unit) {
        if (unit == 1) {
            mFormat = new DecimalFormat("#0.00");
        } else {
            mFormat = new DecimalFormat("#0.00");
        }
        this.unit = unit;
        this.u=MyUtils.getVolUnit(unit);
    }


    @Override
    public String getFormattedValue(float value, YAxis yAxis) {
        value = value / unit;
        if(value==0){
            return u;
        }
        return mFormat.format(value);
    }
}
