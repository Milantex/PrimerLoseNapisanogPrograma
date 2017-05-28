package primerlosenapisanogprograma;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PrimerLoseNapisanogPrograma {
    public static void main(String[] args) {
        if (args.length != 1) {
            prikaziPomoc();
            return;
        }

        System.out.println("Ucitavam datoteku " + args[0]);

        if (!isFilenameValid(args[0])) {
            System.out.println("Datoteka mora da ima ekstenziju .txt da bi program mogao da je koristi.");
            return;
        }

        File f = new File(args[0]);

        if ( ! isFileUsable(f) ) {
            System.out.println("Datoteka ne postoji ili nije moguce citanje izabrane datoteke.");
            return;
        }

        List<Kutija> kutije = ucitajKutijeIzDatoteke(f);

        Kutija najbolja = kutije.get(0);
        for (int i=0; i<kutije.size(); i++) {
            if (kutije.get(i).getImaPoklopac() &&
                najbolja.getZapremina() < kutije.get(i).getZapremina()) {
                najbolja = kutije.get(i);
            }
        }

        System.out.println("Najbolja kutija je: ");
        System.out.println("Naziv: " + najbolja.getNaziv());
        System.out.println("Širina: " + najbolja.getSirina());
        System.out.println("Dužina: " + najbolja.getDuzina());
        System.out.println("Visina: " + najbolja.getVisina());
        System.out.println("Materijal: " + najbolja.getMaterijal());
        System.out.println("Ima poklopac: " + ((najbolja.getImaPoklopac())?"Da":"Ne"));
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
    
    public static List<Kutija> ucitajKutijeIzDatoteke (File f) {
        List<Kutija> kutije = new ArrayList<>();

        try {
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
        } catch (Exception e) { }

        return kutije;
    }
}
