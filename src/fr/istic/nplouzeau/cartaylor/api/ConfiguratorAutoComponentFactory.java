package fr.istic.nplouzeau.cartaylor.api;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class ConfiguratorAutoComponentFactory implements AutoComponentFactory {


    private  File jsonFile = new File("/home/traore/Documents/Master/ALO/aco2019/src/fr/istic/nplouzeau/cartaylor/api/file.json");

    private Set<PartType> setOfPartTypes = new HashSet<>();
    private Set<Category> setOfCategories = new HashSet<>();
    private Map<PartType,Set<PartType>> setOfIncompatibilities = new HashMap<>();
    private Map<PartType,Set<PartType>> setOfRequirements = new HashMap<>();


    @Override
    public Set<Category> createCategories() {
        JSONObject jsonData = JSONReader();
        for (String key : jsonData.keySet()){
             Category category = new CategoryImpl(key);
            setOfCategories.add(category);
        }
        return setOfCategories;
    }

    @Override
    public Set<PartType> createPartTypes() {
        JSONObject jsonData = JSONReader();

        for(String category : jsonData.keySet()){
            JSONObject categoryJSONObject  = jsonData.getJSONObject(category);
            for (String key : categoryJSONObject.keySet()){
                 setOfPartTypes.add(new PartTypeImpl(key , new CategoryImpl(category)));
            }
        }
        return  setOfPartTypes;

    }

    @Override
    public Map<PartType, Set<PartType>> createIncompatiblities() {
        JSONObject jsonData = JSONReader();
        for(String jsonObject : jsonData.keySet()){
            fileJSON(jsonData.getJSONObject(jsonObject ) , "incompatibilities" , this.setOfIncompatibilities);
        }
        return setOfIncompatibilities ;
    }

    @Override
    public Map<PartType, Set<PartType>> createRequirements() {
        JSONObject jsonData = JSONReader();
        for(String jsonObject : jsonData.keySet()){
            fileJSON(jsonData.getJSONObject(jsonObject ),"requirements", this.setOfRequirements);
        }
        return setOfRequirements ;
    }
    private PartType search(String s){
        for (PartType p : setOfPartTypes){
             if(p.getName().equals(s)){
                  return   p ;
             }
        }
        return null ;

    }

    private JSONObject JSONReader() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(jsonFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        JSONTokener tokener = new JSONTokener(fileReader);

        JSONObject jsonData = new JSONObject(tokener);

        return jsonData;
    }
    private void fileJSON( JSONObject  jsonObject , String type , Map<PartType, Set<PartType>>  parts ) {
        for (String key : jsonObject.keySet()) {
            PartType partTypeKey = search(key);
            Set<PartType> result = new HashSet<>();
            JSONObject jsonObjectKey = jsonObject.getJSONObject(key);
            JSONArray partTypeArray = jsonObjectKey.getJSONArray(type);
            if (partTypeArray.length() != 0) {
                for (int i = 0; i < partTypeArray.length(); i++) {
                    String incompatibility = partTypeArray.getString(i);
                    result.add(search(incompatibility));
                }
                parts.put(partTypeKey, result);
            } else {
                parts.put(partTypeKey, new HashSet<>());
            }

        }
    }
}
