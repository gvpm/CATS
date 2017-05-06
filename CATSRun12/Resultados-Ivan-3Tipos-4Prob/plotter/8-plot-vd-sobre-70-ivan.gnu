reset
set grid
#set ytic 0.1
#set xtic 0.1
set yrange[0:150]
set xrange[0:100]
set xlabel "Density"
set ylabel "AvgVel km/h"
 
#plot filename.txt using ($2):($1) w p t "Fluxo Densidade"
plot "naschp70.txt" using 2:3 title "naschp70" with points pointtype 1 , \
     "-a1b6p70.txt" using 2:1 title "a1b6p70" with points pointtype 1 , \
     "-a4b8p70.txt" using 2:1 title "a4b8p70" with points pointtype 1 , \
     "-a8b4p70.txt" using 2:1 title "a8b4p70" with points pointtype 1 


set terminal pdf color 

set out "sobreposto70ivan-vd.pdf"
replot

set terminal postscript eps color lw 2 "Helvetica" 20

set out "sobreposto70ivan-vd.eps"
replot



