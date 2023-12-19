package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Login extends AppCompatActivity {

    Button button;
    EditText userinput;
    EditText passinput;

    public static ArrayList<String> readDataUrl(Context context, String username, String password){

        ArrayList<String> urls = new ArrayList<>();

        BufferedReader bufferedReader=null;
        try{
            bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(R.raw.data),StandardCharsets.UTF_8));
            String line;

            while ((line = bufferedReader.readLine())!=null){
                Log.d("line",line.toString());
                String[] tokens = line.split("\\|\\|");
                Log.d("token1",tokens[1].toString());
                Log.d("equal", String.valueOf(tokens[1].equals(username)));

                if (tokens[1].equals(username) && tokens[2].equals(password)){
                    Log.d("url",tokens[3].toString());
                    urls.add(tokens[3]);
                }
                else continue;

            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return urls;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = findViewById(R.id.id_login);
        userinput = findViewById(R.id.id_username);
        passinput = findViewById(R.id.id_password);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userinput.getText().toString();
                String pass = passinput.getText().toString();
                System.out.println(name);
                System.out.println(pass);
                User user = new User(1,name,pass);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("USER",user);

                if (User.readData(getApplicationContext(),name,pass)){
                    startActivity(intent);

                }
                else Toast.makeText(getApplicationContext(),"incorrect Login Details",Toast.LENGTH_SHORT).show();
            }
        });

    }

}