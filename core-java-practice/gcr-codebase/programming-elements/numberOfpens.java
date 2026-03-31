public class numberOfpens {
    public static void main(String[] args) {
        int Pens = 14;
        int student = 3;

        int pensPerStudent = Pens / student;
        int remainingPens = Pens % student;

        System.out.println("The Pen Per Student is " + pensPerStudent + " and the remaining pen not distributed is " + remainingPens);
    }
}
