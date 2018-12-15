package pl.sda.struktury_danych;

import pl.sda.struktury_danych.Algorytmy.BinarySearch;
import pl.sda.struktury_danych.Algorytmy.ONP;
import pl.sda.struktury_danych.kolejka.KolejkaList;
import pl.sda.struktury_danych.lista.Lista;
import pl.sda.struktury_danych.stos.StosList;
import pl.sda.struktury_danych.stos.StosListIndexOutException;
import pl.sda.struktury_danych.stos.StosTab;

import java.util.Scanner;

public class Main {
    //==================================================//
    public static void main(String[] args) {
        wywoljLista();
//        wywolajStosTab();
//        wywolajStosKist();
//        wywolajKolejkaList();
//        wywolajONP();
//        wywolajBinarySearch();
    }

    public static void wywoljLista() {
        Lista lista = new Lista();
        lista.addFirst(3);
        lista.addFirst(2);
        lista.addFirst(1);
        lista.addLast(4);
        lista.addLast(5);
        //peek - tylko do podglądu
        System.out.println("PeekFirst: " + lista.peekFirst());
        System.out.println("PeekLast: " + lista.peekLast());
        System.out.println("Czy znajduje się: " + lista.znajdz(4));
//        System.out.println("Czy znajduje się: "+lista.znajdz(4).getValue());
//        System.out.println("Czy znajduje się: "+lista.znajdz(11).getValue());//obsługa wyjątków - dopisać;
        lista.show();
        lista.showReverse();
//        lista.poolFirst();
//        lista.pollLast();
//        lista.pollLast();
//        lista.pollLast();

        lista.usun(3);
        lista.show();
//        lista.show();
    }

    //==================================================//
    public static void wywolajBinarySearch() {
        int tab[] = new int[]{1, 2, 4, 6, 7, 11, 25, 30, 31, 32};
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj szukaną wartość");
        int szukana = scanner.nextInt();

        new BinarySearch().run(tab, szukana);
    }

    //==================================================//
    public static void wywolajONP() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wyrażenie w Odwrotnej Notacji Polskiej");
        String wejscie = scanner.nextLine();
        String[] podzial = wejscie.split(" ");
        new ONP().run(podzial); //algorytm - wczytane i podzielone operacje
    }

    //==================================================//
    public static void wywolajKolejkaList() {
        KolejkaList kolejkaList = new KolejkaList();

        kolejkaList.add(1);
        kolejkaList.add(2);
        kolejkaList.add(3);
        kolejkaList.show();

        System.out.println("peek: " + kolejkaList.peek());

        kolejkaList.poll();
        kolejkaList.show();

        kolejkaList.poll();
        kolejkaList.show();

        kolejkaList.add(4);
        kolejkaList.add(5);
        kolejkaList.show();

        System.out.println("KONIEC");

    }

    //==================================================//
    public static void wywolajStosKist() {
        StosList stosList = new StosList();
        stosList.push(1);
        stosList.push(2);
        stosList.push(3);
        stosList.show();

        try {
            stosList.pop();
        } catch (StosListIndexOutException e) {
            System.out.println(e.getMessage());
            ;
        }
        stosList.show();

        stosList.push(4);
        stosList.push(5);
        stosList.show();

        try {
            stosList.pop();
            stosList.pop();
            stosList.pop();
            stosList.pop();
            stosList.pop();
            stosList.pop();
            stosList.pop();
            stosList.pop();
        } catch (StosListIndexOutException e) {
            System.out.println(e.getMessage());
        }
        stosList.show();

        System.out.println("KONIEC");
    }

    //==================================================//
    public static void wywolajStosTab() {
        Scanner scanner = new Scanner((System.in));
        int tab[];
        int rozmiar;
        StosTab stosTab;

        System.out.println("Podaj rozmiar tablicy");
        rozmiar = scanner.nextInt();
        tab = new int[rozmiar];
        stosTab = new StosTab(rozmiar);

        System.out.println("Podaj elementy tablicy");
        while (true) {
            System.out.println("1-push; 2-pop; 3-peek; 4-show; 0-wyjście");
            int operacja = scanner.nextInt();

            switch (operacja) {
                case 0:
                    return;
                case 1:
                    System.out.println("Podaj wartość na stos");
                    int w = scanner.nextInt();
                    try {
                        stosTab.push(w);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Tablica pełna!");
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Pop: " + stosTab.pop());
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Tablica pusta");
                    }

                    break;
                case 3:
                    System.out.println("Peek: " + stosTab.peek());
                    break;
                case 4:
                    stosTab.show();
                    break;
            }
        }
    }
}
