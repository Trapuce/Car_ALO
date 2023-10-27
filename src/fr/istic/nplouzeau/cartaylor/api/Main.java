package fr.istic.nplouzeau.cartaylor.api;

import java.util.Map;
import java.util.Set;

public class Main {

    public static void  main(String [] ars){


        Configurator conf = new ConfiguratorImpl(new ConfiguratorAutoComponentFactory());
       /* for (PartType p : ((ConfiguratorImpl) conf).partTypes){
            System.out.println(p.getName()  + " num : "+ count);
            count++;
        }*/
        int count = 1 ;
        for (Map.Entry<PartType, Set<PartType>> entry : ((ConfiguratorImpl) conf).requirements.entrySet()) {
            PartType key = entry.getKey();
            Set<PartType> values = entry.getValue();

            System.out.println("Clé : " + key.getName() + " num : "+ count);

            for (PartType value : values) {
                System.out.println("Valeur : " + value.getName());
            }
            count ++ ;
        }

    }
}
