reset
set grid
#set ytic 0.1
#set xtic 0.1
set yrange[0:150]
set xrange[0:100]
set xlabel "Density"
set ylabel "AvgVel km/h"
 

plot "naschp30.txt" using 2:3 title "naschp30" with points pointtype 1 , \
     "a1b6p30.txt" using 2:3 title "a1b6p30" with points pointtype 1 , \
     "a4b8p30.txt" using 2:3 title "a4b8p30" with points pointtype 1 , \
     "a4b4p30.txt" using 2:3 title "a4b4p30" with points pointtype 1 , \
     "a8b4p30.txt" using 2:3 title "a8b4p30" with points pointtype 1 


set terminal pdf color 

set out "sobreposto30gui-vd.pdf"
replot

set terminal postscript eps color lw 2 "Helvetica" 20

set out "sobreposto30gui-vd.eps"
replot



