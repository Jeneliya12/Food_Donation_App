package Data.models;

public class User {
    protected int id;
    protected String name;
    protected String email;
    protected String password;

    // Constructor
    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getter for ID
    public int getId() {
        return id;  // Add this method to retrieve the ID
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void viewProfile() {
        System.out.println("User Profile:");
        System.out.println("ID: " + getId());  // Optionally display ID
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
    }
}
