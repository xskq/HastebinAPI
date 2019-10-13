# HastebinAPI
A hastebin.com API for Java

# Usage

```java 
HastebinAPI haste = new HastebinAPI();
String message = "Hello world";
try {
    System.out.println(haste.upload(message));
} catch (IOException e) {
    e.printStackTrace();
}
```