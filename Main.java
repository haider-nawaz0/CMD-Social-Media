import java.util.Scanner;

public class Main {
  public static int entered_pin;

  public static void main(String[] args) {
    User[] user = new User[10];
    NewsFeed []feed = new NewsFeed[10];
    //Friend []friend = new Friend[10];
    Security []sec = new Security[10];

    Scanner s = new Scanner(System.in);
    
    System.out.println("\nWellcome to your Social Media");
    boolean flag =true;
    while (flag) {
      System.out.println("\n1. New Here?, Create your Account!");
      System.out.println("2. Wellcome Back?, Log In!");
      int main_choice = s.nextInt();
      while (!(main_choice == 1 || main_choice == 2)) {
        System.out.println("\nChoose between 1 and 2!");
        main_choice = s.nextInt();
      }
      if (main_choice == 1) {
        System.out.println("\nEnter the following details to make your account.");
        sec[User.COUNTUSERS] = Security.create_Security();
        sec[User.COUNTUSERS].setCode(sec);
        user[User.COUNTUSERS] = User.createNewUser();
      } else {
        System.out.println("\nEnter your Pin to login to you account.");
        String user_pin = s.next();
        entered_pin = Security.verify_user(sec, user_pin);
        if (entered_pin != -1) {
          System.out.println("\nWellcome '" + user[entered_pin].getName()+"' to your account.");
          System.out.println("\na. Update My Info.");
          System.out.println("b. Change my PIN.");
          System.out.println("c. Show all users.");
          System.out.println("d. Post something!.");
          System.out.println("e. Show News Feed.");
          System.out.println("f. Follow a Friend.");
          System.out.println("g. Sort all users by name.");
          System.out.println("h. Show my Profile.");
          System.out.println("i. Search for a User.");
          System.out.println("j. Log Out.");
          char user_input = s.next().charAt(0);
          
          while(!(user_input >= 'a' && user_input <='j')){
            System.out.println("Choose between a and j.");
            user_input = s.next().charAt(0);
          }
          switch (user_input) {
            case 'a': {
              user[entered_pin].update_profile();
              break;
            }
            case 'b': {
              sec[entered_pin].setCode(sec);
              System.out.println("Your PIN has been changed.");
              break;
            }
            case 'c':{
              User.print_all_users(user);
              break;
            }
            case 'd':{
              feed[entered_pin] = NewsFeed.createNew_feed();
              System.out.println("Your Post has been saved.");
              break;

            }
            case 'e':{
              System.out.println("\nNewsFeed");
              NewsFeed.print_all_posts(feed,user);
              break;
            }
            case 'f':{
              Friend.show_users(user);
              int choice_friend = s.nextInt();
              choice_friend = choice_friend-1;
             // System.out.println("Choice_friend"+ choice_friend);
              System.out.println("SOMETHING WENT WRONG!!!!");
              //user[entered_pin].addFriends(user[choice_friend]);
              break;
            }
            case 'g':{
              User.sortByNames(user);
              User.print_all_users(user);
              
              break;
            }
            case 'h':{
              System.out.println("\nWellcome '"+user[entered_pin].getName()+"' to your profile account.");
              user[entered_pin].display_profile();
              user[entered_pin].show_friends();              

              break;
            }
            case 'i':{
              user[entered_pin].search_User(user);
              break;
            }
            case 'j':{
              System.out.println("\nProgram terminated.");
                flag = false;
              break;
            }

          }

        }
        else{
          System.out.println("Incorrect PIN.");
        }

      }
    }

  }
}
