reset
set grid
#set ytic 0.1
#set xtic 0.1
set yrange[0:16]
set xrange[0:1]
set xlabel "x"
set ylabel "f(x)"
 

plot "BetaTest1-70.txt" using 1:2 title "1-40" with lines


set terminal pdf color 

set out "1-70.pdf"
replot

set terminal postscript eps color lw 2 "Helvetica" 20

set out "1-70.eps"
replot



