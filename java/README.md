# Core Java Programming Lab Book (T.Y.B.Sc. CS 2025-26)

Sir Parashurambhau College, Pune — Department of Computer Science  
**NEP 1.0 — Lab I: Core Java Programming**

---

## Complete Project Structure & Assignment Directory Map

```text
java/
├── Assignment_1/   # Basic Java Programs & Implementing Classes & Objects (Don't use constructor)
│   ├── Set_A/ (Q1: CalculatorMenu, Q2: NumberOperations, Q3: StudentDemo)
│   ├── Set_B/ (Q1: PalindromeChecker, Q2: OrderManagement)
│   └── Set_C/ (Q1: CharacterFrequency, Q2: HospitalManagement)
│
├── Assignment_2/   # Constructors, Method Overloading, Inheritance & Overriding
│   ├── Set_A/ (Q1: StudentDemo2, Q2: AreaCalculator, Q3: BankAccountDemo)
│   ├── Set_B/ (Q1: EmployeeManagerDemo, Q2: VehicleCarDemo)
│   └── Set_C/ (Q1: CoursePlatform)
│
├── Assignment_3/   # Abstract Classes & Interfaces
│   ├── Set_A/ (Q1: LibraryDemo, Q2: SmartPhoneDemo)
│   ├── Set_B/ (Q1: ShapeDemo)
│   └── Set_C/ (Q1: CreditCardPaymentDemo)
│
├── Assignment_4/   # Final Keyword, Garbage Collector, Wrapper Class & Packages
│   ├── Set_A/ (Q1: ConstantsDemo, Q2: AnimalFinalMethodDemo, Q3: WrapperConversion, Q4: EmployeeFinalSalaryDemo, Q5: MathApp, Q6: CalcDemo)
│   ├── Set_B/ (Q1: FinalClassObservation, Q2: FinalMethodObservation, Q3: ShapesDemo)
│   └── Set_C/ (Q1: HotelManagementApp)
│
├── Assignment_5/   # Exception Handling
│   ├── Set_A/ (Q1: DivisionHandler, Q2: DivideWithFinally, Q3: StringToIntegerFormat, Q4: FileLineReaderFinally)
│   ├── Set_B/ (Q1: AgeValidator, Q2: ArrayDivisionExceptions)
│   └── Set_C/ (Q1: CustomExceptionBankDemo, Q2: PasswordValidatorDemo)
│
├── Assignment_6/   # File Handling
│   ├── Set_A/ (Q1: CreateWriteFile, Q2: ReadFileFileReader, Q3: AppendFileFileWriter, Q4: BufferedWriteRead, Q5: CountCharactersFileReader)
│   ├── Set_B/ (Q1: CopyFileBuffered, Q2: CountFileStats, Q3: SearchWordInFile, Q4: SerializeStudentDemo, Q5: FilterLinesStartingWithJava)
│   └── Set_C/ (Q1: MergeTwoFiles, Q2: SplitFileByLines, Q3: TransientKeywordDemo, Q4: SerializeLibraryDemo, Q5: SerializeBankAccountCheck)
│
├── Assignment_7/   # String Manipulation, StringBuffer & StringBuilder
│   ├── Set_A/ (Q1: StringConcatDemo, Q2: StringLengthFirstLast, Q3: StringBuilderAppend, Q4: StringBufferReverse)
│   ├── Set_B/ (Q1: SubstringExtraction, Q2: StringBuilderManipulations, Q3: CharSearchInString, Q4: StringBufferReplace, Q5: StringTransformations)
│   └── Set_C/ (Q1: WordCountSplit, Q2: StringBuilderOperations, Q3: StringPalindromeEquality)
│
└── Assignment_8/   # Collection Framework and Thread Programming
    ├── Set_A/ (Q1: ArrayListStudentMarks, Q2: TreeSetNames, Q3: HashMapStudentRoll, Q4: TreeSetEmployeeAscDesc, Q5: HashMapWordFrequency, Q6: ThreadExtendsDemo, Q7: RunnableThreadDemo)
    ├── Set_B/ (Q1: TreeMapCountryPopulation, Q2: WebsiteVisitorsTreeSet, Q3: ContactDirectory, Q4: StudentNameSetSort, Q5: ThreadSleepJoinDemo, Q6: SynchronizedCounterDemo)
    └── Set_C/ (Q1: ProductCatalogSystem, Q2: StudentMarksGrouping, Q3: EmailDeduplicationOrder, Q4: BankAccountSynchronizedWithdraw, Q5: ProducerConsumerWaitNotify, Q6: EvenOddAlternatingThreads)
```

---

## How to Compile and Run Any Program

### Single Programs:
Navigate to the question folder and run standard `javac` and `java`:
```bash
cd "Assignment_1/Set_A/Q1"
javac CalculatorMenu.java
java CalculatorMenu
```

### Packaged Programs (e.g., Assignment 4):
Compile packages with the root classpath:
```bash
# Example for Assignment 4 Set A Q5 (mathutils and app):
cd "Assignment_4/Set_A/Q5"
javac mathutils/*.java app/*.java
java app.MathApp
```
