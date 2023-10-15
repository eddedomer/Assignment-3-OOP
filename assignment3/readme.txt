# Assignment-3-OOP
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
uppgrade a manager to an director we have to respecify their degree. this could be solved with an overlaod that only takes a department
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