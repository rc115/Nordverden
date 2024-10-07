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
