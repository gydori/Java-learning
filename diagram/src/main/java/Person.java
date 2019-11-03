import java.util.Arrays;

public class Person {
    private int id;
    private String name;
    private boolean permanent;
    private Address address;
    private int[] phoneNumbers;
    private String role;
    private String[] cities;
    private Properties properties;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public Address getAddress() {
        return address;
    }

    public int[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getRole() {
        return role;
    }

    public String[] getCities() {
        return cities;
    }

    public Properties getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", permanent=" + permanent +
                ", address=" + address +
                ", phoneNumbers=" + Arrays.toString(phoneNumbers) +
                ", role='" + role + '\'' +
                ", cities=" + Arrays.toString(cities) +
                ", properties=" + properties +
                '}';
    }
}
