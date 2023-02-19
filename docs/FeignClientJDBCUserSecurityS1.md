# Passing http headers to Feign Client

<b>Step 1</b>: Pass `HttpServletRequest` through your controller to service.<br>
Eg:-
```java
 @GetMapping(value = "/feign/{id}")
    public ResponseEntity<ApiResponse<MembershipDto>> getStudentMembershipFeign(HttpServletRequest request, @PathVariable int id) {
        return membershipService.getLibraryMembershipFeign(request, id);
    }
```

See the [sample](../school-library/src/main/java/com/school/management/library/controller/SchoolLibraryController.java)

<b>Step 2</b>: Extract headers from `HttpServletRequest` in your service.

See my Service layer in the below code notice the method `getHeaders(request)`:-

```java
public ResponseEntity<ApiResponse<MembershipDto>> getLibraryMembershipFeign(HttpServletRequest request, int id) {
        var presentMemberShip = membershipRepository.findByStudentId(id);
        if (presentMemberShip != null) {
            var studentDetails = studentService.getStudentById(getHeaders(request), id);
            MembershipDto membershipDto = new MembershipDto(
                    presentMemberShip.getMembershipNumber(),
                    presentMemberShip.getStudentId(),
                    presentMemberShip.getCreatedDate(),
                    studentDetails
            );
            var response = ApiResponse.<MembershipDto>builder().data(membershipDto).build();
            return ResponseEntity.ok(response);
        } else {
            throw new DataNotFoundException("Student has no membership");
        }

    }
```
In the `getHeader(request)` method I am processing all the available headers in the main request. Which contains `Authorization` header as well.
Also, I am creating a new header object to send to feign client

The below code snippet shows how I am processing the headers and creating new header object.

```java
private HttpHeaders getHeaders(final HttpServletRequest httpServletRequest) {
        var iterator = httpServletRequest.getHeaderNames().asIterator();
        final HttpHeaders headers = new HttpHeaders();
        while (iterator.hasNext()) {
            var key = iterator.next();
            headers.add(key, httpServletRequest.getHeader(key));
        }
        return headers;
    }

```

In the above code I am creating a headers object with all available header.
<br><br>You can either use all header or specific header like below code.

```java

private HttpHeaders getHeaders(final HttpServletRequest httpServletRequest) {
        final HttpHeaders headers = new HttpHeaders();
        headers.add("authorization", httpServletRequest.getHeader("authorization"));
        return headers;
    }
```

See the [example](../school-library/src/main/java/com/school/management/library/service/MembershipService.java)

<b>Step 3</b> : Pass the header to your feign client.



<br> I have an intermediate service layer before calling feign client. See my intermediate service layer below.

[Example](../school-library/src/main/java/com/school/management/library/service/StudentService.java)

```java

@Service
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentFeignClient studentFeignClient;

    @Autowired
    public StudentService(final StudentFeignClient studentFeignClient) {
        this.studentFeignClient = studentFeignClient;
    }

    @CircuitBreaker(name = "studentService", fallbackMethod = "getStudentByIdFallbackMethod")
    public Object getStudentById(final HttpHeaders headers, final int id) {
        logger.info("Student feign client to get student data");
        return studentFeignClient.getStudentById(headers, id).getData().get("student");
    }

    public Object getStudentByIdFallbackMethod(final HttpHeaders headers, final int id, final Throwable th) {
        logger.error("Failed to get student details", th);
        return "Student details not found for student with id.. " + id + " No response from student server";
    }


}
```
Notice `getStudentById` method which is calling `FeignClient.`

<b>Step 4:</b> Implement your feign client with `@RequestHeader`
See the [Sample](../school-library/src/main/java/com/school/management/library/feign/client/StudentFeignClient.java) below


```java
@FeignClient(value = "api-gateway", path = "student-service/api/students/")
public interface StudentFeignClient {

    @GetMapping("/{id}")
    ApiResponse<Map<String,Object>> getStudentById(@RequestHeader HttpHeaders headers, @PathVariable int id);

}
```

### Happy coding