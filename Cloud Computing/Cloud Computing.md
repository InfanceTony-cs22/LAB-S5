# Virtualization and Cloud Computing Tasks

## Task 1: Run Virtual Machines with Different Configurations
### Aim
To run and manage virtual machines (VMs) with different configurations and assess the maximum utilization at a time.

### Procedure
1. **Install VirtualBox/VMware**:
   - Download the latest version compatible with Windows 8 or above.
   - Install the software and set up a user interface.

2. **Create a Virtual Machine**:
   - Open VirtualBox/VMware.
   - Select *New* → Specify OS type, RAM, storage, and processor cores.

3. **Customize VM Configuration**:
   - Adjust CPU and RAM based on system resources.
   - Choose dynamic or fixed storage options.

4. **Monitor Maximum Utilization**:
   - Check system resources using Task Manager while running multiple VMs.
   - Identify the threshold of CPU/RAM usage.

### Algorithm
1. Start the VM software.
2. Create virtual instances with varying configurations.
3. Monitor host machine resource consumption.
4. Scale up VMs until performance degradation is observed.

### Output
List of configurations and the maximum number of VMs the system can handle.

### Result
Efficient management of VMs with optimized resource usage.

---

## Task 3: Installing VirtualBox and a C Compiler
### Aim
Install VirtualBox and run a C program on a Linux or Windows virtual machine.

### Procedure
1. Install VirtualBox and create a VM with your OS of choice.
2. **For Linux**:
   - Install `gcc` using `sudo apt install gcc`.
   - Write and compile a C program using `gcc`.
3. **For Windows**:
   - Install MinGW and configure the environment variables.
   - Compile a sample C program using `gcc` or an IDE like Code::Blocks.

### Algorithm
1. Install the VM software.
2. Set up the operating system.
3. Install the C compiler.
4. Compile and run the program.

### Output
Execution of the C program on the VM.

### Result
C program successfully compiled and executed.

---

## Task 4: Install Google App Engine and Create a Python Web App
### Aim
Deploy a simple Python web application using Google App Engine (GAE).

### Procedure
1. Install GAE SDK.
2. Initialize a new project using `gcloud init`.
3. Create a `main.py` file with a simple Flask-based "Hello World" application.
4. Deploy the application using `gcloud app deploy`.

### Algorithm
1. Install GAE.
2. Write the Python application.
3. Deploy and test the app.

### Output
A web application hosted on GAE.

### Result
Successfully deployed a Python-based web application.

---

## Task 5: Create a Java Web App on GAE
### Aim
Deploy a simple Java web application using Google App Engine.

### Procedure
1. Install GAE SDK for Java.
2. Write a simple servlet-based "Hello World" app.
3. Deploy it to GAE using Maven or Gradle.

### Algorithm
1. Install GAE for Java.
2. Write the Java application.
3. Deploy and test the app.

### Output
A Java web application hosted on GAE.

### Result
Successfully deployed a Java-based web application.

---

## Task 7: Transfer Files Between Virtual Machines
### Aim
Transfer files securely between virtual machines.

### Procedure
1. Use shared folders in VirtualBox/VMware.
2. Use SCP (Secure Copy Protocol) for Linux VMs:
   ```bash
   scp file.txt user@vm-ip:/path/to/destination
