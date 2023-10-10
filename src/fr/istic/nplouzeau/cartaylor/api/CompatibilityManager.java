package fr.istic.nplouzeau.cartaylor.api;

import java.util.Set;

public interface CompatibilityManager extends CompatibilityChecker {
    /**
     * add the incompatibilities
     * @param reference
     * @param target
     * @throws IllegalArgumentException if reference or target is null
     */
    void addIncompatibilities(PartType reference, Set<PartType> target);
    /**
     * remove  incompatibility
     * @param reference
     * @param target
     * @throws IllegalArgumentException if reference or target is null
     */
    void removeIncompatibility(PartType reference, PartType target);
    /**
     * add requirements
     * @param reference
     * @param target
     * @throws IllegalArgumentException if reference or target is null
     */
    void addRequirements(PartType reference, Set<PartType> target);
    /**
     * remove requirement
     * @param reference
     * @param target
     * @throws IllegalArgumentException if reference or target is null
     */
    void removeRequirement(PartType reference, PartType target);

}
