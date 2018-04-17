package com.company;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static int ID=1;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Library thisLibrary = new Library();
        boolean done = false;
        String exit;


        do {

            if (thisLibrary.getBooks().size() < 1) {
                System.out.println("There are no books in this library.Please add one");
                addBook(thisLibrary);

            } else {
                System.out.println(showMenu());
                getInput(scan, thisLibrary);
            }


        } while (!done);

    }


       public static String showMenu() {

        StringBuilder builder=new StringBuilder();
        builder.append("1. List all books\n");
        builder.append("2. Add a book\n");
        builder.append("3. Borrow a book\n");
        return builder.toString();

     }


         public static void getInput(Scanner scan, Library thisLibrary) {
         switch(scan.nextInt()){

             case 1:
                System.out.println("Lists Books");
                System.out.println(listBooks(thisLibrary));
                break;

            case 2:
               System.out.println("Add a Book");
               addBook(thisLibrary);
               break;

               case 3:

        System.out.println("Borrow a Book");
        borrowBook(scan,thisLibrary);
        break;

           case 4:
        System.out.println("Return a Book");

            case 5:
        System.exit(0);
        break;


}
    }

    public static Book newBook(int id) {
        Scanner keyboard = new Scanner(System.in);
        String title, author, yearPub, isbn;
        System.out.println("Enter Title:");
        title = keyboard.nextLine();


        System.out.println("Enter author:");
        author = keyboard.nextLine();

        System.out.println("Enter Year Of Publication:");
        yearPub = keyboard.nextLine();

        System.out.println("Enter ISBN Number:");
        isbn = keyboard.nextLine();


        Book b = new Book(title, author, isbn, yearPub);
        b.setId(id);

        return b;

    }

    public static String listBooks(Library library) {

        StringBuilder builder = new StringBuilder();
        for (Book eachBook : library.getBooks()) {

            builder.append("Book:" + eachBook.getId() + "\n");
            builder.append("Title:" + eachBook.getTitle() + "\n");
            builder.append("Author:" + eachBook.getAuthor() + "\n");
            builder.append("Year Of Publication:" + eachBook.getYearofpublication() + "\n");
            builder.append("ISBN:" + eachBook.getISBNnumber() + "\n");


        }
        return builder.toString();

    }

public static String listBooks(boolean available, Library library) {

     StringBuilder builder=new StringBuilder();
     for(Book eachBook:library.getBooks()) {
if(eachBook.isBorrowed()==!available) {

    builder.append("Book ID:"+eachBook.getId()+"\n");
    builder.append("Tilte:"+eachBook.getTitle()+"\n");
    builder.append("Author:"+eachBook.getAuthor()+"\n");
    builder.append("Year Of Publication:"+eachBook.getYearofpublication()+"\n");
    builder.append("Status:"+(eachBook.isBorrowed()?"Borrowed":"Available")+"\n");
    builder.append("ISBN:"+eachBook.getISBNnumber()+"\n\n");
}
     }
     return builder.toString();
}

   public static void addBook(Library thisLibrary) {

     Scanner sc=new Scanner(System.in);
     boolean done=false;
     String yesno="";


     do {
      thisLibrary.addBook(newBook(ID));

     System.out.println("Would you like to enter another Book?");
         yesno=sc.nextLine();
         if(yesno.equalsIgnoreCase("n")||yesno.equalsIgnoreCase("no")) {

       done=true;
         }else {

       done=false;
         }
         ID++;

     }while(!done);

}

       public static void borrowBook(Scanner scan,Library thisLibrary){

    System.out.println("This is the list of available books:");
    System.out.println(listBooks(true,thisLibrary));
    System.out.println("Enter a book ID");
    long id=scan.nextInt();
    scan.nextLine();
    Book found=new Book();

    for(Book toFind:thisLibrary.getBooks()){
       if(toFind.getId()==id){
           found=toFind;
           System.out.println("ID:"+toFind.getId()+"Title:"+toFind.getTitle()+"has been found \n");
       }
    }

    if(!found.isBorrowed())
    found.setBorrowed(true);

    else{
    System.out.println("This book has already been borrowed");
}

       thisLibrary.getBooks().set(thisLibrary.getBooks().indexOf(found),found);
          System.out.println(listBooks(thisLibrary));

    }

  public static void returnBook(Scanner keyboard,Library thisLibrary){
      System.out.println("Enter a Book ID");
      long id=keyboard.nextLong();
      keyboard.nextLine();
      Book found=new Book();

      for(Book toFind:thisLibrary.getBooks()){

          if(toFind.getId()==id){
              found=toFind;
              System.out.println("ID:"+toFind.getId()+"Title:"+toFind.getTitle()+"has been for \n");
          }
      }

      if(found.isBorrowed())
          found.setBorrowed(false);

      else{
          System.out.println("This book is already available");
      }

      thisLibrary.getBooks().set(thisLibrary.getBooks().indexOf(found),found);
      System.out.println(listBooks(thisLibrary));
  }


}
