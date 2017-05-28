package primerlosenapisanogprograma;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PrimerLoseNapisanogPrograma {
    public static void main(String[] args) {
        if ( ! postojiTačnoJedanArgument(args) ) {
            prikaziPomoc();
            return;
        }

        String imeDatoteke = args[0];

        if (!isFilenameValid(imeDatoteke)) {
            System.err.println("Datoteka mora da ima ekstenziju .txt da bi program mogao da je koristi.");
            return;
        }

        File f = new File(imeDatoteke);

        if ( ! isFileUsable(f) ) {
            System.err.println("Datoteka ne postoji ili nije moguce citanje izabrane datoteke.");
            return;
        }

        try {
            List<Kutija> kutije = ucitajKutijeIzDatoteke(f);

            System.out.println(pronadjiNajboljuKutiju(kutije));
        } catch (FileNotFoundException e) {
            System.err.println("Došlo je do greške prilikom čitanja datoteke. Greška: " + e.getMessage());
        }
    }

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

    public static boolean isFilenameValid(String filename) {
        return Pattern.compile("^.*\\.txt$").matcher(filename).matches();
    }

    public static boolean isFileUsable(File f) {
        return f.exists() && f.isFile() && f.canRead();
    }
    
    public static List<Kutija> ucitajKutijeIzDatoteke (File f) throws FileNotFoundException {
        List<Kutija> kutije = new ArrayList<>();

        Scanner s = new Scanner(f);

        while (s.hasNext()) {
            Kutija k = new Kutija();

            k.setNaziv(s.next());
            k.setSirina(s.nextFloat());
            k.setDuzina(s.nextFloat());
            k.setVisina(s.nextFloat());
            k.setMaterijal(s.next());
            k.setImaPoklopac(s.nextLine().trim().equals("T"));

            kutije.add(k);
        }

        return kutije;
    }

    public static Kutija pronadjiNajboljuKutiju(List<Kutija> kutije) {
        Kutija najbolja = kutije.get(0);

        for (Kutija k : kutije) {
            najbolja = k.vratiBoljuKutiju(najbolja);
        }

        return najbolja;
    }

    public static boolean postojiTačnoJedanArgument(String args[]) {
        return args.length == 1;
    }
}
