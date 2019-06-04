package com.example.administrator.testlayout;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

public class Fragment5 extends Fragment {
    PopupWindow popupWindow;
    @Nullable
    /*@Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment5, container, false);
    }*/

    @Override
    public void onStart() {
        View view = this.getActivity().getLayoutInflater().inflate(R.layout.fragment5, null);
        popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setAnimationStyle(R.style.pop_anim);
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        //透明度变暗
        backgroundAlpha(0.7f);
        //添加popupwindow消失监听
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                //还原透明度
                backgroundAlpha(1.0f);
            }
        });
        super.onStart();
    }


    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = this.getActivity().getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        this.getActivity().getWindow().setAttributes(lp);
    }

}
