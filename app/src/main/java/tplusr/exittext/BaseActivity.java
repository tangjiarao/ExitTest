package tplusr.exittext;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import java.util.List;

public abstract class BaseActivity extends AppCompatActivity {

    //当执行完最后销毁的一个activity回调
    public interface Listener{
        public void end();
    }
    private Listener listener;
    public TestApplication testApplication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContentView(savedInstanceState);
        testApplication =(TestApplication)this.getApplication();
        //每新建一个activity旧增加一个activity
        testApplication.addActivity(this);
        //输出栈里面存有的activity数量和顶层activity
        Log.d("BASE", getTopActivity(this));

    }


    /**
     * 初始化UI，setContentView等
     * 主要是该Activity不加载xml，让子类加载
     * @param savedInstanceState
     */
    protected abstract void initContentView(Bundle savedInstanceState);

    /**
     * 获取栈顶activity
     * @param context
     * @return
     */
    protected String getTopActivity(Activity context)
    {
        ActivityManager manager = (ActivityManager)context.getSystemService(ACTIVITY_SERVICE) ;
        List<ActivityManager.RunningTaskInfo> runningTaskInfos = manager.getRunningTasks(1) ;

        if(runningTaskInfos != null){
            return "栈数量:"+runningTaskInfos.size()+
                    "  栈顶Activity:"+runningTaskInfos.get(0).topActivity+
                    "  总Activity数:"+runningTaskInfos.get(0).numActivities;
        }
        else{
            return null ;
        }

    }

//    protected void onStart(){
//        Log.d("BASE","onStart");
//        super.onStart();
//    }
//
//    protected void onRestart(){
//        Log.d("BASE","onRestart");
//        super.onRestart();
//    }
//
//    protected void onResume(){
//        Log.d("BASE","onResume");
//        super.onResume();
//    }
//
//    protected void onPause(){
//        Log.d("BASE","onPause");
//        super.onPause();
//    }
//
//    protected void onStop(){
//        Log.d("BASE","onStop");
//        super.onStop();
//    }

    protected void onDestroy(){

        testApplication.removeActivity(this);
        //Log.d("BASE", "onDestroy" + getTopActivity(this));
        super.onDestroy();
        //如果当前的activity等于最后销毁的activity，就回调
        if (testApplication.last==this&&listener!=null){
            listener.end();
        }
    }

    public void setListener(Listener listener){
        this.listener=listener;
    }

}
