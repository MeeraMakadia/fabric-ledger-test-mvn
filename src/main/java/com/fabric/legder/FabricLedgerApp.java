package com.fabric.legder;

import com.fabric.legder.module.CommandEnum;
import com.fabric.legder.service.CustomerLoanService;
import com.fabric.legder.service.CustomerLoanServiceImpl;

import java.io.*;


public class FabricLedgerApp {

    public static void main(String[] args) {

        if (args.length == 0 || args[0].trim().equals("")) {
            System.out.println("Please pass input file location.");
        } else {
            File file = new File(args[0]);
            CustomerLoanService customerLoanService = new CustomerLoanServiceImpl();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null && line.length() > 0) {

                    String[] splitLine = line.split("\\s+");
                    CommandEnum command = null;

                    try {
                        command = CommandEnum.valueOf(splitLine[0]);
                    } catch (IllegalArgumentException e) {
                        // ignore line starting with invalid command
                        continue;
                    }

                    switch (command) {
                        case LOAN:
                            if (splitLine.length == 6) {
                                customerLoanService.createCustomerLoan(splitLine[1], splitLine[2], Double.valueOf(splitLine[3]), Double.valueOf(splitLine[4]), Double.valueOf(splitLine[5]));
                            }
                            break;
                        case BALANCE:
                            if (splitLine.length == 4) {
                                customerLoanService.printBalance(splitLine[1], splitLine[2], Integer.valueOf(splitLine[3]));
                            }
                            break;
                        case PAYMENT:
                            if (splitLine.length == 5) {
                                customerLoanService.addPayment(splitLine[1], splitLine[2], Double.valueOf(splitLine[3]), Integer.valueOf(splitLine[4]));
                            }
                            break;
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Can not find input file :" + e.getMessage());
            } catch (IOException e) {
                System.out.println("Error while reading input file : " +e.getMessage());
            } catch (NumberFormatException e) {
                // ignore invalid data type in input
            }

        }
    }
}
