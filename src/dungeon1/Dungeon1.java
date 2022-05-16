/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon1;

import java.util.Scanner;

/**
 *
 * @author Dampi
 */
public class Dungeon1 {

    static Scanner in = new Scanner(System.in); // Input scanner

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean goAgain = false; // Från början är denna bool false, ändras till true ifall spelaren väljer "Y" i slutet av spelet och vill spela spelet igen.

        do {
            // Player variables
            Player HumanPlayer = new Player(10, 1, 3, 10, 50); // Bestämmer spelarens variabler, hp, attackdamage, health potions, hur mycket health potions healar, vad spelaren har för chans att få health potion efter en fight.

            System.out.println("Welcome to the depths of Luleå!");
            System.out.println("Use W/N/S/E to move around the dungeon.");
            System.out.println("You see an entrance to the north side of the room.\nYou see a crack in the wall to the east side of the room.");

            String userChoice; // userChoice = spelarens input.
            boolean validUserInput = false; // Sätter spelarens input till inte valid, för att sedan gå till check-metoden under

            // Kollar så att inputen som användaren gör är korrekt.
            validUserInput = false;
            do {
                System.out.println("What would you like to do? [n] / [e]");

                userChoice = in.nextLine(); // Tar input från användaren.

                // Värden som är accepterade letar man efter här. I detta fall N och E
                if (userChoice.toUpperCase().equals("N") || userChoice.toUpperCase().equals("E")) {
                    validUserInput = true;
                } else {
                    System.out.println("Incorrect input.\n");
                }
            } while (!validUserInput); // Om validuserinput sätts till true så fortsätter koden, annars körs denna loop igen tills man får en valid input.

            if (userChoice.toUpperCase().equals("N")) {
                System.out.println("You walk into a room with bloody chains hanging from the walls. You can smell the stench.");
                System.out.println("You see a reflective light coming from the back of the room.\nYou inspect the glimmering right. You found a sword!\nYour attack damage is now 2.");
                HumanPlayer.setAttackDamage(2);

                Monster spindel = new Monster(8, 1, "Gregarious Grell"); // Skapar ett monster som har variabeln spindel med namnet Gregarious Grell som har 8 hp och skadar 1 per slag.
                runEncounter(HumanPlayer, spindel); // Kör runEncountermetoden som vi har skapat längre ner.

                System.out.println("You see a door that is slightly cracked open to west.");
                System.out.println("You see a passage to the north.");

                // Kollar så att inputen som användaren gör är korrekt.
                validUserInput = false;
                do {
                    System.out.println("What would you like to do? [w] / [n]");

                    userChoice = in.nextLine();

                    //Värden som är accepterade letar man efter här.
                    if (userChoice.toUpperCase().equals("W") || userChoice.toUpperCase().equals("N")) {
                        validUserInput = true;
                    } else {
                        System.out.println("Incorrect input.\n");
                    }
                } while (!validUserInput);

                if (userChoice.toUpperCase().equals("W")) {
                    System.out.println("You enter an extremely dark room.");
                    Monster rat = new Monster(8, 1, "Rat"); // Bestämmer monstrets values. I detta fall har monster endast HP, Attack och en string för namn.
                    runEncounter(HumanPlayer, rat); // Kör runencounter med spelare och monstret som skapats. I detta fall rat.
                    System.out.println("You can leave the room and enter a cave to the north. You see a small light emitting from the cave.");

                    // // Kollar så att inputen som användaren gör är korrekt.
                    validUserInput = false;
                    do {
                        System.out.println("What would you like to do? [n]");

                        userChoice = in.nextLine();
                        //Värden som är accepterade letar man efter här.
                        if (userChoice.toUpperCase().equals("N")) {
                            validUserInput = true;
                        } else {
                            System.out.println("Incorrect input.\n");
                        }
                    } while (!validUserInput);

                    if (userChoice.toUpperCase().equals("N")) {
                        Monster dragon = new Monster(18, 1, "Dragon");
                        runEncounter(HumanPlayer, dragon);

                        if (dragon.getHealth() <= 0) { // Om draken är död så vinner man spelet.
                            System.out.println("You have defeated the dragon and have claimed the treasure the dragon was protecting. Good job adventurer!");
                            System.out.println("The game is now won. Do you want to play again? Y/N");
                            userChoice = in.nextLine();
                            if (userChoice.toUpperCase().equals("Y")) { // Om man väljer Y så startar man om spelet från början.
                                goAgain = true;
                            }
                            if (userChoice.toUpperCase().equals("N")) { // Väljer man nej så händer ingenting, alltså avslutas spelet.

                            }
                        }
                    }
                }
                if (userChoice.toUpperCase().equals("N")) {
                    System.out.println("You enter an extremely dark room.");
                    Monster golem = new Monster(8, 1, "Golem");
                    runEncounter(HumanPlayer, golem);

                    System.out.println("You can leave the room and enter a cave to the north. You see a small light emitting from the cave. You smell something burnt...");
                    System.out.println("What would you like to do? [n]");
                    userChoice = in.nextLine();
                    if (userChoice.toUpperCase().equals("N")) {
                        Monster dragon = new Monster(18, 1, "Dragon");
                        runEncounter(HumanPlayer, dragon);

                        if (dragon.getHealth() <= 0) { // Om draken är död så vinner man spelet.
                            System.out.println("You have defeated the dragon and have claimed the treasure the dragon was protecting. Good job adventurer!");
                            System.out.println("The game is now won. Do you want to play again? Y/N");
                            userChoice = in.nextLine();
                            if (userChoice.toUpperCase().equals("Y")) {
                                goAgain = true;
                            }
                            if (userChoice.toUpperCase().equals("N")) {

                            }
                        }
                    }
                }
            } else if (userChoice.toUpperCase().equals("E")) {
                System.out.println("You walk into a big room covered in different plants. You can tell that there has been no human activity here for a while.");
                System.out.println("You see a reflective light coming from the back of the room.You inspect the glimmering right. You found a sword! Your attack damage is now 2.");
                HumanPlayer.setAttackDamage(2);
                System.out.println("You see a large passage to the north. You hear faint screams coming from that direction..");
                System.out.println("You see a faint passage to the east.");

                // Kollar så att inputen som användaren gör är korrekt.
                validUserInput = false;
                do {
                    System.out.println("What would you like to do? [n] / [e]");

                    userChoice = in.nextLine();

                    //Värden som är accepterade letar man efter här.
                    if (userChoice.toUpperCase().equals("N") || userChoice.toUpperCase().equals("E")) {
                        validUserInput = true;
                    } else {
                        System.out.println("Incorrect input.\n");
                    }
                } while (!validUserInput);

                if (userChoice.toUpperCase().equals("N")) {
                    System.out.println("The passage leads to a new room that reeks of dead plantation.");
                    Monster flower = new Monster(8, 1, "Toxic plant");
                    runEncounter(HumanPlayer, flower);

                    System.out.println("After fighting the toxic plant, you enter a big room with a small entrance to a cave to the east.");
                    // Kollar så att inputen som användaren gör är korrekt.
                    validUserInput = false;
                    do {
                        System.out.println("What would you like to do? [e]");

                        userChoice = in.nextLine();

                        //Värden som är accepterade letar man efter här.
                        if (userChoice.toUpperCase().equals("E")) {
                            validUserInput = true;
                        } else {
                            System.out.println("Incorrect input.\n");
                        }
                    } while (!validUserInput);

                    if (userChoice.toUpperCase().equals("E")) {
                        System.out.println("You enter the cave. It´s dark and hard to see past your arms..");
                        Monster werewolf = new Monster(8, 1, "Werewolf");
                        runEncounter(HumanPlayer, werewolf);
                        System.out.println("You see a faint light in the distance. It seems to be coming from east.");
                        // Kollar så att inputen som användaren gör är korrekt.
                        validUserInput = false;
                        do {
                            System.out.println("What would you like to do? [e]");

                            userChoice = in.nextLine();

                            //Värden som är accepterade letar man efter här.
                            if (userChoice.toUpperCase().equals("E")) {
                                validUserInput = true;
                            } else {
                                System.out.println("Incorrect input.\n");
                            }
                        } while (!validUserInput);
                        if (userChoice.toUpperCase().equals("E")) {
                            Monster dragon = new Monster(18, 1, "Dragon");
                            runEncounter(HumanPlayer, dragon);

                            if (dragon.getHealth() <= 0) { // Om draken är död så vinner man spelet.
                                System.out.println("You have defeated the dragon and have claimed the treasure the dragon was protecting. Good job adventurer!");
                                System.out.println("The game is now won. Do you want to play again? Y/N");
                                userChoice = in.nextLine();
                                if (userChoice.toUpperCase().equals("Y")) {
                                    goAgain = true;
                                }
                                if (userChoice.toUpperCase().equals("N")) {

                                }
                            }
                        }

                    }

                    if (userChoice.toUpperCase().equals("E")) {
                        System.out.println("The passage leads to a large, empty room.");
                        Monster werewolf = new Monster(8, 1, "Werewolf");
                        runEncounter(HumanPlayer, werewolf);

                        System.out.println("You see a faint light in the distance. It seems to be coming from east.");
                        // Kollar så att inputen som användaren gör är korrekt.
                        validUserInput = false;
                        do {
                            System.out.println("What would you like to do? [e]");

                            userChoice = in.nextLine();

                            //Värden som är accepterade letar man efter här.
                            if (userChoice.toUpperCase().equals("e")) {
                                validUserInput = true;
                            } else {
                                System.out.println("Incorrect input.\n");
                            }
                        } while (!validUserInput);
                        if (userChoice.toUpperCase().equals("E")) {
                            Monster dragon = new Monster(18, 1, "Dragon");
                            runEncounter(HumanPlayer, dragon);

                            if (dragon.getHealth() <= 0) { // Om draken är död så vinner man spelet.
                                System.out.println("You have defeated the dragon and have claimed the treasure the dragon was protecting. Good job adventurer!");
                                System.out.println("The game is now won. Do you want to play again? Y/N");
                                userChoice = in.nextLine();
                                if (userChoice.toUpperCase().equals("Y")) {
                                    goAgain = true;
                                }
                                if (userChoice.toUpperCase().equals("N")) {

                                }
                            }
                        }

                    }

                } else if (userChoice.toUpperCase().equals("E")) {
                    System.out.println("You walk into a big room covered strange demonic writings. You can tell that there has been no human activity here for a while.");
                    Monster demon = new Monster(8, 1, "Demon");
                    runEncounter(HumanPlayer, demon);
                    System.out.println("You see a large passage to the north. You hear faint screams coming from that direction..");
                    System.out.println("You see a faint passage to the east.");

                    // Kollar så att inputen som användaren gör är korrekt.
                    validUserInput = false;
                    do {
                        System.out.println("What would you like to do? [n] / [e]");

                        userChoice = in.nextLine();

                        //Värden som är accepterade letar man efter här.
                        if (userChoice.toUpperCase().equals("N") || userChoice.toUpperCase().equals("E")) {
                            validUserInput = true;
                        } else {
                            System.out.println("Incorrect input.\n");
                        }
                    } while (!validUserInput);

                    if (userChoice.toUpperCase().equals("N")) {
                        System.out.println("You enter a room with glass shattered all over the floor.");
                        System.out.println("All of a sudden you get attacked by a dragon!");
                        Monster dragon = new Monster(18, 1, "Dragon");
                        runEncounter(HumanPlayer, dragon);
                        if (dragon.getHealth() <= 0) { // Om draken är död så vinner man spelet.
                            System.out.println("You have defeated the dragon and have claimed the treasure the dragon was protecting. Good job adventurer!");
                            System.out.println("The game is now won. Do you want to play again? Y/N");
                            userChoice = in.nextLine();
                            if (userChoice.toUpperCase().equals("Y")) {
                                goAgain = true;
                            }
                            if (userChoice.toUpperCase().equals("N")) {

                            }
                        }

                    }
                    if (userChoice.toUpperCase().equals("E")) {
                        System.out.println("You enter a room with a human body lying on the floor.");
                        System.out.println("All of a sudden you get attacked by a dragon!");
                        Monster dragon = new Monster(18, 1, "Dragon");
                        runEncounter(HumanPlayer, dragon);
                        if (dragon.getHealth() <= 0) { // Om draken är död så vinner man spelet.
                            System.out.println("You have defeated the dragon and have claimed the treasure the dragon was protecting. Good job adventurer!");
                            System.out.println("The game is now won. Do you want to play again? Y/N");
                            userChoice = in.nextLine();
                            if (userChoice.toUpperCase().equals("Y")) {
                                goAgain = true;
                            }
                            if (userChoice.toUpperCase().equals("N")) {

                            }
                        }

                    }

                }
            }
        } while (goAgain);
    }

