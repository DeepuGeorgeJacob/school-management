# RequestInterceptor to add header to feign request

<b>Step 1 : </b> Create a subclass of `RequestInterceptor` and configure method like below.
<br>
```java
@Component
public class AuthFeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        final RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            final HttpServletRequest httpServletRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
            template.header(HttpHeaders.AUTHORIZATION, httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION));
        }
    }
}
```

<b>Step 2 <b> : You are done. No other changes required in your feign client. Make sure you are successfully configured the `FeignClient`, like below

```java
@FeignClient(value = "api-gateway", path = "student-service/api/students/")
public interface StudentFeignClient {

    @GetMapping("/{id}")
    ApiResponse<Map<String,Object>> getStudentById(@PathVariable int id);

}
```

## Happy coding contact [me](https://www.linkedin.com/in/deepu-george-jacob-76753358/) if you are facing any issues.

