package edu.poly.hoccontentprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private ListView lvBai2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lvBai2 = findViewById(R.id.lv_bai2);

        permissionActivity();
    }

    private void permissionActivity() {
        if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // xin quyền truy cập ảnh trong máy
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},
                    999);
        }
            // tạo list chuỗi chứa dữ liệu
            List<String> list = new ArrayList<>();

            // những thứ cần lấy trong ảnh
            String[] projection = {
                    MediaStore.Images.ImageColumns._ID,
                    MediaStore.Images.ImageColumns.DISPLAY_NAME,
                    MediaStore.Images.ImageColumns.DATA // lấy dữ liệu của ảnh theo dạng 010101
            };

            // dùng con trỏ để lấy dữ liệu
            Cursor cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection,
                    null, null, null, null);


            // nếu có dữ liệu thì mới đọc

            if(cursor.getCount() > 0) {
                cursor.moveToFirst();


                while (!cursor.isAfterLast()) {
                    String data = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                    // lấy dữ liệu dưới dạng nhị phân hay còn gọi là bipmap của ảnh
                    Toast.makeText(this, "hihi", Toast.LENGTH_SHORT).show();

                    list.add(data);
                    cursor.moveToNext();
                }

                // đó con trỏ khỏ tràn dữ liệu
                cursor.close();

                ShowImageAdapter adapter = new ShowImageAdapter(this, list);
                lvBai2.setAdapter(adapter);
            }
    }
}