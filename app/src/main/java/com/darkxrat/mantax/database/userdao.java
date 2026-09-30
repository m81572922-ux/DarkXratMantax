package com.darkxrat.mantax.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.darkxrat.mantax.model.User;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private DatabaseHelper dbHelper;

    public UserDao(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // Cek login
    public User login(String username, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
            DatabaseHelper.TABLE_USERS,
            null,
            DatabaseHelper.COL_USERNAME + "=? AND " + DatabaseHelper.COL_PASSWORD + "=?",
            new String[]{username, password},
            null, null, null
        );

        User user = null;
        if (cursor.moveToFirst()) {
            user = new User();
            user.setId(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ID)));
            user.setUsername(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_USERNAME)));
            user.setPassword(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_PASSWORD)));
            user.setRole(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ROLE)));
            user.setExpired(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_EXPIRED)));
        }
        cursor.close();
        return user;
    }

    // Tambah user baru
    public long addUser(User user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COL_USERNAME, user.getUsername());
        cv.put(DatabaseHelper.COL_PASSWORD, user.getPassword());
        cv.put(DatabaseHelper.COL_ROLE, user.getRole());
        cv.put(DatabaseHelper.COL_EXPIRED, user.getExpired());
        cv.put(DatabaseHelper.COL_ACTIVE, 1);
        return db.insert(DatabaseHelper.TABLE_USERS, null, cv);
    }

    // Ambil semua user
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DatabaseHelper.TABLE_USERS, null,
            null, null, null, null, DatabaseHelper.COL_ID + " ASC");

        while (cursor.moveToNext()) {
            User user = new User();
            user.setId(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ID)));
            user.setUsername(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_USERNAME)));
            user.setPassword(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_PASSWORD)));
            user.setRole(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_ROLE)));
            user.setExpired(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COL_EXPIRED)));
            list.add(user);
        }
        cursor.close();
        return list;
    }

    // Hapus user
    public int deleteUser(int id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return db.delete(DatabaseHelper.TABLE_USERS,
            DatabaseHelper.COL_ID + "=?", new String[]{String.valueOf(id)});
    }

    // Update password
    public int updatePassword(String username, String newPassword) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COL_PASSWORD, newPassword);
        return db.update(DatabaseHelper.TABLE_USERS, cv,
            DatabaseHelper.COL_USERNAME + "=?", new String[]{username});
    }

    // Cek apakah user ada
    public boolean isUserExist(String username) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DatabaseHelper.TABLE_USERS, null,
            DatabaseHelper.COL_USERNAME + "=?", new String[]{username},
            null, null, null);
        boolean exist = cursor.getCount() > 0;
        cursor.close();
        return exist;
    }
}