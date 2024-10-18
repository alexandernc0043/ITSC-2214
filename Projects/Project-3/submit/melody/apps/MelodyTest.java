package melody.apps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.util.Random;
import java.util.Scanner;

import melody.audio.Accidental;
import melody.audio.Note;
import melody.audio.Pitch;

import org.junit.Before;
import org.junit.Test;

import datastructures.LinkedQueue;
import itsc2214.QueueADT;

/**
 *
 * ITSC 2214 Melody.
 * Instructor-provided code.
 * Test Melody
 */
public class MelodyTest {
    Melody instance1; //instance 1 has no repeat(s)
    Melody instance2; //instance 2 has repeat(s)
    String currentDir; //current directory
    
    Random rand; //rand variable

    /**
     * Constructor.
     */
    public MelodyTest() {
        currentDir = System.getProperty("user.dir");
    }
    
    /**
     * Returns a QueueADT filled with the notes specified in the passed in
     * Scan ner. The notes will appear in the same order in the QueueADT
     * as they did in the file.
     * @param input song file input
     * @return QueueADT<Note> Song queue
     */
    public QueueADT<Note> read (Scanner input) {
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
    
    /**
     * Initialize instance(s) before each test function.
     */
    @Before
    public void setUp() {
        rand = new Random();
        String filename1 = "birthday.txt"; //String.format("%s/data/birthday.txt", currentDir);
        File file1 = new File(filename1);
        //String filename2 = "levels.txt";//String.format("%s/data/levels.txt", currentDir);
        String filename2 = "hotcrossbuns.txt";//String.format("%s/data/levels.txt", currentDir);
        File file2 = new File(filename2);
        try{
            Scanner input1 = new Scanner(file1);
            QueueADT<Note> song1 = read(input1);
            instance1 = new Melody(song1, "", "", song1.size());
            
            Scanner input2 = new Scanner(file2);
            QueueADT<Note> song2 = read(input2);
            instance2 = new Melody(song2, "", "", song2.size());
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }


    /**
     * Test of play method, of class Melody.
     */
    @Test
    public void testPlay1() {
        System.out.println("play");
        int size1 = instance1.song.size();
        instance1.play();
        assertEquals(size1, instance1.song.size());

        int size2 = instance2.song.size();
        instance2.play();
        assertEquals(size2, instance2.song.size());
    }

        /**
     * Test of play method, of class Melody.
     */
    @Test
    public void testPlay2() {
        System.out.println("play");
        Melody instance3 = new Melody(null, "", "", 0);
        assertFalse(instance3.play());
    }

    /**
     * Test of reverse method, of class Melody.
     */
    @Test
    public void testReverse1() {
        System.out.println("reverse");
        String instance1String = instance1.toString();
        int size1 = instance1.song.size();
        assertTrue(instance1.reverse());
        assertEquals(size1, instance1.song.size());

        assertTrue(instance1.reverse());
        assertTrue(instance1String.equalsIgnoreCase(instance1.toString()));

    }
    
    /**
     * Test of reverse method, of class Melody.
     * Case 1
     */
    @Test
    public void testReverse2() {
        System.out.println("reverse");
        Melody instance3 = new Melody(null, "", "", 0);
        assertFalse(instance3.reverse());
    }

        /**
     * Test of toString() method, of class Melody.
     * Case 1
     */
    @Test
    public void testToString1() {
        System.out.println("reverse");
        Melody instance3 = new Melody(null, "", "", 0);
        assertTrue(instance3.toString().equals(""));
    }

}
