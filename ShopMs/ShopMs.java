/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;


/**
 *
 * @author muhammadammar
 */

import java.sql.*;
import java.lang.*;
import java.util.Date;
import java.util.Scanner;

class Outlet{
 public  String address;
 public int id;
    
 public Outlet (String address)
    {
        this.address= address;
    }
   public void addOutlet(Outlet outletToAdd)
   {
   stmt.executeQuery("insert {1}", outletToAdd.address +"into outlet" + ";");
     
   }
   public Outlet getOutlet()
  { 
      return ResultSet rs=stmt.executeQuery("select* from outlet " + ";");
     
  }

}
class Expense{
public String expenseDetail;
public double expensePrice;
public Date dateToday = new Date();
 
public Expense (String expenseDetail, double expensePrice, Date dateToday)
    {
    this.expenseDetail= expenseDetail;
    this.expensePrice= expensePrice;
    this.dateToday=dateToday;
    
    }
   public void addExpense(Expense ExpenseToAdd,double expensePrice,Date dateToday,int outletId)
   { 

   stmt.executeQuery("insert {1},{2},{3},{4}",ExpenseToAdd.expenseDetail,ExpenseToAdd.expensePrice,dateToday,outletId  +"into expense " + ";");
   
   }
   public Expense getExpense(int outletId)
   { 
      return ResultSet rs=stmt.executeQuery("select* from expense where outletid ={1}",outletId + ";");
     
   }
}
class SaleReport{
public double totalSale,totalPurchase,monthlyExpenses,totalExpenses,investment,stocks,netIncome,profitRatio,account;
public int id,outletId;
public Date dateToday= new Date();

public SaleReport(double investment,double account,int outletId,Date dateToday)
{
   this.investment=investment;
   this.account=account;
   this.outletId=outletId; 
   this.dateToday = dateToday;
}


public double totalSale(){
   // for(int i in Orders)
totalSale+= ResultSet rs=stmt.executeQuery("select ordertotal From Orders where date={1},outletid={2}",dateToday,outletId + ";");
        return totalSale;
   
}
public double totalPurchase(){
   // for(int i in inventory)
 ResultSet rs=stmt.executeQuery("select purchasingprice ,quantity From inventory  where date={1},outletid={2}",dateToday,outletId + ";");
totalPurchase+=purchasingprice *quantity;
    return totalPurchase;

}
public double monthlyExpenses(){
   // for(int i in Expense)
 monthlyExpense+=ResultSet rs=stmt.executeQuery("select price From Expense  where date={1},outletid={2}",dateToday,outletId + ";");
    return monthlyExpenses;

}
public double totalExpenses(){
   
    return totalExpenses = monthlyExpenses + totalPurchase;

}
public double netIncome(){
    return netIncome =totalSale - totalExpenses;
}
public double profitRatio(){
return profitRatio =netIncome*100/totalExpenses;

}
public double stocks(){
return stocks =stocks+totalPurchase-totalSale+totalSale*0.08;

}
public void addMonthlyReport()
{
    //insert dateToday,tatalSale,totalPurchase,monthlyExpenses,totalExpenses,investment,stocks,netincome,profitRatio,account,outletid;
 ResultSet rs=stmt.executeQuery("insert {1},{2},{3},{4},{5},{6},{7},{8},{9},{10},{11}",dateToday,totalSale,totalPurchase,monthlyExpenses,totalExpenses,investment,stocks,netIncome,profitRatio,account,outletId
  +"into SalesReport " + ";");
  
}
public SaleReport getSaleReport(int outletId)
   {
return ResultSet rs=stmt.executeQuery(" select* from SaleReprt  where date={1},outletid={2}",dateToday,outletId + ";");
   
   }
}

class Inventory {
public int outletId;
public Date dateToday = new Date();

