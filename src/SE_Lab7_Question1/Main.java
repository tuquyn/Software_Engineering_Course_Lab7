package SE_Lab7_Question1;

public class Main{
    private static CarParkSystem test;
    public Main(){
        test = new CarParkSystem();
    }

    public static void main(String[] args) {
        new Main();
        // add an Employee
        test.addEmployee("01","An","0123456");
        test.addEmployee("01","Bao","0465678");
        test.addEmployee("02","Bao","0465678");
        test.addEmployee("03","Cuong","7894561");
        System.out.println(test);

        // change number employee
        test.changeNumberEmployee("02","9788754");
        test.changeNumberEmployee("04","4678978");
        System.out.println(test);

        // add a permit
        test.addPermit("1","999","01");
        test.addPermit("22","99","01");
        test.addPermit("333","9","03");
        test.addPermit("465","123","01");
        System.out.println(test);

        // delete employee
//        test.deleteEmployee("01");
        test.deleteEmployee("02");
        System.out.println(test);

        // Terminate a permit
//        test.terminatePermit("22");
        System.out.println(test);

        // Replace a permit
        test.replacePermit("333","123","12345", "1");
        System.out.println(test);

        // Print owner with a permit number
        test.printOwnerPermit("333");
        test.printOwnerPermit("123");

        // Print all permits
        test.printAllPermits();
    }
}