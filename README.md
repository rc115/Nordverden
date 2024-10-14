Project: Nordverden
CS2011 Final Concept

"I have no clue if I'll be able to do this ngl
I'm either really ambitious or delusional" - Rigo (Main Dev)

Gonna start adding patch notes here ig

Update 8 --- Oct. 3rd, 2024:
* Added comments to almost everything to make it more understandable
* Started working on phase 2 of the stat distribution (currently bugged badly)
* Moved methods and variables to be neater
* Finished phase 1 of the character creator (skill distribution)
* Critical bugs include:
    * Game crashes whenever an invalid input is entered when the user is prompted to enter their skill points
    * Game crashes on non-int inputs on the resistances
    * nextInt is used instead of nextDouble for some reason
* Still very early alpha would not even consider this as "Game" at this point
* List of things needed would be too long to include so ill include the link to the spreadsheet of ideas below
* Spreadsheet of ideas: https://docs.google.com/spreadsheets/d/1skmt_pbT3vvZ0yztQ135bosPSbpcWVjASjwLznJw5q8/edit?usp=sharing
* Hopefully I can finish the important bits by the end of November

Update 9 --- Oct. 4th, 2024:
* Started work on damage multipliers
* Fixed resistance bug that cause the game to crash
* Still haven't fixed it fully it just works with decimals now
* Short update cus I gotta go to sleep its 2:12 rn

Update 10 --- Oct. 4th, 2024
* Finished the stat distribution
* Game breaking bugs still include invalid input crashing
* 3/5 parts of the character creator are finished now
* 3/30 modules finished (1.5k lines of code for 10% of the game... yay.)

Update 11 --- Oct. 6th, 2024
* Huge update changed most of the functions for stat distribution
* Finally finished the majority of the character creator
   * Name & Pronouns
   * Skills
   * Resistances and damage multipliers
   * Class and Race
   * Karma
   * Started work on starting equipment
   * Need to start work on starting location
* Added random (it needed to be done eventually anyway)
* Cleaned up a lot of functions
* Game breaking bug(invalid input on stat distribution) is not a priority rn
* Started work on the combat system
* #1 priority rn is getting the inventory system working (might need to change class equipment later)
* changed the character creator to be more intuitive
* might be forgetting some stuff but thats most of it :)

Update 12 --- Oct. 7th, 2024
* Fixed infinite loop bug in the character creator
* Added arrays (didn't even think I had to ngl)
* Started work on the inventory management system
* Started work on the combat system
* Added all of the weapons
* Added functions to make weapons work
* Need to fix the class system to work with the ims
* Cleaned up comments

Update 13 --- Oct. 7th, 2024
* Got help from Kanishq and started the missile logic locator
* Missile logic locator uses the player's location to figure out where they can go
* Added list of locations in Nordverden (might change in the future)
* Added funtion that finds the player's location and tells them where they are
* Need to work on the Nekomura passport system (non-passport holders should get deported to Nordverden)
* Need to fix class and starting equipment functions to work with IMS
* Need to work on the armour system

Update 14 --- Oct. 8th, 2024
* Added a bunch of variables for the armour system
* Added list with all weapons in the game
* Started work on the Menu Sytem
   * The menu system will let the player do actions such as using items, starting combat, or moving location
* Started work on the use item function that will let players equip weapons/armour or drink potions
* Added method that displays the inventory
* Finished the starting equipment and now works with the IMS
* Extended the weapon equipper in case the player already has a weapon equipped
* Added an infinite loop for testing menu
* Need to add Armour System   <--- Next
* Need to make locations worth visiting (populating and adding quests)
* Need to add starting locations   <--- Next
* Need to add Kanishq to the github so he can upload updates too

Update 15 --- Oct. 13th, 2024
* Massive update after a short break
* Finished character display
* added a bunch of comments and spaces to clean up code
* added a default preset to speed up character creator
* finnally added the starting locations
* fixed the movement functions to work together better
* added a passport checkpoint to nekomura
* started work on "rooms", rooms will include:
   * places to rest
   * questgivers
   * shops
   * npcs
   * loot
* added a special start location that introduces 2 potential party members
* Need to populate rooms
* Need to start combat system and enemys
* Need to work on potions (not as important)
* Need to find a way to generate caves so the player can level up quickly
* Need to add quests and rewards
* Need to add pretty much everything on the spreadsheet (Seems like a lot ngl)
* So far the 80% of the "bones" are done
* Need at least 70% of the "meat" to count this as a game, currently at 0-5%
* I need some sleep, its 3:54 AM rn been coding since 1:43 PM 💀

Update 16 --- Oct. 13th, 2024
* Another massive update 🥲
* Added pain and suffering
* Finnally found the difference between methods and functions
* Added a class to handle NPCs
   * NPC have their own stats
   * NPCs can either be neutral or hostile
* Added a combat system (pain)
   * Turn based system
   * A "20 sided die" determines hit chance
   * If Player gets a 20 they do double damage
   * Player gets bodied if there are more than two enemies
   * Player damage is based on their weapon and damage multiplier
* Added a dynamic enemy system (suffering)
   * Array list handles NPCs in area
   * If player initiate combat neutral NPCs will fight back
   * If a hostile NPC is present they will start combat
   * Enemy damage is based on a Tiered system (T1 = 10, T2 = 20, etc)
   * Damage resistance is based on player's resistance to enemy's attack
   * Different enemies have different damage types
* Added a leveling system that gets exponentially harder
* Added an afterlife in case the player dies (they will)
* Need to add a companion system to balace multi-enemy combat
* Need to impliment stamina system to give player multiple attacks per turn
* Theres a bunch of bugs now because of the combat system
   * Game crashes if player doesnt input an int when prompted to choose an enemy
   * If strenght is negative it heals the enemy (kinda funny might keep)
   * Player can go into combat without a weapon (might be a feature)
   * Probably more that I havent found yet
   * Still havent fixed the other game breaking bugs in char creator
   * Left a bunch of debugging things everywhere
* Might take another short break after this ngl
