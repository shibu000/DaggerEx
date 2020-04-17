package com.mountblue.daggerex.dagger.component;

import com.mountblue.daggerex.MainActivity;
import com.mountblue.daggerex.dagger.module.AppModule;
import com.mountblue.daggerex.dagger.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
