# RES_Labo3

## project description
This project is an SMTP mail prank generator. You can configure it easily to send mail pranks to your friend. It's ready to use, and fast to configure. It provides also a mock server to do some hidden test befor sending the real prank.

## how to configure the mock server with docker

To configure the mock server first, run the docker quickstart terminal. Then move to our project folder named "MockServer". You can use cd path to reach it fastly. Once you are in the correct folder, just run those two command line :
![GitHub Logo](https://github.com/jimmyVerdasca/RES_Labo3/blob/master/figures/dockerBuild.PNG)

![GitHub Logo](https://github.com/jimmyVerdasca/RES_Labo3/blob/master/figures/dockerRun.PNG)

There you are ready! your mock server is running in a docker container. you can go in your favorite browser and search 192.168.99.100:8080
You will find an empty mail queue as followed : 

![GitHub Logo](https://github.com/jimmyVerdasca/RES_Labo3/blob/master/figures/mockstarted.PNG)

you can now for example send a mail in SMTP command line :

first run a command line then write :
telnet 192.168.99.100 25000
now you are connected to the mock server, you can begin to write the smtp protocol. You can see a full mail sending in the following image.

![GitHub Logo](https://github.com/jimmyVerdasca/RES_Labo3/blob/master/figures/exampleOfSMTP.png)

## how to configure and run the project
If you ant to run the project, you just need to provide 2 to 4 arguments to launch the .jar. In the order you the parameters are :
the number of groups of victims we want
the homogeneous size of this groups

and if you want, you can also provide:
the ipadress where you want to connect
the port you want to connect

My advice is to provide only 2 arguments while testing by with mock (the project is configured to run for it). And once you are ready use the 4 argument to send the real prank.

## implementations choices
There is a picture with the class flow (carefull it don't pretend to be an UML!)

![GitHub Logo](https://github.com/jimmyVerdasca/RES_Labo3/blob/master/figures/classBuilt.png)

the bottom line represent the dataFiles that you can configure. You just need to keep the same structure.

### structure of mail.txt
for this file you just need to provide one mail by line. We considere that a mail follow this structure : firstname.lastname@whatever.
The loader of mail can be codly configured to read an other name separator than '.'.

### structure of pranks.txt
This File is more complexe but still simple to write by yourself. you need to write as first line Subject: followed by the subject of the prank that you want to see appear in the futur mail. Then you can write the body of the prank. Once you considere that the body Is complete just add a finish-line ====. You can reapeat this algorithme as much as you want in the file.

finally you can modify the Constants.java file if you want to change some default behaviours.

All this files are red by the loaders class to build proper group of victim and allow the client to finally send the pranks to this groups.
