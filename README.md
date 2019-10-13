# HastebinAPI
A simple hastebin.com API for Java

# Releases
Latest release: [Download](https://github.com/xskq/HastebinAPI/releases/latest)

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
