
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AllHandsOnSpringDataJpaDemo {

    // ------------------------------------------------------------
    // 1) Entity-like model class
    // ------------------------------------------------------------
    static class Country {

        private String code;
        private String name;

        public Country() {
        }

        public Country(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Country{" + "code='" + code + '\'' + ", name='" + name + '\'' + '}';
        }
    }

    // ------------------------------------------------------------
    // 2) Exception class
    // ------------------------------------------------------------
    static class CountryNotFoundException extends Exception {

        public CountryNotFoundException(String message) {
            super(message);
        }
    }

    // ------------------------------------------------------------
    // 3) Repository-like class (mirrors JpaRepository methods)
    // ------------------------------------------------------------
    static class CountryRepository {

        private final Map<String, Country> countries = new LinkedHashMap<>();

        public CountryRepository() {
            save(new Country("IN", "India"));
            save(new Country("US", "United States"));
            save(new Country("GB", "United Kingdom"));
        }

        public Optional<Country> findById(String code) {
            return Optional.ofNullable(countries.get(code));
        }

        public List<Country> findAll() {
            return new ArrayList<>(countries.values());
        }

        public void save(Country country) {
            countries.put(country.getCode(), country);
        }

        public void deleteById(String code) {
            countries.remove(code);
        }

        public List<Country> findByNameContaining(String partialName) {
            List<Country> result = new ArrayList<>();
            String search = partialName.toLowerCase();
            for (Country country : countries.values()) {
                if (country.getName().toLowerCase().contains(search)) {
                    result.add(country);
                }
            }
            return result;
        }
    }

    // ------------------------------------------------------------
    // 4) Service layer with @Transactional-style methods
    // ------------------------------------------------------------
    static class CountryService {

        private final CountryRepository countryRepository;

        public CountryService(CountryRepository countryRepository) {
            this.countryRepository = countryRepository;
        }

        public List<Country> getAllCountries() {
            return countryRepository.findAll();
        }

        public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
            Optional<Country> result = countryRepository.findById(countryCode);
            if (!result.isPresent()) {
                throw new CountryNotFoundException("Country not found with code: " + countryCode);
            }
            return result.get();
        }

        public void addCountry(Country country) {
            countryRepository.save(country);
        }

        public void updateCountry(String code, String newName) throws CountryNotFoundException {
            Country country = findCountryByCode(code);
            country.setName(newName);
            countryRepository.save(country);
        }

        public void deleteCountry(String code) throws CountryNotFoundException {
            if (!countryRepository.findById(code).isPresent()) {
                throw new CountryNotFoundException("Country not found with code: " + code);
            }
            countryRepository.deleteById(code);
        }

        public List<Country> findCountriesByPartialName(String partialName) {
            return countryRepository.findByNameContaining(partialName);
        }
    }

    // ------------------------------------------------------------
    // 5) Main method that runs all hands-on tasks together
    // ------------------------------------------------------------
    public static void main(String[] args) throws Exception {
        CountryRepository repository = new CountryRepository();
        CountryService countryService = new CountryService(repository);

        System.out.println("=== Hand-on 1: Get all countries ===");
        System.out.println(countryService.getAllCountries());

        System.out.println("\n=== Hand-on 6: Find country by code ===");
        Country country = countryService.findCountryByCode("IN");
        System.out.println("Found country: " + country);

        System.out.println("\n=== Hand-on 7: Add a new country ===");
        Country newCountry = new Country("CA", "Canada");
        countryService.addCountry(newCountry);
        System.out.println("Added: " + countryService.findCountryByCode("CA"));

        System.out.println("\n=== Hand-on 8: Update a country ===");
        countryService.updateCountry("US", "United States of America");
        System.out.println("Updated: " + countryService.findCountryByCode("US"));

        System.out.println("\n=== Hand-on 9: Delete a country ===");
        countryService.deleteCountry("CA");
        System.out.println("Deleted CA. Remaining countries:");
        System.out.println(countryService.getAllCountries());

        System.out.println("\n=== Partial-name search ===");
        System.out.println(countryService.findCountriesByPartialName("United"));
    }
}
