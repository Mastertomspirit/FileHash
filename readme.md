# FileHash

A very small App for checking the file hash code with an given String

From MD5 till SHA3-512

### Build a native image:


```
jlink --module-path "%JAVA_HOME%\jmods" --add-modules java.desktop --compress=2 --output customjre

jpackage.exe -t app-image --main-jar FileHash-1.0.2.jar -n FileHash --verbose -i D:\fileDir --runtime-image D:\customjre\
```

or

``` 
jpackage.exe -t app-image --main-jar FileHash-1.0.2.jar -n FileHash --verbose -i D:\fileDir  
```