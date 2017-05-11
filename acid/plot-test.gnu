reset
set grid
#set ytic 0.1
#set xtic 0.1
set yrange[0:60000]
set xrange[0:60000]
set xlabel "Density"
set ylabel "Accident Probability"
 

plot "naschp30-acid.txt" using 2:4 title "Nasch p=0.30" with points pointtype 1 


set terminal pdf color 

set out "test.pdf"
replot

set terminal postscript eps color lw 2 "Helvetica" 20

set out "test.eps"
replot



