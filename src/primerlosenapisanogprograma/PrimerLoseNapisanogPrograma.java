package primerlosenapisanogprograma;

import java.util.List;

public class PrimerLoseNapisanogPrograma {
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
