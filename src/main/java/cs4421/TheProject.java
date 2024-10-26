package cs4421;

import java.util.Scanner;

public class TheProject {

    public static void menu() throws Exception { // Danny's function
        Scanner input = new Scanner(System.in);

        // Test code for pciNamer
        // String vendorName = FetchPciInfo.pciNamer("8086", "0180").get(0);
        // String deviceName = FetchPciInfo.pciNamer("8086", "0180").get(1);
        // System.out.printf("Vendor: %s%nDevice: %s%n", vendorName, deviceName);

        while (true) {
            System.out.println("Main Menu");
            System.out.println("1) CPU Info");
            System.out.println("2) Disk Info");
            System.out.println("3) PCI Info");
            System.out.println("4) System Info");
            System.out.println("5) USB Info");
            System.out.println("6) Exit");
            System.out.print("Enter a number: ");

            int number = input.nextInt();

            // Based on the user's choice, call the corresponding submenu.
            switch (number) {
                case 1:
                    handleInput("CPU_Info");
                    break;
                case 2:
                    handleInput("Disk_Info");
                    break;
                case 3:
                    handleInput("PCI_Info");
                    break;
                case 4:
                    handleInput("System_Info");
                    break;
                case 5:
                    handleInput("USB_Info");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return; // Exit the program
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // function to handle the submenu logic
    public static void handleInput(String UserInput) {
        Scanner input = new Scanner(System.in);

        switch (UserInput) {
            case "CPU_Info":
                System.out.println("\nCPU Information Menu:");
                System.out.println("1) View CPU Model");
                System.out.println("2) View CPU Speed");
                System.out.println("3) Back to Main Menu");
                break;
            case "Disk_Info":
                System.out.println("\nDisk Information Menu:");
                System.out.println("1) View Disk Capacity");
                System.out.println("2) View Disk Usage");
                System.out.println("3) Back to Main Menu");
                break;
            case "PCI_Info":
                System.out.println("\nPCI Information Menu:");
                System.out.println("1) View PCI Devices");
                System.out.println("2) View PCI Bus Info");
                System.out.println("3) Back to Main Menu");
                break;
            case "System_Info":
                System.out.println("\nSystem Information Menu:");
                System.out.println("1) View OS Version");
                System.out.println("2) View System Uptime");
                System.out.println("3) Back to Main Menu");
                break;
            case "USB_Info":
                System.out.println("\nUSB Information Menu:");
                System.out.println("1) View USB Devices");
                System.out.println("2) View USB Controller Info");
                System.out.println("3) Back to Main Menu");
                break;
            default:
                System.out.println("Invalid submenu option.");
        }

        System.out.print("Enter a number: ");
        int submenuChoice = input.nextInt();
        System.out.print(UserInput + submenuChoice);

        // Process submenu options
        if (submenuChoice == 3) {
            return; // Go back to the main menu
        } else {
            System.out.println("Displaying details for option " + submenuChoice);
            // You can add more specific functionality here for each option
        }
    }

    public static void main(String[] args) throws Exception {
        TheProject.menu();
    }
}
