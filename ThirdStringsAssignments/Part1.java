package ThirdStringsAssignments;
import edu.duke.*;

public class Part1 {
    public StorageResource getAllGenes(String dna) {
        int index = 0;
        StorageResource storageResource = new StorageResource();
        while(true){
            int firstIndex = dna.indexOf("ATG",index);
            int lastIndex = dna.indexOf("TAA",firstIndex);
            if(firstIndex == -1 || lastIndex==-1)
                break;
            else {
                storageResource.add(dna.substring(firstIndex,lastIndex+3));
                index = lastIndex + 3;
            }
        }
        return storageResource;
    }

    public static void main(String[] args) {
        Part1 part1 = new Part1();
        StorageResource storageResource;
        storageResource = part1.getAllGenes("AATGAATTGGTAAATGGGTTAAAATTGTATAAA");
        for (String string:storageResource.data()) {
            System.out.println(string);
        }
    }
}