package FirstStringsAssignments;

public class Part2 {
    public String findSimpleGene(String dna,String startCodon, String stopCodon){
        String result = "";
        int startIndex = dna.indexOf(startCodon);
        if(startIndex == -1){
            return "";
        }
        int stopIndex = dna.indexOf(stopCodon,startIndex+3);
        if(stopIndex == -1){
            return "";
        }
        //System.out.println(startIndex + " " + stopIndex);
        if((stopIndex-startIndex) % 3 == 0)
            result = dna.substring(startIndex, stopIndex+3);
        return result;
    }
    public void testSampleGene(){
        String dna1 = "ATGGGTTAAGTC";
        System.out.println("DNA String : "+ dna1);
        System.out.println("Gene is : " + findSimpleGene(dna1,"ATG","TAA"));
        String dna2 = "gatgctataat";
        System.out.println("DNA String : "+ dna2);
        System.out.println("Gene is : " + findSimpleGene(dna2,"atg","taa"));
        String dna3 = "ATGTAA";
        System.out.println("DNA String : "+ dna3);
        System.out.println("Gene is : " + findSimpleGene(dna3,"ATG","TAA"));
    }
}

class Driver2{
    public static void main(String[] args){
        Part2 obj = new Part2();
        obj.testSampleGene();
    }
}
