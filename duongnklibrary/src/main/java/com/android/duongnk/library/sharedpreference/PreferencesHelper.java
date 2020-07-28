package com.android.duongnk.library.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;


import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PreferencesHelper implements RxPreferenceHelper {
    private static final String PREF_NAME = "pref_sb";
    private SharedPreferences pref;

    /**
     * Khởi tạo để mã hóa thông tin data
     *
     * @param context
     */
    @Inject
    public PreferencesHelper(Context context) {
        try {
            String masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC);
            pref = EncryptedSharedPreferences.create(
                    PREF_NAME,
                    masterKeyAlias,
                    context,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveString(String key, String value) {
        pref.edit().putString(key, value).apply();
    }

    @Override
    public String getString(String key) {
        return pref.getString(key, "");
    }

    @Override
    public void saveBoolean(String key, boolean value) {

    }

    @Override
    public boolean getBoolean(String key) {
        return false;
    }

    @Override
    public void removeString(String key) {

    }

    /**
     * object đc format thành gson và save bằng putString
     *
     * @param key
     * @param object
     */
    @Override
    public void saveObject(String key, Object object) {
        putString(key, new Gson().toJson(object));
    }

    /**
     * classOfT là  pattern data of model
     *
     * @param key
     * @param classOfT
     * @return
     */
    @Override
    public Collections getObject(String key, Class classOfT) {
        return new Gson().fromJson(key, (Type) classOfT);

    }

    @Override
    public void saveArrayList(ArrayList list, String key) {
        SharedPreferences.Editor editor = pref.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();     // This line is IMPORTANT !!!
    }

    @Override
    public ArrayList getArrayList(String key) {
        ArrayList<?> arrayList = new ArrayList<>();
        Gson gson = new Gson();
        String json = pref.getString(key, null);
        Type type = new TypeToken<ArrayList<?>>() {
        }.getType();
        arrayList = gson.fromJson(json, type);


        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        return arrayList;
    }

    /*
     *  new
     * */
    private void putString(String key, String value) {
        pref.edit().putString(key, value).apply();
    }

    private String getStrings(String key) {
        return pref.getString(key, "");
    }

    @Override
    public void saveInt(String key, int value) {
        pref.edit().putInt(key, value).apply();
    }

    @Override
    public int getInt(String key, int valuedefaut) {
        return pref.getInt(key, valuedefaut);
    }

}
