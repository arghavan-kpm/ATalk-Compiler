export CLASSPATH=".:/usr/local/lib/antlr-4.7-complete.jar:$CLASSPATH"
rm *.class
rm *.tokens
rm Atalk*.java
java -jar /usr/local/lib/antlr-4.7-complete.jar Atalk.g4
javac *.java
java org.antlr.v4.gui.TestRig Atalk program -gui < ../antler_sample/4.atk