# Healthcare-Management-System-automation
# Healthcare Management System Automation

This project provides an automation framework for testing a healthcare management system. It covers various aspects including patient registration, appointment scheduling, billing, and electronic health records (EHR) management.

## Features

- End-to-end testing of patient workflows
- Data validation for health records
- API testing for integrations with external health services
- Performance testing for real-time data processing

## Technologies

- Java 11
- Selenium WebDriver
- Cucumber for BDD
- TestNG for test execution
- REST Assured for API testing
- Apache JMeter for performance testing
- Maven for project management

## Project Structure

```
healthcare-automation/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── healthcare/
│   │               ├── pages/
│   │               └── utils/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── healthcare/
│       │           ├── runners/
│       │           └── steps/
│       └── resources/
│           └── features/
├── pom.xml
└── README.md
```

## Setup

1. Ensure you have Java 11 and Maven installed on your system.
2. Clone this repository:
   ```
   git clone https://github.com/your-username/healthcare-automation.git
   ```
3. Navigate to the project directory:
   ```
   cd healthcare-automation
   ```
4. Install dependencies:
   ```
   mvn clean install
   ```

## Running Tests

To run all tests:

```
mvn clean test
```

To run a specific test class:

```
mvn test -Dtest=TestClassName
```

To run tests with a specific tag (if using Cucumber):

```
mvn test -Dcucumber.filter.tags="@YourTag"
```

## API Testing

API tests are located in `src/test/java/com/healthcare/api/ExternalHealthServiceAPITest.java`. These tests cover basic CRUD operations for patient information, appointments, and health records.

To run only API tests:

```
mvn test -Dtest=ExternalHealthServiceAPITest
```

## Performance Testing

JMeter test plans are located in `src/test/jmeter/`. To run JMeter tests, use the JMeter Maven Plugin (configuration in pom.xml).

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Contact
Esoham@yahoo.com
