package com.example.my_calc;

public class MathLog {
    int st1, st2;
    String GetLog (String br){
        String br2 = "";
        int i;
        st1 = 0; st2 = 0;

        for (i = 0; i < br.length(); i++) {
            if (br.charAt(i) == '(') st1 = i+1;
            if (br.charAt(i) == ')') {st2 = i; break;}
        }

        for (i = st1; i < st2; i++) {
            br2 = br2 + br.charAt(i);
        }

        if (st1 == 0 & st2 ==0) br2 = br;

        return  br2;
    }

}
