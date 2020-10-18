package cz.vse.ruzicka.logika;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování
 * třídy Hra
 *
 * @author    Jarmila Pavlíčková
 * @version  pro školní rok 2014/2015
 */
public class HraTest {
    private Hra hra1;

    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    //== Příprava a úklid přípravku ================================================

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
        hra1 = new Hra();
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /***************************************************************************
     * Testuje průběh hry, po zavolání každěho příkazu testuje, zda hra končí
     * a v jaké aktuální místnosti se hráč nachází.
     * Při dalším rozšiřování hry doporučujeme testovat i jaké věci nebo osoby
     * jsou v místnosti a jaké věci jsou v batohu hráče.
     * 
     */
    @Test
    public void testPrubehHry() {
        assertEquals("domecek", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi les");
        assertEquals(false, hra1.konecHry());
        assertEquals("les", hra1.getHerniPlan().getAktualniProstor().getNazev());
        hra1.zpracujPrikaz("jdi hluboky_les");
        assertEquals(false, hra1.konecHry());
        assertEquals("hluboky_les", hra1.getHerniPlan().getAktualniProstor().getNazev());

        // následuje ukázka testování věcí - zatím nejsou ani hlavičky metod
        
        //assertTrue(hra1.getHerniPlan().getAktualniProstor().obsahujeVec("kapradí"));
        //hra1.zpracujPrikaz("seber kapradí");
        //assertEquals(false, hra1.konecHry());    
        //assertEquals("hluboký_les", hra1.getHerniPlan().getAktualniProstor().getNazev());
        //assertFalse(hra1.getHerniPlan().getAktualniProstor().obsahujeVec("kapradí"));
        //assertTrue(hra1.getHerniPlan().getBatoh().obsahujeVec("kapradí"));

        // příkaz konec
        hra1.zpracujPrikaz("konec");
        assertEquals(true, hra1.konecHry());
    }
}
