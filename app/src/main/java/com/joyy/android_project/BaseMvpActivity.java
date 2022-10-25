package com.joyy.android_project;

import android.app.Activity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseMvpActivity extends Activity {
    protected IPresenter iPresenter;

    public BaseMvpActivity(IPresenter iPresenter) {
        this.iPresenter = createPresenter();
    }

    protected IPresenter createPresenter() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        if (type == null) {
            return null;
        }
        Type[] typeArray = type.getActualTypeArguments();
        if (typeArray.length == 0) {
            return null;
        }
        Class<IPresenter> clazz = (Class<IPresenter>) typeArray[0];
        try {
            return clazz.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onDestroy() {
        if (iPresenter != null) {
            iPresenter.onUIDestroy();
        }
        super.onDestroy();
    }
}
