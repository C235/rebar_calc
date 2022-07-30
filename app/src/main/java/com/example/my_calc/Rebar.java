package com.example.my_calc;


public class Rebar {
    //private static double a = 0;

    String provideMy(String con,String reb,String sh, double q, double qn, double h, double b, double l, double a){
        int[] RbM = {10350, 13050, 15300};
        int[] RbtserM = {1350, 1550, 1750};
        int[] RbserM = {15000, 18500, 22000};
        double[] EbM = {2.75e7, 3e7, 3.25e7};
        //int[] A = {240, 300, 400, 500};
        int[] RsM = {170000, 270000, 355000, 435000};
        int[] RscM = {215000, 270000, 355000, 435000};
        double[] EsM = {2e8, 2e8, 2e8, 2e8};
        double[][] As = {{3,4,5,6,8,10,12,14,16,18,20,22,25,28,32,36,40},
                {0.071, 0.126, 0.196, 0.283, 0.503, 0.785, 1.131, 1.539, 2.011, 2.545, 3.142, 3.801, 4.909, 6.158, 8.042, 10.179, 12.566}};
        double Mpr, Mop, Aopr, Aoop, n1, Astrpr, Astrop, n, dspr, Aspr, t_pr, ho, t_op,  D, f, f_dop;
        String result = "net";
        Aopr = 0;
        int Rb, Rbtser, Rbser, Rs, Rsc;
        double Eb, Es;
        Rb = 0;
        Rbser = 0;
        Rs = 0;
        Es = 0;
        Rebar_c2 cal = new Rebar_c2();

        //расчетные сопротивления бетона
        switch (con){
            case "B20": {
                Rb = RbM[0];
                Rbtser = RbtserM[0];
                Rbser = RbserM[0];
                Eb = EbM[0];
                break;
            }
            case "B25": {
                Rb = RbM[1];
                Rbtser = RbtserM[1];
                Rbser = RbserM[1];
                Eb = EbM[0];
                break;
            }
            case "B30": {
                Rb = RbM[2];
                Rbtser = RbtserM[2];
                Rbser = RbserM[2];
                Eb = EbM[0];
                break;
            }
        }
        //расчетные сопротивления арматуры
        switch (reb) {
            case "A240": {
                Rs = RsM[0];
                Rsc = RscM[0];
                Es = EsM[0];
                break;
            }
            case "A300": {
                Rs = RsM[1];
                Rsc = RscM[1];
                Es = EsM[1];
                break;
            }
            case "A400": {
                Rs = RsM[2];
                Rsc = RscM[2];
                Es = EsM[2];
                break;
            }
            case "A500": {
                Rs = RsM[3];
                Rsc = RscM[3];
                Es = EsM[3];
                break;
            }
        }
        //вычисления
        if (a == 0) result = "ввидите все значения"; //проверка введенного значения
                else {
                        ho = h - a;
                        switch (sh) {
                            case "З-З": {
                                Mpr = q * l * l / 24;
                                Mop = q * l * l / 12;
                                Aopr = cal.f_Ao(Mpr, Rb, b, ho);
                                Aoop = cal.f_Ao(Mop, Rb, b, ho);
                                if (Aopr > 0.4 | Aoop > 0.4) result = "Ao > 0.4";
                                else {
                                    t_pr = cal.f_teta(Aopr);
                                    t_op = cal.f_teta(Aoop);
                                    Astrpr = (Mpr * 10000) / (Rs * t_pr * ho);
                                    Astrop = (Mop * 10000) / (Rs * t_op * ho);
                                    f_dop = l / cal.f_deflection_n(l);
                                    D = cal.f_deflection(Es, Rbser, Rb, b, ho, Astrpr);
                                    f = qn * l * l * l * l / (384 * D);
                                    Aspr = Astrpr;
                                    while (f > f_dop) {
                                        Aspr = Aspr + 0.5;
                                        D = cal.f_deflection(Es, Rbser, Rb, b, ho, Aspr);
                                        f = qn * l * l * l * l / (384 * D);
                                    }
                                    result = "требуемое количество по прочности\n в пролете " +
                                            String.format("%.3f", Astrpr) + "(см2)\n" + "на опоре " +
                                            String.format("%.3f", Astrop) + "(см2)\n\n" +
                                            "требуемое количество по деформациям\n в пролете " +
                                            String.format("%.3f", Aspr) + "(см2)\n" +
                                            "прогиб " +
                                            String.format("%.3f", f) + "(м)\n" +
                                            "предельно допустимый прогиб " +
                                            String.format("%.3f", f_dop) + "(м)";
                                }
                                break;
                            }
                            case "З-Ш": {
                                Mpr = q * l * l / 16;
                                Mop = q * l * l / 8;
                                Aopr = cal.f_Ao(Mpr, Rb, b, ho);
                                Aoop = cal.f_Ao(Mop, Rb, b, ho);
                                if (Aopr > 0.4 | Aoop > 0.4) result = "Ao > 0.4";
                                else {
                                    t_pr = cal.f_teta(Aopr);
                                    t_op = cal.f_teta(Aoop);
                                    f_dop = l / cal.f_deflection_n(l);
                                    Astrpr = (Mpr * 10000) / (Rs * t_pr * ho);
                                    Astrop = (Mop * 10000) / (Rs * t_op * ho);
                                    D = cal.f_deflection(Es, Rbser, Rb, b, ho, Astrpr);
                                    f = qn * l * l * l * l / (185 * D);
                                    Aspr = Astrpr;
                                    while (f > f_dop) {
                                        Aspr = Aspr + 0.5;
                                        D = cal.f_deflection(Es, Rbser, Rb, b, ho, Aspr);
                                        f = qn * l * l * l * l / (185 * D);
                                    }
                                    result = "требуемое количество по прочности\n в пролете " +
                                            String.format("%.3f", Astrpr) + "(см2)\n" + "на опоре " +
                                            String.format("%.3f", Astrop) + "(см2)\n\n" +
                                            "требуемое количество по деформациям\n в пролете " +
                                            String.format("%.3f", Aspr) + "(см2)\n" +
                                            "прогиб " +
                                            String.format("%.3f", f) + "(м)\n" +
                                            "предельно допустимый прогиб " +
                                            String.format("%.3f", f_dop) + "(м)";
                                }
                                break;
                            }
                            case "Ш-Ш": {
                                Mpr = q * l * l / 8;
                                Aopr = cal.f_Ao(Mpr, Rb, b, ho);
                                if (Aopr > 0.4) result = "Ao > 0.4";
                                else {
                                    t_pr = cal.f_teta(Aopr);
                                    Astrpr = (Mpr * 10000) / (Rs * t_pr * ho);
                                    f_dop = l / cal.f_deflection_n(l);
                                    D = cal.f_deflection(Es, Rbser, Rb, b, ho, Astrpr);
                                    f = 5 * qn * l * l * l * l / (384 * D);
                                    Aspr = Astrpr;
                                    while (f > f_dop) {
                                        Aspr = Aspr + 0.5;
                                        D = cal.f_deflection(Es, Rbser, Rb, b, ho, Aspr);
                                        f = 5 * qn * l * l * l * l / (384 * D);
                                    }
                                    result = "требуемое количество по прочности\n в пролете " +
                                            String.format("%.3f", Astrpr) + "(см2)\n\n" +
                                            "требуемое количество по деформациям\n в пролете " +
                                            String.format("%.3f", Aspr) + "(см2)\n" +
                                            "прогиб " +
                                            String.format("%.3f", f) + "(м)\n" +
                                            "предельно допустимый прогиб " +
                                            String.format("%.3f", f_dop) + "(м)";
                                }
                                break;
                            }
                            case "К": {
                                Mop = q * l * l / 2;
                                Aoop = cal.f_Ao(Mop, Rb, b, ho);
                                if (Aopr > 0.4) result = "Ao > 0.4";
                                else {
                                    t_op = cal.f_teta(Aoop);
                                    Astrpr = (Mop * 10000) / (Rs * t_op * ho);
                                    D = cal.f_deflection(Es, Rbser, Rb, b, ho, Astrpr);
                                    f = qn * l * l * l * l / (185 * D);
                                    result = "требуемое количество по прочности на опоре " +
                                            String.format("%.3f", Astrpr) + " см2 " + " прогиб " +
                                            String.format("%.3f", f) + " м" +
                                            "предельно допустимый прогиб " +
                                            String.format("%.3f", l / 75) + "(м)";
                                }
                                break;
                            }
                        }
                }
        return result;
    }
}
