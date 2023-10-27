package fr.istic.nplouzeau.cartaylor.api;

import java.util.Map;
import java.util.Set;

public interface AutoComponentFactory {

    public Set<Category>createCategories();
    public Set<PartType>createPartTypes();
    public Map<PartType , Set<PartType>> createIncompatiblities();
    public Map<PartType , Set<PartType>> createRequirements();

}
