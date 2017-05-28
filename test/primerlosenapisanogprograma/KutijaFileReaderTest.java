package primerlosenapisanogprograma;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Milantex
 */
public class KutijaFileReaderTest extends TestCase {
    private File file;

    private final String tesFileContents = "K451-A3    10.00  5.00  5.00 KARTON   T\n" +
                                           "PAK560-500  5.00 10.00 10.00 PLASTIKA T\n" +
                                           "K450-RR     7.50  7.50  5.25 KARTON   F\n" +
                                           "LI-600      5.00 10.00 10.00 METAL    T\n" +
                                           "K450-RO     7.50  7.50  1.50 KARTON   F\n" +
                                           "K451-A8    12.25  5.00 10.00 KARTON   T\n" +
                                           "LER-202-Y  10.00 10.00  6.70 METAL    F\n";

    @Before
    @Override
    public void setUp() throws Exception {
        file = File.createTempFile("test-file", ".txt");
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.append(tesFileContents);
            pw.flush();
        }
    }

    /**
     * Test of ucitajKutije method, of class KutijaFileReader.
     * @throws java.lang.Exception
     */
    @Test
    public void testUcitajKutije() throws Exception {
        String fileName = file.getAbsolutePath();

        KutijaFileReader kutijaFileReader = new KutijaFileReader(fileName);
        List<Kutija> kutije = kutijaFileReader.ucitajKutije();

        assertEquals(7, kutije.size());
        assertEquals("PAK560-500", kutije.get(1).getNaziv());
        assertEquals(5.0f, kutije.get(1).getSirina());
        assertEquals(7.5f, kutije.get(2).getDuzina());
        assertEquals(1.5f, kutije.get(4).getVisina());
        assertEquals(Materijal.KARTON, kutije.get(5).getMaterijal());
        assertEquals(false, kutije.get(6).getImaPoklopac());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        file.delete();
    }
}
