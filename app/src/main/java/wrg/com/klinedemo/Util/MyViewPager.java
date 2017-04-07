package wrg.com.klinedemo.Util;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by 翁 on 2017/3/22.
 */

public class MyViewPager extends ViewPager {
    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
      /*  try {
            return super.onInterceptTouchEvent(ev);
        } catch (Exception e) {
            // ignore it
        }*/
        return false;
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
      /*  try {
            return super.onTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
            // ignore it
        }*/
        return false;
    }




}
