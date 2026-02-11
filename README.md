A simple Spring Boot REST API to manage a collection of movies.
The application uses an in-memory ArrayList to store data.
Data resets when the application restarts.

Live URL:
https://miniflix.onrender.com/api/movies

Endpoints:

1. Add Movie
POST /api/movies

eg:-

{
  "id": 1,
  "title": "Inception",
  "genre": "Sci-Fi",
  "releaseYear": 2010,
  "rating": 8.8
}

2. Get Movie by ID
GET /api/movies/{id}

3. Get All Movies
GET /api/movies

