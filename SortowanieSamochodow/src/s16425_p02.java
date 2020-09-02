public class s16425_p02 {
    public static void main(String[] args) {

        PojazdMechaniczny[] tab = new PojazdMechaniczny[100];


        Silnik[] silnikTab = new Silnik[100];

        long[] pojemnoscTab = {
                1200l, 2000l,2400l,2900l,3000l,3500l,4700l,5000l
        };


        int[] mocTab = {
                40, 60, 100, 120, 150, 200
        };

        int[] iloscMiejscTab = {
                3, 4, 5, 6, 7,8,9,10
        };

        String[] nazwaTab = {
                "Peugeot",
                "Renault",
                "Opel",
                "Mercedes",
                "Hyundai",
                "Mazda",
                "Skoda",
                "Volkswagen"
        };


        for (int i = 0; i < silnikTab.length; i++) {
            int a = (int) (Math.random() * mocTab.length);
            int b = (int) (Math.random() * pojemnoscTab.length);
            silnikTab[i] = new Silnik(mocTab[a], pojemnoscTab[b]);
        }

        for (int i = 0; i < tab.length; i++) {
            int c = (int) (Math.random() * iloscMiejscTab.length);
            int d = (int) (Math.random() * nazwaTab.length);
            int e = (int) (Math.random() * silnikTab.length);
            tab[i] = new PojazdMechaniczny(iloscMiejscTab[c], nazwaTab[d], silnikTab[e]);
        }

        sortowanieMoc(tab);


        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i]);
        }


    }


    public static void sortowanieMoc(PojazdMechaniczny[] tab) {


        PojazdMechaniczny tymczasowyPojazdMoc;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {


                if (tab[i].getSilnik().getMoc() > tab[j].getSilnik().getMoc()) {
                    tymczasowyPojazdMoc = tab[i];
                    tab[i] = tab[j];
                    tab[j] = tymczasowyPojazdMoc;
                }

                if(tab[i].getSilnik().getMoc()==tab[j].getSilnik().getMoc() && tab[i].getSilnik().getPojemnosc()> tab[j].getSilnik().getPojemnosc()){
                    tymczasowyPojazdMoc=tab[i];
                    tab[i]=tab[j];
                    tab[j]=tymczasowyPojazdMoc;
                }

                if(tab[i].getSilnik().getMoc()== tab[j].getSilnik().getMoc() && tab[i].getSilnik().getPojemnosc()== tab[j].getSilnik().getPojemnosc() && tab[i].getIloscMiejsc() > tab[j].getIloscMiejsc()){
                    tymczasowyPojazdMoc=tab[i];
                    tab[i]=tab[j];
                    tab[j]=tymczasowyPojazdMoc;
                }
                int count = 0;
                if(tab[i].getSilnik().getMoc()== tab[j].getSilnik().getMoc() && tab[i].getSilnik().getPojemnosc()== tab[j].getSilnik().getPojemnosc() && tab[i].getIloscMiejsc() == tab[j].getIloscMiejsc()) {
                    if (tab[i].getNazwa().toCharArray()[count] <= tab[j].getNazwa().toCharArray()[count]) {
                        tymczasowyPojazdMoc = tab[i];
                        tab[i] = tab[j];
                        tab[j] = tymczasowyPojazdMoc;
                    }else if(tab[i].getNazwa().toCharArray()[count]==tab[j].getNazwa().toCharArray()[count]){
                        count++;
                        j--;
                    }
                }

            }
        }

    }
}

class Silnik {
    int moc;
    long pojemnosc;

    public Silnik(int moc, long pojemnosc){
        this.moc=moc;
        this.pojemnosc=pojemnosc;
    }

    @Override
    public String toString() {
        return "moc " + moc +
                " pojemnosc " + pojemnosc;
    }

    public int getMoc() {
        return moc;
    }

    public long getPojemnosc() {
        return pojemnosc;
    }
}

 class PojazdMechaniczny {
    int iloscMiejsc;
    String nazwa;
    Silnik silnik;

    public PojazdMechaniczny(int iloscMiejsc, String nazwa, Silnik silnik) {
        this.iloscMiejsc = iloscMiejsc;
        this.nazwa = nazwa;
        this.silnik = silnik;
    }

    @Override
    public String toString() {
        return "PojazdMechaniczny silnik " + silnik +
                " iloscMiejsc " + iloscMiejsc +
                " nazwa " + nazwa;
    }

    public int getIloscMiejsc() {
        return iloscMiejsc;
    }

    public String getNazwa() {
        return nazwa;
    }

    public Silnik getSilnik() {
        return silnik;
    }
}

