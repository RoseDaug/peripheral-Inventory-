import java.util.Scanner;
import java.util.ArrayList;


public class WorkplacePeripheral {
    private String Ptype;
    private String Pcode;
    private String Pname;
    private String employee;
    private boolean availableP;

    public WorkplacePeripheral(String Ptype, String Pname, String Pcode,boolean availableP){
        this.Ptype = Ptype;
        this.Pname = Pname;
        this.Pcode = Pcode;
        this.availableP = availableP;

    }


    public String getPeripheralType(){
        return Ptype;
    }
    public String getPeripheralName(){
        return Pname;
    }
    public String getPeripheralCode(){
        return Pcode;
    }
    public String getEmployeePeripheral(){
        return employee;
    }
    public boolean isPAvailable(){
        return availableP;
    }


  

    public void setPType(String Ptype){
        this.Ptype = Ptype;
    }
    public void setPName(String Pname){
        this.Pname = Pname;
    }
    public void setPCode(String Pcode){
        this.Pcode = Pcode; 
    }
    public void setPEmployee(String employee){
        this.employee = employee;
    }
    public void setPAvailability(boolean availableP){
        this.availableP = availableP;
    }
    
}

class PeripheraInventory{
    private ArrayList<WorkplacePeripheral> peripheralList = new ArrayList<WorkplacePeripheral>();
    private ArrayList<String> employees = new ArrayList<String>();
    private Scanner sc = new Scanner(System.in);

 
    public void addPeripheral(){
        System.out.println("ENTER TYPE ");
        System.out.println("Enter input for input peripherals");
        System.out.println("Enter output for output peripherals");
        System.out.println("Enter both if peripheral is both an input and output peripherals");
        System.out.print(": ");
        String Ptype =sc.nextLine();
        System.out.println("Enter Peripheral Name: ");
        String Pname =sc.nextLine();
        System.out.println("Enter Peripheral Code");
        String Pcode = sc.nextLine();
        peripheralList.add(new WorkplacePeripheral(Ptype, Pname, Pcode, true));

    }

    public void PeripheraltoEmployee(){
        System.out.println("ASSIGN PERIPHERAL TO EMPLOYEE");
        System.out.print("Enter employee name: ");
        String employee =sc.nextLine();

        if(!employees.contains(employee)){
            employees.add(employee);

        }
        System.out.println("Enter Peripheral Code: ");
        String Pcode = sc.nextLine();
        for(WorkplacePeripheral peripheral : peripheralList){
            if(peripheral.getPeripheralCode().equals(Pcode)) {
                peripheral.setPEmployee(employee);
                peripheral.setPAvailability(false);
                break;
            }
        }

    }

    public void viewAllPeripherals(){
        System.out.println("ALL PERIPHERALS");
        for(WorkplacePeripheral peripheral : peripheralList){
            System.out.println("Type: " + peripheral.getPeripheralType());
            System.out.println("Name: " + peripheral.getPeripheralName());
            System.out.println("Code: " + peripheral.getPeripheralCode());
            System.out.println("Employee: " + peripheral.getEmployeePeripheral());
            System.out.println("Availability: " + peripheral.isPAvailable());
        }
    }

    public void viewAllAvailablePeripherals(){
                System.out.println("AVAILABLE PERIPHERALS ");
        for(WorkplacePeripheral peripheral : peripheralList) {
            if(peripheral.isPAvailable()){
                System.out.println("Type: " + peripheral.getPeripheralType());
                System.out.println("Name: " + peripheral.getPeripheralName());
                System.out.println("Code: " + peripheral.getPeripheralCode());
            } 
         }
    }

    public void viewNotAvailablePeripherals(){
                System.out.println("UNVAILABLE PERIPHERALS");
        for(WorkplacePeripheral peripheral : peripheralList){
            if(!peripheral.isPAvailable()){
                System.out.println("Type: " + peripheral.getPeripheralType());
                System.out.println("Name: " + peripheral.getPeripheralName());
                System.out.println("Code: " + peripheral.getPeripheralCode());
                System.out.println("Employee: " + peripheral.getEmployeePeripheral());
            }
        }

    }

