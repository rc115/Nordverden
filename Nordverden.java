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
 * Inspired by classic role playing games from Interplay and modern Bethesda games
 * 
 */

import java.util.Scanner;


public class Nordverden {
    static Scanner input = new Scanner(System.in);
    
    static String pSel = "";

    static int pLevel = 1;
    static int pCurXp = 0;
    static int pNextLvl = 100;
    static int pHealth = 100;
    static int pInv = 5;
    static int pGold = 5;
    static int pLuck = 0;

    static int pStrenght = 0;
    static int pSpeech = 0;
    static int pStamina = 0;
    static int pScorcery = 0;
    static int pSneak = 0;

    static double pBladeRes = 0.0;
    static double pBluntRes = 0.0;
    static double pMagicRes = 0.0;
    static double pPoisonRes = 0.0;
    static double pFireRes = 0.0;
    static double pFrostRes = 0.0;

    static double pUnarmedDmg = 0.0;
    static double pBladeDmg = 0.0;
    static double pBluntDmg = 0.0;
    static double pHeavyDmg = 0.0;
    static double pMagicDmg = 0.0;
    static double pRangedDmg = 0.0;

    static void CharacterSelection() {
        System.out.println("    If you would like to create a new character press 1.");
        System.out.println("    If you would like to choose from a preset press 2.\n");
        System.out.println("1. Create a Custom Character\n2. Choose from a preset\n");

        pSel = "";
        pSel = input.next();

        

        switch(pSel) {
            case "2": System.out.println("Placeholder2"); break;
            case "1": CharacterCreation(); break;
            default: System.out.println("\n         C'mon m8 it's only 2 buttons\n"); CharacterSelection();
        }


    }

    static void pCustomizeStats() {
        System.out.println("    Here you will be able to modify your character's stats.");

        System.out.println("    First assign up to 50 points to your skills");
        
        System.out.println("    Which Skill would you like to modify?"
                            + "\n\n1. Strenght ("+ pStrenght +"/100) [10 recommended]"
                            + "\n2. Speech ("+ pSpeech +"/100) [10 recommended]"
                            + "\n3. Stamina ("+ pStamina +"/100) [30 recommended]"
                            + "\n4. Scorcery ("+ pScorcery +"/100)"
                            + "\n5. Sneak ("+ pSneak +"/100)"
        );

        pSel = "";
        pSel = input.next();

        int totalPts = 50;
        

        switch(pSel) {
            case "5": 
                System.out.println("    How many points would you like to assign to Strenght");
                pStrenght = input.nextInt();
                if ((totalPts > 0) && (pStrenght < totalPts)){
                    totalPts -= pStrenght;
                } else if (totalPts == 0){
                    System.out.println("    You have run out of points to spend"
                                        + "\n   You can confirm or reset your skills"
                                        + "\n\n 1. Confirm Skills"
                                        + "\n 2. Reset Skills"
                    );
                    pSel = "";
                    pSel = input.next();

                }
                break;
            case "4": System.out.println("How many points would you like to assign to Speech"); break;
            case "3": System.out.println("How many points would you like to assign to Stamina"); break;
            case "2": System.out.println("How many points would you like to assign to Scorcery"); break;
            case "1": System.out.println("How many points would you like to assign to Sneak"); break;
            default: System.out.println("\n         C'mon m8 is 7 too many buttons?\n"); CharacterSelection();
        }

    }


    static void CharacterCreation() {
        System.out.println("\n\n    Follow the steps to choose your character.\n");

        String playerStatsDisplay = (
                            "\n\n   Level ("+ pLevel +") ["+ pCurXp +"/"+ pNextLvl +" xp]"
                            + "\n   Health ("+ pHealth +")"
                            + "\n   Inventory Space ("+ pInv +")"
                            + "\n   Gold ("+ pGold +")"
                            + "\n   Luck ("+ pLuck +")"

                            + "\n\n Strenght ("+ pStrenght +"/100)"
                            + "\n   Speech ("+ pSpeech +"/100)"
                            + "\n   Stamina ("+ pStamina +"/100)"
                            + "\n   Scorcery ("+ pScorcery +"/100)"
                            + "\n   Sneak ("+ pSneak +"/100)"

                            + "\n\n Bladed Damage Res. ("+ pBladeRes +")"
                            + "\n   Blunt Damage Res. ("+ pBluntRes +")"
                            + "\n   Magic Res. ("+ pMagicRes +")"
                            + "\n   Poison Res. ("+ pPoisonRes +")"
                            + "\n   Fire Res. ("+ pFireRes +")"
                            + "\n   Frost Res. ("+ pFrostRes +")"

                            + "\n\n Unarmed Damage ("+ pUnarmedDmg +")"
                            + "\n   Bladed Damage ("+ pBladeDmg +")"
                            + "\n   Blunt Damage ("+ pBluntDmg +")"
                            + "\n   Heavy Weapons Damage ("+ pHeavyDmg +")"
                            + "\n   Magic Damage ("+ pMagicDmg +")"
                            + "\n   Long Range Damage ("+ pRangedDmg +")"
        );

        System.out.println("    Would you like to view the default stats or modify them right now?\n");
        System.out.println("1. View Character Stats\n2. Modify\n");

        pSel = "";
        pSel = input.next();

        switch(pSel) {
            case "2": pCustomizeStats(); break;
            case "1": System.out.println(playerStatsDisplay); CharacterCreation(); break;
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
                            + "\n                                       Version 0.002.100224"
                            + "\n" 
        );
        
        System.out.println(welcomeMsg);

 
        CharacterSelection();


    }
}




