package wrg.com.klinedemo.Rewrite;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.formatter.YAxisValueFormatter;

/**
 * Created by 翁 on 2017/3/27.
 */

public class CustomYAxisFormatter implements YAxisValueFormatter {
    private static final int TEN_THOUSAND = 10000;
    private static final int HUNDRED_MILLION = 100000000;

    private String unit;
    private int divisor;

    public CustomYAxisFormatter(float maxVolume) {
        this.unit = getUnit(maxVolume);
        this.divisor = getDivisor(maxVolume);
    }

    @Override
    public String getFormattedValue(float value, YAxis yAxis) {
        if (value == 0) {
//坐标原点，显示单位（股/万股/亿股）
            return unit;
        }
        return String.format("%.2f", value / divisor);
    }

    /** 根据最大值的大小来确定单位*/
    public String getUnit(double num) {
        int e = (int) Math.floor(Math.log10(num));
        if (e >= 8) {
            return "亿股";
        } else if (e >= 4) {
            return "万股";
        } else {
            return "股";
        }
    }

    /** 根据最大值的大小来确定除数*/
    public int getDivisor(float maxValue) {
        int e = (int) Math.floor(Math.log10(maxValue));
        if (e >= 8) {
            return HUNDRED_MILLION;
        } else if (e >= 4) {
            return TEN_THOUSAND;
        } else {
            return 1;
        }
    }
}
