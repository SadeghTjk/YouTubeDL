package com.example.youtubedl;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;


public class BottomSheetFragment extends BottomSheetDialogFragment {

    static OnDialogSelectedListener mListener;
    static ArrayList items;
    String key ,quality;
    ListView lv;
    TextView closebtn;
    BottomSheetBehavior bottomSheetBehavior;
    public BottomSheetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;

        mListener = (OnDialogSelectedListener) activity;
    }


    // Container Activity must implement this interface
    public interface OnDialogSelectedListener {
        public void onDialogItemSelected(int quality);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL,R.style.BottomSheetDialogTheme);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_sheet_dialog, container, false);
        setCancelable(false);

        lv = view.findViewById(R.id.listview);

        Bundle bundle = getArguments();
        items = new ArrayList();

        if(bundle != null) {
            Log.e("bundle size: ", "onCreateView: " + bundle.size());
            for (int i = 0; i < bundle.size(); i++) {
                key = "key" + i;
                quality = bundle.getString(key);
                items.add(quality);
            }
            ArrayAdapter<String> itemsAdapter =
                    new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, items);
            lv.setAdapter(itemsAdapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    mListener.onDialogItemSelected(position);
                }
            });
        }
        return view;
    }


}
