package wrg.com.klinedemo.Util;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * Created by 翁 on 2017/3/21.
 */

public class MyWebview extends WebView {
    public inter activity;

    public MyWebview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int ow, int oh) {//该方法会多次调用
        super.onSizeChanged(w, h, ow, oh);
        activity.callback(h);
    }

    // 回调接口
    interface inter {
        void callback(int h);
    }

    public void setActivity(inter activity){
        this.activity = activity;
    }
}
