### **1\. Run Virtual Machines of Different Configurations**

#### **Aim:**

To run and manage multiple virtual machines (VMs) with different configurations and determine the number of VMs that can run simultaneously on a host system.

#### **Procedure:**

1.  **Install VirtualBox/VMware:**
    -   Download and install VirtualBox/VMware on your system.
    -   Ensure that your system supports virtualization (enable it in the BIOS/UEFI if necessary).
2.  **Create Virtual Machines:**
    -   Open the VM software and create a new virtual machine.
    -   Assign CPU cores, RAM, and storage for each VM based on requirements.
    -   Install the desired OS on each VM.
3.  **Run Multiple VMs:**
    -   Start multiple VMs and monitor the host system's resource usage.
    -   Note the number of VMs running simultaneously without overloading the host system.

#### **Algorithm:**

1.  Check host system specifications.
2.  Determine the resource requirements for each VM.
3.  Allocate resources and start VMs one by one.
4.  Monitor CPU, RAM, and disk usage.
5.  Record the maximum number of VMs the system can handle.

* * * * *

### **2\. Install VirtualBox/VMware with Different OS Flavors**

#### **Aim:**

To install VirtualBox/VMware and configure virtual machines with multiple OS flavors (Linux and Windows) on a Windows host.

#### **Procedure:**

1.  Download VirtualBox/VMware and install it on your host system.
2.  Download ISO files for the desired OS flavors (e.g., Ubuntu, Fedora, CentOS, Windows 10).
3.  Create a new VM for each OS flavor.
4.  Mount the ISO file for installation and proceed with OS setup.

#### **Algorithm:**

1.  Open VM software.
2.  Create VMs for each OS flavor.
3.  Attach the respective ISO file and start the VM.
4.  Complete the OS installation.
5.  Test the installed OS functionality.

* * * * *

### **3\. Install a C Compiler in a Virtual Machine**

#### **Aim:**

To set up a C compiler in a virtual machine and execute a sample program.

#### **Procedure:**

1.  Boot into the VM and open the terminal.
2.  Install GCC using the package manager (`sudo apt-get install gcc` for Ubuntu).
3.  Write a sample C program (`hello.c`).
4.  Compile the program (`gcc hello.c -o hello`).
5.  Execute the program (`./hello`).

#### **Algorithm:**

1.  Install the OS and start the VM.
2.  Install GCC or equivalent.
3.  Write and save a C program.
4.  Compile and run the program.

* * * * *

### **4 & 5. Install Google App Engine for Python and Java**

#### **Aim:**

To set up Google App Engine (GAE) and develop a "Hello World" web application in Python and Java.

#### **Procedure:**

1.  Download and install Google Cloud SDK.
2.  Initialize the SDK using `gcloud init`.
3.  Write a simple "Hello World" app.
4.  Deploy the app using `gcloud app deploy`.
5.  Launch the app in a browser.

#### **Algorithm for Python/Java:**

1.  Install required tools (Python/Java, GAE SDK).
2.  Write the app code.
3.  Deploy the app to GAE.
4.  Test the app.

* * * * *

### **6\. Launch Web Applications Using GAE Launcher**

#### **Aim:**

To deploy and launch web applications using Google App Engine Launcher.

#### **Procedure:**

1.  Open the GAE Launcher and configure the app directory.
2.  Deploy the app to the cloud.
3.  Launch the app URL in a browser.

* * * * *

### **7\. File Transfer Between VMs**

#### **Aim:**

To transfer files between virtual machines.

#### **Procedure:**

1.  Enable network connectivity between VMs (e.g., shared network or bridged mode).
2.  Use SCP or file-sharing services to transfer files.

#### **Algorithm:**

1.  Configure network settings.
2.  Use `scp` or shared folders for file transfer.

* * * * *

### **8 & 12. Create and Execute Your First Docker Container**

#### **Aim:**

To set up Docker and create a basic container.

#### **Procedure:**

1.  Install Docker using the package manager.
2.  Pull a base image (`docker pull ubuntu`).
3.  Create and run a container (`docker run -it ubuntu`).

#### **Algorithm:**

1.  Install Docker.
2.  Pull a container image.
3.  Create and execute the container.

* * * * *

### **9 & 13. Simulate Cloud Scenarios Using CloudSim**

#### **Aim:**

To simulate cloud scenarios using CloudSim and run scheduling algorithms.

#### **Procedure:**

1.  Set up CloudSim in an IDE (Eclipse or IntelliJ).
2.  Modify or implement scheduling algorithms in the simulation code.
3.  Run the simulation.

#### **Algorithm:**

1.  Install CloudSim.
2.  Define simulation parameters.
3.  Run the simulation and observe results.

* * * * *

### **10\. Install Hadoop Single Node Cluster**

#### **Aim:**

To set up a Hadoop single-node cluster and run simple applications.

#### **Procedure:**

1.  Install Hadoop and configure `core-site.xml` and `hdfs-site.xml`.
2.  Format the Hadoop file system.
3.  Start the Hadoop services.
4.  Run a sample application like WordCount.

* * * * *

### **11\. Install Docker in VirtualBox**

#### **Aim:**

To install Docker inside a VirtualBox VM.

#### **Procedure:**

1.  Install a compatible Linux OS in the VM.
2.  Follow Docker installation steps for the OS.
3.  Test Docker by running a container.

* * * * *

### **14\. Implement a Docker Image**

#### **Aim:**

To build and use a custom Docker image.

#### **Procedure:**

1.  Create a `Dockerfile` with necessary instructions.
2.  Build the image using `docker build`.
3.  Run a container using the custom image.

#### **Algorithm:**

1.  Define Dockerfile content.
2.  Build the image.
3.  Run and test the container.

* * * * *

### **15\. Hadoop Program for Pi Estimation**

#### **Aim:**

To write a Hadoop program for estimating Pi using Monte Carlo simulation.

#### **Procedure:**

1.  Set up Hadoop.
2.  Write the Pi Estimation code in Java.
3.  Run the job using `hadoop jar`.

#### **Algorithm:**

1.  Generate random points.
2.  Check points within the unit circle.
3.  Estimate Pi using the ratio of points.