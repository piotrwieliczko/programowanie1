package pl.sda.struktury_danych;

public class StosElem {

    private int value;
    private StosElem prev; //prev=preview poprzedni

    public StosElem(int value, StosElem prev) {
        this.value = value;
        this.prev = prev;
        //this - zmienne lokalne w tej klasie
    }

    public int getValue() {
        return value;
    }

    public StosElem getPrev() {
        return prev;
    }
}
