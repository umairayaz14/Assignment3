package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.security.identity.SessionTranscriptMismatchException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.fragments.models.Result;
import com.example.fragments.models.UsersResponse;
import com.example.fragments.networking.Apiinterface;
import com.squareup.picasso.Cache;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView textview;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    UsersResponse ur = new UsersResponse();
    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
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
       Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Apiinterface service = retrofit.create(Apiinterface.class);
        //Try service1 = retrofit.create(Try.class);



        Call<com.example.fragments.models.UsersResponse> call = service.getMultipleUser(10);
        call.enqueue(new Callback<com.example.fragments.models.UsersResponse>() {
            @Override
            public void onResponse(Call<com.example.fragments.models.UsersResponse> call, Response<com.example.fragments.models.UsersResponse> response) {



                Log.v("", response.body().toString());
                ur = response.body();

                SecondFragment sfrag = new SecondFragment();
                Bundle result = new Bundle();
                //result.putString(SecondFragment.DATA_RECEIVE, ur.getResults().get(0).getName().getFirst());
                result.putSerializable(SecondFragment.DATA_RECEIVE, ur);
                sfrag.setArguments(result);
                // getActivity().getSupportFragmentManager().setFragmentResult(SecondFragment.DATA_RECEIVE, result);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragment_container_view, sfrag, null)
                        .commit();

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
            public void onFailure(Call<com.example.fragments.models.UsersResponse> call, Throwable t) {

                Log.e("", t.getLocalizedMessage());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vi =  inflater.inflate(R.layout.fragment_first, container, false);
        Button button = (Button) vi.findViewById(R.id.button1);
       button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ur!=null) {
                    SecondFragment sfrag = new SecondFragment();
                    Bundle result = new Bundle();
                    //result.putString(SecondFragment.DATA_RECEIVE, ur.getResults().get(0).getName().getFirst());
                    result.putSerializable(SecondFragment.DATA_RECEIVE, ur.getResults().get(0));
                    sfrag.setArguments(result);
                    // getActivity().getSupportFragmentManager().setFragmentResult(SecondFragment.DATA_RECEIVE, result);

                    getActivity().getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragment_container_view, sfrag, null)
                            .commit();
                }
            }
        });
                return vi;
    }
}