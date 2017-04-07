package wrg.com.klinedemo.Rewrite;

import android.content.Context;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;

import java.text.DecimalFormat;

import wrg.com.klinedemo.R;

/**
 * Created by 翁 on 2017/3/24.
 */

public class MyRightMarkerView extends MarkerView{

    private TextView markerTv;
    private float num;
    private DecimalFormat mFormat;
    public MyRightMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);
        mFormat = new DecimalFormat("#0.00");
        markerTv = (TextView) findViewById(R.id.marker_tv);
        markerTv.setTextSize(10);

    }

    public void setData(float num){
        this.num=num;
    }
    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        markerTv.setText(mFormat.format(num*100)+"%");
    }

    @Override
    public int getXOffset(float xpos) {

        return 0;
    }

    @Override
    public int getYOffset(float ypos) {
        return 0;
    }
}
