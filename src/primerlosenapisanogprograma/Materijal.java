package primerlosenapisanogprograma;

/**
 * Poseban enum tip za vrstu materijala od kojeg mogu da budu napravljene kutije
 * @author Milantex
 */
public enum Materijal {
    KARTON ("KARTON"),
    PLASTIKA ("PLASTIKA"),
    METAL ("METAL");

    /**
     * U datoteci je ovaj pdoatak string i kao takav ga prihvatamo na ovom mestu
     */
    private final String materijal;

    /**
     * Konstruktor enum instance
     * @param materijal Ime materijala od kojeg može da bude napravljena kutija
     */
    private Materijal(final String materijal) {
        this.materijal = materijal;
    }

    /**
     * Vraćamo string prikaz vrednosti enum tipa, jer sa stringovima radimo u
     * prikazu materijala u glavnom programu.
     * @return Ime materijala
     */
    @Override
    public String toString() {
        return this.materijal;
    }
}
