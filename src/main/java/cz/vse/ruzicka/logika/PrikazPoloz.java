package cz.vse.ruzicka.logika;

 

/**
 *  Třída PrikazPoloz implementuje pro hru příkaz poloz.
 *@author     Alena Buchalcevova
 *@version    z kurzu 4IT101 pro školní rok 2014/2015  
 */

public class PrikazPoloz implements IPrikaz
{
private static final String NAZEV = "poloz";
    private HerniPlan plan;
    private Batoh batoh;
  /**
    *  Konstruktor třídy
    *  
    *  @param plan herní plán, ve kterém se bude hledat aktuální místnost 
    */      
    public PrikazPoloz(HerniPlan plan, Batoh batoh) {
        this.plan = plan;
        this.batoh = batoh;
    }
    /**
     *  Provádí příkaz "poloz". V batohu hledá věc, která je předána jako parametr
     *  pokud ji najde, vyjme ji z bathu a vloží do aktuální místnosti 
     *
     *@param parametry - jako  parametr obsahuje jméno věci,
     *                          která se má položit.
     *@return zpráva, kterou vypíše hra hráči
     */ 
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo , tak ....
            return "Co mám položit? Musíš zadat jméno věci";
        }

        String jmenoVeci = parametry[0];

        // vybereme věc
        Vec vec = batoh.vyberVec(jmenoVeci);

        if (vec == null) {
            return "Taková věc v batohu není ";
        }
        else {
	     // vložíme věc do místnosti
	        plan.getAktualniProstor().vlozVec(vec);
            return "Položil jsi " + jmenoVeci;
        }
    }
    public String getNazev() {
        return NAZEV;
    }

}
