package wrg.com.klinedemo.UI;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;

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
import wrg.com.klinedemo.Fragment.DayFragments;
import wrg.com.klinedemo.Fragment.FifteenFragments;
import wrg.com.klinedemo.Fragment.FiveFragments;
import wrg.com.klinedemo.Fragment.MinuteFragment;
import wrg.com.klinedemo.Fragment.MonthFragments;
import wrg.com.klinedemo.Fragment.WeekFragments;
import wrg.com.klinedemo.R;
import wrg.com.klinedemo.Rewrite.HintPopupWindow;
import wrg.com.klinedemo.Util.MyViewPager;

/**
 * Created by 翁 on 2017/3/29.
 */

public class LandscapeActivity extends BaseActivity {

    @Bind(R.id.tablayout)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    MyViewPager mViewpager;

    @Bind(R.id.minute_detail)
    TextView minute_detail;

    private HintPopupWindow hintpopwindwindow;


    private PopupWindow mPopupWindow;
    private View popupView;


    private List<KlineEntity.DataBean> KlineAlldata;

    private final String[] mTitles = {"分时", "5分", "日K", "周K", "月K", "15分"};

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            loadDatas();


        }
    };

    @Override
    protected int getContentId() {
        setFullscreen();
        return R.layout.activity_landscape;
    }


    @Override
    protected void init() {
        super.init();
        popupView = getLayoutInflater().inflate(R.layout.minutepopwindow_layout, null);

        mPopupWindow = new PopupWindow(popupView, ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.WRAP_CONTENT, true);
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

                Toast.makeText(LandscapeActivity.this, "点击事件触发", Toast.LENGTH_SHORT).show();
            }
        };
        clickList.add(clickListener);
        clickList.add(clickListener);
        clickList.add(clickListener);
        clickList.add(clickListener);
        hintpopwindwindow = new HintPopupWindow(this, strList, clickList);

        tabLayout.setupWithViewPager(mViewpager);
        initViewPager(mViewpager);
        mViewpager.setOffscreenPageLimit(5);




    }

    public void setFullscreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void initViewPager(ViewPager viewPager) {
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        myPagerAdapter.addFragment(new MinuteFragment(), mTitles[0]);
        myPagerAdapter.addFragment(new FiveFragments(), mTitles[1]);
        myPagerAdapter.addFragment(new DayFragments(), mTitles[2]);
        myPagerAdapter.addFragment(new WeekFragments(), mTitles[3]);
        myPagerAdapter.addFragment(new MonthFragments(), mTitles[4]);
        myPagerAdapter.addFragment(new FifteenFragments(), mTitles[5]);
        viewPager.setAdapter(myPagerAdapter);
    }

    @Override
    protected void loadDatas() {
        super.loadDatas();
        getOkgoMinuteData(Constant.fenshi_Line, "fenshi");

        getOkgoData(Constant.fiveminute_Line, "fives");

        getOkgoData(Constant.day_Line, "days");

        getOkgoData(Constant.week_Line, "weeks");

        getOkgoData(Constant.month_Line, "months");

        getOkgoData(Constant.fifteenminute_Line, "fifteens");

        //handler.sendEmptyMessageDelayed(1,1000);


    }


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
                        minute_detail.setText(data.get(data.size()-1).getLastPx()+"");
                        //List<MinuteEntity.DataBean> pastToNowMinuteData = OrderData.getPastToNowMinuteData(data);
                        data.get(0).setState(state);
                        EventBus.getDefault().post(data);
                    }
                });

    }

    @OnClick({R.id.back})
    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
        }

    }
}
