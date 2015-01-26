package net.xdart.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("On class MyService Bind");
        return binder;

    }
    private final MyserviceBinder binder = new MyserviceBinder();
    public class MyserviceBinder extends Binder{

        public MyService getServiceInstance()
        {
            return MyService.this;
        }

    }

    @Override
    public void onCreate() {
        System.out.println("onCreate");
        startTimer();
        super.onCreate();

    }

    @Override
    public void onDestroy() {

        stopTimer();
        System.out.println("onDestory");
        super.onDestroy();
    }

    private Timer timer = null;
    private TimerTask task = null;
    private  int i = 0;
    public int getNum()
    {
        return i;
    }
    private void startTimer()
    {
        if(null == timer)
        {
            timer = new Timer();

        task = new TimerTask() {
            @Override
            public void run() {
                i++;
                System.out.println(i);
            }
        };
        timer.schedule(task,1010,1000);
        }
    }
    private void stopTimer()
    {
        if(null!=timer)
        {
            task.cancel();
            timer.cancel();
            timer = null;
            task = null;
        }
    }

}
