javac src/**/*.java
cd src
java app.Main ../$1
rm -r **/*.class