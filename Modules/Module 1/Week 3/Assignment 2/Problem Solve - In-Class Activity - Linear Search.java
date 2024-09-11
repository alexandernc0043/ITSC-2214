import java.util.Comparator;
import java.util.Date;

class CourseComparatorByCreditsAndBookPublix implements Comparator<Course> {
	@Override
	public int compare(Course t, Course t1){
		if(t.credits == t1.credits)
			return new BookComparatorByPublishingDate().compare(t.book, t1.book);
		else 
			return t.credits - t1.credits;
	}
}
class BookComparatorByPublishingDate implements Comparator<TextBook>{
	@Override
	public int compare(TextBook t, TextBook t1){
		return t.publishing_date.compareTo(t1.publishing_date);
	}
}
class BookComparatorByPrice implements Comparator<TextBook>{
	@Override
	public int compare(TextBook t, TextBook t1){
		return (int)(t.price - t1.price);
	}
}
class CourseComparatorByCredits implements Comparator<Course>{
	@Override
	public int compare(Course t, Course t1){
		return t.credits - t1.credits;
	}
}

class TextBook{
	public long ISBN;
	public float price;
	public Date publishing_date;
	public Textbook(long ISBN, float price, Date publishing_date){
		this.ISBN = ISBN;
		this.price = price;
		this.publishing_date = publishing_date;
	}
	@Override
	public Object clone(){
		return new TextBook(this.ISBN, this.price, (Date)(this.publishing_date.clone()));
	}
	@Override
	public boolean equals(Object another){
		return this.ISBN == ((Textbook)another).ISBN;
	}
	@Override
	public String toString(){
		return "ISBN:" + this.ISBN + "\n"
			+ "Price:" + this.price + "\n"
			+ "Publishing Date:" + this.publishing_date;
	}
}
class Course {
	public String title;
	public short code;
	public byte credits;
	public Textbook book;
	public Course(String title, short code, byte credits, Textbook book){
		this.title = title;
		this.code = code;
		this.credits = credits;
		this.book = (Textbook)(book.clone());
	}
	@Override
	public boolean equals(Object another){
		return this.code == ((Course)another).code && this.book.equals(((Course)another).book);
	}
	@Override
	public String toString(){
		return "Title:" + this. title + "\n" 
		+ "Code:" + this.code + "\n" 
		+ "Credits:" + this.credits + "\n" 
		+ "Textbook:" + this.book.toString();
	}
}
class CourseComparatorByCode implements Comparator<Course>{
	@Override
	public int compare(Course t, Course t1) {
		return t.code - t1.code;
	}
}
public class CourseManagement {
	public static void main (String [] argv){
		Course ds = new Course ("Data Structures",(short) 2214, (byte) 3, new TextBook (133250121, (float) 86.5, new Date (2002, 1,1) ));
		Course database = new Course ("Database systems"(short) 3160, (byte) 3,new TextBook (133970779,(float) 156.5, new Date (2012,1,1)));
		Course data mining = new Course ("Data Mining",(short) 3162, (byte) 3,new TextBook (128042915, (float) 122.5, new Date (2022, 1,1)));
		System out printin(" Find the first course which titles include | "datal" if the case is insensitive?");
		Course resultA = solveProblemA(list, "data");
		System.out.println(resultA);
		System.out. println ("Examine whether this course are contained in the systems,for example, course code is 2214 and ISBN is 133250121");
		boolean result = solveProblemB(list, ds);
		System.out.println(resultB);
		System.out.println("Find the course which posits less course credits. If two courses have the same course credits, list the course that has earliest textbook publishing date.");
		Course resultC = solveProblemC(list) ;
		System.out.println (resultC);
	}
	//Solve problem A
	public static Course solveProblemA (Course[] list, String wordInCourseTitle){
	if (list == null || wordInCourseTitle == null) return null;
	for (Course course: list){
		if(course. title. toLowerCase() .contains(wordInCourseTitle. toLowerCase()))
			return course;
		}
	return null;
	}
	//Solve problem B
	public static boolean solveProblemB(Coursell list, Course aCourse){
		if (list = null || aCourse == null) return false;
		for (Course course: list){
			if (aCourse. equals (course) )
				return true;
		}
		return false;
	}
	//Solve problem C
	public static Course solveProblemC(Course[] list){
		if (list == null) return null;
		Course desired = list[0];
		Course curScan;
		int comparison;
		for (int i = 1; i < list.length; i++){
			curScan = list[il;
			comparison = new CourseComparatorByCreditsAndBookPublix().compare (desired, curScan);
			if (comparison › 0)
				desired = curScan;
		}
		return desired;
	}
}










