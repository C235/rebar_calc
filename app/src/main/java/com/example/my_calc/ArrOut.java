package com.example.my_calc;

public class ArrOut {
    void ArrOutCon(String n, int t1[], int lent1){
        int i;
        System.out.println("\n"+n+":");
        for (i = 0; i < lent1; i++)
            System.out.print("_"+t1[i]);
    }
    void ArrOutCon(String n, double t1[], int lent1){
        int i;
        System.out.println("\n"+n+":");
        for (i = 0; i < lent1; i++)
            System.out.print("_"+t1[i]);
    }
    void ArrOutCon(String n, char t1[], int lent1){
        int i;
        System.out.println("\n"+n+":");
        for (i = 0; i < lent1; i++)
            System.out.print("_"+t1[i]);
    }
    void ArrOutCon(String n, String t1[], int lent1){
        int i;
        System.out.println("\n"+n+":");
        for (i = 0; i < lent1; i++)
            System.out.print("_"+t1[i]);
    }

}
