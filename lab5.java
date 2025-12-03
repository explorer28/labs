//computer: cp frequency, RAM, GPU, power

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Pattern;

public class Lab5{
    public static void main(String[] args) {
        String input = "input.txt";
        String output = "output.txt";
        CReader reader = new CReader(input);
        CWriter writer = new CWriter(output);
        CParser parser = new CParser("^d+\\|\\w+\\|\\w+\\|\\d+$");
        ArrayList<String> strings = reader.readLines();
        ArrayList<Computer> computers = parser.parseComputers(strings);
        computers.stream().forEach(string -> System.out.println(string));
        computers.sort(CComparator.BY_GPU);
        System.out.println("After sorting by GPU");
        computers.stream().forEach(string -> System.out.println(string));
        writer.writeToFile(output, computers);
    }
}

public class Computer{
    private int frequency;
    private String RAM;
    private String GPU;
    private int power;
    
    public Computer(int frequency, String RAM, String GPU, int power){
        this.frequency = frequency > 0 ? frequency : -1;
        this.RAM = RAM != null ? RAM : "Null";
        this.GPU = GPU != null ? GPU : "Null";
        this.power = power > 0 ? power : -1;
    }

    public int getFrequency() {
        return frequency;
    }
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getRAM() {
        return RAM;
    }
    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getGPU() {
        return GPU;
    }
    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + frequency;
        result = prime * result + ((RAM == null) ? 0 : RAM.hashcode());
        result = prime * result + ((GPU == null) ? 0 : GPU.hashCode());
        result = prime * result + power;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if( obj == null || getClass() == obj.getClass()) return false;
        Computer other = (Computer) obj;
        return this.hashCode() == other.hashCode();  
    }
    
    @Override
    public String toString() {
        return frequency + "|" + RAM + "|" + GPU + "|" + power;
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

    public CWriter(String filename){
    output = filename;
  }

    public void writeToFile(ArrayList<Computer> objList){
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(output), StandardCharsets.UTF_8)) {
          for (Computer obj : objList) {
          bw.write(obj.toString());
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

    public ArrayList<Computer> parseComputers(ArrayList<String> strings){
        Pattern pattern = Pattern.compile(stringPatternRegex);
        ArrayList<Computer> computers = new ArrayList<>();
        strings.removeIf(string -> !pattern.matcher(string).matches());
        for(String line : strings){
            String[] params = line.split("\\|");
            computers.add(new Computer(Integer.parseInt(params[0]), params[1], params[2], Integer.parseInt(params[3])));
        }
    return computers;
    }
}

public enum CComparator implements Comparator<Computer> {
    BY_FREQUENCY{
        @Override
        public int compare(Computer comp1, Computer comp2){
        return Integer.compare(comp1.getFrequency(), comp2.getFrequency());
        }
    },
    BY_RAM{
        @Override
        public int compare(Computer comp1, Computer comp2){
            return comp1.getRAM().compareTo(comp2.getRAM());
        }
    },
    BY_GPU{
        @Override
        public int compare(Computer comp1, Computer comp2){
            return comp1.getGPU().compareTo(comp2.getGPU());
        }
    },
    BY_POWER{
        @Override
        public int compare(Computer comp1, Computer comp2){
            return Integer.compare(comp1.getPower(), comp2.getPower());
        }
    }

}
