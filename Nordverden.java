/* 
* Rigoberto Castro
* CS2011 Final (Concept)
* 
* Text Based Adventure Game
* Project Name: Nordverden (NorthWorld) 
* 
*       __              _                   _            
*    /\ \ \___  _ __ __| |_   _____ _ __ __| | ___ _ __  
*   /  \/ / _ \| '__/ _` \ \ / / _ \ '__/ _` |/ _ \ '_ \ 
*  / /\  / (_) | | | (_| |\ V /  __/ | | (_| |  __/ | | |
*  \_\ \/ \___/|_|  \__,_| \_/ \___|_|  \__,_|\___|_| |_|
*                                                     
* 
* Inspirations: Fallout 1 & 2 by Interplay, TES: Skyrim by Bethesda, and the youtuber Magic The Noah
* 
*/


import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;



public class Nordverden {
    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();

    static String welcomeMsg = ( "\n"
        + "\n    Welcome to"
        + "\n          __              _                   _            "
        + "\n       /\\ \\ \\___  _ __ __| |_   _____ _ __ __| | ___ _ __  "
        + "\n      /  \\/ / _ \\| '__/ _` \\ \\ / / _ \\ '__/ _` |/ _ \\ '_ \\ "
        + "\n     / /\\  / (_) | | | (_| |\\ V /  __/ | | (_| |  __/ | | |"
        + "\n     \\_\\ \\/ \\___/|_|  \\__,_| \\_/ \\___|_|  \\__,_|\\___|_| |_|"
        + "\n                                       Version 0.022.101824"
        + "\n" 
    );
//










// ----->   Function Junction   <-----



// --->   Misc. Methods   <---

    // Method that displays character's info
    static void pDisplayCharacter() {
        System.out.println("    This is your character:\n"
            + "    Name: " + pName + " (" + proSub + "/" + proObj + "/" + proPos + ")\n"
            + "    Race: " + pRace + "\n"
            + "    Class: " + pClass + "\n"
            + "    Health: " + pHealth + "/" + pMaxHealth + "\n"
            + "    Level: " + pLevel + " (" + pCurXp + "/" + pNextLvl + ")\n"
            + "    Karma: " + pKarma + "\n"
            + "    Passport: " +pNekoPassport + "\n\n"

            + "    These are " + proPos + " skills:\n"
            + "    Strenght ("+ pStrenght +"/100)\n"
            + "    Speech ("+ pSpeech +"/100)\n"
            + "    Stamina ("+ pStamina +"/100)\n"
            + "    Sorcery ("+ pSorcery +"/100)\n"
            + "    Sneak ("+ pSneak +"/100)\n\n"

            + "    These are " + proPos + " damage resistances:\n"
            + "    Bladed Damage Res. ("+ pBladeRes +")\n"
            + "    Blunt Damage Res. ("+ pBluntRes +")\n"
            + "    Magic Res. ("+ pMagicRes +")\n"
            + "    Poison Res. ("+ pPoisonRes +")\n"
            + "    Fire Res. ("+ pFireRes +")\n"
            + "    Frost Res. ("+ pFrostRes +")\n\n"

            + "    These are " + proPos + " damage multipliers:\n"
            + "    Unarmed Damage ("+ pUnarmedDmg +")\n"
            + "    Bladed Damage ("+ pBladeDmg +")\n"
            + "    Blunt Damage ("+ pBluntDmg +")\n"
            + "    Heavy Weapons Damage ("+ pHeavyDmg +")\n"
            + "    Magic Damage ("+ pMagicDmg +")\n"
            + "    Long Range Damage ("+ pRangedDmg +")\n\n"

            + "    Weapon: " + pWeapon + "\n"
            + "    Armour: " + pArmour
        );

        showInventory();
    }

    // Method that takes the players's input
    static String pSel = "";
    static void playerSelection(){
        pSel = "";
        pSel = input.next();

        if (pSel.equals("exit")) {
            System.out.println("\nGoodbye\n");
            input.close();
            System.exit(0);
        }

        if (pSel.equals("menu")) {
            openMenu();
        }

        System.out.println("\n____________________________________________________________________________________________________\n");
    }

    // Methods that display character stats
    static void playerStatsDisplay() {
        String pStatsDisplay = "";
        pStatsDisplay = ("\n\n    Level ("+ pLevel +") ["+ pCurXp +"/"+ pNextLvl +" xp]"
            + "\n    Health ("+ pHealth +"/" + pMaxHealth + ")"
            + "\n    Inventory Space ("+ pInvSpace +")"
            + "\n    Gold ("+ pGold +")"
            + "\n    Luck ("+ pLuck +")"
            + "\n    Class (" + pClass +")"
            + "\n    Race (" + pRace + ")"

            + "\n\n    Strenght ("+ pStrenght +"/100)"
            + "\n    Speech ("+ pSpeech +"/100)"
            + "\n    Stamina ("+ pStamina +"/100)"
            + "\n    Sorcery ("+ pSorcery +"/100)"
            + "\n    Sneak ("+ pSneak +"/100)"

            + "\n\n    Bladed Damage Res. ("+ pBladeRes +")"
            + "\n    Blunt Damage Res. ("+ pBluntRes +")"
            + "\n    Magic Res. ("+ pMagicRes +")"
            + "\n    Poison Res. ("+ pPoisonRes +")"
            + "\n    Fire Res. ("+ pFireRes +")"
            + "\n    Frost Res. ("+ pFrostRes +")"

            + "\n\n    Unarmed Damage ("+ pUnarmedDmg +")"
            + "\n    Bladed Damage ("+ pBladeDmg +")"
            + "\n    Blunt Damage ("+ pBluntDmg +")"
            + "\n    Heavy Weapons Damage ("+ pHeavyDmg +")"
            + "\n    Magic Damage ("+ pMagicDmg +")"
            + "\n    Long Range Damage ("+ pRangedDmg +")"
        );

        System.out.println(pStatsDisplay);
    }

    static void playerStatsInfo() {
        String pStatsInfo = "";
        pStatsInfo = (
            "\n\n   Level                   [Level determines the ammount of points you have to distribute]\n"
            + "\n   Health                  [Health is self explanitory. If it drops to 0 your character dies.]\n"
            + "\n   Inventory Space         [Inventory management is important in this game."
            + "\n                            Each armour piece, weapon, and quest item take up inventory space]\n"
            + "\n   Gold                    [Gold is the currency of Nordverden. It can be used to purchase items.]\n"
            + "\n   Luck                    [Luck increases your rolls by the ammount of Luck you have."
            + "\n                            Ex: Roll 9 + 2 Luck = Roll 11 (20 is the max roll)]\n"

            + "\n\n   Strenght                [Strength is determines how much damage you do.]\n"
            + "\n   Speech                  [Speech is used to convice people to do things you want.]\n"
            + "\n   Stamina                 [Stamina is very important in this game."
            + "\n                            It determines how many actions you can make per turn.]\n"
            + "\n   Sorcery                 [Sorcey determines which spells, and how many you can cast.]\n"
            + "\n   Sneak                   [Sneak is determines if you can get away with undesired actions.]\n"

            + "\n\n                           - - > A resistance value of 0 means it will do double damage < - -\n"
            + "\n   Bladed Damage Res.      [Blade Resistance lowers the damage you take from bladed weapons.]\n"
            + "\n   Blunt Damage Res.       [Blunt Resistance lowers the damage you take from blunt weapons.]\n"
            + "\n   Magic Res.              [Magic Resistance lowers the damage you take from magic.]\n"
            + "\n   Poison Res.             [Poison Resistance lowers your chance of being poisoned.]\n"
            + "\n   Fire Res.               [Fire Resistance lowers your chance of being set on fire.]\n"
            + "\n   Frost Res.              [Frost Resistance lowers your chance of getting hypothermia.]\n"

            + "\n\n                           - - > A damage value of 0 means you will do no damage < - -\n"
            + "\n   Unarmed Damage          [Unarmed damage increases the damage you do with unarmed weapons]\n"
            + "\n   Bladed Damage           [Bladed damage increases the damage you do with bladed weapons]\n"
            + "\n   Blunt Damage            [Blunt damage increases the damage you do with blunt weapons]\n"
            + "\n   Heavy Weapons Damage    [H.W. damage increases the damage you do with heavy weapons]\n"
            + "\n   Magic Damage            [Magic damage increases the damage you do with magic]\n"
            + "\n   Long Range Damage       [Unarmed damage increases the damage you do with ranged weapons]"
        );

        System.out.println(pStatsInfo);
        System.out.println("\n____________________________________________________________________________________________________\n");
    }

    // --->   Funtion that allows player to use the menu   <---
    static void openMenu() {
        System.out.println("\n    What would you like to do?\n"
            + "\n1. Open Inventory\n2. Use Item\n3. Sneak\n4. Combat\n5. Move\n"
        );

        playerSelection();
        switch (pSel) {
            case "1": showInventory(); break;
            case "2": useItem(); break;
            case "3": break;
            case "4": gotMad(); inCombat = true; combat(); break;
            case "5": pMover(pLocation); break;
            default: System.out.println("Thats not an option."); break;
        }
    }

// --->   End of Misc Methods   <---










// --->   Inventory Management System   <---

    // Variables for IMS
    static int pInvSpace = 5; // player inventory space
    static ArrayList<String> invItems = new ArrayList<>(); // items in inventory (array list needed)

    // Method that places items in the character's inventory
    static void placeInInv(String item) {
        System.out.println("\n    "+pName+" put the " + item + " in "+proPos+" inventory\n");
        if (invItems.size() < pInvSpace) {
            invItems.add(item);
            pInvSpace -= 1;
        } else {
            System.out.println("\n    Unfortunately you dropped the " + item + " and lost it");
        }

        item = "";
    }

    // Method that lets user use an item (pretty complicated ngl)
    static void useItem() {
        if (invItems.isEmpty()) { // Cancels useItem method if char's inv is empty
            System.out.println(pName + "'s inventory is empty.");
            return;
        }

        System.out.println("    Select an item to use:\n");
        for (int i = 0; i < invItems.size(); i++) { // runs until every item in inv is printed
            System.out.println((i + 1) +". " + invItems.get(i)); // prints out every item in inventory
        }


        int choice = 0; // doesnt use player selection because choice needs to be an int
        while (choice < 1 || choice > invItems.size()) { // runs until player selects an item
            System.out.print("Enter your choice (1-" + invItems.size() + "): ");
            if (input.hasNextInt()) { // validates user's input to ensure it can be used later
                choice = input.nextInt();
                if (choice < 1 || choice > invItems.size()) { // checks if its in the range of items
                    System.out.println("Invalid choice. Please try again.");
                }
            } else { // doesnt set choice if its not an integer
                System.out.println("That's not a valid number. Please try again.");
                input.next(); // Clear the invalid input
            }
        }

        String item = invItems.get(choice - 1); // sets item based on player's choice

        if (allWeapons.contains(item)){ // checks if the selected item is a weapon
            isWeapon(item);
        }
        // isArmour(item);
        // isPotion(item);
    }

    // Method that displays items in the character's inventory
    static void showInventory() {
        System.out.println("\n    Items: " + invItems);
        System.out.println("    Inventory Space: " + pInvSpace + "\n");
    }

    // Bakpacks
    static boolean backpackEquiped = false;
    static boolean bSmallBag = false; // +2 inventory
    static boolean bRugsack = false; // +4 inventory
    static boolean bJanksportBackpack = false; // +5 inventory
    static boolean bLargeBackpack = false; // +10 inventory
    static boolean bQuatumBag = false; // +95 inventory
    static boolean bBlackHole = false; // 0 inventory

    //Method that equips a backpack
    static void equipBackpack() {
        if (!backpackEquiped) {
            if (bSmallBag) {
                System.out.println("    " + pName + " has equipped a Small Bag\n");
                pInvSpace += 2;
            } else if (bRugsack) {
                System.out.println("   " + pName + " has equipped a Rugsack\n");
                pInvSpace += 4;
            } else if (bJanksportBackpack) {
                System.out.println("   " + pName + " has equipped a Janksport\n");
                pInvSpace += 5;
            } else if (bLargeBackpack) {
                System.out.println("   " + pName + " has equipped a Camping Bag\n");
                pInvSpace += 10;
            } else if (bQuatumBag) {
                System.out.println("   " + pName + " has equipped a QIIS MK1 Backpack\n");
                pInvSpace += 95;
            } else if (bBlackHole) {
                System.out.println("   " + pName + " has unfortunately equiped a Black Hole\n");
                pInvSpace = 0;
            }
            backpackEquiped = true;
        } else if (backpackEquiped) {
            System.out.println("    " + pName + " already has a backpack equipped.\n"
                + "    Would you like to uneqip it?"
            );
            System.out.println("1. Keep Current backpack.\n2. Unequip Backpack\n");

            playerSelection();
            switch (pSel) {
                case "1":
                    break;
                case "2": 
                    if (bSmallBag) {
                        System.out.println("    " + pName + " has unequiped the Small Bag");
                        pInvSpace -= 2;
                        bSmallBag = false;
                    } else if (bRugsack) {
                        System.out.println("   " + pName + " has unequiped the Rugsack");
                        pInvSpace -= 4;
                        bRugsack = false;
                    } else if (bJanksportBackpack) {
                        System.out.println("   " + pName + " has unequiped the Janksport\n");
                        pInvSpace -= 5;
                        bJanksportBackpack = false;
                    } else if (bLargeBackpack) {
                        System.out.println("   " + pName + " has unequiped the Camping Bag\n");
                        pInvSpace -= 10;
                        bLargeBackpack = false;
                    } else if (bQuatumBag) {
                        System.out.println("   " + pName + " has unequiped the QIIS MK1 Backpack\n");
                        pInvSpace -= 95;
                        bQuatumBag = false;
                    } 

                    backpackEquiped = false;
                    equipBackpack();
                    break;
                default:
                    System.out.println("cant do that");
                    equipBackpack();
                    break;
            }
        } else {
            System.out.println("Smt happened");
        }
    }

    // Damage resistance Armour
    static boolean armourEquipped = false;
    static boolean aLeather = false; // +0.5 bladed res
    static boolean aBarbarian = false; // +0.5 bladed res +0.5 blunt res
    static boolean aChainmail = false; // +1.0 bladed res
    static boolean aPlate = false; // +1.5 bladed res
    static boolean aKnight = false; // +2.0 bladed res +0.5 blunt res
    static boolean aRiot = false; // +2.0 blunt res +0.5 bladed res
    static boolean aBikini = false; // +1.0 bladed res +1.0 blunt res
    // Other Armours
    static boolean aMage = false; // +1.0 magic res
    static boolean aNecro = false; // +1.5 magic res
    static boolean aElven = false; // +2.0 magic res
    static boolean aHoodie = false; // +1.5 frost res
    static boolean aJorts = false; // +2.0 frost res
    static boolean aHazmat = false; // +5.0 poison res

    // Method that equips Armour
    static void equipArmour() {
        if (!armourEquipped) {
            if (aLeather) {
                System.out.println("    " + pName + " has equipped Leather Armour\n");
                pBladeRes += 0.5;
            } else if (aBarbarian) {
                System.out.println("   " + pName + " has equipped Barbarian Armour\n");

            } else if (aChainmail) {
                System.out.println("   " + pName + " has equipped Chainmail Armour\n");

            } else if (aPlate) {
                System.out.println("   " + pName + " has equipped Plate Armour\n");

            } else if (aKnight) {
                System.out.println("   " + pName + " has equipped a set of Knight Armour\n");

            } else if (aRiot) {
                System.out.println("   " + pName + " has equipped Riot Armour\n");

            } else if (aBikini) {
                System.out.println("   " + pName + " has equipped a Bikini?\n");

            } else if (aMage) {
                System.out.println("   " + pName + " has equipped Mage Robes\n");

            } else if (aNecro) {
                System.out.println("   " + pName + " has equipped Necromancer Robes\n");

            } else if (aElven) {
                System.out.println("   " + pName + " has equipped Elven Armour\n");

            } else if (aHoodie) {
                System.out.println("   " + pName + " has equipped a Hoodie\n");

            } else if (aJorts) {
                System.out.println("   " + pName + " has equipped a T-Shirt and Jorts\n");

            } else if (aHazmat) {
                System.out.println("   " + pName + " has equipped a Hazmat Suit\n");

            }
            armourEquipped = true;
        } else if (armourEquipped) {
            System.out.println("    " + pName + " already has armour equipped.\n"
                + "    Would you like to uneqip it?"
            );
            System.out.println("1. Keep Current Armour.\n2. Unequip Armour\n");

            playerSelection();
            switch (pSel) {
                case "1":
                    break;
                case "2": 
                    if (aLeather) {
                        System.out.println("    " + pName + " has unequiped Leather Armour\n");
                        pBladeRes -= 0.5;
                    } else if (aBarbarian) {
                        System.out.println("   " + pName + " has unequiped Barbarian Armour\n");
        
                    } else if (aChainmail) {
                        System.out.println("   " + pName + " has unequiped Chainmail Armour\n");
        
                    } else if (aPlate) {
                        System.out.println("   " + pName + " has unequiped Plate Armour\n");
        
                    } else if (aKnight) {
                        System.out.println("   " + pName + " has unequiped a set of Knight Armour\n");
        
                    } else if (aRiot) {
                        System.out.println("   " + pName + " has unequiped Riot Armour\n");
        
                    } else if (aBikini) {
                        System.out.println("   " + pName + " has unequiped the Bikini\n");
        
                    } else if (aMage) {
                        System.out.println("   " + pName + " has unequiped Mage Robes\n");
        
                    } else if (aNecro) {
                        System.out.println("   " + pName + " has unequiped Necromancer Robes\n");
        
                    } else if (aElven) {
                        System.out.println("   " + pName + " has unequiped Elven Armour\n");
        
                    } else if (aHoodie) {
                        System.out.println("   " + pName + " has unequiped the Hoodie\n");
        
                    } else if (aJorts) {
                        System.out.println("   " + pName + " has unequiped T-Shirt and Jorts\n");
        
                    } else if (aHazmat) {
                        System.out.println("   " + pName + " has unequiped the Hazmat Suit\n");
        
                    }

                    armourEquipped = false;
                    equipArmour();
                    break;
                default:
                    System.out.println("error: nah");
                    equipArmour();
                    break;
            }
        } else {
            System.out.println("Smt happened");
        }
    }

// --->   End of IMS   <---










// --->   Character Creator   <---

