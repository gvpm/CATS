mkdir $2
cp CATS.jar $2 
cp -R lib $2
cd $2
chmod +x CATS.jar
echo Pasta Criada
nohup java -jar CATS.jar 'json' $1 > $2.log &
echo Simulação Rodando em Background
sleep 2
rm -rf lib/
rm CATS.jar

