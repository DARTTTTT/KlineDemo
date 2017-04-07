package wrg.com.klinedemo.UI;

import android.webkit.WebView;

import butterknife.Bind;
import wrg.com.klinedemo.Base.BaseActivity;
import wrg.com.klinedemo.R;
import wrg.com.klinedemo.Util.WebviewSelfAdaption;

/**
 * Created by 翁 on 2017/3/21.
 */

public class WebviewActivity extends BaseActivity{

    @Bind(R.id.webview)
    WebView webView;
    @Override
    protected int getContentId() {
        return R.layout.activity_webview;
    }

    @Override
    protected void init() {
        super.init();
        new WebviewSelfAdaption(this).getWebviewAdaption(webView);
        //webView.loadData("http://192.168.31.76:3802/#/doc-stock/000001.SZ","text/html","utf-8");
        webView.loadUrl("http://192.168.31.76:3802/#/doc-stock/000001.SZ");
    }
}
