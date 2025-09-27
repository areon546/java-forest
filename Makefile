build:
	# compile all into /bin 
	cd src && javac ForestGame.java -d ../bin 
	# run binary
	cd bin && java ForestGame