    static String pName = "";
    static String proSub = "";
    static String proObj = "";
    static String proPos = "";
    static String pRace = "";
    static String pClass = "";
    static String pLocation = "";


    static int pLives = 1; // ammount of lives the character has
    static int pLevel = 1; //character's level. +10 skill pointsMax lvl 46 (lvl 5 = 1000 total xp needed)
    static int pCurXp = 0; // current expirience points
    static int pNextLvl = (10*(pLevel*pLevel) + 90); // ammount of xp needed to level up
    static int pHealth = 100; // character's health
    static int pMaxHealth = 100;

    // char's reputation
    static int pKarma = 0; // (-10< [Bounty Hunters], <10[Mercenaries])
    // -10[kill on sight] < -5[locks quests] < 0[neutral] < 5[Allied] < 10[Special access]
    static int verdRep = 0;
    static int empiRep = 0;
    static int nekoRep = 0;
    static int wElfRep = 0;
    static int dElfRep = 0;

    static boolean tutComplete = false;
    static boolean pRaceSet = false; // var for if the player set their character's race
    static boolean pClassSet = false; // var for if the player set their character's class
    static boolean karmaSet = false; // var for if the player set their character's karma
    static boolean pStartEquip = false; // var for if the player choose their starting equipment
    static boolean pStartLocation = false;

    // boolean variables for each race
    static boolean pVerdian = false;
    static boolean pEmpirian = false;
    static boolean pOrc = false;
    static boolean pDarkElf = false;
    static boolean pWoodElf = false;
    static boolean pNekohito = false;
    static boolean pDragonborn = false;
    static boolean pNekoPassport = false;
    static boolean pForrestKey = false;

    static int pGold = 5; // Nordverden currency
    static int pCoins = 0; // Empirian currency
    static int pSchmeeps = 0; // Nekohito currency
    static int goldToConvert = 0; // ammount of gold to convert
    static int coinsToConvert = 0; // ammount of coins to convert
    static int schmeepsToConvert = 0; // ammount of schmeeps to convert
    static int goldToCoin = 0; // (goldToConvert*10) calculation for gold to coin conversion
    static int cointToGold = 0; // (coinsToConvert/8) calculation for coin to gold conversion
    static int goldToSchmeep = 0; // (goldToConvert*100) calculation for gold to schmeep conversion
    static int schmeepToGold = 0; // (schmeepsToConvert/100) calculation for schmeep to gold conversion

    static int pLuck = 0; // luck variable (adds to all rolls)
    static boolean conFinalStats = false; // confirms all stats

    static int skillPts = 50; // total unspent skill points
    static int assSkiPts = 0; // skill points player wants to assign
    static boolean conSkills = false; // confirms player's skill choices
    static double resistPts = 3.0; // total unspent resistance points
    static double assResPts = 0.0; // resistance points the player wants to assign
    static boolean conResists = false; // confirms the player's resistances 
    static double damagePts = 2.0; // tatal unspent damage points
    static double assDmgPts = 0.0; // damage points the player wants to assign
    static boolean conDamage = false; // confirms the player's damage

    // Method that initializes the character creator
    static void characterSelection() {
        System.out.println("\n    Would you like to create a custom character or choose a premade character?\n"
            + "\n1. Create a Custom Character\n2. Use the default stats\n3. View info on stats\n"
        );

        playerSelection();
        switch (pSel) {
            case "1": customizeStats(); break;
            case "2": defaultStats(); break;
            case "3": playerStatsDisplay(); characterSelection(); break;
            default: System.out.println("That didn't work"); characterSelection();
        }
    }

    // Method that sets the default stats
    static void defaultStats() {
        pStrenght = 10;
        pSpeech = 10;
        pStamina = 30;
        skillPts = 0;
        conSkills = true;
        pBladeRes = 1.0;
        pBluntRes = 1.0;
        pMagicRes = 0.25;
        pPoisonRes = 0.25;
        pFireRes = 0.25;
        pFrostRes = 0.25;
        resistPts = 0;
        conResists = true;
        pBladeDmg = 1.0;
        pBluntDmg = 1.0;
        damagePts = 0;
        conDamage = true;
        customizeStats();
    }

    // Method that modifies the character's stats   <<----- Very Important for character creator
    static void customizeStats() {
        assSkiPts = 0;

        // creates the character's name
        if (pName.equals("")) {
            System.out.println("\n    Character Creator Initialized\n"
                + "\n____________________________________________________________________________________________________\n"
            );
            System.out.println("    What is your character's name?\n");

            playerSelection();
            pName = pSel;

            System.out.println("\n    " + pName + " is your character's name.\n"
                + "\n1. Confirm name\n2. Change name\n"
            
            );
            
            playerSelection();
            switch(pSel) {
                case "2": pName = ""; customizeStats(); break;
                case "1": break;
                default: System.out.println("\n       No\n"); pName = ""; customizeStats();
            }
        }
        // creates the characte's pronouns
        if (proSub.equals("")) {
            System.out.println("\n    Which pronouns does your character go by?\n"
                + "\n1. He/Him/His\n2. She/Her/Her\n3. They/Them/Their\n4. Just use name\n"
            );

            playerSelection();
            switch(pSel) {
                case "1": proSub = "he"; proObj = "him"; proPos = "his"; break;
                case "2": proSub = "she"; proObj = "her"; proPos = "her"; break;
                case "3": proSub = "they"; proObj = "them"; proPos = "their"; break;
                case "4": proSub = pName; proObj = pName; proPos = (pName + "'s"); break;
                default: System.out.println("\n       Sorry that won't work\n"); customizeStats();
            }

            System.out.println("\n    This is an example of your selection:\n\n");
            System.out.println("    The tavern was lively until " + proSub 
                + " walked in and pulled out " + proPos + " sword."
                +"\n    Everyone was terrified of " + proObj + ".\n"
            );

            System.out.println("\n____________________________________________________________________________________________________\n");
        }

        // confirms the character's skills
        if ((skillPts == 0) && (!conSkills)){
            System.out.println("\n____________________________________________________________________________________________________\n");
            System.out.println("\n    You have run out of skill points.\n");
            System.out.println("\n    Your skills are:"
                + "\n\n    Strenght ("+ pStrenght +"/100)"
                + "\n    Speech ("+ pSpeech +"/100)"
                + "\n    Stamina ("+ pStamina +"/100)"
                + "\n    Sorcery ("+ pSorcery +"/100)"
                + "\n    Sneak ("+ pSneak +"/100)\n"
            );
            System.out.println("\n    Are you happy with these or would you like to reset your skills?\n"
                + "\n1. Confirm\n2. Reset\n"
            );

            playerSelection();
            switch (pSel) {
                case "2": resetSkills();
                    System.out.println("\n____________________________________________________________________________________________________\n");
                    break;
                case "1": conSkills = true;
                    System.out.println("\n____________________________________________________________________________________________________\n");
                    break;
                default: System.out.println("\n        Nope"); customizeStats();
            }
        }
        // confirms the character's resitances
        if ((resistPts == 0) && (!conResists)){
            System.out.println("\n____________________________________________________________________________________________________\n");
            System.out.println("\n    You have run out of resistance points.\n");
            System.out.println("\n    Your resistances are:"
                + "\n\n    Bladed Damage Resistance ("+ pBladeRes + ")"
                + "\n    Blunt Damage Resistance ("+ pBluntRes + ")"
                + "\n    Magic Resistance ("+ pMagicRes + ")"
                + "\n    Poison Resistance ("+ pPoisonRes + ")"
                + "\n    Fire Resistance ("+ pFireRes + ")"
                + "\n    Frost Resistance ("+ pFrostRes + ")"
            );
            System.out.println("\n    Are you happy with these or would you like to reset your resistances?\n"
                + "\n1. Confirm\n2. Reset\n"
            );

            playerSelection();
            switch (pSel) {
                case "2": resetResists(); break;
                case "1": conResists = true; break;
                default: System.out.println("\n        Nope"); customizeStats();
            }
        }
        // Confirms the character's damage multipliers
        if ((damagePts == 0) && (!conDamage)){
            System.out.println("\n____________________________________________________________________________________________________\n");
            System.out.println("\n    You have run out of damage points.\n");
            System.out.println("\n    Your damage multipliers are:"
                + "\n\n    Unarmed Damage ("+ pUnarmedDmg + ")"
                + "\n    Bladed Damage ("+ pBladeDmg + ")"
                + "\n    Blunt Damage ("+ pBluntDmg + ")"
                + "\n    Heavy Weapons ("+ pHeavyDmg + ")"
                + "\n    Magic Damage ("+ pMagicDmg + ")"
                + "\n    Ranged Damage ("+ pRangedDmg + ")"   
            );
            System.out.println("\n    Are you happy with these or would you like to reset your dmg multipliers?\n"
                + "\n1. Confirm\n2. Reset\n"
            );

            playerSelection();
            switch (pSel) {
                case "2": resetDmgMults(); break;
                case "1": conDamage = true; break;
                default: System.out.println("\n        Nope"); customizeStats();
            }
        }

        // starts the stat modification process
        if (!conFinalStats) {
            // starts the skill point distribution chain
            if (skillPts > 0) {
                System.out.println("\n    You have " + skillPts + " skill points to spend.");
                System.out.println("    Which Skill would you like to modify?"
                    + "\n\n1. Strenght ("+ pStrenght +"/100)"
                    + "\n2. Speech ("+ pSpeech +"/100)"
                    + "\n3. Stamina ("+ pStamina +"/100)"
                    + "\n4. Sorcery ("+ pSorcery +"/100)"
                    + "\n5. Sneak ("+ pSneak +"/100)"
                    + "\n6. Reset Skills\n"
                );

                playerSelection();
                switch(pSel) {
                    case "1": assignStrPts(); break;
                    case "2": assignSpePts(); break;
                    case "3": assignStaPts(); break;
                    case "4": assignSorPts(); break;
                    case "5": assignSnePts(); break;
                    case "6": resetSkills(); break;
                    default: System.out.println("\n         Are 5 buttons too much for you?\n"); customizeStats();
                }
            // starts the resistances point distribution chain
            } else if (resistPts > 0) {
                System.out.println("\n    You have " + resistPts + " resistance points to spend.");
                System.out.println("    Which damage resistance would you like to modify?"
                    + "\n\n1. Bladed Damage Res. ("+ pBladeRes +")"
                    + "\n2. Blunt Damage Res. ("+ pBluntRes +")"
                    + "\n3. Magic Res. ("+ pMagicRes +")"
                    + "\n4. Poison Res. ("+ pPoisonRes +")"
                    + "\n5. Fire Res. ("+ pFireRes +")"
                    + "\n6. Frost Res. ("+ pFrostRes +")"
                    + "\n7. Reset Resistances\n"
                );

                playerSelection();
                switch(pSel) {
                    case "1": assBladedResPts(); break;
                    case "2": assBluntResPts(); break;
                    case "3": assMagicResPts(); break;
                    case "4": assPoisonResPts(); break;
                    case "5": assFireResPts(); break;
                    case "6": assFrostResPts(); break;
                    case "7": resetResists(); break;
                    default: System.out.println("\n         not gonna do that\n"); customizeStats();
                }
            // starts the damage multiplier point distribution chain
            } else if (damagePts > 0) {
                System.out.println("\n    You have " + damagePts + " damage points to spend.");
                System.out.println("    Which damage multiplier would you like to modify?"
                    + "\n\n1. Unarmed Damage ("+ pUnarmedDmg +")"
                    + "\n2. Bladed Damage ("+ pBladeDmg +")"
                    + "\n3. Blunt Damage ("+ pBluntDmg +")"
                    + "\n4. Heavy Weapons ("+ pHeavyDmg +")"
                    + "\n5. Magic Damage ("+ pMagicDmg +")"
                    + "\n6. Ranged Damage ("+ pRangedDmg +")"
                    + "\n7. Reset Damage Multipliers\n"
                );

                playerSelection();
                switch(pSel) {
                    case "1": assUnarmedDmgPts(); break;
                    case "2": assBladedDmgPts(); break;
                    case "3": assBluntDmgPts(); break;
                    case "4": assHeavyDmgPts(); break;
                    case "5": assMagicDmgPts(); break;
                    case "6": assRangedDmgPts(); break;
                    case "7": resetDmgMults(); break;
                    default: System.out.println("\n         cannot do that for some reason\n"); customizeStats();
                }
            // confirms the player's final stats
            } else if (conSkills && conResists && conDamage) {
                System.out.println("\n    You have finished setting your character's stats."
                    + "\n    These are your finalized character stats:\n"

                    + "\n    Your skills are:"
                    + "\n    Strenght ("+ pStrenght +"/100)"
                    + "\n    Speech ("+ pSpeech +"/100)"
                    + "\n    Stamina ("+ pStamina +"/100)"
                    + "\n    Sorcery ("+ pSorcery +"/100)"
                    + "\n    Sneak ("+ pSneak +"/100)\n"

                    + "\n    Your resistances are:"
                    + "\n    Bladed Damage Resistance ("+ pBladeRes + ")"
                    + "\n    Blunt Damage Resistance ("+ pBluntRes + ")"
                    + "\n    Magic Resistance ("+ pMagicRes + ")"
                    + "\n    Poison Resistance ("+ pPoisonRes + ")"
                    + "\n    Fire Resistance ("+ pFireRes + ")"
                    + "\n    Frost Resistance ("+ pFrostRes + ")\n"

                    + "\n    Your damage multipliers are:"
                    + "\n    Unarmed Damage ("+ pUnarmedDmg + ")"
                    + "\n    Bladed Damage ("+ pBladeDmg + ")"
                    + "\n    Blunt Damage ("+ pBluntDmg + ")"
                    + "\n    Heavy Weapons ("+ pHeavyDmg + ")"
                    + "\n    Magic Damage ("+ pMagicDmg + ")"
                    + "\n    Ranged Damage ("+ pRangedDmg + ")\n" 
                );
                System.out.println("\n    Are you happy with these or do you want to reset them?"
                    + "\n    WARNING: You will not be able to reset your stats for a while.\n"
                    + "\n1. Confirm Final Stats\n2. Reset Stats\n"
                );

                playerSelection();
                switch (pSel) {
                    case "2":
                        resetAllStats();
                        break;
                    case "1":
                        System.out.println("\n    Your final stats are now:"); playerStatsDisplay(); conFinalStats = true;
                    default:
                        break;
                }

            }
        }

        // lets player choose their character's class
        if (!pClassSet){
            charClassSel();
        }

        // lets the player choose their character's race
        if (!pRaceSet) {
            charRaceSel();
        }

        // lets the player choose their character's karma
        if (!karmaSet) {
            startingKarma();
        }

        // lets the player choose their starting equipment
        if (!pStartEquip) {
            startingEquipment();
        }

        // Asks the player if they want to do the tutorial
        if (conFinalStats && pClassSet && pRaceSet && karmaSet && pStartEquip && !tutComplete) {
            System.out.println("\n____________________________________________________________________________________________________\n");
            System.out.println("    You have finished making your character!");
            System.out.println("    Would you like to do the tutorial?\n");
            System.out.println("1. Do the tutorial\n2. Choose an alternate start\n");

            playerSelection();
            switch (pSel) {
                case "1": empirianPrisoner(); break;
                case "2": break;
                default: System.out.println("stop"); customizeStats();
            }
        }

        // lets the player choose their starting location
        if (!pStartLocation) {
            startingLocation();
        }
    }

