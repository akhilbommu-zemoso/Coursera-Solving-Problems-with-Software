package ThirdStringsAssignments;

import edu.duke.FileResource;
import edu.duke.StorageResource;

public class Part3 {
    public float cgRatio(String dna) {
        int count = 0;
        for (int i = 0; i < dna.length(); i++) {
            if (dna.charAt(i) == 'c' || dna.charAt(i) == 'g')
                count++;
        }
        return (float)count/dna.length();
    }

    public void processGenes(StorageResource sr){
        int lenCount = 0;
        System.out.println("Strings in sr that are longer than 9 characters :");
        for (String s : sr.data()) {
            if (s.length() > 9) {
                System.out.println(s);
                lenCount += 1;
            }
        }

        System.out.println("Number of Strings in sr that are longer than 9 characters : " + lenCount);

        int cgCount = 0;
        String maxLenString = "";
        System.out.println("Strings in sr whose C-G-ratio is higher than 0.35 :");
        for (String s : sr.data()) {
            if (cgRatio(s) > 0.35) {
                System.out.println(s);
                cgCount += 1;
            }
            if(s.length() > maxLenString.length()){
                maxLenString = s;
            }
        }
        System.out.println("Number of strings in sr whose C-G-ratio is higher than 0.35 : " + cgCount);

        System.out.println("Length of the longest gene in sr : " + maxLenString);
    }

    public void testProcessGenes() {
        StorageResource storageResource = new StorageResource();
        storageResource.add("atcgatgcatagcta");
        storageResource.add("atctg");
        storageResource.add("ccggatgcagc");
        storageResource.add("cgaaattttt");
        storageResource.add("atctagtcgtacgtaaac");
        // FileResource fileResource = new FileResource("src/brca1line.fa");
        // String dna = fileResource.asString();
        // storageResource.add(dna);
        processGenes(storageResource);
    }

    public static void main(String[] args) {
        Part3 obj = new Part3();
        obj.testProcessGenes();
    }
}