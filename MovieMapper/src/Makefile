backEnd.class: backEnd.java
    javac -d . backEnd.java

Main.class: Main.java backEnd.java
	javac -d . dataWrangler.java	
	javac -d . backEnd.java
	javac -d . Main.java

runBack: backEnd.class
    java movieMapper.backEnd

runMain: Main.class
	java movieMapper.Main 
