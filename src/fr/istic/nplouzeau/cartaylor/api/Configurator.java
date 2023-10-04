package fr.istic.nplouzeau.cartaylor.api;

import java.util.Set;

public interface Configurator {

    /**
     * 
     * @return copy set of categories
     */
    Set<Category> getCategories();
    /**
     *
     * @param category
     * @return copy set of Partype
     * @throws  NullArgumentException  if category is null
     */
    Set<PartType> getVariants(Category category);
    
    /**
     * 
     * @return  the configuration
     */
    Configuration getConfiguration();

    /**
     * 
     * @return set incompatibilities and Requierments
     */
    CompatibilityChecker getCompatibilityChecker();

}
