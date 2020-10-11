package com.inacap.felipe_gonsa_rodri;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.inacap.felipe_gonsa_rodri.adapter.HarryAdapter;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import com.inacap.felipe_gonsa_rodri.model.HarryPotter;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {


    private Button boton;
    public static final String URL = "http://hp-api.herokuapp.com/api/characters";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton =findViewById(R.id.creadores);
        processHttp();
    }

    public void processHttp() {
        AsyncHttpClient client = new AsyncHttpClient();

        client.get(URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String res = new String(responseBody);
                Log.d("INFO", res);

                processJson(res);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }


    public void processJson (String res){
        try {
            JSONArray harry = new JSONArray(res);
            List<HarryPotter> list = new ArrayList<>();
            for (int i = 0; i < harry.length(); i++) {
                JSONObject harryObj = harry.getJSONObject(i);
                String name = harryObj.getString("name");
                String species = harryObj.getString("species");
                String gender = harryObj.getString("gender");
                String image = harryObj.getString("image");


//                    String house = harryObj.getString("house");
//                    String dateOfBird = harryObj.getString("dateOfBird");
//                    String yearOfBird = harryObj.getString("yearOfBird");
//                   JSONObject wand = harryObj.getJSONObject("wand");
//                    String wood = wand.getString("wood");
//                    String core = wand.getString("core");
//

                HarryPotter harryPotter = new HarryPotter(name, species, gender, image);
                Log.d("INFO", harryPotter.name + " " + harryPotter.gender  + " " + harryPotter.image + " " );
                list.add(harryPotter);
            }

            RecyclerView rc = findViewById(R.id.rc_harry);

            LinearLayoutManager lm = new LinearLayoutManager(this);
            lm.setOrientation(RecyclerView.VERTICAL);
            HarryAdapter adapter = new HarryAdapter(this,list,R.layout.harry_main2);

            rc.setLayoutManager(lm);rc.setAdapter(adapter);


        } catch (Exception e) {

        }
    }



}