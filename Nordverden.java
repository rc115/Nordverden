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

import java.util.Scanner;


public class Nordverden {
    static Scanner input = new Scanner(System.in);
    
    static String pSel = "";
    static String pStatsDisplay = "";
    static String pStatsInfo = "";
    static String pName = "";
    static String proSub = "";
    static String proObj = "";
    static String proPos = "";
    static String pRace = "";

    static int pLevel = 1; //Max lvl 46 (lvl 5 = 1000 xp needed [340 @lvl 4])
    static int pCurXp = 0;
    static int xpCalc = (100*(pLevel*pLevel));
    static int pNextLvl = xpCalc;
    static int pHealth = 100;
    static int pInv = 5;
    static int pGold = 5;
    static int pLuck = 0;

    static int skillPts = 50;
    static int assSkiPts = 0;
    static int pStrenght = 0;
    static int pSpeech = 0;
    static int pStamina = 0;
    static int pSorcery = 0;
    static int pSneak = 0;

    static double resistPts = 3.0;
    static double assResPts = 0.0;
    static double pBladeRes = 0.0;
    static double pBluntRes = 0.0;
    static double pMagicRes = 0.0;
    static double pPoisonRes = 0.0;
    static double pFireRes = 0.0;
    static double pFrostRes = 0.0;

    static double combatPts = 2.0;
    static double assComPts = 0.0;
    static double pUnarmedDmg = 0.0;
    static double pBladeDmg = 0.0;
    static double pBluntDmg = 0.0;
    static double pHeavyDmg = 0.0;
    static double pMagicDmg = 0.0;
    static double pRangedDmg = 0.0;

    static void playerSelection(){
        pSel = "";
        pSel = input.next();

        if (pSel.equals("exit")) {
            System.out.println("\nGoodbye\n");
            System.exit(0);
        }
    }

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

    static void resetSkills() {
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
                                    + " points to assign.\n"
                );

                customizeStats();
                break;
            case "2": customizeStats(); break;
            case "3": playerStatsDisplay(); resetSkills(); break;
            default: System.out.println("\n         Nah"); resetSkills();
        }
    }

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

    static void ranOuttaPoints() {
        System.out.println("\n    You have run out of points to spend"
                            + "\n   You can confirm or reset your skills\n"
                            + "\n1. Confirm Skills"
                            + "\n2. Reset Skills"
        );

        playerSelection();
        switch(pSel) {
            case "2": resetSkills(); break;
            case "1": confirmStats(); break;
            default: System.out.println("\n         C'mon m8 it's only 2 buttons\n"); assignStrPts(); break;
        }
    }

    static void assignStrPts() {
        assSkiPts = 0;
        System.out.println("\n    How many points would you like to assign to Strenght\n");
        assSkiPts = input.nextInt();

        if (assSkiPts > skillPts) {
            if (skillPts == 0) {
                ranOuttaPoints();
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
                ranOuttaPoints();
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
                ranOuttaPoints();
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
                ranOuttaPoints();
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
                ranOuttaPoints();
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

    static void customizeStats() {
        assSkiPts = 0;

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
                default: System.out.println("\n       No\n");
            }
        }

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
        } else if (resistPts > 0) {
            System.out.println("{Placeholder}");
        }

    }

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

    static void playerStatsInfo() {
        pStatsInfo = (
            "\n\n   Level                   [Level determines the ammount of points you have to distribute]\n"
            + "\n   Health                  [Health is self explanitory. If it drops to 0 your character dies.]\n"
            + "\n   Inventory Space         [Inventory management is important in this game."
            + "\n                            Each armour piece, weapon, and quest item takes up inventory space]\n"
            + "\n   Gold                    [Gold is the currency of Nordverden. It can be used to purchase items.]\n"
            + "\n   Luck                    [Luck increases your rolls by the ammount of Luck you have."
            + "\n                            Ex: Roll 9 + 2 Luck = Roll 11 (20 is the max roll)]\n"

            + "\n\n   Strenght                [Strength is determines how much damage you do and take.]\n"
            + "\n   Speech                  [Speech is used to convice people to do things you want.]\n"
            + "\n   Stamina                 [Stamina is very important in this game."
            + "\n                            It determines how many actions you can make per turn.]\n"
            + "\n   Sorcery                 [Sorcey determines which spells, and how many you can cast.]\n"
            + "\n   Sneak                   [Sneak is determines if you can get away with undesired actions.]\n"

            + "\n\n   Bladed Damage Res.      [Blade Resistance lowers the damage you take from bladed weapons.]\n"
            + "\n   Blunt Damage Res.       [Blunt Resistance lowers the damage you take from blunt weapons.]\n"
            + "\n   Magic Res.              [Magic Resistance lowers the damage you take from magic.]\n"
            + "\n   Poison Res.             [Poison Resistance lowers your chance of being poisoned.]\n"
            + "\n   Fire Res.               [Fire Resistance lowers your chance of being set on fire.]\n"
            + "\n   Frost Res.              [Frost Resistance lowers your chance of getting hypothermia.]\n"

            + "\n\n   Unarmed Damage          [Unarmed damage increases the damage you do with unarmed weapons]\n"
            + "\n   Bladed Damage           [Bladed damage increases the damage you do with bladed weapons]\n"
            + "\n   Blunt Damage            [Blunt damage increases the damage you do with blunt weapons]\n"
            + "\n   Heavy Weapons Damage    [H.W. damage increases the damage you do with heavy weapons]\n"
            + "\n   Magic Damage            [Magic damage increases the damage you do with magic]\n"
            + "\n   Long Range Damage       [Unarmed damage increases the damage you do with ranged weapons]"
        );

        System.out.println(pStatsInfo);
        System.out.println("\n____________________________________________________________________________________________________\n");
    }

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
            default: System.out.println("\nC'mon m8 it's 2 buttons\n"); CharacterSelection();
        }

    }

    public static void main(String args[]){

        String welcomeMsg = ( "\n"
                            + "\n    Welcome to"
                            + "\n          __              _                   _            "
                            + "\n       /\\ \\ \\___  _ __ __| |_   _____ _ __ __| | ___ _ __  "
                            + "\n      /  \\/ / _ \\| '__/ _` \\ \\ / / _ \\ '__/ _` |/ _ \\ '_ \\ "
                            + "\n     / /\\  / (_) | | | (_| |\\ V /  __/ | | (_| |  __/ | | |"
                            + "\n     \\_\\ \\/ \\___/|_|  \\__,_| \\_/ \\___|_|  \\__,_|\\___|_| |_|"
                            + "\n                                       Version 0.007.100324"
                            + "\n" 
        );

        System.out.println(welcomeMsg);

        CharacterSelection();

    }
}




