reset
set grid
#set ytic 0.1
#set xtic 0.1
set yrange[0:0.04]
set xrange[0:100]
set xlabel "Density"
set ylabel "Probability of Dangerous Situation (Pds)"
 

plot "naschp30-acid.txt" using 1:9 title "NaSch" with lines linecolor rgb "red", \
     "a10b30p30-acid.txt" using 1:9 title "B(10;30)" with lines linecolor rgb "blue", \
     "a30b10p30-acid.txt" using 1:9 title "B(30;10)" with lines linecolor rgb "#006400"


set terminal pdf color 

set out "AcidPAC-allp30.pdf"
replot

set terminal postscript eps color lw 2 "Helvetica" 20

set out "AcidPAC-allp30.eps"
replot



