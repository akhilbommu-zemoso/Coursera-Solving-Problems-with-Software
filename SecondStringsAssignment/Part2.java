package SecondStringsAssignment;

public class Part2{
    public int howMany(String a,String b) {
        int count = 0, index = 0;
        while (true){
            int tempIndex = b.indexOf(a, index);
            if (tempIndex == -1){
                break;
            }
            count += 1;
            index = tempIndex + a.length();
            if (index >= b.length())
                break;
        }
        return count;
    }
    public void testHowMany(){
        System.out.println(howMany("GAA","ATGAACGAATTGAATC"));
        System.out.println(howMany("AA","ATAAAA"));
        System.out.println(howMany("A","AAAA"));
    }

    public static void main(String[] args) {
        Part2 obj = new Part2();
        obj.testHowMany();
    }
}
