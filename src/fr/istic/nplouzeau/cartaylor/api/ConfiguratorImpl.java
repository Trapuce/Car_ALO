package fr.istic.nplouzeau.cartaylor.api;

import java.util.HashSet;
import java.util.Set;

public class ConfiguratorImpl implements  Configurator{


    private Configuration configuration ;
    private Set<Category> categories = new HashSet<>();

    public ConfiguratorImpl(){
        this.categories.add(new CategoryImpl("Engine"));
        this.categories.add(new CategoryImpl("Transmission"));
        this.categories.add(new CategoryImpl("Exterior"));
        this.categories.add(new CategoryImpl("Interior"));
        this.configuration = new ConfigurationImpl() ;
    }
    public ConfiguratorImpl(Configuration configuration){
        this.configuration = configuration;
        this.categories.add(new CategoryImpl("Engine"));
        this.categories.add(new CategoryImpl("Transmission"));
        this.categories.add(new CategoryImpl("Exterior"));
        this.categories.add(new CategoryImpl("Interior"));
    }
    /**
     * @return copy set of categories
     */
    @Override
    public Set<Category> getCategories() {
        return Set.copyOf(this.categories);
    }

    /**
     * @param category
     * @return copy set of Partype
     * @throws IllegalArgumentException if category is null
     */
    @Override
    public Set<PartType> getVariants(Category category) {
        Set<PartType> res = new HashSet<>();
        for(Category c : categories) {
             if(c.getName().equals(category.getName())){

                    switch (c.getName()){
                        case "Engine" :
                            res.add(new PartTypeImpl("EG100" , c));
                            res.add(new PartTypeImpl("EG133" , c));
                            res.add(new PartTypeImpl("EG210" , c));
                            res.add(new PartTypeImpl("EG110" , c));

                            break;
                        case "Transmission":
                            res.add(new PartTypeImpl("TM5" , c));
                            res.add(new PartTypeImpl("TM6" , c));
                            res.add(new PartTypeImpl("TA5" , c));
                            res.add(new PartTypeImpl("TS6" , c));
                            break;
                        case "Exterior":
                            res.add(new PartTypeImpl("xc" , c));
                            res.add(new PartTypeImpl("xm" , c));
                            res.add(new PartTypeImpl("xs" , c));
                            break;
                        case "Interior":
                            res.add(new PartTypeImpl("IN" , c));
                            res.add(new PartTypeImpl("IH" , c));
                            res.add(new PartTypeImpl("IS" , c));
                            break;
                        default:
                            System.out.println("Category unknown !!!!");
                    }

             }
        }
        return  res ;
    }

    /**
     * @return the configuration
     */
    @Override
    public Configuration getConfiguration() {
        //if(configuration == null){ return  new ConfigurationImpl() ;}
        return this.configuration ;
    }



    /**
     * @return set incompatibilities and Requierments
     */
    @Override
    public CompatibilityChecker getCompatibilityChecker() {
        return null;
    }
}
