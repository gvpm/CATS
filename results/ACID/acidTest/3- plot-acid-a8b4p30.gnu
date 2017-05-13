reset
set grid
#set ytic 0.1
#set xtic 0.1
set yrange[0:0.03]
set xrange[0:100]
set xlabel "Density"
set ylabel "Accident Probability"
 

plot "a8b4p30-ac-acid.txt" using 1:8 title "a8b4p30 p=0.30" with points pointtype 1 


set terminal pdf color 

set out "a8b4p30-pac-d.pdf"
replot

set terminal postscript eps color lw 2 "Helvetica" 20

set out "a8b4p30-pac-d.eps"
replot


