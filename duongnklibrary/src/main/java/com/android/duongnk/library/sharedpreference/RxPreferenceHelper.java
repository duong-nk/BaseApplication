package com.android.duongnk.library.sharedpreference;

import java.util.ArrayList;
import java.util.Collections;

import javax.inject.Singleton;


@Singleton
public interface RxPreferenceHelper<D> {
    void saveString(String key, String value);

    String getString(String key);


    void saveBoolean(String key, boolean value);

    boolean getBoolean(String key);

    void removeString(String key);

    void saveObject(String key, Object object);

    Collections getObject(String key, Class<D> classOfT);

    void saveArrayList(ArrayList<D> list, String key);

    ArrayList<D> getArrayList(String key);

    void saveInt(String key, int value);

    int getInt(String key, int valuedefaut);
}
