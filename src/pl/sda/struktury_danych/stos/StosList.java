package pl.sda.struktury_danych.stos;


public class StosList {
    private StosElem top;

    public StosList() {
        top = null;
    }


    public void push(int wartosc) {
        top = new StosElem(wartosc, top);
    }


    public int pop() throws StosListIndexOutException {//zdejmowanie el ze stosu
        //tworzymy własny wyjątek
        if (isEmpty()) {
            throw new StosListIndexOutException("Stos pusty!");
        }
        int value = top.getValue();
        top = top.getPrev();
        return value;
    }


    public boolean isEmpty() {
        return top == null;
        //II sposób
//       if (top == true){
//           return true;
//       }else {
//           return false;
//       }
    }


    public int peek() {
        return top.getValue();
    }

    public void show() {
        StosElem elemTmp = top;

        while (elemTmp != null) {
            int wartoscNEkran = elemTmp.getValue();
            System.out.print(wartoscNEkran + " ");

            elemTmp = elemTmp.getPrev();
        }
        System.out.println();
    }

}
