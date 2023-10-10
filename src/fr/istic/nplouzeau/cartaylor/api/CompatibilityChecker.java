package fr.istic.nplouzeau.cartaylor.api;

import java.util.Set;

public interface CompatibilityChecker {
    /**
     * 
     * @param reference
     * @return copy set of Partype
     * @throws IllegalArgumentException if reference is null
     */
    Set<PartType> getIncompatibilities(PartType reference);
    /**
     * 
     * @param reference
     * @return copy set of Partype
     *  @throws IllegalArgumentException if reference is null
     */
    Set<PartType> getRequirements(PartType reference);

}
