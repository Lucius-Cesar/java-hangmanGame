import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileUtils {
    public static ArrayList<String> fileToArrayList(String filePath){
        ArrayList <String> arrayList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null) {
                arrayList.add(line.trim());
            }
        }
        catch(FileNotFoundException e){
            System.out.println("file " + filePath+ " not found.");
        }
        catch(IOException e){
            System.out.println("Something went wrong");

        }
        return (arrayList);

    }

    public static ArrayList <String> fileToArrayList(String filePath, String splittingString) {
        ArrayList<String> arrayList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String fileContent = "";
            while ((line = reader.readLine()) != null) {
                fileContent = fileContent + line + "\n";
            }
            String[] array = fileContent.split(splittingString);
            arrayList = new ArrayList<>(Arrays.asList(array));
        } catch (FileNotFoundException e) {
            System.out.println("file " + filePath + " not found.");
        } catch (IOException e) {
            System.out.println("Something went wrong");

        }
        return (arrayList);
    }
}
