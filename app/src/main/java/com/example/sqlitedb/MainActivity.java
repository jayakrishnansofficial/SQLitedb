package com.example.sqlitedb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AppCompatEditText usernameedt , passwordedt , currentnameedt , newnameedt , deleteedt;
    AppCompatButton adduserbtn , viewdatabtn , updatebtn , deletebtn;

  // DatabaseAdapter helper;

    DatabaseAdapter helper;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameedt = findViewById(R.id.usernameedittext_id);
        passwordedt = findViewById(R.id.passwordedittext_id);
        currentnameedt = findViewById(R.id.currentnameeditext_id);
        newnameedt = findViewById(R.id.newnameedittext_id);
        deleteedt = findViewById(R.id.deleteedittext_id);

        adduserbtn = findViewById(R.id.adduserbtn_id);
        viewdatabtn = findViewById(R.id.viewdatabtn_id);
        updatebtn = findViewById(R.id.updatebtn_id);
        deletebtn = findViewById(R.id.deletebtn_id);

        helper = new DatabaseAdapter(this);

     //   helper = new DatabaseAdapter(this);


        adduserbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameedt.getText().toString();
                String password = passwordedt.getText().toString();

                if (username.isEmpty() || password.isEmpty()){
                    Toast.makeText(getApplicationContext(),"ENTER USERNAME AND PASSWORD",Toast.LENGTH_SHORT).show();
                }else {
                    long id = helper.insertdata(username,password);
                    if (id<=0){
                        Toast.makeText(getApplicationContext(),"unsuccessfull",Toast.LENGTH_SHORT).show();
                        usernameedt.setText("");
                        passwordedt.setText("");
                    }else {
                        Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_SHORT).show();
                        usernameedt.setText("");
                        passwordedt.setText("");
                    }
                }

            }
        });




//                            //+++++++++++++++++++++++ADDING DATA++++++++++++++++++++++++//
//
//        adduserbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String username = usernameedt.getText().toString();
//                String password = passwordedt.getText().toString();
//                if (username.isEmpty() || password.isEmpty())
//                {
//                    Toast.makeText(getApplicationContext(),"ENTER USERNAME AND PASSWORD",Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    long id = helper.insertData(username,password);
//                    if (id<=0) {
//                        Toast.makeText(getApplicationContext(), "INSERTION UNSUCCESSFULL", Toast.LENGTH_SHORT).show();
//                        usernameedt.setText("");
//                        passwordedt.setText("");
//                    }
//                    else
//                    {
//                        Toast.makeText(getApplicationContext(),"INSERTION SUCCESSFULL",Toast.LENGTH_SHORT).show();
//                        usernameedt.setText("");
//                        passwordedt.setText("");
//
//                    }
//                }
//
//            }
//        });

        viewdatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = helper.getdata();
                Toast.makeText(getApplicationContext(), data ,Toast.LENGTH_SHORT).show();
            }
        });
//
//
//                                //+++++++++++++++++++++ VIEW DATA +++++++++++++++++//
//
//
//        viewdatabtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String data = helper.getData();
//                Toast.makeText(getApplicationContext(), data , Toast.LENGTH_SHORT).show();
//            }
//        });
//
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentusername = currentnameedt.getText().toString();
                String newusername = newnameedt.getText().toString();

                if (currentusername.isEmpty()||newusername.isEmpty()){
                    Toast.makeText(getApplicationContext(),"ENTER DATA" ,Toast.LENGTH_SHORT).show();
                }else {
                    int a = helper.updatename(currentusername,newusername);
                    if (a<=0){
                        Toast.makeText(getApplicationContext(),"UNSUCCESFULL ",Toast.LENGTH_SHORT).show();
                        currentnameedt.setText("");
                        newnameedt.setText("");
                    }else {
                        Toast.makeText(getApplicationContext(),"SUCCESFULL ",Toast.LENGTH_SHORT).show();
                        currentnameedt.setText("");
                        newnameedt.setText("");
                    }
                }
            }
        });

//                                //++++++++++++++++++UPDATING DATA+++++++++++++++++//
//
//        updatebtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String currentusername = currentnameedt.getText().toString();
//                String newusername = newnameedt.getText().toString();
//
//                if (currentusername.isEmpty()||newusername.isEmpty()){
//                    Toast.makeText(getApplicationContext()," ENTER DATA " , Toast.LENGTH_SHORT ).show();
//
//                }else {
//                    int a = helper.updatename(currentusername,newusername);
//                    if (a<=0){
//                        Toast.makeText(getApplicationContext(),"UNSUCCESSFULL",Toast.LENGTH_SHORT).show();
//                        currentnameedt.setText("");
//                        newnameedt.setText("");
//                    } else {
//                        Toast.makeText(getApplicationContext(),"UPDATED",Toast.LENGTH_SHORT).show();
//                        currentnameedt.setText("");
//                        newnameedt.setText("");
//                    }
//                }
//
//
//            }
//        });

        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = deleteedt.getText().toString();
                if (username.isEmpty()){
                    Toast.makeText(getApplicationContext()," ENTER DATA " , Toast.LENGTH_SHORT ).show();

                }else {
                    int a= helper.delete(username);
                    if (a<=0){
                        Toast.makeText(getApplicationContext(),"UNSUCCESSFULL",Toast.LENGTH_SHORT).show();
                        deleteedt.setText("");
                    }else
                    {
                        Toast.makeText(getApplicationContext(),"DELETED",Toast.LENGTH_SHORT).show();
                        deleteedt.setText("");
                    }

                }
            }
        });
//
//
//                            //++++++++++++++++++++++++++++DELETE++++++++++++++++++++++++++++++//
//
//
//
//        deletebtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String username = deleteedt.getText().toString();
//                if (username.isEmpty()){
//                    Toast.makeText(getApplicationContext()," ENTER DATA " , Toast.LENGTH_SHORT ).show();
//
//                }else {
//                    int a = helper.delete(username);
//                    if (a<=0){
//                        Toast.makeText(getApplicationContext(),"UNSUCCESSFULL",Toast.LENGTH_SHORT).show();
//                        deleteedt.setText("");
//                    }else
//                    {
//                        Toast.makeText(getApplicationContext(),"DELETED",Toast.LENGTH_SHORT).show();
//                        deleteedt.setText("");
//                    }
//                }
//
//            }
//        });

    }

}