    public void addInventory(Item itemToAdd,int quantity,double purchasingPrice,double sallingPrice,Date dateToday, int outletId) {
     
 ResultSet rs=stmt.executeQuery("insert {1},{2},{3},{4},{5},{6}",itemToAdd,quantity,purchasingPrice,sallingPrice,dateToday,outletId 
  +" into  inventory   " + ";");

    }

    public String getInventory(int outletId) {
     return ResultSet rs=stmt.executeQuery("  select * from inventory  where outletid={1}",outletId + ";");
      
                  
    }
    public void addOrder(Order orderToAdd) {
    //insert oderToAdd  in ODER TABLE 
        // to be asked
    }
    public String getOrders() {
    
     return ResultSet rs=stmt.executeQuery("select * from Oders  " + ";");          
    }
 public void goodTransfer( int itemId,int quantity,int newOutletId) {
    this.outletId=newOutletId;
     
    }
    
}

class Order {

    String customerName;
    double totalAmount = 0.0; 
public Date dateToday;
    
//    Order(String name) {
//        this.customerName = name;
//
//    }

    public void addItem(String customerName,Item itemToAdd,double totalAmount, int quantity, Date dateToday,int outletId) {
    //insert query to add item in ODER TABLE to be asked
this.totalAmount = itemToAdd.purchasingPrice*quantity;
 ResultSet rs=stmt.executeQuery("insert {1},{2},{3},{4},{5},{6}",customerName,itemToAdd, totalAmount, quantity, dateToday, outletId
  +" into   orders " + ";");

        
    }

    public String toString(int outletKey) {
return ResultSet rs=stmt.executeQuery(" select *from Orders  where outletid={1},Customername={2}",outletId,customerName + ";");
   
         
    }
}

abstract class Item {

    public String name; 
    public double purchasingPrice,sallingPrice; 
    public int quantity; 

    public Item(String name,double purchasingPrice,double sallingPrice , int quantity) {
        this.name = name;
        this.purchasingPrice = purchasingPrice;
        this.sallingPrice = sallingPrice;
        this.quantity = quantity;
    }

        public String toString() {
        return "Name: " + this.name + ", purchasingPrice: " + this.purchasingPrice + ", sallingPrice: " + this.sallingPrice + ", Quantity: " + this.quantity;
    }
}
abstract class Diaper extends Item {

    String size = "";

    public Diaper(String name, double purchasingPrice,double sallingPrice , int quantity, String size) {
        super(name,  purchasingPrice, sallingPrice , quantity);
        this.size = size;
    }
    public String toString() {
        return super.toString() + ", size:" + this.size;
    }
}
    class  BabyDiaper extends Diaper {

       public BabyDiaper(String name,double purchasingPrice,double sallingPrice, int quantity, String size) {
        super(name, purchasingPrice,sallingPrice, quantity,size);
    }
    }
class  AdultDiaper extends Diaper {

    public AdultDiaper(String name,double purchasingPrice,double sallingPrice, int quantity, String size) {
        super(name, purchasingPrice,sallingPrice, quantity,size);
    }
    }
class  Pad extends Diaper {
    public Pad(String name, double purchasingPrice,double sallingPrice, int quantity, String size) {
        super(name, purchasingPrice,sallingPrice, quantity,size);
    }
    }

abstract class PlasticItem extends Item {

    public PlasticItem(String name, double purchasingPrice,double sallingPrice, int quantity) 
    {
        super(name, purchasingPrice,sallingPrice, quantity);
        
    }
    public String toString() {
        return super.toString(); 
    }
}
class Tissue extends PlasticItem {

    public Tissue(String name, double purchasingPrice,double sallingPrice, int quantity) {
        super(name, purchasingPrice,sallingPrice, quantity);
    }
 }
class Shoper extends PlasticItem {

    public Shoper(String name,double purchasingPrice,double sallingPrice, int quantity) {
        super(name, purchasingPrice,sallingPrice, quantity);
    }
 }
class Disposible extends PlasticItem {

