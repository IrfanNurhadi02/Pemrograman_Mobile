package com.example.prak06;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.prak06.Fragment.ErrorFragment;
import com.example.prak06.Model.User;
import com.example.prak06.Response.UserResponse2;
import com.example.prak06.Retrofit.RetrofitClient;
import com.squareup.picasso.Picasso;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {

    private ApiService apiService;
    private ProgressBar loading;
    private ConstraintLayout screen;
    private ImageView pfp, rectangle;
    private TextView name;
    private TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);

        apiService = RetrofitClient.getClient().create(ApiService.class);
        loading = findViewById(R.id.loading);
        screen = findViewById(R.id.screen);
        pfp = findViewById(R.id.pfp);
        name = findViewById(R.id.nama);
        email = findViewById(R.id.email);
        rectangle = findViewById(R.id.rectangle);

        int userID = getIntent().getIntExtra("id", 1);

        FragmentManager fragmentManager = getSupportFragmentManager();
        ErrorFragment errorFragment = new ErrorFragment();
        Fragment fragment = fragmentManager.findFragmentByTag(ErrorFragment.class.getSimpleName());

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
        Handler handler = new Handler(getMainLooper());
            handler.post(() -> {
                pfp.setVisibility(View.GONE);
                name.setVisibility(View.GONE);
                email.setVisibility(View.GONE);
                rectangle.setVisibility(View.GONE);
                loading.setVisibility(View.VISIBLE);
            });

            Call<UserResponse2> call = apiService.getUserById(userID);

            call.enqueue(new Callback<UserResponse2>() {
                @Override
                public void onResponse(Call<UserResponse2> call, Response<UserResponse2> response) {
                    if (response.isSuccessful()) {
                        User user = response.body().getData();

                        handler.post(() -> {
                            Picasso.get().load(user.getAvatar()).into(pfp);
                            name.setText(user.getFirst_name() + " " + user.getLast_name());
                            email.setText(user.getEmail());

                            pfp.setVisibility(View.VISIBLE);
                            name.setVisibility(View.VISIBLE);
                            email.setVisibility(View.VISIBLE);
                            rectangle.setVisibility(View.VISIBLE);
                            loading.setVisibility(View.GONE);
                        });
                    } else {
                        System.out.println(response);
                        if (!(fragment instanceof ErrorFragment)) {
                            fragmentManager
                                    .beginTransaction()
                                    .add(R.id.screen, errorFragment)
                                    .commit();
                        }
                    }
                }

                @Override
                public void onFailure(Call<UserResponse2> call, Throwable t) {
                    System.out.println(t);
                    if (!(fragment instanceof ErrorFragment)) {
                        fragmentManager
                                .beginTransaction()
                                .add(R.id.screen, errorFragment)
                                .commit();
                    }
                }
            });
        });
    }
}
