package org.sat.chatnow.helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by root on 7/31/16.
 */
//This class stores data in SharedPreferences. Here we temporarily stores the unread push notifications in order to append them to new messages.

public class MyPreferenceManager {
    //Shared Preferences
    SharedPreferences pref;

    //Editor for Shared Preferences
    SharedPreferences.Editor editor;

    //Context
    Context _context;

    //Shared pref mode
    int PRIVATE_MODE=0;

    //Shared Preference File name
    private static final String PREF_NAME = "alok_chatnow";

    //All Shared Preference keys
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_USER_NAME = "user_name";
    private static final String KEY_USER_EMAIL = "user_email";
    private static final String KEY_NOTIFICATIONS = "notifications";

    //Constructor
    public MyPreferenceManager(Context context)
    {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor = pref.edit();
    }

    public void addNotification(String notification) {
        //get old notifications
        String oldNotifications = getNotifications();

        if (oldNotifications != null) {
            oldNotifications += "|" + notification;
        } else {
            oldNotifications = notification;
        }
        editor.putString(KEY_NOTIFICATIONS,oldNotifications);
        editor.commit();
    }

    public String getNotifications() {
        return pref.getString(KEY_NOTIFICATIONS,null);
    }

    public void clear()
    {
        editor.clear();
        editor.commit();
    }

}
