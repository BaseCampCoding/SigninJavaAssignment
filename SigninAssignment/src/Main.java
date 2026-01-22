import java.util.*;

public class Main {
  public static boolean first_iter = true;
  public Map<String, Boolean> students;

  private void get_students(Scanner s) {
    students = new HashMap<>();
    System.out.println("Please provide the student names and then q to quit");
    while(true) {
      System.out.print("> ");
      String in = s.nextLine();
      if (in.equals("q")) break;
      students.put(in, false);
    }
    if (students.isEmpty()) System.out.println("No students were provided");
    first_iter = false;
  }

  public void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    get_students(scanner);
    do {
      if (first_iter) get_students(scanner);
      if (students.isEmpty()) return;

      System.out.print("[check] sign ins, [sign] in, or [q]uit: ");
      String in = scanner.next();

      switch (in) {
        case "check":
          for (String n : students.keySet()) {
            System.out.print("> " + n + ": ");
            if (students.get(n))
              System.out.print("Y\n");
            else
              System.out.print("N\n");
          }
          break;
        case "sign":
          System.out.print("> ");
          String user = scanner.next();
          if (!students.containsKey(user)) {
            System.out.println("User does not exist.");
            break;
          }
          students.put(user, true);
          break;
        case "q":
          return;
      }
    } while (true);
  }
}