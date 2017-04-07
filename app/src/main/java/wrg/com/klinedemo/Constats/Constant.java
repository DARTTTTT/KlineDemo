package wrg.com.klinedemo.Constats;

/**
 * Created by 翁 on 2017/3/16.
 */

public interface Constant {
    //日K
    String day_Line = "http://api-cm.zhangtl.com:8000/oxapi2/quote/kline?ID=000001.SZ&period=Day&count=100";
    //周K
    String week_Line = "http://api-cm.zhangtl.com:8000/oxapi2/quote/kline?ID=000001.SZ&period=Week&count=100";
    //月K
    String month_Line = "http://api-cm.zhangtl.com:8000/oxapi2/quote/kline?ID=000001.SZ&period=Month&count=100";
    //分时
    String fenshi_Line = "http://api-cm.zhangtl.com:8000/oxapi2/quote/fs?ID=000001.SZ";
    //5分
    String fiveminute_Line = "http://api-cm.zhangtl.com:8000/oxapi2/quote/kline?ID=000001.SZ&period=5Min&count=100";
    //15分
    String fifteenminute_Line = "http://api-cm.zhangtl.com:8000/oxapi2/quote/kline?ID=000001.SZ&period=15Min&count=100";
    //30分
    String thirtyminute_Line = "http://api-cm.zhangtl.com:8000/oxapi2/quote/kline?ID=000001.SZ&period=30Min&count=100";
    //60分
    String sixtyminute_Line = "http://api-cm.zhangtl.com:8000/oxapi2/quote/kline?ID=000001.SZ&period=60Min&count=100";


}
