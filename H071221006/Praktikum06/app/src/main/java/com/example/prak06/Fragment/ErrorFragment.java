package com.example.prak06.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.prak06.ApiService;
import com.example.prak06.R;
import com.example.prak06.Response.UserResponse;
import com.example.prak06.Retrofit.RetrofitClient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ErrorFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_error, container, false);
    }


    AppCompatButton retry;
    TextView noConnectionText;
    ProgressBar loading;
    private ApiService apiService;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        retry = view.findViewById(R.id.retry);
        noConnectionText = view.findViewById(R.id.text);
        loading = view.findViewById(R.id.loading);

        apiService = RetrofitClient.getClient().create(ApiService.class);

        Runnable runnable = () -> {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(() -> {
                noConnectionText.setVisibility(View.GONE);
                retry.setVisibility(View.GONE);
                loading.setVisibility(View.VISIBLE);
            });
            Call<UserResponse> call = apiService.getUsers(1, 6);

            call.enqueue(new Callback<UserResponse>() {
                @Override
                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                    if (response.isSuccessful()) {
                        getActivity().getSupportFragmentManager().beginTransaction().remove(ErrorFragment.this).commit();
                        getActivity().recreate();
                    } else {
                        handler.post(() -> {
                            loading.setVisibility(View.GONE);
                            noConnectionText.setVisibility(View.VISIBLE);
                            retry.setVisibility(View.VISIBLE);
                        });
                    }
                }

                @Override
                public void onFailure(Call<UserResponse> call, Throwable t) {
                    handler.post(() -> {
                        loading.setVisibility(View.GONE);
                        noConnectionText.setVisibility(View.VISIBLE);
                        retry.setVisibility(View.VISIBLE);
                    });
                }
            });
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(runnable);

        retry.setOnClickListener(v -> {
            executorService.execute(runnable);
        });

    }
}