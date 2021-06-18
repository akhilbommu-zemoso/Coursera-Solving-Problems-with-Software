package ThirdStringsAssignments;

public class Part2 {
    public float cgRatio(String dna) {
        int count = 0;
        for(int i=0;i<dna.length();i++) {
            if(dna.charAt(i) == 'C' || dna.charAt(i) == 'G') {
                count += 1;
            }
        }
        return (float)count/dna.length();
    }

    public int countCTG(String dna) {
        int count = 0, index = 0;
        while(true){
            index = dna.indexOf("CTG",index);
            if(index == -1) {
                break;
            }
            count += 1;
            index = index + 3;
            if(index >= dna.length()) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Part2 obj = new Part2();
        System.out.println("cgRatio: " + obj.cgRatio("ATGCCATAG"));
        System.out.println("CTG Count: " + obj.countCTG("ACTGGGCTGGACTG"));
    }
}