package com.example.my_calc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //private Button btn_eqa, btn_com, btn_clr, btn_brckt1, btn_brckt2, btn_his, btn_rebar;
    //private ImageButton btn_bspc;
    //private Button btn_eqa;
    ArrayList<String> his_arr = new ArrayList();
    int in_arr = 0;
    String resum = "";
    String resum3 = "";
    calc result_v = new calc();
    SharedPreferences sPref;
    final String[] save_num = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};
    int sv_n = 0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView resText = (TextView) findViewById(R.id.Result);
        Intent intent = getIntent();
        resum3 = intent.getStringExtra("name2");
        int t1 = 0;
        sv_n = intent.getIntExtra("name3", t1);
        if (resum3 != null) resum = resum3;
                else resum = "";
        resText.setText(resum3);

    }
    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
    }

    /*
    addListenerOnButton();
    public void addListenerOnButton() {
        btn_eqa = (Button) findViewById(R.id.res2);
        btn_clr = (Button) findViewById(R.id.nclr);
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
                        his_arr.add(in_arr,resum + "=" + result_v.CalcRes(resum));
                        saveText(his_arr.get(in_arr));
                        in_arr += 1;
                    }
                }
        );
    }*/



    public void calcListener(View view) {

        final TextView resText = (TextView) findViewById(R.id.Result);
        final TextView resText_2 = (TextView) findViewById(R.id.Res_count);

        switch (view.getId()) {

            case R.id.b_rebar: {
                Intent intent_his = new Intent(".Activity_rebar"); /*переход на активити rebar*/
                startActivity(intent_his);
                break;
            }
            case R.id.nbspc: {
                if (resum != null)
                    resum = resum.substring(0, resum.length() - 1);
                resText.setText(resum);
                break;
            }
            case R.id.nhstr: {
                Intent intent_his = new Intent(".history"); /*переход на активити истории*/
                intent_his.putExtra("name",sv_n);
                startActivity(intent_his);
                break;
            }
            case R.id.res2: {
                resText_2.setText(result_v.CalcRes(resum));
                his_arr.add(in_arr,resum + "=" + result_v.CalcRes(resum));
                saveText(his_arr.get(in_arr));
                in_arr += 1;
                break;
            }
            case R.id.nclr: {
                resum = "";
                resText.setText(resum);
                resText_2.setText(resum);
                break;
            }
            case R.id.ncom: {
                resum = resum + ".";
                resText.setText(resum);
                break;
            }
            case R.id.nbrckt1: {
                resum = resum + "(";
                resText.setText(resum);
                break;
            }
            case R.id.nbrckt2: {
                resum = resum + ")";
                resText.setText(resum);
                break;
            }
            case R.id.div: {
                resum = resum + "/";
                resText.setText(resum);
                break;
            }
            case R.id.mul: {
                resum = resum + "*";
                resText.setText(resum);
                break;
            }
            case R.id.sub: {
                resum = resum + "-";
                resText.setText(resum);
                break;
            }
            case R.id.sum: {
                resum = resum + "+";
                resText.setText(resum);
                break;
            }
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

    private void saveText(String array) {
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(save_num[sv_n], array);
        sv_n += 1;
        ed.commit();

    }
}