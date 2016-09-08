package tplusr.exittext;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        TextView t =(TextView)findViewById(R.id.text);
        t.setText("这是页面1");
        Button b =(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, test2Activity.class);
                startActivity(intent);
            }
        });

//        //获取SharedPreferences对象
//        SharedPreferences sp = this.getSharedPreferences("SP", MODE_PRIVATE);
//        //利用edit()方法获取Editor对象。
//        SharedPreferences.Editor editor = sp.edit();
//        //通过Editor对象存储key-value键值对数据。
//        editor.putString("Name", "tplusr");
//        editor.putInt("Password", 234556);
//        editor.putBoolean("isCheck", true);
//        //通过commit()方法提交数据
//        editor.commit();
//
////        //返回STRING_KEY的值
////        Log.d("SP", sp.getString("STRING_KEY", "none"));
////        //如果NOT_EXIST不存在，则返回值为"none"
////        Log.d("SP", sp.getString("NOT_EXIST", "none"));

    }

    /**
     * 初始化布局
     * @param savedInstanceState
     */
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }

    /**
     * 重写toString方法
     * @return
     */
    public String toString(){
        return "［页面1：test1Activity Hashcode："+this.hashCode()+"]";
    }
    /**
     * 重写onKeyDown方法，按返回键时不会销毁Activity
     * @param keyCode
     * @param event
     * @return
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

            //跳到手机主页面，activity会onStop
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addCategory(Intent.CATEGORY_HOME);

            startActivity(intent);
            Log.d("BASE", getTopActivity(this));
            return true;
        } else
            return super.onKeyDown(keyCode, event);
    }
}
