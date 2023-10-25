package fr.istic.nplouzeau.cartaylor.api;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConfiguratorImpl implements  Configurator{


    private Configuration configuration ;
    private Set<Category> categories = new HashSet<>();
    public Set<PartType>  partTypes;
    private Map<Category , Set<PartType>>  res ;
    private CompatiblityManagerImpl compatiblityManager;

    public ConfiguratorImpl(Factory factory){
        this.configuration = new ConfigurationImpl() ;
        this.compatiblityManager = new CompatiblityManagerImpl();
        this.categories = factory.createCategories();
        this.partTypes = factory.createPartTypes();



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

                        for (PartType p : partTypes){

                               if(p.getCategory().getName().equals(c.getName())){
                                    res.add(p);
                               }
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
        return this.configuration ;
    }



    /**
     * @return set incompatibilities and Requierments
     */
    @Override
    public CompatibilityChecker getCompatibilityChecker() {
        return  new CompatiblityManagerImpl();
    }
}
