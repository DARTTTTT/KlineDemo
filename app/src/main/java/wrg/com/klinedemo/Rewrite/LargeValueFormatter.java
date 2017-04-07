package wrg.com.klinedemo.Rewrite;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.formatter.YAxisValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;

/**
 * Created by 翁 on 2017/3/29.
 */

public class LargeValueFormatter implements ValueFormatter, YAxisValueFormatter {
    private static String[] SUFFIX = new String[]{
            "", "千", "百万", "十亿", "t"
    };
    private static final int MAX_LENGTH = 4;
    private DecimalFormat mFormat;
    private String mText = "";

    public LargeValueFormatter() {
        mFormat = new DecimalFormat("###E0");
    }

    /**
     * Creates a formatter that appends a specified text to the result string
     *
     * @param appendix a text that will be appended
     */
    public LargeValueFormatter(String appendix) {
        this();
        mText = appendix;
    }

    // ValueFormatter
    @Override
    public String getFormattedValue(float value, Entry entry, int dataSetIndex,
                                    ViewPortHandler viewPortHandler) {
        return makePretty(value) + mText;
    }

    // YAxisValueFormatter
    @Override
    public String getFormattedValue(float value, YAxis yAxis) {
        return makePretty(value) + mText;
    }

    /**
     * Set an appendix text to be added at the end of the formatted value.
     *
     * @param appendix
     */
    public void setAppendix(String appendix) {
        this.mText = appendix;
    }

    /**
     * Set custom suffix to be appended after the values.
     * Default suffix: ["", "k", "m", "b", "t"]
     *
     * @param suff new suffix
     */
    public void setSuffix(String[] suff) {
        if (suff.length == 5) {
            SUFFIX = suff;
        }
    }

    /**
     * Formats each number properly. Special thanks to Roman Gromov
     * (https://github.com/romangromov) for this piece of code.
     */
    private String makePretty(double number) {

        String r = mFormat.format(number);

        r = r.replaceAll("E[0-9]",
                SUFFIX[Character.getNumericValue(r.charAt(r.length() - 1)) / 3]);

        while (r.length() > MAX_LENGTH || r.matches("[0-9]+\\.[a-z]")) {
            r = r.substring(0, r.length() - 2) + r.substring(r.length() - 1);
        }

        return r;
    }
}
