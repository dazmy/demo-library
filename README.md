
## Tools

- Intellij IDEA
- Postman
- Laragon (to run mysql & heidisql)


## Installation

Download or clone this project.

```bash
  git clone https://github.com/dazmy/demo-library.git
  cd demo-library
  idea .
```
After doing that, create database & schema using heidisql. The sql, I put in folder src/main/resources.
## Usage

To usage this project run command.

```bash
  mvn install
  java -jar .\target\demo-library-0.0.1-SNAPSHOT.jar
```


## API Reference

#### Get all books

```http
  GET /books
```

#### Get detail book

```http
  GET /books/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |

#### Create new book

```http
  POST /books
```
```
{
  "name": "Name of book"
}
```

#### Edit book

```http
  PUT /books/{id}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |

```
{
  "name": "Name of book"
}
```

#### Delete book

```http
  PUT /books/{id}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |


