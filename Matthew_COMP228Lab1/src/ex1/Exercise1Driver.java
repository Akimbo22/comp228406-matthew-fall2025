//Matthew Elliott - 301424215
//September 18, 2025
// Lab #1

package ex1;

public class Exercise1Driver {
    public static void main(String[] args) {
        //Initial singer object declaration:
        Exercise1 singer1 = new Exercise1();

        System.out.println("The default ID is: " + singer1.getID());
        System.out.println("The default name is: " + singer1.getName());
        System.out.println("The default address is: " + singer1.getAddress());
        System.out.println("The default date of birth is: " + singer1.getDOB());
        System.out.println("The default number of published albums is: " + singer1.getNumAlbums());
        System.out.println();

        //New singer object with set values:
        Exercise1 singer2 = new Exercise1(123456789, "Paul McCartney", "7 Cavendish Avenue", "1942/06/18", 26);

        System.out.println("The singer's ID is: " + singer2.getID());
        System.out.println("The singer's name is: " + singer2.getName());
        System.out.println(singer2.getName() + "'s address is: " + singer2.getAddress());
        System.out.println(singer2.getName() + "'s birth date is: " + singer2.getDOB());
        System.out.println(singer2.getName() + " has " + singer2.getNumAlbums() + "studio albums.");
        System.out.println();

        //Using setters to edit the values, then getting them again:
        singer2.setID(987654321);
        singer2.setName("Michael Jackson");
        singer2.setAddress("Neverland Ranch");
        singer2.setDOB("1958/08/29");
        singer2.setNumAlbums(10);

        System.out.println("The singer's ID is: " + singer2.getID());
        System.out.println("The singer's name is: " + singer2.getName());
        System.out.println(singer2.getName() + "'s address is: " + singer2.getAddress());
        System.out.println(singer2.getName() + "'s birth date is: " + singer2.getDOB());
        System.out.println(singer2.getName() + " has " + singer2.getNumAlbums() + "studio albums.");
    }
}
