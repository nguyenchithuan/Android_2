package edu.poly.giaodienapplication.Bai6;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import edu.poly.giaodienapplication.R;

public class DialogDemoFragment extends Fragment implements View.OnClickListener{
    private Button btnSimDialog, btnCustomDialog, btnItemDialog, btnChoiceDialog, btnMultiChoiceDialog;
    private String arrayMH[] = {"Toán", "Lý", "Hóa", "Anh", "Văn"};
    private boolean[] mangBoolean = {false, false, false, false, false};
    String ten = "";



    public static DialogDemoFragment newInstance() {
        DialogDemoFragment fragment = new DialogDemoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dialog_demo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnSimDialog = view.findViewById(R.id.btnSimDialog);
        btnCustomDialog = view.findViewById(R.id.btnCustomlog);
        btnItemDialog = view.findViewById(R.id.btnItemDialog);
        btnChoiceDialog = view.findViewById(R.id.btnChoiceDialog);
        btnMultiChoiceDialog = view.findViewById(R.id.btnMultiChoiceDialog);

        btnSimDialog.setOnClickListener(this); // đăng ký sự kiện bằng từ khóa this
        btnCustomDialog.setOnClickListener(this);
        btnItemDialog.setOnClickListener(this);
        btnChoiceDialog.setOnClickListener(this);
        btnMultiChoiceDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSimDialog:
                showSimpleDialog();
                break;
            case R.id.btnCustomlog:
                showCustomDialog();
                break;
            case R.id.btnItemDialog:
                showItemDialog();
                break;
            case R.id.btnChoiceDialog:
                showChoiceDialog();
                break;
            case R.id.btnMultiChoiceDialog:
                showMultiChoiceDialog();
                break;
        }
    }




    private void showSimpleDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Class 17314");
        builder.setMessage("Đa phần đẹp trai nhưng mỗi tội lười");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "Ok", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }


    private void showCustomDialog() {
        Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // để trc setLayout bỏ title
        dialog.setContentView(R.layout.layout_custom_dialog);
        Button btnOk = dialog.findViewById(R.id.btnOk);
        Button btnCancel = dialog.findViewById(R.id.btnCancel);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "OK", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        dialog.show();
    }

    private void showItemDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Chọn Môn Học");
        // setMessage thì không setItems nữa
        builder.setItems(arrayMH, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), arrayMH[which], Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }


    private void showChoiceDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Chọn Môn Học");

        // 0 check ở item đầu tiên
        builder.setSingleChoiceItems(arrayMH, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ten = arrayMH[which];
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), ten, Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }

    private void showMultiChoiceDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Chọn Môn Học");

        builder.setMultiChoiceItems(arrayMH, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                mangBoolean[which] = isChecked;
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for (int i = 0; i < arrayMH.length; i++) {
                    if(mangBoolean[i]) {
                        ten += arrayMH[i];
                    }
                }
                Toast.makeText(getContext(), ten, Toast.LENGTH_SHORT).show();
                for (int i = 0; i < mangBoolean.length; i++) {
                    mangBoolean[i] = false;
                }
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        ten = "";
        builder.show();
    }
}