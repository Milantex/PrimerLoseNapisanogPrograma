package primerlosenapisanogprograma;

/**
 * Klasa koja sadrži podatke o jednoj kutiji
 * @author Milantex
 */
public class Kutija {
    private String naziv;
    private float sirina, duzina, visina;
    private Materijal materijal;
    private boolean imaPoklopac;

    private Float zapremina;

    /**
     * Vraća zapreminu kutije.
     * Zapremina se računa prilikom svakog poziva metoda.
     * @return Zapremina
     */
    public float getZapremina() {
        if (zapremina == null) {
            zapremina = sirina * duzina * visina;
        }

        return zapremina;
    }

    /**
     * Vraća naziv kutije.
     * @return Naziv
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Pomoću ovog metoda se postavlja naziv kutije.
     * @param naziv Novi naziv kutije
     * @return Instanca kutije nad kojom je pozvan ovaj metod
     */
    public Kutija setNaziv(String naziv) {
        this.naziv = naziv;
        return this;
    }

    /**
     * Vraća širinu kutije.
     * @return Širina
     */
    public float getSirina() {
        return sirina;
    }

    /**
     * Pomoću ovog metoda se postavlja širina kutije.
     * @param sirina Nova širina kutije
     * @return Instanca kutije nad kojom je pozvan ovaj metod
     */
    public Kutija setSirina(float sirina) {
        if (sirina > 0) {
            this.sirina = sirina;
        }

        return this;
    }

    /**
     * Vraća dužinu kutije.
     * @return Dužina
     */
    public float getDuzina() {
        return duzina;
    }

    /**
     * Pomoću ovog metoda se postavlja dužina kutije.
     * @param duzina Nova dužina kutije
     * @return Instanca kutije nad kojom je pozvan ovaj metod
     */
    public Kutija setDuzina(float duzina) {
        if (duzina > 0) {
            this.duzina = duzina;
        }

        return this;
    }

    /**
     * Vraća visinu kutije.
     * @return Visina
     */
    public float getVisina() {
        return visina;
    }

    /**
     * Pomoću ovog metoda se postavlja visina kutije.
     * @param visina Nova visina kutije
     * @return Instanca kutije nad kojom je pozvan ovaj metod
     */
    public Kutija setVisina(float visina) {
        if (visina > 0) {
            this.visina = visina;
        }

        return this;
    }

    /**
     * Vraća materijal od kojeg ja napravljena kutija.
     * @return Materijal od kojeg je napravljena kutija
     */
    public Materijal getMaterijal() {
        return materijal;
    }

    /**
     * Pomoću ovog metoda se postavlja materijal od kojeg je napravljena kutija.
     * @param materijal Novi materijal od kojeg je napravljena kutija
     * @return Instanca kutije nad kojom je pozvan ovaj metod
     */
    public Kutija setMaterijal(Materijal materijal) {
        this.materijal = materijal;
        return this;
    }

    /**
     * Vraća informaciju o tome da li kutija ima poklopac ili ne.
     * @return Da li kutija ima poklopac
     */
    public boolean getImaPoklopac() {
        return imaPoklopac;
    }

    /**
     * Pomoću ovog metoda se navodi da li kutija ima poklopac ili ne.
     * @param imaPoklopac Da li kutija ima poklopac
     * @return Instanca kutije nad kojom je pozvan ovaj metod
     */
    public Kutija setImaPoklopac(boolean imaPoklopac) {
        this.imaPoklopac = imaPoklopac;
        return this;
    }

    /**
     * Pomoću ovog metoda se definiše da ova kutija ima poklopac.
     * @return Instanca kutije nad kojom je pozvan ovaj metod
     */
    public Kutija imaPoklopac() {
        this.setImaPoklopac(true);
        return this;
    }

    /**
     * Pomoću ovog metoda se definiše da ova kutija nema poklopac.
     * @return Instanca kutije nad kojom je pozvan ovaj metod
     */
    public Kutija nemaPoklopac() {
        this.setImaPoklopac(false);
        return this;
    }

    /**
     * Ovaj metod formira string sa podacima o kutiji u formatu koji mi želimo.
     * @return String sa podacima o kutiji
     */
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

    /**
     * Ovaj metod vraća onu kutiju koja je bolja.
     * Jedna kutija je bolja od druge ako ima poklopac i ako ima veću zapreminu.
     * @param druga Druga kutija u odnosu na koju se poredi ova trenutna
     * @return Kutija koja je bolja
     */
    public Kutija vratiBoljuKutiju(Kutija druga) {
        if (getImaPoklopac() && druga.getZapremina() < getZapremina()) {
            return this;
        }

        return druga;
    }
}
