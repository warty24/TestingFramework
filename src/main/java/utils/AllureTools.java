package utils;

import io.qameta.allure.Attachment;
import org.apache.commons.io.IOUtils;
import java.io.*;



public class AllureTools {
    private static File newFile;
    private static InputStream inputStream;

    @SuppressWarnings({"UnusedReturnValue", "ResultOfMethodCallIgnored"})
    @Attachment(value = "Log File", type = "text/plain")
    public static byte[] attachLogFile() {
        File folder = new File("Files");
        File[] listOfFiles = folder.listFiles();

        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(".log")) {
                newFile = file;
            }
        }

        try {
            inputStream = new FileInputStream(newFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            newFile.delete();
            return IOUtils.toByteArray(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
