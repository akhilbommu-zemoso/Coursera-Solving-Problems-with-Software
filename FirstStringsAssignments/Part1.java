package FirstStringsAssignments;

public class Part1 {
    public String findSimpleGene(String dna){
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1){
            return "";
        }
        int stopIndex = dna.indexOf("TAA",startIndex+3);
        if(stopIndex == -1){
            return "";
        }
        //System.out.println(startIndex + " " + stopIndex);
        if((stopIndex-startIndex) % 3 == 0)
            result = dna.substring(startIndex, stopIndex+3);
        return result;
    }
    public void testSampleGene(){
        String dna1 = "AGCTGACATCGTGACTAA";
        System.out.println("DNA String : "+ dna1);
        System.out.println("Gene is : " + findSimpleGene(dna1));
        String dna2 = "AGCTGACATCGTGACATG";
        System.out.println("DNA String : "+ dna2);
        System.out.println("Gene is : " + findSimpleGene(dna2));
        String dna3 = "AGCTGACATCGTGACTGATCGAT";
        System.out.println("DNA String : "+ dna3);
        System.out.println("Gene is : " + findSimpleGene(dna3));
        String dna4 = "AGCATGACATCGTGATAA";
        System.out.println("DNA String : "+ dna4);
        System.out.println("Gene is : " + findSimpleGene(dna4));
        String dna5 = "AGCATGACATCTGTGATAA";
        System.out.println("DNA String : "+ dna5);
        System.out.println("Gene is : " + findSimpleGene(dna5));
    }
}
class Driver1{
    public static void main(String[] args){
        Part1 obj = new Part1();
        obj.testSampleGene();
    }
}