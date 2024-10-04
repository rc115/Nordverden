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
* Inspired by classic role playing games from Interplay and modern open-world Bethesda games
* 
*/

// Import statements
import java.util.Scanner;


// Main Program
public class Nordverden {
// input object
    static Scanner input = new Scanner(System.in); 
//

// - - >     Variables     < - -
// Empty string variables needed in certain methods
    static String pSel = "";
    static String pStatsDisplay = "";
    static String pStatsInfo = "";
    static String pName = "";
    static String proSub = "";
    static String proObj = "";
    static String proPos = "";
    static String pRace = "";
//
// All of the variables for the character's statistics
    static int pLevel = 1; //character's level. +10 skill pointsMax lvl 46 (lvl 5 = 1000 total xp needed)
    static int pCurXp = 0; // current expirience points
    static int pNextLvl = (10*(pLevel*pLevel) + 90); // ammount of xp needed to level up
    static int pHealth = 100; // character's health
    static int pLives = 1; // ammount of lives the character has
    static int pInv = 5; // player inventory space
    static int pGold = 5; // Nordverden currency
    static int pEmpCoins = 0; // Empirian currency
    static int pSchmeeps = 0; // Nekohito currency
    static int goldToConvert = 0; // ammount of gold to convert
    static int coinsToConvert = 0; // ammount of coins to convert
    static int schmeepsToConvert = 0; // ammount of schmeeps to convert
    static int goldToCoin = (goldToConvert*10); // calculation for gold to coin conversion
    static int cointToGold = (coinsToConvert/8); // calculation for coin to gold conversion
    static int goldToSchmeep = (goldToConvert*100); // calculation for gold to schmeep conversion
    static int schmeepToGold = (schmeepsToConvert/100); // calculation for schmeep to gold conversion

    static int pLuck = 0; // luck variable (adds to all rolls)

    static int skillPts = 50; // total unspent skill points
    static int assSkiPts = 0; // skill points player wants to assign
    static boolean conSkills = false; // confirms player's skill choices
    static int pStrenght = 0;
    static int pSpeech = 0;
    static int pStamina = 0;
    static int pSorcery = 0;
    static int pSneak = 0;

    static double resistPts = 3.0; // total unspent resistance points
    static double assResPts = 0.0; // resistance points the player wants to assign
    static boolean conResists = false; // confirms the player's resistances 
    static double pBladeRes = 0.0;
    static double pBluntRes = 0.0;
    static double pMagicRes = 0.0;
    static double pPoisonRes = 0.0;
    static double pFireRes = 0.0;
    static double pFrostRes = 0.0;

