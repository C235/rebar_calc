package com.example.my_calc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText pass;
    private Button btn, btn_sum, btn_sub, btn_mul, btn_div;
    private Button btn_eqa, btn_com, btn_clr, btn_brckt1, btn_brckt2, btn_his;
    private ImageButton btn_bspc;
    ArrayList<String> his_arr = new ArrayList();
    //String[] his_arr = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
    int in_arr = 0;
    String resum = "";
    String resum3 = "";
    calc result_v = new calc();
    SharedPreferences sPref;
    //final String SAVED_TEXT = "saved_text";
    final String[] save_num = {"1","2","3","4","5"};
    int sv_n = 0;
    String buf = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();

        final TextView resText = (TextView) findViewById(R.id.Result);
        Intent intent = getIntent();
        resum3 = intent.getStringExtra("name2");
        int t1 = 0;
        sv_n = intent.getIntExtra("name3", t1);
        resum = resum3;
        resText.setText(resum3);
    }

    public void addListenerOnButton() {
        btn_sum = (Button) findViewById(R.id.sum);
        btn_sub = (Button) findViewById(R.id.sub);
        btn_mul = (Button) findViewById(R.id.mul);
        btn_div = (Button) findViewById(R.id.div);

        btn_eqa = (Button) findViewById(R.id.res2);
        btn_clr = (Button) findViewById(R.id.nclr);
        btn_com = (Button) findViewById(R.id.ncom);
        btn_brckt1 = (Button) findViewById(R.id.nbrckt1);
        btn_brckt2 = (Button) findViewById(R.id.nbrckt2);
        btn_his = (Button) findViewById(R.id.nhstr);
        btn_bspc = (ImageButton) findViewById(R.id.nbspc);
        final TextView resText = (TextView) findViewById(R.id.Result);
        final TextView resText_2 = (TextView) findViewById(R.id.Result_2);
        final TextView history1 = (TextView) findViewById(R.id.his1);

        btn_sum.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resum = resum + "+";
                        resText.setText(resum);
                    }
                }
        );

        btn_sub.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resum = resum + "-";
                        resText.setText(resum);
                    }
                }
        );
        btn_mul.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resum = resum + "*";
                        resText.setText(resum);
                    }
                }
        );
        btn_div.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resum = resum + "/";
                        resText.setText(resum);
                    }
                }
        );

        btn_com.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resum = resum + ".";
                        resText.setText(resum);
                    }
                }
        );
        btn_brckt1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resum = resum + "(";
                        resText.setText(resum);
                    }
                }
        );
        btn_brckt2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resum = resum + ")";
                        resText.setText(resum);
                    }
                }
        );
        btn_clr.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resum = "";
                        resText.setText(resum);
                        resText_2.setText(resum);
                    }
                }
        );
        btn_eqa.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resText_2.setText(result_v.CalcRes(resum));
                        //his_arr[in_arr] = resum + "=" + result_v.CalcRes(resum); //вариант простым массивом
                        his_arr.add(in_arr,resum + "=" + result_v.CalcRes(resum));
                        saveText(his_arr.get(in_arr));
                        in_arr += 1;
                    }
                }
        );
        btn_his.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent_his = new Intent(".history");
                        intent_his.putExtra("name",sv_n);
                        //intent_his.putExtra("name", his_arr);
                        startActivity(intent_his);
                    }
                }
        );
        btn_bspc.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (resum != null)
                            resum = resum.substring(0, resum.length() - 1);
                        resText.setText(resum);
                        /*resum.substring(0, resum.length()-1));
                          resum.replaceAll(".$","")*/
                    }
                }
        );
    }

    public void calcListener(View view) {

        final TextView resText = (TextView) findViewById(R.id.Result);
        final TextView resText_2 = (TextView) findViewById(R.id.Result_2);

        switch (view.getId()) {
            case R.id.n0: {
                resum = resum + "0";
                resText.setText(resum);
                break;
            }
            case R.id.n1: {
                resum = resum + "1";
                resText.setText(resum);
                break;
            }
            case R.id.n2: {
                resum = resum + "2";
                resText.setText(resum);
                break;
            }
            case R.id.n3: {
                resum = resum + "3";
                resText.setText(resum);
                break;
            }
            case R.id.n4: {
                resum = resum + "4";
                resText.setText(resum);
                break;
            }
            case R.id.n5: {
                resum = resum + "5";
                resText.setText(resum);
                break;
            }
            case R.id.n6: {
                resum = resum + "6";
                resText.setText(resum);
                break;
            }
            case R.id.n7: {
                resum = resum + "7";
                resText.setText(resum);
                break;
            }
            case R.id.n8: {
                resum = resum + "8";
                resText.setText(resum);
                break;
            }
            case R.id.n9: {
                resum = resum + "9";
                resText.setText(resum);
                break;
            }
        }

    }
    //убрать если не будет работать шаредпреф
    private void saveText(String array) {
        /*if (array != null) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < array.size(); i++) {
                str.append(array.get(i)).append(",");
            }


            sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
            SharedPreferences.Editor ed = sPref.edit();
            ed.putString(SAVED_TEXT, str.toString());
            sv_n += 1;
            ed.commit();
        }
    }*/
        //доделать хистори джава!!!
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(save_num[sv_n], array);
        sv_n += 1;
        ed.commit();
        //убрать если не будет работать шаредпреф
    }
}