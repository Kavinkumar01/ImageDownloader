import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void downloadImage(String imageUrl, String destinationFile) {
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        try {
            // Create URL object
            URL url = new URL(imageUrl);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Open input stream from the connection
            in = new BufferedInputStream(connection.getInputStream());

            // Open output stream to save the file
            fout = new FileOutputStream(destinationFile);

            // Buffer for reading data
            byte[] buffer = new byte[1024];
            int bytesRead;

            // Read from the input stream and write to the output stream
            while ((bytesRead = in.read(buffer)) != -1) {
                fout.write(buffer, 0, bytesRead);
            }

            System.out.println("Image downloaded to " + destinationFile);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close streams
            try {
                if (in != null) in.close();
                if (fout != null) fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    public static void main(String[] args) {
//        // Example URL and destination
//        String imageUrl = "https://example.com/image.jpg";
//        String destinationFile = "downloaded_image.jpg";
//
//        // Call the method to download the image
//        downloadImage(imageUrl, destinationFile);
//    }

    public static List<String> readLinesFromFile(String filePath) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static boolean doesFileExist(String fileUrl) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(fileUrl).openConnection();
            connection.setRequestMethod("HEAD"); // Use HEAD to just check for existence
            int responseCode = connection.getResponseCode();
            return (responseCode == HttpURLConnection.HTTP_OK);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void createDirectoryIfNotExists(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            if (directory.mkdirs()) { // Use mkdirs() to create any necessary but nonexistent parent directories
                System.out.println("Directory created: " + directoryPath);
            } else {
                System.out.println("Failed to create directory: " + directoryPath);
            }
        } else {
            System.out.println("Directory already exists: " + directoryPath);
        }
    }

public static void main(String[] args) throws IOException {
    String filePath = "C:/Users/kavin/OneDrive/Desktop/new Practice(60 days)/TestDownload/Test.txt"; // Path to your text file
    List<String> lines = readLinesFromFile(filePath);
    for(int j=0;j<lines.size();j++) {
        String foldername=j+"/";
        // Print lines to verify
        if (lines != null) {
            for (String line : lines) {
                List<String> imageUrls = new ArrayList<>();
                System.out.println(line);
                for (int i = 1; i <= 20; i++) {
                    imageUrls.add(line + i + ".jpg");
                }
                boolean directoryExist=false;
                for (String imageUrl : imageUrls) {
                    String fileName = imageUrl.substring(imageUrl.lastIndexOf('/') + 1);
                    String directoryPath = "C:/Users/kavin/OneDrive/Desktop/new Practice(60 days)/TestDownload/"+foldername;
                    File directory = new File(directoryPath);
                    if(!directoryExist) {
                        if (!directory.exists()) {
                            if (directory.mkdirs()) { // Use mkdirs() to create any necessary but nonexistent parent directories
                                System.out.println("Directory created: " + directoryPath);
                                directoryExist=true;
                            } else {
                                System.out.println("Failed to create directory: " + directoryPath);
                            }
                        } else {
                            System.out.println("Directory already exists: " + directoryPath);
                        }
                    }
//                    createDirectoryIfNotExists(directoryPath);
                    String destinationFile = "C:/Users/kavin/OneDrive/Desktop/new Practice(60 days)/TestDownload/"+foldername + fileName;

                    Image image = ImageIO.read(new URL(imageUrl));
                    if (image != null) {
//                if (doesFileExist(imageUrl)) {
                        downloadImage(imageUrl, destinationFile);
                    } else {
                        System.out.println("File not found: " + imageUrl);
                    }
                }
            }
        }

//        for(int i=0;i<20;i++) {


        // Example of dynamic URLs
//            String[] imageUrls = {
//                    "https://pics.jjgirls.com/pictures/myfriendshotmom/ava-addams-brandi-love-julia-ann/panther-wife-shut/ava-addams-brandi-love-julia-ann-3.jpg",
//                    "https://pics.jjgirls.com/pictures/myfriendshotmom/ava-addams-brandi-love-julia-ann/panther-wife-shut/ava-addams-brandi-love-julia-ann-4.jpg",
//                    // Add more URLs as needed
//            };
//        }

    }
}
}
