package Data.Client;

public class Client {
    private int id;
    private String name;
    private String email;
    private String password;

    // Constructor
    public Client(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // Common methods for viewing profile
    public void viewProfile() {
        System.out.println("Profile:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}
