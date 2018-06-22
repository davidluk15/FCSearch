#FCSearch
by Jagermeister

## Work Load Distribution  

**Lukas David:**   

* Controller
* Models
* DAOs
* Datenmodel
* Add/Edit Players
* Testing

**Alexander Horina:**  
  
* Models
* DAOs
* HTML
* Datenmodel
* Add/Edit Clubs
* Testing

**Teresa Neuhold:**  
  
* Models
* DAOs
* HTML
* Datenmodel
* Security
* Testing

## About

* Planning Phase  
	> Project proposal  
	> User Requirements Specification  
	> Planning database structure  
	> Choosing a bootstrap design    
 
 
* Development Phase  
	> Implementing the database  
	> Developing the website design  
	> Implementing the Account structure  
	> Implementing of different security features


* Testing Phase  
	> Filling the database with objects  
	> Testing of the different features (rating, commenting)  
   
   
* Presenting Phase  
	> Presenting of the Webpage with the complete features set  


Our Data model includes the following relationships:  
* Club - League
* Club - ClubPlayer
* League - MatchDay
* MatchDay - Match
* Club-League


## Setup Instructions

1. You can fork our project on GitHub and open it in your prefered IDE.  
<a href="https://github.com/davidluk15/FCSearch.git">https://github.com/davidluk15/FCSearch.git</a>

2. The other way is to open eclipse and and import the project direct from the GitHub Repository.

3. After importing the project you need to adapt the db.properties in /src fitting your database location. 

4. If you do not use MySQL you need to change hibernate.dialect in the dispatcher-servlet.xml according to your used database. 

5. Set up a Apache Tomcat 8.5 Server and start project. 

## Releases

The final due was on June 23nd, 2018

## Contributors

This project was created by
* <a href="https://github.com/davidluk15">Lukas David</a>
* <a href="https://github.com/horinaal15">Alexander Horina</a>
* <a href="https://github.com/tneuhold">Teresa Neuhold</a>
