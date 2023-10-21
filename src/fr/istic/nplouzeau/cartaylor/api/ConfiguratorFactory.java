package fr.istic.nplouzeau.cartaylor.api;

import java.util.*;

public class ConfiguratorFactory implements Factory {


    //private ;


    @Override
    public Set<Category> createCategories() {
        Set<Category> res = new HashSet<>();
        res.add(new CategoryImpl("Engine"));
        res.add(new CategoryImpl("Transmission"));
        res.add(new CategoryImpl("Exterior"));
        res.add(new CategoryImpl("Interior"));
        return res;
    }

    @Override
    public Set<PartType> createPartTypes() {
        Set<PartType> res = new HashSet<>();

        res.add(new PartTypeImpl("EG100", new CategoryImpl("Engine")));
        res.add(new PartTypeImpl("EG133", new CategoryImpl("Engine")));
        res.add(new PartTypeImpl("EG210", new CategoryImpl("Engine")));
        res.add(new PartTypeImpl("EG110", new CategoryImpl("Engine")));

        res.add(new PartTypeImpl("TM5", new CategoryImpl("Transmission")));
        res.add(new PartTypeImpl("TM6", new CategoryImpl("Transmission")));
        res.add(new PartTypeImpl("TA5", new CategoryImpl("Transmission")));
        res.add(new PartTypeImpl("TS6", new CategoryImpl("Transmission")));

        res.add(new PartTypeImpl("xc", new CategoryImpl("Exterior")));
        res.add(new PartTypeImpl("xm", new CategoryImpl("Exterior")));
        res.add(new PartTypeImpl("xs", new CategoryImpl("Exterior")));

        res.add(new PartTypeImpl("IN", new CategoryImpl("Interior")));
        res.add(new PartTypeImpl("IH", new CategoryImpl("Interior")));
        res.add(new PartTypeImpl("IS", new CategoryImpl("Interior")));
        return res;
    }

   /* public Map<PartType, Set<PartType>> createIncompatibiltiesOfPartype() {
        Map<PartType, Set<PartType>> res = new HashMap<PartType, Set<PartType>>();
        //Engines
        res.put(new PartTypeImpl("EG100", new CategoryImpl("Engine")), new HashSet<>());
        res.put(new PartTypeImpl("EG133", new CategoryImpl("Engine")), new HashSet<>());
        res.put(new PartTypeImpl("EG110", new CategoryImpl("Engine")), new HashSet<>());
        res.put(new PartTypeImpl("EG210", new CategoryImpl("Engine")), new HashSet<>());
        //Transmision
        Set<PartType> incompatibilitiesTransmission = new HashSet<>();
        incompatibilitiesTransmission.add(new PartTypeImpl("EG100", new CategoryImpl("Engine")));
        incompatibilitiesTransmission.add(new PartTypeImpl("EG133", new CategoryImpl("Engine")));
        incompatibilitiesTransmission.add(new PartTypeImpl("ED110", new CategoryImpl("Engine")));
        res.put(new PartTypeImpl("TSF7", new CategoryImpl("Transmission")), incompatibilitiesTransmission);
        res.put(new PartTypeImpl("TM5", new CategoryImpl("Transmission")), new HashSet<>());
        res.put(new PartTypeImpl("TM6", new CategoryImpl("Transmission")), new HashSet<>());
        res.put(new PartTypeImpl("TA5", new CategoryImpl("Transmission")), new HashSet<>());
        res.put(new PartTypeImpl("TS6", new CategoryImpl("Transmission")), new HashSet<>());
        //Exterior
        Set<PartType> incompatibilitiesExterior = new HashSet<>();
        res.put(new PartTypeImpl("XC", new CategoryImpl("Exterior")), new HashSet<>());
        res.put(new PartTypeImpl("XM", new CategoryImpl("Exterior")), new HashSet<>());
        res.put(new PartTypeImpl("XS", new CategoryImpl("Exterior")), new HashSet<>());


    }*/
}
