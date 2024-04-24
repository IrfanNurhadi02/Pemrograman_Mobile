package com.example.tugasprak4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.DialogFragment;


public class ConfirmDialogFragment extends DialogFragment implements View.OnClickListener {
    private Button btnBatal;
    private Button btnHapus;
    private DialogListener dialogListener;
    private Post post;

    interface DialogListener {
        void setOnClickDeleteButton();
    }

    public void setOnClickDeleteButtonListener(DialogListener dialogListener) {
        this.dialogListener = dialogListener;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_confirm_dialog, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnBatal = view.findViewById(R.id.button_cancel);
        btnHapus = view.findViewById(R.id.button_delete);
        if (getArguments() != null) {
            post = getArguments().getParcelable("post");
        }
        btnBatal.setOnClickListener(this);
        btnHapus.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_cancel) {
            getDialog().cancel();
        } else if (view.getId() == R.id.button_delete) {
            DataSource.posts.remove(post);
            dialogListener.setOnClickDeleteButton();
            getDialog().dismiss();
        }
    }

}