    // Methods for if the player runs out of points
    static void ranOuttaSkiPts() {
        System.out.println("\n    You have run out of skill points to spend"
            + "\n   You can either confirm your stats or reset your skills\n"
            + "\n1. Continue Modifying"
            + "\n2. Reset Skills"
        );

        playerSelection();
        switch(pSel) {
            case "2": resetSkills(); break;
            case "1": customizeStats(); break;
            default: System.out.println("\n         huh\n"); ranOuttaSkiPts();
        }
    }
    static void ranOuttaResPts() {
        System.out.println("\n    You have run out of resitance points to spend"
            + "\n   You can either confirm your stats or reset your resistances\n"
            + "\n1. Continue Modifying"
            + "\n2. Reset Resistances"
        );

        playerSelection();
        switch(pSel) {
            case "2": resetResists(); break;
            case "1": customizeStats(); break;
            default: System.out.println("\n         huh\n"); ranOuttaResPts();
        }
    }
    static void ranOuttaDmgPts() {
        System.out.println("\n    You have run out of damage points to spend"
            + "\n   You can either confirm your stats or reset your dmg multipliers\n"
            + "\n1. Continue Modifying"
            + "\n2. Reset Damage Multipliers"
        );

        playerSelection();
        switch(pSel) {
            case "2": resetDmgMults(); break;
            case "1": customizeStats(); break;
            default: System.out.println("\n         huh\n"); ranOuttaDmgPts();
        }
    }

    // player character's skills
    static int pStrenght = 0;
    static int pSpeech = 0;
    static int pStamina = 0;
    static int pSorcery = 0;
    static int pSneak = 0;

