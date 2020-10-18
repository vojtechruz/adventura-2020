package cz.vse.ruzicka.logika;

/**
 *  Třída PrikazObsahBatohu implementuje pro hru příkaz obsahBatohu.
 *@author     Alena Buchalcevova
 *@version    z kurzu 4IT101 pro školní rok 2014/2015  
 */


public class PrikazObsahBatohu implements IPrikaz
{
private static final String NAZEV = "obsahBatohu";
    private Batoh batoh;
  /**
    *  Konstruktor třídy
    *  
    *  @param plan herní plán, ve kterém se bude hledat aktuální místnost 
    */      
    public PrikazObsahBatohu( Batoh batoh) {
        this.batoh = batoh;
    }
    /**
     *  Provádí příkaz "obsahBatohu". Vypíše názvy věcí v batohu
     *  
     *@return zpráva, kterou vypíše hra hráči
     */ 
    public String proved(String... parametry) {
            return batoh.nazvyVeci();
    }
   
    public String getNazev() {
        return NAZEV;
    }

}


