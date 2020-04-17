package com.mountblue.daggerex;

import android.app.Application;

import com.mountblue.daggerex.dagger.component.AppComponent;
import com.mountblue.daggerex.dagger.component.DaggerAppComponent;
import com.mountblue.daggerex.dagger.module.AppModule;
import com.mountblue.daggerex.dagger.module.NetworkModule;

public class BaseApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule("https://jsonplaceholder.typicode.com"))
                .build();
    }

    public AppComponent getNetworkComponent() {
        return appComponent;
    }
}
