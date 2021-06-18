package SecondStringsAssignment;

public class Part3 {
    public String findGene(String dna) {
        int firstIndex = dna.indexOf("ATG");
        if (firstIndex == -1){
            return "";
        }else{
            int indexTAA = findStopCodon(dna, firstIndex, "TAA");
            int indexTAG = findStopCodon(dna, firstIndex, "TAG");
            int indexTGA = findStopCodon(dna, firstIndex, "TGA");
            int endIndex = Math.min(indexTGA, Math.min(indexTAG, indexTAA));
            if (endIndex == dna.length())
                return "";
            return dna.substring(firstIndex, endIndex + 3);
        }
    }

    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int index = dna.indexOf(stopCodon, startIndex);
        if ((index - startIndex) % 3 == 0) {
            return index;
        }else{
            return dna.length();
        }
    }

    public int countGenes(String dna) {
        int index = 0, count = 0;
        while (true) {
            int firstIndex = dna.indexOf("ATG", index);
            int lastIndex = dna.indexOf("TAA", firstIndex);
            if (firstIndex == -1 || lastIndex == -1){
                break;
            }else{
                count += 1;
            }
            index = lastIndex + 3;
        }
        return count;
    }

    public void testCountGenes() {
        System.out.println(countGenes("ATGGGTTTATAAATGAAGGTTAAAAGGTTATGAATGGTAGTAAA"));
        System.out.println(countGenes("ATGTAAGATGCCCTAAGT"));
    }

    public static void main(String[] args) {
        Part3 obj = new Part3();
        obj.testCountGenes();
    }
}