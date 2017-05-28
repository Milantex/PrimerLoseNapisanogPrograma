package primerlosenapisanogprograma;

import java.util.List;

/**
 * Program koji učitava podatke o kutijama iz datoteke čije ime je dato kao
 * jedini argument u pozivu iz komandne linije i prikazuje podatke o kutiji koja
 * je identifikovana kao najbolja.
 * @author Milantex
 */
public class PrimerLoseNapisanogPrograma {
    /**
     * Metod main programa u kojem se obavlja sva logika. Viši nivo apstrakcije.
     * @param args Spisak argumenata komandne linije
     */
    public static void main(String[] args) {
        if ( ! postojiTačnoJedanArgument(args) ) {
            prikaziPomoc();
            return;
        }

        String imeDatoteke = args[0];
        
        try {
            KutijaFileReader kutijaFileReader = new KutijaFileReader(imeDatoteke);
            List<Kutija> kutije = kutijaFileReader.ucitajKutije();
            Kutija najbolja = pronadjiNajboljuKutiju(kutije);
            System.out.println(najbolja);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Metod koji prikazuje uputstvo za korišćenje programa.
     */
    public static void prikaziPomoc() {
        System.out.println();
        System.out.println("Program učitava datoteku sa podacima o vrstama kutija i pronalazi onu sa najvećom zapreminom koja ima poklopac.");
        System.out.println();
        System.out.println("Program radi sa datotekama koje imaju ekstenziju .txt i koje imaju sledeću strukturu:");
        System.out.println("Naziv(string) Širina(float) Dužina(float) Visina(float) Materijal(KARTON|PLASTIKA|METAL) Poklopac(T|F)");
        System.out.println();
        System.out.println("Način poziva programa:");
        System.out.println("program ime_datoteke.txt");
        System.out.println();
    }

    /**
     * Metod koji pronalazi onu kutiju koja je najbolja.
     * @param kutije Lista kutija iz koje treba pronaći najbolju
     * @return Najbolja kutija
     */
    public static Kutija pronadjiNajboljuKutiju(List<Kutija> kutije) {
        Kutija najbolja = kutije.get(0);

        for (Kutija k : kutije) {
            najbolja = k.vratiBoljuKutiju(najbolja);
        }

        return najbolja;
    }

    /**
     * Suvišan metod koji proverava da li postoji tačno jedan argument u pozivu
     * programa kroz komandnu liniju.
     * @param args Spisak argumenata iz poziva programa kroz komandnu liniju
     * @return Da li postoji tačno jedan argument
     */
    public static boolean postojiTačnoJedanArgument(String args[]) {
        return args.length == 1;
    }
}
