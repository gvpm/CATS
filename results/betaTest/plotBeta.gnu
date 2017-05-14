reset
set grid
#set ytic 0.1
#set xtic 0.1
set yrange[0:10]
set xrange[0:1]
set xlabel "x"
set ylabel "f(x)"
 

plot "BetaTest.txt" using 1:2 title "8-4" with lines


set terminal pdf color 

set out "8-4.pdf"
replot

set terminal postscript eps color lw 2 "Helvetica" 20

set out "8-4.eps"
replot



