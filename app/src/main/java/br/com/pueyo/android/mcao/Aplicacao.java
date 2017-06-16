package br.com.pueyo.android.mcao;

import android.app.Application;
import android.os.SystemClock;

import java.util.concurrent.TimeUnit;

/**
 * Created by u07669751770 on 14/06/17.
 */

public class Aplicacao  extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(4));
    }
}
