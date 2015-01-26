package net.xdart.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class at1 extends Activity {

    private Button btnClost;
    private TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at1);
        btnClost = (Button)findViewById(R.id.btnClose);
        btnClost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("txt2","返回值测试");
                setResult(0,i);
                finish();
            }
        });
        txt1 = (TextView)findViewById(R.id.text1);
        //txt1.setText(getIntent().getStringExtra("txt"));
        Bundle data = getIntent().getExtras();
        txt1.setText(data.getString("txt"));
    }

}
