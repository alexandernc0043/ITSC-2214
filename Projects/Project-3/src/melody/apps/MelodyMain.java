package melody.apps;

import datastructures.*;
import melody.audio.Pitch;
import melody.audio.Note;
import melody.audio.Accidental;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import itsc2214.QueueADT;

/**
 * ITSC 2214 MelodyMain
 * Instructor-provided code.
 * This program tests your Melody object on any file you want.
 * When the program starts, type load and enter the name of the file you want to play
 * You can then type play to hear it or any of the other commands to test you Melody's
 * other functionality.
 */
public class MelodyMain {
    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        intro();

        Melody melody = null;
        Scanner console = new Scanner(System.in);
        String command = "load";
        while(!command.equalsIgnoreCase("quit")) {
            System.out.print("What would you like to do? ");
            command = console.next();

            if(!(command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("load")) 
                            && melody == null) {
                System.out.println("You must load a song before trying to manipulate it");    
            } else if(command.equalsIgnoreCase("load")) {
                System.out.print("File name? ");
                File file = checkFile(console.next(), console);
                Scanner input = new Scanner(file);
                QueueADT<Note> song = read(input);
                melody = new Melody(song, "", "", song.size());
            } else if (command.equalsIgnoreCase("play")) {
                melody.play();
            } else if (command.equalsIgnoreCase("reverse")) {
                melody.reverse();
            } else if (!command.equalsIgnoreCase("quit")) {
                System.out.println("Invalid command. Please try again.");
                intro();
            }		
        }
    }

    // prints out an introduction describing how to use the program
    private static void intro() {
        System.out.println("Welcome to MelodyMain. Type the word in the left column to do the action on the right");
        System.out.println("load     : load a new input file");
        System.out.println("play     : play the last loaded song");
        System.out.println("reverse  : reverse the last loaded song");
        System.out.println("quit     : exit the program");
    }

    // checks to make sure the file exists. Prompts the user for a new file until they 
    // input a valid one. Returns a file that exists.
    public static File checkFile(String name, Scanner console) {
        File file = new File(name);
        while (!file.exists()) {
            System.out.print("Invalid file. File name? ");
            file = new File(console.next());
        }
        return file;
    }

    // returns a QueueADT filled with the notes specified in the passed in 
    // Scanner. The notes will appear in the same order in the QueueADT
    // as they did in the file.
    public static QueueADT<Note> read (Scanner input) {
        //Queue<Note> song = new LinkedList<Note>();
        QueueADT<Note> song = new LinkedQueue<Note>();  //new ArrayCircularQueue<Note>();
        while(input.hasNext()) {
            double duration = input.nextDouble();
            Pitch pitch = Pitch.valueOf(input.next());
            if(pitch.equals(Pitch.R)) {
                song.enqueue(new Note(duration, pitch, input.nextBoolean()));          
            } else {
                song.enqueue(new Note(duration, pitch, input.nextInt(), 
                Accidental.valueOf(input.next()), input.nextBoolean()));
            }
        }
        return song;
    }
    
    // returns a QueueADT filled with the notes specified in the passed in 
    // Scanner. The notes will appear in the same order in the QueueADT
    // as they did in the file.
    public static QueueADT<Note> read (String filename) {
        //Queue<Note> song = new LinkedList<Note>();
        QueueADT<Note> song = new LinkedQueue<Note>();  //new ArrayCircularQueue<Note>();
        System.out.println("Filename: " + filename);
        File file = new File(filename);
        try{
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                double duration = input.nextDouble();
                Pitch pitch = Pitch.valueOf(input.next());
                if (pitch.equals(Pitch.R)) {
                    song.enqueue(new Note(duration, pitch, input.nextBoolean()));
                } else {
                    song.enqueue(new Note(duration, pitch, input.nextInt(),
                            Accidental.valueOf(input.next()), input.nextBoolean()));
                }
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return song;
    }
}
