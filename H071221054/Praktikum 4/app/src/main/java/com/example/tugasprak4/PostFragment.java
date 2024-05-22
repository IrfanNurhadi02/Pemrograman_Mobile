package com.example.tugasprak4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class PostFragment extends Fragment {
    private EditText descriptionEt;
    private ImageView imgContentIv;
    private Button postingBtn;
    private Uri selectedImg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_post, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!(requireActivity() == null || ((AppCompatActivity) requireActivity()).getSupportActionBar() == null)) {
            ((AppCompatActivity) requireActivity()).getSupportActionBar().setTitle("Add Post");
        }
        descriptionEt = view.findViewById(R.id.descriptionEt);
        imgContentIv = view.findViewById(R.id.imgContentIv);
        postingBtn = view.findViewById(R.id.postingBtn);
        imgContentIv.setOnClickListener(v -> openGallery());
        postingBtn.setOnClickListener(v -> submitPost());
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 1);
    }

    private void submitPost() {
        if (descriptionEt.getText().toString().isEmpty()) {
            Toast.makeText(getActivity(), "Konten Masih Kosong", Toast.LENGTH_LONG).show();
        } else if (selectedImg == null) {
            Toast.makeText(getActivity(), "Pilih Gambar Terlebih Dahulu", Toast.LENGTH_LONG).show();
        } else {
            HomeFragment homeFragment = new HomeFragment();
            Post newPost = new Post(selectedImg, descriptionEt.getText().toString(), DataSource.user);
            Bundle bundle = new Bundle();
            bundle.putParcelable(HomeFragment.EXTRA_POST, newPost);
            homeFragment.setArguments(bundle);
            getParentFragmentManager().beginTransaction().replace(((ViewGroup) requireView().getParent()).getId(), homeFragment, HomeFragment.class.getSimpleName()).commit();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == AppCompatActivity.RESULT_OK && requestCode == 1) {
            if (data != null) {
                selectedImg = data.getData();
                imgContentIv.setImageURI(selectedImg);
            } else {
                Toast.makeText(getActivity(), "Data Kosong", Toast.LENGTH_LONG).show();
            }
        }
    }
}
