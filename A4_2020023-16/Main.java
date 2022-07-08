package com.company;
import java.util.*;

class Generic_Calculator <T>{
    private T first_alphaNum;
    private T second_alphaNum;
    Generic_Calculator(T x,T y){
        this.first_alphaNum = x;
        this.second_alphaNum = y;
    }
    public Object Calculate(T first_alphaNum, T second_alphaNum){
        if(first_alphaNum instanceof Integer && second_alphaNum instanceof Integer){
            int a = (int) first_alphaNum;
            int b = (int) second_alphaNum;
            return (a/b);
        }
        else if(first_alphaNum instanceof String && second_alphaNum instanceof String){
            return (String)first_alphaNum +(String) second_alphaNum;
        }
        else {
            System.out.println("Reached Here Just for the sake of error detection!");
            return null;
        }
    }
}

class Tiles{
    private SoftToys softToys;
    Tiles(String toyname){
        this.softToys = new SoftToys(toyname);
    }
    public SoftToys getSoftToys() {
        return softToys;
    }
}

class SoftToys implements Cloneable{
    private String toyname;
    SoftToys(String toyname){
        this.toyname = toyname;
    }
    public String getToyname() {
        return toyname;
    }
    public void setToyname(String toyname) {
        this.toyname = toyname;
    }
    @Override
    public SoftToys clone(){
        try{
            return (SoftToys) super.clone();
        }
        catch (CloneNotSupportedException e){
            System.out.println("Clone not Supported Error"+e);
            return null;
        }
    }
}

class Player{
    private final ArrayList<String> toys_bucket ;//For storing the collected toys
    private int landed_on;
    private int chances;
    Random random = new Random();

    Player(ArrayList<String> toys_bucket){
        this.chances = 5;
        this.toys_bucket = toys_bucket;
    }
    public void Roll_Random(){
        landed_on = random.nextInt(21);
    }
    public int getLanded_on() {
        return landed_on;
    }
    public int getChances() {
        return chances;
    }
    public void setChances() {this.chances = chances-1;}
    public ArrayList<String> getBucket() {
        return toys_bucket;
    }
    public void setBucket(String element) {
        this.toys_bucket.add(element);
    }
}

class Game{

    Scanner sc2 = new Scanner(System.in);
    private final Player player;
    private int chance;
    private final ArrayList<SoftToys> softToysArrayList; // Storing the object of SoftToys class
    Game(ArrayList<SoftToys> softToysArrayList){
        this.softToysArrayList = softToysArrayList;
        this.player = new Player(new ArrayList<String>());
        this.chance = player.getChances();
        Toys_in_Game();
    }
    public void Toys_in_Game(){
        Tiles t1 = new Tiles("Ben10");
        softToysArrayList.add(t1.getSoftToys());
        Tiles t2 = new Tiles("Mr.Bean");
        softToysArrayList.add(t2.getSoftToys());
        Tiles t3 = new Tiles("Tom");
        softToysArrayList.add(t3.getSoftToys());
        Tiles t4 = new Tiles("Jerry");
        softToysArrayList.add(t4.getSoftToys());
        Tiles t5 = new Tiles("Shaun");
        softToysArrayList.add(t5.getSoftToys());
        Tiles t6 = new Tiles("Oggy");
        softToysArrayList.add(t6.getSoftToys());
        Tiles t7 = new Tiles("Bob");
        softToysArrayList.add(t7.getSoftToys());
        Tiles t8 = new Tiles("Ollie");
        softToysArrayList.add(t8.getSoftToys());
        Tiles t9 = new Tiles("Doremon");
        softToysArrayList.add(t9.getSoftToys());
        Tiles t10 = new Tiles("Shinchan");
        softToysArrayList.add(t10.getSoftToys());
        Tiles t11 = new Tiles("Nobita");
        softToysArrayList.add(t11.getSoftToys());
        Tiles t12 = new Tiles("Bheem");
        softToysArrayList.add(t12.getSoftToys());
        Tiles t13 = new Tiles("DragonBall");
        softToysArrayList.add(t13.getSoftToys());
        Tiles t14 = new Tiles("PowerPuff");
        softToysArrayList.add(t14.getSoftToys());
        Tiles t15 = new Tiles("Herny");
        softToysArrayList.add(t15.getSoftToys());
        Tiles t16 = new Tiles("Shizuka");
        softToysArrayList.add(t16.getSoftToys());
        Tiles t17 = new Tiles("Peter");
        softToysArrayList.add(t17.getSoftToys());
        Tiles t18 = new Tiles("Gwen");
        softToysArrayList.add(t18.getSoftToys());
        Tiles t19 = new Tiles("Goku");
        softToysArrayList.add(t19.getSoftToys());
        Tiles t20 = new Tiles("Pikkachu");
        softToysArrayList.add(t20.getSoftToys());
//        Tiles t21 = new Tiles("Muddy Puddle Splash");
//        softToysArrayList.add(t21.getSoftToys());
    }
    public int getChance() {
        return player.getChances();
    }
    public Player getPlayer() {
        return player;
    }
    public int getPosition() {
        return player.getLanded_on();
    }

