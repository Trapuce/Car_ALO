package fr.istic.nplouzeau.cartaylor.api;

public class Engine implements  Category {

    private String name ;
    public Engine(){
        this.name = "Type Of Engine ";
    }
    /**
     * @return category's name
     */
    @Override
    public String getName() {
        return this.name;
    }
}
