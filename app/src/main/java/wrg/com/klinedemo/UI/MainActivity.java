package wrg.com.klinedemo.UI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.LayoutParams;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.LineData;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.zaaach.toprightmenu.MenuItem;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;
import wrg.com.klinedemo.Adapter.MyPagerAdapter;
import wrg.com.klinedemo.Base.BaseActivity;
import wrg.com.klinedemo.Constats.Constant;
import wrg.com.klinedemo.Entity.KlineEntity;
import wrg.com.klinedemo.Entity.MinuteEntity;
import wrg.com.klinedemo.Fragment.DayFragment;
import wrg.com.klinedemo.Fragment.FifteenFragment;
import wrg.com.klinedemo.Fragment.FiveFragment;
import wrg.com.klinedemo.Fragment.MinuteFragment;
import wrg.com.klinedemo.Fragment.MonthFragment;
import wrg.com.klinedemo.Fragment.WeekFragment;
import wrg.com.klinedemo.R;
import wrg.com.klinedemo.Rewrite.HintPopupWindow;
import wrg.com.klinedemo.Util.MyViewPager;
import wrg.com.klinedemo.Util.WebviewSelfAdaption;

import static wrg.com.klinedemo.R.id.webview;


@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends BaseActivity implements TabLayout.OnTabSelectedListener {
    private CombinedChart mChart;
    private Button btn;
    private int itemcount;
    private LineData lineData;
    private CandleData candleData;
    private CombinedData combinedData;
    private ArrayList<String> xVals;
    private List<CandleEntry> candleEntries = new ArrayList<>();

    private List<CandleEntry> candleEntriesKline;
    private List<KlineEntity.DataBean> KlineAlldata;

    private final String[] mTitles = {"分时", "5分", "日K", "周K", "月K", "15分"};


    @Bind(R.id.high)
    TextView high;

    @Bind(R.id.low)
    TextView low;

    @Bind(R.id.tablayout)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    MyViewPager mViewpager;

    private HintPopupWindow hintpopwindwindow;


    private PopupWindow mPopupWindow;

    @Bind(R.id.stock_btn_back)
    TextView back;


    @Bind(webview)
    WebView webView;

    /*@Bind(R.id.btn)
    TextView button;*/


    private MyPagerAdapter myPagerAdapter;
    private View popupView;
    private List<MenuItem> menuItems;

    private ArrayList<String> names = new ArrayList<>();
    @Override
    protected int getContentId() {

        return R.layout.activity_main;
    }

    @SuppressLint("JavascriptInterface")
    @Override
    protected void init() {
        super.init();

        names.add("15分");
        names.add("30分");
        names.add("60分");

        popupView = getLayoutInflater().inflate(R.layout.minutepopwindow_layout, null);

        mPopupWindow = new PopupWindow(popupView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));

        final ArrayList<String> strList = new ArrayList<>();
        strList.add("15分");
        strList.add("30分");
        strList.add("60分");

        ArrayList<View.OnClickListener> clickList = new ArrayList<>();
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "点击事件触发", Toast.LENGTH_SHORT).show();
            }
        };
        clickList.add(clickListener);
        clickList.add(clickListener);
        clickList.add(clickListener);
        clickList.add(clickListener);
        hintpopwindwindow = new HintPopupWindow(this, strList, clickList);

        new WebviewSelfAdaption(this).getWebviewAdaption(webView);
        tabLayout.setupWithViewPager(mViewpager);
        initViewPager(mViewpager);
        mViewpager.setOffscreenPageLimit(5);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

