//Customer: id, name, address, card number, bank account number
//between MIN and MAX in alphabetical order

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Pattern;

public class Lab6{
    public static void main(String[] args) {
        final long MIN = 1000000000000000L, MAX = 1999999999999999L;
        String input = "input.txt";
        String output = "output.txt";
        CReader reader = new CReader(input);
        CWriter writer = new CWriter(output);
        CParser parser = new CParser("^d+\\|\\[A-Za-z]+\\|\\w+\\|\\d+\\|\\d+$");
        ArrayList<String> strings = reader.readLines();
        ArrayList<Customer> customers = parser.parseCustomers(strings);
        customers.stream().forEach(string -> System.out.println(string));
        customers.sort(CComparator.BY_Name);
        System.out.println("After sorting by Name");
        customers.stream().forEach(string -> System.out.println(string));
        writer.writeToFile(output, customers);
    }
}

public class Customer{
    private int ID;
    private String name;
    private String address;
    private int cardNumber;
    private int accountNumber;
    public Customer(int ID, String name, String address, int cardNumber, int accountNumber){
        this.ID = ID >= 0 ? ID : -1;
        this.name = name != null ? name : "Null";
        this.address = address != null ? address : "Null";
        this.cardNumber = cardNumber > 0 ? cardNumber : -1;
        this.accountNumber = accountNumber > 0 ? accountNumber : -1;
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }
    public void setName(String Name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public int getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ID;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + cardNumber;
        result = prime * result + accountNumber;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if( obj == null || getClass() == obj.getClass()) return false;
        Customer other = (Customer) obj;
        return this.hashCode() == other.hashCode();  
    }
    
    @Override
    public String toString() {
        return ID + "|" + name + "|" + address + "|" + cardNumber + "|" + accountNumber;
    }
}

public class CReader {
    private static String filename;

    public CReader(String inputFile){
        filename = inputFile;
    }

    public ArrayList<String> readLines(){
        ArrayList<String> strings = new ArrayList<>();
        if(filename.isBlank()){
        return strings;
        }
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8)){
           String line;
           while ((line = reader.readLine()) != null) {
        strings.add(line);
           }
        }catch (IOException exception){
            System.err.println("Ошибка при записи файла: " + exception.getMessage());
        }
        return strings;
    }
}

public class CWriter {
    private static String output;
    ArrayList<Customer> filtered = new ArrayList<>();
    
    public ArrayList<Customer> cardNumberFilter(ArrayList<Customer> customers, long MIN, long MAX){
        for(Customer c : customers){
           if(c.getCardNumber() >= MIN && c.getCardNumber() <= MAX){
               filtered.add(c);
           }
        }
    }

    public CWriter(String filename){
    output = filename;
    }

    public void writeToFile(ArrayList<Customer> objList){
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(output), StandardCharsets.UTF_8)) {
          for (Customer c : filtered) {
          bw.write(c.toString());
          bw.newLine();
          }
        System.out.println("Результат записан в " + output);
    } catch (IOException e) {
        System.err.println("Ошибка при записи файла: " + e.getMessage());
    }
    }
}

public class CParser{
    private static String stringPatternRegex;

    public CParser(String regex){
        stringPatternRegex = regex;
    }

    public ArrayList<Customer> parseCustomers(ArrayList<String> strings){
        Pattern pattern = Pattern.compile(stringPatternRegex);
        ArrayList<Customer> customers = new ArrayList<>();
        strings.removeIf(string -> !pattern.matcher(string).matches());
        for(String line : strings){
            String[] params = line.split("\\|");
            customers.add(new Customer(Integer.parseInt(params[0]), params[1], params[2], Integer.parseInt(params[3]), Integer.parseInt(params[3])));
        }
    return customers;
    }
}

public enum CComparator implements Comparator<Customer> {
    BY_ID{
        @Override
        public int compare(Customer c1, Customer c2){
        return Integer.compare(c1.getID(), c2.getID());
        }
    },
    BY_Name{
        @Override
        public int compare(Customer c1, Customer c2){
            return c1.getName().compareTo(c2.getName());
        }
    },
    BY_Address{
        @Override
        public int compare(Customer c1, Customer c2){
            return c1.getAddress().compareTo(c2.getAddress());
        }
    },
    BY_CardNumber{
        @Override
        public int compare(Customer c1, Customer c2){
        return Integer.compare(c1.getCardNumber(), c2.getCardNumber());
        }
    },
    BY_AccountNumber{
        @Override
        public int compare(Customer c1, Customer c2){
        return Integer.compare(c1.getAccountNumber(), c2.getAccountNumber());
        }
    },
}