package fr.istic.nplouzeau.cartaylor.api;

import java.util.*;

public class CompatibilityManagerImpl implements  CompatibilityManager{
    private Map<PartType , Set<PartType>> partTypeIncompatibilities = new HashMap<>();
    private Map<PartType , Set<PartType>> partTypeRequirements = new HashMap<>();

    /**
     * @param reference
     * @return copy set of Partype
     * @throws IllegalArgumentException if reference is null
     */
    @Override
    public Set<PartType> getIncompatibilities(PartType reference) {
        if(partTypeIncompatibilities.containsKey(reference)){

            return  partTypeIncompatibilities.get(reference);
        }
        return Set.of();
    }

    /**
     * @param reference
     * @return copy set of Partype
     * @throws IllegalArgumentException if reference is null
     */
    @Override
    public Set<PartType> getRequirements(PartType reference) {
        if(partTypeRequirements.containsKey(reference)){

            return  partTypeRequirements.get(reference);
        }
        return Set.of();
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
        Objects.requireNonNull(reference , "You have passed a null reference ");
        Objects.requireNonNull(target , "You have  Passed a null target");
        if(partTypeIncompatibilities.containsKey(reference)){
            Set<PartType> referenceIncompatibilties = partTypeIncompatibilities.get(reference);
            referenceIncompatibilties.addAll(target);
            partTypeIncompatibilities.put(reference,referenceIncompatibilties);
        }else {
            partTypeIncompatibilities.put(reference, target);
        }

        for (PartType partType : target){

            Set<PartType> incompatiblities = partTypeIncompatibilities.get(partType);
            incompatiblities.add(reference);
            partTypeIncompatibilities.put(partType,incompatiblities);
        }



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
        Objects.requireNonNull(reference , "You have passed a null reference ");
        Objects.requireNonNull(target , "You have  Passed a null target");
        Set<PartType> referenceIncompatibilities =  partTypeIncompatibilities.get(reference);
        if(referenceIncompatibilities != null){
            Set<PartType> updatedReferenceIncompatibilities = new HashSet<>(referenceIncompatibilities);
            for(PartType p : referenceIncompatibilities){
                if(p.getName().equals(target.getName())){
                    updatedReferenceIncompatibilities.remove(p);
                }
            }
            partTypeIncompatibilities.put(reference , updatedReferenceIncompatibilities);
        }

        Set<PartType> targetIncompatibilities = partTypeIncompatibilities.get(target);
        if(targetIncompatibilities != null){
            Set<PartType> updatedTargetIncompatibilities = new HashSet<>(targetIncompatibilities);
            updatedTargetIncompatibilities.remove(reference);
            partTypeIncompatibilities.put(target , updatedTargetIncompatibilities);
        }


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
        Objects.requireNonNull(reference , "You have passed a null reference ");
        Objects.requireNonNull(target , "You have  Passed a null target");
        Set<PartType> referenceRequirements = partTypeRequirements.get(reference);
        referenceRequirements.addAll(target);
        for (PartType partType :target){
            Set<PartType> requirements = partTypeRequirements.get(partType);
            for (PartType partTypeRequirement : requirements){
                referenceRequirements.add(partTypeRequirement);
            }
        }
        partTypeRequirements.put(reference,referenceRequirements);
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
        Objects.requireNonNull(reference , "You have passed a null reference ");
        Objects.requireNonNull(target , "You have  Passed a null target");
       Set<PartType> referenceRequirements = partTypeRequirements.get(reference);
       for(PartType partType : referenceRequirements){
             if(partType.getName().equals(target.getName())){
                  for (PartType targetRequirements : partTypeRequirements.get(partType)){
                            referenceRequirements.remove(targetRequirements);
                  }
                  referenceRequirements.remove(partType);
                  break;
             }
       }
        partTypeRequirements.put(reference,referenceRequirements);
    }
}