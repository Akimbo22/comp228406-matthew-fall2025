//Matthew Elliott - 301424215
//September 18, 2025
// Lab #1

package ex1;

public class Exercise1 {
    // Variables:
    private int id;
    private String name;
    private String address;
    private String dob;
    private int numAlbums;

    // Constructors:
    public Exercise1() {
        this.id = 0;
        this.name = "default";
        this.address = "default";
        this.dob = "YYYY/MM/DD";
        this.numAlbums = 0;
    }
    public Exercise1(int id, String name, String address, String dob, int numAlbums) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.numAlbums = numAlbums;
    }

    // Setters:
    public void setID(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setDOB(String dob) { this.dob = dob; }
    public void setNumAlbums(int numAlbums) { this.numAlbums = numAlbums; }

    // Getters:
    public int getID() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getDOB() { return dob; }
    public int getNumAlbums() { return numAlbums; }
}
