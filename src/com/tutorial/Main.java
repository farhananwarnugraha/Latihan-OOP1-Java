package com.tutorial;

//player
class Player{
    String name;
    double health;
    int level;
    //object member
    Weapon weapon;
    Armour armour;

    Player(String name, double health){
        this.name = name;
        this.health = health;
    }

    void attack(Player opponent){
        double attackPower = this.weapon.attackPower;
        System.out.println(this.name + " attacking " + opponent.name + " With power " + attackPower);

        opponent.deffence(attackPower);
    }

    void deffence(double attackPower){
        //akan mengambil demage
        double damage;
        if (this.armour.defencePower < attackPower){
             damage = attackPower - this.armour.defencePower;
        }else {
            damage = 0;
        }

        this.health -= damage;
        System.out.println(this.name + " gets demage " + damage);
    }

    void equipWeapon(Weapon weapon){
        this.weapon = weapon;
    }
    void equipArmour(Armour armour){
        this.armour = armour;
    }

    void display(){
        System.out.println("\nName : " + this.name);
        System.out.println("Health : " + this.health + " hp");
        this.weapon.display();
        this.armour.display();
    }

}

//senjata
class Weapon{
    double attackPower;
    String name;
    Weapon(String name, double attackPower){
        this.name = name;
        this.attackPower = attackPower;
    }
    void display(){
        System.out.println("Weapon : " + this.name + " , Attack : " + this.attackPower);
    }
}

// armor
class Armour{
    double defencePower;
    String name;

    Armour(String name,double defencePower){
        this.defencePower = defencePower;
        this.name = name;
    }

    void display(){
        System.out.println("Armour : " + this.name + " , Defence : " + this.defencePower);
    }
}




public class Main {
    public static void main(String[] args) {
        //membuat object player
        Player player1 = new Player("Ucup", 100);
        Player player2 = new Player("Alfy", 50);
        //membuat object weapon
        Weapon pedang = new Weapon("Pedang",15);
        Weapon panah = new Weapon("Panah", 5);
        //object armour
        Armour bajuBesi = new Armour("Baju Besi",10);
        Armour kaos = new Armour("Perisai", 5);

        //equip senjata dan armoru
        //Player 1
        player1.equipWeapon(pedang);
        player1.equipArmour(bajuBesi);
        player1.display();

        //player2
        player2.equipWeapon(panah);
        player2.equipArmour(kaos);
        player2.display();

        System.out.println("\nPertrmpuran");
        player1.attack(player2);
        player1.display();
        player2.display();
        System.out.println("=========================");
        player2.attack(player1);
        player2.display();
        player1.display();
    
    }
    
}
