# wise-java-sdk
Wise.com Java SDK based on their publicly available Postman collection: https://api-docs.transferwise.com/

## Instructions
This reactive SDK was generated using openapi-generator-maven-plugin and Spring's reactive WebClient. If you wish to use the Spring beans that were created in this library, add "com.wise.sdk" to your component scan or add an @Import(WiseSdkConfiguration.class).

Spring expects 2 properties:

<pre>
wise.url=https://api.sandbox.transferwise.tech
wise.api.key=YOUR_API_KEY
</pre>

You can get the wise.url for free by adding one of our properties files to your property sources and add a Spring active profile to either wise-sandbox or wise-production.

If you are using Spring, you can inject the available Spring-managed Wise-beans that are in WiseSdkConfiguration.

If you are not using Spring, you will have to instantiate the Api classes manually and configure the url and api key manually. See WiseSdkConfiguration for inspiration on how you can do that.

## Install
Grab library from Maven repo

~~~ xml
<dependency>
    <groupId>travel.wink</groupId>
    <artifactId>wise-sdk-java</artifactId>
    <version>{{ VERSION }}</version>
</dependency>
~~~

## Development
Generate library
`mvn clean compile`

Test library
`mvn clean test`
