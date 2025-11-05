//book: publisher, author, pages
//name -> classes
//fiction book: genre
//scientific book: topic, difficulty
import java.util.*;
public class lab3 {
    static Scanner scan = new Scanner (System.in);
    public static void main(String[] args){
        Book DeadSouls = new Book();
        FictionBook RomeoAndJuliet = new FictionBook();
        ScientificBook IDKBook = new ScientificBook();
        DeadSouls.getBaseInfo();
        RomeoAndJuliett.getFictionBookInfo();
        IDKBook.getScientificBookInfo();
    }
}
public class Book{
    protected String name;
    protected String publisher;
    protected String author;
    protected int pages;
    
    public Book(){}
    
    public Book (String name, String publisher, String author, int pages){
        this.name = name;
        this.publisher = publisher;
        this.author = author;
        this.pages = pages;
    }
    
    public String getName(){
        return name;
    }
    public String getPublisher(){
        return publisher;
    }
    public String getAuthor(){
        return author;
    }
    public int getPages(){
        return pages;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public void setPublisher(String newPublisher){
        this.publisher = newPublisher;
    }
    public void setAuthor(String newAuthor){
        this.author = newAuthor;
    }
    public void setPages(int newPages){
        this.pages = newPages;
    }
    
    public void getBaseInfo(){
        System.out.println("Base book info:");
        System.out.println("Name: "+ name);
        System.out.println("Publisher: "+ publisher);
        System.out.println("Author: "+ author);
        System.out.println("Pages: "+ pages);
    }
}

public class FictionBook extends Book{
    protected String genre;
        
    public FictionBook(String name, String publisher, String author, int pages, String genre){
        super(name, publisher, author, pages);
        this.genre = genre;
    }
    
    public FictionBook(){}
    
    public String getGenre(){
        return genre;
    }
    public void setGenre(String newGenre){
        this.genre = newGenre;
    }
    
    public void getFictionBookInfo(){
        this.getBaseInfo();
        System.out.println("Genre: " + genre);
    }
}

public class ScientificBook extends Book{
    protected String topic;
    protected String difficulty;
    
    public ScientificBook(String name, String publisher, String author, int pages, String topic, String difficulty){
        super(name, publisher, author, pages);
        this.topic = topic;
        this.difficulty = difficulty;
    }
    
    public ScientificBook(){}
    
    public String getTopic(){
        return topic;
    }
    public void setTopic(String newTopic){
        this.topic = newTopic;
    }
    public String getDifficulty(){
        return difficulty;
    }
    public void setDifficulty(String newDifficulty){
        this.difficulty = newDifficulty;
    }
    
    public void getScientificBookInfo(){
        this.getBaseInfo();
        System.out.println("Topic: " + topic);
        System.out.println("Difficulty: " + difficulty);
    }
}