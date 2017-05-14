reset
set grid
#set ytic 0.1
#set xtic 0.1
set yrange[0:0.05]
set xrange[0:100]
set xlabel "Density"
set ylabel "Accident Probability"
 

plot "a4b4TESTENASCH-acid.txt" using 1:8 title "naschGambiarra p=0.30" with points pointtype 1


set terminal pdf color 

set out "naschGambiarra.pdf"
replot

set terminal postscript eps color lw 2 "Helvetica" 20

set out "naschGambiarra.eps"
replot