// Metod för hur själva battle-encounters fungerar.
    public static void runEncounter(Player player, Monster monster) {
        System.out.println("-----------------------------------");
        System.out.println("\t# " + monster.getName() + " appeared! #\n");

        while (monster.getHealth() > 0) { // Detta körs medan monstrets HP är över 0.
            System.out.println("\tYour HP: " + player.getHealth()); // Hämtar spelarens värde i health.
            System.out.println("\t" + monster.getName() + "'s HP: " + monster.getHealth()); // Hämtar monstrets namn och health.
            System.out.println("\n\tChoose your action:");
            System.out.println("\t1. Attack");
            System.out.println("\t2. Drink health potion");
            System.out.println("\t3. Run!");

            String input = in.nextLine();
            if (input.equals("1")) {
                int playerDamage = player.getAttackDamage();  //Tar emot spelarens attackdamge
                int monsterDamage = monster.getAttackDamage(); //Hämtar monstrets attackdamage

                monster.takeDamage(playerDamage); // Kör metoden monster.takedamage som kör matten health -=damagetaken i playerklassen.
                player.takeDamage(monsterDamage); // Kör metoden player.takeDamage som kör matten health -=damagetaken i playerklassen.

                System.out.println("\t> You attack the " + monster.getName() + " for " + playerDamage + " damage.");
                System.out.println("\t> The " + monster.getName() + " hits you for " + monsterDamage + "!");

                if (player.getHealth() < 1) { // om spelarens health når under 1 så skrivs denna rad ut och spelet tar slut.
                    System.out.println("\t You have taken too much damage, game over!");
                    break;
                }
            } else if (input.equals("2")) { // Om man ger input två så körs metoden healPlayer som tar bort en healthpotion och helar spelaren.
                if (player.getNumHealthPotions() > 0) {
                    player.healPlayer();
                    System.out.println("\t> You drank a health potion. It recovered all of your health! \n\tYou have " + player.getNumHealthPotions() + " health potions left.");

                } else {
                    System.out.println("\t>You have no more health potions."); // Skriver ut detta ifall spelaren inte har några health potions kvar.
                }
            } else if (input.equals("3")) { // Flyr från monstret.
                System.out.println("\t> You run away from the " + monster.getName() + ".");
            } else {
                System.out.println("\tInvalid command.");

            }
            if (player.getHealth() < 1) {
                System.out.println("You run out of the dungeon, damaged and exhausted.");
                break;

            }

        }

        System.out.println("-----------------------------------");
        System.out.println("> " + monster.getName() + " was defeated!");

        if (!monster.getName().equals("Dragon")) {
            System.out.println("> You have " + player.getHealth() + " health remaining.");

            player.checkLoot(); // Metod för att randomly ge spelaren en health potion efter encounter

            System.out.println("-----------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue fighting.");
            System.out.println("2. Exit the dungeon.");
            System.out.println("3. Drink a health potion.");

            String input = in.nextLine();

            if (!input.equals("1") && !input.equals("2") && !input.equals("3")) { // om input inte är 1,2 eller 3 så ges invalid command och spelaren får göra en ny input.
                System.out.println("Invalid command.");
                input = in.nextLine();
            }
            if (input.equals("1")) {
                System.out.println("You continue your adventure.");

            } else if (input.equals("2")) {
                System.out.println("You exit the dungeon successfully!");

            } else if (input.equals("3")) {
                player.healPlayer();
                System.out.println("You drink a health potion.\nIt recovered all of your health.\nYour health is now " + player.getHealth() + ".\nYou have " + player.getNumHealthPotions() + " left.");
            }

        }

    }
}
