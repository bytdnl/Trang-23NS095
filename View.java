import java.io.File;
import java.util.List;

public class TextEditorController {
    private final TextEditorModel model;
    private final TextEditorView view;

    public TextEditorController(TextEditorModel model, TextEditorView view) {
        this.model = model;
        this.view = view;
    }

    public void addLine() {
        String line = view.getNewLineFromUser();
        model.addLine(line);
    }

    public void removeLine() {
        int index = view.getLineToRemoveFromUser() - 1;
        model.removeLine(index);
    }

    public void displayLines() {
        List<String> lines = model.getLines();
        view.displayLines(lines);
    }

    public void traverseDirectory() {
        String path = view.getDirectoryPathFromUser();
        File directory = new File(path);
        traverse(directory);
    }

    private void traverse(File dir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        traverse(file);
                    } else {
                        System.out.println(file.getAbsolutePath());
                    }
                }
            }
        }
    }

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
        } while (choice !=5);
        scanner.close();
    }
}