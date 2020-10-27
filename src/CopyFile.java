import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyFile {
    private static final int BUFFER = 4096;

    private static void copyBinaryFile(String path1,String path2){
        try{
            FileInputStream fis = new FileInputStream(path1);
            FileOutputStream fos = new FileOutputStream(path2);

            byte[] fileBuffer = new byte[BUFFER];
            int byteRead = -1;

            while((byteRead = fis.read(fileBuffer)) != -1){
                fos.write(fileBuffer,0,byteRead);
            }
            fos.close();
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the path-in:");
        String path1 = input.nextLine();
        System.out.println("Enter the path-out:");
        String path2 = input.nextLine();

        copyBinaryFile(path1,path2);
    }
}
