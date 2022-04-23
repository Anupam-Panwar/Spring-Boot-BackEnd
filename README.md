# Spring Boot Backend Application

## Six API was developed under this project

<details>
<summary style="font-size: 1.2em">GET : Movie Add in Database</summary>
 <br><strong> http://localhost:8081/movie/add </strong><br><br>
 Collects Movie details from https://developers.themoviedb.org/3/getting-started/introduction and stores it in Database
</details>

<details>
<summary style="font-size: 1.2em">POST : User Registration</summary>
 <br><strong> http://localhost:8081/user/add </strong><br><br>
 Allows user to register into your system
</details>

<details>
<summary style="font-size: 1.2em">POST : Login User</summary>
<br><strong> http://localhost:8081/user/login</strong><br><br>
 Allows user to login using username password and provide access token as response
</details>

<details>
<summary style="font-size: 1.2em">POST : Movie List</summary>
<br><strong> http://localhost:8081/user/list</strong><br><br>
 Using the access token user can retrieve movies list
</details>

<details>
<summary style="font-size: 1.2em">POST : User Rating Movie</summary>
 <br><strong> http://localhost:8081/user/rate</strong><br><br>
 Using access token user can rate movies
</details>


<details>
<summary style="font-size: 1.2em">GET : Movie Rating</summary>
<br><strong> http://localhost:8081/movie/rating</strong><br><br>
API to look at the average rating of each movie. if not rating existing for any movie. Provides NA
</details>


#### For more interactive documentation [click here](./Spring%20Boot%20backend%20Application%20API%20Documentation.pdf)
