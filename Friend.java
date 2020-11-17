public class Friend
{
    int countFriends = 0;
    public Friend(){
        

    }

   
 

    public static void show_users(User [] user){
        System.out.println("\nChoose from the following.");
        for(int i=0; i<User.COUNTUSERS; i++){
            if(!(user[i].getName().equals(user[Main.entered_pin].getName()))){
                System.out.println((i+1)+"."+user[i].getName());
            }
           
        }
    }
    public String toString(){
         return "Total number of friends are :" + countFriends;
    }
    
}