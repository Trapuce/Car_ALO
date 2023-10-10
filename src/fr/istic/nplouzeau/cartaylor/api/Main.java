package fr.istic.nplouzeau.cartaylor.api;

public class Main {

    public static void  main(String [] ars){


        Configurator conf = new ConfiguratorImpl();

          for(PartType p : conf.getVariants(new CategoryImpl("Exterior"))){

              System.out.println(p.getName());
          }
        for(Category c : conf.getCategories()){

            System.out.println(c.getName());
        }

    }
}
