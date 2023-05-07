package customer;

public class Address {
    private String line1;
    private String city;
    private String zip;

    //CREATION

    @Override
    public String toString() {
        return
                 line1 + '\'' +
                city + '\'' +
                zip;
    }

    public Address(String line1, String city, String zip) {
        super();    //원래는 있지만 생략해도됨.
        this.line1 = line1;
        this.city = city;
        this.zip = zip;
    }
}
