package com.example.my_calc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class history extends AppCompatActivity {

    ListView list;
    String r1;
    final String[] his_arr2 = {"","","","","","","","","","","","","","","","","","","","",
            "","","","","","","","","","","","","","","","","","","",""};
    ArrayList<String> his_arr3 = new ArrayList();
    private SharedPreferences sPref;
    //final String SAVED_TEXT = "saved_text";

    String[] save_num = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};
    int sv_n1 = 0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        historyListener();
    }
    @Override
    protected void onStart() {
        super.onStart();
        //historyListener();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //historyListener();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //historyListener();
    }
    @Override
    protected void onStop() {
        super.onStop();
        //historyListener();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        //historyListener();
    }

    public void historyListener () {

        Intent intent = getIntent();
        int t1 = 0;
        sv_n1 = intent.getIntExtra("name", t1);

        loadText(sv_n1);

        list = (ListView) findViewById(R.id.LvMain);

        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                R.layout.listview_calc_item, his_arr2);

        list.setAdapter(adapter);

        Button btnChecked = (Button) findViewById(R.id.btnChecked);
        btnChecked.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SparseBooleanArray sbArray = list.getCheckedItemPositions();
                        for (int i = 0; i < sbArray.size(); i++) {
                            int key = sbArray.keyAt(i);
                            if (sbArray.get(key)) {
                                Intent intent = new Intent(history.this, MainActivity.class);
                                r1 = his_arr2[key];
                                r1 = r1.substring(+0, r1.indexOf('='));
                                intent.putExtra("name2", r1);
                                intent.putExtra("name3", sv_n1);
                                startActivity(intent);
                            }
                        }
                    }
                });
    }
     private void loadText(int sv) {

        for (int i = 0; i < sv; i++){
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        his_arr2[i] = sPref.getString(save_num[i], "");}

    }

}

