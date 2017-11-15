package zhoxuan.com.bwie.greendao_two;

import zhoxuan.com.bwie.greendao_two.gen.DaoMaster;
import zhoxuan.com.bwie.greendao_two.gen.DaoSession;

/**
 * 周旋
 * 2017/11/15  14:12
 */

public class GreenDaoManager {
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private static volatile GreenDaoManager mInstance = null;
    private GreenDaoManager(){
        if (mInstance == null) {
            DaoMaster.DevOpenHelper devOpenHelper = new
            DaoMaster.DevOpenHelper(App.context, "user.db");
            mDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
            mDaoSession = mDaoMaster.newSession();
        }     }
    public static GreenDaoManager getInstance() {
        if (mInstance == null) {
            synchronized (GreenDaoManager.class) {
                if (mInstance == null) {
                    mInstance = new GreenDaoManager();
                }             }         }
        return mInstance;     }
    public DaoMaster getMaster() {
        return mDaoMaster;     }
    public DaoSession getSession() {
        return mDaoSession;     }
    public DaoSession getNewSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;     }
}
