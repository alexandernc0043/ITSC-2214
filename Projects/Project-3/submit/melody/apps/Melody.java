package melody.apps;

import itsc2214.QueueADT;
import datastructures.*;
import melody.audio.Note;

/**
 * ITSC 2214 Melody
 * Instructor-provided code.
 * Manage music notes in a Melody object on any file you want.
 */
public class Melody {
    QueueADT<Note> song;
    String songTitle;
    String songComposers;
    int numOfLines;
    double totalDuration;
    final static int MIN_OCTAVE = 1;
    final static int MAX_OCTAVE = 10;
    final static int MAX_REPEATS = 3;
    final static int ARRAY_BLOCKING_QUEUE_INIT_CAPACITY = 100;

    /**
     * Initializes your melody to store the passed in QueueADT of Notes.
     *
     * @param song    A Note queue
     * @param title   Song title
     * @param artists Song composers
     * @param lineNum Number of basic notes (not counting repeats)
     */
    public Melody(QueueADT<Note> song,
                  String title, String artists, int lineNum) {
        // TODO: write this constructor
        this.song = song;
        this.totalDuration = 0;
        this.songTitle = title;
        this.numOfLines = lineNum;
        this.songComposers = artists;
    }

    /**
     * In this method you should play your melody so that it can
     * be heard on the computer's speakers. Essentially this
     * consists of calling the play method on each Note in your
     * array. The notes should be played from the beginning
     * of the list to the end, unless there are notes that
     * are marked as being part of a repeated section. If a
     * series of notes represents a repeated section, that sequence
     * is played twice. For example, in the diagram below, suppose
     * the notes at indexes 3, 5, 9, and 12 all indicate that they
     * are start/end points of repeated sections (their isRepeat
     * method returns true). In this case, the correct sequence of
     * note indexes to play is 0, 1, 2, 3, 4, 5, 3, 4, 5, 6, 7, 8,
     * 9,10, 11, 12, 9, 10, 11, 12, 13. Note that notes at indexes
     * 3-5 and 9-12 are played twice in our example.
     * This method should not modify the state of your array.
     * Also, it should be possible to call play multiple times
     * and get the same result each time.
     *
     * @return boolean Is it successful reversing the melody
     */
    public boolean play() {
        // TODO: READ this method
        if (this.song == null)
            return false;
        boolean isRepeated = false;
        int repeatCount = 0;
        int numOfNotes = this.song.size();
        QueueADT<Note> repeatQueue = null;
        Note note;
        QueueADT<Note> tmpQueue = this.song;
        for (int i = 0; i < numOfNotes; i++) {
            note = tmpQueue.dequeue();
            note.play();
            tmpQueue.enqueue(note);

            if (isRepeated) {
                if (note.isRepeat()) {
                    if (repeatCount >= Melody.MAX_REPEATS) {
                        tmpQueue = this.song;
                        isRepeated = false;
                        repeatCount = 0;
                    } else if (repeatCount > 0) {
                        repeatCount++;
                        if (repeatCount < Melody.MAX_REPEATS) {
                            numOfNotes += tmpQueue.size();
                        }
                    } else {//repeatCount == 0 
                        repeatQueue.enqueue(note);
                        repeatCount++;
                        tmpQueue = repeatQueue;
                        numOfNotes += tmpQueue.size();
                    }
                } else {//note.isRepeat() == false note in the middle of a repeat section
                    if (tmpQueue == this.song) {
                        repeatQueue.enqueue(note);
                    }
                }
            } else {//!isRepeated
                if (note.isRepeat()) { //Beginning of the repeat section
                    repeatQueue = new LinkedQueue<Note>(); //ArrayCircularQueue<Note>();
                    isRepeated = true;
                    repeatQueue.enqueue(note);
                }
            }
        }
        return true;
    }

    /**
     * Reverses the order of notes in the song, so that future
     * calls to the play methods will play the notes in the
     * opposite of the order they were in before reverse was
     * called. For example, a song containing notes A, F, G,
     * then B would become B, G, F, A after reversing.
     * This function just reverse the order of notes
     * and it will not play the reversed song.
     * Only when users choose to play, the notes in queue will
     * be played out.
     * You may use one temporary StackADT or one temporary
     * QueueADT to help you solve this problem.
     *
     * @return boolean Is it successful reversing the melody
     */
    public boolean reverse() {
        if (this.song == null)
            return false;
        // TODO: write this method
        for (int i = 0; i < this.song.size(); i++) {
            Note note = this.song.dequeue();
            this.song.enqueue(note);
        }
        return true;
    }

    /**
     * This method is optional.
     * You are not required to write a toString method in your
     * Melody class, but if you do, it will be called by our Main
     * program when any operations are performed. For example, after
     * loading a song from a file, or reversing the song, or
     * changing duration or octaves, the Main program prints out
     * the toString representation of your Melody on the console.
     * If you do write a toString, you can return any string you
     * want. This may be useful for debugging. Recall that
     * Arrays.toString returns a string representation of an array
     *
     * @return Song notes
     */
    public String toString() {
        // TODO Read this method
        if (this.song == null) return "";
        int numOfNotes = this.song.size();
        Note[] notes = new Note[numOfNotes];
        Note note;
        for (int i = 0; i < numOfNotes; i++) {
            note = this.song.dequeue();
            notes[i] = note;
            this.song.enqueue(note);
        }
        return java.util.Arrays.toString(notes);
    }
}

