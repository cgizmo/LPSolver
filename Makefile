all:
	mkdir -p bin
	chmod +x toto
	chmod +x totoopt
	chmod +x totoprint
	javac -cp .:antlr-4.5-complete.jar  -d bin src/fr/enslyon/Main.java -sourcepath src

