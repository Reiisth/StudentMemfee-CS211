
# Student Organization Membership Fee Tracker

This project is a final requirement for the course CS211 - Object Oriented Programming.

## I. Project Overview
Student organizations are a big part of the University experience. Each and everyone who attends University has probably joined or is in an organization. But a problem arises when it comes to managing the organizations especially when it comes to membership fees. 

This project is a Student Organization Membership Fee Tracker that records information such as students' name, ID, section, and most importantly joined organizations. Organizations are registered within the program and the organizations' name and membership fee amount is recorded.

Unlike pen and paper style of tracking, this project ensures portability and convenience of the system. The program tracks the payment status of the students as well as their total amounts due. With the OOP concepts in play, the program aims to make organization management more efficient.

## II. OOP Principles
OOP Principles were used within the program to streamline the process of programming and ensure the consistency, integrity, and quality of the system. 
### Encapsulation
Within the project files, different classes are defined such as: 
- __Person:__ has first name and last name attributes
- __Student:__ has studentId, section, and organizations attributes
- __Organization:__ has name and membership fee attributes
- __MembershipFeeTracker:__ contains the main method and essential method for tracking and management

Each of these classes contains _class specific methods_ that can be accessed by other classes. But the progam also contains private attributes that could only be accessed by setter and getter methods such as in Student and Organization class. 

Encapsulation within the program protects methods and attributes from direct interaction with the user. It acts as a safeguard so that users are distanced from the back end of the program as well as making the code more organized and modular.
### Inheritance
An instance of Inheritance happens within the program in the classes of the project. The base class of _Person_ was extended by the class _Student_. Inheritance is a fundamental part of the program because it simplifies the code to ensure that unplanned repetitions do not happen.
### Abstraction
Method abstraction was used prominently within the project. The methods are only accessible to the classes who need to use them and the processes of tracking is hidden from the users. This principle is implemented to establish a sense of coherence and streamlining when it comes to processes.
### Polymorphism
Polymorphism was used within this project to override certain functions. This overriding was done to maximize the funcitonalities of certain methods. Within the inherited classes, the polymorphic function acts as a consistency marker for the program.
## III. Sustainable Development Goals
Among the United Nation's Sustainable Development Goals, this project aligns the most with UN SDG No.9 or the Industry, Innovation, and Infrastructure goal. More specifically, this project is an attempt at innovation in the field of information technology. 

The information integrity, convenience, and accuracy of the project is an innovation that makes it easier for people to do their duties within student organizations. More importantly, this system reduces waste such as paper waste because it aims to replace pen-and-paper management systems with a more modern and fool-proof approach.
## IV. Program Instructions
Download all the files within the project repository. Then, with the help of any IDE and compiler, run the file __'MembershipFeeTracker'__. The user interface of the console application is mostly intuitive and self-explanatory.

