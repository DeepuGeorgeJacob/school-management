### 1. To get all performance Details

URL -> http://localhost:3000/api/students/performance

Method : GET

Response body
```
{
    "data": [
        {
            "bestPerformance": 90,
            "lastPerformance": 70,
            "student": {
                "firstName": "First student",
                "lastname": "First student last name"
            }
        }
    ]
}
```