reset
pdfName = sprintf("%s-vd.pdf",filename)
epsName = sprintf("%s-vd.eps",filename)
txt = ".txt"
set grid
#set ytic 0.1
#set xtic 0.1
set yrange[0:150]
set xrange[0:100]
set xlabel "Density"
set ylabel "AvgVel km/h"
 
plot filename.txt using ($2):($3) with points pointtype 7 pointsize 0.1 t "Velocidade/Densidade"

set terminal pdf color 

set out pdfName
replot

set terminal postscript eps color lw 2 "Helvetica" 20

set out epsName
replot



