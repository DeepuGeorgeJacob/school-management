### 1. Post(Save) Book entry.

URL-> http://localhost:3000/api/book

Method : POST

Request body
```
{
    "author":"James",
    "name":"My Story",
    "genre":"SCI_FI",
    "price":100
}
```

Success response body

```
{
    "data": {
        "author": "James",
        "name": "My Story",
        "genre": "SCI_FI",
        "price": 100
    }
}
```

Error response body

```
{
    "errorMessage": "Book already present"
}
```