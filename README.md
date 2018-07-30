# Epix Coding Project

## Description
The project is intended to demonstrate my understanding of the interaction between the database, the backend, and the front end.

## Technology Stack
### Backend
```
Maven
Github
JAVA
Spring Framework
RestController (for services)
Repository Pattern
Service Pattern
ResponseEntity with exception handling
```
### Frontend
```
Bootstrap
AngularJS 1.X (ngResource, ui-router)
Bower
Javascript
HTML
```

### Database
```
Hibernate
CRUD Repository
JPA Repository
Relational Database Architecture (Many-to-One relationship between SHOW and CHANNEL)
```

## API
### CHANNEL
```
/api/v1/channels GET
- returns a list of all channels available

/api/v1/channels/:id GET
- returns information for channel specified by ID

/api/v1/channels/:id/shows GET
- returns list of shows for specified channel ID

```
### SHOW
```
/api/v1/shows GET
- returns a list of all shows available

/api/v1/shows/:id GET
- returns information for show specified by ID

```

## Notes

For the CHANNEL data management, I used the Repository pattern that Spring offers.

For the SHOW data management, I added another layer in between the Controller and Repository, the Service layer.
This will make it more robust in that it decouples implementation directly on the repository allowing for easier maintenance if the repository is changed in the future.

I am not a good UI designer, so please excuse the simple UI format. I was focused more on its functionality.

## Time Crunch
If I had more time, I would do the following:
1) Implement DynamoDB architecture and have it hosted in AWS
2) Create Nano Instance in AWS and have it host the website
3) Have images hosted in AWS S3 rather than locally
4) Implement the Service pattern on CHANNEL as well
5) Implement PUT, DELETE, POST services for both CHANNEL and SHOW to allow for forms in website
6) Create TestNG test suite
7) Configure app.js routing properly where there would be a main Index.html rather than going to http://localhost:8080/#/channels

## Running Project
1) Clone project
2) Run EpixApplicatoin project
3) From Browser, go to http://localhost:8080/#/channels
4) All links are working - hopefully you are not behind a firewall preventing youtube videos from showing

## Summary
In summary, my intention was to develop an application that would require all around understanding of an Internet application, from the backend to the frontend.

Feel free to contact me if you have any questions.

Thank you very much.

Luis Buitrago

