package cs4421;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Note from Bence: It seems like this is loading the ENTIRE .csv into memory.
// Could we not just check the Vendor/Device ID against each row as we scan it?
// Instead of loading it into a ArrayList and then checking _that_.

// Skye: Yes, can do but will wait until main project is up and running.
// For now will focus on creating other cool classes

public class FetchPCIData {

    public static List<String> pciNamer(String vendorID, String deviceID) throws Exception {
        /*
         * This function takes two inputs for vendor ID and device ID, then returns a
         * string list
         * containing the actual data, in the form of ["Vendor Name", "Device Name"]
         * This is achieved by comparing the results to a csv database of >50,000 PCI
         * devices.
         * Created by Skye Fitzpatrick
         */

        /*
         * TO CALL pciNamer
         * numbers to be replaced with output from Mark's pciInfo code
         * String vendorName = TheProject.pciNamer("8086", "0180").get(0);
         * String deviceName = TheProject.pciNamer("8086", "0180").get(1);
         * System.out.printf("Vendor: %s%nDevice: %s", vendorName, deviceName);
         */

        // Read in data from the CSV file using Scanner
        Scanner readCsv = new Scanner(new File(".\\project\\PCI-Lookup.csv"));

        /*
         * We need to create a 2-dimensional array because of the way the csv file is
         * formatted.
         * The CSV contains data in the form [vendorID+deviceID, vendor name, device
         * name], copied from https://pcilookup.com.
         * To analyse and get data from this, we need to use nested while loops as
         * below.
         */
        ArrayList<ArrayList<String>> pciData = new ArrayList<ArrayList<String>>();

        while (readCsv.hasNextLine()) { // while there are still rows to be read...
            ArrayList<String> rowData = new ArrayList<String>(); // create an empty list for each string in data row
            Scanner separateRowData = new Scanner(readCsv.nextLine()); // read data from the next row
            separateRowData.useDelimiter(","); // separate it using the comma delimiter
            while (separateRowData.hasNext()) {
                rowData.add(separateRowData.next()); // add it to the data list
            }
            pciData.add(rowData); // add to 2 dimensional array
        }

        // initialise variables for each dataset
        ArrayList<String> codesList = new ArrayList<String>();
        ArrayList<String> vendorsList = new ArrayList<String>();
        ArrayList<String> devicesList = new ArrayList<String>();

        // for loop increments for each item in pciData 2D array
        for (int i = 0; i < pciData.size(); i++) {
            codesList.add(pciData.get(i).get(0)); // first column of row i is a code
            vendorsList.add(pciData.get(i).get(1)); // second column of row i is a vendor name
            devicesList.add(pciData.get(i).get(2)); // third column of row i is a device name
        }

        // combine the vendor and device ID into one string to form the "code"
        String codeNeeded = vendorID.concat(deviceID);

        // using a try/catch block in case the code provided is not part of the database

        // list and throws an error
        try {
            int index = codesList.indexOf(codeNeeded); // find index of codeNeeded against original CSV
            ArrayList<String> result = new ArrayList<String>();
            result.add(vendorsList.get(index)); // use same index to find necessary vendor name
            result.add(devicesList.get(index)); // use same index to fine
            return result;
        } catch (Exception e) {
            // create and return an "error list" if the code doesn't run as expected
            List<String> error = new ArrayList<String>();
            error.add("Unknown Vendor!");
            error.add("Unknown Device!");
            return error;
        }
    }
}
