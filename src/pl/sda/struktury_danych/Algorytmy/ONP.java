package pl.sda.struktury_danych.Algorytmy;

import pl.sda.struktury_danych.stos.StosTab;

public class ONP {

    public void run(String tab[]) {
        StosTab stosTab = new StosTab(tab.length);

        for (int i = 0; i < tab.length; i++) {
            try {
                //try-catch zamiast if
                int wartosc = Integer.parseInt(tab[i]);
                stosTab.push(wartosc);
            } catch (NumberFormatException e) {
                //TOOOOO
                //catch - jeżeli dany string nie jest liczbą to kawałek kodu jest znakiem działania, np. dodawania
                int wartosc1 = stosTab.pop();
                int wartosc2 = stosTab.pop();

                String operacja = tab[i];

                int wynik = 0;
                if (operacja.equals("+")) {
                    wynik = wartosc2 + wartosc1;
                } else if (operacja.equals("-")) {
                    wynik = wartosc2 - wartosc1;
                } else if (operacja.equals("*")) {
                    wynik = wartosc2 * wartosc1;
                } else if (operacja.equals("/")) {
                    wynik = wartosc2 / wartosc1;
                } else {
                    return;
                }
                stosTab.push(wynik); //wynik tych operacji dodajemy na stos
            }
        }

        System.out.println(stosTab.pop());
    }
}
