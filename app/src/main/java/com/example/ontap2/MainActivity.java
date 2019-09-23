package com.example.ontap2;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<NhanVien> mangnhanvien;
    MyArrayAdapter adapter;
    ListView lvNV;
    Button btnNhapNV, btnXoa;
    EditText etManv, etTennv;
    RadioGroup rg;
    RadioButton radNam, radNu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNhapNV = findViewById(R.id.btnNhapNV);
        lvNV = findViewById(R.id.lvNV);
        etManv = findViewById(R.id.etManv);
        btnXoa = findViewById(R.id.btnXoa);
        etTennv = findViewById(R.id.etTennv);
        rg = findViewById(R.id.rg);

        mangnhanvien = new ArrayList<NhanVien>();
        NhanVien nv1 = new NhanVien("1","Nghia",true);
        mangnhanvien.add(nv1);
        adapter = new MyArrayAdapter(this, R.layout.my_item_layout, mangnhanvien);
        lvNV.setAdapter(adapter);

        btnNhapNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xyLyNhap();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xyLyXoa();
            }
        });
    }

    private void xyLyXoa() {
        for (int i = lvNV.getChildCount() - 1; i>=0; i--){
            View v = lvNV.getChildAt(i);
            CheckBox chkXoa = v.findViewById(R.id.chkXoa);
            if(chkXoa.isChecked()){
                mangnhanvien.remove(i);
            }
            adapter.notifyDataSetChanged();
        }
    }

    private void xyLyNhap() {
        String id = etManv.getText().toString();
        String name = etTennv.getText().toString();
        boolean gender = false;
        if(rg.getCheckedRadioButtonId() == R.id.radNu){
            gender = true;
        }
        NhanVien nv = new NhanVien();
        nv.setId(id);
        nv.setName(name);
        nv.setGender(gender);

        mangnhanvien.add(nv);

        adapter.notifyDataSetChanged();

        etManv.setText("");
        etTennv.setText("");
        etManv.requestFocus();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
