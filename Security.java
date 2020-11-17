import java.util.Scanner;
public class Security {
    Scanner scan = new Scanner(System.in);
    private String code;
 
    public void setCode(Security[] sec){
        boolean flag = false;
        System.out.println("\nChoose a PIN for your account.");
        String pin = scan.next();
        while(!(pin.length() >= 4)){
            System.out.println("\nYour must be at least 4 digit long.");
            pin = scan.next();
        }
         for(int i=0; i<User.COUNTUSERS; i++){
             if(sec[i].getCode().equals(pin)){
                 flag = true;
             }
        }
            while(flag != false){ 
                System.out.println("\nSorry, this pin is already taken, try another one...");
                pin = scan.next();
                for(int i=0; i<User.COUNTUSERS; i++){
                    if(sec[i].getCode().equals(pin)){
                        flag = true;
                        break;
                    }
                    else flag = false;
                }
                
               
            }
        this.code = pin;
    }
    public String getCode(){
        return this.code;
    }

    public static int verify_user(Security[] sec, String key){
        for(int i=0; i<User.COUNTUSERS; i++){
            if(sec[i].getCode().equals(key))
            {
                return i;
            }
        }
        return -1;
    }
    public static Security create_Security(){
        return new Security();
    }
    
}
