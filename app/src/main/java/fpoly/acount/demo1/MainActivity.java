package fpoly.acount.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import fpoly.acount.demo1.adapter.Adapter;
import fpoly.acount.demo1.model.Model;

public class MainActivity extends AppCompatActivity {
private Adapter adapter;
private List<Model>list;

EditText edtTitle, edtDescription;
Button btnAdd;
ListView listView;
DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.demoLv);
        edtTitle = findViewById(R.id.edtTitle);
        edtDescription = findViewById(R.id.edtDescription);
        btnAdd = findViewById(R.id.btnAdd);



        dbHelper = new DbHelper(this);  // goi ham tao database
        list = dbHelper.getAllData(); //load du lieu
        adapter = new Adapter(this,list);
        listView.setAdapter(adapter);
        //them du lieu
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edtTitle.getText().toString();
                String des = edtDescription.getText().toString();
                if (!title.isEmpty() && !des.isEmpty()){ // neu du lieu ko rong
                            Model model = new Model(title,des);
                            dbHelper.them(model);
                            adapter.notifyDataSetChanged();
                            edtTitle.setText("");
                            edtDescription.setText("");
                }
            }
        });
    }
}