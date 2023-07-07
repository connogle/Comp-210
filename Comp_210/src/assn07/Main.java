package assn07;


import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,String> passwordManager = new PasswordManager<>();

        // your code below
        boolean entered = false;
        while (!entered){
            System.out.println("Enter Master Password");
            entered = passwordManager.checkMasterPassword(scanner.nextLine());
        }
        boolean done = false;
        String input;
        while (!done) {
            input=scanner.nextLine();
            switch (input) {
                case "New password":
                    passwordManager.put(scanner.nextLine(), scanner.nextLine());
                    System.out.println("New password added");
                    break;
                case "Get password":
                    String site = passwordManager.get(scanner.nextLine());
                    if (site==null){
                        System.out.println("Account does not exist");
                    } else {
                        System.out.println(site);
                    }
                    break;
                case "Delete account":
                    String deleted = passwordManager.remove(scanner.nextLine());
                    if(deleted==null){
                        System.out.println("Account does not exist");
                    } else {
                        System.out.println("Account deleted");
                    }
                    break;
                case "Check duplicate password":
                    List toCheck = passwordManager.checkDuplicate(scanner.nextLine());
                    if (toCheck.size()==0){
                        System.out.println("No account uses that password");
                    } else {
                        System.out.println("Websites using that password:");
                        for (Object acc:toCheck){
                            System.out.println(acc);
                        }
                    }
                    break;
                case "Get accounts":
                    Set accSet = passwordManager.keySet();
                    System.out.println("Your accounts:");
                    for(Object thing:accSet){
                        System.out.println(thing);
                    }
                    break;
                case "Generate random password":
                    System.out.println(passwordManager.generateRandomPassword(scanner.nextInt()));
                    break;
                case "Exit":
                    done=true;
                    break;
                default:
                    System.out.println("Command not found");
                    break;
            }
        }







        /* passwordManager.put("webKinz", "password");
        passwordManager.put("yahop","password2");
        passwordManager.put("yahod","password2");
        passwordManager.put("yahof","password2");
        passwordManager.put("yahov","password2");
        System.out.println(passwordManager.get("webKinz"));
        System.out.println(passwordManager.size());
        System.out.println(passwordManager.keySet());
        System.out.println(passwordManager.remove("webKinz"));
        System.out.println(passwordManager.keySet());
        System.out.println(passwordManager.checkDuplicate("password2"));
        System.out.println(passwordManager.checkMasterPassword("password123"));
         */
    }



}