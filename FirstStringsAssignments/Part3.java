package FirstStringsAssignments;

public class Part3 {
    public boolean twoOccurrences(String a,String b){
        int index = b.indexOf(a);
        int count = 0;
        while (index != -1) {
            count++;
            b = b.substring(index + 1);
            index = b.indexOf(a);
        }
        return count >= 2;
    }

    public String lastPart(String a, String b){
        int index = b.indexOf(a);
        if(index == -1){
            return b;
        }
        return b.substring(index + a.length());
    }

    public void testing(){
        System.out.println(twoOccurrences("by", "A story by Abby Long"));
        System.out.println(twoOccurrences("a", "banana"));
        System.out.println(twoOccurrences("atg", "ctgtatgta"));

        System.out.println(lastPart("an","banana"));
        System.out.println(lastPart("zoo","forest"));
    }

}
class Driver3{
    public static void main(String[] args){
        Part3 obj = new Part3();
        obj.testing();
    }
}
