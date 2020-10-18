package cz.vse.ruzicka.logika;

 


/**
 *  Třída PrikazSeber implementuje pro hru příkaz seber.
 *@author     Jarmila Pavlickova, Luboš Pavlíček, Alena Buchalcevova
 *@version    z kurzu 4IT101 pro školní rok 2014/2015  
 */
public class PrikazSeber implements IPrikaz
{
private static final String NAZEV = "seber";
    private HerniPlan plan;
    private Batoh batoh;
  /**
    *  Konstruktor třídy
    *  
    *  @param plan herní plán, ve kterém se bude hledat aktuální místnost 
    */      
    public PrikazSeber(HerniPlan plan, Batoh batoh) {
        this.plan = plan;
        this.batoh = batoh;
    }
    /**
     *  Provádí příkaz "seber". V aktuální místnosti hledá věc, která je předána jako parametr
     *  
     *
     *@param parametry - jako  parametr obsahuje jméno věci,
     *                          která se má sebrat.
     *@return zpráva, kterou vypíše hra hráči
     */ 
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo , tak ....
            return "Co mám sebrat? Musíš zadat jméno věci";
        }

        String jmenoVeci = parametry[0];

        // vybereme věc
        Vec vec = plan.getAktualniProstor().vyberVec(jmenoVeci);

        if (vec == null) {
            return "Taková věc tu není a nebo ji nemůžeš vzít!";
        }
        else {
	     // uložíme věc do batohu	
	        batoh.vlozVec(vec);
            return "Sebral jsi " + jmenoVeci;
        }
    }
    public String getNazev() {
        return NAZEV;
    }
}

