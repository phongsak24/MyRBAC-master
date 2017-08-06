package com.example.rbac.phongsak.mai.myrbac.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.rbac.phongsak.mai.myrbac.R;
import com.example.rbac.phongsak.mai.myrbac.manager.MyAlert;
import com.example.rbac.phongsak.mai.myrbac.manager.PostUsertoServer;

public class SignUpFragment extends Fragment {
    private  String nameString,userString,passwordString;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup,container,false);
        return view;
    }//onCreateView

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Back Controller
        backController();
        //Save Controller
        saveController();


    }

    private void saveController() {
        ImageView imageView = (ImageView) getView().findViewById(R.id.imvSave);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get Value From EditText
                EditText nameEditText = (EditText) getView().findViewById(R.id.edtName);
                EditText userEditText = (EditText) getView().findViewById(R.id.txtUser);
                EditText passEditText = (EditText) getView().findViewById(R.id.txtPassword);

                nameString = nameEditText.getText().toString().trim();
                userString = userEditText.getText().toString().trim();
                passwordString = passEditText.getText().toString().trim();
                MyAlert myAlert = new MyAlert(getActivity());
                //Check Space
                if (nameString.equals("")||userString.equals("")||passwordString.equals("")) {
                    Log.d("6AugV1", "Have Space");
                    myAlert.myDialog("Have Space", "Please Fill All Every Blank");

                } else {
                    Log.d("6AugV1","No Space");
                    uploadValue();
                } //NO Space


            }//onClick
        });
    }

    private void uploadValue() {

        try {

            PostUsertoServer postUsertoServer = new PostUsertoServer(getActivity());
            postUsertoServer.execute(nameString,userString,passwordString,"http://androidthai.in.th/rbac/addDataMaster123.php");
            String strResult = postUsertoServer.get();
            Log.d("6AugV1", "Result==> " + strResult);
            if (Boolean.parseBoolean(strResult)) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.mainContainer, new MainFragment())
                        .commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void backController() {
        ImageView imageView = (ImageView) getView().findViewById(R.id.imvBack);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }
}//main Class
