package com.example.youtubedl;

import android.app.Dialog;
import android.icu.text.MessagePattern;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dd.processbutton.iml.ActionProcessButton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements ProgressGenerator.OnCompleteListener, BottomSheetFragment.OnDialogSelectedListener {

    public static final String EXTRAS_ENDLESS_MODE = "EXTRAS_ENDLESS_MODE";
    ActionProcessButton btnSignIn;
    ProgressGenerator progressGenerator;
    EditText url;
    View buttomSheet;
    Youtube download;
    LinearLayout sheet;
    BottomSheetDialog dialog;
    BottomSheetFragment bsf;
    BottomSheetBehavior bottomSheetBehavior;
    static String s;
    static List<Youtube> list = new ArrayList<>();
    static Retrofit retrofit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = findViewById(R.id.url_input);
        progressGenerator = new ProgressGenerator(this);
        btnSignIn = findViewById(R.id.btnSignIn);

        download = new Youtube();
        bsf = new BottomSheetFragment();

        buttomSheet = getLayoutInflater().inflate(R.layout.fragment_bottom_sheet_dialog, null);
        dialog = new BottomSheetDialog(this);
        dialog.setContentView(buttomSheet);
        dialog.setCanceledOnTouchOutside(true);

        sheet = findViewById(R.id.sheet_bottom);
        bottomSheetBehavior = BottomSheetBehavior.from(sheet);



        final FirstBottomSheetDialog myBottomSheetDialog = FirstBottomSheetDialog.getInstance(this);
        myBottomSheetDialog.setTvTitle("Bottom Sheet Dialog");
        myBottomSheetDialog.setTvSubTitle("Read more...");
        myBottomSheetDialog.setCanceledOnTouchOutside(false);
        //Bundle extras = getIntent().getExtras();

        //if(extras != null && extras.getBoolean(EXTRAS_ENDLESS_MODE)) {
        btnSignIn.setMode(ActionProcessButton.Mode.ENDLESS);
        //} else {
        //btnSignIn.setMode(ActionProcessButton.Mode.PROGRESS);
        // }

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressGenerator.start(btnSignIn);
                final String s = url.getText().toString();

                (getmyClient().getAllURL("danteh-03c7c2df352b55ea", s)).enqueue(new Callback<Youtube>() {
                    @Override
                    public void onFailure(Call<Youtube> call, Throwable e) {
                        Log.e("teeest", "EREORORROROROROR: " + s + e.getMessage());
                        bsf.show(getSupportFragmentManager(), "quality");
                    }

                    @Override
                    public void onResponse(Call<Youtube> call, Response<Youtube> response) {
                        if (response.isSuccessful()) {
                            //list = response.body();
                            download = response.body();
                            Bundle bundle = new Bundle();

                            for(int i=0;i< download.getData().getVideo().getAdaptive().size() ; i++){
                                String key = "key" +i;
                                String value = download.getData().getVideo().getAdaptive().get(i).getQuality();
                                Log.e("resssss", "onResponse: "+value);
                                Log.e(key, "onResponse: ");
                                bundle.putString(key,value );
                            }
                            Log.e("size: ", "onResponse: "+download.getData().getVideo().getAdaptive().size() );
                            bsf.setArguments(bundle);

                            Log.e("errrrrrrrr", "to res: secc " + download.getData().getTitle());
                            Log.e("errrrrrrrr", "to res: secc " + download.getData().getVideo().getEncoded().get(0).getPUrl());

                            bsf.show(getSupportFragmentManager(), "quality");
                        }
                    }
                });
            }
        });
    }

    @Override
    public void onComplete() {
        Toast.makeText(this, "wow!", Toast.LENGTH_LONG).show();
    }

    public static ApiInterface getmyClient() {
        Log.e("errrrrrr", "before");
        if (retrofit == null) {
            OkHttpClient.Builder client = new OkHttpClient.Builder();
            client.connectTimeout(10, TimeUnit.SECONDS);
            client.readTimeout(10, TimeUnit.SECONDS);
            client.writeTimeout(10, TimeUnit.SECONDS);
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.vipapi.ir/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client.build())
                    .build();
            Log.e("errrrrrrrr", "getClient: to if");

        }
        Log.e("errrrrrrrr", "getClient: out if");
        return retrofit.create(ApiInterface.class);
    }


    @Override
    public void onDialogItemSelected(int position) {
        Toast.makeText(getApplicationContext(), "hahah " + position, Toast.LENGTH_LONG).show();
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
        bsf.dismiss();
    }
}



