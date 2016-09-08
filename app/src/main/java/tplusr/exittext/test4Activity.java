package tplusr.exittext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class test4Activity extends BaseActivity {

    public long mStartTime=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView t =(TextView)findViewById(R.id.text);
        t.setText("这是页面4");
        Button b1 =(Button)findViewById(R.id.button1);
        Button b2 =(Button)findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //清空页面
                testApplication.clearAllActivity();

                //当最后一个activity销毁完毕后才退出程序
                setListener(new Listener() {
                    @Override
                    public void end() {
                        //输出当前页面栈内容
                        Log.d("BASE", getTopActivity(test4Activity.this));
                        System.exit(0);
                    }
                });

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //清空页面
                testApplication.clearAllActivity();
                //输出当前页面栈内容
                Log.d("BASE", getTopActivity(test4Activity.this));
                //跳回程序主页面
                Intent intent = new Intent();
                intent.setClass(test4Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_test4);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

            //当点击的时候计算2次点击的时间差，如果在2秒之内点击2次，就退出
            long currentTimeMillis = System.currentTimeMillis();
            if ((currentTimeMillis - mStartTime) < 2000) {
                //清空页面
                testApplication.clearAllActivity();
                //输出当前页面栈内容
                Log.d("BASE", getTopActivity(test4Activity.this));
                //退出进程方法2
                android.os.Process.killProcess(android.os.Process.myPid());
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//在非activity中，要唤起一个activity,就要重现创建一个任务栈
                startActivity(intent);
            } else {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mStartTime = System.currentTimeMillis();    //记录点击后的时间
            }
            return true;
        } else
            return super.onKeyDown(keyCode, event);
    }

    public String toString(){
        return "［页面4：test4Activity Hashcode："+this.hashCode()+"]";
    }
}
