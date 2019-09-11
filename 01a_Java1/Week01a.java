/**
 * main
 *
 * This is the in-class demo from the first lecture
 * 
 * @author Randy Fortier
 * @date September 9, 2019
 */
public class Week01a {
    static boolean teamEvil = true;
    int hp = 10;

    /**
     * main
     * 
     * The entry point for the program
     *
     * @arg args The command-line arguments
     */
     public static void main(String[] args) {
         System.out.println("teamEvil = " + teamEvil);
         //System.out.println("hp = " + hp);

         int age = 21;
         long accountBalance = 100000000000L;
         float gpa = 4.0f;
         double measurement = 0.000743;

         Integer age2 = 20;

         String name = "Randy";
         String ageStr = "20 years old";
         try {
            age = Integer.parseInt(ageStr);
            // success
         } catch (NumberFormatException e) {
            // failure
            e.printStackTrace();
         } catch (Exception e) {
            // failure
            e.printStackTrace();
         } finally {
            // success and failure
         }
         System.out.printf("Your age is %d.\n", age);

         age = 17;
         String rank = "Officer";
         if ((age >= 19) || (rank == "Officer")) {
             System.out.println("Ok to go");
         } else if (age > 12) {
             System.out.println("None for you!");
         } else {
             System.out.println("Get out of here, kid!");
         }

         age = 21;
         switch(age) {
             case 18:
                System.out.println("Vote!");
                break;
             case 16:
                System.out.println("Drive!");
                break;
             default:
                System.out.println("...");
         }

         String status = "subs";
         String nickname = (status == "subs") ? "Friend" : "Stranger";

         int numIterations = 4;
         while (numIterations > 0) {
             System.out.println("While");
             numIterations--;
         }

         numIterations = 4;
         do {
            System.out.println("DoWhile");
            numIterations--;
         } while (numIterations > 0);

         numIterations = 4;
         for (int i = 0; i < numIterations; i++) {
            System.out.println("For");
         }

         float[] marks = new float[] {13.0f, 8.0f, 15.0f};
         for (float m : marks) {
            System.out.println("m: " + m);
         }
     }
}