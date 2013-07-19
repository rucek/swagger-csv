A simple script for creating a CSV file (actually separated by semicolons) from a JSON api docs exposed by [Swagger](https://developers.helloreverb.com/swagger/)

It takes a single parameter with the base URL for Swagger API docs, without the `/api-docs` part (e.g. when your Swagger URL is `http://myapp.com/swagger/api-docs`, you should pass `http://myapp.com/swagger`).