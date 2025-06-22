package telran.employee.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.employee.dao.Company;
import telran.employee.dao.CompanyImpl;
import telran.employee.model.Employee;
import telran.employee.model.Manager;
import telran.employee.model.SalesManager;
import telran.employee.model.WageEmployee;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {
    Company company;
    Employee[] firm;

    @BeforeEach
    void setUp() {
        company = new CompanyImpl(5);
        firm = new Employee[4];
        firm[0] = new Manager(1000, "John", "Smith", 180, 20_000, 20);
        firm[1] = new WageEmployee(2000, "Mary", "Smith", 180, 50);
        firm[2] = new SalesManager(3000, "Peter", "Jackson", 180, 100_000, 0.05);
        firm[3] = new SalesManager(4000, "Tigran", "Petrosian", 90, 500_000, 0.1);
        for (int i = 0; i < firm.length; i++) {
            company.addEmployee(firm[i]);
        }
    }

    @Test
    void addEmployee() {
        assertFalse(company.addEmployee(firm[3]));
        Employee employee = new SalesManager(5000, "Andy", "Jackson", 90, 40_000, 0.1);
        assertTrue(company.addEmployee(employee));
        assertEquals(5, company.size());
        employee = new SalesManager(6000, "Andy", "Jackson", 90, 40_000, 0.1);
        assertFalse(company.addEmployee(employee));
    }

    @Test
    void removeEmployee() {

        assertNull(company.removeEmployee(123));
        assertEquals(company.removeEmployee(2000),firm[1]);

    }

    @Test
    void findEmployee() {
        assertNull(company.findEmployee(123));
        assertEquals(company.findEmployee(2000),firm[1]);
    }

    @Test
    void totalSalary() {
        double total = 89080;
             assertEquals(total, company.totalSalary());
    }

    @Test
    void averageSalary() {
        double average = 89080/4;
        assertEquals(average, company.averageSalary());
    }

    @Test
    void size() {
        assertEquals(4, company.size());
    }

    @Test
    void printEmployees() {
        String expected = "Employee{id=1000, firstName='John', lastName='Smith', hours=180.0}\n" +
                "Employee{id=2000, firstName='Mary', lastName='Smith', hours=180.0}\n" +
                "Employee{id=3000, firstName='Peter', lastName='Jackson', hours=180.0}\n" +
                "Employee{id=4000, firstName='Tigran', lastName='Petrosian', hours=90.0}\n";
        PrintStream consoleStream = System.out;
        OutputStream testStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testStream));

        company.printEmployees();

        assertEquals(expected,testStream.toString());
        System.setOut(consoleStream);
        return;
    }

    @Test
    void totalSales() {
        assertEquals(600_000.,company.totalSales());
    }
}