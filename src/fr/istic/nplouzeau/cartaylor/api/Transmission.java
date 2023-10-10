package fr.istic.nplouzeau.cartaylor.api;

public class Transmission implements Category{
    private String name;
    public Transmission (){
        this.name = "Type of Transmission";
    }
    /**
     * @return category's name
     */
    @Override
    public String getName() {
        return this.name;
    }
}
