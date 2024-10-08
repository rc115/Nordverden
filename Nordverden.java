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
* Inspirations: Fallout 1 & 2 by Interplay, TES: Skyrim by Bethesda, and Magic The Noah
* 
*/


import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;


public class Nordverden {
    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();





// --->   VarHell Starts here  <---
// (Variables are static to be used globally)

    // String Variables
    static String welcomeMsg = ( "\n"
        + "\n    Welcome to"
        + "\n          __              _                   _            "
        + "\n       /\\ \\ \\___  _ __ __| |_   _____ _ __ __| | ___ _ __  "
        + "\n      /  \\/ / _ \\| '__/ _` \\ \\ / / _ \\ '__/ _` |/ _ \\ '_ \\ "
        + "\n     / /\\  / (_) | | | (_| |\\ V /  __/ | | (_| |  __/ | | |"
        + "\n     \\_\\ \\/ \\___/|_|  \\__,_| \\_/ \\___|_|  \\__,_|\\___|_| |_|"
        + "\n                                       Version 0.014.100824"
        + "\n" 
    );

    static String pSel = "";
    static String pStatsDisplay = "";
    static String pStatsInfo = "";
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
    static int pKarma = 0;

    static boolean pRaceSet = false; // var for if the player set their character's race
    static boolean pClassSet = false; // var for if the player set their character's class
    static boolean karmaSet = false; // var for if the player set their character's karma
    static boolean pStartEquip = false; // var for if the player choose their starting equipment

    // boolean variables for each race
    static boolean pVerdian = false;
    static boolean pEmpirian = false;
    static boolean pOrc = false;
    static boolean pDarkElf = false;
    static boolean pWoodElf = false;
    static boolean pNekohito = false;
    static boolean pDragonborn = false;
    static boolean pNekoPassport = false;

    static int pGold = 5; // Nordverden currency
    static int pCoins = 0; // Empirian currency
    static int pSchmeeps = 0; // Nekohito currency
    static int goldToConvert = 0; // ammount of gold to convert
    static int coinsToConvert = 0; // ammount of coins to convert
    static int schmeepsToConvert = 0; // ammount of schmeeps to convert
    static int goldToCoin = (goldToConvert*10); // calculation for gold to coin conversion
    static int cointToGold = (coinsToConvert/8); // calculation for coin to gold conversion
    static int goldToSchmeep = (goldToConvert*100); // calculation for gold to schmeep conversion
    static int schmeepToGold = (schmeepsToConvert/100); // calculation for schmeep to gold conversion

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

    // player character's skills
    static int pStrenght = 0;
    static int pSpeech = 0;
    static int pStamina = 0;
    static int pSorcery = 0;
    static int pSneak = 0;
    // player character's damage resistance
    static double pBladeRes = 0.0;
    static double pBluntRes = 0.0;
    static double pMagicRes = 0.0;
    static double pPoisonRes = 0.0;
    static double pFireRes = 0.0;
    static double pFrostRes = 0.0;
    // player character's damage multipliers
    static double pUnarmedDmg = 0.0;
    static double pBladeDmg = 0.0;
    static double pBluntDmg = 0.0;
    static double pHeavyDmg = 0.0;
    static double pMagicDmg = 0.0;
    static double pRangedDmg = 0.0;

    // Variables for IMS
    static int pInvSpace = 5; // player inventory space
    static ArrayList<String> invItems = new ArrayList<>(); // items in inventory

    // Bakpacks
    static boolean backpackEquiped = false;
    static boolean bSmallBag = false; // +2 inventory
    static boolean bRugsack = false; // +4 inventory
    static boolean bJanksportBackpack = false; // +5 inventory
    static boolean bLargeBackpack = false; // +10 inventory
    static boolean bQuatumBag = false; // +95 inventory
    static boolean bBlackHole = false; // 0 inventory

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

    //Combat Variables
    static boolean weaponEquipped = false;
    static String pWeapon = "";
    static String pArmour = "";
    static int combatStamina = pStamina;
    static int pHitChance = 0; // Character's hit chance (1-20) [<10 hits]
    static int pDisToTar = 0; // Character's distance to targeted enemy (>=2 is Melee <2 isRanged)
    static int pWeaponDmg = 0; // Character's current weapon damage (T1 = 10, T2 = 20, ... T5 = 50[Max])
    static String pWeaponType = "none"; // type of weapon character is using
    static double dmgMult = 0.0; // Characte's damage multiplier (depends on weapon type)
    static double dmgRes = 0.0; // Character's damage resistance (depens on damage type)
    static int eDmgToP = 0; // damage done to player if enemy hits

