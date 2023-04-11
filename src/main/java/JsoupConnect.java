import com.opencsv.CSVWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


    public class JsoupConnect {

        public static void getContentFromHtmlPage() {

            try {
                Document doc = Jsoup.connect("https://awmhq.weblium.site/applications/project-1-3").get();
                Elements paragraphs = doc.select("p");

                // Create a list to hold the data
                List<String[]> data = new ArrayList<>();

                // Add header row
                String[] header = {"Text"};
                data.add(header);

                // Add data rows
                for (Element p : paragraphs) {
                    String[] row = {p.text()};
                    data.add(row);
                }

                // Write data to CSV file
                CSVWriter writer = new CSVWriter(new FileWriter("output.csv"));
                writer.writeAll(data);
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
