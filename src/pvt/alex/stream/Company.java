package pvt.alex.stream;

import java.util.List;

public class Company {

    private String companyName;
    private List<Person> employees;

    Company (String companyName, List<Person> employees){
        this.companyName = companyName;
        this.employees = employees;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Person> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Person> employees) {
        this.employees = employees;
    }
}
