package by.jmp.console;

import module11.task1.service.PersonService;
import module11.task1.service.PersonServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Julia on 01.03.2016.
 */
public class Runner {
    
    enum Command {
        exit,
        list,
        add,
        get,
        help
    }
    
    private static PersonService personService = new PersonServiceImpl();
    
    
    
    public static void main(String[] args) {
        System.out.println("Gradle and Maven Task");
        
        String command;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                command = br.readLine();
                if (Command.help.toString().equals(command)) {
                    help();
                } else if (Command.exit.toString().equals(command)) {
                    exit();
                } else if (Command.list.toString().equals(command)) {
                    list();
                } else if (Command.add.toString().equals(command)) {
                    add(br);
                } else if (Command.get.toString().equals(command)) {
                    get(br);
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void exit() {
        System.exit(0);
    }
    
    public static void list() {
        System.out.println("Person List:");
        for(String person: personService.getPersons()) {
            System.out.println(person);
        }
    }
    
    public static void add(BufferedReader br) throws IOException{
        System.out.print("Input person data (name,age,gender): ");
        
        String personStr = br.readLine();
        personService.addPerson(personStr);
    }
    
    public static void get(BufferedReader br) throws IOException{
        System.out.print("Input person name: ");
        
        String name = br.readLine();
        System.out.println(personService.getPerson(name));
    }
    
    public static void help() {
        System.out.println("List of command:");
        System.out.println("- exit");
        System.out.println("- list (return list of person)");
        System.out.println("- add (add user in format name,age,gender)");
        System.out.println("- get (get person by name)");
    }
}