    static double damagePts = 2.0; // tatal unspent damage points
    static double assDamPts = 0.0; // damage points the player wants to assign
    static boolean conDamage = false; // confirms the player's damage
    static double pUnarmedDmg = 0.0;
    static double pBladeDmg = 0.0;
    static double pBluntDmg = 0.0;
    static double pHeavyDmg = 0.0;
    static double pMagicDmg = 0.0;
    static double pRangedDmg = 0.0;
//


// - - >     Methods     < - -
// Method that takes the players's input
    static void playerSelection(){
        pSel = "";
        pSel = input.next();

        if (pSel.equals("exit")) {
            System.out.println("\nGoodbye\n");
            System.exit(0);
        }
    }

//
// Method that selects the character
    static void CharacterSelection() {
        System.out.println("\n    Would you like to make a new character or choose a preset?\n"
                            + "\n1. Create a Custom Character\n2. Choose from a preset\n"
        );

        playerSelection();
        switch(pSel) {
            case "2": System.out.println("{Preset Placeholder}"); break;
            case "1": CharacterCreation(); break;
            default: System.out.println("\n         C'mon m8 it's only 2 buttons\n"); CharacterSelection();
        }
    }
//
// Method that display character stats
    static void playerStatsDisplay() {
        pStatsDisplay = (
            "\n\n   Level ("+ pLevel +") ["+ pCurXp +"/"+ pNextLvl +" xp]"
            + "\n   Health ("+ pHealth +")"
            + "\n   Inventory Space ("+ pInv +")"
            + "\n   Gold ("+ pGold +")"
            + "\n   Luck ("+ pLuck +")"

            + "\n\n   Strenght ("+ pStrenght +"/100)"
            + "\n   Speech ("+ pSpeech +"/100)"
            + "\n   Stamina ("+ pStamina +"/100)"
            + "\n   Sorcery ("+ pSorcery +"/100)"
            + "\n   Sneak ("+ pSneak +"/100)"

            + "\n\n   Bladed Damage Res. ("+ pBladeRes +")"
            + "\n   Blunt Damage Res. ("+ pBluntRes +")"
            + "\n   Magic Res. ("+ pMagicRes +")"
            + "\n   Poison Res. ("+ pPoisonRes +")"
            + "\n   Fire Res. ("+ pFireRes +")"
            + "\n   Frost Res. ("+ pFrostRes +")"

            + "\n\n   Unarmed Damage ("+ pUnarmedDmg +")"
            + "\n   Bladed Damage ("+ pBladeDmg +")"
            + "\n   Blunt Damage ("+ pBluntDmg +")"
            + "\n   Heavy Weapons Damage ("+ pHeavyDmg +")"
            + "\n   Magic Damage ("+ pMagicDmg +")"
            + "\n   Long Range Damage ("+ pRangedDmg +")"
        );

        System.out.println(pStatsDisplay);
    }

// Method that displays info for every stat
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
// Method that initializes the character creator
    static void CharacterCreation() {
        System.out.println("\n    Follow the steps to create your character."
                            + "\n    Would you like to view info on your stats "
                            + "or modify them right now?\n"
                            + "\n1. View info on stats\n2. Modify\n"
        );

        playerSelection();
        switch(pSel) {
            case "2": customizeStats(); break;
            case "1": playerStatsInfo(); CharacterCreation(); break;
            default: System.out.println("\n           no... its either 1 or 2\n"); CharacterCreation();
        }

    }

// Method that modifies the character's stats
    static void customizeStats() {
        assSkiPts = 0;

        // creates the character's name
        if (pName.equals("")) {
            System.out.println("\n____________________________________________________________________________________________________\n");
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
                                + "\n1. Confirm\n2. Reset"
            );

            playerSelection();
            switch (pSel) {
                case "2": resetSkills(); break;
                case "1": conResists = true; break;
                default: System.out.println("\n        Nope"); customizeStats();
            }
        }

        // starts the skill point distribution chain
        if (skillPts > 0) {
            System.out.println("\n    You have " + skillPts + " skill points to spend.");
            System.out.println("    Which Skill would you like to modify?"
                                + "\n\n1. Strenght ("+ pStrenght +"/100) [10 recommended]"
                                + "\n2. Speech ("+ pSpeech +"/100) [10 recommended]"
                                + "\n3. Stamina ("+ pStamina +"/100) [30 recommended]"
                                + "\n4. Sorcery ("+ pSorcery +"/100)"
                                + "\n5. Sneak ("+ pSneak +"/100)\n"
            );

            playerSelection();
            switch(pSel) {
                case "1": assignStrPts(); break;
                case "2": assignSpePts(); break;
                case "3": assignStaPts(); break;
                case "4": assignSorPts(); break;
                case "5": assignSnePts(); break;
                default: System.out.println("\n         Are 5 buttons too much for you?\n"); customizeStats();
            }
        // starts the resistances point distribution chain
        } else if (resistPts > 0) {
            System.out.println("\n    You have " + resistPts + " resistance points to spend.");
            System.out.println("    Which damage resistance would you like to modify?"
                                + "\n\n1. Bladed Damage Res. ("+ pBladeRes +") [1.0 recommended]"
                                + "\n2. Blunt Damage Res. ("+ pBluntRes +") "
                                + "\n3. Magic Res. ("+ pMagicRes +") [0.5 recommended]"
                                + "\n4. Poison Res. ("+ pPoisonRes +") [0.5 recommended]"
                                + "\n5. Fire Res. ("+ pFireRes +") [0.5 recommended]"
                                + "\n6. Frost Res. ("+ pFrostRes +") [0.5 recommended]\n"
            );

            playerSelection();
            switch(pSel) {
                case "1": assBladedResPts(); break;
                case "2": assBluntResPts(); break;
                case "3": assMagicResPts(); break;
                case "4": assPoisonResPts(); break;
                case "5": assFireResPts(); break;
                case "6": assFrostResPts(); break;
                default: System.out.println("\n         Are 5 buttons too much for you?\n"); customizeStats();
            }
        }

    }

