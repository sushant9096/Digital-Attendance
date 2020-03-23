package com.example.digitalattendance.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.digitalattendance.MainActivity;
import com.example.digitalattendance.R;
import com.google.android.material.textfield.TextInputEditText;

public class SlideshowFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel = ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        Button btn_sub = root.findViewById(R.id.btn_submit);
        final TextInputEditText student_name_in = root.findViewById(R.id.std_name);
        final TextInputEditText roll_no_in = root.findViewById(R.id.rol_no);
        final TextInputEditText branch_in = root.findViewById(R.id.branch);
        final TextInputEditText email_in = root.findViewById(R.id.email);
        final TextInputEditText pwd_in = root.findViewById(R.id.pwd);

        ((MainActivity)getActivity()).setRGTitle("Hello World!");

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((student_name_in.getText().toString().isEmpty()) && (roll_no_in.getText().toString().isEmpty()) && (branch_in.getText().toString().isEmpty()) && (email_in.getText().toString().isEmpty()) && (pwd_in.getText().toString().isEmpty())){
                    Toast.makeText(getContext(),"Fill All Fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    String student_name = student_name_in.getText().toString();
                    String roll_no = roll_no_in.getText().toString();
                    String branch = branch_in.getText().toString();
                    String email = email_in.getText().toString();
                    String pwd = pwd_in.getText().toString();

                    ((MainActivity)getActivity()).FirebaseAuthReg(email, pwd, student_name, roll_no, branch);
                    student_name_in.setText(" ");
                    roll_no_in.setText(" ");
                    branch_in.setText(" ");
                    email_in.setText(" ");
                    pwd_in.setText(" ");
                }
            }
        });

        return root;
    }
}
