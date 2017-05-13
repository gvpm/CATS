reset
set grid
#set ytic 0.1
#set xtic 0.1
set yrange[0:150]
set xrange[0:100]
set xlabel "Density"
set ylabel "AvgVel km/h"

 
#plot filename.txt using ($2):($3) w p t "Fluxo Densidade"
plot "a4b8p30v15.txt" using 2:3 title "a4b8p30v15" with points pointtype 7 pointsize 0.1 , \
     "a4b8p30v20.txt" using 2:3 title "a4b8p30v20" with points pointtype 7 pointsize 0.1 , \
     "a4b8p30v25.txt" using 2:3 title "a4b8p30v25" with points pointtype 7 pointsize 0.1

set terminal pdf color 

set out "sobre-diffVels-a4b8p30-vd.pdf"
replot

set terminal postscript eps color lw 2 "Helvetica" 20

set out "sobre-diffVels-a4b8p30-vd.eps"
replot



