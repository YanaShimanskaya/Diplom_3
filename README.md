# Diplom_3
Третья часть дипломного проекта. В проекте использовались:
java version "1.8.0_311", JUnit 4.13.1, selenium 4.9.0, rest-assured 4.4.0, allure 2.15, maven 3.10.1

```java
mvn clean test
mvn test
mvn -Dwebdriver.chrome.driver=/opt/chromedriver/chromedriver \
    -Dwebdriver.chrome.binary=/opt/chrome-for-testing/chrome \
    -Dwebdriver.yandex.driver=/opt/chromedriver/chromedriver-116 \
    -Dwebdriver.yandex.binary=/usr/bin/yandex-browser \
    -Dbrowser=yandex test