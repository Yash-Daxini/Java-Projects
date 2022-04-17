package otherclass;

import java.util.ArrayList;
import java.util.Scanner;

class IncorrectIdException extends Exception {
    @Override
    public String toString() {
        return "Invalid Id !  Please Enter Correct Id.";
    }
}

class Book {
    String Name;
    String Author;

    // Book(){
    // this.Name = CreateBook().Name;
    // this.Author = CreateBook().Author;
    // }

    Book(String Name, String Author) {
        this.Name = Name;
        this.Author = Author;
    }

    public String toString() {
        return "Name Of Book :" + this.Name + "\n" + "Author Of Book : " + this.Author + "\n\n";
    }
}

class Library {
    int Id;
    ArrayList<Integer> idList = new ArrayList<>();
    ArrayList<Object> bookList = new ArrayList<>();

    public void registerId() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Id:");
        Id = sc.nextInt();
        idList.add(Id);
    }

    public void addBook() throws IncorrectIdException {
        System.out.println();
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Enter Your Student ID:");
        Id = sc.nextInt();

        if (idList.contains(Id)) {
            System.out.print("Enter Book Name You Want to Add:");
            String addName = sc1.nextLine();
            System.out.print("Enter Author of " + addName + " :");
            String addAuthor = sc1.nextLine();
            Book b = new Book(addName, addAuthor);
            bookList.add(b);
            System.out.println(b.Name + " is Added Successfully.");
        }

        else {
            throw new IncorrectIdException();
        }
    }

    public void issueBook() throws IncorrectIdException {
        System.out.println();
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Enter Your Student ID:");
        Id = sc.nextInt();
        System.out.println();

        System.out.println("\t Available Books");
        System.out.println();

        for (Object object : bookList) {
            System.out.print(object.toString() + "   ");
            System.out.println();
        }

        System.out.println();
        String issueName;
        if (idList.contains(Id)) {
            System.out.print("Enter Book Name You Want to Issue :");
            issueName = sc1.nextLine();
            boolean flag = false;
            Object b = null;
            for (Object object : bookList) {
                if (object.toString().contains(issueName)) {
                    b = object;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                bookList.remove(b);
                System.out.println(issueName + " is Issued Succesfully");
            }
            else {
                System.out.println(issueName + " Has Been Alredy Issued!");
            }
        }
        else
        {
            throw new IncorrectIdException();
        }

    }

    public void returnBook() throws IncorrectIdException {
        System.out.println();
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Enter Your Student ID:");
        Id = sc.nextInt();

        if (idList.contains(Id)) {
            System.out.print("Enter Book Name You Want to Return:");
            String returnName = sc1.nextLine();
            System.out.print("Enter Book Name You Want to Return:");
            String returnAuthor = sc1.nextLine();
            Book b = new Book(returnName, returnAuthor);
            bookList.add(b);
            System.out.println(returnName + " is succesfully returned.");
        }

        else {
            throw new IncorrectIdException();
        }
    }
}

public class LibraryManagment {
    public static void main(String[] args) {
        Library l = new Library();
        // Book b2= new Book("JavaA", "def");
        // Book b3= new Book("JavaB", "ghi");
        // Book b4= new Book("JavaC", "jkl");

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("To Register ID in Library : Register Id");
            System.out.println("To add Book in Library : Add");
            System.out.println("To Issue Book from Library : Issue");
            System.out.println("To Return Book in Library : Return");
            System.out.println("Exit : Exit");
            String choice;
            do {
                System.out.println("\n");
                System.out.print("Enter choice :");
                choice = sc.nextLine();
                switch (choice) {
                    case "Register":
                        l.registerId();
                        break;

                    case "Add":
                        l.addBook();
                        break;

                    case "Issue":
                        l.issueBook();
                        break;

                    case "Return":
                        l.returnBook();
                        break;

                    case "Exit":
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid Input!");
                        break;
                }
            } while (choice != "Exit");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
