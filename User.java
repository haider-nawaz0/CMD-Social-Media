import java.util.Scanner;

public class User {

    Scanner s = new Scanner(System.in);
    private  String name, adress, phone;
    private String age;
    private Friend[] friends;
    private int numberOfFriends;
    
    public static int COUNTUSERS = 0;

    // constructer
    public User() {
        this.friends = new Friend[10];
        this.numberOfFriends =0;
        setName(name);
        setPhone(phone);
        setAdress(adress);
        setAge(age);
        System.out.println("\nYour account has been created succfully.");
    }
    public void  addFriends(Object obj){
            Friend friends = (Friend)obj;
            this.friends[this.numberOfFriends] = friends;
            this.numberOfFriends++;
            System.out.println("\nFriend added.");
    }

    public void show_friends(){
        System.out.println("\nYour Friends.");
        for(int i=0; i<this.numberOfFriends; i++){
            System.out.print(friends[i]);
        }
    }
    // getters and setters
    public int getCOUNTUSERS() {
        return COUNTUSERS;
    }

    public void setName(String name) {
        String name2;
        System.out.println("\nEnter your first Name?");
        name = s.next();
        System.out.println("\nEnter your second Name?");
        name2 = s.next();
        name = name + " " + name2;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAdress(String adress) {
        System.out.println("\nEnter your city(without space)?");
        adress = s.next();
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

    public void setPhone(String phone) {
        System.out.println("\nEnter your Mobile No(Without spaces ):");
        phone = s.next();
        while(phone.length() != 11){
            System.out.println("\nYour Phone length must be 11.");
            phone = s.next();
        }
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setAge(String age) {
        System.out.println("\nEnter your age?");
        age = s.next();
        while(Integer.parseInt(age) <= 0){
            System.out.println("\nEnter the valid age.");
            age = s.next();
        }
        this.age = age;
    }

    public String getAge() {
        return age;
    }

   
    // ToString method
    public String toString() {
        return "\nName: " + getName() + ", " + "Age: " + getAge() + ", " + "Phone: " + getPhone() + ", " + "City: "
                + getAdress();
    }
    // display profile
    public void display_profile() {
        System.out.println("\nUser Profile: ");
        System.out.println("\nName: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Phone No: " + getPhone());
        System.out.println("Adress: " + getAdress());
        
    }
    
    public static User createNewUser(){
        COUNTUSERS++;
        return new User();
    }
   
    // update-info
    public void update_profile() {
        System.out.println("\nEnter a valid input from the following.");
        System.out.println("\n1. Change your Name");
        System.out.println("2. Change your Phone No");
        System.out.println("3. Change your Adress ");
        System.out.println("4. Change your Age");
        int user_input = s.nextInt();
        while (!(user_input >= 1 && user_input <= 4)) {
            System.out.println("Enter between 1 and 4!");
            user_input = s.nextInt();
        }
        switch (user_input) {
            case 1: {
                setName(name);
                System.out.println("\nName updated successfully!");
                break;
            }
            case 2: {
                setPhone(phone);
                System.out.println("\nPhone No updated successfully!");
                break;
            }
            case 3: {
                setAdress(adress);
                System.out.println("\nCity  updated successfully!");
                break;

            }
            case 4: {
                setAge(age);
                System.out.println("\nAge updated successfully!");
                break;
            }
        }

    }
    public  void search_User(User[] user){
        boolean flag = true;
        System.out.println("\nSearch for a User by Name: ");
        System.out.println("\nFirst Name: ");
        String name1 = s.next();
        System.out.println("Second Name: ");
        String name2 = s.next();

        String name_key = name1 +" "+ name2;
        System.out.println("Name Key: " + name_key);

        for(int i=0; i<COUNTUSERS; i++){
            if(user[i].getName().equalsIgnoreCase(name_key))
            {
                flag = false;
                System.out.println("\nWe have found a user by that name, here is its profile: ");
                user[i].display_profile();
                return;
            }
        }
        if(flag == true){
            System.out.println("\noops, There is no such user by that name!");
        }
    }
    public static void sortByNames(User[] user){
        for(int i=0; i<COUNTUSERS; i++){
            int index = i;
            for(int j=i+1; j<COUNTUSERS; j++){
                if(user[j].getName().compareTo(user[index].getName()) < 0)
                {
                    index =j;
                }
            }
            User temp = user[index];
            user[index] = user[i];
            user[i] = temp;
        }

    }
    public static void print_all_users(User[] user){
        System.out.println("\nHere is the info of all the users.");
        for(int i=0; i<COUNTUSERS; i++){
            user[i].display_profile();
        }
    }
}