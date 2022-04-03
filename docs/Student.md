### 1. Post(Save) student entry.

URL-> http://localhost:3000/api/students

Method : POST

Request Body
```
{
            "firstName": "First student",
            "lastName": "First student last name",
            
            "studentDetails": {
                "age": 18,
                "dateOfBirth": "207-05-06",
                "contactNumber": "123456789"
            },
            "performance": {
                "bestPerformance":90,
                "lastPerformance":70
            },
            "guardian": {
                "name": "GName",
                "contactNumber": "345667"
            }
        }
```

Response Body

```
{
    "data": [
        {
            "id": 1,
            "firstName": "First student",
            "lastName": "First student last name",
            "studentDetails": {
                "id": 1,
                "age": 18,
                "dateOfBirth": "207-05-06",
                "contactNumber": "123456789"
            },
            "performance": {
                "id": 1,
                "bestPerformance": 90,
                "lastPerformance": 70
            },
            "guardian": {
                "name": "GName",
                "contactNumber": "345667"
            }
        }
    ]
}
```



### 2. To get all students
 
URL -> http://localhost:3000/api/students/

Method : GET

Response body
```
{
    "data": [
        {
            "id": 1,
            "firstName": "First student",
            "lastName": "First student last name",
            "studentDetails": {
                "id": 1,
                "age": 18,
                "dateOfBirth": "207-05-06",
                "contactNumber": "123456789"
            },
            "performance": {
                "id": 1,
                "bestPerformance": 90,
                "lastPerformance": 70
            },
            "guardian": {
                "name": "GName",
                "contactNumber": "345667"
            }
        }
    ]
}
```

### 3. To get student by id

URL -> http://localhost:3000/api/students/{id}

Method : GET

Response body
```
{
    "data": [
        {
            "id": 1,
            "firstName": "First student",
            "lastName": "First student last name",
            "studentDetails": {
                "id": 1,
                "age": 18,
                "dateOfBirth": "207-05-06",
                "contactNumber": "123456789"
            },
            "performance": {
                "id": 1,
                "bestPerformance": 90,
                "lastPerformance": 70
            }
        }
    ]
}
```


### 4. Remove student entry.

URL-> http://localhost:3000/api/students

Method : DELETE

Request Body
```
{
            "id": 1,
            "firstName": "First student",
            "lastName": "First student last name",
            "studentDetails": {
                "id": 1,
                "age": 18,
                "dateOfBirth": "207-05-06",
                "contactNumber": "123456789"
            },
            "performance": {
                "id": 1,
                "bestPerformance": 90,
                "lastPerformance": 70
            }
        }
```

Response Body

```
{
    "data": []
}
```


### 5. Remove student by id.

URL-> http://localhost:3000/api/students/{id}

Method : DELETE

Response Body

```
{
    "data": []
}
```





