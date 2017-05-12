reset
set grid
#set ytic 0.1
#set xtic 0.1
set yrange[0:0.07]
set xrange[0:100]
set xlabel "Density"
set ylabel "Accident Probability"
 

plot "naschp30-acid.txt" using 1:10 title "Nasch p=0.30" with points pointtype 1 


set terminal pdf color 

set out "nasch30-pac-d-norm.pdf"
replot

set terminal postscript eps color lw 2 "Helvetica" 20

set out "nasch30-pac-d-norm.eps"
replot



