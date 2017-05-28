package primerlosenapisanogprograma;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class KutijaFileReader {
    private final File file;

    public KutijaFileReader(String imeDatoteke) throws Exception {
        checkFilename(imeDatoteke);

        file = new File(imeDatoteke);

        checkIfTheFileIsUsable(file);
    }

    private void checkFilename(String imeDatoteke) throws Exception {
        if ( !Pattern.compile("^.*\\.txt$").matcher(imeDatoteke).matches() ) {
            throw new Exception("Datoteka mora da ima ekstenziju .txt da bi program mogao da je koristi.");
        }
    }
    
    private void checkIfTheFileIsUsable(File file) throws Exception {
        if ( ! file.exists() || ! file.isFile() || !file.canRead() ) {
            throw new Exception("Datoteka ne postoji ili nije moguce citanje izabrane datoteke.");
        }
    }
    
    public List<Kutija> ucitajKutije() throws FileNotFoundException {
        List<Kutija> kutije = new ArrayList<>();

        Scanner s = new Scanner(file);

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
}
