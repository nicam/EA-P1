EA-P1
=====

<img src="https://photos-4.dropbox.com/t/0/AADUZHfZCr7BJ9xY54iu02iVZfIG6roqXDkQjH7n-5OnbQ/12/419439/png/1024x768/3/1411308000/0/2/Screenshot%202014-09-21%2014.43.53.png/ZSwmH8JpxQIgUkIW0D8Hjcks_ZMc5sPFq-vIvEwypBY">

Praktikum 1 Coffee Server

#Build
Create new Project from sources and build using Netbeans

#Run it

##1. Start RMI

    cd NetBeansProjects/P1/build/classes 
    rmic coffee.CoffeeCashRegister
    rmirmiregistry

##2. Start Server
    cd NetBeansProjects/P1/build/classes
    java -Djava.security.policy=coffee/wideopen.policy coffee/CoffeeCashRegister
  
##3. Start Client
    cd NetBeansProjects/P1/build/classes
    java -Djava.security.policy=wideopen.policy coffee/Gui
  
