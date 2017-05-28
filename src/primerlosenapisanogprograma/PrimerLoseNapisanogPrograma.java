package primerlosenapisanogprograma;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class PrimerLoseNapisanogPrograma {
    public static class Kutija {
        public String naziv;
        public float sirina, duzina, visina;
        public String materijal;
        public boolean imaPoklopac;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println();
            System.out.println("Program učitava datoteku sa podacima o vrstama kutija i pronalazi onu sa najvećom zapreminom koja ima poklopac.");
            System.out.println();
            System.out.println("Program radi sa datotekama koje imaju ekstenziju .txt i koje imaju sledeću strukturu:");
            System.out.println("Naziv(string) Širina(float) Dužina(float) Visina(float) Materijal(KARTON|PLASTIKA|METAL) Poklopac(T|F)");
            System.out.println();
            System.out.println("Način poziva programa:");
            System.out.println("program ime_datoteke.txt");
            System.out.println();
        } else {
            System.out.println("Ucitavam datoteku " + args[0]);

            if (args[0].length() > 4 &&
                args[0].charAt(args[0].length()-4) == '.' &&
                args[0].charAt(args[0].length()-3) == 't' &&
                args[0].charAt(args[0].length()-2) == 'x' &&
                args[0].charAt(args[0].length()-1) == 't') {

                File f = new File(args[0]);

                if (f.exists() && f.isFile() && f.canRead()) {
                    ArrayList<Kutija> kutije = new ArrayList<>();

                    try {
                        Scanner s = new Scanner(f);

                        while (s.hasNext()) {
                            kutije.add(new Kutija());

                            kutije.get(kutije.size()-1).naziv = s.next();
                            kutije.get(kutije.size()-1).sirina = s.nextFloat();
                            kutije.get(kutije.size()-1).duzina = s.nextFloat();
                            kutije.get(kutije.size()-1).visina = s.nextFloat();
                            kutije.get(kutije.size()-1).materijal = s.next();

                            String imaNemaPoklopac = s.nextLine().trim();
                            kutije.get(kutije.size()-1).imaPoklopac = imaNemaPoklopac.equals("T");
                        }
                    } catch (Exception e) { }

                    Kutija najbolja = kutije.get(0);
                    for (int i=0; i<kutije.size(); i++) {
                        if (kutije.get(i).imaPoklopac &&
                            najbolja.sirina*najbolja.visina*najbolja.duzina < kutije.get(i).sirina*kutije.get(i).visina*kutije.get(i).duzina) {
                            najbolja = kutije.get(i);
                        }
                    }

                    System.out.println("Najbolja kutija je: ");
                    System.out.println("Naziv: " + najbolja.naziv);
                    System.out.println("Širina: " + najbolja.sirina);
                    System.out.println("Dužina: " + najbolja.duzina);
                    System.out.println("Visina: " + najbolja.visina);
                    System.out.println("Materijal: " + najbolja.materijal);
                    System.out.println("Ima poklopac: " + ((najbolja.imaPoklopac)?"Da":"Ne"));
                } else {
                    System.out.println("Datoteka ne postoji ili nije moguce citanje izabrane datoteke.");
                }
            } else {
                System.out.println("Datoteka mora da ima ekstenziju .txt da bi program mogao da je koristi.");
            }
        }
    }
}
