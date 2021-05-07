package com.example.webview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentGo extends Fragment {
        String url;
    Button btnGo;
    EditText edt;
    public static FragmentGo newInstance() {

        Bundle args = new Bundle();

        FragmentGo fragment = new FragmentGo();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_go, container,false);
        btnGo = view.findViewById(R.id.btn_go);
        edt = view.findViewById(R.id.edt_content);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = edt.getText().toString();
                if(url.length()==0){
                    Toast.makeText(getContext(),"Please enter url",Toast.LENGTH_SHORT).show();
                }
                else{
                    Fragment fragment = FragmentWebView.newInstance(url);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.addToBackStack("go");
                    fragmentTransaction.replace(R.id.fragment_layout, fragment);
                    fragmentTransaction.commit();
                }
            }
        });
        return view;
    }

}
