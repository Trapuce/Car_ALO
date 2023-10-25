package fr.istic.nplouzeau.cartaylor.api;

public class Main {

    public static void  main(String [] ars){


        Configurator conf = new ConfiguratorImpl(new ConfiguratorFactory());

          for(PartType p : ((ConfiguratorImpl) conf).partTypes){

              System.out.println(p.getName());
          }
        for(Category c : conf.getCategories()){

            System.out.println(c.getName());
        }

    }
}
