package com.example.myapplication.mysqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.PrimitiveIterator;

public class DataActivity extends AppCompatActivity implements View.OnClickListener {

    private MySqliteOpenHelper mySqliteOpenHelper;
    private Button btn_insert,btn_update,btn_delete,btn_query;
    private TextView tv_query;
    private EditText et_stu_name,et_stu_tele;
    private SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        mySqliteOpenHelper = new MySqliteOpenHelper(DataActivity.this,"student");

        bindView();
        setListeners();

    }

    private void setListeners() {
        btn_insert.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_query.setOnClickListener(this);
    }

    private void bindView() {
        btn_insert = findViewById(R.id.btn_insert);
        btn_update = findViewById(R.id.btn_update);
        btn_delete = findViewById(R.id.btn_delete);
        btn_query  = findViewById(R.id.btn_query);
        et_stu_name  = findViewById(R.id.et_stu_name);
        et_stu_tele  = findViewById(R.id.et_stu_tele);
    }

    @Override
    public void onClick(View v) {
        String name = et_stu_name.getText().toString();
        String telephone = et_stu_tele.getText().toString();
        switch (v.getId()){
            case R.id.btn_insert:
                sqLiteDatabase = mySqliteOpenHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name",et_stu_name.getText().toString());
                values.put("telephone",et_stu_tele.getText().toString());
                sqLiteDatabase.insert("student",null,values);

//                第二种方法 sqLiteDatabase.execSQL("insert into student(name,telephone) values(name,telephone)");
//                sqLiteDatabase.close();//关闭数据库，这里不用关
                break;
            case R.id.btn_delete:
                sqLiteDatabase = mySqliteOpenHelper.getWritableDatabase();
//                模糊查询
                sqLiteDatabase.delete("student","name like ? and telephone like ?",new String[]{"%"+name+"%"});
                break;
            case R.id.btn_update:
                sqLiteDatabase = mySqliteOpenHelper.getWritableDatabase();
                ContentValues values_update = new ContentValues();
                values_update.put("name",name);
                values_update.put("telephone",telephone);
                sqLiteDatabase.update("student",values_update,"name =?",null);

                break;
            case R.id.btn_query:
                sqLiteDatabase = mySqliteOpenHelper.getReadableDatabase();
                //返回一个游标
                Cursor cursor = sqLiteDatabase.query("student",new String[]{"ID","name","telephone"},"name like ?",new String[]{name+"%"},null,null,null);


                while (cursor.moveToNext()){
                    int id = cursor.getInt(cursor.getColumnIndex("ID"));
                    String name_query = cursor.getString(cursor.getColumnIndex("name"));
                    String telephone_query = cursor.getString(cursor.getColumnIndex("telephone"));
                //    tv_query.append(id+"%\t"+name_query);
                }
                break;

        }

    }
}