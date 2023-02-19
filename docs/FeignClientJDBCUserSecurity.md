## Feign client authorization header using JDBC username and password
Some springboot microservice application using Database to save username and password.
<br><br> [See my gateway code to fetch the username and password](../security/jdbc-user-security/src/main/java/com/school/management/service/UserDetailsService.java)
<br>

[See my gateway code to authenticate the username and password](../security/jdbc-user-security/src/main/java/com/school/management/config/JdbcUserSecurityAdapter.java)
<br><br>Many of these application struggle to call feign client to get data. Because your feign client may be under authorization protection.

So the question comes here, how to pass the authorization header to feign client to get the data?

Based on my research I come up with few solution for this problem. Please note the below points

1. [Passing Headers to Feign Client](FeignClientJDBCUserSecurityS1.md)
2. [Use RequestInterceptor](FeignClientJDBCUserSecurityS2.md)

