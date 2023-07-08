package textProcessing;

import java.util.Scanner;

public class ExtractFile_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();
        //"C:\Internal\training-internal\Template.pptx".split("\")
        String [] parts = path.split("\\\\");     //["C:", "Internal", "training-internal", "Template.pptx"]
        String fullFileName = parts[parts.length - 1];  //"Template.pptx"

        //"Template.pptx".split(".") -> ["Template", "pptx"]
        String name = fullFileName.split("\\.")[0];       //"Template"
        String extension = fullFileName.split("\\.")[1];  //"pptx"

        System.out.println("File name: " + name);
        System.out.println("File extension: " + extension);
    }
}
