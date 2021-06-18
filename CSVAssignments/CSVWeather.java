package CSVAssignments;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVWeather {
    public CSVRecord getSmallestOfTwo (CSVRecord currentRow, CSVRecord SmallestSoFar) {
        if (SmallestSoFar == null) {
            SmallestSoFar = currentRow;
        }
        else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double largestTemp = Double.parseDouble(SmallestSoFar.get("TemperatureF"));
            if (currentTemp < largestTemp) {
                SmallestSoFar = currentRow;
            }
        }
        return SmallestSoFar;
    }

    public CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord SmallestSoFar = null;
        for (CSVRecord currentRow : parser) {
            SmallestSoFar = getSmallestOfTwo(currentRow, SmallestSoFar);
        }
        return SmallestSoFar;
    }

    public void testColdestHourInFile(){
        FileResource fr = new FileResource("src/nc_weather/2014/weather-2014-01-03.csv");
        CSVRecord smallest = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temperature was " + smallest.get("TemperatureF") +
                " at " + smallest.get("TimeEST"));
    }

    public CSVRecord lowestHumidityInFile(CSVParser csvParser) {
        CSVRecord SmallestSoFar = null;
        for (CSVRecord currentRow : csvParser) {
            if (SmallestSoFar == null) {
                SmallestSoFar = currentRow;
            } else {
                if(currentRow.get("Humidity").equals("N/A"))
                    continue;
                double currentHumidity = Double.parseDouble(currentRow.get("Humidity"));
                double smallestHumidity = Double.parseDouble(SmallestSoFar.get("Humidity"));
                if (currentHumidity < smallestHumidity)
                    SmallestSoFar = currentRow;
            }
        }
        return SmallestSoFar;
    }

    public void testLowestHumidityInFile(){
        FileResource fileResource=new FileResource("src/nc_weather/2014/weather-2014-07-22.csv");
        CSVParser csvParser = fileResource.getCSVParser();
        CSVRecord csv=lowestHumidityInFile(csvParser);
        System.out.println("Lowest Humidity was "+csv.get("Humidity")+" at "+csv.get("DateUTC"));
    }


    public static void main(String[] args){
        CSVWeather obj = new CSVWeather();
        obj.testColdestHourInFile();
        obj.testLowestHumidityInFile();
    }
}
