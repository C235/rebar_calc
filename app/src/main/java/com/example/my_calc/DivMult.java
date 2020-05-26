package com.example.my_calc;

public class DivMult {
    ////////////////////////////////метод для приведения подобных////////////////////////////////////

    double GetDivMult (double d[], String t4[], int len){
        //System.out.print("\nstart divmult");

        int i, j, k;
        double res = 0;

        for (i = 0; i < len; i++){
            switch (t4[i]){
                case "*" : {
                    //System.out.println("\n"+i+"!!");
                    //for (double x: d) System.out.print(x+" ");
                    if (t4[0] == "-" | t4[0] == "+") j = i-1;
                    else j = i;

                    if (d[j+1] == 0) break;
                    d[j-1] = d[j-1] * d[j+1];
                    d[j+1]=0;

                    for (k = j ;t4[k] != "+" && t4[k] != "-" && t4[k] != t4[len]; k++){
                        if (t4[k+2] == "/") {d[j-1] = d[j-1] / d[k+3]; d[k+3] = 0;}
                        if (t4[k+2] == "*") {d[j-1] = d[j-1] * d[k+3]; d[k+3] = 0;}
                    }
                    break;
                }
                case "/" : {
                    //System.out.println("\n!!!");
                    if (t4[0] == "-" | t4[0] == "+") j = i-1;
                    else j = i;

                    if (d[j+1] == 0)  break;
                    d[j-1] = d[j-1] / d[j+1];
                    d[j+1]=0;

                    for (k = j ;t4[k] != "+" && t4[k] != "-" && t4[k] != t4[len]; k++){
                        if (t4[k+2] == "/") {d[j-1] = d[j-1] / d[k+3]; d[k+3]=0;}
                        if (t4[k+2] == "*") {d[j-1] = d[j-1] * d[k+3]; d[k+3]=0;}
                    }
                    break;
                }
            }
        }
        //for (double n : d) System.out.print("_"+n);
        for (double n : d) {res += n;}
        //System.out.print("\nend divmult");
        return res;
    }
////////////////////метод для преобразования строки в массив строк///////////////////////////

    String[] SetSt (String[] t3, String extmp, int len2){

        //System.out.print("\nstart SetSt");

        int i = 0, j = 1, k = 0;
        String[] st = new String[len2*2+1];

        for ( i = 0, j = 1, k = 0 ; k < len2; k++, i = i + 2, j = j + 2) {
            st[i] = t3[k];
            st[j] = "0";
        }
        for (k=0, j = 1; k < extmp.length(); k++)
            switch (extmp.charAt(k)){
                case '+' : { st[j] = "+"; j = j + 2; break;}
                case '-' : { st[j] = "-"; j = j + 2; break;}
                case '*' : { st[j] = "*"; j = j + 2; break;}
                case '/' : { st[j] = "/"; j = j + 2; break;}
            }

        if (extmp.charAt(0) == '-' | extmp.charAt(0) == '+'  )
            for (k=0; k < extmp.length(); k++) st[k] = st[k+1];
        //for (String x: st) System.out.print("_"+x);
        //System.out.println("\n!!!"+st[0]);
        //System.out.println("\nend SetSd");
        return st;
    }

//////////////////////метод лля преобразования массива строк в массив чисел/////////////////////////

    double[] SetSd(String[] t3, String[] st, int len2){
        //System.out.print("\nstart SetSd");
        int i = 0, j = 1, k = 0, len;
        ArrOut Pr = new ArrOut();

        if (st[0] == "-" | st[0] == "+") len =  t3.length-1;
        else len = t3.length;

        String[] t33 = new String[len];
        double[] sd = new double[len2*2+1];

        if (st[0] == "-" | st[0] == "+") {for (k=0; k < len; k++) t33[k] = t3[k+1];}
        else {for (k=0; k < len; k++) t33[k] = t3[k];}
        //Pr.ArrOutCon("t33",t33,t33.length);

        for (i = 0, j = 1, k = 0  ; k < t33.length; k++, i=i+2, j=j+2) {
            sd[i] = Double.parseDouble(t33[k]);
            sd[j] = 0;
        }

        if (st[0] == "-" | st[0] == "+") {i = 0; j = 0;} else {i = 0; j = 1;}
        for (; i < t33.length*2; i++, j++) {
            if (st[i] == "-") sd[j] = sd[j] * (-1);
        }

        //System.out.println("\nend SetSd");
        return sd;
    }


}
