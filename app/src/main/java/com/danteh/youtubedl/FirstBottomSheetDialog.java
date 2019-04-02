//package com.example.youtubedl;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.google.android.material.bottomsheet.BottomSheetBehavior;
//import com.google.android.material.bottomsheet.BottomSheetDialog;
//
//import androidx.annotation.NonNull;
//
//public class FirstBottomSheetDialog extends BottomSheetDialog {
//
//    private ImageView ivAvatar;
//    private ImageView ivClose;
//    private TextView tvTitle;
//    private TextView tvSubTitle;
//    private Context context;
//    BottomSheetBehavior bottomSheetBehavior;
//
//    @SuppressLint("StaticFieldLeak")
//    private static FirstBottomSheetDialog instance;
//
//    public static FirstBottomSheetDialog getInstance(@NonNull Context context) {
//        return instance == null ? new FirstBottomSheetDialog(context) : instance;
//    }
//
//    public FirstBottomSheetDialog(@NonNull Context context) {
//        super(context);
//        this.context = context;
//        create();
//    }
//
//    public void create() {
//        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
//        setContentView(bottomSheetView);
//        bottomSheetBehavior = BottomSheetBehavior.from((View) bottomSheetView.getParent());
//
//        ivAvatar = bottomSheetView.findViewById(R.id.ivAvatar);
//        ivClose = bottomSheetView.findViewById(R.id.ivClose);
//        tvTitle = bottomSheetView.findViewById(R.id.tvTitle);
//        tvSubTitle = bottomSheetView.findViewById(R.id.tvSubTitle);
//    }
//}