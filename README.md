Project title: Bashundhara Rental Management System

This Java Spring Boot-based application provides a complete backend solution for managing rental properties, agreements, payments, maintenance, and user authentication. It is designed for residential house rental agencies or housing complexes to track tenants, rental requests, property statuses, and more.

Tech Stack:
Java 17, Spring Boot, Spring Security(JWT Based), Spring JDBC with postgreSQL, Spring AOP, JavaMailSender,Maven,Postman,Git.


###Core Features:
***Authentication System
1.Register, Login, Change Password, Forgot Password 
2.Role-based access control (Admin/User)
3.JWT-secured endpoints

***Property Management
1.Add/update/delete/view rental properties
2.Set availability, rent, descriptions

*** Rental Agreement Handling
1.Create agreements for approved rental requests
2.Agreement update & deletion

***Rental Request System
1.Submit requests by users
2.Admin can approve/reject requests

*** Payment Tracking
1.Add/view payment history per user
2.Link payments with rental agreements

***Maintenance Request Management
1.Tenants can raise maintenance issues
2.Admin/maintenance team can track and resolve

***Application Logging
1.Spring AOP-based logs saved in application.log


***Email Notifications
1.JavaMailSender integrated for notifications
