package BabyNames;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class BabyNamesAssignment {
    public void totalBirths(FileResource fileParser) {
        int totalBirths = 0, totalBoys = 0, totalGirls = 0;
        int boysNameCount = 0, girlsNameCount = 0;
        for (CSVRecord rec : fileParser.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                boysNameCount += 1;
                totalBoys += numBorn;
            }
            else {
                girlsNameCount += 1;
                totalGirls += numBorn;
            }
        }
        System.out.println("Total Births : " + totalBirths);
        System.out.println("Total Girls : " + totalGirls);
        System.out.println("Total Boys : " + totalBoys);
        System.out.println("Number of Girls Names : " + girlsNameCount);
        System.out.println("Number of Boys Names : " + boysNameCount);
    }

    public int getRank(int year,String name,String gender){
        FileResource fr = new FileResource("src/us_babynames_by_year/yob"+year+".csv");
        int rank = 0;
        for (CSVRecord csvRecord:fr.getCSVParser(false)) {
            if(csvRecord.get(1).equals(gender)) {
                rank += 1;
                if (csvRecord.get(0).equals((name))) {
                    return rank;
                }
            }
        }
        return -1;
    }

    public String getName(int year,int rank,String gender){
        FileResource fr = new FileResource("src/us_babynames_by_year/yob"+year+".csv");
        int count = 0;
        for(CSVRecord csvRecord:fr.getCSVParser(false)){
            if(csvRecord.get(1).equals(gender)) {
                count += 1;
            }
            if(count == rank){
                return csvRecord.get(0);
            }
        }
        return "NO NAME";
    }

    public void whatIsNameInYear(String name,int year,int newYear,String gender){
        int rank = getRank(year,name,gender);
        String newName = getName(newYear,rank,gender);
        if(gender.equals("F"))
            System.out.println(name+" born in "+year+" would be "+newName+" if she was born in "+newYear+".");
        else
            System.out.println(name+" born in "+year+" would be "+newName+" if he was born in "+newYear+".");
    }

    public int yearOfHighestRank(String name,String gender){
        DirectoryResource dr = new DirectoryResource();
        int maxYear = -1, maxRank = Integer.MAX_VALUE;
        int rank;
        for (File file : dr.selectedFiles()){
            String yearName = file.getName().substring(3,7);
            int year = Integer.parseInt(yearName);
            rank = getRank(year,name,gender);
            if(rank < maxRank && rank>0) {
                maxRank = rank;
                maxYear = year;
            }
        }
        return maxYear;
    }

    public static void main(String[] args){
        BabyNamesAssignment obj = new BabyNamesAssignment();
        FileResource fr = new FileResource("src/us_babynames_by_year/yob1900.csv");
        obj.totalBirths(fr);
        System.out.println(obj.getRank(1971,"Frank","M"));
        System.out.println(obj.getName(1982,450,"M"));
        obj.whatIsNameInYear("Owen",1974,2014,"M");
        System.out.println(obj.yearOfHighestRank("Mich","M"));
    }
}
