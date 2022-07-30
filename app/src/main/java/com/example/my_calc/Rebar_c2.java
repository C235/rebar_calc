package com.example.my_calc;

import static java.lang.Math.sqrt;

public class Rebar_c2 {
    double f_Ao (double Mpr, int Rb, double b, double ho){
        double Aoprf;
        Aoprf = Mpr / (Rb * b * ho * ho);
        return Aoprf;
    }
    double f_teta (double Aopr){
        double teta;
        teta = (1 + sqrt(1 - 2 * Aopr)) / 2;
        return teta;
    }
    double f_deflection (double Es, int Rbser,int Rb, double b, double ho, double Aspr){
        double eb1rd, Ebred, alfa_s1, mu_s, xm, z, Ds;
        eb1rd = 0.0028; // для спб
        Ebred = Rbser / eb1rd;
        alfa_s1 = Es / Ebred;
        mu_s = Aspr / (10000 * b * ho);
        xm = ho * (sqrt(mu_s * alfa_s1 * mu_s * alfa_s1 + 2 * mu_s * alfa_s1) - mu_s * alfa_s1);
        z = ho - xm / 3;
        Ds = Es * Aspr * z * (ho-xm) / 10000;
        return Ds;
    }
    double f_deflection_n (double l){
        double f1;
        double [] f = {150, 157, 164, 172, 180, 189, 200, 204, 208, 213, 217, 221, 225, 229, 233, 238, 242, 246, 250};
        double [] l_dop = {0, 3.5, 4, 4.5, 5, 5.5, 6, 6.5, 7, 7.5, 8, 8.5, 9, 9.5, 10, 10.5, 11, 11.5, 12};
        int j;
        f1 = 0;
        j = 0;
        for (int i = 0; i < 17; i++) {
            if ( (l_dop[i] <= l) & (l_dop[i+1] >= l)) {
                j = i;
                break;
            }
        }
        if (l >= l_dop[18]) f1 = f[18];
        else f1 = (l - l_dop[j]) * (f[j+1]-f[j]) / (l_dop[j+1]-l_dop[j]) +f[j];
        return f1;
    }
}
