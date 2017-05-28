package primerlosenapisanogprograma;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class PrimerLoseNapisanogPrograma {
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

                            kutije.get(kutije.size()-1).setNaziv(s.next());
                            kutije.get(kutije.size()-1).setSirina(s.nextFloat());
                            kutije.get(kutije.size()-1).setDuzina(s.nextFloat());
                            kutije.get(kutije.size()-1).setVisina(s.nextFloat());
                            kutije.get(kutije.size()-1).setMaterijal(s.next());

                            String imaNemaPoklopac = s.nextLine().trim();
                            kutije.get(kutije.size()-1).setImaPoklopac(imaNemaPoklopac.equals("T"));
                        }
                    } catch (Exception e) { }

                    Kutija najbolja = kutije.get(0);
                    for (int i=0; i<kutije.size(); i++) {
                        if (kutije.get(i).getImaPoklopac() &&
                            najbolja.getSirina()*najbolja.getVisina()*najbolja.getDuzina() < kutije.get(i).getSirina()*kutije.get(i).getVisina()*kutije.get(i).getDuzina()) {
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
                } else {
                    System.out.println("Datoteka ne postoji ili nije moguce citanje izabrane datoteke.");
                }
            } else {
                System.out.println("Datoteka mora da ima ekstenziju .txt da bi program mogao da je koristi.");
            }
        }
    }
}
