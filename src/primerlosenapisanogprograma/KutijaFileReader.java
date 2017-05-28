package primerlosenapisanogprograma;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Klasa koja se koristi za učitavanje podataka o kutijama iz datoteke u listu.
 * @author Milantex
 */
public class KutijaFileReader {
    private final File file;

    /**
     * Pravi čitač datoteke sa podacima o kutijama za datoteku sa daim imenom.
     * Daje izuzetak u slučaju da ime datoteke nije ispravno, da na putanji ne
     * postoji datoteka, da na putanji nije datoteka ili da nije moguće čitanje
     * podataka iz navedene datoteke.
     * @param imeDatoteke Ime datoteke iz koje treba učitati podatke o kutijama
     * @throws Exception Izuzeci u slučaju opisanih problematičnih situacija
     */
    public KutijaFileReader(String imeDatoteke) throws Exception {
        checkFilename(imeDatoteke);

        file = new File(imeDatoteke);

        checkIfTheFileIsUsable(file);
    }

    /**
     * Ako ime datoteke nije ispravno, tj. ako se ne završava sa .txt, metod
     * objavljuje izuzetak sa adekvatnom porkukom.
     * @param imeDatoteke Ime datoteke
     * @throws Exception Opisani izuzetak koji može da nastane
     */
    private void checkFilename(String imeDatoteke) throws Exception {
        if ( !Pattern.compile("^.*\\.txt$").matcher(imeDatoteke).matches() ) {
            throw new Exception("Datoteka mora da ima ekstenziju .txt da bi program mogao da je koristi.");
        }
    }
    
    /**
     * Ako data datoteka ne postoji, nije u pitanju datoteka ili nije moguće
     * čitanje iz nje, metod daje izuzetak sa adekvatnom porukom.
     * @param file Datoteka sa kojom se radi
     * @throws Exception Opisani izuzetak koji može da nastane
     */
    private void checkIfTheFileIsUsable(File file) throws Exception {
        if ( ! file.exists() || ! file.isFile() || !file.canRead() ) {
            throw new Exception("Datoteka ne postoji ili nije moguce citanje izabrane datoteke.");
        }
    }

    /**
     * Metod učitava sve podatke o kutijama iz datoteke za koju je ovaj čitač
     * napravljen i kao rezultat vraća listu objekata klase Kutija čiji članovi
     * podaci su popunjeni adekvatnim vrednostima.
     * Daje izuzetak u slučaju da datoteka ne postoji ili ako dođe do problema
     * prilikom čitanja sadržaja iz datoteke pomoću skenera.
     * @return Lista objekata klase Kutija čiji podaci su učitani iz datoteke
     * @throws FileNotFoundException Opisani izuzetak
     */
    public List<Kutija> ucitajKutije() throws FileNotFoundException {
        List<Kutija> kutije = new ArrayList<>();

        Scanner s = new Scanner(file);

        while (s.hasNext()) {
            Kutija k = new Kutija();

            k.setNaziv(s.next());
            k.setSirina(s.nextFloat());
            k.setDuzina(s.nextFloat());
            k.setVisina(s.nextFloat());
            k.setMaterijal(Materijal.valueOf(s.next()));
            k.setImaPoklopac(s.nextLine().trim().equals("T"));

            kutije.add(k);
        }

        return kutije;
    }
}
