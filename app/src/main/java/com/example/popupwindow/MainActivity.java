package com.example.popupwindow;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private PopupWindow popupWindow = null;
    private Button btnConfirm, btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        btnShow = (Button) findViewById(R.id.btnShow);
        btnShow.setOnClickListener(listener);

        initPopupWindow();
    }


    private void initPopupWindow() {

        View view = LayoutInflater.from(context).inflate(R.layout.popupwindow_layout, null);
        popupWindow = new PopupWindow(view);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(false);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        btnConfirm = (Button) view.findViewById(R.id.btnConform);
        btnConfirm.setOnClickListener(listener);

    }

    public View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {

                case R.id.btnShow:
                    popupWindow.showAtLocation(view, Gravity.CENTER_HORIZONTAL, 0, 0);
                    break;

                case R.id.btnConform:
                    popupWindow.dismiss();
                    break;
            }
        }
    };


}
