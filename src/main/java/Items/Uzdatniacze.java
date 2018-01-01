package Items;

import lombok.Data;

/**
 * Klasa Uzdatniacze - pojemnik na itemy typu uzdatniajacego
 */

@Data
public class Uzdatniacze {

    private String nazwa;
    private double temperaturaTopnienia = 1;
    private double twardosc = 1;
    private double elastycznosc = 1;
    private double podatnosc = 1;
    private double kruchosc = 1;
    private double waga = 1;
    private double przewodnictwoCieplne = 1;


    public Uzdatniacze(String nazwa, double temperaturaTopnienia, double twardosc, double elastycznosc,
                       double podatnosc, double kruchosc, double waga, double przewodnictwoCieplne) {
        this.nazwa = nazwa;
        this.temperaturaTopnienia = temperaturaTopnienia;
        this.twardosc = twardosc;
        this.elastycznosc = elastycznosc;
        this.podatnosc = podatnosc;
        this.kruchosc = kruchosc;
        this.waga = waga;
        this.przewodnictwoCieplne = przewodnictwoCieplne;
    }

    /**
     *
     * dzieli uzdatniacz na 2 częęci
     * @param na_ile
     * @return uzdatniacz o tych samych właściwościach o podanej wadze
     */
    public Uzdatniacze podziel(int na_ile) {

        if (na_ile >= waga || na_ile <= 0) {
            throw new Error("nie mozna podzielic na tyle");
        } else {
            Uzdatniacze uzdatniacz = new Uzdatniacze(nazwa, temperaturaTopnienia, twardosc, elastycznosc, podatnosc,
                    kruchosc, (na_ile), przewodnictwoCieplne);
            waga = waga - na_ile;
            return uzdatniacz;
        }
    }

    public Uzdatniacze() {
    }

    @Override
    public String toString() {
        return "Uzdatniacze{" +
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
/*
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getTemperaturaTopnienia() {
        return temperaturaTopnienia;
    }

    public void setTemperaturaTopnienia(double temperaturaTopnienia) {
        this.temperaturaTopnienia = temperaturaTopnienia;
    }

    public double getTwardosc() {
        return twardosc;
    }

    public void setTwardosc(double twardosc) {
        this.twardosc = twardosc;
    }

    public double getElastycznosc() {
        return elastycznosc;
    }

    public void setElastycznosc(double elastycznosc) {
        this.elastycznosc = elastycznosc;
    }

    public double getPodatnosc() {
        return podatnosc;
    }

    public void setPodatnosc(double podatnosc) {
        this.podatnosc = podatnosc;
    }

    public double getKruchosc() {
        return kruchosc;
    }

    public void setKruchosc(double kruchosc) {
        this.kruchosc = kruchosc;
    }

    public double getWaga() {
        return waga;
    }

    public void setWaga(double waga) {
        this.waga = waga;
    }

    public double getPrzewodnictwoCieplne() {
        return przewodnictwoCieplne;
    }

    public void setPrzewodnictwoCieplne(double przewodnictwoCieplne) {
        this.przewodnictwoCieplne = przewodnictwoCieplne;
    }
    */
}