/*

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPopupWindow.showPopupWindow(view);
            }
        });
*/


        tabLayout.addOnTabSelectedListener(this);
        //取消滑动
        //webView.loadUrl("http://vg.ztgame.com/");

        webView.addJavascriptInterface(new JavascriptInterface(this), "imagelistner");

        webView.postDelayed(new Runnable() {
            @Override
            public void run() {
                webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public void onPageStarted(WebView view, String url, Bitmap favicon) {
                        super.onPageStarted(view, url, favicon);
                        Log.d("print", "onPageStarted: " + "--------------onPageStarted--------");
                    }

                    @Override
                    public void onPageFinished(WebView view, String url) {
                        super.onPageFinished(view, url);

                        getWebviewHeight();
                        int w = View.MeasureSpec.makeMeasureSpec(0,
                                View.MeasureSpec.UNSPECIFIED);
                        int scrollBarSize = webView.getScrollBarSize();
                        Log.d("print", "onPageFinished:getScrollBarSize----------------> " + scrollBarSize);
                        int contentHeight = webView.getContentHeight();
                        Log.d("print", "onPageFinished:getContentHeight----------------> " + contentHeight);
                        if (webView.getContentHeight() * webView.getScale() - (webView.getHeight() + webView.getScrollY()) == 0) {
                            //XXX
                            int webviewheight = (int) (webView.getContentHeight() * webView
                                    .getScale());
                            view.measure(w, webviewheight);
                            Log.d("print", "onPageFinished: " + "--------------onPageFinished--------" + "--onPageFinished--------> webviewheight = " + webviewheight);

                        }
                     /*   int webviewheight = (int) (webView.getContentHeight() * webView
                                .getScale());
                        view.measure(w,webviewheight);*/

                        //Log.d("print", "onPageFinished: "+"--------------onPageFinished--------"+"--onPageFinished--------> webviewheight = "+webviewheight);
                    }

                    @Override
                    public void onReceivedError(WebView view, int errorCode,
                                                String description, String failingUrl) {
                        super.onReceivedError(view, errorCode, description, failingUrl);
                        Log.d("print", "onPageFinished: " + "--------------onReceivedError--------");

                    }

                    @SuppressLint("SetJavaScriptEnabled")
                    @Override
                    public void onLoadResource(WebView view, String url) {
                        super.onLoadResource(view, url); // 监听器加载这是为了防止动态加载图片时新加载的图片无法预览
                        //addImageClickListener();
                        getWebviewHeight();
                        new WebviewSelfAdaption(getApplicationContext()).getWebviewAdaption(view);


                    }
                });
            }
        }, 1000);


        //webView.addJavascriptInterface(new JavaScriptInterface(), "HTMLOUT");


    }


    // 注入js函数监听
    private void getWebviewHeight() {
        webView.loadUrl("javascript:(function () {\n" +
                "      var height = angular.element(document.querySelector('#ionContent'))[0].scrollHeight;\n" +
                "      console.log(\"height=\"+height);\n" +
                "      egos.returnHeight(height+\"\");\n" +
                "   },0)");
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab.getPosition() == 5) {
            /*new MultiSelectPopWindow.Builder(MainActivity.this)
                    .setNameArray(names)
                    .setConfirmListener(new MultiSelectPopWindow.OnConfirmClickListener() {
                        @Override
                        public void onClick(ArrayList<Integer> indexList, ArrayList<String> selectedList) {
                            Toast.makeText(getApplication(), indexList.size()+"", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setCancel("取消")
                    .setConfirm("完成")
                    .build()
                    .show(findViewById(R.id.tablayout));
*/

            hintpopwindwindow.showPopupWindow(tabLayout);


        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        if (tab.getPosition() == 5) {
          /*  new MultiSelectPopWindow.Builder(MainActivity.this)
                    .setNameArray(names)
                    .setConfirmListener(new MultiSelectPopWindow.OnConfirmClickListener() {
                        @Override
                        public void onClick(ArrayList<Integer> indexList, ArrayList<String> selectedList) {
                            Toast.makeText(getApplication(), indexList.size()+"", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setCancel("取消")
                    .setConfirm("完成")
                    .build()
                    .show(findViewById(R.id.tablayout));*/


            hintpopwindwindow.showPopupWindow(tabLayout);
        }
    }



    public class JavascriptInterface {

        private Context context;

        public JavascriptInterface(Context context) {
            this.context = context;
        }


    }


    private void initViewPager(ViewPager viewPager) {
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        myPagerAdapter.addFragment(new MinuteFragment(), mTitles[0]);
        myPagerAdapter.addFragment(new FiveFragment(), mTitles[1]);
        myPagerAdapter.addFragment(new DayFragment(), mTitles[2]);
        myPagerAdapter.addFragment(new WeekFragment(), mTitles[3]);
        myPagerAdapter.addFragment(new MonthFragment(), mTitles[4]);
        myPagerAdapter.addFragment(new FifteenFragment(), mTitles[5]);
        viewPager.setAdapter(myPagerAdapter);
    }

    @Override
    protected void loadDatas() {
        super.loadDatas();



        getOkgoMinuteData(Constant.fenshi_Line, "fenshi");

        getOkgoData(Constant.fiveminute_Line,"five");

        getOkgoData(Constant.day_Line, "day");

        getOkgoData(Constant.week_Line, "week");

        getOkgoData(Constant.month_Line, "month");

        getOkgoData(Constant.fifteenminute_Line,"fifteen");






    }

    @Override
    public boolean isOpenStatus() {
        return false;
    }

    //K线的数据
    public void getOkgoData(String url, final String state) {
        OkGo.get(url)
                .tag(this)
                .cacheKey("cache")
                .cacheMode(CacheMode.DEFAULT)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        KlineEntity klineEntity = new Gson().fromJson(s, KlineEntity.class);
                        KlineAlldata = klineEntity.getData();


                        //List<KlineEntity.DataBean> pastToNowData = OrderData.getPastToNowData(KlineAlldata);

                        KlineAlldata.get(0).setState(state);
                        EventBus.getDefault().post(KlineAlldata);

                    }
                });

    }

    //分时的数据
    public void getOkgoMinuteData(String url, final String state) {
        OkGo.get(url)
                .tag(this)
                .cacheKey("cacheline")
                .cacheMode(CacheMode.DEFAULT)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        MinuteEntity minuteEntity = new Gson().fromJson(s, MinuteEntity.class);
                        List<MinuteEntity.DataBean> data = minuteEntity.getData();
                        //List<MinuteEntity.DataBean> pastToNowMinuteData = OrderData.getPastToNowMinuteData(data);
                        data.get(0).setState(state);
                        EventBus.getDefault().post(data);
                    }
                });

    }

    @OnClick({R.id.all_screen})
    public void btnClick(View view){
        switch (view.getId()){
            case R.id.all_screen:
                startActivity(new Intent(MainActivity.this, LandscapeActivity.class));
                break;

        }
    }



}
