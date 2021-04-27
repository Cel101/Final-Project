/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle.generator;

/**
 *
 * @author marce
 */
import java.util.Random;
public class Realm {
    //Class Field
    private String[] biomeList;
    private String[] featuresList;
    private String realmName;
    
    public Realm(){
        
    }
    public Realm(String name, String[] biome, String[] features){
        realmName = name;
        biomeList = biome;
        featuresList = features;
    }

    public String[] getBiomeList() {
        return biomeList;
    }

    public void setBiomeList(String[] biomeList) {
        this.biomeList = biomeList;
    }

    public String[] getFeaturesList() {
        return featuresList;
    }

    public void setFeaturesList(String[] featuresList) {
        this.featuresList = featuresList;
    }

    public String getRealmName() {
        return realmName;
    }

    public void setRealmName(String realmName) {
        this.realmName = realmName;
    }
    public String getBiome(int index){
        String biome = this.biomeList[index];
        return biome;
    }
    public String getFeature(int index){
        String feat = this.featuresList[index];
        return feat;
    }
    
    
}//End Class
