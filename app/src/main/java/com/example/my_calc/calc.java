package com.example.my_calc;

public class calc {
    String CalcRes(String ex){
        int i=0, j=1, k=0, y=0, q = 1;
        double result = 0, res2;
        int len, len2, bkt1,bkt2;
        //String ex = "1+(2*12-(-5-9*2-1)*2-2/5)+1";                  //правильный ответ 73,6 c плюсом не работает
        String extmp, pm;
        /*System.out.print("введите выражение и нажмите ввод: ");
        Scanner in = new Scanner(System.in);
        String expr = in.nextLine();*/
        String[] t3 = new String[ex.length()];            // массив строк без знаков ex.split("\\+|\\-|\\*|\\/|\\(|\\)") работает не корректно
        String[] t4 = new String[ex.length()];            // массив строк со знаками
        String[] t6 = new String[ex.length()];            //для передачи методу GetDivMult
        double[] d = new double[t3.length*2];             //числовой массив элементов
        double[] d2 = new double[t3.length*2];            //для передачи методу GetDivMult

        ArrOut Pr = new ArrOut();
        DivMult div1 = new DivMult();
        MathLog str1 = new MathLog();
        //System.out.println("\n"+ex+"\n");
        pm = "";

        do{
            //System.out.println("\nnum-"+q++);
            extmp = str1.GetLog(ex);
            bkt1 = str1.st1;
            bkt2 = str1.st2;
            //System.out.print("bkt1="+bkt1+" bkt2="+bkt2);

            //System.out.println("\nextmp="+extmp);

            t3 = extmp.split("\\+|\\-|\\*|\\/");
            //Pr.ArrOutCon("t3",t3,t3.length);

            t6 = div1.SetSt(t3,extmp,t3.length);
            //Pr.ArrOutCon("t6",t6,t6.length);

            d2 = div1.SetSd(t3,t6,ex.length());
            //Pr.ArrOutCon("d2",d2,t6.length);

            result = div1.GetDivMult(d2, t6, t3.length*2-1);

            //Pr.ArrOutCon("t3",t3,t3.length);
            // Pr.ArrOutCon("t6",t6,t6.length);
            // Pr.ArrOutCon("d2",d2,d2.length);
            //System.out.println("\nresult="+result+"!");
            //System.out.println(ex.charAt(bkt1-2));

            res2 = result;
            if ((bkt1 == 0) & (bkt2 == 0))  break;
            if (ex.charAt(bkt1-2) == '-' & res2<0) {y = -1; result = result * (-1); pm = "+";}
            if (ex.charAt(bkt1-2) == '+' & res2<0) {y = -1; pm = "";}
            if (ex.charAt(bkt1-2) == '-' & res2>0) {y = 0; pm = "";}
            if (ex.charAt(bkt1-2) == '+' & res2>0) {y = -1; pm = "+";}

            ex = ex.substring(0,bkt1-1+y) + pm + result + ex.substring(bkt2+1,ex.length());

        } while ((bkt1 != 0) & (bkt2 != 0));

        String result_text;
        if (result % 1 == 0)
            result_text = String.valueOf((int)result);
        else result_text = String.valueOf(result);

        return result_text;
    }
}
