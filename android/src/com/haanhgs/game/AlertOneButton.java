package com.haanhgs.game;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class AlertOneButton extends DialogFragment {

    public interface OnButtonAlertClick {
        void onOkButtonClick();
    }

    private String title;
    private String content;
    private TextView tvTitleAlert;
    private TextView tvContentAlert;
    private Button bnOK;
    private OnButtonAlertClick listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void setListener(OnButtonAlertClick listener) {
        this.listener = listener;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private void initViews(View view){
        tvTitleAlert = view.findViewById(R.id.tvTitleAlert);
        tvContentAlert = view.findViewById(R.id.tvContentAlert);
        bnOK = view.findViewById(R.id.bnOKAlert);
    }

    private void handleOkButton(){
        bnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onOkButtonClick();
                dismiss();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.new_alert_one_button, container, false);
        if (getDialog() != null && getDialog().getWindow() != null){
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        initViews(view);
        if (title != null && content != null){
            tvTitleAlert.setText(title);
            tvContentAlert.setText(content);
        }
        handleOkButton();
        return view;
    }

}
