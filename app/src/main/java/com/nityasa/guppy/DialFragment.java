package com.nityasa.guppy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

public class DialFragment extends Fragment {

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragement_call, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Dial Number Phone");

        Button btnDial = getActivity().findViewById(R.id.btnDial);
        TextInputLayout numberPhone = getActivity().findViewById(R.id.number_phone);

        btnDial.setOnClickListener(v ->  {
            Intent intent = new Intent(Intent.ACTION_DIAL,
                                   Uri.parse("tel:" + Uri.encode(numberPhone.getEditText().getText().toString())));
            startActivity(intent);
        });
    }
}
