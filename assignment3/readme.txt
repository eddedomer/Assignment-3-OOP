# Assignment-3-OOP

Re-exam Added text:

We used inheritance in: 
Employee class, Manager class, Director Class, and Intern Class. 
The Manager and Intern class inherits the Employee class. The Director class then inherits the Manager class

The relationship between the Employees and the Company is aggregation

We use polymorphism in:
The LinkedHashMap were we store the Employees
Some methods we use it: updateManagerDegree(), updateDirectorDept(), updateInternGPA 
We also use it when we throw custom Exceptions as an Exception. 

Overiding: 
We use it in the getNetSalaryNO_TRUNCATION and getGrossSalary methods. 

Overloading: 
We use it when creating different types of employees with the CreateEmployee method. 

designPattern:
We use the Factory Method design pattern in the EmployeeFactory class. 

casting: 
We use casting when we want to access specific methods from a subtype. like the degree of a manager. We also use it to truncate. 

Encapsulation: 
We dont have unecesary setters. and all attributes are private or protected. 

Abstract classes: 
The employee factory is abstract. 

Static methods: 
We have some static methods like all the createEmployee methods in the EmployeeFactroy. 

Re-exam Added text:


The third assignment in my OOP Class.

Edvin did tasks: 1.1 to 1.5
Daniel did tasks: 1.6 to 1.10

Since we had a lot of troubleshooting on task 1.11
we decided to do it togheter.

For the Epic Feature 2
Daniel created the classes and Edvin implemented them.


Comments on 1.11 from Edvin
we where a little confused since the assignemnt said that we needed 4 different methods for this task but there was no mention
demmoting an employee to a regular employee. So we did it with 3. one for each type. some issues with this tho is now when we want to 
uppgrade a manager to an director we have to respecify their degree. this could be solved with an overload that only takes a department
but since there was no mention of this in the assignemnt or tests we did not do that. Also if you go from director to manager you could
make a method that only removes the department and turns it into a manger without having to specify the degree. 

This was a great example of some advantages and disadvatages with inheritance. A way were you could just tranform an child Object
into another one only having to specify the uniqe attributes for the Object would be great. But there is no such thing i java. that we 
have Learned atleast. This means the we need som many different methods for the promotion since all of them have uniqe attributes. 
and if we wanted to cover every possible promotion case without having to respecify data this could have to be written with atleast 5 methos 
instead of the already messy three. 

We are not completly happy with the way we did this. I wanted to make a more efficient way to store the data of the old employee
but since we work with so many different datatypes it was a real mess trying to store it all. so we just stored it in the same method 
for all of them which is a little bit wet but since there are only 2 variables to be stored we thought of it as fine. 




Comments on 1.11 from Daniel;
Well we noticed quite fast the limitations of inheritance, though it is great for reuse and creating relationships with classes.
It is quite hard to justify our trade offs since we had a lot of challanges in managing different types of employees.
Our inheritance is causing the code to be very dependet of eachother. One example of this is that if we where to add a feature 
to their shared attributes we need to update both of them. 

As well for the code being hard to update. If we where to introduce new employees this might in some 
cases be challinging due to the inheritance hiearchy. That in some cases could make us do some exstensive modifications.

And I can't forget to mention that the code also is dublicated. If we look at how we managed the attribute name, is that it is 
dublicated across multiple classes. To handle the attribute name we would need to change this in each class separately.

For a summary it is important to use inheritance but we've learned that it comes with limitations. But if you know
your weaknesses you also knows it's limitation. Thinking about the trade offs is important when choosing the design 
of your project.

