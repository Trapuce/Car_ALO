package fr.istic.nplouzeau.cartaylor.api;

import java.util.*;

public class ConfiguratorImpl implements  Configurator{


    private Configuration configuration ;
    private Set<Category> categories ;
    public Set<PartType>  partTypes;
    public Map<PartType , Set<PartType>> incompatibilities ;
    public Map<PartType , Set<PartType>> requirements ;

    private Map<Category , Set<PartType>>  res ;
    private CompatibilityManager compatiblityManager;

    public ConfiguratorImpl(AutoComponentFactory autoComponentFactory){
        this.configuration = new ConfigurationImpl() ;


        this.categories = autoComponentFactory.createCategories();
        this.partTypes = autoComponentFactory.createPartTypes();
        this.incompatibilities = autoComponentFactory.createIncompatiblities();
        this.requirements = autoComponentFactory.createRequirements();
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
        Set<PartType> result = new HashSet<>();
        for (Category targetCategory : categories) {
            if (targetCategory.getName().equals(category.getName())) {
                for (PartType partType : partTypes) {
                    if (partType.getCategory().getName().equals(category.getName())) {
                        result.add(partType);
                    }
                }
            }
        }
        return result;
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
        return new CompatibilityManager() {
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
                if(partTypeRequirements.containsKey(reference)){
                    Set<PartType> requirements = partTypeRequirements.get(reference);
                    requirements.addAll(target);
                    partTypeRequirements.put(reference,requirements);
                }else {
                    partTypeRequirements.put(reference, target);
                }


                for (PartType p : partTypeRequirements.get(reference)){

                    Set<PartType> requirements = partTypeRequirements.get(p);
                    requirements.add(reference);
                    partTypeRequirements.put(p,requirements);
                }
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
                Set<PartType> requirements = partTypeRequirements.get(target);
                if(requirements != null){
                    requirements.remove(reference);
                    partTypeRequirements.put(target , requirements);
                }
            }
        };
    }
}
