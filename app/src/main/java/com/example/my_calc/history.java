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
    final String[] his_arr2 = {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ",
            " "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "};
    ArrayList<String> his_arr3 = new ArrayList();
    private SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";

    String[] save_num = {"1","2","3","4","5"};
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
        /*final String[] name = intent.getStringArrayExtra("name");
        int num = 0;
        for (int i = 0; i < his_arr2.length; i++)
            if (his_arr2[i] == " ") {
                num = i;
                break;
            }

        System.arraycopy(name, 0, his_arr2, num, name.length);*/

        loadText(sv_n1);

        list = (ListView) findViewById(R.id.LvMain);

        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_list_item_single_choice, his_arr2);

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
    //попытка выгрузить из шаредпреф преобразовать список в массив!!!!!
    private void loadText(int sv) {
        //рабочая часть
        /*sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT, "");
        StringTokenizer st = new StringTokenizer(savedText, ",");
        ArrayList<String> array = new ArrayList<String>(st.countTokens());
        while(st.hasMoreTokens()) {
            array.add(st.nextToken());
        }
        for(int i=0; i<array.size();i++) his_arr2[i] = array.get(i);*/

        //передать через интент сколько раз прочитать из шаредпреф для ключа!!!!!!!!!
        for (int i = 0; i < sv; i++){
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        his_arr2[i] = sPref.getString(save_num[i], "");}

    }

}
    /*private void saveArr() {
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, his_arr2.get);
        ed.commit();
    }*/

