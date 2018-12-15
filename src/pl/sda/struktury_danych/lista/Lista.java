package pl.sda.struktury_danych.lista;

public class Lista {
    private ListaElem first;// head - pierwsy element w liści
    private ListaElem last; //tail


    public Lista() {
        first = last = null;
    }

    public void addFirst(int wartosc) {
        ListaElem newListaElem = new ListaElem(wartosc);
        if (first == null) {
            first = last = newListaElem;
        } else {
            first.setPrev(newListaElem);//pierwszy jest poprednikiem, którego jeszcze nie ma
            newListaElem.setNext(first);
            first = newListaElem;
        }
    }

    public void addLast(int wartosc) {
        ListaElem newListaElem = new ListaElem(wartosc);
        if (first == null) {
            first = last = newListaElem;
        } else {
            last.setNext(newListaElem);
            //ustawiamy poprzednik:
            newListaElem.setPrev(last); //ten, który był ostatni stał się poprzednikiem
            last = newListaElem;
        }
    }

    //peek - podgląd początku i końca listy
    public int peekFirst() {
        return first.getValue();
    }

    public int peekLast() {
        return last.getValue();
    }

    public int poolFirst() {
        if (first == null) {
            //TODO Exceptiom
        }
        if (first.getNext() == null) {
            last = null;
        }
        int value = first.getValue();
        first = first.getNext();

        //jeżeli nowy pierwszy jest null, to jego poprzednik jest null
        if (first != null) {
            first.setPrev(null);
        }
        return value;
    }

    public int pollLast() {
        if (last == null) {
            //TODO Exception
        }
        if (last.getPrev() == null) {
            first = null;
        }
        int value = last.getValue();
        last = last.getPrev();

        if (last != null) {
            last.setNext(null);
        }
        return value;
    }

    public void show() {
        ListaElem listaElemTmp = first;
        while (listaElemTmp != null) {
            System.out.print(listaElemTmp.getValue() + " ");
            listaElemTmp = listaElemTmp.getNext();
        }
        System.out.println();
    }

    public void showReverse() {
        ListaElem listElemTmp = last;
        while (listElemTmp != null) {
            System.out.print(listElemTmp.getValue() + " ");
            listElemTmp = listElemTmp.getPrev();
        }
        System.out.println();
    }

    //cy element o jakiejść wartości znajduje się w liście
    public ListaElem znajdz(int wartosc) {
        //tworzymy obiekt tymczasowy
        ListaElem listaElemTmp = first;
        while (listaElemTmp != null) {
            if (listaElemTmp.getValue() == wartosc) {
                return listaElemTmp;
            }
            listaElemTmp = listaElemTmp.getNext();
        }
        return null;
    }

    //jeżeli wartość znajduje się na liście, to usuwamy:
    public boolean usun(int wartosc) {
        ListaElem szukanyElemen = znajdz(wartosc);

        if (szukanyElemen == null) {
            return false; //jeeli szukanego elementu nie m na liście, to zwraca null
        } else if (wartosc == first.getValue()) {
            poolFirst();
        } else if (wartosc == last.getValue()) {
            pollLast();
        } else {
            szukanyElemen.getPrev().setNext(szukanyElemen.getNext());
            szukanyElemen.getNext().setPrev(szukanyElemen.getPrev());
        }
        return true;
    }

}