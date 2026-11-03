import entities.Employee;
import services.Company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Company company = new Company();
        int option;

        do {
            System.out.println("\n=== COMPANY SYSTEM ===");
            System.out.println("1. Add employee");
            System.out.println("2. Remove employee");
            System.out.println("3. List employees");
            System.out.println("4. Calculate total payroll");
            System.out.println("5. Find highest paid employee");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Employee name: ");
                    String name = sc.nextLine();

                    System.out.print("Employee role: ");
                    String role = sc.nextLine();

                    System.out.print("Employee salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();

                    Employee employee = new Employee(name, role, salary);
                    company.addEmployee(employee);

                    System.out.println("Employee added successfully.");
                    break;

                case 2:
                    System.out.print("Employee name: ");
                    name = sc.nextLine();

                    Employee found = null;

                    for (Employee item : company.employees) {
                        if (item.getName().equalsIgnoreCase(name)) {
                            found = item;
                            break;
                        }
                    }

                    if (found != null) {
                        company.removeEmployee(found);
                        System.out.println("Employee removed successfully.");
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 3:
                    if (company.employees.isEmpty()) {
                        System.out.println("No employees registered.");
                    } else {
                        for (Employee item : company.employees) {
                            System.out.println(item);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Total payroll: R$ " + company.calculateTotalPayroll());
                    break;

                case 5:
                    Employee highestPaid = company.findHighestPaidEmployee();

                    if (highestPaid != null) {
                        System.out.println("Highest paid employee: " + highestPaid);
                    } else {
                        System.out.println("No employees registered.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 0);

        sc.close();
    }
}