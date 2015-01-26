package net.xdart.myapplication;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;


public class MainActivity extends Activity implements View.OnClickListener,ServiceConnection {

    private Button btnStart;
    private Button btnStop;
    private Button btnBindService,btnUnbindService;
    private Button btnGetNum;
    private Intent serviceIntent;
    private MyService serviceInstance = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = (Button)findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);
        btnStop = (Button)findViewById(R.id.btnStop);
        btnStop.setOnClickListener(this);
        btnBindService = (Button)findViewById(R.id.btnBind);
        btnUnbindService = (Button)findViewById(R.id.btnUnbind);
        btnBindService.setOnClickListener(this);
        btnUnbindService.setOnClickListener(this);
        btnGetNum = (Button)findViewById(R.id.btnGetNum);
        btnGetNum.setOnClickListener(this);

        serviceIntent = new Intent(this,MyService.class);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnStop:
                stopService(serviceIntent);
                break;
            case R.id.btnStart:
                startService(serviceIntent);
                break;
            case R.id.btnBind:
                bindService(serviceIntent,this,BIND_AUTO_CREATE);
                break;
            case R.id.btnUnbind:
                unbindService(this);
                break;
            case R.id.btnGetNum:
                if(null != serviceInstance)
                {
                    System.out.println(serviceInstance.getNum());
                }
                break;

        }


    }


    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("In Activity run Bind");

        if(null==serviceInstance)
        {
            serviceInstance = ((MyService.MyserviceBinder)(service)).getServiceInstance();

        }

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
