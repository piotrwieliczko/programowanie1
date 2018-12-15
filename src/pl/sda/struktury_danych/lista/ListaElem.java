package pl.sda.struktury_danych.lista;
//tworzymy nasz element
public class ListaElem {

    private int value;
    private ListaElem prev;
    private ListaElem next;

    public ListaElem (int value) {
        this.value = value;
        prev = next = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListaElem getPrev() {
        return prev;
    }

    public void setPrev(ListaElem prev) {
        this.prev = prev;
    }

    public ListaElem getNext() {
        return next;
    }

    public void setNext(ListaElem next) {
        this.next = next;
    }
}
