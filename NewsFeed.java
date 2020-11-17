import java.util.Scanner;
public class NewsFeed {
    Scanner s = new Scanner(System.in);
    private String post;
    private static int countFeed=0;
    

    public NewsFeed(){
       setPost();
       countFeed++;

    }
   
    public void setPost(){
        System.out.println("\nEnter your Post:");
        String msg = s.nextLine();
        this.post = msg;
    }
    public String getPost(){
        return post;
    }
    public static NewsFeed createNew_feed(){
        
        return new NewsFeed();
    }

    public void print_post(User[] user){
        
            System.out.println("\nPost from "+user[Main.entered_pin].getName()+"  : " + getPost());
    }
    public static void print_all_posts(NewsFeed []feed, User[] user){
        if(countFeed <=0){  
            System.out.println("\nNo Posts to show, add some posts and then try again...");
            return;
        }
        for(int i=0; i<User.COUNTUSERS; i++){
            feed[i].print_post(user);
        }
    }

}
