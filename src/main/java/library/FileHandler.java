import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final String BOOK_FILE = "data/books.txt";
    private static final String MEMBER_FILE = "data/members.txt";

    @SuppressWarnings("unchecked")
    public List<Book> loadBooks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(BOOK_FILE))) {
            return (List<Book>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Member> loadMembers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(MEMBER_FILE))) {
            return (List<Member>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void saveBooks(List<Book> books) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BOOK_FILE))) {
            oos.writeObject(books);
        } catch (IOException e) {
            System.out.println("Error saving books");
        }
    }

    public void saveMembers(List<Member> members) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(MEMBER_FILE))) {
            oos.writeObject(members);
        } catch (IOException e) {
            System.out.println("Error saving members");
        }
    }
}