    static double pDamageCalc = ((pWeaponDmg*dmgMult) + (pStrenght*0.25)); // calculates character's damage
    static double pHurtCalc = (pHealth - (eDmgToP/(dmgRes+0.5)));
    
    static int eHitChance = 0; // Enemy's hit chance (1-20) [<10 hits]
    static int e1DisToP = 0; // Enemy(1) distance to player (>=2 melee, <2 ranged)
    static int e2DisTop = 0; // Enemy(2) distance to player (>=2 melee, <2 ranged)
    static int e3DisTop = 0; // Enemy(3) distance to player (>=2 melee, <2 ranged)

    // Enemy(s) health (chages depending on enemy)
    static int e1Health = 0;
    static int e2Health = 0;
    static int e3Health = 0;

    // Enemy(s) damage (chages depending on enemy) [T1 = 10, T2 = 20, ... T5 = 50]
    static int e1Damage = 0; 
    static int e2Damage = 0;
    static int e3Damage = 0;

    // Enemy(s) name(s) [not important but still]
    static String e1Name = "";
    static String e2Name = "";
    static String e3Name = "";

    // Long Ahh List of Weapons
    static ArrayList<String> allWeapons = new ArrayList<>();
    static ArrayList<String> t1Weapons = new ArrayList<>();
    static ArrayList<String> t2Weapons = new ArrayList<>();
    static ArrayList<String> t3Weapons = new ArrayList<>();
    static ArrayList<String> t4Weapons = new ArrayList<>();
    static ArrayList<String> t5Weapons = new ArrayList<>();

    // Location Array
    static ArrayList<String> locList = new ArrayList<>();

// -->   End of VarHell   <---
//










// --->   Function Junction   <---
// 

    // Function that displays character's info
    static void pDisplayCharacter() {
        System.out.println("    This is your character:\n"
            + "    Name: " + pName + " (" + proSub + "/" + proObj + "/" + proPos + ")\n"
            + "    Race: " + pRace + "\n"
            + "    Class: " + pClass + "\n"
            + "    Health: " + pHealth + "/" + pMaxHealth + "\n"
            + "    Level: " + pLevel + " (" + pCurXp + "/" + pNextLvl + ")\n\n"
            + "    Karma: " + pKarma + "\n"

            + "    These are " + proPos + " stats:\n"
            + "    "
        );
    }

    // Function that takes the players's input
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

