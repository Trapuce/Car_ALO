package fr.istic.nplouzeau.cartaylor.api;

public class PartTypeImpl implements  PartType{

    private String name ;
    private Category category ;
    public PartTypeImpl ( String name , Category category){
        this.name = name ;
        this.category = category;
    }
    /**
     * @return PartType's name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * @return category
     */
    @Override
    public Category getCategory() {
        return this.category;
    }
}
