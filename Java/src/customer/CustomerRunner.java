package customer;

public class CustomerRunner {
    public static void main(String[] args) {
        Address homeAddress = new Address("line 1","Hyderabad","500045");
        Customer customer = new Customer("Ranga",homeAddress);

        Address workAddress = new Address("line 1 for work","Hyderabad","500045");
        customer.setWorkAddress(workAddress);
        System.out.println(customer);



    }
}