    public Disposible(String name, double purchasingPrice,double sallingPrice, int quantity) {
        super(name, purchasingPrice,sallingPrice, quantity);
    }
 }
abstract class BabyCosmetic extends Item {

    public BabyCosmetic(String name, double purchasingPrice,double sallingPrice, int quantity) {
        super(name, purchasingPrice, sallingPrice,quantity);
    }

    /**
     * @overrides toString method of parent
     * @return string with extra detail about size
     */
    public String toString() {
        return super.toString();    }
}
 class Wipe extends BabyCosmetic {

    public Wipe(String name, double purchasingPrice,double sallingPrice, int quantity) {
        super(name, purchasingPrice,sallingPrice, quantity);
    }
 }
 class Milk extends BabyCosmetic {
double weight;
    public Milk(String name, double purchasingPrice,double sallingPrice, int quantity,double weight) {
        super(name, purchasingPrice,sallingPrice, quantity);
           
        this.weight = weight;
    }
        public String toString() {
        return super.toString() + ", weight:" + this.weight;
    }

 }

public class JavaApplication1 {

    public static void main(String[] args) {
        
     Scanner in = new Scanner(System.in);
        String address,name,decision ,expenseDetail,size ;  
       int index, quantity , option,number,outletId;
    double purchasingPrice ,sallingPrice,weight,expensePrice,investment, account;  
  Date dateToday= new Date();
    System.out.println("Outlet address");
              address =in.next();
  // first object creation to be asked
              Outlet outlet1 = new Outlet(address);
              outlet1.addOutlet(outlet1);
              Inventory inventoryOutlet1 = new Inventory();
Order Order1 = new Order();

    System.out.println("--------------");
         System.out.println("Welcome To Diaper zone");
         System.out.println(" make your Seclection");
         System.out.println("1 Add Oulet");
       System.out.println("2 select outlet");
       number =in.nextInt();
    
      switch (number){
          case 1:
          { 
             System.out.println("adress");
              address =in.next();
           
              Outlet outlet2 = new Outlet(address);
    Inventory inventoryOutlet2 = new Inventory();
   
              outlet2.addOutlet(outlet2);
              break; 
          }      
   case 2:{
             System.out.println("outlet list");
          outlet1.getOutlet();
             System.out.println("select the outlet by number");
       outletId =in.nextInt();       
do{
    System.out.println("--------------");
         System.out.println("Welcome To "+ address + "Branch Diperzone");
         System.out.println(" make your Seclection");
         System.out.println("1 Add inventory");
       System.out.println("2 Add Order");
        System.out.println("3 show inventory");
         System.out.println("4 show order");
     System.out.println("5 show Details");
         System.out.println("6 Expense detail");
       System.out.println("7 Monthly Sale report ");
 
     System.out.println("8 exit system");
       number =in.nextInt();
    
      switch (number){
          case 1:
          {
     do{
          System.out.println("you can add the following");
          System.out.println("1 Baby Diaper ");
       System.out.println("2 Adult Diaper ");
        System.out.println("3 Pad");
          System.out.println("4 Tissue ");
       System.out.println("5 Shopper ");
        System.out.println("6 Disposible item");
          System.out.println("7Wipe ");
       System.out.println("8  Milk ");
       
       option =in.nextInt();
      
       switch (option){
          case 1:{    
          System.out.println("Baby Diaper");
          System.out.println("Entre Name");
         name =in.next();
         System.out.println("Entre Purchasing Price");
         purchasingPrice =in.nextDouble();
         System.out.println("Entre Salling Price");
         sallingPrice =in.nextDouble();
         
         System.out.println("Entre QUANTITY");
         quantity =in.nextInt(); 
         System.out.println("Entre Size");
         size =in.next();

          BabyDiaper BabyDiaper1 = new BabyDiaper(name,purchasingPrice,sallingPrice,quantity,size);
       inventoryOutlet1.addInventory(BabyDiaper1,quantity,purchasingPrice,sallingPrice,dateToday, outletId);
          break;
      }      
   case 2:{
            System.out.println("Adult Diaper");
          System.out.println("Entre Name");
         name =in.next();
         System.out.println("Entre Purchasing Price");
         purchasingPrice =in.nextDouble();
         System.out.println("Entre Salling Price");
         sallingPrice =in.nextDouble();
         System.out.println("Entre QUANTITY");
         quantity =in.nextInt(); 
         System.out.println("Entre Size");
         size =in.next();
          AdultDiaper AdultDiaper1 = new AdultDiaper(name,purchasingPrice,sallingPrice,quantity,size);
       inventoryOutlet1.addInventory(AdultDiaper1,quantity,purchasingPrice,sallingPrice,dateToday, outletId);
          break;   
   }      
   case 3:{
           System.out.println("Pad");
          System.out.println("Entre Name");
         name =in.next();
         System.out.println("Entre Purchasing Price");
         purchasingPrice =in.nextDouble();
         System.out.println("Entre Salling Price");
         sallingPrice =in.nextDouble();
         System.out.println("Entre QUANTITY");
         quantity =in.nextInt(); 
         System.out.println("Entre Size");
         size =in.next();

          Pad Pad1 = new Pad(name,purchasingPrice,sallingPrice,quantity,size);
         inventoryOutlet1.addInventory(Pad1,quantity,purchasingPrice,sallingPrice,dateToday, outletId);
          
          break;   
   }
   case 4:{
           System.out.println("Tissue");
          System.out.println("Entre Name");
         name =in.next();
         System.out.println("Entre Purchasing Price");
         purchasingPrice =in.nextDouble();
         System.out.println("Entre Salling Price");
         sallingPrice =in.nextDouble();
         System.out.println("Entre QUANTITY");
         quantity =in.nextInt(); 
         
          Tissue Tissue1 = new Tissue(name,purchasingPrice,sallingPrice,quantity);
       inventoryOutlet1.addInventory(Tissue1,quantity,purchasingPrice,sallingPrice,dateToday, outletId);
       
          break;   
   }
    case 5:{
          System.out.println("Shopper");
          System.out.println("Entre Name");
         name =in.next();
         System.out.println("Entre Purchasing Price");
         purchasingPrice =in.nextDouble();
         System.out.println("Entre Salling Price");
         sallingPrice =in.nextDouble();
         System.out.println("Entre QUANTITY");
         quantity =in.nextInt(); 
         
          Shoper Shoper1 = new Shoper(name,purchasingPrice,sallingPrice,quantity);
        inventoryOutlet1.addInventory(Shoper1,quantity,purchasingPrice,sallingPrice,dateToday, outletId);
       
          break;  
   }
     case 6:{
           System.out.println("Disposible Item");
          System.out.println("Entre Name");
         name =in.next();
         System.out.println("Entre Purchasing Price");
         purchasingPrice =in.nextDouble();
         System.out.println("Entre Salling Price");
         sallingPrice =in.nextDouble();
         System.out.println("Entre QUANTITY");
         quantity =in.nextInt(); 
         System.out.println("Entre Size");
         size =in.next();

          Disposible Disposible1 = new Disposible(name,purchasingPrice,sallingPrice,quantity);
        inventoryOutlet1.addInventory(Disposible1,quantity,purchasingPrice,sallingPrice,dateToday, outletId);
       
          break;   
   }
      case 7:{
           System.out.println("Wipe");
          System.out.println("Entre Name");
         name =in.next();
         System.out.println("Entre Purchasing Price");
         purchasingPrice =in.nextDouble();
         System.out.println("Entre Salling Price");
         sallingPrice =in.nextDouble();
         System.out.println("Entre QUANTITY");
         quantity =in.nextInt(); 
         
          Wipe Wipe1 = new Wipe(name,purchasingPrice,sallingPrice,quantity);
        inventoryOutlet1.addInventory(Wipe1,quantity,purchasingPrice,sallingPrice,dateToday, outletId);
       break;   
   
             
   }
       case 8:{
           System.out.println("Milk");
          System.out.println("Entre Name");
         name =in.next();
         System.out.println("Entre Purchasing Price");
         purchasingPrice =in.nextDouble();
         System.out.println("Entre Salling Price");
         sallingPrice =in.nextDouble();
         System.out.println("Entre QUANTITY");
         quantity =in.nextInt(); 
         System.out.println("Entre Weight");
         weight =in.nextDouble();

          Milk Milk1 = new Milk(name,purchasingPrice,sallingPrice,quantity,weight);
        inventoryOutlet1.addInventory(Milk1,quantity,purchasingPrice,sallingPrice,dateToday, outletId);
       
          break;   
   }
   }
     System.out.println("Do you want to add more inventory yes or no");
          decision = in.next();
      decision = decision.toUpperCase();
      
      }while("YES".equals(decision));
          break;
          }
     case 2:{
   System.out.println("Entre your name");
         name =in.next();
  Order1.customerName=name;        
        do{
             System.out.println("you can add order from this");
        inventoryOutlet1.getInventory(outletId);
           
             System.out.println("Entre Number");
         index =in.nextInt();
           System.out.println("Entre QUANTITY");
         quantity =in.nextInt();
         Order1.addItem(inventoryOutlet1.getInventory[index], outletId);//to be asked
//insert into  orders where outletid =outletId to be asked       

          System.out.println("Do you want to add more oder yes or no");
          decision = in.next();
      decision = decision.toUpperCase();
     }while("YES".equals(decision));
        break;}
     case 3:{
       inventoryOutlet1.getInventory(outletId); 
       break;
     }
     case 4:
     {   
        Order1.toString(outletId);
                break;
     }case 5:
   {
       inventoryOutlet1.getInventory(outletId); 
       Order1.toString(outletId);
       
       break;}
case 6:
     System.out.println("1 for adding an expense ");
     System.out.println("2 for expense histroy ");
     option =in.nextInt();
    
    switch (option){
        case 1:   { 
             System.out.println("expense Details");
              expenseDetail =in.next();
           System.out.println("expense price");
              expensePrice =in.nextDouble();
           dateToday = new Date();
           
              Expense expense1 = new Expense(expenseDetail, expensePrice,dateToday);
              expense1.addExpense(expense1, expensePrice,dateToday, outletId);
 
              break; 
          }
        case 2:{
     System.out.println("Expense list");
   System.out.println(expense1.getExpense(outletId));         
        break;
        }
      }
   case 7:{
      System.out.println("1 for adding an SaleReport ");
     System.out.println("2 for Display Sale Report");
     option =in.nextInt();
    
    switch (option){
        case 1:   { 
             System.out.println("Investment");
              investment =in.nextDouble();
           System.out.println("account");
              account =in.nextDouble();
           dateToday = new Date();
           
             SaleReport saleReport1 = new SaleReport(investment, account,outletId, dateToday);
        saleReport1.totalSale();
        saleReport1.totalPurchase();
        saleReport1.monthlyExpenses();
        saleReport1.totalExpenses();
        saleReport1.stocks();
        saleReport1.netIncome();
        saleReport1.profitRatio();
            saleReport1.addMonthlyReport();
       
              break; 
          
        }
        case 2:{
     System.out.println("Monthly Sale Report ");
   System.out.println( saleReport1.getSaleReport(outletId));         
        break;
        }
      }
   }
     default:
   {  
inventoryOutlet1.getInventory(outletId); 
       Order1.toString(outletId);
            
            System.out.println("Allah hafiz");
                break;
                
                
 }
      
}
              
}while(number<=7);      
        
}
        
      }  

    }
}
