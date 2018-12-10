package pl.sda.struktury_danych.Algorytmy;

public class BinarySearch {

    public void run (int A[], int y) {
        int lewo = 0;
        int prawo = A.length-1;
        int indeks = -1;

        while (lewo<prawo){
            int srodek = (lewo+prawo)/2;

            if (A[srodek]<y) {
                lewo = srodek+1;

            }else {
                prawo=srodek;
            }
        }

        if (A[lewo ]==y){
            indeks=lewo;


        }else {
            indeks = -1;
        }
        if (indeks == -1){
            System.out.println("nie znaleziono");
        }else {
            System.out.println("znaleziono: "+A[indeks]+" ,o indeksie :"+indeks);
        }
    }
}
