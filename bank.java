/*
Created by Joseph Kinahan
    05/12/16
*/

import java.util.Scanner;
import java.text.DecimalFormat;//i used this as a means to round off to 2 decimal places in my average double


public class bank {

    private static DecimalFormat DF = new DecimalFormat(".##");
    
    public static void main (String[]args){
        int noOfAccounts=0;

        Scanner scan = new Scanner(System.in);
        System.out.println("\n-Between 1 & 20----How many accounts are in the bank?");
        
        noOfAccounts= scan.nextInt();
        
        do{// iv used a do while loop to rerun the error message and reprompt whenever illegal entries are made
            if(noOfAccounts<1||noOfAccounts>20){
                System.out.println("ERROR. That cant be right. Try again");
                System.out.println("-Between 1 & 20----How many accounts are there?");
                noOfAccounts=scan.nextInt();
            }
            
        } while (noOfAccounts<1||noOfAccounts>20);
        
        System.out.println("The number of accounts is "+noOfAccounts+". Please enter account details now\n");
        
        
        String [] accountName = new String[noOfAccounts];
        int [] accNo= new int[noOfAccounts];
        double [] balance = new double[noOfAccounts];
        
        
    for(int i=0; i<noOfAccounts;i++){
        Scanner scan2= new Scanner(System.in);
        System.out.println("What is the name of the holder of account number BOI-"+(i+1)+" ?");
        accountName[i] = scan2.nextLine();
        System.out.println("What is the balance of "+accountName[i]);
        double temp= scan2.nextDouble();
     
        do {
               if(temp>=0.00){
            balance[i]= temp;
            
        }
           else if(temp<0.00) {
            System.out.println("Sorry it cant be a negative balance!");
            System.out.println("Please enter a positive number");
            balance[i]= scan2.nextDouble();
        } 
        } while (balance[i]<0.00);
        
        
        accNo[i]= i+1;
       
    }
        System.out.println("\nTHE BANK DETAILS OF BOI");
        System.out.println("-----------------------");
    for (int j=0; j<noOfAccounts;j++){
        System.out.println("BOI-"+accNo[j]+" - Name: "+ accountName[j]+ "\t -Balance: "+"$"+ balance[j]);
    }   
        System.out.println("");
        System.out.println("#####################################################");
        System.out.println("#               Choose from options                 #");
        System.out.println("# 1.Display average account balance                 #");
        System.out.println("# 2.Display the highest account balance             #");
        System.out.println("# 3.Display the lowest account balance              #");
        System.out.println("# 4.Sort and Display balances in descending order   #");
        System.out.println("# 5.Search for an individual account holder by name #");
        System.out.println("#####################################################");
        
        int tick=0;//ive made this so that the user can ask it several questions in turn, but with an end
        while(tick<10){
        System.out.println("Select number from above list:");
        Scanner scan3= new Scanner(System.in);
        int ans = scan3.nextInt();
        
            //ive used a while loop to catch out of bounds replies and halt any forward motion until answer is within sought range....
            while(ans<1||ans>5){
                System.out.println("ERROR. Please select from list");
                ans= scan3.nextInt();
            }

            switch(ans){
                case 1: avg(balance);  
                    break;
                case 2:System.out.println("The highest balance is $"+highest(balance));
                    break;
                case 3:System.out.println("The lowest balance is $"+lowest(balance));
                    break;
                case 4:descend(balance);
                    break;
                case 5: search(accountName, balance, accNo);
                    break;
            } 
             tick++;
            System.out.println("");
         }
}
    
    public static void avg(double[] bal) {
        double total=0;
        for(int i=0; i<bal.length; i++){
            total+= bal[i];
        }
        double average= total/bal.length;
        System.out.print("The average balance is ");
        //System.out.printf("$"+DF.format(average)+"\n");
        System.out.print(average);
        
    }
    
    
    public static double highest(double[] bal){
        double high=0;
        for(int i=0; i<bal.length; i++){
            if(bal[i]>high) {
                high=bal[i];
            }
        }
        return high;
    }  
    
      public static double lowest(double[] bal){
        double low=bal[0];
        for(int i=1; i<bal.length; i++){
                if(low>bal[i]){
                    low=bal[i];
                }
            }
          return low;
        }
    
    public static void descend(double[] bal){//im using an inner and outer loop to compare the elements in pairs, each time swapping the places using a temp variable if the rightside one is larger...this will result in sorted array from highest down....
        double temp;
        for(int i=0; i<bal.length-1; i++){
            for(int j=1;j<bal.length;j++){
                if(bal[j]>bal[j-1]){
                    temp=bal[j-1];
                    bal[j-1]=bal[j];
                    bal[j]=temp;
                }
            }
        }
        System.out.println("The array in descending order is : ");
        for(int p=0; p<bal.length-1; p++){
            System.out.print(bal[p]+"  --  ");
        }
        System.out.print(" "+bal[bal.length-1]);//ive separated the last index to ensure tidy presentation- with no hanging -- .......
        System.out.println("");
    }
    
    public static void search(String[] names,double[] bals, int[] nos){
        Scanner scan10 = new Scanner(System.in);
        System.out.println("Enter the first and last name of the user whose account you require:");
        String input= scan10.nextLine();
        for(int i =0; i<names.length;i++){
            if(names[i].equals(input)){
                System.out.println("Your search has resulted in user "+names[i]+", account no: BOI-"+nos[i]+" and their balance is $"+bals[i]);
                break;
            }
        }
    }
    
    
    
    
        
    }

    
    
