import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TextEditorModel model = new TextEditorModel();
        TextEditorView view = new TextEditorView();
        TextEditorController controller = new TextEditorController(model, view);

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add line");
            System.out.println("2. Remove line");
            System.out.println("3. Display lines");
            System.out.println("4. Traverse directory");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    controller.addLine();
                    break;
                case 2:
                    controller.removeLine();
                    break;
                case 3:
                    controller.displayLines();
                    break;
                case 4:
                    controller.traverseDirectory();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        scanner.close();
    }
}