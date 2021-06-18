package SecondStringsAssignment;

public class Part1 {
    public int findStopCodon(String dna,int startIndex,String stopCodon) {
        int index= dna.indexOf(stopCodon,startIndex);
        if ((index-startIndex) % 3 == 0)
            return index;
        else
            return dna.length();
    }
    public void testFindStopCodon(){
        System.out.println(findStopCodon("CTCGTAAGGGCGTCTGGCCCGTCTCTATGCCTCGATGAGCCGAGCACGTAGG",3,"AAG"));
        System.out.println(findStopCodon("CTCGTAAGGGCGTCTGGCCCGTCTTATGCCTGATGAGCCGAGCACGTAGG",7,"ATG"));
        System.out.println(findStopCodon("'CTCGTAAGGGCGTCTGGCCCGTCTTATGCCTGATGAGCCGAGCACGTAGG'",11,"CTC"));
        System.out.println(findStopCodon("ATGCCCTAA",0,"TAA"));
    }
    public String findGene(String dna){
        int firstIndex = dna.indexOf("ATG");
        if(firstIndex == -1)
            return "";
        else{
            int indexTAA = findStopCodon(dna,firstIndex,"TAA");
            int indexTAG = findStopCodon(dna,firstIndex,"TAG");
            int indexTGA = findStopCodon(dna,firstIndex,"TGA");
            int endIndex = Math.min(indexTGA,Math.min(indexTAG,indexTAA));
            if(endIndex == dna.length())
                return "";
            return dna.substring(firstIndex, endIndex + 3);
        }
    }
    public void testFindGene() {
        System.out.println(findGene("ATTAGTAGG"));
        System.out.println(findGene("AATGGGTAGA"));
        System.out.println(findGene("AAATTTGGGTAAA"));
        System.out.println(findGene("AATGAATGGGTAAA"));

    }
    public void printAllGenes(String dna) {
        int index = 0;
        while (true){
            int firstIndex = dna.indexOf("ATG",index);
            int lastIndex = dna.indexOf("TAA",firstIndex);
            if(firstIndex == -1 || lastIndex == -1)
                break;
            else
                System.out.println(dna.substring(firstIndex,lastIndex+3));
            index = lastIndex + 3;
        }
    }

    public static void main(String[] args) {
        Part1 obj = new Part1();
        obj.testFindStopCodon();
        obj.testFindGene();
        obj.printAllGenes("AATGAATTGGTAAATGGGTTAAAATTGTATAAA");
    }
}