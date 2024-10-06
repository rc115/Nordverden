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

// Import statements
import java.util.Scanner;
import java.util.Random;


public class Nordverden {
// input object
    static Scanner input = new Scanner(System.in); 
// random object
    static Random rand = new Random();
//


// - - >     Variables     < - -
// Empty string variables needed in certain functions
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
//
// All of the variables for the character's statistics
    static int pLevel = 1; //character's level. +10 skill pointsMax lvl 46 (lvl 5 = 1000 total xp needed)
    static int pCurXp = 0; // current expirience points
    static int pNextLvl = (10*(pLevel*pLevel) + 90); // ammount of xp needed to level up
    static int pHealth = 100; // character's health
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

    static int pLives = 1; // ammount of lives the character has
    static int pInv = 5; // player inventory space
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
    static boolean conFinalStats = false;

    static int skillPts = 50; // total unspent skill points
    static int assSkiPts = 0; // skill points player wants to assign
    static boolean conSkills = false; // confirms player's skill choices
    // player character's skills
    static int pStrenght = 0;
    static int pSpeech = 0;
    static int pStamina = 0;
    static int pSorcery = 0;
    static int pSneak = 0;

    static double resistPts = 3.0; // total unspent resistance points
    static double assResPts = 0.0; // resistance points the player wants to assign
    static boolean conResists = false; // confirms the player's resistances 
    // player character's damage resistance
    static double pBladeRes = 0.0;
    static double pBluntRes = 0.0;
    static double pMagicRes = 0.0;
    static double pPoisonRes = 0.0;
    static double pFireRes = 0.0;
    static double pFrostRes = 0.0;

    static double damagePts = 2.0; // tatal unspent damage points
    static double assDmgPts = 0.0; // damage points the player wants to assign
    static boolean conDamage = false; // confirms the player's damage
    // player character's damage multipliers
    static double pUnarmedDmg = 0.0;
    static double pBladeDmg = 0.0;
    static double pBluntDmg = 0.0;
    static double pHeavyDmg = 0.0;
    static double pMagicDmg = 0.0;
    static double pRangedDmg = 0.0;

    static boolean bSmallBag = false; // +2 inventory
    static boolean bRugsack = false; // +4 inventory
    static boolean bJanksportBackpack = false; // +5 inventory
    static boolean bLargeBackpack = false; // +10 inventory
    static boolean bQuatumBag = false; // +95 inventory
//
//Combat Variables
    static int combatStamina = pStamina;
    static int pHitChance = 0; // Character's hit chance (1-20) [<10 hits]
    static int pDisToTar = 0; // Character's distance to targeted enemy (>=2 is Melee <2 isRanged)
    static int pWeaponDmg = 0; // Character's current weapon damage (T1 = 10, T2 = 20, ... T5 = 50[Max])
    static String pWeaponType = "none"; // type of weapon character is using
    static String pDmgType = "none";
    static double dmgMult = 0.0; // Characte's damage multiplier (depends on weapon type)
    static double dmgRes = 0.0; // Character's damage resistance (depens on damage type)
    static int eDmgToP = 0; // damage done to player if enemy hits

