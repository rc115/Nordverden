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

    static String welcomeMsg = (
          "\n"
        + "\n    Welcome to"
        + "\n          __              _                   _            "
        + "\n       /\\ \\ \\___  _ __ __| |_   _____ _ __ __| | ___ _ __  "
        + "\n      /  \\/ / _ \\| '__/ _` \\ \\ / / _ \\ '__/ _` |/ _ \\ '_ \\ "
        + "\n     / /\\  / (_) | | | (_| |\\ V /  __/ | | (_| |  __/ | | |"
        + "\n     \\_\\ \\/ \\___/|_|  \\__,_| \\_/ \\___|_|  \\__,_|\\___|_| |_|"
        + "\n                                       Version 0.026.102724"
        + "\n" 
    );
//










// ----->   Function Junction   <-----



// --->   Misc. Methods   <---

    // Method that displays character's info
    static void displayCharacter() {
        System.out.println("    This is your character:\n"
            + "    Name: " + pName + " (" + proSub + "/" + proObj + "/" + proPos + ")\n"
            + "    Race: " + pRace + "\n"
            + "    Background: " + pBackground + "\n"
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

    // Method that tries to clear the player's screen (didn't work ill just ooga booga it)
    static void clearConsole() {
        System.out.println("\n____________________________________________________________________________________________________\n");
        System.out.println("Clearing Screen...");
        try {
            Thread.sleep(2000); // Waits 2 secs before clearing screen
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        for (int i = 0; i < 50; i++) {
            System.out.println("\n\n");
        }
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

        if (pSel.equals("admin")) {
            adminChar();
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
            + "\n    Background (" + pBackground +")"
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

    // --->   Admin Character for debugging   <---
    static void adminChar() {
        System.out.print("\n\nLogin: "
        );

        playerSelection();
        if (pSel.equals("Admin")) {
            System.out.print("Password: ");

            playerSelection();
            if (pSel.equals("Password")) {
                pName = "Admin"; proSub = pName; proObj = pName; proPos = (pName + "'s");
                pHealth = 1000; pMaxHealth = 1000;
                pGold = 1000; pCoins = 100000; pSchmeeps = 1000000;

                pRaceSet = true; pRace = "Admin";
                pVerdian = true;
                pEmpirian = true;
                pOrc = true;
                pCaveElf = true;
                pWoodElf = true;
                pNekohito = true; pNekoPassport = true;
                pDragonborn = true;
                pBackgroundSet = true; pBackground = "Admin";
                karmaSet = true;
                pStartEquip = true; equipWeapon("Dragonn KLR 20mm Anti-Matiriel Rifle");
                pStartLocation = true;
                conSkills = true; conResists = true; conDamage = true; conFinalStats = true;

                pStrenght = 100;
                pSpeech = 100;
                pStamina = 100;
                pSorcery = 100;
                pSneak = 100;

                pBladeRes = 1.0;
                pBluntRes = 1.0;
                pMagicRes = 1.0;
                pPoisonRes = 1.0;
                pFireRes = 1.0;
                pFrostRes = 1.0;

                pUnarmedDmg = 1.0;
                pBladeDmg = 1.0;
                pBluntDmg = 1.0;
                pHeavyDmg = 1.0;
                pMagicDmg = 1.0;
                pRangedDmg = 1.0;
            }
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
        if (invItems.isEmpty()) { // Cancels useItem method if Chara's inv is empty
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
            if (input.hasNextInt()) { // validates user's input to ensure its an int
                choice = input.nextInt();
                if (choice < 1 || choice > invItems.size()) { // checks if its in the range of items
                    System.out.println("Invalid choice. Please try again.");
                    useItem();
                } else if (choice == 0) {
                    break;
                }
            } else { // doesnt set choice if its not an integer
                System.out.println("That's not a valid number. Please try again.");
                input.next(); // Clear the invalid input
                useItem();
            }
        }

        String item = invItems.get(choice - 1); // sets item based on player's choice

        if (allWeapons.contains(item) && pWeapon != item){ // checks if the selected item is a weapon
            equipWeapon(item);
        }
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
    static String pArmour = "";

    // Method that equips Armour
    static void equipArmour() {
        if (!armourEquipped) {
            if (aLeather) {
                System.out.println("    " + pName + " has equipped Leather Armour\n");
                pArmour = "Leather Armour";
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
    static String pBackground = "";
    static String pLocation = "";


    static int pLives = 1; // ammount of lives the character has
    static int pLevel = 1; //character's level. +10 skill pointsMax lvl 46 (lvl 5 = 1000 total xp needed)
    static int pCurXp = 0; // current expirience points
    static int pNextLvl = (10*(pLevel*pLevel) + 90); // ammount of xp needed to level up
    static int pHealth = 100; // character's health
    static int pMaxHealth = 100;

    // Chara's reputation
    static int pKarma = 0; // (-10< [Bounty Hunters], <10[Mercenaries])
    // -10[kill on sight] < -5[locks quests] < 0[neutral] < 5[Allied] < 10[Special access]
    static int verdRep = 0;
    static int empiRep = 0;
    static int nekoRep = 0;
    static int wElfRep = 0;
    static int dElfRep = 0;

    static boolean tutComplete = false;
    static boolean pRaceSet = false; // var for if the player set their character's race
    static boolean pBackgroundSet = false; // var for if the player set their character's background
    static boolean karmaSet = false; // var for if the player set their character's karma
    static boolean pStartEquip = false; // var for if the player choose their starting equipment
    static boolean pStartLocation = false;

    // boolean variables for each race
    static boolean pVerdian = false;
    static boolean pEmpirian = false;
    static boolean pOrc = false;
    static boolean pCaveElf = false;
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
    static int cointToGold = 0; // (coinsToConvert/10) calculation for coin to gold conversion
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
                System.out.println("\n    These are your character stats:\n"

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
                    + "\n1. Continue\n2. Reset all Stats\n3. Reset Skills\n4. Reset Dmg Resistances\n5. Reset Dmg Multipliers\n"
                );

                playerSelection();
                switch (pSel) {
                    case "5": resetDmgMults(); break;
                    case "4": resetResists(); break;
                    case "3": resetSkills(); break;
                    case "2": resetAllStats(); break;
                    default:
                        conFinalStats = true;
                        break;
                }

            }
        }

        // lets player choose their character's background
        if (!pBackgroundSet){
            charBackgroundSel();
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
        if (conFinalStats && pBackgroundSet && pRaceSet && karmaSet && pStartEquip && !tutComplete) {
            System.out.println("\n____________________________________________________________________________________________________\n");
            System.out.println("    You have finished making your character!");

            displayCharacter();

            System.out.println("    Would you like to do the tutorial?\n");
            System.out.println("1. Do the tutorial\n2. Choose an alternate start\n");

            playerSelection();
            switch (pSel) {
                case "1": tutorial(); break;
                case "2": tutComplete = true; break;
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
            + "\n    Grottalv   - Great magic casters but both elf races are weaker than other races.\n"
            + "\n    Trealv     - Worse magic casters than Grottalver, but have a stronger community.\n"
            + "\n    Nekohito   - The peacful natives of Nekomura, a remote island to the east of Nordverden.\n"
            + "\n    Dragonborn - The rarest race in Nordverden, not much is known about them.\n"
        );
        System.out.println("\n____________________________________________________________________________________________________\n");
    }
    static void charRaceSel() {
        if (pRace.equals("")) {
            System.out.println("\n    Choose your character's Race\n"
                + "\n1. Verdian\n2. Empirian\n3. Orc\n4. Grottalv\n5. Trealv\n6. Nekohito\n7. Dragonborn\n8. View Info on Races\n"
            );

            playerSelection();
            switch(pSel) {
                case "1": pRace = "Verdian"; charRaceSet(); break;
                case "2": pRace = "Empirian"; charRaceSet(); break;
                case "3": pRace = "Orc"; charRaceSet(); break;
                case "4": pRace = "Grottalv"; charRaceSet(); break;
                case "5": pRace = "Trealv"; charRaceSet(); break;
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
        } else if (pRace.equals("Grottalv")) {
            pSorcery += 20;
            pFireRes += 0.25;
            pMagicRes += 0.75;
            pMaxHealth -= 30;
            pHealth -= 30;
            pCaveElf = true;
            System.out.println("\n    Your character is now a Grottalv");
        } else if (pRace.equals("Trealv")) {
            pSorcery += 10;
            pPoisonRes += 0.25;
            pSpeech += 10;
            pMaxHealth -= 30;
            pHealth -= 30;
            pWoodElf = true;
            System.out.println("\n    Your character is now a Trealv");
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
                } else if (pRace.equals("Grottalv")) {
                    pSorcery -= 20;
                    pFireRes -= 0.25;
                    pMagicRes -= 0.75;
                    pMaxHealth += 30;
                    pHealth += 30;
                    pCaveElf = false;
                } else if (pRace.equals("Trealv")) {
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

    // Methods for choosing the character's background
    static void viewBackgroundInfo() {
        System.out.println("\n____________________________________________________________________________________________________\n");
        System.out.println("\n    These are all the backgrounds you can choose:\n"
            + "\n    Villager - Non-combat focused and starts with +15 speech and +3 gold\n"
            + "\n    Warrior  - Great for beginners, starts with +15 strenght and a rusty sword\n"
            + "\n    Tank     - Good at soaking up damage, +1.0 Res. to Blade & Blunt Damage\n"
            + "\n    Mage     - Great start for magic builds, starts with +15 sorcery and a wand\n"
            + "\n    Archer   - Good for \"Stealth-Sniper\" Builds, starts with +15 Sneak and a handmade bow\n"
            + "\n    Gambler  - Starts with +1 luck but also has -3 gold\n"
        );
        System.out.println("\n____________________________________________________________________________________________________\n");

    }
    static void charBackgroundSel() {
        System.out.println("\n____________________________________________________________________________________________________\n");

        if (pBackground.equals("")) {
            System.out.println("\n    Choose your character's background\n"
                + "\n1. Villager\n2. Warrior\n3. Tank\n4. Mage\n5. Archer\n6. Gambler\n7. View Background info\n"
            );
            
            playerSelection();
            switch(pSel) {
                case "1": pBackground = "Villager"; charBackgroundSet(); break;
                case "2": pBackground = "Warrior"; charBackgroundSet(); break;
                case "3": pBackground = "Tank"; charBackgroundSet(); break;
                case "4": pBackground = "Mage"; charBackgroundSet(); break;
                case "5": pBackground = "Archer"; charBackgroundSet(); break;
                case "6": pBackground = "Gambler"; charBackgroundSet(); break;
                case "7": viewBackgroundInfo(); charBackgroundSel(); break;
                default: System.out.println("\n        Try again"); charBackgroundSel();
            }
        } else {
            System.out.println("\n        No clue what you did\n");
        }

        System.out.println("\n____________________________________________________________________________________________________\n");
    }
    static void charBackgroundSet() {
        if (pBackground.equals("Villager")) {
            pSpeech += 15;
            pGold += 3;
            System.out.println("\n    Your character is now a Vilager.\n");
        } else if (pBackground.equals("Warrior")) {
            pStrenght += 15;
            equipWeapon("Rusty Sword");
            placeInInv("Rusty Sword");
            System.out.println("\n    Your character is now a Warrior.\n");
        } else if (pBackground.equals("Tank")) {
            pBladeRes += 1;
            pBluntRes += 1;
            System.out.println("\n    Your character is now a Tank.\n");
        } else if (pBackground.equals("Mage")) {
            pSorcery += 15;
            equipWeapon("Stick Wand");
            placeInInv("Stick Wand");
            System.out.println("\n    Your character is now a Mage.\n");
        } else if (pBackground.equals("Archer")) {
            pSneak += 15;
            equipWeapon("Handmade Bow");
            placeInInv("Handmade Bow");
            System.out.println("\n    Your character is now a Archer.\n");
        } else if (pBackground.equals("Gambler")) {
            pLuck += 1;
            pGold -= 3;
            System.out.println("\n    Your character is now a Gambler.\n");
        } else {
            System.out.println("How did you do that?");
        }

        System.out.println("\n1. Confirm Background\n2. Reset Background\n");
        playerSelection();
        switch(pSel) {
            case "1": pBackgroundSet = true; customizeStats(); break;
            case "2": 
                if (pBackground.equals("Villager")) {
                    pSpeech -= 15;
                    pGold -= 3;
                } else if (pBackground.equals("Warrior")) {
                    pStrenght -= 15;
                    pInvSpace += 1;
                    equipWeapon("");
                    invItems.remove("Rusty Sword");
                } else if (pBackground.equals("Tank")) {
                    pBladeRes -= 1;
                    pBluntRes -= 1;
                } else if (pBackground.equals("Mage")) {
                    pSorcery -= 15;
                    pInvSpace += 1;
                    invItems.remove("Stick Wand");
                } else if (pBackground.equals("Archer")) {
                    pSneak -= 15;
                    pInvSpace += 1;
                    invItems.remove("Handmade Bow");
                } else if (pBackground.equals("Gambler")) {
                    pLuck -= 1;
                    pGold += 3;
                } else {
                    System.out.println("How did you do that?");
                }

                pBackground = "";
                pBackgroundSet = false;
                charBackgroundSel();
                break;
            default: System.out.println("Nuh uh"); charBackgroundSet();
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
        System.out.println("\n1. Rusty Sword\n2. Wooden Club\n3. Handmade Bow\n4. Stick Wand"
            + "\n5. Leather Armour\n6. Stamina Potion\n7. Health Potion\n8. Small Bag\n9. Gold Sack\n"
        );

        playerSelection();
        switch(pSel) {
            case "1":
                equipWeapon("Rusty Sword");
                placeInInv("Rusty Sword");
                break;
            case "2":
                equipWeapon("Wooden Club");
                placeInInv("Wooden Club");
                break;
            case "3":
                equipWeapon("Handmade Bow");
                placeInInv("Handmade Bow");
                break;
            case "4":
                equipWeapon("Stick Wand");
                placeInInv("Stick Wand");
                break;
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
            + "\n    Note: Some locations are not recommended for certain builds.\n"
        );
        System.out.println("\n1. River\n2. Desert\n3. Nekomura\n4. Orc Territory"
            + "\n5. Barbarian Territory\n6. View Character\n"
        );

        playerSelection();
        switch(pSel) {
            case "1":
                System.out.println("    " + pName + " hears the sounds of running water nearby.\n");
                charaLocator("River");
                break;
            case "2":
                System.out.println("    The schorching heat causes sweat to bead on " + pName + "'s face.\n");
                charaLocator("Desert");
                break;
            case "3":
                System.out.println("    " + pName + " got on a boat headed to Nekomura.\n");
                charaLocator("Nekomura");
                break;
            case "4":
                System.out.println("    " + pName + " has wandered into orc territory.\n");
                charaLocator("Orcs");
                break;
            case "5":
                System.out.println("    " + pName + " stumbled into barbarian territory.\n");
                charaLocator("Barbarians");
                break;
            case "6": displayCharacter(); startingLocation(); break;
            default: System.out.println("Cant"); startingLocation();
        }

        pStartLocation = true;
        customizeStats();
    }

// --->   End of Character Creator   <---










// --->   Leveling System   <---

    // Function that handles the xp curve (gets progressively harder to level up)
    static int levelCurve() {
        return 10 * (pLevel * pLevel) + 90;
    }

    // Method that levels Chara up if they have enough xp
    static void levelUp() {
        while (pCurXp >= pNextLvl && pLevel < 46) { // while loop makes sure Chara can level up more than once
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
        System.out.println("1. Strenght\n2. Speech\n3. Stamina\n4. Sorcery\n5. Sneak\n");

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

    static int randEncounter = 0;
    // Funtion that lets player choose where to go (Probably not the best way to do it)
    static void pMover(String pLocation) {
        if (pLocation.equals("Capital")){
            System.out.println("    Kronebyen is the capital of Nordverden.\n"
                + "\n(w) North"
                + "\n(e) Northeast"
                + "\n(d) East"
                + "\n(c) Southeast"
                + "\n(x) South"
                + "\n(z) Southwest"
                + "\n(a) West"
                + "\n(q) Northwest"
                + "\n\n1. Go to Kronebyen.\n"
            );

            playerSelection();
            switch(pSel) {
                case "w": // Keeps Chara in Capital
                    System.out.println("    North");
                    pMover(pLocation);
                    break;
                case "e": // Sends Chara to CoS
                    System.out.println("    "+pName+" goes Northeast.");
                    charaLocator("College");
                    break;
                case "d": // Sends Chara to the Forrest
                    System.out.println("    "+pName+" goes East");
                    charaLocator("Forrest");
                    break;
                case "c": // Sends Chara to Orc Ter
                    System.out.println("    "+pName+" goes Southeast");
                    charaLocator("Orcs");
                    break;
                case "x": // Sends Chara to the Desert
                    System.out.println("    "+pName+" goes South");
                    charaLocator("Desert");
                    break;
                case "z": // Sends Chara to the River
                    System.out.println("    "+pName+" goes Southwest");
                    charaLocator("River");
                    break;
                case "a": // Sends Chara to the Northern Cave
                    System.out.println("    "+pName+" goes West");
                    northCave();
                    break;
                case "q": // Keeps Chara in Capital
                    System.out.println("    Northwest");
                    pMover(pLocation);
                    break;
                case "1": // Sends Chara to the capital room
                    System.out.println("    "+pName+" went to Kronebyen");
                    capitalCity(true);
                    break;
                default:
                    System.out.println("Cant go there");
                    pMover(pLocation);
            }
        } else if (pLocation.equals("Nekomura")) {
            System.out.println("    Nekomura is a remote island to the east of Nordverden.\n"
                + "\n(w) North"
                + "\n(e) Northeast"
                + "\n(d) East"
                + "\n(c) Southeast"
                + "\n(x) South"
                + "\n(z) Southwest"
                + "\n(a) West"
                + "\n(q) Northwest"
                + "\n\n1. Go to Keji City.\n"
            );

            playerSelection();
            switch(pSel) {
                // Only way to go back is by heading Northwest
                case "w": 
                case "e":
                case "d":
                case "c":
                case "x":
                case "z":
                case "a":
                    System.out.println("    "+pName+" is on a remote Island, head Northwest to go back to the mainland.\n");
                    pMover("Nekomura");
                    break;
                case "q": // Sends Chara to the Coast
                    System.out.println("    "+pName+" went back to Nordverden.\n");
                    charaLocator("Coast");
                    break;
                case "1": // Sends Chara to the Keji city
                    System.out.println("    "+pName+" went towards Keji City.");
                    nekoCity(true);
                    break;
                default:
                    System.out.println("Can't go there.");
                    pMover(pLocation);
            }
        } else if (pLocation.equals("Desert")) {
            System.out.println("    The Desert is in the center of Nordverden.\n"
                + "\n(w) North"
                + "\n(e) Northeast"
                + "\n(d) East"
                + "\n(c) Southeast"
                + "\n(x) South"
                + "\n(z) Southwest"
                + "\n(a) West"
                + "\n(q) Northwest"
                + "\n\n1. Go to Rattensby\n"
            );

            playerSelection();
            switch(pSel) {
                case "w": // Sends Chara to the Capital
                    System.out.println("    "+pName+" goes North.");
                    charaLocator("Capital");
                    break;
                case "e": // Sends Chara to the Forrest
                    System.out.println("    "+pName+" goes Northeast.");
                    charaLocator("Forrest");
                    break;
                case "d": // Sends Chara to Orc Ter
                    System.out.println("    "+pName+" goes East.");
                    charaLocator("Orcs");
                    break;
                case "c": // Sends Chara to the Plains
                    System.out.println("    "+pName+" goes Southeast.");
                    charaLocator("Plains");
                    break;
                case "x": // Sends Chara to Barbarian Ter
                    System.out.println("    "+pName+" goes South.");
                    charaLocator("Barbarians");
                    break;
                case "z": // Sends Chara to the Mountains
                    System.out.println("    "+pName+" goes Southwest.");
                    charaLocator("Mountains");
                    break;
                case "a": // Sends Chara to the Desert Village
                    System.out.println("    "+pName+" goes West.");
                    desVillage();
                    break;
                case "q": // Sends Chara to the River
                    System.out.println("    "+pName+" goes Northwest.");
                    charaLocator("River");
                    break;
                case "1": // Sends Chara to the Desert city
                    System.out.println("    "+pName+" went to Rattensby.");
                    rotCity(true);
                    break;
                default:
                    System.out.println("Can't go there.");
                    pMover(pLocation);
            }
        } else if (pLocation.equals("Barbarians")) {
            randEncounter = rand.nextInt(20) + 1;
            if (randEncounter == 20) {
                System.out.println("    " + pName + " was ambushed!");
                addNPC("Barbarian Leader", 200, 30, "Bladed", 100, true);
                addNPC("Barbarian Bruiser", 100, 20, "Blunt", 30, true);
                addNPC("Barbarian", 100, 10, "Bladed", 10, true);
                addNPC("Barbarian", 100, 10, "Bladed", 10, true);
                gotMad();
            } else if (randEncounter >= 15) {
                System.out.println("    " + pName + " was ambushed!");
                addNPC("Barbarian Bruiser", 100, 20, "Blunt", 30, true);
                addNPC("Barbarian", 100, 10, "Bladed", 10, true);
                addNPC("Barbarian", 100, 10, "Bladed", 10, true);
                gotMad();
            } else if (randEncounter > 10) {
                System.out.println("    " + pName + " was ambushed!");
                addNPC("Barbarian Scout", 75, 15, "Bladed", 25, true);
                addNPC("Barbarian Scout", 75, 10, "Bladed", 25, true);
                gotMad();
            }

            System.out.println("    Barbarian territory is controled by outlaws.\n"
                + "\n(w) North"
                + "\n(e) Northeast"
                + "\n(d) East"
                + "\n(c) Southeast"
                + "\n(x) South"
                + "\n(z) Southwest"
                + "\n(a) West"
                + "\n(q) Northwest"
                + "\n\n1. Try to go to the Barbarian camp.\n"
            );

            playerSelection();
            switch(pSel) {
                case "w": // Sends Chara to the Desert
                    System.out.println("    "+pName+" goes North.");
                    charaLocator("Desert");
                    break;
                case "e": // Sends Chara to Orc Ter
                    System.out.println("    "+pName+" goes Northeast.");
                    charaLocator("Orcs");
                    break;
                case "d": // Sends Chara to the Plains
                    System.out.println("    "+pName+" goes East.");
                    charaLocator("Plains");
                    break;
                case "c":
                case "x":
                case "z": // Keeps Chara in Barb Ter
                    System.out.println("    " + pName + "cant go there.");
                    pMover("Barbarians");
                    break;
                case "a": // Sends Chara to the Plains Village
                    System.out.println("    "+pName+" goes West.");
                    plainsVillage();
                    break;
                case "q": // Sends Chara to the Mountains
                    System.out.println("    "+pName+" goes Northwest.");
                    charaLocator("Mountains");
                    break;
                case "1": // Sends Chara to the Barbarian Camp
                    System.out.println("    "+pName+" went to the Barbarian camp.");
                    barCamp();
                    break;
                default:
                    System.out.println("Can't go there.");
                    pMover(pLocation);
            }
        } else if (pLocation.equals("Colony")) {
            System.out.println("    The Empire established a colony on the west coast of Nordverden.\n"
            + "\n(w) North"
            + "\n(e) Northeast"
            + "\n(d) East"
            + "\n(c) Southeast"
            + "\n(x) South"
            + "\n(z) Southwest."
            + "\n(a) West."
            + "\n(q) Northwest."
            + "\n\n1. Go to {tempEmpCity}.\n"
            );

            playerSelection();
            switch(pSel) {
                case "w": // Sends Chara to the Northern Cave
                    System.out.println("    "+pName+" goes North.");
                    northCave();
                    break;
                case "e": // Sends Chara to the River
                    System.out.println("    "+pName+" goes Northeast.");
                    charaLocator("River");
                    break;
                case "d": // Sends Chara to the Desert
                    System.out.println("    "+pName+" goes East.");
                    charaLocator("Desert");
                    break;
                case "c": // Sends Chara to the Mountains
                    System.out.println("    "+pName+" goes Southeast.");
                    charaLocator("Mountains");
                    break;
                case "x": // Sends Chara to the Southern Cave
                    System.out.println("    "+pName+" goes South.");
                    southCave();
                    break;
                case "z":
                case "a":
                case "q": // Keeps Chara in the Colony
                    System.out.println("    " + pName + " cant go there.");
                    pMover("Colony");
                    break;
                case "1": // Sends Chara to the Empirian City
                    System.out.println("    "+pName+" went to {tempEmpColony}.");
                    colonyCity(true);
                    break;
                default:
                    System.out.println("Can't go there.");
                    pMover(pLocation);
            }
        } else if (pLocation.equals("River")) {
            System.out.println("    The River is the main food source of the capital.\n"
                + "\n(w) North"
                + "\n(e) Northeast"
                + "\n(d) East"
                + "\n(c) Southeast"
                + "\n(x) South"
                + "\n(z) Southwest"
                + "\n(a) West"
                + "\n(q) Northwest"
                + "\n\n1. Go to Elvsm\u00E5stad.\n"
            );

            playerSelection();
            switch(pSel) {
                case "w": // Sends Chara to the Capital
                    System.out.println("    "+pName+" goes North.");
                    charaLocator("Capital");
                    break;
                case "e": // Sends Chara to the Capital
                    System.out.println("    "+pName+" goes Northeast.");
                    charaLocator("Capital");
                    break;
                case "d": // Sends Chara to the Forrest
                    System.out.println("    "+pName+" goes East.");
                    charaLocator("Forrest");
                    break;
                case "c": // Sends Chara to the Desert
                    System.out.println("    "+pName+" goes Southeast");
                    charaLocator("Desert");
                    break;
                case "x": // Sends Chara to the Mountains
                    System.out.println("    "+pName+" goes South");
                    charaLocator("Mountains");
                    break;
                case "z": // Sends Chara to the Desert Village
                    System.out.println("    "+pName+" goes Southwest.");
                    desVillage();
                    break;            
                case "a": // Sends Chara to the Colony
                    System.out.println("    "+pName+" goes West.");
                    charaLocator("Colony");
                    break;
                case "q": // Sends Chara to the Northern Cave
                    System.out.println("    "+pName+" goes Northwest.");
                    northCave();
                    break;
                case "1":
                    System.out.println("    "+pName+" went to Elvsm\u00E5stad.");
                    riverVillage();
                    break;
                default:
                    System.out.println("Can't go there.");
                    pMover(pLocation);
            }
        } else if (pLocation.equals("Orcs")) {
            randEncounter = rand.nextInt(20) + 1;
            if (randEncounter == 20) {
                System.out.println("    " + pName + " was ambushed!");
                addNPC("Orc Leeda", 300, 30, "Blunt", 200, true);
                addNPC("Orc Basha", 200, 20, "Blunt", 100, true);
                addNPC("Orc Smasha", 150, 10, "Blunt", 50, true);
                addNPC("Orc Stabba", 150, 10, "Bladed", 50, true);
                gotMad();
            } else if (randEncounter >= 15) {
                System.out.println("    " + pName + " was ambushed!");
                addNPC("Orc Smasha", 150, 10, "Blunt", 50, true);
                addNPC("Orc Stabba", 150, 10, "Bladed", 50, true);
                addNPC("Orc Smasha", 150, 10, "Blunt", 50, true);
                gotMad();
            }

            System.out.println("    Orc Territory is a large mountain occupied by Orcs.\n"
                + "\n(w) North"
                + "\n(e) Northeast"
                + "\n(d) East"
                + "\n(c) Southeast"
                + "\n(x) South"
                + "\n(z) Southwest"
                + "\n(a) West"
                + "\n(q) Northwest"
                + "\n\n1. Try to enter the Orc Camp.\n"
            );

            playerSelection();
            switch(pSel) {
                case "w": // Sends Chara to the College
                    System.out.println("    "+pName+" goes North");
                    charaLocator("College");
                    break;
                case "e": // Sends Chara to the Forrest
                    System.out.println("    "+pName+" goes Northeast.");
                    charaLocator("Forrest");
                    break;
                case "d": // Sends Chara to the Coast
                    System.out.println("    "+pName+" goes East");
                    charaLocator("Coast");
                    break;
                case "c": // Sends Chara to the Lake
                    System.out.println("    "+pName+" goes Southeast");
                    nordLake();
                    break;
                case "x": // Sends Chara to the Plains
                    System.out.println("    "+pName+" goes South");
                    charaLocator("Plains");
                    break;
                case "z": // Sends Chara to Barb Ter
                    System.out.println("    "+pName+" goes Southwest");
                    charaLocator("Barbarians");
                    break;
                case "a": // Sends Chara to the Desert
                    System.out.println("    "+pName+" goes West");
                    charaLocator("Desert");
                    break;
                case "q": // Sends Chara to the Capital
                    System.out.println("    "+pName+" goes Northwest");
                    charaLocator("Capital");
                    break;
                case "1": // Sends Chara to the Orc Camp
                    System.out.println("    "+pName+" tried to go to the Orc Camp");
                    orcCamp();
                    break;
                default:
                    System.out.println("Cant go there");
                    pMover(pLocation);
            }
        } else if (pLocation.equals("Coast")) {
            System.out.println("    The East Coast is the only way to get to Nekomura.\n"
                + "\n(w) North"
                + "\n(e) Northeast"
                + "\n(d) East"
                + "\n(c) Southeast"
                + "\n(x) South"
                + "\n(z) Southwest"
                + "\n(a) West"
                + "\n(q) Northwest"
                + "\n\n1. Go to Fiskeaktig\n"
            );

            playerSelection();
            switch(pSel) {
                case "w": // Sends Chara to the Eastern caves
                    System.out.println("    "+pName+" goes North");
                    eastCave();
                    break;
                case "d": // Sends Chara to Nekomura
                    System.out.println("    "+pName+" goes East");
                    charaLocator("Nekomura");
                    break;
                case "e":
                case "c":
                case "x": // Keeps Chara in the Coast
                    System.out.println("    " + pName + " cant go there. Boasts headed to Nekomura are to the East.");
                    pMover("Coast");
                    break;
                case "z": // Sends Chara to the lake
                    System.out.println("    "+pName+" goes Southwest");
                    nordLake();
                    break;
                case "a": // Sends Chara to Orc Ter
                    System.out.println("    "+pName+" goes West");
                    charaLocator("Orcs");
                    break;
                case "q": // Sends Chara to the Forrest
                    System.out.println("    "+pName+" goes Northwest");
                    charaLocator("Forrest");
                    break;
                case "1":
                    System.out.println("    "+pName+" went to Fiskeaktig");
                    coastVill();
                    break;
                default:
                    System.out.println("Cant go there");
                    pMover(pLocation);
            }
        } else if (pLocation.equals("Plains")) {
            randEncounter = rand.nextInt(20) + 1;
            if (randEncounter >= 15) {
                System.out.println("    " + pName + " was ambushed!");
                System.out.println("Barbarian Thief: Gimme all your coin and I wont put this sword in your spine.\n");
                System.out.println("1. Give the thief all your gold\n2. Fight the thief\n");
                
                playerSelection();
                switch (pSel) {
                    case "1":
                        System.out.println("    " + pName + " was robbed!");
                        pGold = 0;
                        break;
                    default:
                        addNPC("Barbarian Thief", 80, 20, "Bladed", 30, true);
                        addNPC("Barbarian Hooligan", 70, 10, "Bladed", 20, true);
                        gotMad();
                }
            } else if (randEncounter >= 10) {
                System.out.println("    " + pName + " was ambushed!");

                addNPC("Orc", 150, 20, "Blunt", 50, true);
                gotMad();
            }

            System.out.println("    The Plains are fertile lands but are dangerous due to the proximity to Orcs and Barbarians.\n"
                + "\n(w) North"
                + "\n(e) Northeast"
                + "\n(d) East"
                + "\n(c) Southeast"
                + "\n(x) South"
                + "\n(z) Southwest"
                + "\n(a) West"
                + "\n(q) Northwest"
                + "\n\n1. "+pName+" go to the Plains Town.\n"
            );

            playerSelection();
            switch(pSel) {
                case "w": // Sends Chara to Orc Ter
                    System.out.println("    "+pName+" goes North.");
                    charaLocator("Orcs");
                    break;
                case "e": // Sends Chara to the Lake
                    System.out.println("    "+pName+" goes Northeast.");
                    nordLake();
                    break;
                case "d": // Sends Chara to the Coast
                    System.out.println("    "+pName+" goes East.");
                    charaLocator("Coast");
                    break;
                case "c":
                case "x":
                case "z": // Keeps Chara in the Plains
                    System.out.println("    cant go there.");
                    pMover("Plains");
                    break;
                case "a": // Sends Chara to Barb Ter
                    System.out.println("    "+pName+" goes West.");
                    charaLocator("Barbarians");
                    break;
                case "q": // Sends Chara to the Desert
                    System.out.println("    "+pName+" goes Northwest.");
                    charaLocator("Desert");
                    break;
                case "1": // Sends Chara to the Plains City
                    System.out.println("    "+pName+" went to {tempPlainsTown}.");
                    plainsCity(true);
                    break;
                default:
                    System.out.println("Can't go there.");
                    pMover("Plains");
            }
        } else if (pLocation.equals("Forrest")) {
            System.out.println("    The Forrest is rumoured to hide the remaining Trealv civilization."
                + "\n(w) North"
                + "\n(e) Northeast"
                + "\n(d) East"
                + "\n(c) Southeast"
                + "\n(x) South"
                + "\n(z) Southwest"
                + "\n(a) West"
                + "\n(q) Northwest"
                + "\n\n1. Try to find the hidden forrest.\n"
            );

            playerSelection();
            switch(pSel) {
                case "w": // Keeps Chara in the Forrest
                    System.out.println("    "+pName+" cant go North");
                    pMover("Forrest");
                    break;
                case "e": // Sends Chara to the Forrest
                    System.out.println("    Northeast.");
                    pMover("Forrest");
                    break;
                case "d": // Sends Chara to the Eastern Cave
                    System.out.println("    "+pName+" goes East.");
                    eastCave();
                    break;
                case "c": // Sends Chara to the Coast
                    System.out.println("    "+pName+" goes Southeast.");
                    charaLocator("Coast");
                    break;
                case "x": // Sends Chara to Orc Ter
                    System.out.println("    "+pName+" goes South.");
                    charaLocator("Orcs");
                    break;
                case "z": // Sends Chara to the Desert
                    System.out.println("    "+pName+" goes Southwest.");
                    charaLocator("Desert");
                    break;
                case "a": // Sends Chara to the Capital
                    System.out.println("    "+pName+" goes West.");
                    charaLocator("Capital");
                    break;
                case "q": // Sends Chara to the CoS
                    System.out.println("    "+pName+" goes Northwest.");
                    charaLocator("College");
                    break;
                case "1": // Sends Chara to the Hidden Forrest if they have a key
                    System.out.println("    "+pName+" walks around for a while.");
                    if (pForrestKey){
                        System.out.println("    The key begins to glow... "
                            + pName + " is transported into the hidden forrest."
                        );
                        hiddenForrest(true);
                    } else {
                        System.out.println("    But "+proObj+" didn't find anything");
                    }
                    break;
                default:
                    System.out.println("Can't go there.");
                    pMover("Forrest");
            }
        } else if (pLocation.equals("Mountains")) {
            System.out.println("    The Great Mountains were a crystal mine before the Grottalv moved in."
                + "\n(w) North"
                + "\n(e) Northeast"
                + "\n(d) East"
                + "\n(c) Southeast"
                + "\n(x) South"
                + "\n(z) Southwest"
                + "\n(a) West"
                + "\n(q) Northwest"
                + "\n\n1. Enter the crystal mine.\n"
            );

            playerSelection();
            switch(pSel) {
                case "w": // Sends Chara to the River
                    System.out.println("    "+pName+" goes North.");
                    charaLocator("River");
                    break;
                case "e": // Sends Chara to the Desert
                    System.out.println("    "+pName+" goes Northeast.");
                    charaLocator("Desert");
                    break;
                case "d": // Sends Chara to Orc Ter
                    System.out.println("    "+pName+" goes East.");
                    charaLocator("Orcs");
                    break;
                case "c": // Sends Chara to Barb Ter
                    System.out.println("    "+pName+" goes Southeast.");
                    charaLocator("Barbarians");
                    break;
                case "x": // Sends Chara to the Plains village
                    System.out.println("    "+pName+" goes South.");
                    plainsVillage();
                    break;
                case "z": // Sends Chara to the Southern Cave
                    System.out.println("    "+pName+" goes Southwest.");
                    southCave();
                    break;
                case "a": // Sends Chara to the Colony
                    System.out.println("    "+pName+" goes West.");
                    charaLocator("Colony");
                    break;
                case "q": // Sends Chara to the Desert village
                    System.out.println("    "+pName+" goes Northwest.");
                    desVillage();
                    break;
                case "1": // Sends Chara to the Great Cave
                    System.out.println("    "+pName+" went into the cave.");
                    greatCave(true);
                    break;
                default:
                    System.out.println("Can't go there.");
                    pMover("Mountains");
            }
        } else if (pLocation.equals("College")) {
            System.out.println("    The College of Sorcery only accepts the best mages."
                + "\n(w) North"
                + "\n(e) Northeast"
                + "\n(d) East"
                + "\n(c) Southeast"
                + "\n(x) South"
                + "\n(z) Southwest"
                + "\n(a) West"
                + "\n(q) Northwest"
                + "\n\n1. Apply to the College of Sorcery\n"
            );

            playerSelection();
            switch(pSel) {
                case "w":
                case "e": // Keeps Chara in the CoS
                    System.out.println("    cant go there.");
                    pMover("College");
                    break;
                case "d": // Sends Chara to the Forrest
                    System.out.println("    "+pName+" goes East.");
                    charaLocator("Forrest");
                    break;
                case "c": // Sends Chara to the Forrest
                    System.out.println("    "+pName+" goes Southeast.");
                    charaLocator("Forrest");
                    break;
                case "x": // Sends Chara to Orc Ter
                    System.out.println("    "+pName+" goes South.");
                    charaLocator("Orcs");
                    break;
                case "z": // Sends Chara to the Desert
                    System.out.println("    "+pName+" goes Southwest.");
                    charaLocator("Desert");
                    break;
                case "a": // Sends Chara to the Capital
                    System.out.println("    "+pName+" goes West.");
                    charaLocator("Capital");
                    break;
                case "q": // Keeps Chara in the CoS
                    System.out.println("    " + pName + " cant go Northwest.");
                    pMover("College");
                    break;
                case "1":
                    System.out.println("    " + pName + " went to the College of Sorcery");
                    college();
                    break;
                default:
                    System.out.println("Can't go there.");
                    pMover("College");
            }
        } else if (pLocation.equals("Void")) {
            System.out.println("Mysterious Traveler: How did you end up here?\n");
            while (true) {
                System.out.println("    " + pName + " screams but nothing comes out...");
                playerSelection();
            }
        } else {
            System.out.println("\n\nGo to the void!\n\n");
            pMover("Void");
        }
    }

    // Method that determines the player's location
    static void charaLocator(String Location) {
        clearConsole();
        if (locList.contains(Location)) { // Ascii art generated by https://www.patorjk.com/software/taag/#p=display&f=Ogre&t=Nordverden &
            if (Location.equals("Capital")) {
                System.out.println("\n____________________________________________________________________________________________________\n");
                System.out.println("    " + pName + " is in the:\n");
                System.out.println(     " _   __                    _                      \n" +
                                        "| | / / __ ___  _ __   ___| |__  _   _  ___ _ __  \n" +
                                        "| |/ / '__/ _ \\| '_ \\ / _ \\ '_ \\| | | |/ _ \\ '_ \\ \n" +
                                        "|   <| | | (_) | | | |  __/ |_) | |_| |  __/ | | |\n" +
                                        "|_|\\_\\_|  \\___/|_| |_|\\___|_.__/ \\__, |\\___|_| |_|\n" +
                                        "                                 |___/            "
                );
                System.out.println("\n____________________________________________________________________________________________________\n");
                pLocation = Location;
            } else if (Location.equals("Nekomura")) {
                nekoCheckpoint();
            } else if (Location.equals("Desert")) {
                System.out.println("\n____________________________________________________________________________________________________\n");
                System.out.println("    " + pName + " is in the:\n");
                System.out.println(".#####...######...####...######..#####...######.\n" +
                                        ".##..##..##......##......##......##..##....##...\n" +
                                        ".##..##..####.....####...####....#####.....##...\n" +
                                        ".##..##..##..........##..##......##..##....##...\n" +
                                        ".#####...######...####...######..##..##....##...\n" +
                                        "................................................"
                );
                System.out.println("\n____________________________________________________________________________________________________\n");
                pLocation = Location;
            } else if (Location.equals("Barbarians")) {
                System.out.println("\n____________________________________________________________________________________________________\n");
                System.out.println("    " + pName + " is in:\n");
                System.out.println("___  ___  ____ ___  ___  ____ ____ ___  __   \n" +
                                        "| .\\ |  \\ | . \\| .\\ |  \\ | . \\|___\\|  \\ | \\|\\\n" +
                                        "| .<_| . \\|  <_| .<_| . \\|  <_| /  | . \\|  \\|\n" +
                                        "|___/|/\\_/|/\\_/|___/|/\\_/|/\\_/|/   |/\\_/|/\\_/\n" +
                                        "____ ____ ____ ____ ____ ____ ____ ____ _    \n" +
                                        "|_ _\\| __\\| . \\| . \\|___\\|_ _\\|   || . \\||_/\\\n" +
                                        "  || |  ]_|  <_|  <_| /    || | . ||  <_| __/\n" +
                                        "  |/ |___/|/\\_/|/\\_/|/     |/ |___/|/\\_/|/   "
                );
                System.out.println("\n____________________________________________________________________________________________________\n");
                pLocation = Location;
            } else if (Location.equals("Colony")) {
                System.out.println("\n____________________________________________________________________________________________________\n");
                System.out.println("    " + pName + " is in the:\n");
                System.out.println(" _______             _       _                 ______      _                   \n" +
                                        "(_______)           (_)     (_)               / _____)    | |                  \n" +
                                        " _____   ____  ____  _  ____ _  ____ ____    | /      ___ | | ___  ____  _   _ \n" +
                                        "|  ___) |    \\|  _ \\| |/ ___) |/ _  |  _ \\   | |     / _ \\| |/ _ \\|  _ \\| | | |\n" +
                                        "| |_____| | | | | | | | |   | ( ( | | | | |  | \\____| |_| | | |_| | | | | |_| |\n" +
                                        "|_______)_|_|_| ||_/|_|_|   |_|\\_||_|_| |_|   \\______)___/|_|\\___/|_| |_|\\__  |\n" +
                                        "              |_|                                                       (____/ "
                );
                System.out.println("\n____________________________________________________________________________________________________\n");
                pLocation = Location;
            } else if (Location.equals("River")) {
                System.out.println("\n____________________________________________________________________________________________________\n");
                System.out.println("    " + pName + " is near the:\n");
                System.out.println("   _  _  _  _        _                                                  \n" +
                                        "  (_)(_)(_)(_) _    (_)                                                 \n" +
                                        "  (_)         (_) _  _  _               _  _  _  _  _   _       _  _    \n" +
                                        "  (_) _  _  _ (_)(_)(_)(_)_           _(_)(_)(_)(_)(_)_(_)_  _ (_)(_)   \n" +
                                        "  (_)(_)(_)(_)      (_)  (_)_       _(_) (_) _  _  _ (_) (_)(_)         \n" +
                                        "  (_)   (_) _       (_)    (_)_   _(_)   (_)(_)(_)(_)(_) (_)            \n" +
                                        "  (_)      (_) _  _ (_) _    (_)_(_)     (_)_  _  _  _   (_)            \n" +
                                        "  (_)         (_)(_)(_)(_)     (_)         (_)(_)(_)(_)  (_)            "
                );
                System.out.println("\n____________________________________________________________________________________________________\n");
                pLocation = Location;
            } else if (Location.equals("Orcs")) {
                System.out.println("\n____________________________________________________________________________________________________\n");
                System.out.println("    " + pName + " is in:\n");
                System.out.println(" _____  _____  ____    _____ _____ _____ _____ __ _____  _____  _____ _  _ \n" +
                                        "((   )) ||_// ((        ||   ||==  ||_// ||_// ||  ||   ((   )) ||_// \\\\// \n" +
                                        " \\\\_//  || \\\\  \\\\__     ||   ||___ || \\\\ || \\\\ ||  ||    \\\\_//  || \\\\  //  ");
                System.out.println("\n____________________________________________________________________________________________________\n");
                pLocation = Location;
            } else if (Location.equals("Coast")) {
                System.out.println("\n____________________________________________________________________________________________________\n");
                System.out.println("    " + pName + " is near the:\n");
                System.out.println("   ,___              \n" +
                                        "  /   /           _/_\n" +
                                        " /    __ __,  (   /  \n" +
                                        "(___/(_)(_/(_/_)_(__ "
                );
                System.out.println("\n____________________________________________________________________________________________________\n");
                pLocation = Location;
            } else if (Location.equals("Plains")) {
                System.out.println("\n____________________________________________________________________________________________________\n");
                System.out.println("    " + pName + " is in the:\n");
                System.out.println(" ____  __     __   __  __ _  ____ \n" +
                                        "(  _ \\(  )   / _\\ (  )(  ( \\/ ___)\n" +
                                        " ) __// (_/\\/    \\ )( /    /\\___ \\\n" +
                                        "(__)  \\____/\\_/\\_/(__)\\_)__)(____/"
                );
                System.out.println("\n____________________________________________________________________________________________________\n");
                pLocation = Location;
            } else if (Location.equals("Forrest")) {
                System.out.println("\n____________________________________________________________________________________________________\n");
                System.out.println("    " + pName + " is in the:\n");
                System.out.println(" __, _, ,_  ,_   _, _, ___, \n" +
                                        "'|_,/ \\,|_) |_) /_,(_,' |   \n" +
                                        " | '\\_/'| \\'| \\'\\_  _)  |   \n" +
                                        " '  '   '  `'  `  `'    '   "
                );
                System.out.println("\n____________________________________________________________________________________________________\n");
                pLocation = Location;
            } else if (Location.equals("Mountains")) {
                System.out.println("\n____________________________________________________________________________________________________\n");
                System.out.println("    " + pName + " is at the:\n");
                System.out.println(     "      _,---.                  ,----.   ,---.   ,--.--------.  \n" +
                                        "  _.='.'-,  \\  .-.,.---.   ,-.--` , \\.--.'  \\ /==/,  -   , -\\ \n" +
                                        " /==.'-     / /==/  `   \\ |==|-  _.-`\\==\\-/\\ \\\\==\\.-.  - ,-./ \n" +
                                        "/==/ -   .-' |==|-, .=., ||==|   `.-./==/-|_\\ |`--`\\==\\- \\    \n" +
                                        "|==|_   /_,-.|==|   '='  /==/_ ,    /\\==\\,   - \\    \\==\\_ \\   \n" +
                                        "|==|  , \\_.' )==|- ,   .'|==|    .-' /==/ -   ,|    |==|- |   \n" +
                                        "\\==\\-  ,    (|==|_  . ,'.|==|_  ,`-./==/-  /\\ - \\   |==|, |   \n" +
                                        " /==/ _  ,  //==/  /\\ ,  )==/ ,     |==\\ _.\\=\\.-'   /==/ -/   \n" +
                                        " `--`------' `--`-`--`--'`--`-----`` `--`           `--`--`   "
                );
                System.out.println(     "        ___     _,.---._                 .-._        ,--.--------.   ,---.       .=-.-..-._         \n" +
                                        " .-._ .'=.'\\  ,-.' , -  `.  .--.-. .-.-./==/ \\  .-._/==/,  -   , -\\.--.'  \\     /==/_ /==/ \\  .-._  \n" +
                                        "/==/ \\|==|  |/==/_,  ,  - \\/==/ -|/=/  ||==|, \\/ /, |==\\.-.  - ,-./\\==\\-/\\ \\   |==|, ||==|, \\/ /, / \n" +
                                        "|==|,|  / - |==|   .=.     |==| ,||=| -||==|-  \\|  | `--`\\==\\- \\   /==/-|_\\ |  |==|  ||==|-  \\|  |  \n" +
                                        "|==|  \\/  , |==|_ : ;=:  - |==|- | =/  ||==| ,  | -|      \\==\\_ \\  \\==\\,   - \\ |==|- ||==| ,  | -|  \n" +
                                        "|==|- ,   _ |==| , '='     |==|,  \\/ - ||==| -   _ |      |==|- |  /==/ -   ,| |==| ,||==| -   _ |  \n" +
                                        "|==| _ /\\   |\\==\\ -    ,_ /|==|-   ,   /|==|  /\\ , |      |==|, | /==/-  /\\ - \\|==|- ||==|  /\\ , |  \n" +
                                        "/==/  / / , / '.='. -   .' /==/ , _  .' /==/, | |- |      /==/ -/ \\==\\ _.\\=\\.-'/==/. //==/, | |- |  \n" +
                                        "`--`./  `--`    `--`--''   `--`..---'   `--`./  `--`      `--`--`  `--`        `--`-` `--`./  `--`  "
                );
                System.out.println("\n____________________________________________________________________________________________________\n");
                pLocation = Location;
            } else if (Location.equals("College")) {
                System.out.println("\n____________________________________________________________________________________________________\n");
                System.out.println("    " + pName + " is outside the:\n");
                // Unicode is a pain, but its worth the headache (I like the magic numbers ngl)
                // I tried using unicodedecode.com but the "Heavy" versions weren't compatible with Git Bash/CMD
                // So I had to manually change every value from www.patorjk.com/software/taag/#p=display&f=Tmplr&t=College%20of%20Sorcery using www.unicode.org/charts/nameslist/n_2500.html
                System.out.println(
                    "\u250C\u2510  \u2510\u2510          \u250C  \u250C\u2510           \n" +
                    "\u2502 \u250C\u2510\u2502\u2502\u250C\u2510\u250C\u2510\u250C\u2510  \u250C\u2510\u253C  \u2514\u2510\u250C\u2510\u250C\u2510\u250C\u250C\u2510\u250C\u2510\u2510\u250C\n" +
                    "\u2514\u2518\u2514\u2518\u2514\u2514\u2514 \u2514\u2524\u2514   \u2514\u2518\u2518  \u2514\u2518\u2514\u2518\u2518 \u2514\u2514 \u2518 \u2514\u2524\n" +
                    "         \u2518                     \u2518"
                );
                System.out.println("\n____________________________________________________________________________________________________\n");
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


// --->   End of Missile Logic <---

/*
static void charIsIn(String room) {
    System.out.println("\n\nDEBUG{OUTDATED ROOM LOGIC}");
    System.out.println("EXITING GAME LOOP");
}
*/







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
    }

    // The tavern is the main location for side quests
    static void tavern(String Location) {
        addNPC("Barkeep", 100, 10, "Blunt", 25, false);
        addNPC("Patron", 100, 5, "Blunt", 25, false);
        addNPC("Drunk", 80, 0, "Blunt", 25, false);
        addNPC("Patron", 100, 5, "Blunt", 25, false);
        addNPC("Barguard", 100, 30, "Bladed", 50, false);

        System.out.println("    "+pName+" walks into the tavern to look for work.\n");
        System.out.println("Quest Board: ");

        if (Location.equals("Capital")) {
            System.out.println("1. Caravan Guard(5g)\n2. Capture Thief(10g)\n3. Capture Spy(5-10g)");

            playerSelection();
            switch (pSel) {
                case "1":
                    if (!caravanGuard) {
                        System.out.println("Barkeep: We've had some trouble getting our supplies over\n"
                            + "to Elvsm\u00E5stad and back because of Wolves. Make sure they get there safely.\n"
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

    // Northern cave room
    static void northCave() {
        System.out.println("DEBUG{IN NORTH CAVE}");
        charaLocator(pLocation);
    }

    // Southern cave room
    static void southCave() {
        System.out.println("DEBUG{IN SOUTH CAVE}");
        charaLocator(pLocation);
    }

    // Eastern cave room
    static void eastCave() {
        System.out.println("DEBUG{IN EAST CAVE}");
        charaLocator(pLocation);
    }

    // Capital city room
    static void capitalCity(boolean inRoom) {
        System.out.println("    The cold air stings " + pName + "'s nose.\n");

        while (inRoom) {
            System.out.println("\n\nDEBUG{IN CAPITAL CITY}\n\n");
            inRoom = false;
            charaLocator(pLocation);
        }
    }

    // Empirian city room
    static void colonyCity(boolean inRoom) {
        System.out.println("    Sounds of merchants and soldiers fill the busy streets.\n");

        while (inRoom) {
            System.out.println("\n\nDEBUG{IN CAPITAL CITY}\n\n");
            inRoom = false;
            charaLocator(pLocation);
        }
    }

    // Method that ensures character has a passport
    static void nekoCheckpoint() {
        if (pNekoPassport) {
            System.out.println("    " + pName + " passed the checkpoint and was allowed to stay in:\n");
            System.out.println(
                                "  _____   __    ______                                        \n" +
                                "  ___  | / /_______  /______________ _______  ______________ _\n" +
                                "  __   |/ /_  _ \\_  //_/  __ \\_  __ `__ \\  / / /_  ___/  __ `/\n" +
                                "  _  /|  / /  __/  ,<  / /_/ /  / / / / / /_/ /_  /   / /_/ / \n" +
                                "  /_/ |_/  \\___//_/|_| \\____//_/ /_/ /_/\\__,_/ /_/    \\__,_/  "
            );
            pLocation = "Nekomura";
        } else {
            System.out.println("    " + pName + " did not pass the checkpoint and was deported...\n");
            pLocation = "Coast";
        }
    }

    // Capital city room
    static void nekoCity(boolean inRoom) {
        System.out.println("    Neon lights and the sounds of a modern city draw " + pName + " closer.\n");

        while (inRoom) {
            System.out.println("\n\nDEBUG{IN NEKO CITY}\n\n");
            inRoom = false;
            charaLocator(pLocation);
        }
    }

    // Desert town room
    static void rotCity(boolean inRoom) {
        System.out.println("    The smell blood and alcohol are amplified by the heat.\n");

        while (inRoom) {
            System.out.println("\n\nDEBUG{IN DESERT CITY}\n\n");
            inRoom = false;
            charaLocator(pLocation);
        }
    }

    static boolean forKeyP1 = false;
    // Desert village room
    static void desVillage() {
        System.out.println("\n    The village is still under construction. Most shops are still closed.\n" 
            + "    Rubble is everywhere on the streets and entire buildings are broken.\n\n"
            + "    The tavern has a sign out front: [NO ENTRY]\n"
        );

        if (!forKeyP1) {
            System.out.println("    There is an old man standing outside a ruin with a cart and several wares.\n\n"
                + "1. Approach the man\n2. Leave Torrlandsby\n"
            );            
            playerSelection();
            switch (pSel) {
                case "1": talkToNPC = true; break;
                default: System.out.println("    " + pName + " left."); charaLocator(pLocation);
            }
        } else {
            System.out.println("    The old man left...");
            System.out.println("    Everyone else seems too busy to talk to " + pName + ".");
            System.out.println("    " + pName + " left."); charaLocator(pLocation);
        }



        if (talkToNPC && !forKeyP1) {
            System.out.println("Mu'Guffin: Ahh a traveler! Dun get any round 'ere n'more.\n"
                + "Only soldiers. Dont buy nun they do. So yous buyin or leavin?\n\n"
                + "1. Buy Something\n2. Leave\n"
            );

            merchantInv.clear();
            merchPrice.clear();

            merchantInv.add("Small Spring");
            merchPrice.add(4);

            merchantInv.add("Broken Stick"); // Part one of the Hidden Forrest Key
            merchPrice.add(1);

            merchantInv.add("Chewed Up Bubblegum");
            merchPrice.add(2);

            merchantInv.add("Slightly Damaged Brick");
            merchPrice.add(3);

            merchantInv.add("Silver Key");
            merchPrice.add(3);

            playerSelection();
            if (pSel.equals("1")) {
                System.out.println("Mu'Guffin: The big stuff blew up. Bu' gotta few trinkets.\n");
                System.out.println("    Items on the cart:\n");
                for (int i = 0; i < merchantInv.size(); i++) {
                    System.out.println((i + 1) +". " + merchantInv.get(i) + ", Price: (" + merchPrice.get(i) + "g)");
                }
                System.out.println("\n" + pName + ": This looks like rubbish.\n\n"
                    + "Mu'Guffin: Nuh uh.\n\n"
                    + "    What will " + pName + " purchace (1-" + merchantInv.size() + ")\n"
                );

                playerSelection();
                if (pSel.equals("1") && ((pGold - merchPrice.get(0)) >= 0)) {
                    placeInInv(merchantInv.get(0));
                    pGold -= merchPrice.get(0);
                    System.out.println("Mu'Guffin: Got that from one a them fancy cat people pens.");
                } else if (pSel.equals("2") && ((pGold - merchPrice.get(1)) >= 0)) {
                    forKeyP1 = true;
                    placeInInv(merchantInv.get(1));
                    pGold -= merchPrice.get(1);
                    System.out.println("Mu'Guffin: Pic'd it up on da woods. Looong way back yup.");
                } else if (pSel.equals("3") && ((pGold - merchPrice.get(2)) >= 0)) {
                    placeInInv(merchantInv.get(2));
                    pGold -= merchPrice.get(2);
                    System.out.println("Mu'Guffin: Still 'aves flavour.");
                } else if (pSel.equals("4") && ((pGold - merchPrice.get(3)) >= 0)) {
                    placeInInv(merchantInv.get(3));
                    pGold -= merchPrice.get(3);
                    System.out.println("Mu'Guffin: Didn' git blasted inda da bo'min, gotta be lucky or sum.");
                } else if (pSel.equals("5") && ((pGold - merchPrice.get(4)) >= 0)) {
                    placeInInv(merchantInv.get(4));
                    pGold -= merchPrice.get(4);
                    System.out.println("Mu'Guffin: Fur mah 'ouse... Door got blasted tho.");
                } else {
                    System.out.println("Mu'Guffin: Pfft. New you was broke. Git outta 'ere!");
                }

                charaLocator(pLocation);
            } else {
                System.out.println("Mu'Guffin: Pfft. New you was broke. Git outta 'ere!");
                charaLocator(pLocation);
            }
        }
    }

    // Coastal village room
    static void coastVill() {
        System.out.println("\n\nDEBUG{IN COASTAL VILLAGE}\n\n");
        charaLocator(pLocation);
    }

    // Plains town room
    static void plainsCity(boolean inRoom) {
        System.out.println("    The townspeople look frustrated and too busy to aknowledge " + pName + ".\n");

        while (inRoom) {
            System.out.println("\n\nDEBUG{IN PLAINS CITY}\n\n");
            inRoom = false;
            charaLocator(pLocation);
        }
    }

    // Plains Village room
    static void plainsVillage() {
        System.out.println("\n\nDEBUG{IN PLAINS VILLAGE}\n\n");
        charaLocator(pLocation);
    }

    // River Village room
    static void riverVillage() {
        System.out.println("\n\nDEBUG{IN RIVER VILLAGE}\n\n");
        charaLocator(pLocation);
    }

    // Barbarian Camp room
    static void barCamp() {
        if (pKarma > -5) {
            System.out.println("DEBUG{HOSTILE AREA}");
        }
        System.out.println("\n\nDEBUG{IN BARBARIAN TERRITORY}\n\n");
        charaLocator(pLocation);
    }

    // Orc Camp room
    static void orcCamp() {
        if (!pOrc) {
            System.out.println("DEBUG{HOSTILE AREA}");
        }
        System.out.println("\n\nDEBUG{IN BARBARIAN TERRITORY}\n\n");
        charaLocator(pLocation);
    }

    // Lake room
    static void nordLake() {
        System.out.println("\n\nDEBUG{IN LAKE}\n\n");
        charaLocator(pLocation);
    }
    
    static boolean inCollege = false;
    static boolean acceptedInCollege = false;
    static boolean orientationCompleted = false;
    // College of Sorcery room
    static void college() {
        if(!acceptedInCollege) {
            System.out.println("    Several apprentice mages are outside using teleportation spells to get to their classes.\n"
                + "    There is a mage sitting on a chair taking applications to apply to the college...\n\n"
                + "1. Approach the mage\n2. Leave\n"
            );

            playerSelection();
            switch (pSel) {
                case "1":
                    System.out.println("Daelen: Welcome to the College of Sorcery.\n"
                        + "Please fill out this application and we will provide the\n"
                        + "details through carrier pigeon in 3-4 fullm\u00E5ne.\n\n"
                        + "    " + pName + " fills out the application and turns in to the mage...\n"
                    );

                    if (pSorcery >= 30) {
                        System.out.println("Daelen: Congratulations... You have been accepted to the College of Sorcery.\n"
                            + "Please take the teleporter on the right in order to complete the orientation.\n\n"
                            + pName + ": I thought you said it takes 3-4 fullm\u00E5ne?\n\n"
                            + "Daelen: We can wait that long if you want... Yeah thats what I thought.\n"
                            + "Just go through the teleporter. I have a job to do.\n"
                        );
                        acceptedInCollege = true;
                        break;
                    } else {
                        System.out.println("Daelen: Thank you for submitting your application.\n"
                            + "You can leave now, you're holding up the line\n"
                        );
                    }
                default: charaLocator(pLocation);
            }            
        } else {
            System.out.println("1. Go to the main hall\n2. Leave");

            playerSelection();
            switch (pSel) {
                case "1":
                    inCollege = true;
                    break;
                default: charaLocator(pLocation);
            }
        }

        if (!orientationCompleted) {
            System.out.println("    " + pName + " takes the teleporter and rematerializes in a large lecture hall.\n\n"
                + "\nDEBUG{ATTENDING ORIENTATION}\n"
            );
            orientationCompleted = true;
            inCollege = true;
            college();
        }


        while (inCollege) {
            System.out.println("\n\nDEBUG{IN COLLEGE}\n\n");
            inCollege = false;
            charaLocator(pLocation);
        }
    }

    // Plains town room
    static void hiddenForrest(boolean inRoom) {
        if (pWoodElf) {
            System.out.println("    The elves dont even aknowledge " + pName + ".\n");
        } else if (pCaveElf) {
            System.out.println("    A Trealv spots "+ pName +" and screams in terror!\n");
        } else {
            System.out.println("    The elves look confused but also treat " + pName + " like a celebrity.\n");
        }

        while (inRoom) {
            System.out.println("\n\nDEBUG{IN HIDDEN FORREST}\n\n");
            inRoom = false;
            charaLocator(pLocation);
        }
    }

    // Great Cave room
    static void greatCave(boolean inRoom) {
        while (inRoom) {
            System.out.println("\n\nDEBUG{IN CRYSTAL CAVE}\n\n");
            inRoom = false;
            charaLocator(pLocation);
        }
    }

// --->   End of Rooms   <---










//   --->   Quest Variables   <---


    static boolean talkToNPC = false; // bool to talk to a npc (mostly merchants)
    static ArrayList<String> merchantInv = new ArrayList<>(); // List of merchant's wares
    static ArrayList<Integer> merchPrice = new ArrayList<>(); // List of prices of items

    // Method for the empirian prisoner start
    static void tutorial() {
        if (!tutComplete) {
            clearConsole();
            pStartLocation = true;
            tutComplete = true;
            System.out.println("\n____________________________________________________________________________________________________\n");

            String[] loadingMsg = { // Loading message to catch player's attention
                "   __                 _ _             \n" +
                "  / /  ___   __ _  __| (_)_ __   __ _ \n" +
                " / /  / _ \\ / _` |/ _` | | '_ \\ / _` |\n" +
                "/ /__| (_) | (_| | (_| | | | | | (_| |\n" +
                "\\____/\\___/ \\__,_|\\__,_|_|_| |_|\\__, |\n" +
                "                                |___/ ",

                "   o   ",
                "o   ",
                "o   ",
                "o   ",
                "o"

            };

            for (String loading : loadingMsg) { 
                System.out.print(loading);
                try { // credits to Gray on stack overflow for sleep method
                    Thread.sleep(1000); // half a sec wait time (feels too fast and too slow at the same time)
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            clearConsole();
            System.out.println("\n____________________________________________________________________________________________________\n");

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
                "    The cart stops inside Torrlandsby.",
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
                    Thread.sleep(250); // quarter second wait time (feels too fast and too slow at the same time)
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
                    System.out.println("    "+pName+" takes the opportunity and escapes Torrlandsby.");
                    charaLocator("Desert");
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

    // method for if Chara goes with Astrid
    static void goWithAstrid() {
        empiRep -= 2;

        String[] statements = { // string array with the text blob
            "    "+pName+" followed Astrid.",
            "",
            "Astrid: Over here! Hurry before the guards come after us!",
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
                        + "Survivor: You! We're heading to Elvsm\u00E5stad you can come if you want.\n"
                        + "Its just up the river here for a few kilometers, or you can head east towards Rattensby.\n"
                    );
                    if (astridChance < 6) {
                        astridDied = true;
                    }
                    tutComplete = true;
                    charaLocator("Desert");
                    break;
                default: System.out.println("    Something inside of "+pName+" stopped "+proObj+" from leaving.\n"); equipWeapon("Fists"); fightWithAstrid = true;
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
                        + "Survivor: You! We're heading to Elvsm\u00E5stad you can come if you want.\n"
                        + "Its just up the river here for a few kilometers, or you can head east towards Rattensby.\n"
                    );
                    if (astridChance < 6) {
                        astridDied = true;
                    }
                    tutComplete = true;
                    charaLocator("Desert");
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

            dismissComp("Astrid");
            System.out.println("Astrid: Let's keep moving we might still be able to catch up.\n\n"
                + "    They exit the sewers near a river in the desert.\n\n"
                + "Astrid: We're heading up the river towards Elvsm\u00E5stad but if you\n"
                + "want Rattensby is to the east. If you want to travel together again I\n"
                + "will be in the capital for the next couple months.\n\n"
                + "1. Go with the group\n2. Stay in the desert\n"
            );

            tutComplete = true;
            playerSelection();

            switch (pSel) {
                case "1": charaLocator("River"); break;
                default: charaLocator("Desert");
            }
        }

        System.out.println("\n____________________________________________________________________________________________________\n");
    }

    // method for if Chara tries to save Leon
    static boolean benignusBellator = false;
    static void saveLeon() {
        verdRep -= 2;

        String[] statements = { // string array with the text blob
            "    "+pName+" went over to help Leon.",
            "",
            "    Leon is under several rocks.",
            "    " + pName + " uses a pirce of rebar to lift the rock on top of his foot.",
            "    A guard rushes over to sound of Leon's screams...",
            "",
            "Wounded Soldier: Back off criminal!.",
            "",
            "    The guard raises his sword and readies an attack...",
            "",
            "Leon: DISCEDITE MILES!",
            "This person was trying to help me and you're here to strike them down?",
            "Help " + proSub + " out or you'll be stationed on the deepest parts of the mine!",
            "",
            "Wounded Soldier: Paenitet Leutnant Leon...",
            "",
            "    With the help of the soldier, "+pName+" is able to free Leon.",
            "",
            "Leon: Ack! Danke... I hate to ask but will you escort me and this one to the Colony,",
            "I'll be sure you are compensated and pardoned of any crimes.",
            "",
            "1. Escort Leon to the Colony",
            "2. Leave Torrlandsby alone\n"
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

        boolean escortLeon = false;
        playerSelection();
        switch (pSel) {
            case "1":
                escortLeon = true;
                empiRep += 3;
                break;
            default:
                empiRep += 1;
                System.out.println("    "+pName+" thinks " + proSub + " has done enough.");
        }

        System.out.println("\n____________________________________________________________________________________________________\n");
        if (escortLeon) {
            System.out.println("    "+pName+" helps Leon get up but notices his ankle is too damaged to walk.\n"
                + "    Some Empirian soldiers notice the two struggling to help Leon and come over to help out as well.\n"
                + "    With the help of the others "+pName+" is able to escape Torrlandsby with Leon.\n"
                + "    A few kilometers away from the Colony gateway they are spotted by Verdian Soldiers...\n\n"

                + "Leon: Ready your swords Fortes Milites! We stand our ground here before diese hunde get closer to our land!\n"
                + "You the Benignus Odin. You have done so much for me but now I ask of you my final request...\n"
                + "Take my sword and defend me with my men.\n\n"
            );

            equipWeapon("War Sword");
            placeInInv("War Sword");

            addNPC("Verdian Soldier", 100, 20, "Bladed", 50, true);
            addNPC("Verdian Soldier", 100, 20, "Bladed", 50, true);
            addNPC("Verdian Soldier", 100, 20, "Bladed", 50, true);

            addAlly("Empirian Soldier", 100, 20);
            addAlly("Empirian Soldier", 100, 20);
            addAlly("Wounded Soldier", 60, 20);

            gotMad();

            if (pHealth > 50) {
                System.out.println("Leon: Vincimus! Benignus Odin... you proved yourself in battle today,\n"
                    + "and I will make sure the Empire hears about it. Tell me your name...\n\n"
                    + pName +": My name is " + pName + " the " + pRace + ".\n\n"
                    + "Leon: I will ensure the Empire knows you as " + pName + " the Benignus Bellator.\n"
                    + "For your kindness and strenght in battle.\n"
                    + "The Empire could use your strength, you can enlist in the barracks inside the colony.\n\n"
                    + "Leon: Milites let us continue towards the capital!\n" 
                );
                empiRep += 1;
                benignusBellator = true;
            } else {
                System.out.println("Leon: Vincimus. Good work men let's move before more come.");
            }

            pCoins += 50;
            System.out.println("    "+pName+" gets paid 50c for his troubles.\n");
            System.out.println("1. Stay in the Colony\n2. Go back to the desert\n");

            playerSelection();
            switch (pSel) {
                case "2": charaLocator("Desert"); break;
                default: charaLocator("Colony");
            }

        } else {
            System.out.println("Leon: That is understandable. You're actions are appreciated by me and the Empire.");

            int leonChance = 0;
            leonChance = rand.nextInt(20) + 1;

            if (leonChance > 6) {
                leonDied = false;
            } else {
                leonDied = true;
            }

            System.out.println("1. Stay in the Desert\n2. Go towards the Colony\n3. Go towards the River");
            playerSelection();

            switch(pSel) {
                case "3": charaLocator("River"); break;
                case "2": charaLocator("Colony"); break;
                default: charaLocator("Desert");
            }

        }
    }

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
        addNPC("Wolf", 50, 10, "Bladed", 25, true);
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

        System.out.println("    The caravan made it to Elvsm\u00E5stad safely!");
        pGold += 5;
        caravanGuard = true;
        quests.remove("Caravan Guard");
        charaLocator("River");
    }

    // Wolf Exterminator quest
    static void qWolfExt() {
        System.out.println("    "+pName+" walks in the forrest until "+proObj+" hears the snarls of Wolves nearby.");
        
        clearNPCs();
        addNPC("Wolf", 50, 10, "Bladed", 25, true);
        addNPC("Wolf", 50, 10, "Bladed", 25, true);
        addNPC("Alpha Wolf", 100, 20, "Bladed", 50, true);
        addNPC("Wolf", 50, 10, "Bladed", 25, true);
        addNPC("Wolf", 50, 10, "Bladed", 25, true);

        System.out.println("    The howls of hungry dogs are nearby...");
        gotMad();

        if (pHealth > 50) {
            System.out.println("    "+pName+" brushes off a couple scratches.");
        } else {
            System.out.println("    "+pName+" groans in pain and limps back to Elvsm\u00E5stad");
        }

        System.out.println("    "+pName+" turns in the Alpha Wolf's head to a nearby guard.\n\n"
            + "Guard: Ohh... you didn't have to bring it back.\n\n"
            + "    The guard pays "+pName+" 5g!"
        );

        pGold += 5;
        wolfExterminator = true;
        quests.remove("Wolf Exterminator");
        charaLocator("River");
        
    }

// --->   End of quests   <---










// --->   Companion System   <---

    // Companion variables
    static boolean warriorInParty = false; // var for if the player has a warrior in their party
    static String wName = "";
    static int wHealth = 0;
    static int wDamage = 0;
    static double wDmgRes = 0;
    static int wMaxHealth = 0;

    static boolean mageInParty = false;
    static String mName = "";
    static int mHealth = 0;
    static int mDamage = 0;
    static double mDmgRes = 0;
    static int mMaxHealth = 0;

    static boolean tankInParty = false;
    static String tName = "";
    static int tHealth = 0;
    static int tDamage = 0;
    static double tDmgRes = 0;
    static int tMaxHealth = 0;

    static boolean rangeInParty = false;
    static String rName = "";
    static int rHealth = 0;
    static int rDamage = 0;
    static double rDmgRes = 0;
    static int rMaxHealth = 0;

    static boolean astridDied = false;
    static boolean leonDied = false;
    static boolean steinDied = false;
    static boolean evinDied = false;
    static boolean dorcyDied = false;
    static boolean inurukiDied = false;

    // Method that sets companion stats
    static void recruitComp(String name) {
        if (warriorInParty) {
            System.out.println("    You already have " + wName + " in your party...\n"
                + "    Dismiss " + wName + "?\n\n"
                + "1. Keep " + wName + " in party.\n"
                + "2. Dismiss " + wName + "."
            );

            playerSelection();
            switch (pSel) {
                case "2": dismissComp(wName); recruitComp(name); break;
                default: System.out.println("    " + wName + " stayed with " + pName);
            }
        } else if (name.equals("Astrid") && !astridDied && !warriorInParty) {
            wName = "Astrid";
            wDamage = 20;
            wDmgRes = 1.5;
            wHealth = 150;
            wMaxHealth = 150;
            warriorInParty = true;

        } else if (name.equals("Leon") && !leonDied && !warriorInParty) {
            wName = "Leon";
            wDamage = 30;
            wDmgRes = 1.5;
            wHealth = 100;
            wMaxHealth = 100;
            warriorInParty = true;
        }

        System.out.println("    " + name + " has joined " + pName + "'s party.");
    }

    // method that dismisses companion
    static void dismissComp(String name) {

        if (name.equals(wName)) {
            wName = "";
            wDamage = 0;
            wDmgRes = 0;
            wHealth = 0;
            wMaxHealth = 0;        
            warriorInParty = false;    
        }


        System.out.println("    " + name + " has left " + pName + "'s party.");

    }

    // method that checks if the companion died
    static boolean isCompDead(String name) {
        if (!charIsAlone()) {
            if (name.equals(wName) && wHealth <= 0 && warriorInParty) {
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

            if (name.equals(mName) && mHealth <= 0 && mageInParty) {
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

            if (name.equals(tName) && tHealth <= 0 && tankInParty) {
                System.out.println("    "+tName+" died!");
                if (name.equals("Steineter")) {
                    steinDied = true;
                    tankInParty = false;
                }

                return true;
            }

            if (name.equals(rName) && rHealth <= 0 && rangeInParty) {
                System.out.println("    "+rName+" died!");
                if (name.equals("Inuruki")) {
                    inurukiDied = true;
                    rangeInParty = false;
                }

                return true;
            }
        }

        return false;
    }

    // method that check if Chara is alone
    static boolean charIsAlone() {
        return !(warriorInParty || mageInParty || tankInParty || rangeInParty);
    }

// --->   End of Comp Sys   <---










// --->   Turn Based Combat System   <---

    //Combat Variables
    static boolean inCombat = false;
    static int pDisToTar = 0; // Character's distance to targeted enemy (>=2 is Melee <2 isRanged)
    static ArrayList<String> spells = new ArrayList<>();

    // Method that initializes combat
    static void combat() {
        while (inCombat) { // Starts bombat

            if (theyAreDead()) {
                System.out.println("\n    "+pName+" has triumphed!\n");
                for (int i = 0; i < npcName.size(); i++) { // for loop to reward player with exp
                    pCurXp += npcExp.get(i);
                    levelUp();
                }
                break;
            }

            System.out.println("\n    Enemies in view:");
            for (int i = 0; i < npcName.size(); i++) { // for loop to display enemies
                System.out.println((i + 1) + ". " + npcName.get(i) + " (Health: " + npcHealth.get(i) + ")");
            }

            System.out.println("\n    "+pName+"'s Health: "+pHealth+"/"+pMaxHealth+"\n");
            if (warriorInParty) {
                System.out.println("    "+wName+"'s Health: "+wHealth+"/"+wMaxHealth+"\n");
            }
            if (mageInParty) {
                System.out.println("    "+mName+"'s Health: "+mHealth+"/"+mMaxHealth+"\n");
            }
            if (tankInParty) {
                System.out.println("    "+tName+"'s Health: "+tHealth+"/"+tMaxHealth+"\n");
            }
            if (rangeInParty) {
                System.out.println("    "+rName+"'s Health: "+rHealth+"/"+rMaxHealth+"\n");
            }

            if (isMagic()) { // Player goes first
                useMagic();
            } else {
                pTurn(); 

            }

            updateEffects(); // Updates any status effects Chara might have

            if (!charIsAlone()) // Party members are second
                cTurn();
            
            eTurn(); // enemies go after party members

            if (!allyName.isEmpty()) // Allies go after enemy
                aTurn();
            
            combatMenu();



            clearConsole();

            if (isCharDead()) { // checks if Chara is KIA
                if (pLives == 1) { // Sends Chara to the gulag if they die
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
        clearNPCs();
        if (allyName.size() > 0) {
            clearAllies();
        }
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
    
    static double pDmgRes = 0.0; // Character's damage resistance (depens on damage type)
    static double pDmgMult = 0.0; // Characte's damage multiplier (depends on weapon type)

    // Method for the players turn
    static void pTurn() {
        for (int i = 0; i < (pStamina/10); i++) {
            int choice = 0;
            System.out.print("\n    Who will "+pName+" attack? (1-" + npcName.size() + "): ");
            choice = input.nextInt() - 1;

            if (choice < 0 || choice >= npcName.size()) { // input validation to make sure player selects valid enemy
                System.out.println("    "+pName+" sparked up.");
                pHealth += 1;
                continue;
            }

            int pHitChance = rand.nextInt(20) + 1 + pLuck;
            double pDamageCalc; // ((pWeaponDmg*pDmgMult) + (pStrenght*0.25))  Equation to calculate character's damage

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

    // Function that checks if Chara died
    static boolean isCharDead() {
        return pHealth <= 0; // checks if Chara's health dropped to 0
    }

    static String eDmgType = "";
    static int eDamage = 0;
    // Method for the enemies turn (i sHoUlD aDd A sYsTeM fOr MuLtIpLe EnEmIeS - Naive Rigo)
    static void eTurn() {
        for (int i = 0; i < npcName.size(); i++) { // looks like jargon but lets every enemy attack
            if (npcHealth.get(i) > 0) { // if the enemy attacking is alive

                // Create a list of available targets
                ArrayList<String> targets = new ArrayList<>();
                targets.add(pName); // Player character
                if (warriorInParty && !isCompDead(wName)) {
                    targets.add(wName);
                }
                if (mageInParty && !isCompDead(mName)) {
                    targets.add(mName);
                }
                if (tankInParty && !isCompDead(tName)) {
                    targets.add(tName);
                }
                if (rangeInParty && !isCompDead(rName)) {
                    targets.add(rName);
                }
                if (!allyName.isEmpty()) {
                    String aName = "";
                    for (int j = 0; j < allyName.size(); j++) {
                        aName = allyName.get(j);
                        targets.add(aName);
                    }
                }

                int eHitChance = rand.nextInt(20) + 1;
                int numTargets = targets.size();
                eDamage = npcDamage.get(i);
                int eTargetChoice = rand.nextInt(numTargets);
                String target = targets.get(eTargetChoice);
                
                int targetAlly = (!allyName.isEmpty())? rand.nextInt(allyName.size()) : 0;

                if (eHitChance < 10) {
                    System.out.println("    "+npcName.get(i)+" missed!");
                } else if (eTargetChoice == 0 || target.equals(pName)) {
                    if ((eHitChance - setRange()) < 10) {
                        System.out.println("    "+pName+" was far enough away to not get hit!\n");
                        continue;                        
                    }

                    eDmgType = npcDamageType.get(i);
                    pDmgRes = setDamageResistance(eDmgType);
                    eDamage = (int)(eDamage / (pDmgRes + 0.5));
                    eDamage = Math.max(eDamage, 0); // Makes sure the enemies damage cant be lower than 0 or it would heal (would be funny tho)
                    pHealth -= eDamage;
                    System.out.println("    "+npcName.get(i)+" hit "+pName+" and did "+eDamage+" damage!");
                } else if (target.equals(wName)) {
                    eDamage = (int)(eDamage / (wDmgRes + 0.5));
                    eDamage = Math.max(eDamage, 0);
                    wHealth -= eDamage;
                    System.out.println("    "+npcName.get(i)+" hit "+wName+" and did "+eDamage+" damage!");
                } else if (target.equals(mName)) {
                    eDamage = (int)(eDamage / (mDmgRes + 0.5));
                    eDamage = Math.max(eDamage, 0);
                    mHealth -= eDamage;
                    System.out.println("    "+npcName.get(i)+" hit "+mName+" and did "+eDamage+" damage!");
                }  else if (target.equals(tName)) {
                    eDamage = (int)(eDamage / (tDmgRes + 0.5));
                    eDamage = Math.max(eDamage, 0);
                    tHealth -= eDamage;
                    System.out.println("    "+npcName.get(i)+" hit "+tName+" and did "+eDamage+" damage!");
                } else if (target.equals(rName)) {
                    eDamage = (int)(eDamage / (rDmgRes + 0.5));
                    eDamage = Math.max(eDamage, 0);
                    rHealth -= eDamage;
                    System.out.println("    "+npcName.get(i)+" hit "+rName+" and did "+eDamage+" damage!");
                } else if (!allyName.isEmpty() && allyHealth.get(targetAlly) > 0) {
                    allyHealth.set(targetAlly, allyHealth.get(eTargetChoice) - eDamage);
                } else {
                    System.out.println("    " + npcName.get(i) + " missed!");
                }
            }
        }
    }

    // Method that lets the party members attack
    static void cTurn() {
        int cHitChance;
        int cChoice;

        if (npcName.isEmpty())
            return;

        if (!isCompDead(wName) && warriorInParty) { // if warrior is alive they attack a random enemy
            cChoice = rand.nextInt(npcName.size());
            cHitChance = rand.nextInt(20) + 1;
            if (cHitChance < 7) {
                System.out.println("    "+wName+" missed!\n");
            } else {
                npcHealth.set(cChoice, npcHealth.get(cChoice) - wDamage);
                System.out.println("    " + wName + " hit " + npcName.get(cChoice) + " and did " + wDamage + " damage!\n");
            }
        }
        if (!isCompDead(mName) && mageInParty) { // if mage is alive they attack a random enemy (heals player with a nat 20)
            cChoice = rand.nextInt(npcName.size());
            cHitChance = rand.nextInt(20) + 1;
            if (cHitChance < 11) {
                System.out.println("    "+mName+" missed!\n");
            } else if (cHitChance == 20) {
                pHealth = pMaxHealth;
                System.out.println("    "+mName+" fully healed "+pName+"!");
            } else {
                npcHealth.set(cChoice, npcHealth.get(cChoice) - mDamage);
                System.out.println("    " + mName + " hit " + npcName.get(cChoice) + " and did " + mDamage + " damage!\n");
            }
        }
        if (!isCompDead(tName) && tankInParty) { // if tank is alive they attack a random enemy
            cChoice = rand.nextInt(npcName.size());
            cHitChance = rand.nextInt(20) + 1;
            if (cHitChance <= 11) {
                System.out.println("    "+tName+" missed!\n");
            } else {
                npcHealth.set(cChoice, npcHealth.get(cChoice) - tDamage);
                System.out.println("    " + tName + " hit " + npcName.get(cChoice) + " and did " + tDamage + " damage!\n");
            }
        }
        if (!isCompDead(rName) && rangeInParty) { // if ranged is alive they attack a random enemy (Should get expanded later to actually do ranged dmg)
            cChoice = rand.nextInt(npcName.size());
            cHitChance = rand.nextInt(20) + 1;
            if (cHitChance < 6) {
                System.out.println("    "+rName+" missed!\n");
            } else {
                npcHealth.set(cChoice, npcHealth.get(cChoice) - rDamage);
                System.out.println("    " + rName + " hit " + npcName.get(cChoice) + " and did " + rDamage + " damage!\n");
            }
        }
    }

    // Method for the allies turn
    static void aTurn() {
        if (npcName.isEmpty())
            return;

        for (int i = 0; i < allyName.size(); i++) { // lets every ally attack
            if (allyHealth.get(i) > 0) { // if the ally is alive

                int aHitChance = rand.nextInt(20) + 1;
                int numTargets = npcName.size();
                int aChoice = rand.nextInt(numTargets);
                int aDamage = allyDamage.get(i);

                System.out.println(allyName.get(i) + " (Health: " + allyHealth.get(i) +") attacked...");
                if (aHitChance < 10) {
                    System.out.println("    "+allyName.get(i)+" missed!");
                } else {
                    npcHealth.set(aChoice, npcHealth.get(aChoice) - aDamage);
                    System.out.println("    "+allyName.get(i)+" hit "+npcName.get(aChoice)+" and did "+aDamage+" damage!");
                }
            }
        }
    }

    // Method for the combat menu
    static void combatMenu() {
        System.out.println("\n____________________________________________________________________________________________________\n");
        System.out.println("    Prepare for your next move!\n"
            + "    What will "+pName+" do?\n\n"
            + "1. Continue\n2. Use an item\n3. Try to run away\n"
        );

        playerSelection();
        switch (pSel) {
            case "2": useItem(); break;
            case "3": escapeCombat(); break;
            default: 
                String str = (!theyAreDead() && pHealth > 0)? "    The enemy moves closer!\n" : "The battlefield is quiet...\n";
                System.out.println(str);
        }
    }

    static int escapeChance;
    // Method for fleeing combat
    static void escapeCombat() {
        System.out.println("    "+pName+" tried to escape...");

        escapeChance = rand.nextInt(100) + 1;

        if (escapeChance <= pSneak) { // chance to escape is based on sneak skill
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
    static double setDamageResistance(String eDmgType) {
        if (eDmgType.equals("Bladed")) {
            return pBladeRes;
        } else if (eDmgType.equals("Blunt")) {
            return pBluntRes;
        } else if (eDmgType.equals("Magic")) {
            return pMagicRes;
        } else if (eDmgType.equals("Poison")) {
            return pPoisonRes;
        } else if (eDmgType.equals("Fire")) {
            return pFireRes;
        } else if (eDmgType.equals("Frost")) {
            return pFrostRes;
        } else {
            return 0;
        }
    }

    // Individual array lists used for each enemy stat
    static ArrayList<String> npcName = new ArrayList<>(); // NPC names
    static ArrayList<Integer> npcHealth = new ArrayList<>(); // NPC health
    static ArrayList<Integer> npcDamage = new ArrayList<>(); // NPC damage
    static ArrayList<String> npcDamageType = new ArrayList<>(); // NPC damage type
    static ArrayList<Integer> npcExp = new ArrayList<>(); // NPC experience
    static ArrayList<Boolean> npcHostile = new ArrayList<>(); // Whether NPC is hostile

    // Add NPC to the lists
    static void addNPC(String name, int health, int damage, String dType, int exp, boolean hostile) {
        npcName.add(name);
        npcHealth.add(health);
        npcDamage.add(damage);
        npcDamageType.add(dType);
        npcExp.add(exp);
        npcHostile.add(hostile);
    }

    // Arrays for allies
    static ArrayList<String> allyName = new ArrayList<>(); // Ally names
    static ArrayList<Integer> allyHealth = new ArrayList<>(); // Ally health
    static ArrayList<Integer> allyDamage = new ArrayList<>(); // Ally damage

    // Add Allies to the lists
    static void addAlly(String name, int health, int damage) {
        allyName.add(name);
        allyHealth.add(health);
        allyDamage.add(damage);
    }

    // Clear NPCs from area
    static void clearNPCs() {
        npcName.clear();
        npcHealth.clear();
        npcDamage.clear();
        npcExp.clear();
        npcHostile.clear();
    }

    // clear Allies from area
    static void clearAllies() {
        allyName.clear();
        allyHealth.clear();
        allyDamage.clear();
    }
    
    // Long Ahh List of Weapons (array lists not needed but makes finding weapon simpler)
    static ArrayList<String> allWeapons = new ArrayList<>(); 
    static ArrayList<String> t1Weapons = new ArrayList<>();
    static ArrayList<String> t2Weapons = new ArrayList<>();
    static ArrayList<String> t3Weapons = new ArrayList<>();
    static ArrayList<String> t4Weapons = new ArrayList<>();
    static ArrayList<String> t5Weapons = new ArrayList<>();
    static boolean weaponEquipped = false;
    static String pWeapon = "";
    static String pWeaponType = "none"; // type of weapon character is using
    static int pWeaponDmg = 0; // Character's current weapon damage (T1 = 10, T2 = 20, ... T5 = 50[Max])

    // Method that populates the weapon arrays
    static void popWeaponArrays() {
        // Tier 1 Weapons
        t1Weapons.add("Fists");
        t1Weapons.add("Rusty Sword");
        t1Weapons.add("Wooden Club");
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
        t4Weapons.add("NA Carbine MKII");

        // Tier 5 Weapons
        t5Weapons.add("Gunpowder Gloves");
        t5Weapons.add("Nekohito Steel Katana");
        t5Weapons.add("Veridian Warhammer");
        t5Weapons.add("Empirian Greatsword");
        t5Weapons.add("Archmage Staff");
        t5Weapons.add("Dragonn KLR 20mm Anti-Matiriel Rifle");

        // populates the allWeapons Array
        allWeapons.add("Fists");
        allWeapons.add("Rusty Sword");
        allWeapons.add("Wooden Club");
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
        allWeapons.add("NA Carbine MKII");

        allWeapons.add("Gunpowder Gloves");
        allWeapons.add("Nekohito Steel Katana");
        allWeapons.add("Veridian Warhammer");
        allWeapons.add("Empirian Greatsword");
        allWeapons.add("Archmage Staff");
        allWeapons.add("Dragonn KLR 20mm Anti-Matiriel Rifle");
    }

    static boolean t1Spells = false;
    static boolean t2Spells = false;
    static boolean t3Spells = false;
    static boolean t4Spells = false;
    static boolean t5Spells = false;
    // Method that gives user spells based on their weapon
    static boolean isMagic() {
        if (pWeapon.equals("Stick Wand")) {
            if (!t1Spells) {
                spells.add("Fireball");
                spells.add("Minor Heal");
                t1Spells = true;
            }
            return true;
        } else if (pWeapon.equals("College of Sorcery Wand")) {
            if (!t2Spells) {
            spells.add("Magic Ward");
            spells.add("Weaken Foe");
            t2Spells = true;
            }
            return true;
        } else if (pWeapon.equals("Crystal Staff")) {
            if (!t3Spells) {
            spells.add("Shard Blast");
            spells.add("Phantom Armour");
            t3Spells = true;
            }
            return true;
        } else if (pWeapon.equals("Elfwood Wand")) {
            if (!t4Spells) {
            spells.add("Heal");
            spells.add("Conjure Familiar");
            spells.add("Blessing");
            t4Spells = true;
            }
            return true;
        } else if (pWeapon.equals("Archmage Staff")) {
            if (!t1Spells) {
            spells.add("Banish");
            spells.add("Full Heal");
            t5Spells = true;
            }
            return true;
        } else {
            return false;
        }
    }

    // Method for magic users
    static void useMagic() {
        for (int i = 0; i < (pSorcery/10); i++) {
            System.out.println("\n    Spells Available:");
            for (int j = 0; j < spells.size(); j++) { // for loop to display enemies
                System.out.println((j + 1) + ". " + spells.get(j));
            }

            int choice = 0;
            System.out.print("\n    What spell will "+pName+" cast? (1-" + spells.size() + "): ");
            choice = input.nextInt() - 1;
            if (choice < 0 || choice >= spells.size()) { // input validation to make sure player selects valid enemy
                System.out.println("    "+pName+" cast confuse.");
                continue;
            }

            String spell = spells.get(choice);

            castSpell(spell);
        }

        System.out.println("\n    "+pName+" ran out of mana.");
        System.out.println("\n____________________________________________________________________________________________________\n");
    }

    // Method that casts a specific spell
    static void castSpell(String spell) {
        int spellWorked = rand.nextInt(20) + 1;
        if (spell.equals("Fireball")) {
            double fireSize = Math.random() + 0.5;
            int fireDamage = (int)((10.0*fireSize)*pMagicDmg);

            if (spellWorked == 20 && pSorcery >= 30) {
                int choice = 0;
                System.out.print("\n    Who will "+pName+" attack? (1-" + npcName.size() + "): ");
                choice = input.nextInt() - 1;

                if (choice < 0 || choice >= npcName.size()) { // input validation to make sure player selects valid enemy
                    System.out.println("    "+pName+" took a rip.");
                    pHealth += 10;
                    return;
                }

                npcHealth.set(choice, npcHealth.get(choice) - (fireDamage * 2));
                System.out.println("\n" + pName + ": En stor rumpe ildkule!\n");
                System.out.println("    " + pName + " cast Fireball and did " + fireDamage + " damage to " + npcName.get(choice));
            } else if (spellWorked > 10 && pSorcery >= 10) {
                int choice = 0;
                System.out.print("\n    Who will "+pName+" attack? (1-" + npcName.size() + "): ");
                choice = input.nextInt() - 1;

                if (choice < 0 || choice >= npcName.size()) { // input validation to make sure player selects valid enemy
                    System.out.println("    "+pName+" couldn't remember the words.");
                    return;
                }

                npcHealth.set(choice, npcHealth.get(choice) - fireDamage);
                System.out.println("\n" + pName + ": En stor ildkule!\n");
                System.out.println("    " + pName + " cast Fireball and did " + fireDamage + " damage to " + npcName.get(choice));
            } else if (spellWorked >= 5) {
                int choice = 0;
                System.out.print("\n    Who will "+pName+" attack? (1-" + npcName.size() + "): ");
                choice = input.nextInt() - 1;

                if (choice < 0 || choice >= npcName.size()) { // input validation to make sure player selects valid enemy
                    System.out.println("    "+pName+" couldn't remember the words.");
                    return;
                }

                npcHealth.set(choice, npcHealth.get(choice) - 10);
                System.out.println("\n" + pName + ": En ildkule!\n");
                System.out.println("    " + pName + " cast Fireball and did " + 10 + " damage to " + npcName.get(choice));
            } else {
                System.out.println("\n" + pName + ": In eldkule!\n");
                System.out.println("    " + pName + " messed up the cast...");
                pHealth -= 5;
            }
        } else if (spell.equals("Minor Heal")) {
            System.out.println("    Who will " + pName + " heal?\n");

            // Create a list of available targets
            ArrayList<String> targets = new ArrayList<>();
            targets.add(pName); // Player character
            if (warriorInParty && !isCompDead(wName)) {
                targets.add(wName);
            }
            if (mageInParty && !isCompDead(mName)) {
                targets.add(mName);
            }
            if (tankInParty && !isCompDead(tName)) {
                targets.add(tName);
            }
            if (rangeInParty && !isCompDead(rName)) {
                targets.add(rName);
            }
            if (!allyName.isEmpty()) {
                String aName = "";
                for (int i = 0; i < allyName.size(); i++) {
                    aName = allyName.get(i);
                    targets.add(aName);
                }
            }

            for (int i = 0; i < targets.size(); i++) { // for loop to display enemies
                System.out.println((i + 1) + ". " + targets.get(i));
            }
            System.out.println("");

            int choice = 0;
            int healChance = rand.nextInt(20) + 1;

            choice = input.nextInt() - 1;

            if (choice < 0 || choice >= npcName.size()) { // input validation to make sure player selects valid enemy
                System.out.println("    "+pName+" healed the air\n.");
                return;
            }

            String giveTo = targets.get(choice);

            if (healChance < 10) {
                System.out.println("    "+pName+" forgot the words!");
            } else if (giveTo.equals(pName)) {
                if ((pHealth + 10) > pMaxHealth) {
                    System.out.println("    "+pName+" cant heal more.");
                } else {
                    System.out.println(pName + ": Damihi Salutem!");
                    pHealth += 10;
                }
            } else if (giveTo.equals(wName)) {
                if ((wHealth + 10) > wMaxHealth) {
                    System.out.println("    "+pName+" cant heal " + wName + " more.");
                } else {
                    System.out.println(pName + ": G\u011Bi T\u0101men Jiànk\u0101ng!");
                    wHealth += 10;
                }
            } else if (giveTo.equals(mName)) {

            }  else if (giveTo.equals(tName)) {

            } else if (giveTo.equals(rName)) {

            } else if (!allyName.isEmpty() && giveTo.equals(allyName.get(choice))) {
                allyHealth.set(choice, allyHealth.get(choice) + 10);
            } else {
                System.out.println("    " + pName + " healed a rock!");
            }
        }
    }

    // Method that sets the weapon type and damage
    static void equipWeapon(String item) {
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
                    pWeaponDmg = (item.equals("NA Carbine MKII"))? 55 : 40;
                } else if (t5Weapons.contains(item)) {
                    pWeaponDmg = (item.equals("Dragonn KLR 20mm Anti-Matiriel Rifle"))? 100 : 50;
                } else {
                    pWeaponDmg = 0; // if weapon is not found, no damage
                }

                // Sets weapon type
                if (item.equals("Fists") || item.equals("Boxing Gloves") || item.equals("Brass Knuckles") || item.equals("Push Daggers") || item.equals("Gunpowder Gloves")) {
                    pWeaponType = "Unarmed";
                } else if (item.equals("Rusty Sword") || item.equals("War Sword") || item.equals("Mass Produced Katana") || item.equals("Claymore") || item.equals("Nekohito Steel Katana")) {
                    pWeaponType = "Bladed";
                } else if (item.equals("Wooden Club") || item.equals("Baseball Bat") || item.equals("Mace") || item.equals("Flail") || item.equals("Veridian Warhammer")) {
                    pWeaponType = "Blunt";
                } else if (item.equals("Sledgehammer") || item.equals("Woodsplitting Axe") || item.equals("Warworn Greatsword") || item.equals("Battleaxe") || item.equals("Empirian Greatsword")) {
                    pWeaponType = "Heavy";
                } else if (item.equals("Stick Wand") || item.equals("College of Sorcery Wand") || item.equals("Crystal Staff") || item.equals("Elfwood Wand") || item.equals("Archmage Staff")) {
                    pWeaponType = "Magic";
                } else if (item.equals("Handmade Bow") || item.equals("Ancient Longbow") || item.equals("Compound Bow") || item.equals("NA Carbine MKII") || item.equals("Dragonn KLR 20mm Anti-Matiriel Rifle")) {
                    pWeaponType = "Ranged";
                } else {
                    System.out.println("    What?");
                }

                pWeapon = item;
                isMagic();
                weaponEquipped = true;
                System.out.println("    " + pName + " has equipped a " + pWeapon + "!");
                pInvSpace -= 1;
            }
        } else {
            String newItem = item;
            if (item.equals(pWeapon)) {
                System.out.println("    You already have the " + item + " equipped.\n");
            }

            System.out.println("    You already have a weapon. Do you want to drop your "+pWeapon+"?\n"
                + "\n1. Keep current weapon\n2. Drop " + pWeapon + "\n"
            );

            playerSelection();
            switch (pSel) {
                case "1":
                    System.out.println("    " + pName + " kept " + proPos + " "+ pWeapon 
                        + ".\n    The " + item + " was sent to " + proPos +" inventory."
                    );
                    placeInInv(item);
                    break;
                case "2":
                    System.out.println("    You dropped your " + pWeapon + " and it fell through the floor.");
                    invItems.remove(pWeapon);
                    pWeapon = "";
                    pWeaponDmg = 0;
                    pWeaponType = "";
                    pInvSpace += 1;
                    weaponEquipped = false;
                    equipWeapon(newItem);
                    break;
                default:
                    System.out.println("    Nope");
                    equipWeapon(item);
            }
        }
    }

    // Method that gives the ranged weapons a purpose
    static int setRange() {
        if (pWeapon.equals("Handmade Bow")) {
            return 1;
        } else if (pWeapon.equals("Ancient Longbow")) {
            return 2;
        } else if (pWeapon.equals("Compound Bow")) {
            return 3;
        } else if (pWeapon.equals("NA Carbine MKII")) {
            return 5;
        } else if (pWeapon.equals("Dragonn KLR 20mm Anti-Matiriel Rifle")) {
            return 10;
        } else {
            return 0;
        }
    }

// --->   End of TBCS   <---










// --->   Status Effects   <---
    // Original stats
    static int oMaxHealth;
    static int oStamina;
    static double oMagicRes;
    static double oBladeRes;
    static double oBluntRes;
    static double oPoisonRes;
    static double oFireRes;
    static double oFrostRes;

    static final int MAX_EFFECTS = 9;
    static int[] effectDurations = new int[MAX_EFFECTS];
    static boolean[] effectActive = new boolean[MAX_EFFECTS];

    // positions of the effects in the list
    static final int POISONED_INDEX = 0;
    static final int ON_FIRE_INDEX = 1;
    static final int FROSTBITE_INDEX = 2;
    static final int HP_BOOST_INDEX = 3;
    static final int STAMINA_BOOST_INDEX = 4;
    static final int MAGIC_WARD_INDEX = 5;
    static final int ARMOUR_INDEX = 6;
    static final int BLESSED_INDEX = 7;

    // Method that gives player effects
    static void applyEffect(String effect, int time) {
        if (effect.equals("Poisoned")) {
            effectDurations[POISONED_INDEX] = time;
            effectActive[POISONED_INDEX] = true;
        } else if (effect.equals("On Fire")) {
            effectDurations[ON_FIRE_INDEX] = time;
            effectActive[ON_FIRE_INDEX] = true;
        } else if (effect.equals("Frostbite")) {
            effectDurations[FROSTBITE_INDEX] = time;
            effectActive[FROSTBITE_INDEX] = true;
        } else if (effect.equals("HpBoost")) {
            oMaxHealth = pMaxHealth;
            effectDurations[HP_BOOST_INDEX] = time;
            effectActive[HP_BOOST_INDEX] = true;
        } else if (effect.equals("StaminaBoost")) {
            oStamina = pStamina;
            effectDurations[STAMINA_BOOST_INDEX] = time;
            effectActive[STAMINA_BOOST_INDEX] = true;
        } else if (effect.equals("Ward")) {
            oMagicRes = pMagicRes;
            effectDurations[MAGIC_WARD_INDEX] = time;
            effectActive[MAGIC_WARD_INDEX] = true;
        } else if (effect.equals("Armour")) {
            oBladeRes = pBladeRes;
            oBluntRes = pBluntRes;
            effectDurations[ARMOUR_INDEX] = time;
            effectActive[ARMOUR_INDEX] = true;
        }  else if (effect.equals("Blessed")) {
            oMaxHealth = pMaxHealth;
            oStamina = pStamina;
            oMagicRes = pMagicRes;
            oBladeRes = pBladeRes;
            oBluntRes = pBluntRes;
            oPoisonRes = pPoisonRes;
            oFireRes = pFireRes;
            oFrostRes = pFrostRes;
            effectDurations[BLESSED_INDEX] = time;
            effectActive[BLESSED_INDEX] = true;
        }
    }

    // Method that removes effects from player
    static void updateEffects() {
        for (int i = 0; i < MAX_EFFECTS; i++) {
            if (effectActive[i]) {
                if (effectDurations[i] > 0) {
                    if (i == POISONED_INDEX) { // Apply poison damage
                        pHealth -= 3;
                    }
                    if (i == ON_FIRE_INDEX) { // Apply Fire damage
                        pHealth -= 5;
                    }
                    if (i == FROSTBITE_INDEX) { // Apply Frostbite damage
                        pHealth -= 3;
                    }
                    if (i == HP_BOOST_INDEX) { // Apply max health boost
                        pMaxHealth += 30;
                    }
                    if (i == STAMINA_BOOST_INDEX) { // Apply stamina boost
                        pStamina += 10;
                    }
                    if (i == MAGIC_WARD_INDEX) { // Apply ward effect
                        pMagicRes += 1.0;
                    }
                    if (i == ARMOUR_INDEX) { // Apply bubble shield effect
                        pBladeRes += 1.0;
                        pBluntRes += 1.0;
                    }
                    if (i == BLESSED_INDEX) { // Apply blessed effect
                        pMaxHealth += 50; 
                        pBladeRes += 1.0;
                        pBluntRes += 1.0;
                        pMagicRes += 1.0;
                        pPoisonRes += 1.0;
                        pFireRes += 1.0;
                        pFrostRes += 1.0;
                    }
                    effectDurations[i]--;
                }
                // Remove effect if duration expires
                if (effectDurations[i] == 0) {
                    effectActive[i] = false;

                    if (i == HP_BOOST_INDEX) { // Revert max health
                        pMaxHealth = oMaxHealth;
                    } else if (i == STAMINA_BOOST_INDEX) { // Revert stamina
                        pStamina = oStamina;
                    } else if (i == MAGIC_WARD_INDEX) { // Revert magic resistance
                        pMagicRes = oMagicRes;
                    } else if (i == ARMOUR_INDEX) { // Revert blade and blunt resistance
                        pBladeRes = oBladeRes;
                        pBluntRes = oBluntRes;
                    } else if (i == BLESSED_INDEX) { // Revert all blessed effects
                        pMaxHealth = oMaxHealth;
                        pStamina = oStamina;
                        pMagicRes = oMagicRes;
                        pBladeRes = oBladeRes;
                        pBluntRes = oBluntRes;
                        pPoisonRes = oPoisonRes;
                        pFireRes = oFireRes;
                        pFrostRes = oFrostRes;
                    }
                }
            }
        }
    }

// --->   End Of Status Effects   <---



// --->   Leaving Function Junction   <---










// This should run everything
    public static void main(String args[]){

        popWeaponArrays();
        popLocList();

        System.out.println(welcomeMsg);

        characterSelection();

        System.out.println("\n\nGame loop ended... Entering debug area\n\n");

        addNPC("Silly Fella", 100, 10, "Bladed", 100, true);
        addNPC("Goober", 100, 10, "Blunt", 100, true);
        pHealth -= 50;
        gotMad();

        // nightmare loop (for debugging ofc)
        for (int i = 0; i < 50; i++)
            System.out.println("Nightmare");

        // Dragon Fight test
        
        equipWeapon("Dragonn KLR 20mm Anti-Matiriel Rifle"); // will be worth 1,000,000 schmeeps in final game
        addNPC("Dragon", 500, 50, "Fire", 100, true);
        gotMad();

        System.out.println("\n\nThats it for now. Thanks for playing :)\n\n");
    }
}


