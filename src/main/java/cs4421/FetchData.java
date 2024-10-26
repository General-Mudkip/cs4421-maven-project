package cs4421;

import java.awt.*;

public class FetchData {
    public static void subMenu(String mainChoice, int subChoice) throws Exception {
        System.out.println(mainChoice + subChoice);

        if (mainChoice.equals("Cpu_Info1")) {
            if (subChoice == 1) {
                // System.out.print(CpuInfo.getModel());
            } else if (subChoice == 2) {
                // System.out.print(CpuInfo.getIdleTime(1));
            } else if (subChoice == 3) {
                TheProject.menu();
            }
        }
        if (mainChoice.equals("Cpu_Info2")) {
            if (subChoice == 1) {
                // DiskInfo.diskCount();
            } else if (subChoice == 2) {
                // DiskInfo.getModel();
            } else if (subChoice == 3) {
                TheProject.menu();

            }
        }
        if (mainChoice.equals("Cpu_Info3")) {
            if (subChoice == 1) {
                // System.out.print(PciInfo.deviceCount(1));
            } else if (subChoice == 2) {
                // PciInfo.busCount();
            } else if (subChoice == 3) {
                TheProject.menu();

            }
        }
        if (mainChoice.equals("Cpu_Info4")) {
            if (subChoice == 1) {
                // CpuInfo.coresPerSocket();
            } else if (subChoice == 2) {
                // CpuInfo.socketCount();
            } else if (subChoice == 3) {
                TheProject.menu();
            }

        }
        if (mainChoice.equals("Cpu_Info5")) {
            if (subChoice == 1) {
                // CpuInfo.l1dCacheSize();
            }
            if (subChoice == 2) {
                // CpuInfo.l1iCacheSize();
            }
        }

    }
}
