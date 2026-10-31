package Jobsheet10.Praktikum2;

import Jobsheet10.Praktikum1.*;

public class Tester3 {
    public static void main(String[] args) {
        PermanentEmployee pEmp = new PermanentEmployee("Dedik", 500);
        InternshipEmployee iEmp = new InternshipEmployee("Sunarto", 5);
        ElectricityBill eBill = new ElectricityBill(5, "A-1");

        Payable p[] = { pEmp, eBill };

        Employee e[] = { pEmp, iEmp };

        // Employee e2[] = { pEmp, iEmp, eBill };
    }
}