    static double pDamageCalc = ((pWeaponDmg*dmgMult) + (pStrenght*0.25));
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
    
//


// - - >     Misc. Functions     < - -
// Function that takes the players's input
    static void playerSelection(){
        pSel = "";
        pSel = input.next();

        if (pSel.equals("exit")) {
            System.out.println("\nGoodbye\n");
            System.exit(0);
        }

        System.out.println("\n____________________________________________________________________________________________________\n");
    }

//
// Functions that display character stats
    static void playerStatsDisplay() {
        pStatsDisplay = ("\n\n    Level ("+ pLevel +") ["+ pCurXp +"/"+ pNextLvl +" xp]"
            + "\n    Health ("+ pHealth +")"
            + "\n    Inventory Space ("+ pInv +")"
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

//


// - - >     Charactor creator     < - -
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

// Function for choosing the character's race
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
        System.out.println("\n____________________________________________________________________________________________________\n");

        if (pRace.equals("")) {
            System.out.println("\n    Choose your character's Race\n"
                + "\n1. Verdian [Recommended]\n2. Empirian\n3. Orc\n4. Dark Elf\n5. Wood Elf\n6. Nekohito\n7. Dragonborn\n8. View Info on Races"
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
            pInv += 1;
            pVerdian = true;
            System.out.println("\n    Your character's is now a Vernian");
        } else if (pRace.equals("Empirian")) {
            pCoins += 100;
            pSpeech +=10;
            pStrenght += 10;
            pEmpirian = true;
            System.out.println("\n    Your character's is now a Empirian");
        } else if (pRace.equals("Orc")) {
            pBladeRes += 0.5;
            pMagicRes += 0.5;
            pSpeech -= 50;
            pStrenght += 25;
            pOrc = true;
            System.out.println("\n    Your character's is now a Orc");
        } else if (pRace.equals("Dark")) {
            pSorcery += 20;
            pFireRes += 0.25;
            pMagicRes += 0.5;
            pHealth -= 50;
            pDarkElf = true;
            System.out.println("\n    Your character's is now a Dark Elf");
        } else if (pRace.equals("Wood")) {
            pSorcery += 10;
            pPoisonRes += 0.25;
            pSpeech += 10;
            pHealth -= 50;
            pWoodElf = true;
            System.out.println("\n    Your character's is now a Wood Elf");
        } else if (pRace.equals("Nekohito")) {
            pSneak += 25;
            pStamina += 10;
            pSorcery += 5;
            pStrenght -= 10;
            pNekohito = true;
            System.out.println("\n    Your character's is now a Nekohito");
        } else if (pRace.equals("Dragonborn")) {
            pDragonborn = true;
            System.out.println("\n    Your character's is now a Dragonborn");
        } else {
            System.out.println("How did you do that?");
        }

        System.out.println("\n1. Confirm Race\n2. Reset Race\n");
        playerSelection();
        switch(pSel) {
            case "1": pRaceSet = true; customizeStats(); break;
            case "2": 
                if (pRace.equals("Vernian")) {
                    pFrostRes -= 0.5;
                    pStrenght -= 10;
                    pInv -= 1;
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
                    pHealth += 50;
                    pDarkElf = false;
                } else if (pRace.equals("Wood")) {
                    pSorcery -= 10;
                    pPoisonRes -= 0.25;
                    pSpeech -= 10;
                    pHealth += 50;
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

// Function for choosing the character's class
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
            System.out.println("\n    You are now a Vilager.\n");
        } else if (pClass.equals("Warrior")) {
            pStrenght += 15;
            pInv -= 1;
            pWeaponDmg = 10;
            pWeaponType = "Bladed";
            System.out.println("\n    You are now a Warrior.\n");
        } else if (pClass.equals("Tank")) {
            pBladeRes += 1;
            pBluntRes += 1;
            System.out.println("\n    You are now a Tank.\n");
        } else if (pClass.equals("Mage")) {
            pSorcery += 15;
            pInv -= 1;
            pWeaponDmg = 10;
            pWeaponType = "Magic";
            System.out.println("\n    You are now a Mage.\n");
        } else if (pClass.equals("Archer")) {
            pSneak += 15;
            pInv -= 1;
            pWeaponDmg = 10;
            pWeaponType = "Ranged";
            System.out.println("\n    You are now a Archer.\n");
        } else if (pClass.equals("Gambler")) {
            pLuck += 1;
            pGold -= 3;
            System.out.println("\n    You are now a Gambler.\n");
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
                    pInv += 1;
                    pWeaponDmg = 0;
                    pWeaponType = "none";
                } else if (pClass.equals("Tank")) {
                    pBladeRes -= 1;
                    pBluntRes -= 1;
                } else if (pClass.equals("Mage")) {
                    pSorcery -= 15;
                    pInv += 1;
                    pWeaponDmg = 0;
                    pWeaponType = "none";
                } else if (pClass.equals("Archer")) {
                    pSneak -= 15;
                    pInv += 1;
                    pWeaponDmg = 0;
                    pWeaponType = "none";
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
// Function for choosing the character's karma
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
            case "1": break;
            case "2": break;
            case "3": break;
            case "4": break;
            case "5": break;
            case "6": break;
            case "7": break;
            case "8": pInv += 2; bSmallBag = true; break;
            case "9": pGold += ((rand.nextInt(5)) + 1); break;
            default:
        }

        customizeStats();
    }
//



// This should run everything
    public static void main(String args[]){

        String welcomeMsg = ( "\n"
                            + "\n    Welcome to"
                            + "\n          __              _                   _            "
                            + "\n       /\\ \\ \\___  _ __ __| |_   _____ _ __ __| | ___ _ __  "
                            + "\n      /  \\/ / _ \\| '__/ _` \\ \\ / / _ \\ '__/ _` |/ _ \\ '_ \\ "
                            + "\n     / /\\  / (_) | | | (_| |\\ V /  __/ | | (_| |  __/ | | |"
                            + "\n     \\_\\ \\/ \\___/|_|  \\__,_| \\_/ \\___|_|  \\__,_|\\___|_| |_|"
                            + "\n                                       Version 0.011.100624"
                            + "\n" 
        );

        System.out.println(welcomeMsg);

        characterSelection();
        System.out.println("This is where the game would start");

    }
}
// End of the program