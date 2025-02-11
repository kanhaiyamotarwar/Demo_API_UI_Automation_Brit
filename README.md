This project is a robust test automation framework designed for both UI and API testing using industry-standard tools and best practices. 
It leverages Selenium WebDriver for UI automation and Rest Assured for API testing, ensuring a seamless and scalable approach to test execution.

**Key Features**

✔️ UI Automation: Built using Selenium WebDriver with the Page Object Model (POM) for maintainability.

🔹 API Testing: Implements Rest Assured to validate RESTful APIs efficiently.

📌 BDD Approach: Uses Cucumber and Gherkin for behavior-driven development (BDD).

⚡ Test Execution: Powered by JUnit, providing structured test execution and reporting.

🔄 Reusable Components: Modular test design for enhanced scalability and reusability.

Tech Stack
  1. Java (Core language)
  2. Selenium WebDriver (UI automation)
  3. Rest Assured (API testing)
  4. JUnit (Test execution)
  5. Cucumber & Gherkin (BDD framework)
  6. Page Object Model (POM) (UI test design pattern)
  
  Usage
  1. Easily extendable for new test cases.
  2. Supports parallel execution for faster test runs.
  3. Structured reporting for test results and failures.

**Instructions to Use the Automation Framework**
Prerequisites
Before using the automation framework, ensure the following dependencies are installed on your system:
1. Maven – Required for project build and dependency management.
2. Java (JDK 11 or later) – Required for execution.
3. Cucumber – Required for BDD-based test execution.
4. Eclipse IDE – Recommended IDE for running and managing test cases.

Steps to Import Project as a Maven Project
1. Open Eclipse IDE.
2. Click on File and select the Import option.
3. Click on Maven > Existing Maven Projects.
4. Click on Next.
5. Browse and select your project directory.
6. Click on Finish to import the project.

Importing Projects from Git with Smart Import
1. Click on File > Import.
2. In the Import window, select Projects from Git (with smart import) and click Next.
3. In the Select Repository Source window, choose one of the following:
    * Existing local repository (if the repository is already cloned locally)
    * Clone URI  https://github.com/kanhaiyamotarwar/Demo_API_UI_Automation_Brit/tree/master
      
4. Follow the wizard steps and click Finish.
5. Eclipse will analyze the project folder and automatically import it into the Project Explorer.

Steps to Execute Test Cases
1. Open the TestRunner file inside the TestRunner package.
2. Right-click on the TestRunner file and select Run As > JUnit Test.
3. The tests will execute, and the results will be displayed in the console.

Viewing Test Reports
1. Once execution is completed, navigate to the target directory.
2. Open the report folder.
3. Locate and open the cucumber.html report in a browser to analyze the test results.