    public ArrayList<SoftToys> getSoftToysArrayList() {
        return softToysArrayList;
    }

    public void BucketWorthy(String format,int pos){
        if(format.equals("integer")){
            Random random = new Random();
            int a = random.nextInt(9999);
            int b = 0;
            boolean t = false;
            while(!t){
                try{
                    b = random.nextInt(999);
                    if(b>0) t=true;
                }
                catch (ArithmeticException div){
                    System.out.println("Second Number cannot be Zero"+div);
                }
            }
            System.out.println("Calculate the Result of "+a+" divided by "+b);
            Generic_Calculator<Integer> int_val = new Generic_Calculator<Integer>(a,b);
            int userAns = 0;
            boolean done = false;
            while(!done) {
                System.out.println("Enter Integer Input");
                try {
                    Scanner sc = new Scanner(System.in);
                    userAns = sc.nextInt();
                    done = true;
                }
                catch(InputMismatchException inp) {
                    System.out.println("Wrong input:"+inp);
                }
            }
            int corrAns = (int) int_val.Calculate(a, b);
            System.out.println("Correct Answer is:"+int_val.Calculate(a, b));
            if(userAns==corrAns){
                System.out.println("Correct Answer");
                System.out.print("You Won a ");
                SoftToys st = getSoftToysArrayList().get(pos).clone();
                System.out.print(st.getToyname());
                System.out.println(" Soft Toy");
                getPlayer().setBucket(st.getToyname());
            }
            else{
                System.out.println("Incorrect Answer");
                System.out.println("You Did not won any Soft Toy in this Hop");
            }
        }
        else if(format.equals("string")){
            String AlphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
            int size = 4;
            StringBuilder stringBuilder = new StringBuilder(size);
            for (int i = 0; i < size; i++) {
                // generate a random number between 0 to AlphabetString length
                int position = (int) (AlphabetString.length() * Math.random());
                stringBuilder.append(AlphabetString.charAt(position));
            }
            StringBuilder stringBuilder1 = new StringBuilder(size);
            for (int i = 0; i < size; i++) {
                // generate a random number between 0 to AlphabetString length
                int position = (int) (AlphabetString.length() * Math.random());
                stringBuilder1.append(AlphabetString.charAt(position));
            }
            String a = stringBuilder.toString();
            String b = stringBuilder1.toString();
            System.out.println("Calculate the Concatenation of strings "+a+" and "+b);
            Generic_Calculator<String > str_val = new Generic_Calculator<String>(a,b);
            String UserAns = sc2.nextLine();
            String CorrAns = (String) str_val.Calculate(a, b);
            System.out.println("Correct Answer is:"+str_val.Calculate(a,b));
            if(UserAns.equals(CorrAns)){
                SoftToys st = getSoftToysArrayList().get(pos).clone();
                System.out.print("You Won a ");
                System.out.print(st.getToyname());
                System.out.println(" Soft Toy ");
                getPlayer().setBucket(st.getToyname());
            }
            else{
                System.out.println("Incorrect Answer");
                System.out.println("You Did not won any Soft Toy in this Hop");
            }
        }
        else{
            System.out.println("String passed is null");
        }
    }

    public void checker(String input) throws MyException{
        if(!input.equals("")){
            throw new MyException(" Empty String not Entered ");
        }
    }
}

