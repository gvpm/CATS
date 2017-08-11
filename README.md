<img src="img/frontCat.png" alt="Cat" width="200"/>



# CATS - Cellular Automata Traffic Simulator
A program that allows the implementation and simulation of various cellular automata traffic simulation models.

The initial development of this program can be found here: https://github.com/gvpm/TUFFEngine

This is a Netbeans project.


## The Simulation.

  The whole simulation is actually a set of many smaller simulations. The program will do one simulation for each density you need to run.
  
  You can set the densities you want to run using 3 parameters in the configuration file.
  
  The simulation will run from **INITIALDENSITY** to **FINALDENSITY** and will jump **DELTADENSITY** between the densities.
  
  Eg: **INITIALDENSITY=0.05**  **FINALDENSITY=0.90**  **DELTADENSITY=0.01** 
  
  It will simulate the dentities 0.05, 0.06, 0.07 ... 0.50, 0.51, 0.52 ... 0.89, 0.90

## Running the Simulation.
If you just want to run the simulation you only need what is inside the **CATSRun** folder.
There you will find the following:
- The "CAT.jar": The program itself.
- The folder "configs": Is has a set of .txt configs.
  A file on this model is required to run the simulation on txt mode.
  
There are 3 ways of running the simulation via prompt.
  
- #### TXT Loader Mode:

   Syntax:

   `java -jar CATS.jar txt <yourConfigFileName.txt>"`	

   Be sure to have the configuration file on the same folder.
   
   Running the txt mode with no input parameter will run the 'simulation.txt'

   `java -jar CATS.jar txt`
   
   The file you pick should be in the same folder.

- #### JSON Loader Mode:

   Syntax:

   `java -jar CATS.jar json <oneLineJsonString>"`	

   To run the program using a Json Configuration you need put all the json in a continuous one line String.

   You can use this website to edit and compact your json: http://jsoneditoronline.org/

   Here is an example of a json configuration.


{
  "simulationParameters": {
    "speedLimit": 25,
    "probP": 30,
    "simulationTime": 15000,
    "discardTime": 10000,
    "statisticTime": 121,
    "initialDensity": 0.01,
    "deltaDensity": 0.01,
    "finalDensity": 0.9,
    "cellsInX": 10000,
    "cellsInY": 1,
    "cellSize": 1.5,
    "defaultCarSize": 7.5,
    "model": "nasch",
    "logName": "naschp30",
    "pictureLog": "0",
    "acidLog": 1,
    "velLog": "0"
  },
  "profiles":[{
    "fdpProviderString": "uniform",
    "name": "NaschBasic",
    "size": 5,
    "velMax": 25,
    "ahead": 0,
    "safeDistance": 0,
    "velIncrement": 5,
    "percentageOccurrence": 1,
    "alphaAcc": 8,
    "betaAcc": 4,
    "alphaAnt": 8,
    "betaAnt": 4
  }
  ]
}


- #### RedisSubscriber Mode:

   Will be documented after test phase.

## The Output.
When you run the simulation, it will generate output files.
There are 2 types of logs.
- #### The Main Log
  The main log will be created in all simulations and its name can be set in the **LOGNAME** parameter in the configuration file. eg: `LOGNAME: plotar`
  
  Each line of the log shows statistic information for some time(step) in the simulation, each information is separated by a space.
  
  Those are the parameters you will find in all the lines:
  
   1. Flow
   2. Density
   3. Average Velocity
  
   The steps there are logged are defined by some parameters in the configuration following this rules.
  
   When the step of the simulation is equal to **DISCARDTIME** it will trigger a counter that will increase 1 in each step.
  
   When the counter is equal to **STATISTICTIME** a line will be logged and the counter will be restarted.
   
   This will happen until the end of the **SIMULATIONTIME**
  
 - #### The Picture Log
 
    The idea of this log is that it takes a screenshot of the road in each step of the simulation.
    
    It will create a .txt file for each density simulated, the name will be the density value.

    Each line will have a byte for all the cells in the grid. The byte will be set as **1** if the cell is occupied and **0** if the cell is not occupied.
    
    To turn it on you need to set the **PICTURELOG** parameter in the configuration file to 1. Keep it 0 if you don't need this log.
    
    **WARNING** This is a dangerous log. For example, if your **SIMULATIONTIME** is set to 15000 it will generate a 150mb .txt file for each density simulated.
    
## The Configuration File.
  Use the program Notepad++ to open the configuration file if you have problems using it on the standard notepad.
  
  https://notepad-plus-plus.org/
  
  In the standard notepad is usually badly formated.


  More information about each parameter soon...
  
## The Implemented Models.
- #### Nasch With Beta
  ```java
  //This will be applied to every car in each step of the simulation.
  //Here the space between the current car and the car in front of it is calculated.
  
  distanceToFront = vehicle.getDistanceToFrontAndId()[0];
  
  //Here the alpha is calculated, is a number between 0 and 1, it is given by the beta function.
  
  float alpha = vehicle.getBetaFunctionAcc();
  
  //The rounded version of the alpha is calculated.
  
  float roundA = (float) (Math.round(alpha * 100.0) / 100.0);
  
  //The acceleration is calculated based on the alpha
  //The acceleration set in the cars profile is multiplied by a number between 0 and 1.

  int calculatedAcceletarion = (int) (acceleration * (1 - roundA));

  //New Velocity is calculated.
  //This new value is added to the current velocity of the car.
  //There is a cap so that this new value will not be higher than the maximum velocity of the road.

  newVel = min((currentVel + calculatedAcceletarion), vMax);

  //Uses the Uniform FDP to decide if its going to use the calculated acceletarion or not.
  //Subtracts the acceletation with a probP chance of happening. probP is defined in the config file.

  if (vehicle.getCore().provideGeneralFDPUniform()) {
    newVel = max(newVel - calculatedAcceletarion, 0);
  }
      
  //Caps the new velocity based on the distance to the vehicle on the front
  
  newVel = min(newVel, distanceToFront);

  //Sets the vehicle new velocity.
  
  vehicle.setNewVelocity(newVel);
  ```
  
  
  
  This project was made with the support of CNPq, Conselho Nacional
de Desenvolvimento Científico e Tecnológico - Brazil. 


