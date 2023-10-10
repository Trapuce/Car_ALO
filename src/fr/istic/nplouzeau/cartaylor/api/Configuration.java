package fr.istic.nplouzeau.cartaylor.api;


import java.util.Set;

public interface Configuration {

    /**
     * @return Boolean  True if the configuration is valid
     * else False
     */
    boolean isValid();

    /**
     * @return Boolean True if the configuration isComplete 
     * else False
     */
    boolean isComplete();

    /**
     * @return copy sets of Partype 
     */
    Set<PartType> getSelectedParts();
    /**
     * @Param chosenPart
     * @throws  IllegalArgumentException  if an chosenPart is null
     */
    void selectPart(PartType chosenPart);

    /**
     * @Param category
     * @return PartType for category given
     * @throws IllegalArgumentException if an category is null
     */
    PartType getSelectionForCategory(Category category);

    /**
     * @Param categoryToClear
     * @throws IllegalArgumentException if an categoryToClear is null
     */
    void unselectPartType(Category categoryToClear);
    /**
     * clean the whole configuration
     */
    void clear();

}
