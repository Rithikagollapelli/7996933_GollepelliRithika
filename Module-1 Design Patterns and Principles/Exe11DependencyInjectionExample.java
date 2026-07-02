// DependencyInjectionExample.java

// Repository Interface
interface CustomerRepository {
    String findCustomerById(int id);
}

// Concrete Repository
class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public String findCustomerById(int id) {

        if (id == 101) {
            return "Rithika";
        } else if (id == 102) {
            return "Rahul";
        } else {
            return "Customer Not Found";
        }
    }
}

// Service Class
class CustomerService {

    private CustomerRepository customerRepository;

    // Constructor Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void getCustomerDetails(int id) {
        String customer = customerRepository.findCustomerById(id);
        System.out.println("Customer ID   : " + id);
        System.out.println("Customer Name : " + customer);
    }
}

// Main Class
public class Exe11DependencyInjectionExample {

    public static void main(String[] args) {

        // Dependency Injection
        CustomerRepository repository =
                new CustomerRepositoryImpl();

        CustomerService service =
                new CustomerService(repository);

        service.getCustomerDetails(101);

        System.out.println();

        service.getCustomerDetails(102);

        System.out.println();

        service.getCustomerDetails(103);
    }
}