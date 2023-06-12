package edu.poly.hoccontentprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvList;
    private Button btnShowDanhBa, btnShowImage;
    private List<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvList = findViewById(R.id.lv_list);
        btnShowDanhBa = findViewById(R.id.btn_show_danh_ba);
        btnShowImage = findViewById(R.id.btn_show_image);
        list = new ArrayList<>();

        btnShowDanhBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickXemDanhBa();
            }
        });

        btnShowImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    private void onclickXemDanhBa() {

        // dùng ContextCompat.checkSelfPermission(this, quyền) == checkSelfPermission(quyền)
        // kiểm tra máy xem đã cho phép truy cập vào trong danh bạ chưa nếu chư thì phải cấp quyền
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            // cú pháp requestPermissions(); hiện thông báo lên để người dùng có cho phép hay không
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_CONTACTS},
                    999);
        } else {
            // url là đường dẫn web đường dẫn online
            // uri là đường dẫn offline
            Uri uri = Uri.parse("content://contacts/people");

            // con trỏ để đọc dữ liệu từ sql, đọc dữ liệu từng dòng
            // đọc dữ liệu danh bạ cũng sử dụng cái này

            // contentResolver giúp cho một ứng dụng quản lý quyền truy cập đến dữ liệu được lưu bởi ứng dụng đó
            // máy ta như 1 sql vậy lên ta vẫn phải query
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);

            if(cursor.getCount() > 0) { // nếu có dữ liệu thì mới đọc
                cursor.moveToFirst();
                Toast.makeText(this, "Hihi", Toast.LENGTH_SHORT).show();
                while (!cursor.isAfterLast()) {
                    // lấy id danh bạ có ở trong máy
//                       String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    String name = "hihi";

                    list.add(name);
                    cursor.moveToNext();
                }

                // đó lại để không bị tràn bộ nhớ
                cursor.close();
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
                lvList.setAdapter(arrayAdapter);

            }

        }

    }
}