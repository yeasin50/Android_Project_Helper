package com.example.offline_income.SQLite_Handler_Off_in;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.offline_income.model.Item;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper_OF_in extends SQLiteOpenHelper {

    private static final String DATABASE_NAME= "MonthList.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_MONTH ="MONTHS_LIST";

    private static final String ID= "id";
    private static final String MONTH="month";
    private static final String YEAR = "year";
    private static final String TK ="tk";

    Context context;
    String CREATE_MONTH_TABLE= "CREATE TABLE "+ TABLE_MONTH + "("+ ID +" INTEGER  PRIMARY KEY, "+ MONTH +"TEXT ,"+YEAR +" TEXT,"+TK +"TEXT"+ ")";

    public DataBaseHelper_OF_in( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try {
            sqLiteDatabase.execSQL(CREATE_MONTH_TABLE);
            SToast("Table Created");

        }catch (Exception a){
            SToast(a.toString());
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_MONTH);
        onCreate(sqLiteDatabase);

    }



// All Database Operation

    public long addMonth(Item i){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID,i.getId());
        contentValues.put(MONTH, i.getMon());
        contentValues.put(YEAR,i.getYear());
        contentValues.put(TK,i.getTk());
        long id =   sqLiteDatabase.insert(TABLE_MONTH,null, contentValues);
        sqLiteDatabase.close();
        SToast("Added "+ i.getMon());

       return id;
    }

    public Item getSingleItem(String id){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_MONTH, new String[]{
                ID,MONTH,YEAR,TK},
                ID + "=?",new String[]{String.valueOf(id)},null,null,null);


        if(cursor !=null)cursor.moveToFirst();

        Item i = new Item(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
        return i;
    }

    public ArrayList <Item> getAll_Month(){
        ArrayList<Item> MonthList = new ArrayList<Item>();

        String selectAllQuery ="SELECT * FROM "+ TABLE_MONTH;
        SQLiteDatabase database = this.getWritableDatabase();

        Cursor cursor =database.rawQuery(selectAllQuery,null);
        while (cursor.moveToNext()){

               Item i = new Item();
               i.setId(cursor.getString(0));
               i.setMon(cursor.getString(1));
               i.setYear(cursor.getString(2));
               i.setTk(cursor.getString(3));
               MonthList.add(i);


        }

        return MonthList;
    }

    public  int updateMonth(Item i){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MONTH,i.getMon());
        contentValues.put(YEAR,i.getYear());
        contentValues.put(TK,i.getTk());

        return database.update(TABLE_MONTH, contentValues,ID + "=?",new String[]{String.valueOf(i.getId())});

    }


    public  void deleteA_Month(Item i){
        SQLiteDatabase  database= this.getWritableDatabase();
        database.delete(TABLE_MONTH,ID +"=?",
                new String[]{String.valueOf(i.getId())});
        database.close();
    }

    public int getCountMonths(){
        String c = "SELECT * FROM "+TABLE_MONTH;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(c,null);
        cursor.close();
        return cursor.getCount();
    }

    public void SToast(String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
