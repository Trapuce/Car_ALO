package fr.istic.nplouzeau.cartaylor.api;

import java.util.List;
import java.util.Set;

public interface Factory {

    public Set<Category>createCategories();
    public Set<PartType>createPartTypes();
    public List<String> jsonReader(String partypeToSeek);
}
