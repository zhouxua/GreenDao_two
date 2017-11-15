package zhoxuan.com.bwie.greendao_two;

import android.app.Application;
import android.content.Context;

/**
 * 周旋
 * 2017/11/15  14:14
 */

public class App extends Application {
   public static  Context context;

    public App() {
        context=this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        GreenDaoManager.getInstance();

    }
}
