package exception.interview;

import exception.customexceptionclasses.FileMissingException;

public class ReadFile {

    public static String readFile(String filePath) throws FileMissingException{

        if(filePath == null) {
            throw new FileMissingException("File path is missing. Please provide a valid path.");
        }

        return "Reading file at: " + filePath;
    }
}
