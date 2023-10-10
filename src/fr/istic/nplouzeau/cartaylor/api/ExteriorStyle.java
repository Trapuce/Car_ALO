package fr.istic.nplouzeau.cartaylor.api;

public class ExteriorStyle implements  Category{

    private String name ;
    public ExteriorStyle(){
        this.name = "Exterior Style";
    }
    /**
     * @return category's name
     */
    @Override
    public String getName() {
        return this.name;
    }
}