    // Methods for assigning points to skills
    static void assignStrPts() {
        assSkiPts = 0;
        System.out.println("\n    How many points would you like to assign to Strenght\n");
        assSkiPts = input.nextInt();

        if (assSkiPts > skillPts) {
            if (skillPts == 0) {
                ranOuttaSkiPts();
            }

            System.out.println("\n    You cannot assign " + assSkiPts + " points to Strenght."
                +"\n    You have " + skillPts + " skill points available."
            );
            assignStrPts();

        } else if (assSkiPts < 0) {
            System.out.println("\n    You cannot assign negative points."
                +"\n    If you would like to reset your points you can do that later."
            );
            assignStrPts();

        }else if (skillPts >= 0){
            skillPts -= assSkiPts;
            pStrenght += assSkiPts;
            assSkiPts = 0;
            System.out.println("\n    Your Strenght is now at "+ pStrenght);
            System.out.println("    You have " + skillPts + " skill points available.\n");
            System.out.println("\n____________________________________________________________________________________________________\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        customizeStats();
    }
    static void assignSpePts() {
        assSkiPts = 0;
        System.out.println("\n    How many points would you like to assign to Speech\n");
        assSkiPts = input.nextInt();

        if (assSkiPts > skillPts) {
            if (skillPts == 0) {
                ranOuttaSkiPts();
            }

            System.out.println("\n    You cannot assign " + assSkiPts + " points to Speech."
                +"\n    You have " + skillPts + " skill points available."
            );
            assignSpePts();

        } else if (assSkiPts < 0) {
            System.out.println("\n    You cannot assign negative points."
                +"\n    If you would like to reset your points you can do that later."
            );
            assignSpePts();

        }else if (skillPts >= 0){
            skillPts -= assSkiPts;
            pSpeech += assSkiPts;
            assSkiPts = 0;
            System.out.println("\n    Your Speech is now at "+ pSpeech);
            System.out.println("    You have " + skillPts + " skill points available.\n");
            System.out.println("\n____________________________________________________________________________________________________\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        customizeStats();
    }
    static void assignStaPts() {
        assSkiPts = 0;
        System.out.println("\n    How many points would you like to assign to Stamina\n");
        assSkiPts = input.nextInt();

        if (assSkiPts > skillPts) {
            if (skillPts == 0) {
                ranOuttaSkiPts();
            }

            System.out.println("\n    You cannot assign " + assSkiPts + " points to Stamina."
                +"\n    You have " + skillPts + " skill points available."
            );
            assignStaPts();

        } else if (assSkiPts < 0) {
            System.out.println("\n    You cannot assign negative points."
                +"\n    If you would like to reset your points you can do that later."
            );
            assignStaPts();

        }else if (skillPts >= 0){
            skillPts -= assSkiPts;
            pStamina += assSkiPts;
            assSkiPts = 0;
            System.out.println("\n    Your Stamina is now at "+ pStamina);
            System.out.println("    You have " + skillPts + " skill points available.\n");
            System.out.println("\n____________________________________________________________________________________________________\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        customizeStats();
    }
    static void assignSorPts() {
        assSkiPts = 0;
        System.out.println("\n    How many points would you like to assign to Sorcery\n");
        assSkiPts = input.nextInt();

        if (assSkiPts > skillPts) {
            if (skillPts == 0) {
                ranOuttaSkiPts();
            }

            System.out.println("\n    You cannot assign " + assSkiPts + " points to Sorcery."
                +"\n    You have " + skillPts + " skill points available."
            );
            assignSorPts();

        } else if (assSkiPts < 0) {
            System.out.println("\n    You cannot assign negative points."
                +"\n    If you would like to reset your points you can do that later."
            );
            assignSorPts();

        }else if (skillPts >= 0){
            skillPts -= assSkiPts;
            pSorcery += assSkiPts;
            assSkiPts = 0;
            System.out.println("\n    Your Sorcery is now at "+ pSorcery);
            System.out.println("    You have " + skillPts + " skill points available.\n");
            System.out.println("\n____________________________________________________________________________________________________\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        customizeStats();
    }
    static void assignSnePts() {
        assSkiPts = 0;
        System.out.println("\n    How many points would you like to assign to Sneak\n");
        assSkiPts = input.nextInt();

        if (assSkiPts > skillPts) {
            if (skillPts == 0) {
                ranOuttaSkiPts();
            }

            System.out.println("\n    You cannot assign " + assSkiPts + " points to Sneak."
                +"\n    You have " + skillPts + " skill points available."
            );
            assignSnePts();

        } else if (assSkiPts < 0) {
            System.out.println("\n    You cannot assign negative points."
                +"\n    If you would like to reset your points you can do that later."
            );
            assignSnePts();

        }else if (skillPts >= 0){
            skillPts -= assSkiPts;
            pSneak += assSkiPts;
            assSkiPts = 0;
            System.out.println("\n    Your Sneak is now at "+ pSneak);
            System.out.println("    You have " + skillPts + " skill points available.\n");
            System.out.println("\n____________________________________________________________________________________________________\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        customizeStats();
    }

    // player character's damage resistance
    static double pBladeRes = 0.0;
    static double pBluntRes = 0.0;
    static double pMagicRes = 0.0;
    static double pPoisonRes = 0.0;
    static double pFireRes = 0.0;
    static double pFrostRes = 0.0;

    // Methods for assigning points to resistances
    static void assBladedResPts() {
        assResPts = 0;
        System.out.println("\n    How many points would you like to assign to Bladed Damage Resistance\n");
        assResPts = input.nextDouble();

        if (assResPts > resistPts) {
            if (resistPts == 0) {
                ranOuttaResPts();
            }

            System.out.println("\n    You cannot assign " + assResPts + " points to Bladed Dmg. Res."
                + "\n    You have " + resistPts + " resistance points available."
            );
            assBladedResPts();

        } else if (assResPts < 0) {
            System.out.println("\n    You cannot assign negative points."
                + "\n    If you would like to reset your points you can do that later."
            );
            assBladedResPts();

        }else if (resistPts >= 0){
            resistPts -= assResPts;
            pBladeRes += assResPts;
            assResPts = 0;
            System.out.println("\n    Your Bladed Damage Resistance is now at "+ pBladeRes);
            System.out.println("    You have " + resistPts + " resistance points available.\n");
            System.out.println("\n____________________________________________________________________________________________________\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        customizeStats();
    }
    static void assBluntResPts() {
        assResPts = 0;
        System.out.println("\n    How many points would you like to assign to Blunt Damage Resistance\n");
        assResPts = input.nextDouble();

        if (assResPts > resistPts) {
            if (resistPts == 0) {
                ranOuttaResPts();
            }

            System.out.println("\n    You cannot assign " + assResPts + " points to Blunt Dmg. Res."
                + "\n    You have " + resistPts + " resistance points available."
            );
            assBluntResPts();

        } else if (assResPts < 0) {
            System.out.println("\n    You cannot assign negative points."
                + "\n    If you would like to reset your points you can do that later."
            );
            assBluntResPts();

        }else if (resistPts >= 0){
            resistPts -= assResPts;
            pBluntRes += assResPts;
            assResPts = 0;
            System.out.println("\n    Your Blunt Damage Resistance is now at "+ pBluntRes);
            System.out.println("    You have " + resistPts + " resistance points available.\n");
            System.out.println("\n____________________________________________________________________________________________________\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        customizeStats();
    }
    static void assMagicResPts() {
        assResPts = 0;
        System.out.println("\n    How many points would you like to assign to Magic Damage Resistance\n");
        assResPts = input.nextDouble();

        if (assResPts > resistPts) {
            if (resistPts == 0) {
                ranOuttaResPts();
            }

            System.out.println("\n    You cannot assign " + assResPts + " points to Magic Dmg. Res."
                + "\n    You have " + resistPts + " resistance points available."
            );
            assMagicResPts();

        } else if (assResPts < 0) {
            System.out.println("\n    You cannot assign negative points."
                + "\n    If you would like to reset your points you can do that later."
            );
            assMagicResPts();

        }else if (resistPts >= 0){
            resistPts -= assResPts;
            pMagicRes += assResPts;
            assResPts = 0;
            System.out.println("\n    Your Magic Damage Resistance is now at "+ pMagicRes);
            System.out.println("    You have " + resistPts + " resistance points available.\n");
            System.out.println("\n____________________________________________________________________________________________________\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        customizeStats();
    }
    static void assPoisonResPts() {
        assResPts = 0;
        System.out.println("\n    How many points would you like to assign to Poison Damage Resistance\n");
        assResPts = input.nextDouble();

        if (assResPts > resistPts) {
            if (resistPts == 0) {
                ranOuttaResPts();
            }

            System.out.println("\n    You cannot assign " + assResPts + " points to Poison Dmg. Res."
                + "\n    You have " + resistPts + " resistance points available."
            );
            assPoisonResPts();

        } else if (assResPts < 0) {
            System.out.println("\n    You cannot assign negative points."
                + "\n    If you would like to reset your points you can do that later."
            );
            assPoisonResPts();

        }else if (resistPts >= 0){
            resistPts -= assResPts;
            pPoisonRes += assResPts;
            assResPts = 0;
            System.out.println("\n    Your Poison Damage Resistance is now at "+ pPoisonRes);
            System.out.println("    You have " + resistPts + " resistance points available.\n");
            System.out.println("\n____________________________________________________________________________________________________\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        customizeStats();
    }
    static void assFireResPts() {
        assResPts = 0;
        System.out.println("\n    How many points would you like to assign to Fire Damage Resistance\n");
        assResPts = input.nextDouble();

        if (assResPts > resistPts) {
            if (resistPts == 0) {
                ranOuttaResPts();
            }

            System.out.println("\n    You cannot assign " + assResPts + " points to Fire Dmg. Res."
                + "\n    You have " + resistPts + " resistance points available."
            );
            assFireResPts();

        } else if (assResPts < 0) {
            System.out.println("\n    You cannot assign negative points."
                + "\n    If you would like to reset your points you can do that later."
            );
            assFireResPts();

        }else if (resistPts >= 0){
            resistPts -= assResPts;
            pFireRes += assResPts;
            assResPts = 0;
            System.out.println("\n    Your Fire Damage Resistance is now at "+ pFireRes);
            System.out.println("    You have " + resistPts + " resistance points available.\n");
            System.out.println("\n____________________________________________________________________________________________________\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        customizeStats();
    }
    static void assFrostResPts() {
        assResPts = 0;
        System.out.println("\n    How many points would you like to assign to Frost Damage Resistance\n");
        assResPts = input.nextDouble();

        if (assResPts > resistPts) {
            if (resistPts == 0) {
                ranOuttaResPts();
            }

            System.out.println("\n    You cannot assign " + assResPts + " points to Frost Dmg. Res."
                + "\n    You have " + resistPts + " resistance points available."
            );
            assFrostResPts();

        } else if (assResPts < 0) {
            System.out.println("\n    You cannot assign negative points."
                + "\n    If you would like to reset your points you can do that later."
            );
            assFrostResPts();

        }else if (resistPts >= 0){
            resistPts -= assResPts;
            pFrostRes += assResPts;
            assResPts = 0;
            System.out.println("\n    Your Frost Damage Resistance is now at "+ pFrostRes);
            System.out.println("    You have " + resistPts + " resistance points available.\n");
            System.out.println("\n____________________________________________________________________________________________________\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        customizeStats();
    }

    // player character's damage multipliers
    static double pUnarmedDmg = 0.0;
    static double pBladeDmg = 0.0;
    static double pBluntDmg = 0.0;
    static double pHeavyDmg = 0.0;
    static double pMagicDmg = 0.0;
    static double pRangedDmg = 0.0;

    // Methods for assigning points to damage mults.
    static void assUnarmedDmgPts() {
        assDmgPts = 0;
        System.out.println("\n    How many points would you like to assign to Unarmed Damage\n");
        assDmgPts = input.nextDouble();

        if (assDmgPts > damagePts) {
            if (damagePts == 0) {
                ranOuttaDmgPts();
            }

            System.out.println("\n    You cannot assign " + assDmgPts + " points to Unarmed Damage"
                + "\n    You have " + damagePts + " damage points available."
            );
            assUnarmedDmgPts();

        } else if (assDmgPts < 0) {
            System.out.println("\n    You cannot assign negative points."
                + "\n    If you would like to reset your points you can do that later."
            );
            assUnarmedDmgPts();

        }else if (damagePts >= 0){
            damagePts -= assDmgPts;
            pUnarmedDmg += assDmgPts;
            assDmgPts = 0;
            System.out.println("\n    Your Unarmed Damage Multiplier is now at "+ pUnarmedDmg);
            System.out.println("    You have " + damagePts + " damage points available.\n");
            System.out.println("\n____________________________________________________________________________________________________\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        customizeStats();
    }
    static void assBladedDmgPts() {
        assDmgPts = 0;
        System.out.println("\n    How many points would you like to assign to Bladed Damage\n");
        assDmgPts = input.nextDouble();

        if (assDmgPts > damagePts) {
            if (damagePts == 0) {
                ranOuttaDmgPts();
            }

            System.out.println("\n    You cannot assign " + assDmgPts + " points to Bladed Damage"
                + "\n    You have " + damagePts + " damage points available."
            );
            assBladedDmgPts();

        } else if (assDmgPts < 0) {
            System.out.println("\n    You cannot assign negative points."
                + "\n    If you would like to reset your points you can do that later."
            );
            assBladedDmgPts();

        }else if (damagePts >= 0){
            damagePts -= assDmgPts;
            pBladeDmg += assDmgPts;
            assDmgPts = 0;
            System.out.println("\n    Your Bladed Damage is now at "+ pBladeDmg);
            System.out.println("    You have " + damagePts + " damage points available.\n");
            System.out.println("\n____________________________________________________________________________________________________\n");

        } else {
            System.out.println("\n\n        What did you do?\n");
        }

        customizeStats();
    }
    static void assBluntDmgPts() {
        assDmgPts = 0;
        System.out.println("\n    How many points would you like to assign to Blunt Damage\n");
        assDmgPts = input.nextDouble();

        if (assDmgPts > damagePts) {
            if (damagePts == 0) {
                ranOuttaDmgPts();
            }

            System.out.println("\n    You cannot assign " + assDmgPts + " points to Dlunt Damage"
                + "\n    You have " + damagePts + " damage points available."
            );
            assBluntDmgPts();

        } else if (assDmgPts < 0) {
            System.out.println("\n    You cannot assign negative points."
                + "\n    If you would like to reset your points you can do that later."
            );
            assBluntDmgPts();

        }else if (damagePts >= 0){
            damagePts -= assDmgPts;
            pBluntDmg += assDmgPts;
            assDmgPts = 0;
            System.out.println("\n    Your Blunt Damage is now at "+ pBluntDmg);
            System.out.println("    You have " + damagePts + " damage points available.\n");
            System.out.println("\n____________________________________________________________________________________________________\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        customizeStats();
    }
    static void assHeavyDmgPts() {
        assDmgPts = 0;
        System.out.println("\n    How many points would you like to assign to Heavy Weapons Damage?\n");
        assDmgPts = input.nextDouble();

        if (assDmgPts > damagePts) {
            if (damagePts == 0) {
                ranOuttaDmgPts();
            }

            System.out.println("\n    You cannot assign " + assDmgPts + " points to Heavy Damage"
                + "\n    You have " + damagePts + " damage points available."
            );
            assHeavyDmgPts();

        } else if (assDmgPts < 0) {
            System.out.println("\n    You cannot assign negative points."
                + "\n    If you would like to reset your points you can do that later."
            );
            assHeavyDmgPts();

        }else if (damagePts >= 0){
            damagePts -= assDmgPts;
            pHeavyDmg += assDmgPts;
            assDmgPts = 0;
            System.out.println("\n    Your Heavy Weapons Damage is now at "+ pHeavyDmg);
            System.out.println("    You have " + damagePts + " damage points available.\n");
            System.out.println("\n____________________________________________________________________________________________________\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        customizeStats();
    }
    static void assMagicDmgPts() {
        assDmgPts = 0;
        System.out.println("\n    How many points would you like to assign to Magic Damage\n");
        assDmgPts = input.nextDouble();

        if (assDmgPts > damagePts) {
            if (damagePts == 0) {
                ranOuttaDmgPts();
            }

            System.out.println("\n    You cannot assign " + assDmgPts + " points to Magic Damage"
                + "\n    You have " + damagePts + " damage points available."
            );
            assMagicDmgPts();

        } else if (assDmgPts < 0) {
            System.out.println("\n    You cannot assign negative points."
                + "\n    If you would like to reset your points you can do that later."
            );
            assMagicDmgPts();

        }else if (damagePts >= 0){
            damagePts -= assDmgPts;
            pMagicDmg += assDmgPts;
            assDmgPts = 0;
            System.out.println("\n    Your Magic Damage is now at "+ pMagicDmg);
            System.out.println("    You have " + damagePts + " damage points available.\n");
            System.out.println("\n____________________________________________________________________________________________________\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        customizeStats();
    }
    static void assRangedDmgPts() {
        assDmgPts = 0;
        System.out.println("\n    How many points would you like to assign to Ranged Damage\n");
        assDmgPts = input.nextDouble();

        if (assDmgPts > damagePts) {
            if (damagePts == 0) {
                ranOuttaDmgPts();
            }

            System.out.println("\n    You cannot assign " + assDmgPts + " points to Ranged Damage"
                + "\n    You have " + damagePts + " damage points available."
            );
            assRangedDmgPts();

        } else if (assDmgPts < 0) {
            System.out.println("\n    You cannot assign negative points."
                + "\n    If you would like to reset your points you can do that later."
            );
            assRangedDmgPts();

        }else if (damagePts >= 0){
            damagePts -= assDmgPts;
            pRangedDmg += assDmgPts;
            assDmgPts = 0;
            System.out.println("\n    Your Ranged Damage is now at "+ pRangedDmg);
            System.out.println("    You have " + damagePts + " damage points available.\n");
            System.out.println("\n____________________________________________________________________________________________________\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        customizeStats();
    }

    // Methods that resets the character's stats
    static void resetSkills() {
        conSkills = false;
        System.out.println("\n    Are you sure you want to reset your skills?\n"
            + "\n1. Reset\n2. Continue Modifying\n3. View Stats\n"
        );

        playerSelection();
        switch (pSel) {
            case "1":
                skillPts = (pStrenght + pSpeech + pStamina + pSorcery + pSneak);
                pStrenght = 0;
                pSpeech = 0;
                pStamina = 0;
                pSorcery = 0;
                pSneak = 0;

                System.out.println("\n  Your skills have been reset. You now have " 
                    + skillPts 
                    + " skill points to assign.\n"
                );
            case "2": customizeStats(); break;
            case "3": playerStatsDisplay(); resetSkills(); break;
            default: System.out.println("\n         Nah"); resetSkills();
        }
    }
    static void resetResists() {
        conResists = false;
        System.out.println("\n    Are you sure you want to reset your resistances?\n"
            + "\n1. Reset\n2. Continue Modifying\n3. View Stats\n"
        );

        playerSelection();
        switch (pSel) {
            case "1":
                resistPts = (pBladeRes + pBluntRes + pMagicRes + pPoisonRes + pFireRes + pFrostRes);
                pBladeRes = 0;
                pBluntRes = 0;
                pMagicRes = 0;
                pPoisonRes = 0;
                pFireRes = 0;
                pFrostRes = 0;

                System.out.println("\n  Your resistances have been reset. You now have " 
                    + resistPts 
                    + " resistance points to assign.\n"
                );
            case "2": customizeStats(); break;
            case "3": playerStatsDisplay(); resetResists(); break;
            default: System.out.println("\n         cant do that"); resetSkills();
        }
    }
    static void resetDmgMults() {
        conDamage = false;
        System.out.println("\n    Are you sure you want to reset your damage multipliers?\n"
            + "\n1. Reset\n2. Continue Modifying\n3. View Stats Again\n"
        );

        playerSelection();
        switch (pSel) {
            case "1":
                damagePts = (pBladeDmg + pBluntDmg + pMagicDmg + pUnarmedDmg + pHeavyDmg + pRangedDmg);
                pBladeDmg = 0;
                pBluntDmg = 0;
                pMagicDmg = 0;
                pUnarmedDmg = 0;
                pHeavyDmg = 0;
                pRangedDmg = 0;

                System.out.println("\n  Your damage multipliers have been reset. You now have " 
                    + damagePts 
                    + " damage points to assign.\n"
                );
            case "2": customizeStats(); break;
            case "3": playerStatsDisplay(); resetResists(); break;
            default: System.out.println("\n         cant do that"); resetSkills();
        }
    }
    static void resetAllStats() {
        conSkills = false;
        conResists = false;
        conDamage = false;
        System.out.println("\n    Are you sure you want to reset all your stats?\n"
            + "    This action is not reversable!\n"
            + "\n1. View Stats\n2. Continue Modifying\n3. Reset all stats\n"
        );

        playerSelection();
        switch (pSel) {
            case "3":
                skillPts = (pStrenght + pSpeech + pStamina + pSorcery + pSneak);
                pStrenght = 0;
                pSpeech = 0;
                pStamina = 0;
                pSorcery = 0;
                pSneak = 0;

                resistPts = (pBladeRes + pBluntRes + pMagicRes + pPoisonRes + pFireRes + pFrostRes);
                pBladeRes = 0;
                pBluntRes = 0;
                pMagicRes = 0;
                pPoisonRes = 0;
                pFireRes = 0;
                pFrostRes = 0;

                damagePts = (pBladeDmg + pBluntDmg + pMagicDmg + pUnarmedDmg + pHeavyDmg + pRangedDmg);
                pBladeDmg = 0;
                pBluntDmg = 0;
                pMagicDmg = 0;
                pUnarmedDmg = 0;
                pHeavyDmg = 0;
                pRangedDmg = 0;

                System.out.println("\n  All of your character's stats have been reset. You now have:\n    " 
                    + skillPts 
                    + " skill points to assign.\n    "
                    + resistPts 
                    + " resistance points to assign.\n    "
                    + damagePts 
                    + " damage points to assign.\n"
                                    
                );
            case "2": customizeStats(); break;
            case "1": playerStatsDisplay(); resetSkills(); break;
            default: System.out.println("\n         Nah"); resetSkills();
        }
    }

    // Methods for choosing the character's race
    static void viewRaceInfo() {
        System.out.println("\n____________________________________________________________________________________________________\n");
        System.out.println("\n    These are all the races found in Nordverden:\n\n"
            + "\n    Verdian    - Natives of Nordverden. Warriors with a natural resistance to cold.\n"
            + "\n    Empirian   - Citizens of the Western Empire. A militaristic civilization hungry for resources.\n"
            + "\n    Orc        - Strong barbaric warriors that only communicate with grunts.\n"
            + "\n    Dark Elf   - Great magic casters but both elf races are weaker than other races.\n"
            + "\n    Wood Elf   - Worse magic casters than Dark Elves, but have a stronger community.\n"
            + "\n    Nekohito   - The peacful natives of Nekomura, a remote island to the east of Nordverden.\n"
            + "\n    Dragonborn - The rarest race in Nordverden, not much is known about them.\n"
        );
        System.out.println("\n____________________________________________________________________________________________________\n");
    }
    static void charRaceSel() {
        if (pRace.equals("")) {
            System.out.println("\n    Choose your character's Race\n"
                + "\n1. Verdian\n2. Empirian\n3. Orc\n4. Dark Elf\n5. Wood Elf\n6. Nekohito\n7. Dragonborn\n8. View Info on Races\n"
            );

            playerSelection();
            switch(pSel) {
                case "1": pRace = "Verdian"; charRaceSet(); break;
                case "2": pRace = "Empirian"; charRaceSet(); break;
                case "3": pRace = "Orc"; charRaceSet(); break;
                case "4": pRace = "Dark Elf"; charRaceSet(); break;
                case "5": pRace = "Wood Elf"; charRaceSet(); break;
                case "6": pRace = "Nekohito"; charRaceSet(); break;
                case "7": pRace = "Dragonborn"; charRaceSet(); break;
                case "8": viewRaceInfo(); charRaceSel(); break;
                default: System.out.println("\n        Try again"); charRaceSel();
            }
        } else {
            System.out.println("\n        No clue what you did\n");
        }
    }
    static void charRaceSet() {
        if (pRace.equals("Verdian")) {
            pFrostRes += 0.5;
            pStrenght += 10;
            pInvSpace += 1;
            pVerdian = true;
            System.out.println("\n    Your character is now a Verdian");
        } else if (pRace.equals("Empirian")) {
            pCoins += 100;
            pSpeech +=10;
            pStrenght += 10;
            pEmpirian = true;
            System.out.println("\n    Your character is now a Empirian");
        } else if (pRace.equals("Orc")) {
            pBladeRes += 0.5;
            pMagicRes += 0.5;
            pSpeech -= 50;
            pStrenght += 25;
            pOrc = true;
            System.out.println("\n    Your character is now a Orc");
        } else if (pRace.equals("Dark")) {
            pSorcery += 20;
            pFireRes += 0.25;
            pMagicRes += 0.5;
            pMaxHealth -= 30;
            pHealth -= 30;
            pDarkElf = true;
            System.out.println("\n    Your character is now a Dark Elf");
        } else if (pRace.equals("Wood")) {
            pSorcery += 10;
            pPoisonRes += 0.25;
            pSpeech += 10;
            pMaxHealth -= 30;
            pHealth -= 30;
            pWoodElf = true;
            System.out.println("\n    Your character is now a Wood Elf");
        } else if (pRace.equals("Nekohito")) {
            pSneak += 25;
            pStamina += 10;
            pSorcery += 5;
            pStrenght -= 15;
            pNekohito = true;
            pNekoPassport = true;
            System.out.println("\n    Your character is now a Nekohito");
        } else if (pRace.equals("Dragonborn")) {
            pDragonborn = true;
            System.out.println("\n    Your character is now a Dragonborn");
        } else {
            System.out.println("How did you do that?");
        }

        System.out.println("\n1. Confirm Race\n2. Reset Race\n");
        playerSelection();
        switch(pSel) {
            case "1": pRaceSet = true; customizeStats(); break;
            case "2": 
                if (pRace.equals("Verdian")) {
                    pFrostRes -= 0.5;
                    pStrenght -= 10;
                    pInvSpace -= 1;
                    pVerdian = false;
                } else if (pRace.equals("Empirian")) {
                    pCoins -= 100;
                    pSpeech -=10;
                    pStrenght -= 10;
                    pEmpirian = false;
                } else if (pRace.equals("Orc")) {
                    pBladeRes -= 0.5;
                    pMagicRes -= 0.5;
                    pSpeech += 50;
                    pStrenght -= 25;
                    pOrc = false;
                } else if (pRace.equals("Dark")) {
                    pSorcery -= 20;
                    pFireRes -= 0.25;
                    pMagicRes -= 0.5;
                    pMaxHealth += 30;
                    pHealth += 30;
                    pDarkElf = false;
                } else if (pRace.equals("Wood")) {
                    pSorcery -= 10;
                    pPoisonRes -= 0.25;
                    pSpeech -= 10;
                    pMaxHealth += 30;
                    pHealth += 30;
                    pWoodElf = false;
                } else if (pRace.equals("Nekohito")) {
                    pSneak -= 25;
                    pStamina -= 10;
                    pSorcery -= 5;
                    pStrenght += 15;
                    pNekohito = false;
                } else if (pRace.equals("Dragonborn")) {
                    pDragonborn = false;
                } else {
                    System.out.println("How did you do that?");
                }

                pRace = "";
                pRaceSet = false;
                charRaceSel();
                break;
            default: System.out.println("Nuh uh"); charRaceSet();
        }
    }

    // Methods for choosing the character's class
    static void viewClassInfo() {
        System.out.println("\n____________________________________________________________________________________________________\n");
        System.out.println("\n    These are all the classes you can choose:\n"
            + "\n    Villager - Non-combat focused and starts with +15 speech and +3 gold\n"
            + "\n    Warrior  - Great for beginners, starts with +15 strenght and a rusty sword\n"
            + "\n    Tank     - Good at soaking up damage, +1.0 Res. to Blade & Blunt Damage\n"
            + "\n    Mage     - Great start for magic builds, starts with +15 sorcery and a wand\n"
            + "\n    Archer   - Good for \"Stealth-Sniper\" Builds, starts with +15 Sneak and a handmade bow\n"
            + "\n    Gambler  - Starts with +1 luck but also has -3 gold\n"
        );
        System.out.println("\n____________________________________________________________________________________________________\n");

    }
    static void charClassSel() {
        System.out.println("\n____________________________________________________________________________________________________\n");

        if (pClass.equals("")) {
            System.out.println("\n    Choose your character's class\n"
                + "\n1. Villager\n2. Warrior\n3. Tank\n4. Mage\n5. Archer\n6. Gambler\n7. View Class info\n"
            );
            
            playerSelection();
            switch(pSel) {
                case "1": pClass = "Villager"; charClassSet(); break;
                case "2": pClass = "Warrior"; charClassSet(); break;
                case "3": pClass = "Tank"; charClassSet(); break;
                case "4": pClass = "Mage"; charClassSet(); break;
                case "5": pClass = "Archer"; charClassSet(); break;
                case "6": pClass = "Gambler"; charClassSet(); break;
                case "7": viewClassInfo(); charClassSel(); break;
                default: System.out.println("\n        Try again"); charClassSel();
            }
        } else {
            System.out.println("\n        No clue what you did\n");
        }

        System.out.println("\n____________________________________________________________________________________________________\n");
    }
    static void charClassSet() {
        if (pClass.equals("Villager")) {
            pSpeech += 15;
            pGold += 3;
            System.out.println("\n    Your character is now a Vilager.\n");
        } else if (pClass.equals("Warrior")) {
            pStrenght += 15;
            setWeaponStats("Rusty Sword");
            System.out.println("\n    Your character is now a Warrior.\n");
        } else if (pClass.equals("Tank")) {
            pBladeRes += 1;
            pBluntRes += 1;
            System.out.println("\n    Your character is now a Tank.\n");
        } else if (pClass.equals("Mage")) {
            pSorcery += 15;
            setWeaponStats("Stick Wand");
            System.out.println("\n    Your character is now a Mage.\n");
        } else if (pClass.equals("Archer")) {
            pSneak += 15;
            setWeaponStats("Handmade Bow");
            System.out.println("\n    Your character is now a Archer.\n");
        } else if (pClass.equals("Gambler")) {
            pLuck += 1;
            pGold -= 3;
            System.out.println("\n    Your character is now a Gambler.\n");
        } else {
            System.out.println("How did you do that?");
        }

        System.out.println("\n1. Confirm Class\n2. Reset Class\n");
        playerSelection();
        switch(pSel) {
            case "1": pClassSet = true; customizeStats(); break;
            case "2": 
                if (pClass.equals("Villager")) {
                    pSpeech -= 15;
                    pGold -= 3;
                } else if (pClass.equals("Warrior")) {
                    pStrenght -= 15;
                    pInvSpace += 1;
                    setWeaponStats("");
                } else if (pClass.equals("Tank")) {
                    pBladeRes -= 1;
                    pBluntRes -= 1;
                } else if (pClass.equals("Mage")) {
                    pSorcery -= 15;
                    pInvSpace += 1;
                    invItems.remove("Stick Wand");
                } else if (pClass.equals("Archer")) {
                    pSneak -= 15;
                    pInvSpace += 1;
                    invItems.remove("Handmade Bow");
                } else if (pClass.equals("Gambler")) {
                    pLuck -= 1;
                    pGold += 3;
                } else {
                    System.out.println("How did you do that?");
                }

                pClass = "";
                pClassSet = false;
                charClassSel();
                break;
            default: System.out.println("Nuh uh"); charClassSet();
        }
    }

    //Method for choosing the character's karma
    static void startingKarma() {
        System.out.println("\n    Is your character good, neutral, or bad?");
        System.out.println("\n1. Good\n2. Neutral\n3. Bad\n");

        playerSelection();
        switch(pSel) {
            case "1": pKarma = 6; break;
            case "2": pKarma = 0; break;
            case "3": pKarma = -6; break;
            default: System.out.println("\n         N"); startingKarma();
        }

        karmaSet = true;
        customizeStats();        
    }

    // Method for choosing character's starting equipment
    static void startingEquipment() {
        System.out.println("\n    What will you take with you?\n    Note: You may only take one.\n");
        System.out.println("\n1. Rusty Sword\n2. Wooden Hammer\n3. Handmade Bow\n4. Stick Wand"
            + "\n5. Leather Armour\n6. Stamina Potion\n7. Health Potion\n8. Small Bag\n9. Gold Sack\n"
        );

        playerSelection();
        switch(pSel) {
            case "1": setWeaponStats("Rusty Sword"); break;
            case "2": setWeaponStats("Wooden Hammer"); break;
            case "3": setWeaponStats("Handmade Bow"); break;
            case "4": setWeaponStats("Stick Wand"); break;
            case "5": aLeather = true; equipArmour(); break;
            case "6": placeInInv("Stamina Potion");break;
            case "7": placeInInv("Health Potion");break;
            case "8": bSmallBag = true; equipBackpack(); break;
            case "9": pGold += ((rand.nextInt(5)) + 1); break;
            default: System.out.println("Cant"); startingEquipment();
        }

        pStartEquip = true;
        customizeStats();
    }

    // Method for starting locations
    static void startingLocation() {
        System.out.println("\n    Where will your journey start?"
            + "\n    Note: Some locations are not suitable for certain builds.\n"
        );
        System.out.println("\n1. River\n2. Desert\n3. Nekomura\n4. Orc Territory"
            + "\n5. Barbarian Territory\n6. View Character\n"
        );

        playerSelection();
        switch(pSel) {
            case "1":
                System.out.println("    " + pName + " hears the sounds of running water nearby.\n");
                playerLocator("River");
                break;
            case "2":
                System.out.println("    The schorching heat causes sweat to bead on " + pName + "'s face.\n");
                playerLocator("Desert");
                break;
            case "3":
                System.out.println("    " + pName + " got on a boat headed to Nekomura.\n");
                playerLocator("Nekomura");
                break;
            case "4":
                System.out.println("    " + pName + " has wandered into orc territory.\n");
                playerLocator("Orcs");
                break;
            case "5":
                System.out.println("    " + pName + " stumbled into barbarian territory.\n");
                playerLocator("Barbarians");
                break;
            case "6": pDisplayCharacter(); startingLocation(); break;
            default: System.out.println("Cant"); startingLocation();
        }

        pStartLocation = true;
        customizeStats();
    }

    // Method for the empirian prisoner start
    static void empirianPrisoner() {
        if (!tutComplete) {
            pStartLocation = true;
            tutComplete = true;
            String[] statements = { // string array with the text blob
                "    " + pName + " opens " + proPos + " eyes.",
                "    There's three carts being transported by Empirian Soldiers on horsedrawn carts.",
                "    "+pName+" is on the last one with three prisoners sitting with " + proObj + ",",
                "    " + proSub + " looks down to see " + proPos + " hands are tied aswell.",
                "    The convoy seems to be going towards a small desert village a few kilometers away.",
                "    One of the prisoner's starts talking to " + proObj + ".",
                "",
                "Astrid: Hey you! You finally woke up.",
                "I was starting to think the grunts hit you a bit too hard.",
                "You were trying to leave Nordverden on the west coast I'm guessing.",
                "Us? We were sent by the king to sabotage one of their ships.",
                "A classic case of wrong place wrong time I suppose.",
                "They might take it easy on you if you manage to convince them you're not with us.",
                "Good luck though. Empirians don't spare prisoners of wa...",
                "",
                "Empirian Guard: Be quiet! You're lucky I have orders to follow.",
                "If not you wouldn't even make it to the guillotine.",
                "Your stunt cost the Empire thousands of coins.",
                "You will all pay for your crimes regardless of what you say.",
                "",
                "    The cart stops inside {tempDesertVillage}.",
                "",
                "Empirian Guard: Get off already! What are you waiting for?",
                "",
                "    One by one each prisoner steps out of the cart until it's just " + pName + ".",
                "    The guard shoves " + proObj + " and " + proSub + " is forced to line up with the rest.",
                "    An officer begins to list off the names of the prisoner's and their crimes.",
                "",
                "Empirian Officer: These prisoner's have all committed unforgivable crimes against",
                "the Great Empire of the Wise Emperor Brutus the Fourth.",
                "For these crimes they will be tried for terrorism and sentenced to death by guillotine.",
                "Leon bring up the first prisoner.",
                "",
                "    The guard standing next to the officer goes out into the line of prisoners",
                "    and takes the person on the far side of where "+pName+" is.",
                "    This repeats until the prisoners on the first cart were gone",
                "    Just as the soldiers were ready to take next set of prisoners forward,",
                "    a large bomb was set off behind the guillotine sending rubble flying everywhere.",
                "    In the chaos the remaining prisoners take the opportunity to flee",
                "    while the soldiers are distracted."
            };

            // Neded to slow text chunk to let player read it better
            for (String statement : statements) { 
                System.out.println(statement);
                try { // credits to Gray on stack overflow for sleep method
                    Thread.sleep(500); // half a sec wait time (feels too fast and too slow at the same time)
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            System.out.println("\nAstrid: Hey! Come with us we know a way out through the sewers.\n\n"
            + "    At the same time she says that "+pName+" sees Leon lying on the floor under some rubble.\n"
            + "\n1. Go with Astrid\n2. Save Leon\n3. Run towards the desert\n"
            );

            playerSelection();
            switch (pSel) {
                case "1":
                    goWithAstrid();
                    break;
                case "2":
                    saveLeon();
                    break;
                case "3":
                    System.out.println("    "+pName+" takes the opportunity and escapes {tempDesertVillage}.");
                    playerLocator("Desert");
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("\n    "+pName+" already did this before...\n");
            pStartLocation = false;
            startingLocation();
        }

    }

    // method for if char goes with Astrid
    static void goWithAstrid() {
        empiRep -= 2;

        String[] statements = { // string array with the text blob
            "    "+pName+" followed Astrid.",
            "",
            "Astrid: Over here! Herry before the guards come after us!",
            "",
            "    " + pName + " and Astrid climb down the sewers with a small group of survivors",
            "    A few feet into the tunnel the group hears voices behind them",
            "",
            "Astrid: Dritt! De jager oss! Keep going I'll stay back to hold them off.",
            "",
            "    " + pName + " decides its better if they both fight back...",
            "",
            "Astrid: What are you doing? "
        };

        // Neded to slow text chunk to let player read it better
        for (String statement : statements) { 
            System.out.println(statement);
            try {
                Thread.sleep(500); // half a sec wait time (feels too fast and too slow at the same time)
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        boolean fightWithAstrid = false;
        int astridChance = rand.nextInt(20);
        if (!weaponEquipped) {
            System.out.print("Are you daft? You don't even have a weapon! Get out while you can.\n\n"
                + "1. Run Away\n2. Stay and Fight\n"
            );

            playerSelection();
            switch (pSel) {
                case "1":
                    System.out.println("\n    " + pName + " ran away with the rest of the group...\n"
                        + "    They continue traveling until one of the survivors tells the group they can exit from a hatch nearby.\n"
                        + "    The group exits the tunnel and are left near a river in the desert.\n\n"
                        + "Survivor: You! We're heading to {tempRiverVillage} you can come if you want.\n"
                        + "Its just up the river here for a few kilometers, or you can head east towards {tempDesertTown}.\n"
                    );
                    if (astridChance < 6) {
                        astridDied = true;
                    }
                    tutComplete = true;
                    playerLocator("Desert");
                    break;
                default: System.out.println("    Something inside of "+pName+" stopped "+proObj+" from leaving.\n"); setWeaponStats("Fists"); fightWithAstrid = true;
            }
        } else {
            System.out.println("Astrid: What? Are you sure? You look a little green.");
            if (pOrc || pWoodElf) {
                System.out.println("Astrid: I didn't mean it like... nevermind.");
            }
            System.out.println("\n\n1. Fight with Astrid\n2. Run Away\n");

            playerSelection();
            switch (pSel) {
                case "2":
                    System.out.println("\n    " + pName + " ran away with the rest of the group...\n"
                        + "    They continue traveling until one of the survivors tells the group they can exit from a hatch nearby.\n"
                        + "    The group exits the tunnel and are left near a river in the desert.\n\n"
                        + "Survivor: You! We're heading to {tempRiverVillage} you can come if you want.\n"
                        + "Its just up the river here for a few kilometers, or you can head east towards {tempDesertTown}.\n"
                    );
                    if (astridChance < 6) {
                        astridDied = true;
                    }
                    tutComplete = true;
                    playerLocator("Desert");
                    break;
                default:
                    System.out.println("    Something inside of "+pName+" stopped "+proObj+" from leaving.\n");
                    fightWithAstrid = true;
            }
        }

        if (fightWithAstrid) {
            System.out.println("\nAstrid: Fine let's do this together.\n\n");

            recruitComp("Astrid");

            addNPC("Wounded Soldier", 60, 20, "Bladed", 50, true);
            addNPC("Wounded Soldier", 55, 20, "Bladed", 50, true);
            addNPC("Wounded Soldier", 70, 20, "Bladed", 50, true);
            
            gotMad();

            if (pHealth > 50) {
                System.out.println("Astrid: Not bad. You might do well in the Kings Finest.");
            } else {
                System.out.println("Astrid: See. I told you not to stay behind!");
            }

            dismissComp();
            System.out.println("Astrid: Let's keep moving we might still be able to catch up.\n\n"
                + "    They exit the sewers near a river in the desert.\n\n"
                + "Astrid: We're heading up the river towards {tempRiverVillage} but if you\n"
                + "want {tempDesertTown} is to the east. If you want to travel together again I\n"
                + "will be in the capital for the next couple months.\n"
            );

            tutComplete = true;
            playerLocator("Desert");
        }

        System.out.println("\n____________________________________________________________________________________________________\n");
    }

    // method for if char tries to save Leon
    static void saveLeon() {
        verdRep -= 2;
        System.out.println("    "+pName+" went over to help Leon.");

    }

// --->   End of Character Creator   <---










// --->   Companion System   <---

    // Companion variables
    static boolean warriorInParty = false; // var for if the player has a warrior in their party
    static String wName = "";
    static int wHealth = 0;
    static int wDamage = 0;
    static double wDmgRes = 0;

    static boolean mageInParty = false;
    static String mName = "";
    static int mHealth = 0;
    static int mDamage = 0;
    static double mDmgRes = 0;

    static boolean tankInParty = false;
    static String tName = "";
    static int tHealth = 0;
    static int tDamage = 0;
    static double tDmgRes = 0;

    static boolean rangeInParty = false;
    static String rName = "";
    static int rHealth = 0;
    static int rDamage = 0;
    static double rDmgRes = 0;

    static boolean astridDied = false;
    static boolean leonDied = false;
    static boolean steinDied = false;
    static boolean evinDied = false;
    static boolean dorcyDied = false;
    static boolean inurukiDied = false;

    // Method that sets companion stats
    static void recruitComp(String name) {
        if (name.equals("Astrid") && !astridDied && !warriorInParty) {
            wName = "Astrid";
            wDamage = 20;
            wDmgRes = 1.5;
            wHealth = 150;
            warriorInParty = true;

        } else if (name.equals("Leon") && !leonDied && !warriorInParty) {
            wName = "Leon";
            wDamage = 30;
            wDmgRes = 1.5;
            wHealth = 100;
            warriorInParty = true;
        }

        System.out.println("    " + wName + " has joined " + pName + "'s party.");
    }

    // method that dismisses companion
    static void dismissComp() {
        System.out.println("    "+wName+" has left "+pName+"'s party.");

        wName = "";
        wDamage = 0;
        wDmgRes = 0;
        wHealth = 0;
    }

    // method that checks if the companion died
    static boolean isCompDead(String name) {
        if (charIsAlone()) {
            if (wHealth <= 0 && warriorInParty) {
                System.out.println("    "+wName+" died!");

                if (name.equals("Astrid")) {
                    astridDied = true;
                    warriorInParty = false;
                } else if (name.equals("Leon")) {
                    leonDied = true;
                    warriorInParty = false;
                }

                return true;
            }
            if (mHealth <= 0 && mageInParty) {
                System.out.println("    "+mName+" died!");

                if (name.equals("Evindal")) {
                    evinDied = true;
                    mageInParty = false;
                } else if (name.equals("Dorcyne")) {
                    dorcyDied = true;
                    mageInParty = false;
                }

                return true;
            }
            if (tHealth <= 0 && tankInParty) {
                System.out.println("    "+tName+" died!");

                if (name.equals("Steineter")) {
                    steinDied = true;
                    tankInParty = false;
                }

                return true;
            }
            if (rHealth <= 0 && rangeInParty) {
                System.out.println("    "+rName+" died!");

                if (name.equals("Inuruki")) {
                    inurukiDied = true;
                    rangeInParty = false;
                }

                return true;
            } else {
                return false;
            } 
        } else {
            return false;
        }

    }

    // method that check if char is alone
    static boolean charIsAlone() {
        if (warriorInParty || mageInParty || tankInParty || rangeInParty) {
            return false;
        } else {
            return true;
        }
    }

// --->   End of Comp Sys   <---










// --->   Leveling System   <---

    // Function that handles the xp curve (gets progressively harder to level up)
    static int levelCurve() {
        return 10 * (pLevel * pLevel) + 90;
    }

    // Method that levels char up if they have enough xp
    static void levelUp() {
        while (pCurXp >= pNextLvl && pLevel < 46) { // while loop makes sure char can level up more than once
            pCurXp -= pNextLvl;
            pLevel++;
            System.out.println("    "+pName+" Leveled Up!\n    New Level: " + pLevel);
            lvlUpStats();

            pNextLvl = levelCurve();
            System.out.println("    Next level: " +pCurXp + "/" + pNextLvl);
        }
    }

    static void lvlUpStats() {
        System.out.println("    What skill do you want to improve?\n");
        System.out.println("1. Strenght\n2. Speech\n3. Stamina\n4. Sorcery\n5. Sneak");

        playerSelection();
        switch(pSel) {
            case "1": pStrenght += 10; break;
            case "2": pSpeech += 10; break;
            case "3": pStamina += 10; break;
            case "4": pSorcery += 10; break;
            case "5": pSneak += 10; break;
            default: System.out.println("Nuh uh");
        }

        pMaxHealth += 10;
        pHealth = pMaxHealth;
        pBladeRes += 0.05;
        pBluntRes += 0.05;
        pMagicRes += 0.05;
        pPoisonRes += 0.05;
        pFireRes += 0.05;
        pFrostRes += 0.05;
        pUnarmedDmg += 0.05;
        pBladeDmg += 0.05;
        pBluntDmg += 0.05;
        pHeavyDmg += 0.05;
        pMagicDmg += 0.05;
        pRangedDmg += 0.05;
    }

// --->   End of Leveling System   <---










// --->   Missile Logic (it knows where it is because it knows where it isnt)   <---

    // All Possible Locations (func needed to populate locations because its an array list)
    static ArrayList<String> locList = new ArrayList<>();
    static void popLocList() {
        locList.add("Capital");
        locList.add("Nekomura");
        locList.add("Desert");
        locList.add("Barbarians");
        locList.add("Colony");
        locList.add("River");
        locList.add("Orcs");
        locList.add("Coast");
        locList.add("Plains");
        locList.add("Forrest");
        locList.add("Mountains");
        locList.add("College");

    }

    // All Possible "Rooms" (not used just wanted a list of them)
    static void popRoomList() {
        /*
        ("nordCapital")
        ("norCave")
        ("nekoCity")
        ("desVill")
        ("desTown")
        ("plaVill")
        ("barCamp")
        ("souCave")
        ("empColony")
        ("rivVill")
        ("lake")
        ("orcCamp")
        ("easCave")
        ("coastVill")
        ("hiddenForrest")
        ("plaTown")
        ("cryCave")
        ("colSor")
        ("gulag")
        ("deViSewers")
        */
    }

    // Funtion that lets player choose where to go (Probably not the best way to do it)
    static void pMover(String pLocation) {
        if (pLocation.equals("Capital")){
            System.out.println("    {tempNordCapital} is the biggest city in Nordverden."
                + "\n1. "+pName+" cannot go North."
                + "\n2. "+pName+" can go Northeast to go towards the College of Sorcery."
                + "\n3. "+pName+" can go East to go towards the Forrest."
                + "\n4. "+pName+" can go Southeast to go to Orc Territory."
                + "\n5. "+pName+" can go South towards the desert."
                + "\n6. "+pName+" can go Southwest to go towards the River."
                + "\n7. "+pName+" can go West towards the Northern Caves."
                + "\n8. "+pName+" cannot go Northwest"
                + "\n9. Go to the Capital.\n"
            );

            playerSelection();
            switch(pSel) {
                case "1":
                    System.out.println("    "+pName+" cannot go North");
                    pMover(pLocation);
                    break;
                case "2":
                    System.out.println("    "+pName+" goes Northeast.");
                    playerLocator("College");
                    break;
                case "3":
                    System.out.println("    "+pName+" goes East");
                    playerLocator("Forrest");
                    break;
                case "4":
                    System.out.println("    "+pName+" goes Southeast");
                    playerLocator("Orcs");
                    break;
                case "5":
                    System.out.println("    "+pName+" goes South");
                    playerLocator("Desert");
                    break;
                case "6":
                    System.out.println("    "+pName+" goes Southwest");
                    playerLocator("River");
                    break;
                case "7":
                    System.out.println("    "+pName+" goes West");
                    charIsIn("norCave");
                    break;
                case "8":
                    System.out.println("    "+pName+" cannot go Northwest");
                    pMover(pLocation);
                    break;
                case "9":
                    System.out.println("    "+pName+" Went into {tempNordCapital}");
                    charIsIn("nordCapital");
                    break;
                default:
                    System.out.println("Cant go there");
                    pMover(pLocation);
            }
        } else if (pLocation.equals("Nekomura")) {
            System.out.println("    Nekomura is a remote island to the east of Nordverden.\n"
                + "\n1. "+pName+" cannot go North."
                + "\n2. "+pName+" cannot go Northeast."
                + "\n3. "+pName+" cannot go East."
                + "\n4. "+pName+" cannot go Southeast."
                + "\n5. "+pName+" cannot go South."
                + "\n6. "+pName+" cannot go Southwest."
                + "\n7. "+pName+" cannot go West."
                + "\n8. "+pName+" can go Northwest to take a boat to Nordverden."
                + "\n9. Head to the Nekomura city.\n"
            );

            playerSelection();
            switch(pSel) {
                case "1": 
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                    System.out.println("    "+pName+" cannot go there.\n");
                    pMover("Nekomura");
                    break;
                case "8":
                    System.out.println("    "+pName+" went back to Nordverden.\n");
                    playerLocator("Coast");
                    break;
                case "9":
                    System.out.println("    "+pName+" went towards {tempNekoCity}.");
                    charIsIn("nekoCity");
                    break;
                default:
                    System.out.println("Can't go there.");
                    pMover(pLocation);
            }
        } else if (pLocation.equals("Desert")) {
            System.out.println("    The Desert is in the center of the map.\n"
                + "\n1. "+pName+" can go North to the Capital."
                + "\n2. "+pName+" can go Northeast to the Forrest."
                + "\n3. "+pName+" can go East to Orc Territory."
                + "\n4. "+pName+" can go Southeast to the Plains."
                + "\n5. "+pName+" can go South to Barbarian Territory."
                + "\n6. "+pName+" can go Southwest to the Mountains."
                + "\n7. "+pName+" can go West to {tempDesVill}."
                + "\n8. "+pName+" can go Northwest to the River."
                + "\n9. Go to the desert town\n"
            );

            playerSelection();
            switch(pSel) {
                case "1":
                    System.out.println("    "+pName+" goes North.");
                    playerLocator("Capital");
                    break;
                case "2":
                    System.out.println("    "+pName+" goes Northeast.");
                    playerLocator("Forrest");
                    break;
                case "3":
                    System.out.println("    "+pName+" goes East.");
                    playerLocator("Orcs");
                    break;
                case "4":
                    System.out.println("    "+pName+" goes Southeast.");
                    playerLocator("Plains");
                    break;
                case "5":
                    System.out.println("    "+pName+" goes South.");
                    playerLocator("Barbarians");
                    break;
                case "6":
                    System.out.println("    "+pName+" goes Southwest.");
                    playerLocator("Mountains");
                    break;
                case "7":
                    System.out.println("    "+pName+" goes West.");
                    charIsIn("desVill");
                    break;
                case "8":
                    System.out.println("    "+pName+" goes Northwest.");
                    playerLocator("River");
                    break;
                case "9":
                    System.out.println("    "+pName+" went to {tempDesertTown}.");
                    charIsIn("desTown");
                    break;
                default:
                    System.out.println("Can't go there.");
                    pMover(pLocation);
            }
        } else if (pLocation.equals("Barbarians")) {
            System.out.println("    Barbarian territory is occupied by outlaws.\n"
                + "\n1. "+pName+" can go North to the Desert."
                + "\n2. "+pName+" can go Northeast to Orc territory."
                + "\n3. "+pName+" can go East to the Plains."
                + "\n4. "+pName+" cannot go Southeast."
                + "\n5. "+pName+" cannot go South."
                + "\n6. "+pName+" cannot go Southwest."
                + "\n7. "+pName+" can go West to {tempPlaVill}."
                + "\n8. "+pName+" can go Northwest to the Great Mountains."
                + "\n9. Try to go to the Barbarian camp.\n"
            );

            playerSelection();
            switch(pSel) {
                case "1":
                    System.out.println("    "+pName+" goes North.");
                    playerLocator("Desert");
                    break;
                case "2":
                    System.out.println("    "+pName+" goes Northeast.");
                    playerLocator("Orcs");
                    break;
                case "3":
                    System.out.println("    "+pName+" goes East.");
                    playerLocator("Plains");
                    break;
                case "4":
                case "5":
                case "6":
                    System.out.println("    "+pName+" cannot go there.");
                    pMover("Barbarians");
                    break;
                case "7":
                    System.out.println("    "+pName+" goes West.");
                    charIsIn("plaVill");
                    break;
                case "8":
                    System.out.println("    "+pName+" goes Northwest.");
                    playerLocator("Mountains");
                    break;
                case "9":
                    System.out.println("    "+pName+" went to the Barbarian camp.");
                    charIsIn("barCamp");
                    break;
                default:
                    System.out.println("Can't go there.");
                    pMover(pLocation);
            }
        } else if (pLocation.equals("Colony")) {
            System.out.println("    {empColony} is an Empirian colony on the west coast.\n"
            + "\n1. "+pName+" can go North towards the Northern Caves."
            + "\n2. "+pName+" can go Northeast to the River."
            + "\n3. "+pName+" can go East to the Desert."
            + "\n4. "+pName+" can go Southeast to the Mountains."
            + "\n5. "+pName+" can go South to Southern Caves."
            + "\n6. "+pName+" cannot go Southwest."
            + "\n7. "+pName+" cannot go West."
            + "\n8. "+pName+" cannot go Northwest."
            + "\n9. Go to the Empirian town.\n"
            );

            playerSelection();
            switch(pSel) {
                case "1":
                    System.out.println("    "+pName+" goes North.");
                    charIsIn("norCave");
                    break;
                case "2":
                    System.out.println("    "+pName+" goes Northeast.");
                    playerLocator("River");
                    break;
                case "3":
                    System.out.println("    "+pName+" goes East.");
                    playerLocator("Desert");
                    break;
                case "4":
                    System.out.println("    "+pName+" goes Southeast.");
                    playerLocator("Mountains");
                    break;
                case "5":
                    System.out.println("    "+pName+" goes South.");
                    charIsIn("souCave");
                    break;
                case "6":
                case "7":
                case "8":
                    System.out.println("    "+pName+" cannot go there.");
                    pMover("Colony");
                    break;
                case "9":
                    System.out.println("    "+pName+" went to {tempEmpColony}.");
                    charIsIn("empColony");
                    break;
                default:
                    System.out.println("Can't go there.");
                    pMover(pLocation);
            }
        } else if (pLocation.equals("River")) {
            System.out.println("    The River is the main food source of the capital.\n"
            + "\n1. "+pName+" can go North to the Capital."
            + "\n2. "+pName+" can go Northeast to the Capital."
            + "\n3. "+pName+" can go East to the Forrest."
            + "\n4. "+pName+" can go Southeast to the Desert."
            + "\n5. "+pName+" can go South to the Great Mountains."
            + "\n6. "+pName+" can go Southwest to {tempDesVill}."
            + "\n7. "+pName+" can go West to the Colony."
            + "\n8. "+pName+" can go Northwest to the Northern Caves."
            + "\n9. Go to {riverVillage}.\n"
        );

        playerSelection();
        switch(pSel) {
            case "1":
            case "2":
                System.out.println("    "+pName+" goes Northeast.");
                playerLocator("Capital");
                break;
            case "3":
                System.out.println("    "+pName+" goes East.");
                playerLocator("Forrest");
                break;
            case "4":
                System.out.println("    "+pName+" goes Southeast");
                playerLocator("Desert");
                break;
            case "5":
                System.out.println("    "+pName+" goes South");
                playerLocator("Mountains");
                break;
            case "6":
                System.out.println("    "+pName+" goes Southwest.");
                charIsIn("desVill");
                break;            
            case "7":
                System.out.println("    "+pName+" goes West.");
                playerLocator("Colony");
                break;
            case "8":
                System.out.println("    "+pName+" goes Northwest.");
                charIsIn("norCave");
                break;
            case "9":
                System.out.println("    "+pName+" went to {tempRiverVillage}.");
                charIsIn("rivVill");
                break;
            default:
                System.out.println("Can't go there.");
                pMover(pLocation);
            }
        } else if (pLocation.equals("Orcs")) {
            System.out.println("    Orc Territory is a large mountain occupied by Orcs.\n"
            + "\n1. "+pName+" can go North towards the College of Sorcery."
            + "\n2. "+pName+" can go Northeast towards the Forrest."
            + "\n3. "+pName+" can go East towards the Coast."
            + "\n4. "+pName+" can go Southeast towards the Lake."
            + "\n5. "+pName+" can go South towards the Plains."
            + "\n6. "+pName+" can go Southwest towards Barbarian territory."
            + "\n7. "+pName+" can go West towards the Desert."
            + "\n8. "+pName+" can go Northwest towards the Capital"
            + "\n9. Try to enter the Orc Camp.\n"
        );

        playerSelection();
        switch(pSel) {
            case "1":
                System.out.println("    "+pName+" goes North");
                playerLocator("College");
                break;
            case "2":
                System.out.println("    "+pName+" goes Northeast.");
                playerLocator("Forrest");
                break;
            case "3":
                System.out.println("    "+pName+" goes East");
                playerLocator("Coast");
                break;
            case "4":
                System.out.println("    "+pName+" goes Southeast");
                charIsIn("lake");
                break;
            case "5":
                System.out.println("    "+pName+" goes South");
                playerLocator("Plains");
                break;
            case "6":
                System.out.println("    "+pName+" goes Southwest");
                playerLocator("Barbarians");
                break;
            case "7":
                System.out.println("    "+pName+" goes West");
                playerLocator("Desert");
                break;
            case "8":
                System.out.println("    "+pName+" goes Northwest");
                playerLocator("Capital");
                break;
            case "9":
                System.out.println("    "+pName+" Went to the Orc Camp");
                charIsIn("orcCamp");
                break;
            default:
                System.out.println("Cant go there");
                pMover(pLocation);
            }
        } else if (pLocation.equals("Coast")) {
            System.out.println("    The East Coast is the only way to get to Nekomura.\n"
                + "\n1. "+pName+" can go North towards the Eastern caves."
                + "\n2. "+pName+" cannot go Northeast."
                + "\n3. "+pName+" can go East to Nekomura."
                + "\n4. "+pName+" cannot go Southeast."
                + "\n5. "+pName+" cannot go South."
                + "\n6. "+pName+" can go Southwest towards the Lake."
                + "\n7. "+pName+" can go West to Orc Territory."
                + "\n8. "+pName+" can go Northwest to the Forrest."
                + "\n9. Go towards the Coastal Village\n"
            );

            playerSelection();
            switch(pSel) {
            case "1":
                System.out.println("    "+pName+" goes North");
                charIsIn("easCave");
                break;
            case "3":
                System.out.println("    "+pName+" goes East");
                playerLocator("Nekomura");
                break;
            case "2":
            case "4":
            case "5":
                System.out.println("    "+pName+" cannot go there");
                pMover("Coast");
                break;
            case "6":
                System.out.println("    "+pName+" goes Southwest");
                charIsIn("lake");
                break;
            case "7":
                System.out.println("    "+pName+" goes West");
                playerLocator("Orcs");
                break;
            case "8":
                System.out.println("    "+pName+" goes Northwest");
                playerLocator("Forrest");
                break;
            case "9":
                System.out.println("    "+pName+" Went to {tempCoastalVillage}");
                charIsIn("coastVill");
                break;
            default:
                System.out.println("Cant go there");
                pMover(pLocation);
            }
        } else if (pLocation.equals("Plains")) {
            System.out.println("    The Plains are dangerous due to the proximity to Orcs and Barbarians.\n"
                + "\n1. "+pName+" can go North to Orc territory."
                + "\n2. "+pName+" can go Northeast to the Lake."
                + "\n3. "+pName+" can go East to the coast."
                + "\n4. "+pName+" cannot go Southeast."
                + "\n5. "+pName+" cannot go South."
                + "\n6. "+pName+" cannot go Southwest."
                + "\n7. "+pName+" can go West to Barbarian territory."
                + "\n8. "+pName+" can go Northwest to the Desert."
                + "\n9. "+pName+" go to the Plains Town.\n"
            );

            playerSelection();
            switch(pSel) {
                case "1":
                    System.out.println("    "+pName+" goes North.");
                    playerLocator("Orcs");
                    break;
                case "2":
                    System.out.println("    "+pName+" goes Northeast.");
                    charIsIn("lake");
                    break;
                case "3":
                    System.out.println("    "+pName+" goes East.");
                    playerLocator("Coast");
                    break;
                case "4":
                case "5":
                case "6":
                    System.out.println("    "+pName+" cannot go there.");
                    pMover("Plains");
                    break;
                case "7":
                    System.out.println("    "+pName+" goes West.");
                    playerLocator("Barbarians");
                    break;
                case "8":
                    System.out.println("    "+pName+" goes Northwest.");
                    playerLocator("Desert");
                    break;
                case "9":
                    System.out.println("    "+pName+" went to {tempPlainsTown}.");
                    charIsIn("plaTown");
                    break;
                default:
                    System.out.println("Can't go there.");
                    pMover("Plains");
            }
        } else if (pLocation.equals("Forrest")) {
            System.out.println("    The Forrest is rumoured to hide the remaining wood elf civilization."
                + "\n1. "+pName+" can go North towards the College."
                + "\n2. "+pName+" cannot go Northeast."
                + "\n3. "+pName+" can go East towards the Eastern Caves."
                + "\n4. "+pName+" can go Southeast towards the Coast."
                + "\n5. "+pName+" can go South towards Orc Territory."
                + "\n6. "+pName+" can go Southwest towards the Desert."
                + "\n7. "+pName+" can go West towards the Capital."
                + "\n8. "+pName+" can go Northwest towards the College."
                + "\n9. Try to find the hidden forrest.\n"
            );

            playerSelection();
            switch(pSel) {
                case "1":
                    System.out.println("    "+pName+" goes North");
                    playerLocator("College");
                    break;
                case "2":
                    System.out.println("    "+pName+" cannot go Northeast.");
                    pMover("Forrest");
                    break;
                case "3":
                    System.out.println("    "+pName+" goes East.");
                    charIsIn("easCave");
                    break;
                case "4":
                    System.out.println("    "+pName+" goes Southeast.");
                    playerLocator("Coast");
                    break;
                case "5":
                    System.out.println("    "+pName+" goes South.");
                    playerLocator("Orcs");
                    break;
                case "6":
                    System.out.println("    "+pName+" goes Southwest.");
                    playerLocator("Desert");
                    break;
                case "7":
                    System.out.println("    "+pName+" goes West.");
                    playerLocator("Capital");
                    break;
                case "8":
                    System.out.println("    "+pName+" goes Northwest to the College.");
                    playerLocator("College");
                    break;
                case "9":
                    System.out.println("    "+pName+" walks around for a while.");
                    if (pForrestKey){
                        System.out.println("    The key begins to glow. "
                            + pName + " is transported into the hidden forrest."
                        );
                        charIsIn("hiddenForrest");
                    } else {
                        System.out.println("    But "+proObj+" didn't find anything");
                    }
                    break;
                default:
                    System.out.println("Can't go there.");
                    pMover("Forrest");
            }
        } else if (pLocation.equals("Mountains")) {
            System.out.println("    The Mountains used to be used for magic crystal mining."
                + "\n1. "+pName+" can go North to the River."
                + "\n2. "+pName+" can go Northeast to the Desert."
                + "\n3. "+pName+" can go East to Orc Territory."
                + "\n4. "+pName+" can go Southeast to Barbarian territory."
                + "\n5. "+pName+" can go South to {tempPlainsVillage}."
                + "\n6. "+pName+" can go Southwest to the Southern Caves."
                + "\n7. "+pName+" can go West to the the Colony."
                + "\n8. "+pName+" can go Northwest to {tempDesertVillage}."
                + "\n9. Enter the crystal mine.\n"
            );

            playerSelection();
            switch(pSel) {
                case "1":
                    System.out.println("    "+pName+" goes North.");
                    playerLocator("River");
                    break;
                case "2":
                    System.out.println("    "+pName+" goes Northeast.");
                    playerLocator("Desert");
                    break;
                case "3":
                    System.out.println("    "+pName+" goes East.");
                    playerLocator("Orcs");
                    break;
                case "4":
                    System.out.println("    "+pName+" goes Southeast.");
                    playerLocator("Barbarians");
                    break;
                case "5":
                    System.out.println("    "+pName+" goes South.");
                    charIsIn("plaVill");
                    break;
                case "6":
                    System.out.println("    "+pName+" goes Southwest.");
                    charIsIn("souCave");
                    break;
                case "7":
                    System.out.println("    "+pName+" goes West to the Colony.");
                    playerLocator("Colony");
                    break;
                case "8":
                    System.out.println("    "+pName+" goes Northwest to {tempDesertVillage}.");
                    charIsIn("desVill");
                    break;
                case "9":
                    System.out.println("    "+pName+" went into the cave.");
                    charIsIn("cryCave");
                    break;
                default:
                    System.out.println("Can't go there.");
                    pMover("Mountains");
            }
        } else if (pLocation.equals("College")) {
            System.out.println("    The College of Sorcery only accepts the best mages."
                + "\n1. "+pName+" cannot go North."
                + "\n2. "+pName+" cannot go Northeast."
                + "\n3. "+pName+" can go East to the Forrest."
                + "\n4. "+pName+" can go Southeast to the Forrest."
                + "\n5. "+pName+" can go South to Orc territory."
                + "\n6. "+pName+" can go Southwest to the Desert."
                + "\n7. "+pName+" can go West to the Capital."
                + "\n8. "+pName+" cannot go Northwest."
                + "\n9. Apply to the College of Sorcery"
            );

            playerSelection();
            switch(pSel) {
                case "1":
                case "2":
                    System.out.println("    "+pName+" cannot go there.");
                    pMover("College");
                    break;
                case "3":
                    System.out.println("    "+pName+" goes East.");
                    playerLocator("Forrest");
                    break;
                case "4":
                    System.out.println("    "+pName+" goes Southeast.");
                    playerLocator("Forrest");
                    break;
                case "5":
                    System.out.println("    "+pName+" goes South.");
                    playerLocator("Orcs");
                    break;
                case "6":
                    System.out.println("    "+pName+" goes Southwest.");
                    playerLocator("Desert");
                    break;
                case "7":
                    System.out.println("    "+pName+" goes West.");
                    playerLocator("Capital");
                    break;
                case "8":
                    System.out.println("    "+pName+" cannot go Northwest.");
                    pMover("College");
                    break;
                case "9":
                    System.out.println("    "+pName+" went into the College");
                    charIsIn("colSor");
                    break;
                default:
                    System.out.println("Can't go there.");
                    pMover("College");
            }
        } else if (pLocation.equals("Void")) {
            System.out.println("Mysterious Traveler: How did you end up here?\n");
            while (true) {
                playerSelection();
            }
        } else {
            System.out.println("\n\nGo to the void!\n\n");
            pMover("Void");
        }
    }

    // Method that determines the player's location
    static void playerLocator(String Location) {
        if (locList.contains(Location)) {
            if (Location.equals("Capital")) {
                System.out.println("    " + pName + " is in the Capital\n");
                pLocation = Location;
            } else if (Location.equals("Nekomura")) {
                nekoCheckpoint();
            } else if (Location.equals("Desert")) {
                System.out.println("    " + pName + " is in the Desert\n");
                pLocation = Location;
            } else if (Location.equals("Barbarians")) {
                System.out.println("    " + pName + " is in Barbarian territory\n");
                pLocation = Location;
            } else if (Location.equals("Colony")) {
                System.out.println("    " + pName + " is in the Empirian Colony\n");
                pLocation = Location;
            } else if (Location.equals("River")) {
                System.out.println("    " + pName + " is near the River\n");
                pLocation = Location;
            } else if (Location.equals("Orcs")) {
                System.out.println("    " + pName + " is in Orc territory\n");
                pLocation = Location;
            } else if (Location.equals("Coast")) {
                System.out.println("    " + pName + " is near the coast\n");
                pLocation = Location;
            } else if (Location.equals("Plains")) {
                System.out.println("    " + pName + " is in the Plains\n");
                pLocation = Location;
            } else if (Location.equals("Forrest")) {
                System.out.println("    " + pName + " is in the Forrest\n");
                pLocation = Location;
            } else if (Location.equals("Mountains")) {
                System.out.println("    " + pName + " is at the Great Mountains\n");
                pLocation = Location;
            } else if (Location.equals("College")) {
                System.out.println("    " + pName + " is outside the College of Sorcery\n");
                pLocation = Location;
            } else {
                System.out.println("Somethings went wrong?");
            }
        } else {
            System.out.println("    You are stuck in the void");
            pLocation = "Void";
        }

        pMover(pLocation);
    }

    // Method that ensures character has a passport
    static void nekoCheckpoint() {
        if (pNekoPassport) {
            System.out.println("    " + pName + " passed the checkpoint and was allowed to stay.\n");
            pLocation = "Nekomura";
        } else {
            System.out.println("    " + pName + " did not pass the checkpoint and was deported.\n");
            pLocation = "Coast";
        }
    }

    // Funtion that sends cahr to the correct room
    static void charIsIn(String room) {
        if (room.equals("gulag")) {
            theGulag();
        }
    }

// --->   End of Missile Logic <---










//   --->   Quest Variables   <---

    // Array list with all current quests
    static ArrayList<String> quests = new ArrayList<>();

    // -> Tavern Quests <-

    // Capital Quests
    static boolean caravanGuard = false;
    static boolean thiefCapture = false;
    static boolean spyCapture = false;

    // River quests
    static boolean wolfExterminator = false;
    static boolean npcHelper = false;
    static boolean hasWoodAxe = false;

    // 

    // -> End of Tavern Quests <-


//   --->   End of Quest Vars   <---










// --->   Rooms (secondary locations)   <---

    // Room for player's death
    static void theGulag() {
        System.out.println("    "+pName+" woke up in an empty arena...");
        System.out.println("    The only way to escape is by facing YOUR weakness.");
        System.out.println("    Prepare for combat or quit.");
        pHealth = pMaxHealth;

        playerSelection();

        int xpNeeded = pNextLvl - pCurXp;
        clearNPCs();
        addNPC(pName, pMaxHealth, pWeaponDmg, pWeaponType, xpNeeded, true);
        gotMad();

        clearNPCs();
        inCombat = false;
        pLives += 2;
        System.out.println("    "+pName+" has lived to fight another day...");
        startingLocation();
    }

    // The tavern is the main location for side quests
    static void tavern(String Location) {
        addNPC("Barkeep", 100, 10, "Blunt", 25, false);
        addNPC("Patron", 100, 5, "Blunt", 25, false);
        addNPC("Drunk", 80, 0, "Blunt", 25, false);
        addNPC("Patron", 100, 5, "Blunt", 25, false);
        addNPC("Barguard", 100, 30, "Blade", 50, false);

        System.out.println("    "+pName+" walks into the tavern to look for work.\n");
        System.out.println("Quest Board: ");

        if (Location.equals("Capital")) {
            System.out.println("1. Caravan Guard(5g)\n2. Capture Thief(10g)\n3. Capture Spy(5-10g)");

            playerSelection();
            switch (pSel) {
                case "1":
                    if (!caravanGuard) {
                        System.out.println("Barkeep: We've had some trouble getting our supplies over\n"
                            + "to {tempRiverVillage} and back because of Wolves. Make sure they get there safely.\n"
                            + "They should be waiting outside the capital wall."
                        );
                        quests.add("Caravan Guard");

                        qCarGuard();
                    }
                    break;
                case "2":
                    if (!thiefCapture) {

                    }
                    break;
                case "3":
                    if (!spyCapture) {

                    }
                    break;
                default: System.out.println("    Thats not available"); tavern("Capital");
            }
        } else if (Location.equals("Colony")) {
            System.out.println("1. Kill the wolves nearby(5g)\n2. Help out \"{tempVillagerName}\"(3g)\n3. Chop Wood(1g/log)");

            playerSelection();
            switch (pSel) {
                case "1":
                    if (!wolfExterminator) {
                        System.out.println("Barkeep: Those wolves have been eating our lumberjacks!\n"
                            + "Lord {tempRiverLord} sent out 3 guards and only 1 and a half came back.\n"
                            + "The wolf den is about half a kilometer in the forrest. Kill them all."
                        );
                        quests.add("Wolf Exterminator");

                        qWolfExt();
                    }
                    break;
                case "2":
                    if (!npcHelper) {

                    }
                    break;
                case "3":
                    if (hasWoodAxe) {

                    } else {
                        System.out.println("    "+pName+" cannot punch down a tree"
                            + "    Wood Axes are available in the shop."
                        );
                        tavern("River");
                    }
                    break;
                default: System.out.println("    Thats not available"); tavern("River");
            }
        } else if (Location.equals("River")) {

        } else if (Location.equals("Desert")) {

        } else if (Location.equals("Coast")) {

        }
    }

// --->   End of Rooms   <---










// --->   Quest Rooms    <---


    // caravan guard quest
    static void qCarGuard() {
        System.out.println("    "+pName+" meets up with the rest of the caravan outside of the capital\n\n"
            + "Traveling Merchant: Finally they send someone to help us! We've been waiting here for hours.\n\n"
            + "    "+pName+" gets on a horse and starts following the caravan...\n"
            + "    A few kilometers down the river, the caravan hears howls...\n\n"
            + "Traveling Merchant: Hurry! This is what we pay you for."
        );

        clearNPCs();
        addNPC("Wolf", 50, 10, "Blade", 25, true);
        addNPC("Rabid Wolf", 50, 10, "Poison", 30, true);
        addNPC("Albino Wolf", 50, 20, "Frost", 50, true);

        System.out.println("    The caravan Stays back while "+pName+" goes towards the howls.\n");

        gotMad();

        if (pHealth > 50) {
            int bonus = rand.nextInt(2) + 1;
            pGold += bonus;
            System.out.println("Traveling Merchant: Many thanks guard. I was not expecting this to go smoothly.\n"
                + "Here is a token of our appreciation.\n\n"
                + "    The merchant gives "+pName+" a "+bonus+"g bonus!\n"
            );
        } else {
            System.out.println("Traveling Merchant: Pfft. As expected. I'm surprised were still alive.");
        }

        System.out.println("    The caravan made it to {tempRiverVillage} safely!");
        pGold += 5;
        caravanGuard = true;
        quests.remove("Caravan Guard");
        playerLocator("River");
    }

    // Wolf Exterminator quest
    static void qWolfExt() {
        System.out.println("    "+pName+" walks in the forrest until "+proObj+" hears the snarls of Wolves nearby.");
        
        clearNPCs();
        addNPC("Wolf", 50, 10, "Blade", 25, true);
        addNPC("Wolf", 50, 10, "Blade", 25, true);
        addNPC("Alpha Wolf", 100, 20, "Blade", 50, true);
        addNPC("Wolf", 50, 10, "Blade", 25, true);
        addNPC("Wolf", 50, 10, "Blade", 25, true);

        System.out.println("    The howls of hungry dogs are nearby...");
        gotMad();

        if (pHealth > 50) {
            System.out.println("    "+pName+" brushes off a couple scratches.");
        } else {
            System.out.println("    "+pName+" groans in pain and limps back to {tempRiverVillage}");
        }

        System.out.println("    "+pName+" turns in the Alpha Wolf's head to a nearby guard.\n\n"
            + "Guard: Ohh... you didn't have to bring it back.\n\n"
            + "    The guard pays "+pName+" 5g!"
        );

        pGold += 5;
        wolfExterminator = true;
        quests.remove("Wolf Exterminator");
        playerLocator("River");
        
    }

// --->   End of quests   <---










// --->   Combat Methods   <---

    //Combat Variables
    static boolean inCombat = false;
    static boolean weaponEquipped = false;
    static String pWeapon = "";
    static String pArmour = "";
    static int pHitChance = 0; // Character's hit chance (1-20) [<10 hits]
    static int eHitChance = 0; // enemy hit chance
    static int pDisToTar = 0; // Character's distance to targeted enemy (>=2 is Melee <2 isRanged)
    static int pWeaponDmg = 0; // Character's current weapon damage (T1 = 10, T2 = 20, ... T5 = 50[Max])
    static String pWeaponType = "none"; // type of weapon character is using
    static double pDmgMult = 0.0; // Characte's damage multiplier (depends on weapon type)
    static double pDmgRes = 0.0; // Character's damage resistance (depens on damage type)
    static int eDamage = 0; // damage done to player if enemy hits
    static String eDmgType; // type of damage enemy does
    static double pDamageCalc; // ((pWeaponDmg*pDmgMult) + (pStrenght*0.25))  Equation to calculate character's damage

    // Individual array lists used for each enemy stat
    static ArrayList<String> npcName = new ArrayList<>(); // NPC names
    static ArrayList<Integer> npcHealth = new ArrayList<>(); // NPC health
    static ArrayList<Integer> npcDamage = new ArrayList<>(); // NPC damage
    static ArrayList<String> npcDamageType = new ArrayList<>(); // NPC damage type
    static ArrayList<Integer> npcExp = new ArrayList<>(); // NPC experience
    static ArrayList<Boolean> npcHostile = new ArrayList<>(); // Whether NPC is hostile

    // Long Ahh List of Weapons (array lists not needed but makes finding weapon simpler)
    static ArrayList<String> allWeapons = new ArrayList<>(); 
    static ArrayList<String> t1Weapons = new ArrayList<>();
    static ArrayList<String> t2Weapons = new ArrayList<>();
    static ArrayList<String> t3Weapons = new ArrayList<>();
    static ArrayList<String> t4Weapons = new ArrayList<>();
    static ArrayList<String> t5Weapons = new ArrayList<>();
    static ArrayList<String> spells = new ArrayList<>();

    // Method that initializes combat
    static void combat() {
        while (inCombat) { // Starts bombat

            System.out.println("\n    Enemies in view:");
            for (int i = 0; i < npcName.size(); i++) { // for loop to display enemies (same as inv)
                System.out.println((i + 1) + ". " + npcName.get(i) + " (Health: " + npcHealth.get(i) + ")");
            }

            System.out.println("\n    "+pName+"'s Health: "+pHealth+"/"+pMaxHealth+"\n");
            pTurn(); // Player goes first

            if (theyAreDead()) {
                System.out.println("\n    "+pName+" has triumphed!");
                for (int i = 0; i < npcName.size(); i++) { // for loop to reward player with exp
                    pCurXp += npcExp.get(i);
                    levelUp();
                }
                break;
            }

            if (!charIsAlone()) {
                cTurn();
            }

            combatMenu();

            eTurn(); // if char has not won next enemy will attack

            if (isCharDead()) {
                if (pLives == 1) { // Sends char to the gulag if they die
                    System.out.println("\n    "+pName+" has died...");
                    pLives -= 1;
                    theGulag();
                    break;
                } else if (pLives <= 0) { // ends game if they lose in the gulag
                    System.out.println("\n    "+pName+" has died...");
                    System.out.println("    "+pName+"'s journey has ended.");
                    System.out.println("\nGoodbye\n");
                    input.close();
                    System.exit(0);
                } else { // continues battle if they have more lives left
                    System.out.println("\n    "+pName+" has died...");
                    System.out.println("    BUT THAT DID NOT STOP " +pName+ "!");
                    pLives -= 1;
                    pHealth = pMaxHealth;
                }

            }
        }

        System.out.println("\n   "+pName+"'s Health: "+pHealth+"/"+pMaxHealth+"\n");
        inCombat = false;
        System.out.println("    The battlefield is quiet.");
        clearNPCs();
        System.out.println("\n____________________________________________________________________________________________________\n");
    }

    // Method that displays list of npcs and their health
    static void showEnemies() {
        System.out.println("\nEnemies in view:");
        for (int i = 0; i < npcName.size(); i++) { // for loop to display enemies (same as inv)
            System.out.println((i + 1) + ". " + npcName.get(i) + " (Health: " + npcHealth.get(i) + ")");
        }
    }

    // Method that starts combat if NPC is hostile or if the player want to
    static void gotMad() {
        if (isBadArea()) {
            inCombat = true;
            combat();
        } else {
            System.out.println("    Everyone is chill.\n    But does that matter...");
            System.out.println("1. Start Combat\n2. Maintain the peace\n");

            playerSelection();
            switch (pSel) {
                case "1":
                    inCombat = true;
                    combat();
                    break;
                default: System.out.println("    No one is a threat.\n");
            }
        }

    }

    // Function that checks if there are hostile enemies nearby
    static boolean isBadArea() {
        for (boolean hostile : npcHostile) {
            if (hostile) {
                return true;
            }
        }
        return false;
    }

    // Method for the players turn
    static void pTurn() {
        for (int i = 0; i < (pStamina/10); i++) {
            int choice = 0;
            System.out.print("\n    Who will "+pName+" attack? (1-" + npcName.size() + "): ");
            choice = input.nextInt() - 1;

            if (choice < 0 || choice >= npcName.size()) { // input validation to make sure player selects valid enemy
                System.out.println("    "+pName+" fought the air.");
                return;
            }

            pHitChance = rand.nextInt(20) + 1 + pLuck;

            if (pHitChance < 10) {
                System.out.println("    "+pName+" missed!");
            } else if (pHitChance == 20) {
                System.out.println("\n*Critical Hit!*\n");
                setDamageMultiplier(pWeaponType);
                pDamageCalc = ((pWeaponDmg * pDmgMult) + (pStrenght * 0.25));
                int damage = (int)(pDamageCalc);
                damage *= 2;

                npcHealth.set(choice, npcHealth.get(choice) - damage);
                System.out.println("    " + pName + " hit " + npcName.get(choice) + " and did " + damage + " damage!");
            } else {
                setDamageMultiplier(pWeaponType);
                pDamageCalc = ((pWeaponDmg * pDmgMult) + (pStrenght * 0.25));
                int damage = (int)(pDamageCalc);

                npcHealth.set(choice, npcHealth.get(choice) - damage);
                System.out.println("    " + pName + " hit " + npcName.get(choice) + " and did " + damage + " damage!");
            }            
        }

        System.out.println("\n    "+pName+" ran out of stamina.");
        System.out.println("\n____________________________________________________________________________________________________\n");
    }

    // Function that checks if all enemies in sight are dead
    static boolean theyAreDead() {
        for (int i = 0; i < npcHealth.size(); i++) {
            if (npcHealth.get(i) > 0) {
                return false;
            }
        }
        return true;
    }

    // Function that checks if char died
    static boolean isCharDead() {
        return pHealth <= 0; // checks if char's health dropped to 0
    }

    // Method for the enemies turn (i sHoUlD aDd A sYsTeM fOr MuLtIpLe EnEmIeS - Naive Rigo)
    static void eTurn() {
        for (int i = 0; i < npcName.size(); i++) { // looks like jargon but lets every enemy attack
            if (npcHealth.get(i) > 0) { // if the enemy attacking is alive

                // Create a list of available targets
                ArrayList<String> targets = new ArrayList<>();
                targets.add(pName); // Player character
                if (warriorInParty) {
                    targets.add(wName);
                } else if (isCompDead(wName)) {
                    targets.remove(wName);
                }
                if (mageInParty) {
                    targets.add(mName);
                } else if (isCompDead(mName)) {
                    targets.remove(mName);
                }
                if (tankInParty) {
                    targets.add(tName);
                } else if (isCompDead(tName)) {
                    targets.remove(tName);
                }
                if (rangeInParty) {
                    targets.add(rName);
                } else if (isCompDead(rName)) {
                    targets.remove(rName);
                }

                eHitChance = rand.nextInt(20) + 1;
                int numTargets = rand.nextInt(targets.size());
                String eTargetChoice = targets.get(numTargets);
                eDamage = npcDamage.get(i);

                if (eHitChance < 10) {
                    System.out.println("    "+npcName.get(i)+" missed!");
                } else if (eTargetChoice.equals(pName)) {
                    eDmgType = npcDamageType.get(i);
                    setDamageResistance(eDmgType);
                    eDamage = (int)(eDamage / (pDmgRes + 0.5));
                    eDamage = Math.max(eDamage, 0); // Makes sure the enemies damage cant be lower than 0 or it would heal (would be funny tho)
                    pHealth -= eDamage;
                    System.out.println("    "+npcName.get(i)+" hit "+pName+" and did "+eDamage+" damage!");
                } else if (eTargetChoice.equals(wName)) {
                    eDamage = (int)(eDamage / (wDmgRes + 0.5));
                    eDamage = Math.max(eDamage, 0);
                    wHealth -= eDamage;
                    System.out.println("    "+npcName.get(i)+" hit "+wName+" and did "+eDamage+" damage!");
                } else if (eTargetChoice.equals(mName)) {
                    eDamage = (int)(eDamage / (mDmgRes + 0.5));
                    eDamage = Math.max(eDamage, 0);
                    mHealth -= eDamage;
                    System.out.println("    "+npcName.get(i)+" hit "+mName+" and did "+eDamage+" damage!");
                }  else if (eTargetChoice.equals(tName)) {
                    eDamage = (int)(eDamage / (tDmgRes + 0.5));
                    eDamage = Math.max(eDamage, 0);
                    tHealth -= eDamage;
                    System.out.println("    "+npcName.get(i)+" hit "+tName+" and did "+eDamage+" damage!");
                } else if (eTargetChoice.equals(rName)) {
                    eDamage = (int)(eDamage / (rDmgRes + 0.5));
                    eDamage = Math.max(eDamage, 0);
                    rHealth -= eDamage;
                    System.out.println("    "+npcName.get(i)+" hit "+rName+" and did "+eDamage+" damage!");
                }
            }
        }
    }

    static void cTurn() {
        int cHitChance;
        int cChoice;

        if (!isCompDead(wName) && warriorInParty) { // if warrior is alive they attack a random enemy
            cChoice = rand.nextInt(npcName.size());
            cHitChance = rand.nextInt(20) + 1;
            if (cHitChance < 7) {
                System.out.println("    "+wName+" missed!");
            } else {
                npcHealth.set(cChoice, npcHealth.get(cChoice) - wDamage);
                System.out.println("    " + wName + " hit " + npcName.get(cChoice) + " and did " + wDamage + " damage!");
            }
        }
        if (!isCompDead(mName) && mageInParty) { // if mage is alive they attack a random enemy (heals player with a nat 20)
            cChoice = rand.nextInt(npcName.size());
            cHitChance = rand.nextInt(20) + 1;
            if (cHitChance < 11) {
                System.out.println("    "+mName+" missed!");
            } else if (cHitChance == 20) {
                pHealth = pMaxHealth;
                System.out.println("    "+mName+" fully healed "+pName+"!");
            } else {
                npcHealth.set(cChoice, npcHealth.get(cChoice) - mDamage);
                System.out.println("    " + mName + " hit " + npcName.get(cChoice) + " and did " + mDamage + " damage!");
            }
        }
        if (!isCompDead(tName) && tankInParty) { // if tank is alive they attack a random enemy
            cChoice = rand.nextInt(npcName.size());
            cHitChance = rand.nextInt(20) + 1;
            if (cHitChance <= 11) {
                System.out.println("    "+tName+" missed!");
            } else {
                npcHealth.set(cChoice, npcHealth.get(cChoice) - tDamage);
                System.out.println("    " + tName + " hit " + npcName.get(cChoice) + " and did " + tDamage + " damage!");
            }
        }
        if (!isCompDead(rName) && rangeInParty) { // if ranged is alive they attack a random enemy (Should get expanded later to actually do ranged dmg)
            cChoice = rand.nextInt(npcName.size());
            cHitChance = rand.nextInt(20) + 1;
            if (cHitChance < 6) {
                System.out.println("    "+rName+" missed!");
            } else {
                npcHealth.set(cChoice, npcHealth.get(cChoice) - rDamage);
                System.out.println("    " + rName + " hit " + npcName.get(cChoice) + " and did " + rDamage + " damage!");
            }
        }
    }

    // Method for the combat menu
    static void combatMenu() {
        System.out.println("\n____________________________________________________________________________________________________\n");
        System.out.println("    The enemy is about to attack!\n"
            + "    What will "+pName+" do?\n\n"
            + "1. Keep fighting\n2. Use an item\n3. Try to run away\n"
        );

        playerSelection();
        switch (pSel) {
            case "2": useItem(); break;
            case "3": escapeCombat(); break;
            case "1":
            default: System.out.println("    The Enemy Attacks!\n");
        }
    }

    static int escapeChance;
    // Method for fleeing combat
    static void escapeCombat() {
        System.out.println("    "+pName+" tried to escape...");

        escapeChance = ((rand.nextInt(2)) + pSneak/10) + pLuck;

        if (escapeChance > 5) { // chance to escape increases with sneak
            System.out.println("    "+pName+" got away succesfully.");
            clearNPCs();
        } else {
            System.out.println("    But "+proObj+" didn't get away with it.");
        }
    }

    // Method that sets damage multiplier based on weapon type
    static void setDamageMultiplier(String pWeaponType) {
        if (pWeaponType.equals("Unarmed")) {
            pDmgMult = pUnarmedDmg;
        } else if (pWeaponType.equals("Bladed")) {
            pDmgMult = pBladeDmg;
        } else if (pWeaponType.equals("Blunt")) {
            pDmgMult = pBluntDmg;
        } else if (pWeaponType.equals("Heavy")) {
            pDmgMult = pHeavyDmg;
        } else if (pWeaponType.equals("Magic")) {
            pDmgMult = pMagicDmg;
        } else if (pWeaponType.equals("Ranged")) {
            pDmgMult = pRangedDmg;
        } else {
            pDmgMult = 0;
        }
    }

    // Method that sets damage resistances based on the enemy's damage type
    static void setDamageResistance(String eDmgType) {
        if (eDmgType.equals("Bladed")) {
            pDmgRes = pBladeRes;
        } else if (eDmgType.equals("Blunt")) {
            pDmgRes = pBluntRes;
        } else if (eDmgType.equals("Magic")) {
            pDmgRes = pMagicRes;
        } else if (eDmgType.equals("Poison")) {
            pDmgRes = pPoisonRes;
        } else if (eDmgType.equals("Fire")) {
            pDmgRes = pFireRes;
        } else if (eDmgType.equals("Frost")) {
            pDmgRes = pFrostRes;
        } else {
            pDmgRes = 0;
        }
    }

    // Add NPC to the lists
    static void addNPC(String name, int health, int damage, String dType, int exp, boolean hostile) {
        npcName.add(name);
        npcHealth.add(health);
        npcDamage.add(damage);
        npcDamageType.add(dType);
        npcExp.add(exp);
        npcHostile.add(hostile);
    }

    // Clear NPCs from area
    static void clearNPCs() {
        npcName.clear();
        npcHealth.clear();
        npcDamage.clear();
        npcExp.clear();
        npcHostile.clear();
    }

    // Method that populates the weapon arrays
    static void popWeaponArrays() {
        // Tier 1 Weapons
        t1Weapons.add("Fists");
        t1Weapons.add("Rusty Sword");
        t1Weapons.add("Wooden Hammer");
        t1Weapons.add("Sledgehammer");
        t1Weapons.add("Stick Wand");
        t1Weapons.add("Handmade Bow");

        // Tier 2 Weapons
        t2Weapons.add("Boxing Gloves");
        t2Weapons.add("War Sword");
        t2Weapons.add("Baseball Bat");
        t2Weapons.add("Woodsplitting Axe");
        t2Weapons.add("College of Sorcery Wand");
        t2Weapons.add("Ancient Longbow");

        // Tier 3 Weapons
        t3Weapons.add("Brass Knuckles");
        t3Weapons.add("Mass Produced Katana");
        t3Weapons.add("Mace");
        t3Weapons.add("Warworn Greatsword");
        t3Weapons.add("Crystal Staff");
        t3Weapons.add("Compound Bow");

        // Tier 4 Weapons
        t4Weapons.add("Push Daggers");
        t4Weapons.add("Claymore");
        t4Weapons.add("Flail");
        t4Weapons.add("Battleaxe");
        t4Weapons.add("Elfwood Wand");
        t4Weapons.add("Musket");

        // Tier 5 Weapons
        t5Weapons.add("Gunpowder Gloves");
        t5Weapons.add("Nekohito Steel Katana");
        t5Weapons.add("Veridian Warhammer");
        t5Weapons.add("Empirian Greatsword");
        t5Weapons.add("Archmage Staff");
        t5Weapons.add("Barronn M8-AY .50 Cal Anti-Matiriel Rifle");

        // populates the allWeapons Array
        allWeapons.add("Fists");
        allWeapons.add("Rusty Sword");
        allWeapons.add("Wooden Hammer");
        allWeapons.add("Sledgehammer");
        allWeapons.add("Stick Wand");
        allWeapons.add("Handmade Bow");
        allWeapons.add("Boxing Gloves");
        allWeapons.add("War Sword");
        allWeapons.add("Baseball Bat");
        allWeapons.add("Woodsplitting Axe");
        allWeapons.add("College of Sorcery Wand");
        allWeapons.add("Ancient Longbow");
        allWeapons.add("Brass Knuckles");
        allWeapons.add("Mass Produced Katana");
        allWeapons.add("Mace");
        allWeapons.add("Warworn Greatsword");
        allWeapons.add("Crystal Staff");
        allWeapons.add("Compound Bow");
        allWeapons.add("Push Daggers");
        allWeapons.add("Claymore");
        allWeapons.add("Flail");
        allWeapons.add("Battleaxe");
        allWeapons.add("Elfwood Wand");
        allWeapons.add("Musket");
        allWeapons.add("Gunpowder Gloves");
        allWeapons.add("Nekohito Steel Katana");
        allWeapons.add("Veridian Warhammer");
        allWeapons.add("Empirian Greatsword");
        allWeapons.add("Archmage Staff");
        allWeapons.add("Barronn M8-AY .50 Cal Anti-Matiriel Rifle");
    }

    // Method that determines if the item is a weapon
    static void isWeapon(String item) {
        System.out.println("\n____________________________________________________________________________________________________\n");
        System.out.println("    " + item + " is a weapon.");
        System.out.println("1. Equip Weapon\n2. Keep in inventory\n");

        playerSelection();
        switch(pSel) {
            case "1": setWeaponStats(item); break;
            case "2": System.out.println("    " + item + " was sent back to "+proPos+" inventory"); break;
            default: System.out.println("not possible"); isWeapon(item);
        }
    }

    // Method that sets the weapon type and damage
    static void setWeaponStats(String item) {
        if (!weaponEquipped) {
            if (allWeapons.contains(item)) {
                // Sets damage based on the tier
                if (t1Weapons.contains(item)) {
                    pWeaponDmg = 10;
                } else if (t2Weapons.contains(item)) {
                    pWeaponDmg = 20;
                } else if (t3Weapons.contains(item)) {
                    pWeaponDmg = 30;
                } else if (t4Weapons.contains(item)) {
                    pWeaponDmg = 40;
                } else if (t5Weapons.contains(item)) {
                    pWeaponDmg = 50;
                } else {
                    pWeaponDmg = 0; // if weapon is not found, no damage
                }

                // Sets weapon type
                if (item.equals("Fists") || item.equals("Boxing Gloves") || item.equals("Brass Knuckles") || item.equals("Push Daggers") || item.equals("Gunpowder Gloves")) {
                    pWeaponType = "Unarmed";
                } else if (item.equals("Rusty Sword") || item.equals("War Sword") || item.equals("Mass Produced Katana") || item.equals("Claymore") || item.equals("Nekohito Steel Katana")) {
                    pWeaponType = "Bladed";
                } else if (item.equals("Wooden Hammer") || item.equals("Baseball Bat") || item.equals("Mace") || item.equals("Flail") || item.equals("Veridian Warhammer")) {
                    pWeaponType = "Blunt";
                } else if (item.equals("Sledgehammer") || item.equals("Woodsplitting Axe") || item.equals("Warworn Greatsword") || item.equals("Battleaxe") || item.equals("Empirian Greatsword")) {
                    pWeaponType = "Heavy";
                } else if (item.equals("Stick Wand") || item.equals("College of Sorcery Wand") || item.equals("Crystal Staff") || item.equals("Elfwood Wand") || item.equals("Archmage Staff")) {
                    pWeaponType = "Magic";
                } else if (item.equals("Handmade Bow") || item.equals("Ancient Longbow") || item.equals("Compound Bow") || item.equals("Musket") || item.equals("Barronn M8-AY .50 Cal Anti-Matiriel Rifle")) {
                    pWeaponType = "Ranged";
                } else {
                    System.out.println("    What?");
                }
                pWeapon = item;
                weaponEquipped = true;
                System.out.println("    " + pName + " has equipped a " + pWeapon + "!");
                item = "";
            }

            pInvSpace -= 1;
        } else {
            System.out.println("    You already have a weapon. Do you want to drop your "+pWeapon+"?\n"
                + "\n1. Keep current weapon\n2. Drop " + pWeapon + "\n"
            );

            playerSelection();
            switch (pSel) {
                case "1": System.out.println("    " + pName + " kept " + proPos + " "+ pWeapon 
                        + ".\n    The " + item + " was sent to " + proPos +" inventory."
                    );
                    placeInInv(item);
                    break;
                case "2": System.out.println("    You dropped your " + pWeapon + " and it fell through the floor.");
                    weaponEquipped = false;
                    invItems.remove(pWeapon);
                    pWeapon = "none";
                    pWeaponDmg = 0;
                    pWeaponType = "none";
                    pInvSpace += 1;
                    setWeaponStats(item);
                    break;
                default: System.out.println("    Nope"); setWeaponStats(item);
            }
        }
    }

// --->   End of Combat Methods   <---



// --->   Leaving Function Junction   <---










// This should run everything
    public static void main(String args[]){

        popWeaponArrays();
        popLocList();

        System.out.println(welcomeMsg);

        characterSelection();

        System.out.println("\n\nThis is a statement (game loop ended)\n\n");

        addNPC("Silly Fella", 100, 10, "Blade", 100, true);
        addNPC("Goober", 100, 10, "Blunt", 100, true);
        pHealth -= 50;
        gotMad();

        // nightmare loop (for debugging ofc)
        for (int i = 0; i < 50; i++) {
            System.out.println("Nightmare");
        }

    }
}


