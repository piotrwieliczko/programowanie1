package pl.sda.struktury_danych;

public class StosTab {
    private int tab[];
    private int top;

    public StosTab(int rozmiar) {
        tab = new int[rozmiar];
        top = -1;//ostatni element na stosie
    }

    public void push(int wartosc) throws ArrayIndexOutOfBoundsException {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        //wersja I
//        top = top + 1
//        tab[top] = wartosc;
//wersja II
        tab[++top] = wartosc;
        //++top preinkrementacja, zwiększamy wartość,a potem od tego odwołujemy się do tablicy, czli z top =-1 do top=0
    }

    public int pop() throws ArrayIndexOutOfBoundsException {

        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        //wersja I
//        return tab  [top];
//        top = top -1;//top--
        return tab[top--];
        //najpierw pobieramy wartość z tablicy, potem przechodzimy w tablicy o -1
    }

    public boolean isEmpty() {
        return top == -1;

    }

    public int peek() {
        return tab[top];

    }

    public boolean isFull() {
        return top == tab.length - 1;
    }

    public void show() {
        //i<=top - wyświetla tylko na stosie
        for (int i = 0; i <= top; i++) {
            System.out.print(tab[i] + " ");
        }
        System.out.println();


    }
}