class MyException extends Exception{
    public MyException(String message){
        super(message);
    }
}
public class Main {
    public static void main(String[] args) {

        ArrayList<SoftToys> softToysArrayList = new ArrayList<>();
        Game game = null;
        boolean done = false;
        while (!done){
            System.out.println("Hit enter to initialize the game");
            try{
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();
                if(input.equals("")) {
                    done = true;
                    game = new Game(softToysArrayList);
                }
                throw new MyException("");
            }
            catch(MyException ex){
                System.out.print(ex.getMessage());
            }
        }
        boolean done1 = false;
        while (!done1){
            System.out.println("Hit enter for your First Hop");
            try{
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();
                game.checker(input);
                done1 = true;
            }
            catch(MyException ex){
                System.out.println(ex.getMessage());
            }
        }
        if(game.getChance() == 5){
            game.getPlayer().Roll_Random();
            int position = game.getPosition();
            if(position==20){
                System.out.println("You are too energetic and zoomed past all the Tiles.Muddy Puddle Splash!");
            }
            else if((position+1)%2!=0){//ODD
                System.out.print("You Landed on tile ");
                System.out.println(position+1);
                boolean done2 = false;
                String in = "";
                while (!done2){
                    System.out.println("Question Answer Round.integer Or string");
                    try{
                        Scanner sc = new Scanner(System.in);
                        in = sc.nextLine();
                        if(in.equals("integer")) {
                            done2 = true;
                        }
                        else if(in.equals("string")){
                            done2 = true;
                        }
                        if(!done2)
                        throw new MyException("String Does not Match Exception");
                    }
                    catch(MyException e){
                        System.out.println(e.getMessage());
                    }
                }
                game.BucketWorthy(in,position);
            }
            else if((position+1)%2==0){//EVEN
                System.out.print("You Landed on tile ");
                System.out.println(position+1);
                SoftToys st = game.getSoftToysArrayList().get(position).clone();
                System.out.print("You Won a ");
                System.out.print(st.getToyname());
                System.out.println(" Soft Toy");
                game.getPlayer().setBucket(st.getToyname());
            }
            game.getPlayer().setChances();
        }
        boolean done3 = false;
        while (!done3){
            System.out.println("Hit enter for your Second Hop");
            try{
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();
                game.checker(input);
                done3 = true;
            }
            catch(MyException ex){
                System.out.println(ex.getMessage());
            }
        }
        if(game.getChance() == 4){
            game.getPlayer().Roll_Random();
            int position = game.getPosition();
            if(position==20){
                System.out.println("You are too energetic and zoomed past all the Tiles.Muddy Puddle Splash!");
            }
            else if((position+1)%2!=0){//ODD
                System.out.print("You Landed on tile ");
                System.out.println(position+1);
                boolean done4 = false;
                String in = "";
                while (!done4){
                    System.out.println("Question Answer Round.integer Or string");
                    try{
                        Scanner sc = new Scanner(System.in);
                        in = sc.nextLine();
                        if(in.equals("integer")) {
                            done4 = true;
                        }
                        else if(in.equals("string")){
                            done4 = true;
                        }
                        if(!done4)
                        throw new MyException(" String Does not Match Exception");
                    }
                    catch(MyException e){
                        System.out.println(e.getMessage());
                    }
                }
                game.BucketWorthy(in,position);
            }
            else if((position+1)%2==0){//EVEN
                System.out.print("You Landed on tile ");
                System.out.println(position+1);
                SoftToys st = game.getSoftToysArrayList().get(position).clone();
                System.out.print("You Won a ");
                System.out.print(st.getToyname());
                System.out.println(" Soft Toy");
                game.getPlayer().setBucket(st.getToyname());
            }
            game.getPlayer().setChances();
        }
        boolean done5 = false;
        while (!done5){
            System.out.println("Hit enter for your Third Hop");
            try{
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();
                game.checker(input);
                done5 = true;
            }
            catch(MyException ex){
                System.out.println(ex.getMessage());
            }
        }
        if(game.getChance() == 3){
            game.getPlayer().Roll_Random();
            int position = game.getPosition();
            if(position==20){
                System.out.println("You are too energetic and zoomed past all the Tiles.Muddy Puddle Splash!");
            }
            else if((position+1)%2!=0){//ODD
                System.out.print("You Landed on tile ");
                System.out.println(position+1);
                boolean done4 = false;
                String in = "";
                while (!done4){
                    System.out.println("Question Answer Round.integer Or string");
                    try{
                        Scanner sc = new Scanner(System.in);
                        in = sc.nextLine();
                        if(in.equals("integer")) {
                            done4 = true;
                        }
                        else if(in.equals("string")){
                            done4 = true;
                        }
                        if(!done4)
                        throw new MyException(" String Does not Match Exception");
                    }
                    catch(MyException e){
                        System.out.println(e.getMessage());
                    }
                }
                game.BucketWorthy(in,position);
            }
            else if((position+1)%2==0){//EVEN
                System.out.print("You Landed on tile ");
                System.out.println(position+1);
                SoftToys st = game.getSoftToysArrayList().get(position).clone();
                System.out.print("You Won a ");
                System.out.print(st.getToyname());
                System.out.println(" Soft Toy");
                game.getPlayer().setBucket(st.getToyname());
            }
            game.getPlayer().setChances();
        }
        boolean done6 = false;
        while (!done6){
            System.out.println("Hit enter for your Fourth Hop");
            try{
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();
                game.checker(input);
                done6 = true;
            }
            catch(MyException ex){
                System.out.println(ex.getMessage());
            }
        }
        if(game.getChance() == 2){
            game.getPlayer().Roll_Random();
            int position = game.getPosition();
            if(position==20){
                System.out.println("You are too energetic and zoomed past all the Tiles.Muddy Puddle Splash!");
            }
            else if((position+1)%2!=0){//ODD
                System.out.print("You Landed on tile ");
                System.out.println(position+1);
                boolean done4 = false;
                String in = "";
                while (!done4){
                    System.out.println("Question Answer Round.integer Or string");
                    try{
                        Scanner sc = new Scanner(System.in);
                        in = sc.nextLine();
                        if(in.equals("integer")) {
                            done4 = true;
                        }
                        else if(in.equals("string")){
                            done4 = true;
                        }
                        if(!done4)
                        throw new MyException(" String Does not Match Exception ");
                    }
                    catch(MyException e){
                        System.out.println(e.getMessage());
                    }
                }
                game.BucketWorthy(in,position);
            }
            else if((position+1)%2==0){//EVEN
                System.out.print("You Landed on tile ");
                System.out.println(position+1);
                SoftToys st = game.getSoftToysArrayList().get(position).clone();
                System.out.print("You Won a ");
                System.out.print(st.getToyname());
                System.out.println(" Soft Toy");
                game.getPlayer().setBucket(st.getToyname());
            }
            game.getPlayer().setChances();
        }
        boolean done7 = false;
        while (!done7){
            System.out.println("Hit enter for your Fifth Hop");
            try{
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();
                game.checker(input);
                done7 = true;
            }
            catch(MyException ex){
                System.out.println(ex.getMessage());
            }
        }
        if(game.getChance() == 1){
            game.getPlayer().Roll_Random();
            int position = game.getPosition();
            if(position==20){
                System.out.println("You are too energetic and zoomed past all the Tiles.Muddy Puddle Splash!");
            }
            else if((position+1)%2!=0){//ODD
                System.out.print("You Landed on tile ");
                System.out.println(position+1);
                boolean done4 = false;
                String in = "";
                while (!done4){
                    System.out.println("Question Answer Round.integer Or string");
                    try{
                        Scanner sc = new Scanner(System.in);
                        in = sc.nextLine();
                        if(in.equals("integer")) {
                            done4 = true;
                        }
                        else if(in.equals("string")){
                            done4 = true;
                        }
                        if(!done4)
                        throw new MyException(" String Does not Match Exception ");
                    }
                    catch(MyException e){
                        System.out.println(e.getMessage());
                    }
                }
                game.BucketWorthy(in,position);
            }
            else if((position+1)%2==0){//EVEN
                System.out.print("You Landed on tile ");
                System.out.println(position+1);
                SoftToys st = game.getSoftToysArrayList().get(position).clone();
                System.out.print("You Won a ");
                System.out.print(st.getToyname());
                System.out.println(" Soft Toy");
                game.getPlayer().setBucket(st.getToyname());
            }
            game.getPlayer().setChances();
        }
        System.out.println("GAME OVER");
        System.out.println("List of Toys Won by Player :");
        System.out.println(game.getPlayer().getBucket());

    }
}
