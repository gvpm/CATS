reset
set grid
#set ytic 0.1
#set xtic 0.1
set xrange[0:2500]
set xlabel "Flow"
set yrange[0:150]
set ylabel "AvgVel km/h"
 
#plot filename.txt using ($1):($3) w p t "Fluxo Densidade"
plot "a4b8p30v15.txt" using 1:3 title "a4b8p30v15" with points pointtype 7 pointsize 0.1 , \
     "a4b8p30v20.txt" using 1:3 title "a4b8p30v20" with points pointtype 7 pointsize 0.1 , \
     "a4b8p30v25.txt" using 1:3 title "a4b8p30v25" with points pointtype 7 pointsize 0.1


set terminal pdf color 

set out "sobre-diffVels-a4b8p30-fv.pdf"
replot

set terminal postscript eps color lw 2 "Helvetica" 20

set out "sobre-diffVels-a4b8p30-fv.eps"
replot