    public void viewAllInputPeripherals(){
                System.out.println("INPUT DEVICES");
         for(WorkplacePeripheral peripheral : peripheralList){
            if(peripheral.getPeripheralType().equals("input")){
                System.out.println("Name: " + peripheral.getPeripheralName());
                System.out.println("Code: " + peripheral.getPeripheralCode());
                System.out.println( "Eployee: " + peripheral.getEmployeePeripheral());
                System.out.println("Availabilty: " + peripheral.isPAvailable());
            }  
         }
    }

    public void viewAllOutputPeripherals(){
            System.out.println("OUTPUT DEVICES");
        for(WorkplacePeripheral peripheral : peripheralList){
            if(peripheral.getPeripheralType().equals("output")){
                System.out.println("Name: " + peripheral.getPeripheralName());    
                System.out.println("Code: " + peripheral.getPeripheralCode());
                System.out.println("Eployee: " + peripheral.getEmployeePeripheral());
                System.out.println("Availabilty: " + peripheral.isPAvailable());

            }
        }
    }

    public void viewAllInputOutputPeripherals(){
           System.out.println("INPUT/OUTPUT DEVICES");
        for(WorkplacePeripheral peripheral : peripheralList){
            if(peripheral.getPeripheralType().equals("both")){  
                System.out.println("Name: " + peripheral.getPeripheralName());
                System.out.println("Code: " + peripheral.getPeripheralCode());
                System.out.println("Eployee: " + peripheral.getEmployeePeripheral());
                System.out.println( "Availabilty: " + peripheral.isPAvailable());
                
            }
        }
    }

    public void viewAllEmployee(){
            System.out.println("EMPLOYEE/S");
        for(String employee : employees){
            System.out.println(employee);
        }
    }

    public void editPeripheralInfo(){
        System.out.println("EDIT PERIPHERAL INFO ");
        System.out.println("Enter Peripheral code: ");
        String code = sc.nextLine();
        for(WorkplacePeripheral peripheral : peripheralList){
            if(peripheral.getPeripheralCode().equals(code)){
                System.out.println("Enter new type: ");
                peripheral.setPType(sc.nextLine());
                System.out.println("Enter new name: ");
                peripheral.setPName(sc.nextLine());
                System.out.println("Enter new Code: ");
                peripheral.setPCode(sc.nextLine());
                break;

            }
        }
    }

    public void deletePeripheral(){
        System.out.println("DELETE PERIPHERAL");
        System.out.println("Enter peripheral code: ");
        String code = sc.nextLine();
        for(WorkplacePeripheral peripheral : peripheralList){
            if(peripheral.getPeripheralCode().equals(code)){
                peripheralList.remove(peripheral);
                break;
            }
        }

    }




    public static void main(String[] args) {
        PeripheraInventory inventory = new PeripheraInventory();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("WORKPLACE PERIPHERAL INVENTORY");
            System.out.println("1. Add a peripheral");
            System.out.println("2. Add peripheral to employee");
            System.out.println("3. View all peripherals");
            System.out.println("4. View available peripherals");
            System.out.println("5. View not available peripherals");
            System.out.println("6. View all input devices");
            System.out.println("7. View all output devices");
            System.out.println("8. View all input/output devices");
            System.out.println("9. View all employees");
            System.out.println("10. Edit peripheral record");
            System.out.println("11. Delete peripheral");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt(); 
            scanner.nextLine();

            switch(choice){
                case 1:
                inventory.addPeripheral();
                break;
                case 2:
                inventory.PeripheraltoEmployee();
                break;
                case 3:
                inventory.viewAllPeripherals();
                break;
                case 4:
                inventory.viewAllAvailablePeripherals();
                break;
                case 5:
                inventory.viewNotAvailablePeripherals();
                break;
                case 6:
                inventory.viewAllInputPeripherals();
                break;
                case 7:
                inventory.viewAllOutputPeripherals();
                break;
                case 8:
                inventory.viewAllInputOutputPeripherals();
                break;
                case 9:
                inventory.viewAllEmployee();
                break;
                case 10:
                inventory.editPeripheralInfo();
                break;
                case 11:
                inventory.deletePeripheral();
                break;
                case 12:
                System.out.println("PROGRAM CLOSED");
                System.exit(0);
                break;
                

                default:
                System.out.println("INVALID CHOICE!");


                
            }

        }
    }
}