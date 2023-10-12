package fr.istic.nplouzeau.cartaylor.api;

import java.util.HashSet;
import java.util.Set;

public class ConfiguratorFactory implements  Factory{




    @Override
    public Set<Category> createCategories() {
        Set<Category> res = new HashSet<>();
        res.add(new CategoryImpl("Engine"));
        res.add(new CategoryImpl("Transmission"));
        res.add(new CategoryImpl("Exterior"));
        res.add(new CategoryImpl("Interior"));
        return   res ;
    }

    @Override
    public Set<PartType> createPartTypes() {
        Set<PartType> res = new HashSet<>();

        res.add(new PartTypeImpl("EG100" , new CategoryImpl("Engine")));
        res.add(new PartTypeImpl("EG133" , new CategoryImpl("Engine")));
        res.add(new PartTypeImpl("EG210" , new CategoryImpl("Engine")));
        res.add(new PartTypeImpl("EG110" , new CategoryImpl("Engine")));

        res.add(new PartTypeImpl("TM5" , new CategoryImpl("Transmission")));
        res.add(new PartTypeImpl("TM6" , new CategoryImpl("Transmission")));
        res.add(new PartTypeImpl("TA5" , new CategoryImpl("Transmission")));
        res.add(new PartTypeImpl("TS6" , new CategoryImpl("Transmission")));

        res.add(new PartTypeImpl("xc" , new CategoryImpl("Exterior")));
        res.add(new PartTypeImpl("xm" , new CategoryImpl("Exterior")));
        res.add(new PartTypeImpl("xs" , new CategoryImpl("Exterior")));

        res.add(new PartTypeImpl("IN" , new CategoryImpl("Interior")));
        res.add(new PartTypeImpl("IH" , new CategoryImpl("Interior")));
        res.add(new PartTypeImpl("IS" , new CategoryImpl("Interior")));
        return  res ;
    }
}
