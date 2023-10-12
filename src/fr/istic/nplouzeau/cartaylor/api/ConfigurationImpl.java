package fr.istic.nplouzeau.cartaylor.api;

import java.util.HashSet;
import java.util.Set;

public class ConfigurationImpl implements  Configuration{


    private  Set<PartType> selectedParts ;
    public ConfigurationImpl (Set<PartType> selectedParts){
        this.selectedParts = selectedParts;
    }
    public ConfigurationImpl (){
        this.selectedParts = new HashSet<>();
    }
    /**
     * look in set of parts if there are two parts of the same categories
     * @return Boolean  True if the configuration is valid
     * else False
     */
    @Override
    public boolean isValid() {
        for (PartType p: this.selectedParts) {
                for (PartType p2 : this.selectedParts){
                     if(!p.equals(p2.getName())  &&  p.getCategory().getName().equals(p2.getCategory().getName())){
                          return  false ;
                     }
                }
        }
        return  true ;
    }

    /**
     * look in set of parts if i have got all categories
     * @return Boolean True if the configuration isComplete
     * else False
     */
    @Override
    public boolean isComplete() {
      return  false ;
    }

    /**
     * @return copy sets of Partype
     */
    @Override
    public Set<PartType> getSelectedParts() {
        return  Set.copyOf(this.selectedParts);
    }

    /**
     * @param chosenPart
     * @throws IllegalArgumentException if an chosenPart is null
     * @Param chosenPart
     */
    @Override
    public void selectPart(PartType chosenPart) throws  IllegalArgumentException {
            if(chosenPart == null) {
                throw new IllegalArgumentException();
            }
            this.selectedParts.add(chosenPart);
    }

    /**
     * @param category
     * @return PartType for category given
     * @throws IllegalArgumentException if an category is null
     * @Param category
     */
    @Override
    public PartType getSelectionForCategory(Category category) throws  IllegalArgumentException {
         if(category == null){ new IllegalArgumentException();}

        for(PartType p : selectedParts) {
             if(p.getCategory().getName().equals(category.getName())){
                 return p ;
             }
        }
        return  null ;
    }

    /**
     * @param categoryToClear
     * @throws IllegalArgumentException if an categoryToClear is null
     * @Param categoryToClear
     */
    @Override
    public void unselectPartType(Category categoryToClear) {

    }

    /**
     * clean the whole configuration
     */
    @Override
    public void clear() {
            this.selectedParts = new HashSet<>();
    }
}
