Sprint2
=======

# Installation

1. Clone the repository

2. Run the `install.sh` script

3. Setup the environment:
```bash
source bootstrap.sh
```

4. Build the application:
```bash
mvn clean package
```

# Usage

1. Setup the environment:
```bash
source bootstrap.sh
```

2. Run the application on the default port (8080):
```bash
java -jar target/gs-securing-web-0.1.0.jar
```
or custom port (e.g. 8000):
```bash
java -jar target/gs-securing-web-0.1.0.jar --server.port=8000
```

3. Now you can access the admin interface via `http://localhost:8080/admin/sessions` and 
the user interface via `http://localhost:8080/user/sessions?username=YOUR_USERNAME`.

