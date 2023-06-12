package edu.poly.giaodienapplication.Bai5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import edu.poly.giaodienapplication.R;

public class Context_Popup_Menu_Fragment extends Fragment {
    private TextView tvContextMenu;
    private Button btnPopupMenu;


    public static Context_Popup_Menu_Fragment newInstance() {
        Context_Popup_Menu_Fragment fragment = new Context_Popup_Menu_Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_context__popup__menu_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvContextMenu = view.findViewById(R.id.tv_contextMenu);
        registerForContextMenu(tvContextMenu); // để kết nối với contextMenu
        // cho sự kiện, không có cũng được
        tvContextMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.showContextMenu();
            }
        });




        // không có 2 hàm mà nó là đối tượng của lớp popupmenu
        btnPopupMenu = view.findViewById(R.id.btn_popupMenu);
        btnPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getActivity(), btnPopupMenu);
                getActivity().getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.tiengAnh:
                                Toast.makeText(getActivity(), "Tiếng Anh", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.tiengPhap:
                                Toast.makeText(getActivity(), "Tiếng Pháp", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.tiengTrung:
                                Toast.makeText(getActivity(), "Tiếng Trung", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.tiengViet:
                                Toast.makeText(getActivity(), "Tiếng Việt", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.tiengA:
                                Toast.makeText(getActivity(), "Tiếng A", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.tiengB:
                                Toast.makeText(getActivity(), "Tiếng B", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show(); // show để hiển thị
            }
        });
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tiengAnh:
                Toast.makeText(getActivity(), "Tiếng Anh", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tiengPhap:
                Toast.makeText(getActivity(), "Tiếng Pháp", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tiengTrung:
                Toast.makeText(getActivity(), "Tiếng Trung", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tiengViet:
                Toast.makeText(getActivity(), "Tiếng Việt", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

}