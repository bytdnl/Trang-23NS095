import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextEditorModel {
    private static final String SAVE_FILE_PATH = "text_editor_data.txt";
    private List<String> lines;

    public TextEditorModel() {
        lines = new ArrayList<>();
        load();
    }

    public List<String> getLines() {
        return lines;
    }

    public void addLine(String line) {
        lines.add(line);
        save();
    }

    public void removeLine(int index) {
        lines.remove(index);
        save();
    }

    private void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SAVE_FILE_PATH))) {
            lines = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_FILE_PATH))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}