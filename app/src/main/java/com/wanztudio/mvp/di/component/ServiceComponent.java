package com.wanztudio.mvp.di.component;


import dagger.Component;
import com.wanztudio.mvp.di.PerService;
import com.wanztudio.mvp.di.module.ServiceModule;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

}
