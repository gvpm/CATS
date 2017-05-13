reset
set grid
#set ytic 0.1
#set xtic 0.1
set yrange[0:2500]
set xrange[0:100]
set xlabel "Density"
set ylabel "Flow"
 
#plot filename.txt using ($2):($1) w p t "Fluxo Densidade"
plot "naschp1.txt" using 2:1 title "naschp1" with points pointtype 7 pointsize 0.1 , \
     "naschp10.txt" using 2:1 title "naschp10" with points pointtype 7 pointsize 0.1 , \
     "naschp30.txt" using 2:1 title "naschp30" with points pointtype 7 pointsize 0.1, \
     "naschp70.txt" using 2:1 title "naschp70" with points pointtype 7 pointsize 0.1


set terminal pdf color 

set out "sobrepostoNaschAll-fd.pdf"
replot

set terminal postscript eps color lw 2 "Helvetica" 20

set out "sobrepostoNaschAll-fd.eps"
replot



