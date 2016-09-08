package tplusr.exittext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class test3Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView t =(TextView)findViewById(R.id.text);
        t.setText("这是页面3");
        Button b =(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(test3Activity.this, test4Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }
    public String toString(){
        return "［页面3：test3Activity Hashcode："+this.hashCode()+"]";
    }
}
