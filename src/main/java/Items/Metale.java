package Items;


import lombok.Data;

/**
 * Klasa Metal - pojemnik na itemy typu metalowego
 */

@Data
public class Metale {

    private String nazwa;
    private int temperaturaTopnienia;
    private int twardosc;
    private int elastycznosc;
    private int podatnosc;
    private int kruchosc;
    private int waga;
    private int przewodnictwoCieplne;

    public Metale(String nazwa, int temperaturaTopnienia, int twardosc, int elastycznosc, int podatnosc,
                  int kruchosc, int waga, int przewodnictwoCieplne) {
        this.nazwa = nazwa;
        this.temperaturaTopnienia = temperaturaTopnienia;
        this.twardosc = twardosc;
        this.elastycznosc = elastycznosc;
        this.podatnosc = podatnosc;
        this.kruchosc = kruchosc;
        this.waga = waga;
        this.przewodnictwoCieplne = przewodnictwoCieplne;
    }

    public Metale() {
    }

    /**
     * dzieli metal na 2 częęci
     * @param na_ile
     * @return metal o tych samych właściwościach o podanej wadze
     */
    public Metale podziel(int na_ile){

        if (na_ile>=waga || na_ile<=0){
            throw new Error("nie mozna podzielic na tyle");
        }else {
            Metale metale = new Metale(nazwa,temperaturaTopnienia,twardosc,elastycznosc,podatnosc,kruchosc,(na_ile),przewodnictwoCieplne);
            waga = waga - na_ile;
            return metale;
        }
    }

    @Override
    public String toString() {
        return "Metale{" +
                "nazwa='" + nazwa + '\'' +
                ", temperaturaTopnienia=" + temperaturaTopnienia +
                ", twardosc=" + twardosc +
                ", elastycznosc=" + elastycznosc +
                ", podatnosc=" + podatnosc +
                ", kruchosc=" + kruchosc +
                ", waga=" + waga +
                ", przewodnictwoCieplne=" + przewodnictwoCieplne +
                '}';
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getTemperaturaTopnienia() {
        return temperaturaTopnienia;
    }

    public void setTemperaturaTopnienia(int temperaturaTopnienia) {
        this.temperaturaTopnienia = temperaturaTopnienia;
    }

    public int getTwardosc() {
        return twardosc;
    }

    public void setTwardosc(int twardosc) {
        this.twardosc = twardosc;
    }

    public int getElastycznosc() {
        return elastycznosc;
    }

    public void setElastycznosc(int elastycznosc) {
        this.elastycznosc = elastycznosc;
    }

    public int getPodatnosc() {
        return podatnosc;
    }

    public void setPodatnosc(int podatnosc) {
        this.podatnosc = podatnosc;
    }

    public int getKruchosc() {
        return kruchosc;
    }

    public void setKruchosc(int kruchosc) {
        this.kruchosc = kruchosc;
    }

    public int getWaga() {
        return waga;
    }

    public void setWaga(int waga) {
        this.waga = waga;
    }

    public int getPrzewodnictwoCieplne() {
        return przewodnictwoCieplne;
    }

    public void setPrzewodnictwoCieplne(int przewodnictwoCieplne) {
        this.przewodnictwoCieplne = przewodnictwoCieplne;
    }

}

