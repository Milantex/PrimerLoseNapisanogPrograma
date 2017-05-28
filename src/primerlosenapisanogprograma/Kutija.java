package primerlosenapisanogprograma;

public class Kutija {
    private String naziv;
    private float sirina, duzina, visina;
    private String materijal;
    private boolean imaPoklopac;

    public float getZapremina() {
        return sirina * duzina * visina;
    }

    public String getNaziv() {
        return naziv;
    }

    public Kutija setNaziv(String naziv) {
        this.naziv = naziv;
        return this;
    }

    public float getSirina() {
        return sirina;
    }

    public Kutija setSirina(float sirina) {
        this.sirina = sirina;
        return this;
    }

    public float getDuzina() {
        return duzina;
    }

    public Kutija setDuzina(float duzina) {
        this.duzina = duzina;
        return this;
    }

    public float getVisina() {
        return visina;
    }

    public Kutija setVisina(float visina) {
        this.visina = visina;
        return this;
    }

    public String getMaterijal() {
        return materijal;
    }

    public Kutija setMaterijal(String materijal) {
        this.materijal = materijal;
        return this;
    }

    public boolean getImaPoklopac() {
        return imaPoklopac;
    }

    public Kutija setImaPoklopac(boolean imaPoklopac) {
        this.imaPoklopac = imaPoklopac;
        return this;
    }

    public Kutija imaPoklopac() {
        this.setImaPoklopac(true);
        return this;
    }

    public Kutija nemaPoklopac() {
        this.setImaPoklopac(false);
        return this;
    }

    @Override
    public String toString() {
        return 
            "Naziv: " + getNaziv() + "\n" +
            "Širina: " + getSirina() + "\n" +
            "Dužina: " + getDuzina() + "\n" +
            "Visina: " + getVisina() + "\n" +
            "Materijal: " + getMaterijal() + "\n" +
            "Ima poklopac: " + ((getImaPoklopac())?"Da":"Ne") + "\n";
    }

    public Kutija vratiBoljuKutiju(Kutija druga) {
        if (getImaPoklopac() && druga.getZapremina() < getZapremina()) {
            return this;
        }

        return druga;
    }
}
