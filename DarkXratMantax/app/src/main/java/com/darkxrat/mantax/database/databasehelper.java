package com.darkxrat.mantax.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "darkxrat.db";
    private static final int DB_VERSION = 1;

    // Table users
    public static final String TABLE_USERS = "users";
    public static final String COL_ID = "id";
    public static final String COL_USERNAME = "username";
    public static final String COL_PASSWORD = "password";
    public static final String COL_ROLE = "role";
    public static final String COL_EXPIRED = "expired";
    public static final String COL_ACTIVE = "is_active";

    // Table senders
    public static final String TABLE_SENDERS = "senders";
    public static final String COL_S_ID = "id";
    public static final String COL_S_NOMOR = "nomor";
    public static final String COL_S_KODE = "kode";
    public static final String COL_S_TIPE = "tipe";
    public static final String COL_S_OWNER = "owner_user";
    public static final String COL_S_ONLINE = "is_online";

    // Table bugs
    public static final String TABLE_BUGS = "bugs";
    public static final String COL_B_ID = "id";
    public static final String COL_B_NAMA = "nama";
    public static final String COL_B_TIPE = "tipe";
    public static final String COL_B_FUNC = "func";
    public static final String COL_B_DESK = "deskripsi";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create users table
        String createUsers = "CREATE TABLE " + TABLE_USERS + " (" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_USERNAME + " TEXT UNIQUE, " +
            COL_PASSWORD + " TEXT, " +
            COL_ROLE + " TEXT, " +
            COL_EXPIRED + " TEXT, " +
            COL_ACTIVE + " INTEGER DEFAULT 1)";
        db.execSQL(createUsers);

        // Create senders table
        String createSenders = "CREATE TABLE " + TABLE_SENDERS + " (" +
            COL_S_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_S_NOMOR + " TEXT, " +
            COL_S_KODE + " TEXT, " +
            COL_S_TIPE + " TEXT, " +
            COL_S_OWNER + " TEXT, " +
            COL_S_ONLINE + " INTEGER DEFAULT 1)";
        db.execSQL(createSenders);

        // Create bugs table
        String createBugs = "CREATE TABLE " + TABLE_BUGS + " (" +
            COL_B_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_B_NAMA + " TEXT, " +
            COL_B_TIPE + " TEXT, " +
            COL_B_FUNC + " TEXT, " +
            COL_B_DESK + " TEXT)";
        db.execSQL(createBugs);

        // Insert user MANZXRAT (lo)
        ContentValues cv = new ContentValues();
        cv.put(COL_USERNAME, "MANZZ");
        cv.put(COL_PASSWORD, "STOKMAN2011");
        cv.put(COL_ROLE, "MANZXRAT");
        cv.put(COL_EXPIRED, "PERMANEN");
        cv.put(COL_ACTIVE, 1);
        db.insert(TABLE_USERS, null, cv);

        // Insert bug default
        String[][] bugList = {
            {"FORCLOSE IOS", "BUG", "hard", "FC iOS"},
            {"BLANK ANDRO", "BUG", "hard", "Blank Android"},
            {"DELAY ONE SHOT", "BUG", "ultra", "Delay satu tembakan"},
            {"BULDO DELAY", "BUG", "hard", "Buldo delay"},
            {"DELAY", "BUG", "default", "Delay biasa"},
            {"BLANK GROUP", "BUG", "hard", "Blank grup"},
            {"FC INVISIBLE HARD", "BUG", "ultra", "FC invisible hard"},
            {"DELAY INVISIBLE", "BUG", "hard", "Delay invisible"},
            {"BLANK X DELAY INVISIBLE", "BUG", "ultra", "Kombinasi blank + delay"},
            {"FC IOS INVISIBLE", "BUG", "ultra", "FC iOS invisible"},
            {"CRASH HARD", "BUG", "ultra", "Crash hard"},
            {"DELAY INVISIBLE 2", "BUG", "hard", "Delay invisible v2"}
        };

        for (String[] bug : bugList) {
            ContentValues bcv = new ContentValues();
            bcv.put(COL_B_NAMA, bug[0]);
            bcv.put(COL_B_TIPE, bug[1]);
            bcv.put(COL_B_FUNC, bug[2]);
            bcv.put(COL_B_DESK, bug[3]);
            db.insert(TABLE_BUGS, null, bcv);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SENDERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUGS);
        onCreate(db);
    }
}