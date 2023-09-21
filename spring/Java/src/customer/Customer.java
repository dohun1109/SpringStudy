package customer;

public class Customer {
    //state
    private String name;
    private Address HomeAddress;
    private Address WorkAddress;

    //creating
    public Customer(String name, Address HomeAddress) {
        this.name = name;
        this.HomeAddress = HomeAddress;
    }

    //operations

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", HomeAddress=" + HomeAddress +
                ", WorkAddress=" + WorkAddress +
                '}';
    }

    public Address getHomeAddress() {
        return HomeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        HomeAddress = homeAddress;
    }

    public Address getWorkAddress() {
        return WorkAddress;
    }

    public void setWorkAddress(Address workAddress) {
        WorkAddress = workAddress;
    }
}
