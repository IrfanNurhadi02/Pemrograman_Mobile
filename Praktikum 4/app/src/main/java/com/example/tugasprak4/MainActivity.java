package com.example.tugasprak4;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FragmentManager fragmentManager = getSupportFragmentManager();
    private ImageView homeIconMenuIv;
    private TextView homeTextMenuTv;
    private LinearLayout homeLayout;
    private LinearLayout postingLayout;
    private LinearLayout profileLayout;
    private ImageView postIconMenuIv;
    private TextView postTextMenuTv;
    private ImageView profileIconMenuIv;
    private TextView profileTextMenuTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        HomeFragment homeFragment = new HomeFragment();
        if (!(fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName()) instanceof HomeFragment)) {
            fragmentManager.beginTransaction().replace(R.id.frame_layout, homeFragment, HomeFragment.class.getSimpleName()).commit();
        }
        homeLayout.setOnClickListener(this);
        postingLayout.setOnClickListener(this);
        profileLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == homeLayout) {
            onClickMenu(homeLayout);
        } else if (v == postingLayout) {
            onClickMenu(postingLayout);
        } else if (v == profileLayout) {
            onClickMenu(profileLayout);
        }
    }

    public void isActiveHomeMenu(boolean isActive) {
        if (isActive) {
            homeIconMenuIv.setColorFilter(ContextCompat.getColor(this, R.color.primaryColor));
            homeTextMenuTv.setTextColor(ContextCompat.getColor(this, R.color.primaryColor));
        } else {
            homeIconMenuIv.setColorFilter(ContextCompat.getColor(this, R.color.dividerColor));
            homeTextMenuTv.setTextColor(ContextCompat.getColor(this, R.color.dividerColor));
        }
    }

    public void isActivePostMenu(boolean isActive) {
        if (isActive) {
            postIconMenuIv.setColorFilter(ContextCompat.getColor(this, R.color.primaryColor));
            postTextMenuTv.setTextColor(ContextCompat.getColor(this, R.color.primaryColor));
        } else {
            postIconMenuIv.setColorFilter(ContextCompat.getColor(this, R.color.dividerColor));
            postTextMenuTv.setTextColor(ContextCompat.getColor(this, R.color.dividerColor));
        }
    }

    public void isActiveProfileMenu(boolean isActive) {
        if (isActive) {
            profileIconMenuIv.setColorFilter(ContextCompat.getColor(this, R.color.primaryColor));
            profileTextMenuTv.setTextColor(ContextCompat.getColor(this, R.color.primaryColor));
        } else {
            profileIconMenuIv.setColorFilter(ContextCompat.getColor(this, R.color.dividerColor));
            profileTextMenuTv.setTextColor(ContextCompat.getColor(this, R.color.dividerColor));
        }
    }


    private void onClickMenu(LinearLayout linearLayout) {
        Fragment selectedFragment;
        String fragmentName = "";
        if (linearLayout == homeLayout) {
            selectedFragment = new HomeFragment();
            fragmentName = HomeFragment.class.getSimpleName();
            isActiveHomeMenu(true);
            isActivePostMenu(false);
            isActiveProfileMenu(false);
        } else if (linearLayout == postingLayout) {
            selectedFragment = new PostFragment();
            fragmentName = PostFragment.class.getSimpleName();
            isActiveHomeMenu(false);
            isActivePostMenu(true);
            isActiveProfileMenu(false);
        } else if (linearLayout == profileLayout) {
            selectedFragment = new ProfileFragment();
            fragmentName = ProfileFragment.class.getSimpleName();
            isActiveHomeMenu(false);
            isActivePostMenu(false);
            isActiveProfileMenu(true);
        } else {
            return;
        }
        if (fragmentManager.findFragmentByTag(fragmentName) == null) {
            fragmentManager.beginTransaction().replace(R.id.frame_layout, selectedFragment, fragmentName).commit();
        }
    }

    private void initView() {
        homeIconMenuIv = findViewById(R.id.home_icon);
        homeTextMenuTv = findViewById(R.id.home_text);
        postIconMenuIv = findViewById(R.id.posting_icon);
        postTextMenuTv = findViewById(R.id.posting_text);
        profileIconMenuIv = findViewById(R.id.profile_icon);
        profileTextMenuTv = findViewById(R.id.profile_text);
        homeLayout = findViewById(R.id.home_layout);
        postingLayout = findViewById(R.id.posting_layout);
        profileLayout = findViewById(R.id.profile_layout);

        isActiveHomeMenu(true);
        isActivePostMenu(false);
        isActiveProfileMenu(false);
    }


}
