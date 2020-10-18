package cz.vse.ruzicka.logika;

 

import java.util.Map;
import java.util.HashMap;
/**
 *  Trida Batoh 
 *
 *
 *@author     Alena Buchalcevova
 *@version    z kurzu 4IT101 pro školní rok 2014/2015
 */

public class Batoh
{
public static final int KAPACITA = 3 ;
private Map<String, Vec> seznamVeci ;   // seznam věcí v batohu

public Batoh () {
seznamVeci = new HashMap<String, Vec>();
}
 /**
     * Vloží věc do batohu
     *
     *@param  vec  instance věci, která se má vložit
     */
   public void vlozVec (Vec vec) {
     seznamVeci.put(vec.getJmeno(),vec);
    }
     /**
     * Vrací řetězec názvů věcí, které jsou v batohu

     *@return            řetězec názvů
     */
    public String nazvyVeci () {
        String nazvy = "věci v batohu: ";
        for (String jmenoVeci : seznamVeci.keySet()){
            	nazvy += jmenoVeci + " ";
        }
        return nazvy;
    }
     /**
     * Hledá věc daného jména a pokud je v batohu, tak ji vrátí a vymaže ze seznamu

     *@param  jmeno   Jméno věci
     *@return            věc nebo
     *                   hodnota null, pokud tam věc daného jména není 
     */
    public Vec vyberVec (String jmeno) {
        Vec nalezenaVec = null;
        if (seznamVeci.containsKey(jmeno)) {
            nalezenaVec = seznamVeci.get(jmeno);
            seznamVeci.remove(jmeno);
        }   
        return nalezenaVec;
    }

}



