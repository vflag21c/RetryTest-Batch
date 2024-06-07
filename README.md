> Entity 객체의 하기 코드를 추가하게 될 경우 Writer의 Exception 으로 인한  Retry 발생 시, processor의 무한루프가 발생함

```java
@EqualsAndHashCode(callSuper = false)
```