// The following methods are run if the player runs out of distrubution points
    static void ranOuttaSkiPts() {
        System.out.println("\n    You have run out of skill points to spend"
                            + "\n   You can confirm or reset your skills\n"
                            + "\n1. Confirm Stats"
                            + "\n2. Reset Skills"
        );

        playerSelection();
        switch(pSel) {
            case "2": resetSkills(); break;
            case "1": confirmStats(); break;
            default: System.out.println("\n         huh\n"); ranOuttaSkiPts();
        }
    }

    static void ranOuttaResPts() {
        System.out.println("\n    You have run out of points to spend"
                            + "\n   You can confirm or reset your skills\n"
                            + "\n1. Confirm Stats"
                            + "\n2. Reset Resistances"
        );

        playerSelection();
        switch(pSel) {
            case "2": resetSkills(); break;
            case "1": confirmStats(); break;
            default: System.out.println("\n         huh\n"); ranOuttaResPts();
        }
    }

// Methods for assigning points to skills
    static void assignStrPts() {
        assSkiPts = 0;
        System.out.println("\n    How many points would you like to assign to Strenght\n");
        assSkiPts = input.nextInt();

        if (assSkiPts > skillPts) {
            if (skillPts == 0) {
                ranOuttaSkiPts();
            }

            System.out.println(  "\n    You cannot assign " + assSkiPts + " points to Strenght."
                                +"\n    You have " + skillPts + " points available."
            );
            assignStrPts();

        } else if (assSkiPts < 0) {
            System.out.println(  "\n    You cannot assign negative points."
                                +"\n    If you would like to reset your points you can do that later."
            );
            assignStrPts();

        }else if (skillPts > 0){
            skillPts -= assSkiPts;
            pStrenght += assSkiPts;
            assSkiPts = 0;
            System.out.println("\n    Your Strenght is now at "+ pStrenght + "\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        System.out.println("\n    Would you like to move on to modifying Speech?\n"
                            + "\n1. Continue\n2. Modify other stats\n3. Confirm stats\n"
        );

        playerSelection();
        switch(pSel) {
            case "3": confirmStats(); break;
            case "2": customizeStats(); break;
            case "1": assignSpePts(); break;
            default: System.out.println("   Invalid input."); assignStrPts();
        }
    }

    static void assignSpePts() {
        assSkiPts = 0;
        System.out.println("\n    How many points would you like to assign to Speech\n");
        assSkiPts = input.nextInt();

        if (assSkiPts > skillPts) {
            if (skillPts == 0) {
                ranOuttaSkiPts();
            }

            System.out.println(  "\n    You cannot assign " + assSkiPts + " points to Speech."
                                +"\n    You have " + skillPts + " points available."
            );
            assignSpePts();

        } else if (assSkiPts < 0) {
            System.out.println(  "\n    You cannot assign negative points."
                                +"\n    If you would like to reset your points you can do that later."
            );
            assignSpePts();

        }else if (skillPts > 0){
            skillPts -= assSkiPts;
            pSpeech += assSkiPts;
            assSkiPts = 0;
            System.out.println("\n    Your Speech is now at "+ pSpeech + "\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        System.out.println("\n    Would you like to move on to modifying Stamina?\n"
                            + "\n1. Continue\n2. Modify other stats\n3. Confirm stats\n"
        );

        playerSelection();
        switch(pSel) {
            case "3": confirmStats(); break;
            case "2": customizeStats(); break;
            case "1": assignStaPts(); break;
            default: System.out.println("   Invalid input."); assignStrPts();
        }
    }

    static void assignStaPts() {
        assSkiPts = 0;
        System.out.println("\n    How many points would you like to assign to Stamina\n");
        assSkiPts = input.nextInt();

        if (assSkiPts > skillPts) {
            if (skillPts == 0) {
                ranOuttaSkiPts();
            }

            System.out.println(  "\n    You cannot assign " + assSkiPts + " points to Stamina."
                                +"\n    You have " + skillPts + " points available."
            );
            assignStaPts();

        } else if (assSkiPts < 0) {
            System.out.println(  "\n    You cannot assign negative points."
                                +"\n    If you would like to reset your points you can do that later."
            );
            assignStaPts();

        }else if (skillPts > 0){
            skillPts -= assSkiPts;
            pStamina += assSkiPts;
            assSkiPts = 0;
            System.out.println("\n    Your Stamina is now at "+ pStamina + "\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        System.out.println("\n    Would you like to move on to modifying Sorcery?\n"
                            + "\n1. Continue\n2. Modify other stats\n3. Confirm stats\n"
        );

        playerSelection();
        switch(pSel) {
            case "3": confirmStats(); break;
            case "2": customizeStats(); break;
            case "1": assignSorPts(); break;
            default: System.out.println("   Invalid input."); assignStrPts();
        }
    }

    static void assignSorPts() {
        assSkiPts = 0;
        System.out.println("\n    How many points would you like to assign to Sorcery\n");
        assSkiPts = input.nextInt();

        if (assSkiPts > skillPts) {
            if (skillPts == 0) {
                ranOuttaSkiPts();
            }

            System.out.println(  "\n    You cannot assign " + assSkiPts + " points to Sorcery."
                                +"\n    You have " + skillPts + " points available."
            );
            assignSorPts();

        } else if (assSkiPts < 0) {
            System.out.println(  "\n    You cannot assign negative points."
                                +"\n    If you would like to reset your points you can do that later."
            );
            assignSorPts();

        }else if (skillPts > 0){
            skillPts -= assSkiPts;
            pSorcery += assSkiPts;
            assSkiPts = 0;
            System.out.println("\n    Your Sorcery is now at "+ pSorcery + "\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        System.out.println("\n    Would you like to move on to modifying Sneak?\n"
                            + "\n1. Continue\n2. Modify other stats\n3. Confirm stats\n"
        );

        playerSelection();
        switch(pSel) {
            case "3": confirmStats(); break;
            case "2": customizeStats(); break;
            case "1": assignSnePts(); break;
            default: System.out.println("   Invalid input."); assignStrPts();
        }
    }

    static void assignSnePts() {
        assSkiPts = 0;
        System.out.println("\n    How many points would you like to assign to Sneak\n");
        assSkiPts = input.nextInt();

        if (assSkiPts > skillPts) {
            if (skillPts == 0) {
                ranOuttaSkiPts();
            }

            System.out.println(  "\n    You cannot assign " + assSkiPts + " points to Sneak."
                                +"\n    You have " + skillPts + " points available."
            );
            assignSnePts();

        } else if (assSkiPts < 0) {
            System.out.println(  "\n    You cannot assign negative points."
                                +"\n    If you would like to reset your points you can do that later."
            );
            assignSnePts();

        }else if (skillPts > 0){
            skillPts -= assSkiPts;
            pSneak += assSkiPts;
            assSkiPts = 0;
            System.out.println("\n    Your Sneak is now at "+ pSneak + "\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        System.out.println("\n    Would you like to modify your stats or confirm them?\n"
                            + "\n1. Modify other stats\n2. Confirm stats\n"
        );

        playerSelection();
        switch(pSel) {
            case "2": confirmStats(); break;
            case "1": customizeStats(); break;
            default: System.out.println("   Invalid input."); assignStrPts();
        }
    }

// Methods for assigning points to resistances
    static void assBladedResPts() {
        assResPts = 0;
        System.out.println("\n    How many points would you like to assign to Bladed Damage Resistance\n");
        assResPts = input.nextInt();

        if (assResPts > resistPts) {
            if (resistPts == 0) {
                ranOuttaResPts();
            }

            System.out.println(  "\n    You cannot assign " + assResPts + " points to Bladed Dmg. Res."
                                +"\n    You have " + resistPts + " points available."
            );
            assBladedResPts();

        } else if (assResPts < 0) {
            System.out.println(  "\n    You cannot assign negative points."
                                +"\n    If you would like to reset your points you can do that later."
            );
            assBladedResPts();

        }else if (resistPts > 0){
            resistPts -= assResPts;
            pBladeRes += assResPts;
            assResPts = 0;
            System.out.println("\n    Your Bladed Damage Resistance is now at "+ pBladeRes + "\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        System.out.println("\n    Would you like to move on to modifying Blunt Dmg. Resistance?\n"
                            + "\n1. Continue to Blunt Res.\n2. Modify other resistances\n3. Confirm stats\n"
        );

        playerSelection();
        switch(pSel) {
            case "3": confirmStats(); break;
            case "2": customizeStats(); break;
            case "1": assBluntResPts(); break;
            default: System.out.println("   Invalid input."); assBladedResPts();
        }
    }

    static void assBluntResPts() {
        assResPts = 0;
        System.out.println("\n    How many points would you like to assign to Blunt Damage Resistance\n");
        assResPts = input.nextInt();

        if (assResPts > resistPts) {
            if (resistPts == 0) {
                ranOuttaResPts();
            }

            System.out.println(  "\n    You cannot assign " + assResPts + " points to Blunt Dmg. Res."
                                +"\n    You have " + resistPts + " points available."
            );
            assBluntResPts();

        } else if (assResPts < 0) {
            System.out.println(  "\n    You cannot assign negative points."
                                +"\n    If you would like to reset your points you can do that later."
            );
            assBluntResPts();

        }else if (resistPts > 0){
            resistPts -= assResPts;
            pBluntRes += assResPts;
            assResPts = 0;
            System.out.println("\n    Your Blunt Damage Resistance is now at "+ pBladeRes + "\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        System.out.println("\n    Would you like to move on to modifying Magic Dmg. Resistance?\n"
                            + "\n1. Continue to Magic Res.\n2. Modify other resistances\n3. Confirm stats\n"
        );

        playerSelection();
        switch(pSel) {
            case "3": confirmStats(); break;
            case "2": customizeStats(); break;
            case "1": assMagicResPts(); break;
            default: System.out.println("   Invalid input."); assBluntResPts();
        }
    }

    static void assMagicResPts() {
        assResPts = 0;
        System.out.println("\n    How many points would you like to assign to Magic Damage Resistance\n");
        assResPts = input.nextInt();

        if (assResPts > resistPts) {
            if (resistPts == 0) {
                ranOuttaResPts();
            }

            System.out.println(  "\n    You cannot assign " + assResPts + " points to Magic Dmg. Res."
                                +"\n    You have " + resistPts + " points available."
            );
            assMagicResPts();

        } else if (assResPts < 0) {
            System.out.println(  "\n    You cannot assign negative points."
                                +"\n    If you would like to reset your points you can do that later."
            );
            assMagicResPts();

        }else if (resistPts > 0){
            resistPts -= assResPts;
            pMagicRes += assResPts;
            assResPts = 0;
            System.out.println("\n    Your Magic Damage Resistance is now at "+ pMagicRes + "\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        System.out.println("\n    Would you like to move on to modifying Poison Dmg. Resistance?\n"
                            + "\n1. Continue to Poison Res.\n2. Modify other resistances\n3. Confirm stats\n"
        );

        playerSelection();
        switch(pSel) {
            case "3": confirmStats(); break;
            case "2": customizeStats(); break;
            case "1": break;
            default: System.out.println("   Invalid input."); assMagicResPts();
        }
    }

    static void assPoisonResPts() {
        assResPts = 0;
        System.out.println("\n    How many points would you like to assign to Poison Damage Resistance\n");
        assResPts = input.nextInt();

        if (assResPts > resistPts) {
            if (resistPts == 0) {
                ranOuttaResPts();
            }

            System.out.println(  "\n    You cannot assign " + assResPts + " points to Poison Dmg. Res."
                                +"\n    You have " + resistPts + " points available."
            );
            assPoisonResPts();

        } else if (assResPts < 0) {
            System.out.println(  "\n    You cannot assign negative points."
                                +"\n    If you would like to reset your points you can do that later."
            );
            assPoisonResPts();

        }else if (resistPts > 0){
            resistPts -= assResPts;
            pPoisonRes += assResPts;
            assResPts = 0;
            System.out.println("\n    Your Poison Damage Resistance is now at "+ pPoisonRes + "\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        System.out.println("\n    Would you like to move on to modifying Fire Dmg. Resistance?\n"
                            + "\n1. Continue to Fire Res.\n2. Modify other resistances\n3. Confirm stats\n"
        );

        playerSelection();
        switch(pSel) {
            case "3": confirmStats(); break;
            case "2": customizeStats(); break;
            case "1": assFireResPts(); break;
            default: System.out.println("   Invalid input."); assPoisonResPts();
        }
    }

    static void assFireResPts() {
        assResPts = 0;
        System.out.println("\n    How many points would you like to assign to Fire Damage Resistance\n");
        assResPts = input.nextInt();

        if (assResPts > resistPts) {
            if (resistPts == 0) {
                ranOuttaResPts();
            }

            System.out.println(  "\n    You cannot assign " + assResPts + " points to Fire Dmg. Res."
                                +"\n    You have " + resistPts + " points available."
            );
            assFireResPts();

        } else if (assResPts < 0) {
            System.out.println(  "\n    You cannot assign negative points."
                                +"\n    If you would like to reset your points you can do that later."
            );
            assFireResPts();

        }else if (resistPts > 0){
            resistPts -= assResPts;
            pFireRes += assResPts;
            assResPts = 0;
            System.out.println("\n    Your Fire Damage Resistance is now at "+ pFireRes + "\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        System.out.println("\n    Would you like to move on to modifying Frost Dmg. Resistance?\n"
                            + "\n1. Continue to Frost Res.\n2. Modify other resistances\n3. Confirm stats\n"
        );

        playerSelection();
        switch(pSel) {
            case "3": confirmStats(); break;
            case "2": customizeStats(); break;
            case "1": assFrostResPts(); break;
            default: System.out.println("   Invalid input."); assFireResPts();
        }
    }

    static void assFrostResPts() {
        assResPts = 0;
        System.out.println("\n    How many points would you like to assign to Frost Damage Resistance\n");
        assResPts = input.nextInt();

        if (assResPts > resistPts) {
            if (resistPts == 0) {
                ranOuttaResPts();
            }

            System.out.println(  "\n    You cannot assign " + assResPts + " points to Frost Dmg. Res."
                                +"\n    You have " + resistPts + " points available."
            );
            assFrostResPts();

        } else if (assResPts < 0) {
            System.out.println(  "\n    You cannot assign negative points."
                                +"\n    If you would like to reset your points you can do that later."
            );
            assFrostResPts();

        }else if (resistPts > 0){
            resistPts -= assResPts;
            pFrostRes += assResPts;
            assResPts = 0;
            System.out.println("\n    Your Frost Damage Resistance is now at "+ pFrostRes + "\n");

        } else {
            System.out.println("\n\nWhat did you do?\n");
        }

        System.out.println("\n    Would you like to confirm your Resistances?\n"
                            + "\n1. Confirm stats\n2. Modify other resistances\n3. Reset resistances\n"
        );

        playerSelection();
        switch(pSel) {
            case "1": confirmStats(); break;
            case "2": customizeStats(); break;
            case "3": resetResists(); break;
            default: System.out.println("   Invalid input."); assFrostResPts();
        }
    }


// Method that confirms the character's statistics
    static void confirmStats() {
        System.out.println("\n    These are your uncomfirmed stats:\n");
        playerStatsDisplay();

        if (skillPts > 0) {
            System.out.println("\n\n    Are you sure? You still have "
                                + skillPts + " unspent points"
            );
        }

        System.out.println("\n    Do you want to:\n"
                            + "\n1. Confirm stats"
                            + "\n2. Continue Modifying"
                            + "\n3. Reset stats\n"
        );

        playerSelection();
        switch(pSel) {
            case "1": System.out.println("\n____________________________________________________________________________________________________\n");
                      System.out.println("\n   Your stats are now:\n"); playerStatsDisplay();
                      System.out.println("\n____________________________________________________________________________________________________\n");
            case "2": customizeStats(); break;
            case "3": resetSkills(); break;
            default: System.out.println("\n       You can't do that.\n"); confirmStats();
        }
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
                            + "\n                                       Version 0.008.100324"
                            + "\n" 
        );

        System.out.println(welcomeMsg);

        CharacterSelection();
        System.out.println("This is where the game would start");

    }
}
// End of the program