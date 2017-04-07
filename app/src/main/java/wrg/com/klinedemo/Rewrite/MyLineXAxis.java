package wrg.com.klinedemo.Rewrite;

import android.util.SparseArray;

import com.github.mikephil.charting.components.XAxis;

/**
 * Created by 翁 on 2017/3/27.
 */

public class MyLineXAxis extends XAxis {
    private SparseArray<String> labels;
    public SparseArray<String> getXLabels() {
        return labels;
    }
    public void setXLabels(SparseArray<String> labels) {
        this.labels = labels;
    }



}
