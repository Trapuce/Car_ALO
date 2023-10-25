package fr.istic.nplouzeau.cartaylor.api;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class ConfiguratorFactory implements Factory {


    //private ;
    private Set<PartType> setPartypes = new HashSet<>();
    private Set<Category> setCategories = new HashSet<>();



    @Override
    public Set<Category> createCategories() {
        setCategories.add(new CategoryImpl("Engine"));
        setCategories.add(new CategoryImpl("Transmission"));
        setCategories.add(new CategoryImpl("Exterior"));
        setCategories.add(new CategoryImpl("Interior"));
        return setCategories;
    }

    @Override
    public Set<PartType> createPartTypes() {

        setPartypes.add(new PartTypeImpl("EG100", new CategoryImpl("Engine")));
        setPartypes.add(new PartTypeImpl("EG133", new CategoryImpl("Engine")));
        setPartypes.add(new PartTypeImpl("EG210", new CategoryImpl("Engine")));
        setPartypes.add(new PartTypeImpl("EG110", new CategoryImpl("Engine")));
        setPartypes.add(new PartTypeImpl("ED180", new CategoryImpl("Engine")));
        setPartypes.add(new PartTypeImpl("EH120", new CategoryImpl("Engine")));

        setPartypes.add(new PartTypeImpl("TM5", new CategoryImpl("Transmission")));
        setPartypes.add(new PartTypeImpl("TM6", new CategoryImpl("Transmission")));
        setPartypes.add(new PartTypeImpl("TA5", new CategoryImpl("Transmission")));
        setPartypes.add(new PartTypeImpl("TS6", new CategoryImpl("Transmission")));

        setPartypes.add(new PartTypeImpl("XC", new CategoryImpl("Exterior")));
        setPartypes.add(new PartTypeImpl("XM", new CategoryImpl("Exterior")));
        setPartypes.add(new PartTypeImpl("XS", new CategoryImpl("Exterior")));

        setPartypes.add(new PartTypeImpl("IN", new CategoryImpl("Interior")));
        setPartypes.add(new PartTypeImpl("IH", new CategoryImpl("Interior")));
        setPartypes.add(new PartTypeImpl("IS", new CategoryImpl("Interior")));
        return setPartypes;
    }
    @Override
    public List<String> jsonReader(String partypeToSeek ){
        File jsonFile = new File("/home/traore/Documents/Master/ALO/aco2019/src/fr/istic/nplouzeau/cartaylor/api/file.json");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(jsonFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        JSONTokener tokener = new JSONTokener(fileReader);

        JSONObject jsonData = new JSONObject(tokener);


        JSONObject incompatibilities = jsonData.getJSONObject("incompatibilities");
        JSONObject requirements = jsonData.getJSONObject("requirements");

        for (String key : incompatibilities.keySet()) {
            if(key.equals(partypeToSeek)){
                List<String> liste = Arrays.asList(incompatibilities.getString(key));
                return liste ;

            }
        }
        return null;
    }

}
