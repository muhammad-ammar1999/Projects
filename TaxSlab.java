/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationtask;

import java.util.Scanner;

/**
 *
 * @author Ammar
 */
public class JavaApplicationTask {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
      
     Scanner sc = new Scanner(System.in);
     double UserInput = sc.nextDouble();
     double UserTax = TaxSlab(UserInput); 
     System.out.println(UserTax);
     
     
    }
    public static double TaxSlab(double UserInput)
    {double Tax=0,UserTax=0;
       if( UserInput<=250000)
           return  UserInput;
       else if ( UserInput>250000 && UserInput<500000)
       { Tax = UserInput*5/100;
           return  UserTax =UserInput-Tax;
       }
        else if ( UserInput>50000 && UserInput<750000)
       { Tax = UserInput*10/100;
           return  UserTax =UserInput-Tax;
       }
       else if ( UserInput>750000 && UserInput<1000000)
       { Tax = UserInput*15/100;
           return  UserTax =UserInput-Tax;
       }
       else if ( UserInput>1000000 && UserInput<1250000)
       { Tax = UserInput*20/100;
           return  UserTax =UserInput-Tax;
       }
       else if ( UserInput>1250000 && UserInput<1500000)
       { Tax = UserInput*25/100;
           return  UserTax =UserInput-Tax;
       }
       else 
       { Tax = UserInput*30/100;
           return  UserTax =UserInput-Tax;
       }
 }
}

