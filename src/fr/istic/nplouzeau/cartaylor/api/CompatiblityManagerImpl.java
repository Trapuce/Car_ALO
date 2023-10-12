package fr.istic.nplouzeau.cartaylor.api;

import java.util.Set;

public class CompatiblityManagerImpl implements  CompatibilityManager{
    /**
     * @param reference
     * @return copy set of Partype
     * @throws IllegalArgumentException if reference is null
     */
    @Override
    public Set<PartType> getIncompatibilities(PartType reference) {
        return null;
    }

    /**
     * @param reference
     * @return copy set of Partype
     * @throws IllegalArgumentException if reference is null
     */
    @Override
    public Set<PartType> getRequirements(PartType reference) {
        return null;
    }

    /**
     * add the incompatibilities
     *
     * @param reference
     * @param target
     * @throws IllegalArgumentException if reference or target is null
     */
    @Override
    public void addIncompatibilities(PartType reference, Set<PartType> target) {

    }

    /**
     * remove  incompatibility
     *
     * @param reference
     * @param target
     * @throws IllegalArgumentException if reference or target is null
     */
    @Override
    public void removeIncompatibility(PartType reference, PartType target) {

    }

    /**
     * add requirements
     *
     * @param reference
     * @param target
     * @throws IllegalArgumentException if reference or target is null
     */
    @Override
    public void addRequirements(PartType reference, Set<PartType> target) {

    }

    /**
     * remove requirement
     *
     * @param reference
     * @param target
     * @throws IllegalArgumentException if reference or target is null
     */
    @Override
    public void removeRequirement(PartType reference, PartType target) {

    }
}
