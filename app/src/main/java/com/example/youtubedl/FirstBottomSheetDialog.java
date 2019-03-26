package com.example.youtubedl;

import android.support.design.widget.BottomSheetDialog;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FirstBottomSheetDialog extends BottomSheetDialog implements View.OnClickListener {

    private ImageView ivAvatar;
    private ImageView ivClose;
    private TextView tvTitle;
    private TextView tvSubTitle;
    private Context context;
    BottomSheetBehavior bottomSheetBehavior;

    @SuppressLint("StaticFieldLeak")
    private static FirstBottomSheetDialog instance;

    public static FirstBottomSheetDialog getInstance(@NonNull Context context) {
        return instance == null ? new FirstBottomSheetDialog(context) : instance;
    }

    public FirstBottomSheetDialog(@NonNull Context context) {
        super(context);
        this.context = context;
        create();
    }

    public void create() {
        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
        setContentView(bottomSheetView);
        bottomSheetBehavior = BottomSheetBehavior.from((View) bottomSheetView.getParent());
        BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                // do something
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                // do something
            }
        };

        ivAvatar = (ImageView) bottomSheetView.findViewById(R.id.ivAvatar);
        ivClose = (ImageView) bottomSheetView.findViewById(R.id.ivClose);
        tvTitle = (TextView) bottomSheetView.findViewById(R.id.tvTitle);
        tvSubTitle = (TextView) bottomSheetView.findViewById(R.id.tvSubTitle);

        ivAvatar.setOnClickListener(this);
        ivClose.setOnClickListener(this);
        tvTitle.setOnClickListener(this);

    }

    public void setIvAvatar(String url) {
        ivAvatar.setImageResource(R.drawable.ic_youtube);
    }

    public void setTvTitle(String tvTitle) {
        this.tvTitle.setText(tvTitle);
    }

    public void setTvSubTitle(String tvSubTitle) {
        this.tvSubTitle.setText(tvSubTitle);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvTitle:
//                hide();
                break;
            case R.id.ivClose:
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                break;
            case R.id.ivAvatar:
//                hide();
                break;
        }
    }
}