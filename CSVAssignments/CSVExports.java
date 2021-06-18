package CSVAssignments;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVExports{
    public String countryInfo(CSVParser csvParser, String countryName){
        for (CSVRecord csvRecord:csvParser) {
            String country = csvRecord.get("Country");
            if(country.equals(countryName)) {
                return csvRecord.get("Country") + ":" + csvRecord.get("Exports") + ":" + csvRecord.get("Value (dollars)");
            }
        }
        return "NOT FOUND";
    }

    public void listExportersTwoProducts(CSVParser csvParser,String exportItem1,String exportItem2){
        for (CSVRecord csvRecord:csvParser) {
            String exports = csvRecord.get("Exports");
            if(exports.contains(exportItem1) && exports.contains(exportItem2)){
                System.out.println(csvRecord.get("Country"));
            }
        }
    }

    public int numberOfExporters(CSVParser csvParser,String exportItem){
        int count = 0;
        for (CSVRecord csvRecord:csvParser) {
            String exports = csvRecord.get("Exports");
            if(exports.contains(exportItem)) {
                count += 1;
            }
        }
        return count;
    }

    public void bigExporters(CSVParser csvParser,String amount){
        for (CSVRecord csvRecord:csvParser) {
            String value = csvRecord.get("Value (dollars)");
            if(value.length() > amount.length()) {
                System.out.println(csvRecord.get("Country") + " " + csvRecord.get("Value (dollars)"));
            }
        }
    }

    public void tester(){
        FileResource fr = new FileResource("src/exports_small.csv");
        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser,"Germany"));
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser,"gold","diamonds");
        parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser,"gold"));
        parser = fr.getCSVParser();
        bigExporters(parser,"$999,999,999");
    }

    public static void main(String[] args){
        CSVExports obj = new CSVExports();
        obj.tester();
    }
}