package com.joyy.android_project;

import android.os.Bundle;

public interface IPresenter {
    void onUICreate(Bundle savedInstanceState);
    void onUIResume();
    void onUIPause();
    void onUIStop();
    void onUIDestroy();
    void onSaveInstanceState(Bundle outState);
    void onRestoreInstanceState(Bundle savedInstanceState);
}
