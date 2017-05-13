reset

set grid
#set ytic 0.1
#set xtic 0.1
set yrange[0:250]
set xrange[10000:10500]
set xlabel "TimeElapsed"
set ylabel "AvgVel km/h"
 
plot "naschp30-velLog-d0.3.txt" using ($2):($3) with points pointtype 7 pointsize 0.2 t "Velocidade/Tempo"

set terminal pdf color 

set out "naschp30-velLog-d0.3.pdf"
replot

set terminal postscript eps color lw 2 "Helvetica" 20

set out "naschp30-velLog-d0.3.eps"
replot