    // Functions that display character stats
    static void playerStatsDisplay() {
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





    // --->   Inventory Management System   <---

    // Function that places items in the character's inventory
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

    // Function that lets user use an item
    static void useItem() {
        if (invItems.isEmpty()) {
            System.out.println(pName + "'s inventory is empty.");
            return;
        }

        System.out.println("    Select an item to use:\n");
        for (int i = 0; i < invItems.size(); i++) {
            System.out.println((i + 1) +". " + invItems.get(i));
        }

        int choice = 0;

        while (choice < 1 || choice > invItems.size()) {
            System.out.print("Enter your choice (1-" + invItems.size() + "): ");
            if (input.hasNextInt()) {
                choice = input.nextInt();
                if (choice < 1 || choice > invItems.size()) {
                    System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("That's not a valid number. Please try again.");
                input.next(); // Clear the invalid input
            }
        }

        String item = invItems.get(choice - 1);

        if (allWeapons.contains(item)){
            isWeapon(item);
        }
        // isArmour(item);
        // isPotion(item);
    }


    // Function that displays items in the character's inventory
    static void showInventory() {
        System.out.println("\n    Inventory: " + invItems);
        System.out.println("    Available slots: " + pInvSpace + "\n");
    }

    //Function that equips a backpack
    static void equipBackpack() {
        if (backpackEquiped == false) {
            if (bSmallBag == true) {
                System.out.println("    " + pName + " has equiped a Small Bag\n");
                pInvSpace += 2;
            } else if (bRugsack == true) {
                System.out.println("   " + pName + " has equiped a Rugsack\n");
                pInvSpace += 4;
            } else if (bJanksportBackpack == true) {
                System.out.println("   " + pName + " has equiped a Janksport\n");
                pInvSpace += 5;
            } else if (bLargeBackpack == true) {
                System.out.println("   " + pName + " has equiped a Camping Bag\n");
                pInvSpace += 10;
            } else if (bQuatumBag == true) {
                System.out.println("   " + pName + " has equiped a QIIS MK1 Backpack\n");
                pInvSpace += 95;
            } else if (bBlackHole == true) {
                System.out.println("   " + pName + " has unfortunately equiped a Black Hole\n");
                pInvSpace = 0;
            }
            backpackEquiped = true;
        } else if (backpackEquiped == true) {
            System.out.println("    " + pName + " already has a backpack equipped.\n"
                + "    Would you like to uneqip it?"
            );
            System.out.println("1. Keep Current backpack.\n2. Unequip backpack");

            playerSelection();
            switch (pSel) {
                case "1":
                    break;
                case "2": 
                    if (bSmallBag == true) {
                        System.out.println("    " + pName + " has unequiped the Small Bag");
                        pInvSpace -= 2;
                        bSmallBag = false;
                    } else if (bRugsack == true) {
                        System.out.println("   " + pName + " has unequiped the Rugsack");
                        pInvSpace -= 4;
                        bRugsack = false;
                    } else if (bJanksportBackpack == true) {
                        System.out.println("   " + pName + " has unequiped the Janksport\n");
                        pInvSpace -= 5;
                        bJanksportBackpack = false;
                    } else if (bLargeBackpack == true) {
                        System.out.println("   " + pName + " has unequiped the Camping Bag\n");
                        pInvSpace -= 10;
                        bLargeBackpack = false;
                    } else if (bQuatumBag == true) {
                        System.out.println("   " + pName + " has unequiped the QIIS MK1 Backpack\n");
                        pInvSpace -= 95;
                        bQuatumBag = false;
                    } 

                    backpackEquiped = false;
                    equipBackpack();
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("   Idk");
        }
    }

    // ---> End of IMS   <---





    // --->   Character Creator   <---

    //
    // Function that initializes the character creator
    static void characterSelection() {
        System.out.println("\n    Would you like to create a custom character or choose a premade character?\n"
            + "\n1. Create a Custom Character\n2. Choose a Preset\n"
        );

        playerSelection();
        if (pSel.equals("1")) {
            System.out.println("\n    Would you like to view the info on all stats "
                + "or modify them right now?\n"
                + "\n1. View info on stats\n2. Customize stats\n"
            );

            playerSelection();
            switch(pSel) {
                case "2":
                    customizeStats();
                    break;
                case "1": 
                    playerStatsInfo(); 
                    characterSelection();
                    break;
                default: System.out.println("\n           no... its either 1 or 2\n"); characterSelection();
            }
        } else if (pSel.equals("2")) {
            System.out.println("\n    That's not in the game yet sorry.");
            characterSelection();
        } else{
            System.out.println("\n        That didn't work for some reason.");
            characterSelection();
        }
    }

    // Function that modifies the character's stats   <<----- Very Important for character creator
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
        if ((skillPts == 0) && (conSkills == false)){
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
        if ((resistPts == 0) && (conResists == false)){
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
        if ((damagePts == 0) && (conDamage == false)){
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
        if (conFinalStats == false) {
            // starts the skill point distribution chain
            if (skillPts > 0) {
                System.out.println("\n    You have " + skillPts + " skill points to spend.");
                System.out.println("    Which Skill would you like to modify?"
                    + "\n\n1. Strenght ("+ pStrenght +"/100) [10 recommended]"
                    + "\n2. Speech ("+ pSpeech +"/100) [10 recommended]"
                    + "\n3. Stamina ("+ pStamina +"/100) [30 recommended]"
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
                    + "\n\n1. Bladed Damage Res. ("+ pBladeRes +") [1.0 recommended]"
                    + "\n2. Blunt Damage Res. ("+ pBluntRes +") [0.5 recommended]"
                    + "\n3. Magic Res. ("+ pMagicRes +") [0.5 recommended]"
                    + "\n4. Poison Res. ("+ pPoisonRes +") [0.5 recommended]"
                    + "\n5. Fire Res. ("+ pFireRes +") [0.5 recommended]"
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
                    + "\n2. Bladed Damage ("+ pBladeDmg +") [1.0 Recommended]"
                    + "\n3. Blunt Damage ("+ pBluntDmg +") [1.0 recommended]"
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
            } else if (conSkills == true && conResists == true && conDamage == true) {
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
        if (pClassSet == false){
            charClassSel();
        }

        // lets the player choose their character's race
        if (pRaceSet == false) {
            charRaceSel();
        }

        // lets the player choose their character's karma
        if (karmaSet == false) {
            startingKarma();
        }

        // lets the player choose their starting equipment
        if (pStartEquip == false) {
            startingEquipment();
        }
    }

    // Functions for if the player runs out of points
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

    // Functions for assigning points to skills
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

    // Functions for assigning points to resistances
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

    // Functions for assigning points to damage mults.
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

    // Functions that resets the character's stats
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

    // Functions for choosing the character's race
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
                + "\n1. Verdian [Recommended]\n2. Empirian\n3. Orc\n4. Dark Elf\n5. Wood Elf\n6. Nekohito\n7. Dragonborn\n8. View Info on Races\n"
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
            pStrenght -= 10;
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
                    pStrenght += 10;
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

    // Functions for choosing the character's class
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
                + "\n1. Villager\n2. Warrior [Recommended]\n3. Tank\n4. Mage\n5. Archer\n6. Gambler\n7. View Class info\n"
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
            placeInInv("Rusty Sword");
            System.out.println("\n    Your character is now a Warrior.\n");
        } else if (pClass.equals("Tank")) {
            pBladeRes += 1;
            pBluntRes += 1;
            System.out.println("\n    Your character is now a Tank.\n");
        } else if (pClass.equals("Mage")) {
            pSorcery += 15;
            placeInInv("Stick Wand");
            System.out.println("\n    Your character is now a Mage.\n");
        } else if (pClass.equals("Archer")) {
            pSneak += 15;
            placeInInv("Handmade Bow");
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
                    invItems.remove("Rusty Sword");
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

    //Function for choosing the character's karma
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

    // Function for choosing character's starting equipment
    static void startingEquipment() {
        System.out.println("\n    What will you take with you?\n    Note: You may only take one.\n");
        System.out.println("\n1. Rusty Sword\n2. Wooden Hammer\n3. Handmade Bow\n4. Stick Wand"
            + "\n5. Leather Armour\n6. Stamina Potion\n7. Health Potion\n8. Small Bag\n9. Gold Sack\n"
        );

        playerSelection();
        switch(pSel) {
            case "1": placeInInv("Rusty Sword"); break;
            case "2": placeInInv("Wooden Hammer"); break;
            case "3": placeInInv("Handmade Bow"); break;
            case "4": placeInInv("Stick Wand"); break;
            case "5": placeInInv("Leather Armour");break;
            case "6": placeInInv("Stamina Potion");break;
            case "7": placeInInv("Health Potion");break;
            case "8": bSmallBag = true; equipBackpack(); break;
            case "9": pGold += ((rand.nextInt(5)) + 1); break;
            default:
        }

        pStartEquip = true;
        customizeStats();
    }

    // --->   End of Character Creator   <---





    // --->   Missile Logic (it knows where it is because it knows where it isnt)   <---

    // All Possible Locations
    static void popLocList() {
        locList.add("Capital"); // Northern most point of the map
        locList.add("Nekomura"); // Eastern most point of the map
        locList.add("Desert"); // Center of the map
        locList.add("Barbarians"); // Southern most point of the map
        locList.add("Colony"); // Western most point of the map
        locList.add("River"); // East of {Colony}, Southwest of {Capital}, Northwest of {Desert}
        locList.add("Orcs"); // East of {Desert}, South of {Forrest}, West of {Coast}, North of {Plains}
        locList.add("Coast"); // East of {Orcs}, West of {Nekomura}
        locList.add("Plains"); // South of {Orcs}, East of {Barbarians}
        locList.add("Forrest"); // Southeast of {College}, Northeast of {Orcs}, Northwest of {Coast}
        locList.add("Cave"); // South of {River}, Southwest of {Desert}, East of {Colony}
        locList.add("College"); // East of {Capital}, West of {Forrest}, Northwest of {Orcs}

    }

    // Funtion that lets player choose their movement
    static void pMover(String pLocation) {
        if (pLocation.equals("Capital")){
            System.out.println("    The capital is the northern most point in Nordverden."
                + "\n1. "+pName+" cannot go North."
                + "\n2. "+pName+" can go Northeast to go towards the College of Sorcery."
                + "\n3. "+pName+" can go East to go towards the Forrest."
                + "\n4. "+pName+" can go Southeast to go to Orc Territory."
                + "\n5. "+pName+" can go South towards the desert."
                + "\n6. "+pName+" can go Southwest to go towards the River."
                + "\n7. "+pName+" can go West towards the Northern Mountains."
                + "\n8. "+pName+" can go Northwest towards the Nothern Mountains"
                + "\n9. Enter the Capital.\n"
            );

            playerSelection();
            switch(pSel) {
                case "1": System.out.println("    "+pName+" cannot go north"); pMover(pLocation); break;
                case "2": System.out.println("    "+pName+" goes northeast."); playerLocator("College"); break;
                case "3": System.out.println("    "+pName+" goes East"); playerLocator("Forrest"); break;
                case "4": System.out.println("    "+pName+" goes Southeast"); playerLocator("Orcs"); break;
                case "5": System.out.println("    "+pName+" goes South"); playerLocator("Desert"); break;
                case "6": System.out.println("    "+pName+" goes Southwest"); playerLocator("River"); break;
                case "7": System.out.println("    "+pName+" goes West"); playerLocator("{temp}"); break;
                case "8": System.out.println("    "+pName+" goes Northwest"); playerLocator("{temp}"); break;
                case "9": System.out.println("    "+pName+" Enters the capital"); break;
                default: System.out.println("Cant go there"); pMover(pLocation);
            }
        } else if (pLocation.equals("Nekomura")) {
            System.out.println("    Nekomura is a remote island to the east of Nordverden."
                + "\n1. "+pName+" cannot go North."
                + "\n2. "+pName+" cannot go Northeast."
                + "\n3. "+pName+" cannot go East."
                + "\n4. "+pName+" cannot go Southeast."
                + "\n5. "+pName+" cannot go South."
                + "\n6. "+pName+" cannot go Southwest."
                + "\n7. "+pName+" cannot go West."
                + "\n8. "+pName+" can go Northwest to cross the Fishy Islands."
                + "\n9. Stay in Nekomura\n"
            );

            playerSelection();
            switch(pSel) {
                case "1": 
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7": System.out.println("    "+pName+" cannot go there.\n"); pMover("Nekomura"); break;
                case "8": System.out.println("    "+pName+" goes back to Nordverden.\n");
                    playerLocator("Coast");
                    break;
                case "9": System.out.println("    "+pName+" stayed in Nekomura"); break;
                default: System.out.println("Can't go there."); pMover(pLocation);
            }
        } else if (pLocation.equals("Desert")) {
            System.out.println("    The Desert is in the center of the map."
                + "\n1. "+pName+" can go North to the Capital."
                + "\n2. "+pName+" can go Northeast to Orc Territory."
                + "\n3. "+pName+" can go East to Orc Territory."
                + "\n4. "+pName+" can go Southeast to Barbarian Territory."
                + "\n5. "+pName+" can go South to Barbarian Territory."
                + "\n6. "+pName+" can go Southwest to the Cave."
                + "\n7. "+pName+" can go West to the Cave."
                + "\n8. "+pName+" can go Northwest to the River."
                + "\n9. Go to the desert Village\n"
            );

            playerSelection();
            switch(pSel) {
                case "1": System.out.println("    "+pName+" goes North."); playerLocator("Capital"); break;
                case "2": System.out.println("    "+pName+" goes Northeast."); playerLocator("Orcs"); break;
                case "3": System.out.println("    "+pName+" goes East."); playerLocator("Orcs"); break;
                case "4": System.out.println("    "+pName+" goes Southeast."); playerLocator("Barbarians"); break;
                case "5": System.out.println("    "+pName+" goes South."); playerLocator("Barbarians"); break;
                case "6": System.out.println("    "+pName+" goes Southwest."); playerLocator("Cave"); break;
                case "7": System.out.println("    "+pName+" goes West."); playerLocator("Cave"); break;
                case "8": System.out.println("    "+pName+" goes Northwest."); playerLocator("River"); break;
                default: System.out.println("Can't go there."); pMover(pLocation);
            }
        } else if (pLocation.equals("Barbarians")) {
            System.out.println("    Barbarian territory is the southernmost point."
                + "\n1. "+pName+" cannot go South."
                + "\n2. "+pName+" can go Northeast to the Plains."
                + "\n3. "+pName+" can go East to the Plains."
                + "\n4. "+pName+" can go Southeast to {temp}."
                + "\n5. "+pName+" can go North to the Desert."
                + "\n6. "+pName+" can go Northwest to the Cave."
                + "\n7. "+pName+" can go West to {temp}."
                + "\n8. "+pName+" can go Southwest to {temp}."
            );
    
            playerSelection();
            switch(pSel) {
                case "1": System.out.println("    "+pName+" cannot go South."); pMover(pLocation); break;
                case "2": System.out.println("    "+pName+" goes Northeast."); playerLocator("Plains"); break;
                case "3": System.out.println("    "+pName+" goes East."); playerLocator("Plains"); break;
                case "4": System.out.println("    "+pName+" goes Southeast."); playerLocator("{temp}"); break;
                case "5": System.out.println("    "+pName+" goes North."); playerLocator("Desert"); break;
                case "6": System.out.println("    "+pName+" goes Northwest."); playerLocator("Cave"); break;
                case "7": System.out.println("    "+pName+" goes West."); playerLocator("{temp}"); break;
                case "8": System.out.println("    "+pName+" goes Southwest."); playerLocator("{temp}"); break;
                default: System.out.println("Can't go there."); pMover(pLocation);
            }
        } else if (pLocation.equals("Colony")) {
            System.out.println("    The Colony is in the west."
                + "\n1. "+pName+" cannot go West."
                + "\n2. "+pName+" can go Northeast to the River."
                + "\n3. "+pName+" can go East to the Cave."
                + "\n4. "+pName+" can go Southeast to the Desert."
                + "\n5. "+pName+" can go South to {temp}."
                + "\n6. "+pName+" can go Southwest to {temp}."
                + "\n7. "+pName+" can go Northwest to {temp}."
                + "\n8. "+pName+" can go North to the Capital."
            );
    
            playerSelection();
            switch(pSel) {
                case "1": System.out.println("    "+pName+" cannot go West."); pMover(pLocation); break;
                case "2": System.out.println("    "+pName+" goes Northeast."); playerLocator("River"); break;
                case "3": System.out.println("    "+pName+" goes East."); playerLocator("Cave"); break;
                case "4": System.out.println("    "+pName+" goes Southeast."); playerLocator("Desert"); break;
                case "5": System.out.println("    "+pName+" goes South."); playerLocator("{temp}"); break;
                case "6": System.out.println("    "+pName+" goes Southwest."); playerLocator("{temp}"); break;
                case "7": System.out.println("    "+pName+" goes Northwest."); playerLocator("{temp}"); break;
                case "8": System.out.println("    "+pName+" goes North."); playerLocator("Capital"); break;
                default: System.out.println("Can't go there."); pMover(pLocation);
            }
        } else if (pLocation.equals("River")) {
            System.out.println("    The River is located east of the Colony."
                + "\n1. "+pName+" can go North to the Capital."
                + "\n2. "+pName+" can go Northeast to the College."
                + "\n3. "+pName+" can go East to the Desert."
                + "\n4. "+pName+" can go Southeast to the Cave."
                + "\n5. "+pName+" can go South to the Desert."
                + "\n6. "+pName+" can go Southwest to the Colony."
                + "\n7. "+pName+" can go West to the Colony."
                + "\n8. "+pName+" can go Northwest to the Capital."
            );
        
            playerSelection();
            switch(pSel) {
                case "1": System.out.println("    "+pName+" goes North."); playerLocator("Capital"); break;
                case "2": System.out.println("    "+pName+" goes Northeast."); playerLocator("College"); break;
                case "3": System.out.println("    "+pName+" goes East."); playerLocator("Desert"); break;
                case "4": System.out.println("    "+pName+" goes Southeast."); playerLocator("Cave"); break;
                case "5": System.out.println("    "+pName+" goes South."); playerLocator("Desert"); break;
                case "6": System.out.println("    "+pName+" goes Southwest."); playerLocator("Colony"); break;
                case "7": System.out.println("    "+pName+" goes West."); playerLocator("Colony"); break;
                case "8": System.out.println("    "+pName+" goes Northwest."); playerLocator("Capital"); break;
                default: System.out.println("Can't go there."); pMover(pLocation);
            }
        } else if (pLocation.equals("Orcs")) {
            System.out.println("    Orc Territory is located east of the Desert."
                + "\n1. "+pName+" can go North to the Forrest."
                + "\n2. "+pName+" can go Northeast to the College."
                + "\n3. "+pName+" can go East to the Coast."
                + "\n4. "+pName+" can go Southeast to the Plains."
                + "\n5. "+pName+" can go South to the Desert."
                + "\n6. "+pName+" can go Southwest to the Cave."
                + "\n7. "+pName+" can go West to the Desert."
                + "\n8. "+pName+" can go Northwest to the River."
            );
        
            playerSelection();
            switch(pSel) {
                case "1": System.out.println("    "+pName+" goes North."); playerLocator("Forrest"); break;
                case "2": System.out.println("    "+pName+" goes Northeast."); playerLocator("College"); break;
                case "3": System.out.println("    "+pName+" goes East."); playerLocator("Coast"); break;
                case "4": System.out.println("    "+pName+" goes Southeast."); playerLocator("Plains"); break;
                case "5": System.out.println("    "+pName+" goes South."); playerLocator("Desert"); break;
                case "6": System.out.println("    "+pName+" goes Southwest."); playerLocator("Cave"); break;
                case "7": System.out.println("    "+pName+" goes West."); playerLocator("Desert"); break;
                case "8": System.out.println("    "+pName+" goes Northwest."); playerLocator("River"); break;
                default: System.out.println("Can't go there."); pMover(pLocation);
            }
        } else if (pLocation.equals("Coast")) {
            System.out.println("    The Coast is located east of Orc Territory."
                + "\n1. "+pName+" cannot go East."
                + "\n2. "+pName+" can go Northeast to {temp}."
                + "\n3. "+pName+" can go East to Nekomura."
                + "\n4. "+pName+" can go Southeast to {temp}."
                + "\n5. "+pName+" can go South to Orc Territory."
                + "\n6. "+pName+" can go Southwest to Orc Territory."
                + "\n7. "+pName+" can go West to Orc Territory."
                + "\n8. "+pName+" can go Northwest to the Forrest."
            );
        
            playerSelection();
            switch(pSel) {
                case "1": System.out.println("    "+pName+" cannot go East."); pMover(pLocation); break;
                case "2": System.out.println("    "+pName+" goes Northeast."); playerLocator("{temp}"); break;
                case "3": System.out.println("    "+pName+" goes East."); playerLocator("Nekomura"); break;
                case "4": System.out.println("    "+pName+" goes Southeast."); playerLocator("{temp}"); break;
                case "5": System.out.println("    "+pName+" goes South."); playerLocator("Orcs"); break;
                case "6": System.out.println("    "+pName+" goes Southwest."); playerLocator("Orcs"); break;
                case "7": System.out.println("    "+pName+" goes West."); playerLocator("Orcs"); break;
                case "8": System.out.println("    "+pName+" goes Northwest."); playerLocator("Forrest"); break;
                default: System.out.println("Can't go there."); pMover(pLocation);
            }
        } else if (pLocation.equals("Plains")) {
            System.out.println("    The Plains are located south of Orc Territory."
                + "\n1. "+pName+" can go North to Orc Territory."
                + "\n2. "+pName+" can go Northeast to the Coast."
                + "\n3. "+pName+" can go East to {temp}."
                + "\n4. "+pName+" can go Southeast to {temp}."
                + "\n5. "+pName+" cannot go South."
                + "\n6. "+pName+" can go Southwest to the Cave."
                + "\n7. "+pName+" can go West to the Barbarians."
                + "\n8. "+pName+" can go Northwest to the Desert."
            );
        
            playerSelection();
            switch(pSel) {
                case "1": System.out.println("    "+pName+" goes North."); playerLocator("Orcs"); break;
                case "2": System.out.println("    "+pName+" goes Northeast."); playerLocator("Coast"); break;
                case "3": System.out.println("    "+pName+" goes East."); playerLocator("{temp}"); break;
                case "4": System.out.println("    "+pName+" goes Southeast."); playerLocator("{temp}"); break;
                case "5": System.out.println("    "+pName+" cannot go South."); pMover(pLocation); break;
                case "6": System.out.println("    "+pName+" goes Southwest."); playerLocator("Cave"); break;
                case "7": System.out.println("    "+pName+" goes West."); playerLocator("Barbarians"); break;
                case "8": System.out.println("    "+pName+" goes Northwest."); playerLocator("Desert"); break;
                default: System.out.println("Can't go there."); pMover(pLocation);
            }
        } else if (pLocation.equals("Forrest")) {
            System.out.println("    The Forrest is located southeast of the College."
                + "\n1. "+pName+" can go North to the College."
                + "\n2. "+pName+" can go Northeast to the Capital."
                + "\n3. "+pName+" can go East to the Coast."
                + "\n4. "+pName+" can go Southeast to Orc Territory."
                + "\n5. "+pName+" can go South to Orc Territory."
                + "\n6. "+pName+" can go Southwest to Orc Territory."
                + "\n7. "+pName+" can go West to the River."
                + "\n8. "+pName+" can go Northwest to the College."
            );
        
            playerSelection();
            switch(pSel) {
                case "1": System.out.println("    "+pName+" goes North."); playerLocator("College"); break;
                case "2": System.out.println("    "+pName+" goes Northeast."); playerLocator("Capital"); break;
                case "3": System.out.println("    "+pName+" goes East."); playerLocator("Coast"); break;
                case "4": System.out.println("    "+pName+" goes Southeast."); playerLocator("Orcs"); break;
                case "5": System.out.println("    "+pName+" goes South."); playerLocator("Orcs"); break;
                case "6": System.out.println("    "+pName+" goes Southwest."); playerLocator("Orcs"); break;
                case "7": System.out.println("    "+pName+" goes West."); playerLocator("River"); break;
                case "8": System.out.println("    "+pName+" goes Northwest."); playerLocator("College"); break;
                default: System.out.println("Can't go there."); pMover(pLocation);
            }
        } else if (pLocation.equals("Cave")) {
            System.out.println("    The Cave is located southwest of the Desert."
                + "\n1. "+pName+" can go North to the River."
                + "\n2. "+pName+" can go Northeast to the Desert."
                + "\n3. "+pName+" can go East to Orc Territory."
                + "\n4. "+pName+" can go Southeast to Orc Territory."
                + "\n5. "+pName+" can go South to the Barbarians."
                + "\n6. "+pName+" can go Southwest to the Colony."
                + "\n7. "+pName+" can go West to the Colony."
                + "\n8. "+pName+" can go Northwest to the River."
            );
        
            playerSelection();
            switch(pSel) {
                case "1": System.out.println("    "+pName+" goes North."); playerLocator("River"); break;
                case "2": System.out.println("    "+pName+" goes Northeast."); playerLocator("Desert"); break;
                case "3": System.out.println("    "+pName+" goes East."); playerLocator("Orcs"); break;
                case "4": System.out.println("    "+pName+" goes Southeast."); playerLocator("Orcs"); break;
                case "5": System.out.println("    "+pName+" goes South."); playerLocator("Barbarians"); break;
                case "6": System.out.println("    "+pName+" goes Southwest."); playerLocator("Colony"); break;
                case "7": System.out.println("    "+pName+" goes West."); playerLocator("Colony"); break;
                case "8": System.out.println("    "+pName+" goes Northwest."); playerLocator("River"); break;
                default: System.out.println("Can't go there."); pMover(pLocation);
            }
        } else if (pLocation.equals("College")) {
            System.out.println("    The College of Sorcery is northeast of the Capital."
                + "\n1. "+pName+" can go North to the Capital."
                + "\n2. "+pName+" can go Northeast to {temp}."
                + "\n3. "+pName+" can go East to the Forrest."
                + "\n4. "+pName+" can go Southeast to Orc Territory."
                + "\n5. "+pName+" can go South to the Desert."
                + "\n6. "+pName+" can go Southwest to the River."
                + "\n7. "+pName+" can go West to the Capital."
                + "\n8. "+pName+" can go Northwest to {temp}."
            );
        
            playerSelection();
            switch(pSel) {
                case "1": System.out.println("    "+pName+" goes North."); playerLocator("Capital"); break;
                case "2": System.out.println("    "+pName+" goes Northeast."); playerLocator("{temp}"); break;
                case "3": System.out.println("    "+pName+" goes East."); playerLocator("Forrest"); break;
                case "4": System.out.println("    "+pName+" goes Southeast."); playerLocator("Orcs"); break;
                case "5": System.out.println("    "+pName+" goes South."); playerLocator("Desert"); break;
                case "6": System.out.println("    "+pName+" goes Southwest."); playerLocator("River"); break;
                case "7": System.out.println("    "+pName+" goes West."); playerLocator("Capital"); break;
                case "8": System.out.println("    "+pName+" goes Northwest."); playerLocator("{temp}"); break;
                default: System.out.println("Can't go there."); pMover(pLocation);
            }
        }
    }

    // Function that determines the player's location
    static void playerLocator(String Location) {
        if (locList.contains(Location)) {
            if (Location.equals("Capital")) {
                System.out.println("    " + pName + " is in the Capital\n");
                pLocation = Location;
            } else if (Location.equals("Nekomura")) {
                System.out.println("    " + pName + " now in Nekomura\n");
                pLocation = Location;
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
            } else if (Location.equals("Cave")) {
                System.out.println("    " + pName + " is in the Cave of Misery\n");
                pLocation = Location;
            } else if (Location.equals("College")) {
                System.out.println("    " + pName + " is outside the College of Sorcery\n");
                pLocation = Location;
            } else {
                System.out.println("Somethings went wrong?");
            }
        } else {
            System.out.println("    You are stuck in the void");
            pLocation = "The Void";
        }

        pMover(pLocation);
    }

    // --->   End of Missile Logic <---





    // --->   Combat Functions   <---

    // Function that populates the weapon arrays
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

    // Function that determines if the item is a weapon
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

    // Function that sets the weapon type and damage
    static void setWeaponStats(String item) {
        if (weaponEquipped == false) {
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

    // --->   End of Combat Functions   <---





    // --->   Options Menu   <---

    // --->   Funtion that allows player to use the menu   <---
    // (lets character use items, equip weapons/armour, and start combat)
    static void openMenu() {
        System.out.println("\n    What would you like to do?\n"
            + "\n1. Open Inventory\n2. Use Item\n3. Sneak\n4. Combat\n5. Move\n"
        );

        playerSelection();
        switch (pSel) {
            case "1": showInventory(); break;
            case "2": useItem(); break;
            case "3": break;
            case "4": break;
            case "5": pMover(pLocation); break;
            default: System.out.println("Thats not an option."); break;
        }
    }
// --->   Leaving Function Junction   <---
//










// This should run everything
//
    public static void main(String args[]){

        popWeaponArrays();
        popLocList();

        System.out.println(welcomeMsg);

        characterSelection();

        System.out.println("This is where the game would start");

        while (true) {
            playerSelection();
        }

    }
}
// End of the program


