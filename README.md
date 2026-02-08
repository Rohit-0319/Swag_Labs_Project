# 🚀 Selenium TestNG Automation Framework (UI)

A scalable and maintainable **UI Automation Framework** built using **Java, Selenium WebDriver, and TestNG**, following **industry best practices** such as Page Object Model, data-driven testing, centralized reporting and logging.

This project demonstrates **real-world automation framework design**, not just test scripting.

---

## 📌 Key Highlights

✔ Page Object Model (POM) for clean separation of concerns
✔ Data-driven testing using Excel + TestNG DataProvider
✔ Centralized Extent HTML reporting with screenshots on failure
✔ TestNG Listeners for lifecycle management
✔ Log4j2 integration for execution-level logging
✔ Config-driven execution (no hardcoded values)
✔ Clean, scalable, and CI-friendly structure

---

## 🛠 Tech Stack

- **Language:** Java
- **UI Automation:** Selenium WebDriver
- **Test Framework:** TestNG
- **Build Tool:** Maven
- **Reporting:** Extent Reports
- **Logging:** Log4j2
- **Test Data:** Excel (Apache POI)

---

## 🧱 Framework Architecture

The framework is designed following **Single Responsibility Principle** and **Separation of Concerns**.

```
src/test/java
├── base
│ └── BaseClass.java
├── pages
│ ├── LoginPage.java
│ ├── AddToCart.java
│ └── CheckOut.java
│ └── LogoutPage.java
├── tests
│ └── LoginTest.java
│ └── E2E_CheckoutTest.java
├── listeners
│ └── MyTestListener.java
├── utilities
│ ├── ExcelUtility.java
│ └── LoggerUtil.java
│ └── ExtentManager.java

```


## ⚙️ Configuration Management

All environment-specific and configurable values are externalized in a properties file.

This allows easy execution across different environments without code changes.

---

## 📊 Reporting (Extent Reports)

- Centralized reporting using **Extent Reports**
- Integrated via **TestNG Listener**
- Automatic screenshot capture on test failure
- Flaky tests (passed after retry) are highlighted separately

📌 Sample report features:
- Pass / Fail / Skip / Warning status
- Execution timeline
- Failure stacktrace with screenshots

---

## 🪵 Logging (Log4j2)

- Execution-level logs captured using **Log4j2**
- Logs help in debugging failures and understanding test flow
- Rolling file strategy used to prevent oversized log files

Logs are maintained separately from test reports for clarity.


---

## 🔍 Test Design Strategy

- **Login tests** are data-driven and validate authentication behavior using multiple user credentials.
- **End-to-end (E2E) tests** validate complete business flows and are executed using a stable user only.

This mirrors real-world automation strategies used in CI pipelines.

---
## 📂 Test Data Management

- Test data stored in Excel
- Excel file path controlled via `config.properties`
- DataProvider enables multiple test executions with different datasets
- Each row in Excel represents one test iteration

---

## ▶️ How to Run the Tests

### Prerequisites
- Java 8+
- Maven installed
- Chrome browser

### Execute tests
bash
mvn clean test

After execution:

- Extent report will be generated under /reports
- Logs will be available under /logs

  ## 👤 Author

**Rohit Kumar Jaiswal**

## License

This project is created for learning and demonstration purposes.
