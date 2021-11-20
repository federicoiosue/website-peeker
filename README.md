<img src="https://github.com/federicoiosue/website-peeker/raw/develop/assets/icon.png" width="200">

# Website Peeker

Spring Boot application for taking instants images of online websites, for previews and thumbnails.

## Build & Run

```bash
mvn clean spring-boot:run
```

## Usage

### Peek for a website screenshot

```bash
curl --output GET 'localhost:8080/website/iosue.it' --header 'Authorization: Basic dXNlcjpwYXNz'
```
<img src="https://github.com/federicoiosue/website-peeker/raw/develop/assets/site1.jpg" width="450"> <img src="https://github.com/federicoiosue/website-peeker/raw/develop/assets/site2.jpg" width="450">

### Evict website from cache

```bash
curl DELETE 'localhost:8080/website/iosue.it' --header 'Authorization: Basic dXNlcjpwYXNz'
```