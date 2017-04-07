package wrg.com.klinedemo.Util;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.ScrollView;

/**
 * Created by 翁 on 2017/3/21.
 */

public class MyWebviewScrollView extends ScrollView {


    public MyWebviewScrollView(Context context) {
        super(context);
    }

    @Override
    public void requestChildFocus(View child, View focused) {
        if (focused instanceof WebView)
            return;
        super.requestChildFocus(child, focused);
    }
}
