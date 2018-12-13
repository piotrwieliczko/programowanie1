package pl.sda.struktury_danych.kolejka;

public class KolejkaList {

    KolejkaElem first;

    KolejkaElem last;

    public KolejkaList() {
        first = last = null;
    }

    public void add(int wartosc) {
        KolejkaElem newLastElem = new KolejkaElem(wartosc, null); //tworzyy nowy obiekt ostatni
        if (first == null) {
            first = last = newLastElem;
        } else {
            last.setNext(newLastElem);//przypisujemy last do nowego obiektu
            last = newLastElem;
        }

    }

    public int poll() {
        if (first == null) {
            //TOOO exception
        }
        if (first.getNext() == null){
            last = null;//jeżeli po pierwszym nie ma nikogo, to ostatniego ustawiamy jako pusty
        }
        int value = first.getValue();
        first = first.getNext();
        return value;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int peek() {//pobranie

        return first.getValue();
    }

    public void show() {
        KolejkaElem elemTmp = first;
        while (elemTmp != null) {
            System.out.print(elemTmp.getValue() + " ");
            elemTmp = ((KolejkaElem) elemTmp).getNext();
        }
        System.out.println();
    }

}
