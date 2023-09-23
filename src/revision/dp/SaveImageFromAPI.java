package revision.dp;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

 class SaveImageFromAPI {
    public static void main(String[] args) {
        String imageUrl = "https://erowall.com/download_img.php?dimg=";
        String savePath = "F:\\Projects\\java\\core java\\saveimage\\images\\"; // Replace with the desired local file path
           
		  int count=0;
		  int minstartCount=0;
         for(int i=36984;i<40000;i++){
        try {
            // Create a URL object from the image URL
            URL url = new URL(imageUrl+i+"&raz=1920x1080");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Check if the request was successful (HTTP status code 200)
            if (connection.getResponseCode() == 200) {
				System.out.println("Image count " + (count++));
				if(minstartCount==0)
				 minstartCount=i;
                // Get the input stream from the connection
                InputStream inputStream = connection.getInputStream();

                // Read the image data into a BufferedImage
                BufferedImage image = ImageIO.read(inputStream);
                
                // Save the image to the specified file path
                File outputFile = new File(savePath);
                ImageIO.write(image, "jpg", outputFile);

                System.out.println("Image saved to " + savePath);
            } else {
                System.out.println("Failed to fetch image. Status code: " + connection.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		 }
		 System.out.println("Total image found " + count);
		 System.out.println("Min image found " + minstartCount);
		 
    }
}
