# Odd Task Overview 

### Task 1 - Write code that stores the first N records of the dataset in some custom object.  
Implemented `StoreRecords` class with a method `get_first_n_records(N)` that returns the first N records.

---

### Task 3 - Write code that displays a horizontal text-based histogram of the ages.  
Implemented `AgeHistogram` class that counts ages, sorts them, and prints each age with `*` characters as bars.

---

### Task 5 - Write code that determines the total number of records for each number of children.  
Implemented `ChildrenCount` class that counts children values and prints results with stars and totals.

---

### Task 7 - We think this data is "fair" if the number of records from each region differ by no more than 5%. Is the data fair?  
Implemented `Task7` class that checks the count per region, compares against expected values, and prints if fair or not.

-> Task7 fairness = new Task7(records);
-> fairness.print_fairness();

---

### Task 9 - We think the range of charges for BMI in 30–45 are greater than the other two ranges of BMIs. Is this true?  
Implemented `Task9` class that splits BMI into three groups (<30, 30–45, >45), calculates min/max charges, and compares ranges.

-> Task9 bmi_range = new Task9(records);
-> bmiRange.check_bmi_ranges();

---

### Task 11 - Our hypothesis is that smokers have higher charges and a wider range of charges than non-smokers. Is this hypothesis true for our dataset?
Split records into smokers vs nonsmokers -> Calculated average charge and found range for each group -> Compared the results

-> Task11 smoker_charges = new Task11(records);
-> smoker_charges.check_smoker_hypothesis();

---

### Task 13 - Do smokers average lower BMI than non-smokers?
Split records into smokers vs nonsmokers -> Calculated average for bmi -> Compared the results

-> Task13 smoker_bmi = new Task13(records);
-> smoker_bmi.check_smoker_bmi();

---

### Task 15 - Sort the 4 regions by their average charges in descending order.
Group charges by region -> Compute average charge for each region -> Sort average charge in descending order -> Print outcome

-> Task 15 rc = new Task15(records);
-> rc.sort_regions_by_avg_charges();