package telran.employee.dao;

import telran.employee.model.Employee;
import telran.employee.model.SalesManager;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CompanyImpl implements Company {
    Employee[] employees;
    int size;

    public boolean full(){
        return size >= employees.length;
    }

    public CompanyImpl(int capacity) {
        employees = new Employee[capacity];
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if(full())
            return false;
        for(int i = 0;i<size;i++){
            if(employees[i].getId() == employee.getId())
                return false;
//            if(employees[i].getFirstName().equals(employee.getFirstName()) && employees[i].getLastName().equals(employee.getLastName()))
//                return false;
        }

        employees[size] = employee;
        size++;
        return true;
    }

    @Override
    public Employee removeEmployee(int id) {

        for(int i = 0;i<size;i++) {
            if (employees[i].getId() == id) {
                    Employee res = employees[i];
                    size--;
                    employees[i] = employees[size];
                    employees[size] = null;
                    return res;
            }
        }
        return null;
    }

    @Override
    public Employee findEmployee(int id) {
        for(int i = 0; i<size;i++){
            if(employees[i].getId() == id)
                return employees[i];
        }
        return null;
    }

    @Override
    public double totalSalary() {
        double summ = 0;
        for(int i = 0; i<size;i++){
            summ += employees[i].calcSalary();
        }
        return summ;
    }

    @Override
    public double averageSalary() {
        return totalSalary()/size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printEmployees() {

        for(int i = 0; i<size;i++){
            System.out.println(employees[i]);
        }

    }

    @Override
    public double totalSales() {
        Double summ = 0.;

        for(int i = 0; i<size;i++){
            if( employees[i] instanceof SalesManager ){
                SalesManager sm = (SalesManager)(employees[i]);
                summ += sm.getSalesValue();
            }
        }
        return summ;
    }
}
