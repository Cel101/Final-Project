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
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
public class BattleGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        
        //Variables
        Scanner input = new Scanner(System.in);
        int menuChoice = 0;
        int rollingChoice = 0;
        String realmChoice = "";
        int pointsChoice = 0;
        ArrayList<String> nighthaunt = new ArrayList<String>();
        Desktop d = Desktop.getDesktop();
        int unitMenu = 0;
        
        
        //Biome Arrays
        String[] aqshyBio = new String[] {"Volcanic", "Forest Ruin", "Chaos Wastes", "Desert"};
        String[] shyishBio = new String[] {};
        String[] ghyranBio = new String[] {};
        
        //Feature Arrays
        String[] aqshyFeat = new String[] {"Scorched Landscape", "Flaming Missiles", "Clouds of Smoke and Steam", "Every Step a League", "Burning Skies", "Geysers of Boiling Blood"};
        String[] shyishFeat = new String[] {};
        String[] ghyranFeat = new String[] {};
        
        //Intialize Realm Objects
        Realm aqshy = new Realm("Aqshy", aqshyBio, aqshyFeat);
        Realm shyish = new Realm();
        Realm ghyran = new Realm();
        
        //Intialize Realm Array
        Realm[] realms = new Realm[3];
        realms[0] = aqshy;
        realms[1] = shyish;
        realms[2] = ghyran;
        
        //Deployment Array
        String[] deploy = new String[6];
        deploy[0] = "Standard Deployment";
        deploy[1] = "Field Split Vertcally Deployment";
        deploy[2] = "Field Split Horizontally Deployment";
        deploy[3] = "Ambush Deployment";
        deploy[4] = "Seige Deployment";
        deploy[5] = "Surrounded Deployment";
        
        //Datastore Manipulation
        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
        
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("Death - Nighthaunt.cat");
            NodeList nameList = doc.getElementsByTagName("entryLink");
                                                                                System.out.println(nameList.getLength());
                                                                                System.out.println(nameList.item(2).toString());
            
            for (int i = 0; i < nameList.getLength(); i++){
                Node p = nameList.item(i);
                if (p.getNodeType() == Node.ELEMENT_NODE){
                    Element entryLink = (Element) p;
                    String id = entryLink.getAttribute("name");
                    System.out.println(id);
                    nighthaunt.add(id);
                    NodeList nameList1 = entryLink.getChildNodes();
                    for (int j = 0; j < nameList1.getLength(); j++){
                        System.out.println("J LOOP");
                        Node n = nameList1.item(j);
                        if (n.getNodeType() == Node.ELEMENT_NODE){
                            Element name = (Element) n;
                            System.out.println("Person " +id +":" +name.getTagName() +"=" +name.getTextContent());
                        }//End Node n if
                        else {
                            System.out.println("Something is wrong 2");
                        }
                    }//End for
                }//End if
                else {
                    System.out.println("Something is Wrong");
                }
            }//End for
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(BattleGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(BattleGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BattleGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        ArrayList<String> nighthauntLords = new ArrayList<String>();
        nighthauntLords.add(nighthaunt.get(0));
        nighthauntLords.add(nighthaunt.get(1));
        nighthauntLords.add(nighthaunt.get(2));
        nighthauntLords.add(nighthaunt.get(4));
        nighthauntLords.add(nighthaunt.get(5));
        nighthauntLords.add(nighthaunt.get(6));
        ArrayList<String> nighthauntUnits = new ArrayList<String>();
        nighthauntUnits.add(nighthaunt.get(3));
        nighthauntUnits.add(nighthaunt.get(10));
        nighthauntUnits.add(nighthaunt.get(22));
        nighthauntUnits.add(nighthaunt.get(23));
        nighthauntUnits.add(nighthaunt.get(24));
        nighthauntUnits.add(nighthaunt.get(26));
        
        ArrayList<String> playerLords = new ArrayList<String>();
        //End Datastore Manipulation
        
        //Menu Loop
        while (menuChoice != 10){
            menu();
            menuChoice = input.nextInt();
            if (menuChoice > 10 || menuChoice < 1){     //OPTION !
                System.out.println("Option not available: Please choose betweeen 1 and 10");
            }
            else if (menuChoice == 1){                  //OPTION 1
                realmChoice = realms[realmMenu()].getRealmName();
                System.out.println(realmChoice);
                
            }
            else if (menuChoice == 2){                  //OPTION 2
                pointsChoice = pointsMenu();
            }
            else if (menuChoice == 3){                  //OPTION 3
                rollingChoice = 0;
                
                while (rollingChoice != 2){
                    System.out.println("Choose from the following");
                    System.out.println("1.) Add Available Lord Models");
                    System.out.println("2.) Back to Main Menu");
                    rollingChoice = input.nextInt();
                    if (rollingChoice < 0 || rollingChoice > 2){
                        System.out.println("You must choose either 1 or 2");
                    }
                    else if (rollingChoice == 1){
                        System.out.println("Select a Lord model to add: ");
                        System.out.println("1.)" +nighthauntLords.get(0));
                        System.out.println("2.)" +nighthauntLords.get(1));
                        System.out.println("3.)" +nighthauntLords.get(2));
                        System.out.println("4.)" +nighthauntLords.get(3));
                        System.out.println("5.)" +nighthauntLords.get(4));
                        System.out.println("6.)" +nighthauntLords.get(5));
                        unitMenu = input.nextInt();
                        if (unitMenu < 0 || unitMenu > 6){
                            System.out.println("You can only choose an option from 1 to 6");
                        }
                        else if(unitMenu == 1){
                            playerLords.add(nighthauntLords.get(0));
                        }
                        else if(unitMenu == 2){
                            playerLords.add(nighthauntLords.get(1));
                        }
                        else if(unitMenu == 3){
                            playerLords.add(nighthauntLords.get(2));
                        }
                        else if(unitMenu == 4){
                            playerLords.add(nighthauntLords.get(3));
                        }
                        else if(unitMenu == 5){
                            playerLords.add(nighthauntLords.get(4));
                        }
                        else if(unitMenu == 6){
                            playerLords.add(nighthauntLords.get(5));
                        }
                    }
                    else if (rollingChoice == 2){
                        System.out.println("Returning to Main Menu");
                    }
                }
                
            }//End menu 3
            else if (menuChoice == 4){                  //Option 4 See Campaign Info
                if (realmChoice == ""){
                    System.out.println("No realm has been chosen");
                }
                else {
                    System.out.println("Realm: " +realmChoice);
                }
                if (pointsChoice == 0){
                    System.out.println("No point value has been set");
                }
                else {
                    System.out.println("Points: " +pointsChoice);
                }
                
            }
            else if (menuChoice == 5){          //Option 5 See Character Sheet
                characterSheet();
                
            }//End Menu 5
            else if (menuChoice == 6){          //Option 6 Generate Battleplan
                if (realmChoice == ""){
                    System.out.println("No realm has been chosen. Please select option 1 from the main menu and set the realm");
                }
                else if (pointsChoice == 0){
                    System.out.println("No points value has been chosen. Please select option 2 from main menu and set points value");
                }
                else{
                    System.out.println("The realm location is " +realmChoice);
                    System.out.println("The battlefield is " +realms[0].getBiome(rollD4()));
                    System.out.println("The realm feature is " +realms[0].getFeature(rollD6()));
                    System.out.println("You will face a unit of " +nighthauntUnits.get(rollD6()) +" lead by " +nighthauntLords.get(rollD6()));
                    System.out.println("Battle will be played at " +pointsChoice);
                    System.out.println("Models will be placed on the table using " +deploy[rollD6()]);
                }
                
            }//End Menu 6
            else if (menuChoice == 7){          //OPTION 7 Roll Dice
                System.out.println("How many dice would you like to roll? ");
                rollingChoice = input.nextInt();
                System.out.println("RESULTS:");
                for (int i = 0; i < rollingChoice; ++i){
                    System.out.println(rollD6()+1);
                }
                
            }
            else if (menuChoice == 8){          //OPTION 8 See Rules
                try {
                    d.browse(new URI("https://ageofsigmar.com/wp-content/uploads/sites/12/2018/06/AoS_Rules-ENG.pdf"));
                } catch (URISyntaxException ex) {
                    Logger.getLogger(BattleGenerator.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            else if (menuChoice == 9){          //OPTION 9 Visit GW
                try {
                    d.browse(new URI("https://www.games-workshop.com/en-US/Warhammer-Age-of-Sigmar"));
                } catch (URISyntaxException ex) {
                    Logger.getLogger(BattleGenerator.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            else if (menuChoice == 10){
                System.out.println("Thanks for playing!");
            }
            
        }//End Menu Loop
        
    }//End Main
    
    public static void menu(){
        System.out.println("Main Menu");
        System.out.println("1.) Set Realm Location");
        System.out.println("2.) Set Points Value");
        System.out.println("3.) Set Available Models");
        System.out.println("4.) See Campaign Info");
        System.out.println("5.) See Character Sheet");
        System.out.println("6.) Generate Battleplan");
        System.out.println("7.) Roll Dice");
        System.out.println("8.) See Game Rules");
        System.out.println("9.) Visit Games Workshop");
        System.out.println("10.) Exit Program");
    }//End Menu Method
    
    public static int realmMenu(){
        int choice = 0;
        while (choice != 1 && choice != 2 && choice != 3){
        System.out.println("Choose the Realm for the Battleplan");
        System.out.println("1.) Aqshy: Realm of Fire");
        System.out.println("2.) Shyish: Realm of Death");
        System.out.println("3.) Ghyran: Realm of Life");
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();
        
        if (choice < 1 || choice > 3){
            System.out.println("Option not available: Choose and option between 1 and 3");
        }
        else if (choice == 1){
            System.out.println("You have chosen Aqshy");
            choice = 1;
        }
        else if (choice == 2){
            System.out.println("You have chosen Shyish");
            choice = 2;
        }
        else if (choice == 3){
            System.out.println("You have chosen Ghyran");
            choice = 3;
        }
        }//End While
        return choice - 1;
    }//End Realm Menu
    public static int pointsMenu(){
        Scanner input = new Scanner(System.in);
        int points = 0;
        System.out.println("Enter the current points value for the campaign");
        points = input.nextInt();
        System.out.println("Campaign points set to " +points);
        return points;
    }
    public static int rollD4(){
        int result = 0;
        result = (int)(Math.random() * 4) +1;
        return result -1;
    }
    public static int rollD6(){
        int result = 0;
        result = (int)(Math.random() * 6) +1;
        return result -1;
    }
    public static void characterSheet() throws IOException{
        Scanner input = new Scanner(System.in);
        Desktop d = Desktop.getDesktop();
        int choice = 0;
        System.out.println("Select Character Sheet to view: ");
        System.out.println("1.) Stormcast Eternals: Gardus Steelsoul");
        System.out.println("2.) Lumineth Realm-Lords: Scinari Cathallar");
        System.out.println("3.) Sylvaneth: Druanti the Arch-Revenant");
        System.out.println("4.) Fyreslayers: Grimwrath Berzerker");
        System.out.println("5.) Seraphon: Skink Starpriest");
        choice = input.nextInt();
        if (choice < 1 || choice > 5){
            System.out.println("You must choose between 1 and 5. Returning to main menu");
        }
        else if (choice == 1){
            try {
                    d.browse(new URI("https://www.games-workshop.com/resources/PDF/AoS_Warscrolls/BR_Belakor_Warscroll_GardusSteelSoul_eng.pdf"));
                } catch (URISyntaxException ex) {
                    Logger.getLogger(BattleGenerator.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        else if (choice == 2){
            try {
                    d.browse(new URI("https://www.games-workshop.com/resources/PDF/AoS_Warscrolls/Lumineth_Warscroll_Scinari%20Cathallar%20-%20eng.pdf"));
                } catch (URISyntaxException ex) {
                    Logger.getLogger(BattleGenerator.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        else if (choice == 3){
            try {
                    d.browse(new URI("https://www.games-workshop.com/resources/PDF/AoS_Warscrolls/AoS_Arch_Revenant_ENG.pdf"));
                } catch (URISyntaxException ex) {
                    Logger.getLogger(BattleGenerator.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        else if (choice == 4){
            try {
                    d.browse(new URI("https://www.games-workshop.com/resources/PDF/AoS_Warscrolls/BR_Belakor_Warscroll_GrimwrathBerzerker_eng.pdf"));
                } catch (URISyntaxException ex) {
                    Logger.getLogger(BattleGenerator.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        else if (choice == 5){
            try {
                    d.browse(new URI("https://www.games-workshop.com/resources/PDF/AoS_Warscrolls/Seraphon_warscroll_Skink-Starpriest-en.pdf"));
                } catch (URISyntaxException ex) {
                    Logger.getLogger(BattleGenerator.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
}//End Class
