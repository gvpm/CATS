reset
set grid
#set ytic 0.1
#set xtic 0.1
set yrange[0:150]
set xrange[10000:10500]
set xlabel "Time"
set ylabel "Velocity"
 

plot "a10b30p30-velLog-d0.15.txt" using 2:3 title "B(10;30)" with lines linecolor rgb "red"


set terminal pdf color 

set out "a10b30-d15.pdf"
replot

set terminal postscript eps color lw 2 "Helvetica" 20

set out "a10b30-d15.eps"
replot



