package machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeMachine {

    private static int money = 550;
    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int disposableCups = 9;
    private static boolean engine = true;

    private static void coffeeMachineInfo(){
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }

    private static void buy() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
            String s = reader.readLine();
            if (!s.equals("back")) {
                int sortOfCoffee = Integer.parseInt(s);
                if (sortOfCoffee == 1) {
                    if (water < 250) {
                        System.out.println("Sorry, not enough water!");
                    }
                    if (coffeeBeans < 16) {
                        System.out.println("Sorry, not enough coffee beans!");
                    }
                    if (disposableCups < 1) {
                        System.out.println("Sorry, not enough disposable cups!");
                    }
                    if (water >= 250) {
                        water = water - 250;
                        if (coffeeBeans >= 16) {
                            coffeeBeans = coffeeBeans - 16;
                            if (disposableCups >= 1) {
                                disposableCups--;
                                money = money + 4;
                                System.out.println("I have enough resources, making you a coffee!");

                            }
                        }
                    }
                }

                if (sortOfCoffee == 2) {
                    if (water < 350) {
                        System.out.println("Sorry, not enough water!");
                    }
                    if (coffeeBeans < 20) {
                        System.out.println("Sorry, not enough coffee beans!");
                    }
                    if (disposableCups < 1) {
                        System.out.println("Sorry, not enough disposable cups!");
                    }
                    if (milk < 75) {
                        System.out.println("Sorry, not enough disposable milk!");
                    }

                    if (water >= 350) {
                        water = water - 350;
                        if (coffeeBeans >= 20) {
                            coffeeBeans = coffeeBeans - 20;
                            if (disposableCups >= 1) {
                                disposableCups--;
                                if (milk >= 75) {
                                    milk = milk - 75;
                                    money = money + 7;
                                    System.out.println("I have enough resources, making you a coffee!");
                                }
                            }
                        }
                    }
                }

                if (sortOfCoffee == 3) {
                    if (water < 200) {
                        System.out.println("Sorry, not enough water!");
                    }
                    if (coffeeBeans < 12) {
                        System.out.println("Sorry, not enough coffee beans!");
                    }
                    if (disposableCups < 1) {
                        System.out.println("Sorry, not enough disposable cups!");
                    }
                    if (milk < 100) {
                        System.out.println("Sorry, not enough disposable milk!");
                    }
                    if (water >= 200) {
                        water = water - 200;
                        if (coffeeBeans >= 12) {
                            coffeeBeans = coffeeBeans - 12;
                            if (disposableCups >= 1) {
                                disposableCups--;
                                if (milk >= 100) {
                                    milk = milk - 100;
                                    money = money + 6;
                                    System.out.println("I have enough resources, making you a coffee!");
                                }
                            }
                        }
                    }

                }

            }
    }

    private static void fill() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Write how many ml of water do you want to add:");
        int addWater = Integer.parseInt(reader.readLine());
        water = water + addWater;
        System.out.println("Write how many ml of milk do you want to add:");
        int addMilk = Integer.parseInt(reader.readLine());
        milk = milk + addMilk;
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int addCoffeeBeans = Integer.parseInt(reader.readLine());
        coffeeBeans = coffeeBeans + addCoffeeBeans;
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int addDisposableCups = Integer.parseInt(reader.readLine());
        disposableCups = disposableCups + addDisposableCups;
    }

    private static void take(){
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public static void main(String[] args) throws IOException{
        while (engine) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String action = reader.readLine();
            if (action.equals("buy")) {
                buy();
            }
            if (action.equals("fill")) {
                fill();
            }
            if (action.equals("take")) {
                take();
            }
            if (action.equals("remaining")) {
                coffeeMachineInfo();
            }
            if (action.equals("exit")) {
                engine = false;
            }
        }
    }
}
