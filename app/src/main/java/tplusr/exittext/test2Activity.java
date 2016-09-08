package tplusr.exittext;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class test2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView t =(TextView)findViewById(R.id.text);
        t.setText("这是页面2");
        Button b =(Button)findViewById(R.id.button);
        //b.setVisibility(View.INVISIBLE);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(test2Activity.this, test3Activity.class);
                startActivity(intent);
            }
        });

//        //获取SharedPreferences对象
//        SharedPreferences sp = this.getSharedPreferences("SP", Context.MODE_WORLD_READABLE);
//
//        t.setText("Name:"+sp.getString("Name","none")
//                +" Password:"+sp.getInt("Password", 0)
//                +" isCheck:" +sp.getBoolean("isCheck", false));

    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }

    public String toString(){
        return "［页面2：test2Activity Hashcode："+this.hashCode()+"]";
    }

}
