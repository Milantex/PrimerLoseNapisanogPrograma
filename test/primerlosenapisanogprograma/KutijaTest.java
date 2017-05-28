package primerlosenapisanogprograma;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * Test za testiranje klase Kutija
 * @author Milantex
 */
public class KutijaTest extends TestCase {
    private Kutija kutija = new Kutija();

    /**
     * Ovaj metod popunjava podrazumevane, očekivane, vrednosti testne kutije.
     */
    private void remakeKutija() {
        kutija.setNaziv("Kutija A");
        kutija.setSirina(10.0f);
        kutija.setVisina(5.0f);
        kutija.setDuzina(2.0f);
        kutija.setImaPoklopac(true);
        kutija.setMaterijal(Materijal.PLASTIKA);
    }

    /**
     * Test of getZapremina method, of class Kutija.
     */
    @Test
    public void testGetZapremina() {
        remakeKutija();
        assertEquals(100.0F, kutija.getZapremina(), 0.0);
    }

    /**
     * Test of getNaziv method, of class Kutija.
     */
    @Test
    public void testGetNaziv() {
        remakeKutija();
        assertEquals("Kutija A", kutija.getNaziv());
    }

    /**
     * Test of setNaziv method, of class Kutija.
     */
    @Test
    public void testSetNaziv() {
        remakeKutija();
        String naziv = "Kutija B";
        assertEquals(naziv, kutija.setNaziv(naziv).getNaziv());
    }

    /**
     * Test of getSirina method, of class Kutija.
     */
    @Test
    public void testGetSirina() {
        remakeKutija();
        assertEquals(kutija.getSirina(), 10.0f, 0.0f);
    }

    /**
     * Test of setSirina method, of class Kutija.
     */
    @Test
    public void testSetSirina() {
        remakeKutija();
        assertEquals(20.0f, kutija.setSirina(20.0f).getSirina());
        assertEquals(10.0f, kutija.setSirina(10.0f).getSirina());
        assertEquals(10.0f, kutija.setSirina(0.0f).getSirina());
        assertEquals(10.0f, kutija.setSirina(-1000.0f).getSirina());
    }

    /**
     * Test of getDuzina method, of class Kutija.
     */
    @Test
    public void testGetDuzina() {
        remakeKutija();
        assertEquals(kutija.getDuzina(), 2.0f, 0.0f);
    }

    /**
     * Test of setDuzina method, of class Kutija.
     */
    @Test
    public void testSetDuzina() {
        assertEquals(20.0f, kutija.setDuzina(20.0f).getDuzina());
        assertEquals(10.0f, kutija.setDuzina(10.0f).getDuzina());
        assertEquals(10.0f, kutija.setDuzina(0.0f).getDuzina());
        assertEquals(10.0f, kutija.setDuzina(-1000.0f).getDuzina());
    }

    /**
     * Test of getVisina method, of class Kutija.
     */
    @Test
    public void testGetVisina() {
        remakeKutija();
        assertEquals(kutija.getVisina(), 5.0f, 0.0f);
    }

    /**
     * Test of setVisina method, of class Kutija.
     */
    @Test
    public void testSetVisina() {
        assertEquals(20.0f, kutija.setVisina(20.0f).getVisina());
        assertEquals(10.0f, kutija.setVisina(10.0f).getVisina());
        assertEquals(10.0f, kutija.setVisina(0.0f).getVisina());
        assertEquals(10.0f, kutija.setVisina(-1000.0f).getVisina());
    }

    /**
     * Test of getMaterijal method, of class Kutija.
     */
    @Test
    public void testGetMaterijal() {
        remakeKutija();
        assertEquals(Materijal.PLASTIKA, kutija.getMaterijal());
    }

    /**
     * Test of setMaterijal method, of class Kutija.
     */
    @Test
    public void testSetMaterijal() {
        remakeKutija();
        assertEquals(Materijal.KARTON, kutija.setMaterijal(Materijal.KARTON).getMaterijal());
        assertEquals(Materijal.PLASTIKA, kutija.setMaterijal(Materijal.PLASTIKA).getMaterijal());
        assertEquals(Materijal.METAL, kutija.setMaterijal(Materijal.METAL).getMaterijal());
    }

    /**
     * Test of getImaPoklopac method, of class Kutija.
     */
    @Test
    public void testGetImaPoklopac() {
        remakeKutija();
        assertEquals(true, kutija.getImaPoklopac());
    }

    /**
     * Test of setImaPoklopac method, of class Kutija.
     */
    @Test
    public void testSetImaPoklopac() {
        remakeKutija();
        assertEquals(true, kutija.setImaPoklopac(true).getImaPoklopac());
    }

    /**
     * Test of imaPoklopac method, of class Kutija.
     */
    @Test
    public void testImaPoklopac() {
        remakeKutija();
        assertEquals(true, kutija.imaPoklopac().getImaPoklopac());
    }

    /**
     * Test of nemaPoklopac method, of class Kutija.
     */
    @Test
    public void testNemaPoklopac() {
        remakeKutija();
        assertEquals(false, kutija.nemaPoklopac().getImaPoklopac());
    }

    /**
     * Test of toString method, of class Kutija.
     */
    @Test
    public void testToString() {
        remakeKutija();
        String expResult = "Naziv: Kutija A\n" +
                           "Širina: 10.0\n" +
                           "Dužina: 2.0\n" +
                           "Visina: 5.0\n" +
                           "Materijal: PLASTIKA\n" +
                           "Ima poklopac: Da\n";
        assertEquals(expResult, kutija.toString());
    }

    /**
     * Test of vratiBoljuKutiju method, of class Kutija.
     */
    @Test
    public void testVratiBoljuKutiju() {
        remakeKutija();

        Kutija druga = new Kutija();
        druga.setNaziv("BOLJA");
        druga.setSirina(20.0f);
        druga.setVisina(10.0f);
        druga.setDuzina(10.0f);
        druga.setImaPoklopac(true);
        druga.setMaterijal(Materijal.METAL);

        assertSame(druga, kutija.vratiBoljuKutiju(druga));

        druga = new Kutija();
        druga.setNaziv("NIJE BOLJA");
        druga.setSirina(1.0f);
        druga.setVisina(1.0f);
        druga.setDuzina(1.0f);
        druga.setImaPoklopac(false);
        druga.setMaterijal(Materijal.PLASTIKA);

        assertSame(kutija, kutija.vratiBoljuKutiju(druga));
    }
}
