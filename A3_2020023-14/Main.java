package com.company;

import java.util.*;
class Player{
    private int Points;
    private int Floor;
    private final String Name; // Final Used
    Player(String name){
        this.Floor = -1;
        this.Name = name;
        this.Points = 0;
    }

    public int getPoints() {return Points;}
    public void setPoints(int points) {Points = points;}
    public int getFloor() {
        return Floor;
    }
    public void setFloor(int floor) {Floor = floor;}
    public String getName() {
        return Name;
    }
}

class Floor{
    private final Player player;   //
    Floor(Player plyr){
        this.player = plyr;
    }
    public String player_name(){
        return player.getName();
    }

}
class Empty_Floor extends Floor{
    private int pts ;
    private int floor ;

    Empty_Floor(Player player,int point,int Floor){
        super(player);
        this.pts = point;
        this.floor = Floor;
        player.setFloor(floor);
        player.setPoints(pts);
    }
    public int getPts() {return pts;}
    public void setPts(int pts) {this.pts = pts;}
    public int getFloor() {return floor;}
    public void setFloor(int floor) {this.floor = floor;}
    @Override
    public String toString(){
        System.out.println(player_name()+" has reached an Empty Floor");
        return "Total Points "+getPts();
    }
}
abstract class Ladder_Floor extends Floor{
    Ladder_Floor(Player plyr) {
        super(plyr);
    }
}
class Normal_Ladder extends Ladder_Floor{
    private int pts ;
    private final int floor;
    Normal_Ladder(Player player){
        super(player);
        this.pts= player.getPoints()+2;
        this.floor=12;
        player.setFloor(floor);
        player.setPoints(pts);
    }
    public int getPts() {return pts;}
    public void setPts(int pts) {this.pts = pts;}
    public int getFloor() {return floor;}

    @Override
    public String toString() {
        System.out.println("Player Position Floor:"+getFloor());
        System.out.println(player_name()+" has reached an Normal Ladder Floor");
        return "Total Points "+ getPts();
    }
}
class Elevator_Ladder extends Ladder_Floor{
    private int pts;
    private final int floor;
    Elevator_Ladder(Player player){
        super(player);
        this.pts=player.getPoints()+4;
        this.floor = 10;
        player.setPoints(pts);
        player.setFloor(floor);
    }
    public int getPts() {return pts;}
    public void setPts(int pts) {this.pts = pts;}
    public int getFloor() {return floor;}

    @Override
    public String toString() {
        System.out.println(player_name()+" has reached an Elevator Floor");
        System.out.println("Total Points "+ getPts());
        return "Player Position Floor:"+getFloor();
    }
}
abstract class Snake_Floor extends Floor{
    Snake_Floor(Player plyr) {
        super(plyr);
    }
}
class Normal_Snake extends Snake_Floor{
    private int pts;
    private final int floor;
    Normal_Snake(Player player){
        super(player);
        this.pts=player.getPoints()-2;
        this.floor=1;
        player.setFloor(floor);
        player.setPoints(pts);
    }

    public int getPts() {return pts;}
    public void setPts(int pts) {this.pts = pts;}
    public int getFloor() {return floor;}

    @Override
    public String toString() {
        System.out.println("Player Position Floor:"+getFloor());
        System.out.println(player_name()+" has reached an Normal Snake Floor");
        return "Total Points "+ getPts();
    }

}
class Cobra_Snake extends Snake_Floor{
    private int pts;
    private final int floor;
    Cobra_Snake(Player player){
        super(player);
        this.pts=player.getPoints()-4;
        this.floor=3;
        player.setFloor(floor);
        player.setPoints(pts);
    }

    public int getPts() {return pts;}
    public void setPts(int pts) {this.pts = pts;}
    public int getFloor() {return floor;}

    @Override
    public String toString() {
        System.out.println("Player Position Floor:"+getFloor());
        System.out.println(player_name()+" has reached an King Cobra Snake Floor");
        return "Total Points "+ getPts();
    }
}
class Dice{
    private final int face; // Final

    Dice(){
        Random random = new Random();
        face = 1+ random.nextInt(2);
    }
    public int getFace() {
        return face;
    }

