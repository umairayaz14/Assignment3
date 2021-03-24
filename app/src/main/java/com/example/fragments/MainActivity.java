package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.fragments.models.UsersResponse;
import com.example.fragments.networking.Apiinterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragment_container_view, ThirdFragment.class, null)
                    .commit();
        }

        /*
        tv = findViewById(R.id.tev);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Apiinterface service = retrofit.create(Apiinterface.class);
        //Try service1 = retrofit.create(Try.class);

        Call<com.example.fragments.models.UsersResponse> call = service.getMultipleUser(10);
        call.enqueue(new Callback<UsersResponse>() {
            @Override
            public void onResponse(Call<UsersResponse> call, Response<UsersResponse> response) {



                Log.v("", response.body().toString());
                tv.setText(response.body().getResults().get(0).getName().getFirst());
                // ur[1] = response.body().getResults().get(1);
                //strr2[0] = ur[0].getName().getFirst();
                //strr2[1] = ur[1].getName().getFirst();

                //textview.setText(response.body().getResults().get(0).getName().getFirst());
                //textview2.setText(response.body().getResults().get(0).getName().getLast());
                //textview3.setText(response.body().getResults().get(0).getEmail());
                //textview4.setText(response.body().getResults().get(0).getGender());
                //textview5.setText(response.body().getResults().get(0).getCell());
                //Log.w("", r);
                //Picasso.get().load(response.body().getResults().get(0).getPicture().getLarge()).into(imageview);
                //Picasso.get().load(response.body().getResults().get(0).getName().getFirst()).into();
            }

            @Override
            public void onFailure(Call<UsersResponse> call, Throwable t) {

                Log.e("", t.getLocalizedMessage());
            }
        });

         */
    }

}