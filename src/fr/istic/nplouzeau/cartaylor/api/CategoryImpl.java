package fr.istic.nplouzeau.cartaylor.api;

public class CategoryImpl implements  Category{

    private String name ;

    public CategoryImpl(String name){
        this.name = name ;
    }
    /**
     * @return category's name
     */
    @Override
    public String getName() {
        return this.name;
    }
}
