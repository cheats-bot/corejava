/*
 * Assignment 1: Basic Java Programs and Implementing Classes & Objects
 * Note: Don't use constructor
 * 
 * SET C - Question 2:
 * Design a program to manage hospital patients using a Patient class with attributes:
 * patientId, name, age, disease, daysAdmitted, dailyCharge, totalBill. 
 * The program should perform the following operations:
 * a) Create and store details of at least 5 patients. (Use Array)
 * b) Calculate total bill for each patient using daysAdmitted × dailyCharge.
 * c) Display summary of all patients.
 * d) Display details of the patient with the longest stay and highest bill.
 */

import java.util.Scanner;

class Patient {
    int patientId;
    String name;
    int age;
    String disease;
    int daysAdmitted;
    double dailyCharge;
    double totalBill;

    // Method to accept patient details (No constructor used)
    void acceptPatient(Scanner sc, int index) {
        System.out.println("\n--- Enter Details for Patient " + (index + 1) + " ---");
        System.out.print("Patient ID          : ");
        this.patientId = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Name                : ");
        this.name = sc.nextLine();
        System.out.print("Age                 : ");
        this.age = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Disease / Diagnosis : ");
        this.disease = sc.nextLine();
        System.out.print("Days Admitted       : ");
        this.daysAdmitted = sc.nextInt();
        System.out.print("Daily Charge (₹)    : ");
        this.dailyCharge = sc.nextDouble();
        sc.nextLine(); // consume newline

        // Calculate bill
        calculateBill();
    }

    // Method to calculate total bill: daysAdmitted × dailyCharge
    void calculateBill() {
        this.totalBill = this.daysAdmitted * this.dailyCharge;
    }

    // Method to display summary in tabular form
    void displaySummaryRow() {
        System.out.printf("%-8d %-16s %-6d %-16s %-12d %-14.2f %-12.2f\n",
            patientId, name, age, disease, daysAdmitted, dailyCharge, totalBill);
    }

    // Method to display detailed card
    void displayCard() {
        System.out.println("  ID            : " + patientId);
        System.out.println("  Name          : " + name);
        System.out.println("  Age           : " + age);
        System.out.println("  Disease       : " + disease);
        System.out.println("  Days Admitted : " + daysAdmitted);
        System.out.println("  Daily Charge  : ₹" + dailyCharge);
        System.out.println("  Total Bill    : ₹" + totalBill);
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int TOTAL_PATIENTS = 5;

        // a) Create and store details of at least 5 patients (Use Array)
        Patient[] patients = new Patient[TOTAL_PATIENTS];

        System.out.println("=================================================");
        System.out.println("       HOSPITAL PATIENT MANAGEMENT SYSTEM        ");
        System.out.println("=================================================");

        for (int i = 0; i < TOTAL_PATIENTS; i++) {
            patients[i] = new Patient(); // No constructor initialization
            patients[i].acceptPatient(sc, i);
        }

        // c) Display summary of all patients
        System.out.println("\n" + "=".repeat(90));
        System.out.println("                              PATIENTS SUMMARY");
        System.out.println("=".repeat(90));
        System.out.printf("%-8s %-16s %-6s %-16s %-12s %-14s %-12s\n",
            "ID", "Name", "Age", "Disease", "Stay(Days)", "Daily Chg(₹)", "Total(₹)");
        System.out.println("-".repeat(90));

        for (int i = 0; i < TOTAL_PATIENTS; i++) {
            patients[i].displaySummaryRow();
        }
        System.out.println("=".repeat(90));

        // d) Display details of the patient with the longest stay and highest bill
        int longestStayIndex = 0;
        int highestBillIndex = 0;

        for (int i = 1; i < TOTAL_PATIENTS; i++) {
            if (patients[i].daysAdmitted > patients[longestStayIndex].daysAdmitted) {
                longestStayIndex = i;
            }
            if (patients[i].totalBill > patients[highestBillIndex].totalBill) {
                highestBillIndex = i;
            }
        }

        System.out.println("\n>>> [A] PATIENT WITH LONGEST STAY <<<");
        patients[longestStayIndex].displayCard();

        System.out.println("\n>>> [B] PATIENT WITH HIGHEST BILL <<<");
        patients[highestBillIndex].displayCard();

        sc.close();
    }
}

