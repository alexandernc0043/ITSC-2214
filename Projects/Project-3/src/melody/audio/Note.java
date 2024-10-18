package melody.audio;

/**
 * ITSC 2214 ArrayCircularQueue
 * Instructor-provided code.  You should not modify this file!
 * A Note object represents a musical note in scientific music notation.
 * For example, middle C is represented as C4. 
 */
public class Note {
    /**
     * Constant for the minimum legal value that an octave can have.
     */
    public static final int OCTAVE_MIN = 1;

    /**
     * Constant for the maximum legal value that an octave can have.
     */
    public static final int OCTAVE_MAX = 10;
    private Pitch note;
    private double duration;
    private int octave;
    private Accidental accidental;
    private boolean repeat;

    // pre : duration > 0 and 0 <= octave <= 10, otherwise throws an IllegalArgumentException
    // constructs a note with the provided duration, pitch, octave, accidental 
    //       and repeat settings.
    public Note(double duration, Pitch note, int octave, Accidental accidental, boolean repeat) {
       if(duration <= 0 || octave < 0 || octave > 10) {
          throw new IllegalArgumentException();
       }
       this.note = note;
       this.duration = duration;
       this.octave = octave;
       this.accidental = accidental;
       this.repeat = repeat;
    }
   
    // pre : duration > 0, otherwise throws an IllegalArgumentException
    // constructs a note with the passed in duration, pitch and repeat settings. 
    public Note(double duration, Pitch note, boolean repeat) {
       this(duration, note, 0, Accidental.NATURAL, repeat);
    }
    public Note(double duration, boolean repeat) {
        this(duration, Pitch.R, OCTAVE_MIN + 1, Accidental.NATURAL, repeat);
    }
   // returns the length of the note in seconds
   public double getDuration() {
      return duration;
   }
   
   // returns the Accidental value of the note
   public Accidental getAccidental() {
      return accidental;
   }
   
   // returns the octave of the note
   public int getOctave() {
      return octave;
   }
   
   // returns the pitch of the note (A - G or R of it is a rest)
   public Pitch getPitch() {
      return note;
   }
   
   // pre : d must be greater than 0, otherwise an IllegalArgumentException is thrown
   // sets the duration of the note to be the given time
   public void setDuration(double d) {
      if(d <= 0) {
         throw new IllegalArgumentException();    
      }
      duration = d;
   }
   
   // sets the accidental of the note to be the given accidental
   public void setAccidental(Accidental a) {
      accidental = a;
   }
   
   // pre : octave must be greater than 0 and less than 10, 
   //       otherwise an IllegalArgumentException is thrown
   // sets the octave of the note to be the passed in octave
   public void setOctave(int octave) {
      if(octave < 0 || octave > 10) {
         throw new IllegalArgumentException();    
      }
      this.octave = octave;
   }
   
   // sets the pitch of the note to be the passed in pitch
   public void setPitch(Pitch pitch) {
      note = pitch;
   }
   
   // sets the repeat of the note to be the passed in repeat
   public void setRepeat(boolean repeat) {
      this.repeat = repeat;
   }
   
   // returns true if the note is the beginning or ending note in a repeated section, 
   //       false otherwise
   public boolean isRepeat() {
      return repeat;
   }
   
   // plays the sound this note represents
   //public void play() {
   //   StdAudio.play(duration, note, octave, accidental);
   //}
    /**
     * Plays this note through the underlying audio system.
     * Also prints a message to the system console for debugging.
     * If the audio system is muted or paused, the note may not play.
     */
    public void play() {
        if (note == Pitch.R) {
            // play no sound (but do delay) if the note is a rest
            // StdAudio.play(StdAudio.note(0, duration, 0.5), duration);
            StdAudio.play(this, StdAudio.note(0, duration, 0.5), duration);
        } else {
            char noteChar = note.toString().charAt(0);
            int steps = (noteChar - 'A') * 2;

            // adjust for sharps/flats
            if (noteChar == 'C' || noteChar == 'D' || noteChar == 'E') {
                    steps -= 1;
            } else if (noteChar == 'F' || noteChar == 'G') {
                    steps -= 2;
            }

            // adjust pitch for proper octave
            if (octave > 4 || (octave == 4 && noteChar <= 'B')) {
                    steps += (octave - 4) * 12;
            } else {
                    steps -= (4 - octave) * 12;
            }

            // octave start at C so A and B are an octave lower
            if (noteChar != 'A' && noteChar != 'B') {
                steps -= 12;
            }

            // adjust for sharps and flats
            if (accidental.equals(Accidental.SHARP)) {
                steps += 1;
            } else if (accidental.equals(Accidental.FLAT)) {
                steps -= 1;
            }

            // play the note!
            double hz = 440.0 * Math.pow(2, steps / 12.0);
            StdAudio.play(this, StdAudio.note(hz, duration, 0.5), duration);
        }
    }
   
   // returns a string in the format "<duration> <pitch> <repeat>" if the note is a rest,
   //       otherwise returns a string in the format: 
   //       "<duration> <pitch> <octave> <accidental> <repeat>"
   //       For example "2.3 A 4 SHARP true" and "1.5 R true".
   public String toString() {
      if(note.equals(Pitch.R)) {
         return String.format("%f %s %s", duration, note, repeat);
      } else {
         return String.format("%f %s %d %s %s", duration, note, octave, accidental, repeat);
      }
   }
}