    @Override
    public String toString() {
        return "Dice gave"+getFace();
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Player Name and hit Enter:");
        String name = sc.nextLine();
        System.out.println(name);
        System.out.println("The Game Setup is Ready");
        int flag = 0;
        int count_floor = -1;
        Player player = new Player(name);
        Empty_Floor empty_floor = new Empty_Floor(player,1,0);

        while(true){
            while(flag==0){
                System.out.println("Hit Enter to roll the dice");
                String enterf = sc.nextLine();
                Dice dice = new Dice();
                if(enterf.equals("")){
                    if(dice.getFace()==2){
                        System.out.println("Game cannot start until you get 1");
                    }
                    else if(dice.getFace()==1){
                        System.out.println("Dice Gave 1");
                        System.out.println("Player Position Floor: "+empty_floor.getFloor());
                        System.out.println(empty_floor);
                        count_floor++;
                        flag=1;
                    }
                }
                else System.out.println("Try Again");
            }
            System.out.println("Hit Enter to roll the dice");
            String enter = sc.nextLine();
            Dice dice = new Dice();
            int face = dice.getFace();
            System.out.println("Dice Gave "+face);//------Being printed
            count_floor = count_floor+face;
            player.setFloor(player.getFloor()+face);
            if(enter.equals("")){
                if(count_floor==0){
                    System.out.println(empty_floor);
                }
                if(count_floor==1 || count_floor==3 || count_floor==4 || count_floor==6 || count_floor==7 || count_floor==9 || count_floor==10){//EMPTY
                    empty_floor.setFloor(player.getFloor());
                    empty_floor.setPts(player.getPoints()+1);// ------****------ //
                    player.setPoints(empty_floor.getPts());
                    System.out.println("Player Position Floor: "+empty_floor.getFloor());
                    System.out.println(empty_floor);
                }
                else if(count_floor==2){//ELEVATOR + EMPTY
                    Elevator_Ladder elevator_ladder = new Elevator_Ladder(player);
                    System.out.println(elevator_ladder);
                    empty_floor.setPts(elevator_ladder.getPts()+1);
                    empty_floor.setFloor(elevator_ladder.getFloor());
                    player.setPoints(elevator_ladder.getPts()+1);
                    System.out.println(empty_floor);
                    count_floor=10;
                }
                else if(count_floor==5){//NORMAL SNAKE + EMPTY
                    Normal_Snake normal_snake = new Normal_Snake(player);
                    System.out.println(normal_snake);
                    empty_floor.setFloor(normal_snake.getFloor());
                    empty_floor.setPts(normal_snake.getPts()+1);
                    player.setPoints(normal_snake.getPts()+1);
                    System.out.println(empty_floor);
                    count_floor=1;
                }
                else if(count_floor==8){//NORMAL LADDER + EMPTY
                    Normal_Ladder normal_ladder = new Normal_Ladder(player);
                    System.out.println(normal_ladder);
                    empty_floor.setFloor(normal_ladder.getFloor());
                    empty_floor.setPts(normal_ladder.getPts()+1);
                    player.setPoints(normal_ladder.getPts()+1);
                    System.out.println(empty_floor);
                    count_floor=12;
                }
                else if(count_floor==11){//KING COBRA + EMPTY
                    Cobra_Snake cobra_snake = new Cobra_Snake(player);
                    System.out.println(cobra_snake);
                    empty_floor.setFloor(cobra_snake.getFloor());
                    empty_floor.setPts(cobra_snake.getPts()+1);
                    player.setPoints(cobra_snake.getPts()+1);
                    System.out.println(empty_floor);
                    count_floor=3;
                }
                else if(count_floor==12){
                    empty_floor.setFloor(player.getFloor());
                    empty_floor.setPts(player.getPoints()+1);// ------****------ //
                    player.setPoints(empty_floor.getPts());
                    System.out.println("Player Position Floor :"+empty_floor.getFloor());
                    System.out.println(empty_floor);

                }
                else if(count_floor==13){
                    empty_floor.setFloor(empty_floor.getFloor()+1);
                    empty_floor.setPts(empty_floor.getPts()+1);
                    player.setPoints(empty_floor.getPts());
                    System.out.println(empty_floor);
                    System.out.println("Game Over");
                    System.out.println(player.getName()+" Accumulated "+player.getPoints()+" Points");
                    System.out.println("-----------------------------------------------");
                    break;
                }
                else if(count_floor>13){
                    System.out.println("Player Cannot Move");
                    count_floor=12;
                }
            }
            else System.out.println("Wrong value");
            if(enter.equals("0")) break;
        }
    }
}
