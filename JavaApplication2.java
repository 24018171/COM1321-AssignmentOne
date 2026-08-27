/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author MaokoTshepo
 * 24018171
 * Com!321 Assignment1
 */
import java.util.Scanner;

public class JavaApplication2 {



    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // keyboard reader
        System.out.println("BRIGHT FUTURE TECHNOLOGIES APPLICATION"); // title
        System.out.println("*********************************************"); // line
        
        while(true){ // keep running
            System.out.print("Enter (1) to launch menu or any other key to exit: ");
            String in = s.nextLine(); // read what user types
            
            if(!in.equals("1")){ // if not 1 then close
                Products.ExitApplication();
            }

            int choice = Products.DisplayMenu(); // show menu
            
            if(choice==1){
                Products.CaptureProduct(); // 1 = add product
            }
            else if(choice==2){
                Products.SearchProduct(); // 2 = search
            }
            else if(choice==3){
                Products.UpdateProduct(); // 3 = update
            }
            else if(choice==4){
                Products.DeleteProduct(); // 4 = delete
            }
            else if(choice==5){
                Products.PrintReport(); // 5 = report
            }
            else if(choice==6){
                Products.ExitApplication(); // 6 = exit
            }
            else{
                System.out.println("Invalid choice"); // wrong number
            }
        }
    }
}