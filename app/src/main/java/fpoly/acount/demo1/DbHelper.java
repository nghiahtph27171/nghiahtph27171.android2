package fpoly.acount.demo1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.ColorSpace;

import java.util.ArrayList;
import java.util.List;

import fpoly.acount.demo1.model.Model;

public class DbHelper  extends SQLiteOpenHelper {
    public DbHelper(Context context){
        super(context, "DB", null, 1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE Model( id integer PRIMARY KEY, title text, description text)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS Model");
    }

    public void them(Model model){
        SQLiteDatabase db= this.getWritableDatabase(); //cho phep ghi
        ContentValues contentValues = new ContentValues(); //doi tuong chua du lieu
        //chuan bi du lieu insert
        contentValues.put("title", model.getTitle());
        contentValues.put("description", model.getDescription());
        //thuc thi insert
        db.insert("Model", null,contentValues);
        //dong ket noi
        db.close();

    }
    public List<Model> getAllData(){
        List<Model> list = new ArrayList<>();
        String query = "SELECT * FROM Model";
        SQLiteDatabase db = this.getWritableDatabase();
        //con tro doc du lieu
        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst()){ // di chuyen con tro ve ban ghi dau tien
            do {
                Model model = new Model();
                model.setTitle(cursor.getString(1));
                model.setDescription(cursor.getString(2));
                list.add(model); //dua doi tuong vao list
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }
}
