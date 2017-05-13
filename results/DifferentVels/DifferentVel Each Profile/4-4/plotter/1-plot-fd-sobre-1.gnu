reset
set grid
#set ytic 0.1
#set xtic 0.1
set yrange[0:2500]
set xrange[0:100]
set xlabel "Density"
set ylabel "Flow"
 
#plot filename.txt using ($2):($1) w p t "Fluxo Densidade"
plot "a4b4p1v15.txt" using 2:1 title "a4b4p1v15" with points pointtype 7 pointsize 0.1 , \
     "a4b4p1v20.txt" using 2:1 title "a4b4p1v20" with points pointtype 7 pointsize 0.1 , \
     "a4b4p1v25.txt" using 2:1 title "a4b4p1v25" with points pointtype 7 pointsize 0.1


set terminal pdf color 

set out "sobre-diffVels-a4b4p1-fd.pdf"
replot

set terminal postscript eps color lw 2 "Helvetica" 20

set out "sobre-diffVels-a4b4p1-fd.eps"
replot



