export CLASSPATH=".:/usr/local/lib/antlr-4.7-complete.jar:$CLASSPATH"
rm *.class
rm *.tokens
rm AtalkPass1*.java
rm AtalkPass2*.java
java -jar /usr/local/lib/antlr-4.7-complete.jar AtalkPass1.g4
java -jar /usr/local/lib/antlr-4.7-complete.jar AtalkPass2.g4
javac *.java
java Atalk ./antler_sample/4.atk
