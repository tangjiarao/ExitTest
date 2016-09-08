package tplusr.exittext;

import android.app.Application;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangjiarao on 16/9/6.
 */
public class TestApplication extends Application {

    //管理所有activity销毁
    List<BaseActivity> mActivityList = new ArrayList<>();

    //记录最后销毁的activity
    BaseActivity last;

    /**
     * 提供一个添加activity的方法
     * 每新建一个activity就增加到集合里面
     * @param activity
     */
    public void addActivity(BaseActivity activity) {
        if (!mActivityList.contains(activity)) {
            mActivityList.add(activity);
            checkActivityNum();
        }

    }

    //提供一个移除activity的方法
    public void removeActivity(BaseActivity activity) {
        if (mActivityList.contains(activity)) {
            mActivityList.remove(activity);
        }
    }


    /**
     * 提供一个清空集合的方法
     * 就是使用循环对集合里的activity逐个销魂
     */
    public void clearAllActivity() {
        last =mActivityList.get(mActivityList.size()-1);
        for (int i = 0; i< mActivityList.size(); i++) {
            BaseActivity activity = mActivityList.get(i);
            activity.finish();
            Log.d("BASE", "销毁了：" + activity);
        }
        mActivityList.clear();
    }

    //查看Activity数量及名字
    public void checkActivityNum(){

        Log.d("BASE", "------------List储存的actvity------------");
        for (BaseActivity b: mActivityList){
            Log.d("BASE", b.toString());
        }
        Log.d("BASE", "页面数："+mActivityList.size());
        Log.d("BASE", "------------List储存的actvity------------");
    }
}
