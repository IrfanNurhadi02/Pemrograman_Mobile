package com.example.praktikum_5.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.praktikum_5.DataSource;
import com.example.praktikum_5.Instagram;
import com.example.praktikum_5.R;
import com.example.praktikum_5.SearchAdapter;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchFragment extends Fragment {

    private RecyclerView rv_search;
    private EditText searchprofile;
    private ProgressBar progressBar;

    Executor executor = Executors.newSingleThreadExecutor();
    Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewsearch = inflater.inflate(R.layout.fragment_search, container, false);
        rv_search = viewsearch.findViewById(R.id.rv_search);
        searchprofile = viewsearch.findViewById(R.id.editTextSearch);
        progressBar = viewsearch.findViewById(R.id.progressBar);

        rv_search.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_search.setHasFixedSize(true);

        ImageButton btnClearText = viewsearch.findViewById(R.id.btnClearText);
        btnClearText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Menghapus teks pada EditText
                searchprofile.setText("");
            }
        });

        searchprofile.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Menampilkan loading bar saat pengguna mengetik
                progressBar.setVisibility(View.VISIBLE);
                // Menggunakan Handler untuk menjalankan pencarian setelah jeda
                handler.removeCallbacksAndMessages(null);
                handler.postDelayed(() -> {
                    if (!s.toString().isEmpty()) { // Tambahkan pengecekan apakah teks tidak kosong
                        ArrayList<Instagram> searchingthis = searchProfile(s.toString());
                        SearchAdapter searchAdapter = new SearchAdapter(searchingthis);
                        rv_search.setAdapter(searchAdapter);
                    } else {
                        // Jika teks kosong, atur adapter dengan daftar kosong
                        SearchAdapter searchAdapter = new SearchAdapter(new ArrayList<>());
                        rv_search.setAdapter(searchAdapter);
                    }
                    // Menghilangkan loading bar setelah pencarian selesai
                    progressBar.setVisibility(View.GONE);
                }, 500); // Ubah angka ini sesuai dengan kebutuhan jeda
            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return viewsearch;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView IV_Home = view.findViewById(R.id.IV_Home);
        ImageView IV_Postingan = view.findViewById(R.id.IV_Post);
        ImageView iv_profile = view.findViewById(R.id.IV_Profile);

        IV_Home.setOnClickListener(v -> {
            HomeFragment homeFragment = new HomeFragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, homeFragment)
                    .addToBackStack(null)
                    .commit();
        });

        IV_Postingan.setOnClickListener(v -> {
            PostinganFragment postinganFragment = new PostinganFragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, postinganFragment)
                    .addToBackStack(null)
                    .commit();
        });

        iv_profile.setOnClickListener(v -> {
            ProfileFragment profileFragment = new ProfileFragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, profileFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }

    public ArrayList<Instagram> searchProfile(String searchinput) {

        ArrayList<Instagram> searching = new ArrayList<>();
        Pattern pattern = Pattern.compile(Pattern.quote(searchinput), Pattern.CASE_INSENSITIVE);
        executor.execute(() -> {
            ArrayList<Instagram> users = DataSource.instagrams;
            for (Instagram user : users) {
                Matcher matcher = pattern.matcher(user.getName());
                Matcher matcher1 = pattern.matcher(user.getUsername());
                if (matcher.find() || matcher1.find()) {
                    if (!Objects.equals(user.getName(), "Gabe Newell"))
                        searching.add(user);
                }
            }
        });
        return searching;

    }
}
