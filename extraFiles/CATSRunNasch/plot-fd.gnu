reset
pdfName = sprintf("%s-fd.pdf",filename)
epsName = sprintf("%s-fd.eps",filename)
txt = ".txt"
set grid
#set ytic 0.1
#set xtic 0.1
set yrange[0:2500]
set xrange[0:100]
set xlabel "Density"
set ylabel "Flow"
 
plot filename.txt using ($2):($1) w p t "Fluxo Densidade"

set terminal pdf color 

set out pdfName
replot

set terminal postscript eps color lw 2 "Helvetica" 20

set out epsName
replot



