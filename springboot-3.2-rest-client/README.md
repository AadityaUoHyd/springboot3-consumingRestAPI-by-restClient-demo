# springboot-3.2-rest-client

Note that as of Spring 6.1, in comparison to RestTemplate, the RestClient offers a more modern API 
for synchronous HTTP access. RestTemplate, added in Spring 3, is a bloated class exposing every 
capability of HTTP in a template-like class with too many overloaded methods.

The WebClient also supports synchronous HTTP access, but it required an additional dependency 
"spring-boot-starter-webflux". We can avoid adding a new dependency in the project by adding RestClient.

# Source to learn :
- https://spring.io/blog/2023/07/13/new-in-spring-6-1-restclient 
- https://howtodoinjava.com/spring/spring-restclient/ 