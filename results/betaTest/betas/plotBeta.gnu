reset
set grid
#set ytic 0.1
#set xtic 0.1
set yrange[0:8]
set xrange[0:1]
#set xlabel "x"
#set ylabel "f(x)"
 

plot "BetaTest10-30.txt" using 1:2 title "B(10;30)" with lines , \
     "BetaTest20-28.txt" using 1:2 title "B(20;28)" with lines , \
     "BetaTest28-20.txt" using 1:2 title "B(28;20)" with lines , \
     "BetaTest30-10.txt" using 1:2 title "B(30;10)" with lines 


set terminal pdf color 

set out "allbetas.pdf"
replot

set terminal postscript eps color solid lw 2 "Helvetica" 20

set out "allbetas.eps"
replot



