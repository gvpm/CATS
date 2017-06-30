mkdir $2
cp CATS.jar $2 
cp -R lib $2
cd $2
chmod +x CATS.jar
echo Folder created.
nohup java -jar CATS.jar 'json' $1 > simulation.log &
echo Simulation running on background.
echo The "simulation.log" will be inside the created folder.
sleep 2
rm -rf lib/
rm CATS.jar

