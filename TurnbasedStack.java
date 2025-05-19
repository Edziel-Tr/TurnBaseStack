package com.mycompany.lohera;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class TurnbasedStack {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Stack<Integer> LastHP = new Stack<>();
        Random randomizer = new Random();

        String playerName = "Qiann The Great";
        String botName = "Vinze And Friends";
        int playerHP = 1000;
        int botHP = 5000;
        int botMaxHP = 5000;
        int playerMinDmg = 100;
        int playerMaxDmg = 2000;
        int botMinDmg = 50;
        int botMaxDmg = 75;
        int stunTurns = 0;
        int turnCount = 1;
        int chance;
        
        System.out.println("Choose a Class Sir " + playerName);
        System.out.println("Knight");
        System.out.println("Mage");
        System.out.println("Ranger");
        System.out.println("Warrior");
        System.out.println("You encountered an enemy!");
        while (playerHP > 0 && botHP > 0) {
            System.out.println("\n    Turn " + turnCount + "   ");

            if (turnCount % 2 == 1) {
                if (stunTurns > 0) {
                    System.out.println("Enemy is stunned! You get another turn.");
                    stunTurns--;
                }
                System.out.println("What would you like to do?");
                System.out.println("Player HP: " + playerHP);
                System.out.println("Bot HP: " + botHP);
                System.out.println(">>> Attack");
                System.out.println(">>> Stun");
                System.out.println(">>> Dance");
                System.out.println(">>> Skip");
                String in = scan.nextLine().trim();

                if (in.equalsIgnoreCase("Attack")) {
                    int playerDmg = randomizer.nextInt(playerMaxDmg - playerMinDmg + 1) + playerMinDmg;
                    botHP -= playerDmg;
                    System.out.println("You dealt " + playerDmg + " damage to the enemy.");
                } else if (in.equalsIgnoreCase("Stun")) {
                    System.out.println("You stunned the enemy for 2 turns!");
                    stunTurns = 2;
                } else if (in.equalsIgnoreCase("Dance")) {
                    System.out.println("You performed a dance. It's not very effective...");
                } else if (in.equalsIgnoreCase("Skip")) {
                    System.out.println("You skipped your turn.");
                } else {
                    System.out.println("Invalid action. You lost your turn.");
                }
            } else {

                if (stunTurns > 0) {
                    System.out.println("Bot is stunned and skips its turn!");
                    stunTurns--;
                } else {

                    if (botHP <= botMaxHP / 2 && randomizer.nextInt(100) < 25) {
                        int healAmount = randomizer.nextInt(501) + 500;
                        botHP += healAmount;
                        if (botHP > botMaxHP) {
                            botHP = botMaxHP;
                        }
                        System.out.println("The enemy has triggered healing passive " + healAmount + " HP!");
                    } else {
                        int botDmg = randomizer.nextInt(botMaxDmg - botMinDmg + 1) + botMinDmg;
                        playerHP -= botDmg;
                        System.out.println("The enemy dealt " + botDmg + " damage to you.");
                    }
                }
            }

            turnCount++;

        }

        if (playerHP <= 0) {
            System.out.println("\nDefeat! The enemy has slain " + playerName + "!");
        } else if (botHP <= 0) {
            System.out.println("\nVictory! " + playerName + " has slain the enemy!  " + botName);
        }
    }

    static boolean isOddOrEven(int i) {
        boolean oddOrEven;
        if (i % 2 == 0) {
            return oddOrEven = true;
        } else {
            return oddOrEven = false;

        }
    }
}
