Spring AOP examples (AspectJ)
=

## Disclaimers

This project is using plain Spring Framework without Spring Boot **intentionally**.

## Technical information

| Piece of tech | Version |
|---------------|---------|
| Java          | 17      |
| Spring        | 6.0.x   |
| AspectJ       | 1.9.x   |
| Tomcat        | 10.0.x  |
| Wildfly       | 27.0.x  |

Spring 6 works Tomcat 10+ and with Wildfly 27+.

Spring 5 can only work with Tomcat 9 (and prior) or Wildfly 26 (and prior).

## Deploy

Examples were tested with Tomcat 10.0.xx, 10.1.xx and Wildfly 27.0.1.

### Tomcat

If you've installed Tomcat via SdkMan and observing `permission denied` error during Tomcat launch attempt,
check the permissions on catalina.sh script.

```
-rw-r--r-- 1 starichkov starichkov  23445 May  9 14:30 catalina.sh 
```

With SdkMan you must make this script executable yourself:

```shell
chmod u+x ./catalina.sh
```

```
-rwxr--r-- 1 starichkov starichkov  23445 May  9 14:30 catalina.sh
```

## Endpoints

After deployment, under ```http://localhost:8080/spring-aop-examples``` base URL following GET-endpoints will be available:
* /afterReturning?id=100500
* /afterThrowing
* /afterThrowingNone
* /around
* /around/777
