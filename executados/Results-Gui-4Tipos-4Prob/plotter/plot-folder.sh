#!/bin/bash
replacer= ' '
#array with all the files
files=$( ls * )
for i in $files ; do
#filters the files, removing the ones with plot inside
	if [[ $i != *"plot"* ]]; then
 		finalName="${i/.txt/$replacer}"
 		./plot.sh $finalName
	fi
done




