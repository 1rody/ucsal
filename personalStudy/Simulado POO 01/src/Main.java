import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //no main nao preicos usar public ou priv para delcarar o array de funcionarios
        ArrayList<Employee> employees = new ArrayList<>();


        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("=====Insira a acao que deseja fazer=======");
            System.out.println("  ");
            System.out.println("===== 0 - Cadastrar funcionarior =======");
            System.out.println("===== 1 - Ver lista de funcionarios ======");
            System.out.println("===== 2 - Ver salario de funcionario =======");
            System.out.println("===== 3 - Sair =======");
            System.out.println("  ");
            System.out.println("Digite o numero:");

            int menuAction = sc.nextInt();

            switch (menuAction) {
                case 0:
                    System.out.println("  ");
                    System.out.println("  ");
                    System.out.println("  ");

                    System.out.println("===== CADASTRO =======");
                    System.out.println("  ");
                    System.out.println("Informe o tipo de funcionario:");
                    System.out.println("Comun: 1");
                    System.out.println("terceirizado: 2");

                    int employeetype = sc.nextInt();

                    if ( (employeetype > 2) || (employeetype <= 0)){
                        System.out.println("Valor invalido, favor informe um valor entre 1 e 2 para i tipo de funcionario.");
                        employeetype = sc.nextInt();

                        while ((employeetype > 2) || (employeetype <= 0)) {
                            System.out.println("Valor invalido, favor informe um valor entre 1 e 2 para i tipo de funcionario.");
                            employeetype = sc.nextInt();
                        }
                    }
                    System.out.println("Informe o ID:");
                    Integer id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Informe o nome:");
                    String name = sc.nextLine();

                    System.out.println("Informe as horas trabalhadas:");
                    double hours = sc.nextDouble();

                    System.out.println("Informe o valor por hora:");
                    double valuePerHour = sc.nextDouble();



                    Employee employee;

                    if (employeetype == 1) {
                        employee = new Employee(id, name, hours, valuePerHour);

                    } else {
                        System.out.println("Informe a taxa adicional:");
                        double additionalCharge = sc.nextDouble();

                        employee = new OutsourcedEmployee(
                                id, name, hours, valuePerHour, additionalCharge
                        );
                    }

                    employees.add(employee);
                    System.out.println("Funcionario cadastrado com sucesso!");

                    break;
                case 1:
                    if (employees.isEmpty()) {
                        System.out.println("Nenhum funcionario cadastrado.");
                    } else {
                        System.out.println("===== FUNCIONARIOS CADASTRADOS =====");

                        for (Employee employee : employees) {
                            System.out.println("ID: " +employee.getId());
                            System.out.println("Nome: " +employee.getName());
                            System.out.println("Valor por hora: " +employee.getValuePerHour());
                            System.out.println("Horas: " +employee.getHours());
                            System.out.println("Pagamento: " + employee.payment());
                        }
                    }
                    break;
                case 2:
                    System.out.println("===== CONSULTAR POR ID =======");
                    System.out.println("Insira o id:");
                    int idemp = sc.nextInt();

                    boolean found = false;

                    for (Employee employee : employees) {
                        if (employee.getId() == idemp) {
                            System.out.println("ID: " +employee.getId());
                            System.out.println("Nome: " +employee.getName());
                            System.out.println("Valor por hora: " +employee.getValuePerHour());
                            System.out.println("Horas: " +employee.getHours());
                            System.out.println("Pagamento: " + employee.payment());
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Funcionario nao encontrado na base de dados.");

                    }

                    break;
                case 3:
                    System.out.println("Saindo do sistema...");
                    running = false;

                    break;
            }
        }
        System.out.println("Rode novamente para votlar ao menu de opcoes..,");
    }
}