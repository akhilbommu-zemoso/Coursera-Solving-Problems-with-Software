package FirstStringsAssignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Part4 {
    public void findYouTubeLinks() throws IOException {
        String inputLine;
        URL url = new URL("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        InputStreamReader isp = new InputStreamReader(url.openStream());
        BufferedReader br = new BufferedReader(isp);
        while ((inputLine = br.readLine()) != null) {
            String itemLower = inputLine.toLowerCase();
            int pos = itemLower.indexOf("youtube.com");
            if (pos != -1) {
                int beg = inputLine.lastIndexOf("\"",pos);
                int end = inputLine.indexOf("\"", pos+1);
                System.out.println(inputLine.substring(beg+1,end));
            }
        }
        br.close();
    }
}
class Driver4{
    public static void main(String[] args) throws IOException {
        Part4 obj = new Part4();
        obj.findYouTubeLinks();
    }
}
