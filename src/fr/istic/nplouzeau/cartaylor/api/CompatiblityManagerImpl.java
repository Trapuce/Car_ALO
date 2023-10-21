package fr.istic.nplouzeau.cartaylor.api;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CompatiblityManagerImpl implements  CompatibilityManager{

    private Map<PartType , Set<PartType>> partTypeIncompatibilities ;
    private Map<PartType , Set<PartType>> partTypeRequirements ;

    public CompatiblityManagerImpl(){
        this.partTypeIncompatibilities = new HashMap<>();
        this.partTypeRequirements = new HashMap<>();
    }
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
        partTypeIncompatibilities.put(reference ,target);
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
        Set<PartType> tmp = new HashSet<>();
        tmp =  partTypeIncompatibilities.get(reference);
        for(PartType p : tmp){

            if(p.getName().equals(target.getName())){
                    tmp.remove(p);
            }
        }
        partTypeIncompatibilities.put(reference , tmp);

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
                partTypeRequirements.put(reference,target);
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
        Set<PartType> tmp = new HashSet<>();
        tmp =  partTypeRequirements.get(reference);
        for(PartType p : tmp){

            if(p.getName().equals(target.getName())){
                tmp.remove(p);
            }
        }
        partTypeRequirements.put(reference , tmp);
    }
}
