package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragments.models.Result;
import com.example.fragments.models.UsersResponse;
import com.example.fragments.networking.Apiinterface;
import com.example.fragments.networking.CustomAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView r;
    String strr[] = {"Lucie", "Andreas", "Matthew"};
    String strr2[];
    Result ur[];
    TextView tv;
    //boolean fl[];
    //boolean f2;
    //int x;
    public ThirdFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThirdFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThirdFragment newInstance(String param1, String param2) {
        ThirdFragment fragment = new ThirdFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        ur = new Result[3];
        strr2 = new String[3];
        //fl = new boolean[3];
        //f2 = true;
        //x =0;
        /*
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Apiinterface service = retrofit.create(Apiinterface.class);
        //Try service1 = retrofit.create(Try.class);

        Call<com.example.fragments.models.UsersResponse> call = service.getMultipleUser(10);
        call.enqueue(new Callback<UsersResponse>() {
            @Override
            public void onResponse(Call<com.example.fragments.models.UsersResponse> call, Response<UsersResponse> response) {



                Log.v("", response.body().toString());
                ur[0] = response.body().getResults().get(0);
               // ur[1] = response.body().getResults().get(1);
                strr2[0] = ur[0].getName().getFirst();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view =  inflater.inflate(R.layout.fragment_third, container, false);

        tv = view.findViewById(R.id.text_view);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Apiinterface service = retrofit.create(Apiinterface.class);
        //Try service1 = retrofit.create(Try.class);

        Call<com.example.fragments.models.UsersResponse> call = service.getMultipleUser(10);
        call.enqueue(new Callback<UsersResponse>() {
            @Override
            public void onResponse(Call<com.example.fragments.models.UsersResponse> call, Response<UsersResponse> response) {



                Log.v("", response.body().toString());
                //ur[0] = response.body().getResults().get(0);
                // ur[1] = response.body().getResults().get(1);
                strr2[0] = response.body().getResults().get(0).getName().getFirst();
                strr2[1] = response.body().getResults().get(1).getName().getFirst();
                strr2[2] = response.body().getResults().get(2).getName().getFirst();
                //strr2[1] = ur[1].getName().getFirst();
                tv.setText(strr2[0]);

              // for (int i=0;i<strr2.length;i++)
               // {
                   // Log.d("Strings", strr2[i]);
                    //if (strr2[i] == null)
                   // {
                        //fl[i] = false;
                     //   x = x + 1;
                    //}
                //};

                /*
                if (x == 3)
                {
                    f2 = false;
                };
                */

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
        //tv.setText(strr2[0]);

        r = view.findViewById(R.id.recycler_view);
       // if (f2 != false)
        //{
            r.setAdapter(new CustomAdapter(strr));
            r.setLayoutManager(new LinearLayoutManager(getActivity()));
            r.getAdapter().notifyDataSetChanged();
        //};

        return view;
    }
}
