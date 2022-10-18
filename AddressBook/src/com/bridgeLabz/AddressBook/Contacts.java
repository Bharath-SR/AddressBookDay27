package com.bridgeLabz.AddressBook;

import java.util.*;

import java.io.*;

class Contacts implements Serializable{
	 int sNo;
	 String firstName;
	 String lastName;
	 String address;
	 String state;
	 String city;
	 int zipcode;
	 int phone_number;
	 String e_mail;
	
	Contacts(String firstName,String lastName,String address,String state,String city,int phone_number,String e_mail,int zipcode,int sNo){
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		this.state=state;
		this.city=city;
		this.zipcode=zipcode;
		this.phone_number=phone_number;
		this.e_mail=e_mail;
		this.sNo=sNo;
	}

	public Contacts(String lastName2, String address2, String state2, String city2, int zipcode2, int phone_number2,
			String e_mail2) {
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return firstName+" "+lastName+" "+address+" "+state+" "+city+" "+zipcode+" "+phone_number+" "+e_mail;
	}
}
class AddressBook{
   public static void main(String[] args) throws Exception{
      int choice = -1;
      Scanner inputInt = new Scanner(System.in);
	  Scanner inputString = new Scanner(System.in);
      File file = new File("employee.txt");
      ArrayList<Contacts> al = new ArrayList<Contacts>();
      ObjectOutputStream oos = null;
      ObjectInputStream ois = null;
      ListIterator li = null;
      if(file.isFile()){
         ois = new ObjectInputStream(new FileInputStream(file));
         al = (ArrayList<Contacts>)ois.readObject();
         ois.close();
      }
      do{
         System.out.println("1.INSERT");
         System.out.println("2.DISPLAY");
         System.out.println("3.SEARCH");
         System.out.println("4.DELETE");
         System.out.println("5.UPDATE");
         System.out.println("6.SORT By FirstName");
         System.out.println("7.Write to File");
         System.out.println("8.Read from File");
         System.out.println("0.EXIT");
         System.out.print("Enter Your Choice : ");
         choice = inputInt.nextInt();

         switch(choice){
            case 1:
               System.out.println("Enter how many Contacts you want : ");
               int n = inputInt.nextInt();
               for(int i=0;i<n;i++){
   				System.out.print("Enter first name : ");
   				String firstName =inputString.nextLine();
   				System.out.print("Enter last name :  ");
   				String lastName =inputString.nextLine();
   				System.out.print("Enter address :  ");
   				String address =inputString.nextLine();
   				System.out.print("Enter State :  ");
   				String state =inputString.nextLine();
   				System.out.print("Enter City :  ");
   				String city =inputString.nextLine();
   				System.out.print("Enter ZipCode :  ");
   				int zipcode =inputInt.nextInt();
   				System.out.print("Enter Phone Number :  ");
   				int phone_number =inputInt.nextInt();
   				System.out.print("Enter Email :  ");
   				String e_mail =inputString.nextLine();

                  al.add(new Contacts(firstName,lastName,address,state,city,zipcode,e_mail,phone_number,sNo));               
               }
               oos = new ObjectOutputStream(new FileOutputStream(file));
               oos.writeObject(al);
               oos.close();
            break;
            case 2:
               if(file.isFile()){
                  ois = new ObjectInputStream(new FileInputStream(file));
                  al = (ArrayList<Contacts>)ois.readObject();
                  ois.close();

                  System.out.println("-------------------------------------");
                  li = al.listIterator();
                  while(li.hasNext())
                     System.out.println(li.next());
                  System.out.println("-------------------------------------");
               }else{
                  System.out.println("File not Exists....!");
               }
            break;
            case 3:
               if(file.isFile()){
                  ois = new ObjectInputStream(new FileInputStream(file));
                  al = (ArrayList<Contacts>)ois.readObject();
                  ois.close();

                  boolean found = false;
                  System.out.println("Enter First Name to Search : ");
                  String firstName = inputString.nextLine();
                  System.out.println("-------------------------------------");
                  li = al.listIterator();
                  while(li.hasNext()){
                     Contacts e = (Contacts)li.next();
                     if(e.firstName == firstName){
                        System.out.println(e);
                        found = true;
                     }
                  }
                  if(!found)
                     System.out.println("Record Not Found...!");
                  System.out.println("-------------------------------------");
               }else{
                  System.out.println("File not Exists....!");
               }
            break;          
            case 4:
               if(file.isFile()){
                  ois = new ObjectInputStream(new FileInputStream(file));
                  al = (ArrayList<Contacts>)ois.readObject();
                  ois.close();

                  boolean found = false;
                  System.out.print("Enter First Name to Delete : ");
                  String firstName = inputString.nextLine();
                  System.out.println("-------------------------------------");
                  li = al.listIterator();
                  while(li.hasNext()){
                     Contacts e = (Contacts)li.next();
                     if(e.firstName == firstName){
                        li.remove();
                        found = true;
                     }
                  }
                  if(found){
                     oos = new ObjectOutputStream(new FileOutputStream(file));
                     oos.writeObject(al);
                     oos.close();
                     System.out.println("Record Deleted Successfully....!");
                  }
                  else{
                     System.out.println("Record Not Found...!");                      
                  }
                  System.out.println("-------------------------------------");
               }else{
                  System.out.println("File not Exists....!");
               }
            break;          
            case 5:
               if(file.isFile()){
                  ois = new ObjectInputStream(new FileInputStream(file));
                  al = (ArrayList<Contacts>)ois.readObject();
                  ois.close();

                  boolean found = false;
                  System.out.print("Enter First Name to Update : ");
                  String firstName = inputString.nextLine();
                  System.out.println("-------------------------------------");
                  li = al.listIterator();
                  while(li.hasNext()){
                     Contacts e = (Contacts)li.next();
                     if(e.firstName == firstName){
               				System.out.print("Enter New Last name :  ");
               				String lastName =inputString.nextLine();
               				System.out.print("Enter New Address :  ");
               				String address =inputString.nextLine();
               				System.out.print("Enter New State :  ");
               				String state =inputString.nextLine();
               				System.out.print("Enter New City :  ");
               				String city =inputString.nextLine();
               				System.out.print("Enter New ZipCode :  ");
               				int zipcode =inputInt.nextInt();
               				System.out.print("Enter New Phone Number :  ");
               				int phone_number =inputInt.nextInt();
               				System.out.print("Enter New Email :  ");
               				String e_mail =inputString.nextLine();

               				li.set(new Contacts(lastName,address,state,city,zipcode,phone_number,e_mail));              
                            found = true;
                     }
                  }
                  if(found){
                     oos = new ObjectOutputStream(new FileOutputStream(file));
                     oos.writeObject(al);
                     oos.close();
                     System.out.println("Record Updated Successfully....!");
                  }
                  else{
                     System.out.println("Record Not Found...!");                      
                  }
                  System.out.println("-------------------------------------");
               }else{
                  System.out.println("File not Exists....!");
               }
            break; 
            case 6:
               if(file.isFile()){
                  ois = new ObjectInputStream(new FileInputStream(file));
                  al = (ArrayList<Contacts>)ois.readObject();
                  ois.close();

                  Collections.sort(al, new Comparator<Contacts>(){
                     public int compare(Contacts e1, Contacts e2){
                        return e1.firstName.compareTo(e2.firstName);
                     }  
                  });    

                  System.out.println("-------------------------------------");
                  li = al.listIterator();
                  while(li.hasNext())
                     System.out.println(li.next());
                  System.out.println("-------------------------------------");
               }else{
                  System.out.println("File not Exists....!");
               }
            break; 
            case 7:
                System.out.println("Written to File");
            break;
            case 8:
                System.out.println("Reading from File...");
            break;
         }
      }while(choice!=0); 
   }
}