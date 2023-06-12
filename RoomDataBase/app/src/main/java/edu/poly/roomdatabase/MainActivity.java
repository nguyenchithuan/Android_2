package edu.poly.roomdatabase;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.poly.roomdatabase.adapter.UserAdapter;
import edu.poly.roomdatabase.database.UserDatabase;
import edu.poly.roomdatabase.objects.User;

public class MainActivity extends AppCompatActivity implements UserAdapter.InterfaceClickItemUser {
    private EditText edUsername;
    private EditText edAddress;
    private Button btnAddUser;
    private RecyclerView rcvUser;
    private TextView tvDeleteAll;

    private UserAdapter adapter;
    private ArrayList<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout manhinhcho = findViewById(R.id.manhinhcho);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                manhinhcho.setVisibility(View.INVISIBLE);
            }
        }, 1000);

        edUsername = findViewById(R.id.ed_username);
        edAddress = findViewById(R.id.ed_address);
        btnAddUser = findViewById(R.id.btn_add_user);
        rcvUser = findViewById(R.id.rcv_user);

        tvDeleteAll = findViewById(R.id.tvDeleteAll);
        tvDeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAll();
            }
        });

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcvUser.setLayoutManager(manager);

        adapter = new UserAdapter(this, this);

        capnhatAdapter();

        rcvUser.setAdapter(adapter);

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });
    }

    private void deleteAll() {
        UserDatabase.getInstance(this).userDao().deleteAll();
        capnhatAdapter();
    }

    private void addUser() {
        String strUserName = edUsername.getText().toString().trim();
        String strAddress = edAddress.getText().toString().trim();

        if (strAddress.isEmpty() || strUserName.isEmpty()) {
            Toast.makeText(this, "Dữ liệu null!", Toast.LENGTH_SHORT).show();
            return;
        }

        User user = new User(strUserName, strAddress);

        if (isUserCheck(user) == false) {
            Toast.makeText(this, "Đã có tên user", Toast.LENGTH_SHORT).show();
            return;
        }

        UserDatabase.getInstance(this).userDao().inser(user);
        Toast.makeText(this, "Add user successfully", Toast.LENGTH_SHORT).show();

        edAddress.setText("");
        edUsername.setText("");

        capnhatAdapter();

        hideKeyboard(this);
    }

    public void capnhatAdapter() {
        list = (ArrayList<User>) UserDatabase.getInstance(this).userDao().selectAll();
        adapter.setData(list);
    }


    public boolean isUserCheck(User user) {
        List<User> list1 = UserDatabase.getInstance(this).userDao().checkUser(user.getUsername());
        return list1.size() == 0;
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == RESULT_OK) {
                capnhatAdapter();
                Toast.makeText(MainActivity.this, "hihi", Toast.LENGTH_SHORT).show();
            }
        }
    });

    @Override
    public void updateUser(User user) {
        Intent intent = new Intent(this, UpdateActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("objects", user);
        intent.putExtras(bundle);
        activityResultLauncher.launch(intent);
    }

    @Override
    public void deleteUser(User user) {
        UserDatabase.getInstance(this).userDao().delete(user);
        capnhatAdapter();
        Toast.makeText(this, "Xóa thành công!", Toast.LENGTH_SHORT).show();
    }

}